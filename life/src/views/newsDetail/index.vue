<template>

  <div class="container">
    <a-card :bordered="false">
      <div class="main-content">
        <div style="margin-bottom: 20px; font-size: 22px; font-weight: bold; text-align: center">
          <a-typography-title :heading="2" @click="reqNews">
           {{ news.title }}
          </a-typography-title>
        </div>

        <div style="color: #666; text-align: center">
          <span style="margin-right: 20px">发布时间：{{ news.time }}</span>
          <span style="margin-right: 20px">浏览量：<span style="color: red">{{ news.count }}</span></span>
          <span @click="onLikeChange">
            <span v-if="like" >
              <IconHeartFill :style="{ color: '#f53f3f' }" /> 已赞
            </span>
            <span v-else>
              <IconHeart /> 点赞
            </span>
          </span>
        </div>
        <div style="margin: 30px 0; padding: 0 20px">
          <div class="w-e-text" style="line-height: 26px; text-indent: 2rem">
            <div>
              <div v-html="news.content"></div>
            </div>
          </div>
        </div>
      </div>
    </a-card>

    <a-card :bordered="false" style="margin-top: 15px">
      <components :fid=id module="news"></components>
    </a-card>


  </div>

</template>

<script setup lang="ts">

import {onMounted, reactive, ref} from "vue";
import {getNews, reqNewsCount} from "@/api/news/news";
import {useRoute} from "vue-router";
import components from "@/components/comment/index.vue";
import type {newsData} from "@/api/news/type";
import {getUserId} from "@/utils/auth";
import {deleteLikeNews, reqLikeAdd} from "@/api/like/like";
import type {likeNewsAdd} from "@/api/like/type";

const route = useRoute();
const id: any = route.query.id;

const userId = getUserId();
const news:newsData = reactive({})
const like = ref(false);
const reqNews = async(id: number) => {
  updateCount();
  const res = await getNews(id,userId);
  news.id = res.data?.id;
  news.title = res.data?.title;
  news.time = res.data?.time;
  news.count = res.data?.count;
  news.content = res.data?.content;
  news.category = res.data?.category;
  news.likes = res.data?.likes;
  if (news.likes == '已点赞') {
    like.value = true;
  }else {
    like.value = false;
  }
}
onMounted(() => reqNews(id))

const form = reactive<likeNewsAdd>({});
form.userId = userId;
form.newsId = id;
const onLikeChange = () => {
  if (like.value == false) {
    console.log(form)
    reqLikeAdd(form).then(res => {
      console.log(res)
    })
  }else {
    deleteLikeNews(userId,id);
  }
  like.value = !like.value;
};

const updateCount = () => {
  reqNewsCount(id)
}

</script>

<style scoped lang="less">

.container {
  padding: 16px 0 20px 0;
}

.main-content {
  margin: 10px auto;
}

</style>