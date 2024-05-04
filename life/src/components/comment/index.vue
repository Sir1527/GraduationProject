<template>
  <div>
    <div class="card" style="margin: 10px 0">
      <div style="font-size: 20px; font-weight: bold; margin-bottom: 15px">评论 {{ commentCount }}</div>
      <div style="margin-bottom: 20px">
        <a-input type="textarea" placeholder="请输入评论内容" v-model="form.content"></a-input>
        <div style="margin-top: 5px; text-align: right">
          <a-button type="primary" @click="addComment(null)">评论</a-button>
        </div>
      </div>

      <div>
        <div v-for="item in commentList" :key="item.id" style="display: flex; grid-gap: 15px; margin-bottom: 20px">
          <a-image :src="item.avatar" alt="" fit="cover" width="50px" height="50px" style="border-radius: 50%"></a-image>
          <div style="flex: 1;">
            <div style="margin-bottom: 5px; color: #666">{{ item.userName }}</div>
            <div style="margin-bottom: 5px">{{ item.content }}</div>
            <div style="font-size: 13px; color: #666; margin-bottom: 10px">
              <span>{{ item.time }}</span>
              <span style="margin: 0 20px; cursor: pointer" @click="handleReply(item)" :class="{ 'highLight' : item.showReply }">
                <i><icon-message /></i>回复
              </span>
              <span style="cursor: pointer" @click="del(item.id)" v-if="true">
                <i><icon-close-circle /></i>删除
              </span>
            </div>
            <div style="margin-bottom: 10px" v-if="item.showReply">
              <a-input v-model="item.reply" placeholder="请输入回复内容"></a-input>
              <div style="margin-top: 5px; text-align: right">
                <a-button @click="addComment(item)">回复</a-button>
              </div>
            </div>

            <div v-if="item.children.length">
              <div v-for="sub in item.children" :key="sub.id" style="display: flex; grid-gap: 15px; margin-bottom: 10px">
                <a-image :src="item.avatar" alt="" fit="cover" width="50px" height="50px" style=" border-radius: 50%"></a-image>
                <div style="flex: 1;">
                  <div style="margin-bottom: 5px; color: #666">{{ sub.userName }}  <span v-if="sub.replyUser && sub.replyUser !== item.userName">回复 {{ sub.replyUser }}</span></div>
                  <div style="margin-bottom: 5px">{{ sub.content }}</div>
                  <div style="font-size: 13px; color: #666; margin-bottom: 10px">
                    <span>{{ sub.time }}</span>
                    <span style="margin: 0 20px; cursor: pointer" @click="handleReply(sub)" :class="{ 'highLight' : sub.showReply }">
                      <i><icon-message /></i>回复
                    </span>
                    <span style="cursor: pointer" @click="del(sub.id)" v-if="userId == sub.userId">
                      <i><icon-close-circle /></i>删除
                    </span>
                  </div>
                  <div style="margin-bottom: 10px" v-if="sub.showReply">
                     <a-input type="textarea" v-model="sub.reply" placeholder="请输入回复内容"></a-input>
                    <div style="margin-top: 5px; text-align: right">
                      <a-button type="primary" size="mini" @click="addComment(sub)">回复</a-button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import request from "@/utils/http";
import {onMounted, reactive, ref} from "vue";
import type {comment, respCommentCount, respCommentList} from "@/api/comment/type";
import {getUserId} from "@/utils/auth";

interface Props {
  fid?: string,
  module?: string,
}
const props = defineProps<Props>()
const fid = props.fid;
const module = props.module;

const form:comment = reactive({});
const userId = getUserId();

const del = (id: number) => {
  request.delete<any,respCommentCount>('comment/deepDelete/' + id).then(res => {
    if (res.code === '200') {
      alert('操作成功')
      loadComment();
    }else {
      alert('操作失败')
    }
  })
}

const addComment = (pComment: comment | null) => {
    form.module = module;
    form.fid = fid;
    form.userId = userId;
    if (pComment) {
        form.pid = pComment.id;
        form.content = pComment.reply;
    }
    request.post<any,respCommentCount>('/comment/add', form).then(res => {
      if (res.code === '200') {
        loadComment();
        form.module = ''
        form.id = ''
        form.userId = ''
        form.pid = ''
        form.replyUser = ''
        form.content = ''
      } else {
      }
  })
}

let commentList: any = ref<comment>()
let commentCount = ref(0)
const loadComment = () => {
    request.get<any,respCommentList>('/comment/selectTree/' + fid + '/'+ module).then(res => {
      commentList.value = res.data;
    })
    request.get('/comment/selectCount/' + fid + '/' + module).then(res => {
    commentCount.value = res.data || 0
  })
}
onMounted(() => loadComment())

const handleReply = (comment: any) => {
  comment.showReply = !comment.showReply;
}
</script>


<style scoped>
.highLight {
  color: #2A60C9;
}
</style>