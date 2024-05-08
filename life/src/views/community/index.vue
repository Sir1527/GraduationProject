<template>
  <div class="container">

    <div style="background-color: var(--color-bg-2);">
      <ul class="right-side" style="width: 100%">
        <li style="width: 100%">
          <a-menu mode="horizontal" :default-selected-keys="['0']">
          <a-menu-item key="0" @click="load(1)">全部</a-menu-item>
          <a-menu-item key="1" @click="loadCategory('交友')">交友</a-menu-item>
          <a-menu-item key="2" @click="loadCategory('问答')">问答</a-menu-item>
          <a-menu-item key="3" @click="loadCategory('围棋')">围棋</a-menu-item>
          <a-menu-item key="4" @click="loadCategory('象棋')">象棋</a-menu-item>
          <a-menu-item key="5" @click="loadCategory('骑行')">骑行</a-menu-item>
          <a-menu-item key="6" @click="loadCategory('养生')">养生</a-menu-item>
          <a-menu-item key="7" @click="loadCategory('麻将')">麻将</a-menu-item>
          </a-menu>
        </li>
        <li>
          <div>
            <a-button  shape="circle" :style="{float: 'right',marginRight: '10px'}" @click="handleClick">
              <icon-plus />
            </a-button>
          </div>
        </li>
      </ul>
    </div>
    <a-card :body-style = "{padding:'0 0 15px 0',}" :bordered="false">

      <a-list
          class="list-demo-action-layout"
          :bordered="false"
          :split=false
          v-for="item in postList" :key="item.id"
      >
        <a-list-item class="list-demo-item" action-layout="vertical"  @click="$router.push('/PostDetail?id=' + item.postId)">
            <template #actions>
              <span v-if="item.isLike == '已点赞'">
                <IconHeartFill :style="{ color: '#f53f3f' }" /> 已赞
              </span>
              <span v-else>
                <IconHeart /> 点赞
              </span>
              <span><icon-eye />{{ item.count }}</span>
            </template>
            <template #extra>
              <div className="image-area"  v-if="!(item.cover === '' || item.cover === null)">
                <img alt="arco-design" :src=item.cover />
              </div>
            </template>
            <a-list-item-meta
                :title=item.title
                :description=item.content
            >
              <template #avatar>
                  <a-avatar shape="square">
                    <img alt="avatar" :src=item.userAvatar />
                  </a-avatar>
              </template>
            </a-list-item-meta>
        </a-list-item>

      </a-list>
      <div style="width: 420px;margin: 30px auto">
        <a-pagination :total=page.total @change="handleCurrentChange" show-jumper/>
      </div>
    </a-card>
    <a-modal v-model:visible="visible" @ok="handleOk" @cancel="handleCancel">
      <template #title>
        发布新帖子
      </template>
      <a-form>
        标题：<br>
        <a-form-item field="username" :validate-trigger="['change', 'blur']" hide-label>
          <a-input placeholder="请输入帖子标题" v-model=form.title>
          </a-input>
        </a-form-item>
        类型：
        <a-select :style="{width:'320px'}" placeholder="请选择帖子类型" v-model="form.category">
          <a-option>交友</a-option>
          <a-option>问答</a-option>
          <a-option>围棋</a-option>
          <a-option>象棋</a-option>
          <a-option>骑行</a-option>
          <a-option>养生</a-option>
          <a-option>麻将</a-option>
        </a-select>
          内容：<br>
          <a-textarea placeholder="请输入类容" allow-clear :style="{height:'200px'}" v-model=form.content />
        上传图片：
        <a-upload draggable action="http://localhost:9090/files/upload" :headers="{ token: token }" @success="cover" />
      </a-form>
    </a-modal>
  </div>
</template>

<script setup lang="ts">

import {onMounted, reactive, ref} from "vue";
import {reqAddPost, reqPostListCategory, reqPostListPage} from "@/api/post/post";
import type {FormPost, post} from "@/api/post/type";
import {getToken, getUserAvatar, getUserId} from "@/utils/auth";
import {deleteLike, reqLikeAdd} from "@/api/like/like";
import {reqNewsCount} from "@/api/news/news";

const postList: post | any = ref<post>();
const page = reactive({
  pageNum: 1,
  pageSize: 5,
  total: 0,
  category: '',
})
const load = (pageNum: number) => {
  page.category = ''
  reqPostListPage(pageNum, page.pageSize,userId).then(res => {
    postList.value = res.data?.list;
    page.total = Number (res.data?.total);
    page.pageNum = Number (res.data?.pageNum);
    console.log(postList.value)
  })
}
onMounted( () => load(page.pageNum))
const loadCategory = (category: string | any) => {
  page.category = category;
  reqPostListCategory(page.pageNum,page.pageSize,category).then(res => {
    postList.value = res.data?.list;
    page.total = Number (res.data?.total);
  })
}

const handleCurrentChange = (num: number) => {
  if (page.category === ''){
    load(num)
  }else {
    page.pageNum = num;
    loadCategory(page.category)
  }
}

const visible = ref(false);
const userId: string | any = getUserId();
const userAvatar: string | any = getUserAvatar();
const token = getToken();
const form = reactive<FormPost>({});
const cover = (test: any) => {
  form.cover = test.response.data;
}
const handleClick = () => {
  visible.value = true;
};
const handleOk = () => {
  visible.value = false;
  form.userId = userId;
  form.userAvatar = userAvatar;
  reqAddPost(form);
  load(page.pageNum);
};
const handleCancel = () => {
  visible.value = false;
}

</script>

<style scoped lang="less">
.container {
  padding: 16px 20px;
  padding-bottom: 0;
}

.list-demo-action-layout .image-area {
  width: 183px;
  height: 119px;
  border-radius: 2px;
  overflow: hidden;
}

.list-demo-action-layout .list-demo-item {
  padding: 20px 0;
  border-bottom: 1px solid var(--color-fill-3);
}

.list-demo-action-layout .image-area img {
  width: 100%;
}

.list-demo-action-layout .arco-list-item-action .arco-icon {
  margin: 0 4px;
}

.right-side {
  display: flex;
  margin: 0;
  padding: 0;
  li {
    display: flex;
    align-items: center;
    padding: 0;
    margin: 0;
  }
}

li1 {
  max-width: 1100px;
}
</style>