<template>
  <div class="container">
    <a-card :bordered="false">
      <div class="main-content">
        <div style="margin-bottom: 20px; margin-top: 15px;font-size: 22px; font-weight: bold; text-align: left">
          <h2 style="margin-top: 0;margin-bottom: 5px">
            {{ post.title }}
          </h2>
        </div>

        <div style="color: #666; text-align: left">
          <span style="margin-right: 20px">发布者：{{ user.username }}</span>
          <span style="margin-right: 20px">发布时间：{{ post.createTime }}</span>
          <span>浏览量：<span style="color: red">{{ post.count }}</span></span>
        </div>
        <div>
          <div class="w-e-text" style="line-height: 26px; text-indent: 2rem;margin-top: 10px;font-size: 20px">
            <a-typography-paragraph>
              {{  post.content }}
            </a-typography-paragraph>
            <div  style="text-align: center" v-if=isCover>
              <a-image width="700px" :src=post.cover></a-image>
            </div>
          </div>
        </div>
      </div>
    </a-card>

    <a-card :bordered="false" style="margin-top: 15px">
      <components :fid=id module="post"></components>
    </a-card>

  </div>
</template>

<script setup lang="ts">
import {useRoute} from "vue-router";
import components from "@/components/comment/index.vue";
import {onMounted, reactive, ref} from "vue";
import type {post} from "@/api/post/type";
import {reqPost, reqPostCount} from "@/api/post/post";
import {reqUserById} from "@/api/user/user";
import type {UserData} from "@/api/user/type";

const route = useRoute();
const id: any = route.query.id;

const post: post = reactive({});
const isCover = ref(false)
const user: any = reactive<UserData>({});
const load = async () => {
  const res = await reqPost(id);
  post.postId = res.data?.postId;
  post.userId = res.data?.userId;
  post.userAvatar = res.data?.userAvatar;
  post.title = res.data?.title;
  post.cover = res.data?.cover;
  post.content = res.data?.content;
  post.category = res.data?.category;
  post.count = res.data?.count;
  post.createTime = res.data?.createTime;
  if (post.cover != null){
    isCover.value = true
  }
  await reqPostCount(id);
  const userData = await reqUserById(post.userId);
  user.username = userData.data?.username;
}
onMounted( () => load())

</script>

<style scoped lang="less">
.container {
  padding: 16px 0 20px 0;
}

.main-content {
  margin: 10px auto;
}
</style>