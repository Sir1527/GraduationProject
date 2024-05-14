<template>
  <div class="container">
    <a-grid :cols="{ xs: 12, sm: 12, md: 12, lg: 24, xl: 24, xxl: 24 }" :colGap="12" :rowGap="16">
      <a-grid-item :span="{ xs: 24, sm: 24, md: 24, lg: 12, xl: 12, xxl: 12 }">
        <a-carousel :style="{
      height: '290px',
    }" :auto-play="true" indicator-type="dot" show-arrow="hover">
          <a-carousel-item v-for="(image, idx) in images" :key="idx">
            <img :src="image" :style="{
      width: '100%',
    }" alt="" />
          </a-carousel-item>
        </a-carousel>
      </a-grid-item>

      <a-grid-item :span="{ xs: 24, sm: 24, md: 24, lg: 12, xl: 12, xxl: 12 }">
        <a-card :body-style="{ padding: '0 10px', height: '290px' }" :bordered="false" >
          <div style="padding: 0">
            <a-menu mode="horizontal" :default-selected-keys="['0']" style="margin: 0">
              <a-menu-item key="0" @click="getNewsTopList('new')">最新咨询</a-menu-item>
              <a-menu-item key="1" @click="getNewsTopList('hot')">最热咨询</a-menu-item>
            </a-menu>
            <div style="padding: 0 10px" >
              <div v-for="item in topNews" :key="item.id" @click="$router.push('/newsDetail?id=' + item.id)"
                style="display: flex; grid-gap: 10px; margin: 10px 0; cursor: pointer; padding-top: 2px">
                <div
                  style="flex: 1; width: 0;margin: 1px 0;font-size: 15px; white-space: nowrap;overflow: hidden; text-overflow: ellipsis;">
                  {{ item.title }}
                </div>
                <div style="color: #666; font-size: 13px;padding-top: 0;margin: 1px 0;">
                  {{ item.time }}
                </div>
              </div>
            </div>
          </div>
        </a-card>
      </a-grid-item>

      <a-grid-item :span="{ xs: 24, sm: 24, md: 24, lg: 17, xl: 17, xxl: 17 }">

        <a-card :body-style="{ padding: '0 0 15px 0', }" :bordered="false">

          <div style="display: flex; margin-bottom: 10px; margin-left: 10px; padding-top: 20px">
            <div @click="loadCategoryNews('')" class="category-item" :class="{ 'category-active' : category === '' }">全部</div>
            <div @click="loadCategoryNews(item.name)" class="category-item" :class="{ 'category-active' : item.name === category }" v-for="item in categoryList" :key="item.id">{{ item.name }}</div>
          </div>

          <a-list class="list-demo-action-layout" :bordered="false" :data="newsData.list" :pagination-props="paginationProps">
            <template #item="{ item }">
                <a-list-item class="list-demo-item" action-layout="vertical" @click="$router.push('/newsDetail?id=' + item.id)">
                  <template #actions style="justify-content: flex-end;">
                    <span style="margin-right: 5px"><icon-clock-circle />{{ item.time }}</span>
                    <span><icon-eye />{{ item.count }}</span>
                    <span v-if="item.likes == '已点赞'">
                      <IconHeartFill :style="{ color: '#f53f3f' }" />
                    </span>
                    <span v-else>
                      <IconHeart />
                    </span>
                  </template>
                  <template #extra>
                    <div className="image-area" style="height: 98px">
                      <img alt="arco-design" :src=item.cover />
                    </div>
                  </template>
                  <a-typography-title :heading="5">
                    {{ item.title }}
                  </a-typography-title>
                </a-list-item>
            </template>
          </a-list>
        </a-card>
      </a-grid-item>

      <a-grid-item :span="{ xs: 24, sm: 24, md: 24, lg: 7, xl: 7, xxl: 7 }">

        <a-card :body-style="{ padding: '12px 0' }" :bordered="false" :header-style="{ padding: '30px 10px' }"
          title="公益活动">
          <template #extra>
            <a-link href="http://localhost:5173/activity">查看更多</a-link>
          </template>
          <div style="margin-left: 10px;margin-right: 10px;margin-top: 10px;height:534px">
            <div @click="$router.push('/activityDetail?id=' + item.id)" style="display: flex; grid-gap: 10px; margin-bottom: 17px; cursor: pointer" v-for="item in activityList" :key="item.id">
              <img :src="item.cover" alt="" style="width: 60px; height: 60px; border-radius: 5px">
              <div style="flex: 1">
                <div style="height: 40px; margin-bottom: 5px" class="line2">{{ item.name }}</div>
                <div style="color: #666; font-size: 13px">{{ item.start }}</div>
              </div>
            </div>
          </div>
        </a-card>

      </a-grid-item>
    </a-grid>
  </div>
</template>

<script setup lang="ts">
import {onMounted, reactive, ref} from "vue";
import {getTableDateAPI, reqCategoryNews, reqNewsTableDate, reqNewsTopList} from "@/api/news/news";
import type {newsData, RespNewsTopData} from "@/api/news/type";
import type {TableData} from "@arco-design/web-vue";
import request from "@/utils/http";
import type {respCategory} from "@/api/category/type";
import type {respActivityList} from "@/api/activity/type";
import {getUserId} from "@/utils/auth";

const images = [
  '../src/assets/carousel/1.png',
  '../src/assets/carousel/2.png',
];

const topNews = ref();
const getNewsTopList = async (sort: string) => {
  const res:RespNewsTopData = await reqNewsTopList(sort);
  topNews.value = res.data
}
onMounted(() => getNewsTopList('new'))


const newsData:TableData = reactive({})
const paginationProps = reactive({
  defaultPageSize: 4,
  total: newsData.total,
})
const id = getUserId()
const getTableData = async () => {
  const res = await getTableDateAPI(id);
  newsData.total = res.data.total;
  newsData.pageSize = res.data.pageSize;
  newsData.pageNum =res.data.pageNum;
  newsData.list = res.data.list
  console.log(newsData.list)
  paginationProps.total = newsData.total;
}

let category: any = ref('');
const loadCategoryNews = (category_: string) => {
  category.value = category_
  if (category_ === ''){
    getTableData();
  } else {
    request.get('/news/selectPage?category='+category_+'&pageSize=50').then(res => {
      newsData.total = res.data.total;
      newsData.pageSize = res.data.pageSize;
      newsData.pageNum =res.data.pageNum;
      newsData.list = res.data.list
      paginationProps.total = newsData.total;
    })
  }
}
onMounted(() =>loadCategoryNews(''))

import {useUserStore} from "@/store";
const userStore = useUserStore();

const categoryList: any = ref([]);
const loadCategory = () => {
  request.get<respCategory>('/category/selectAll').then(res => {
    categoryList.value = res.data;
    console.log(userStore.name);
  })
}
onMounted(() => loadCategory())


const activityList: any = ref([]);
const loadActivity = () => {
  request.get<any,respActivityList>('/activity/selectPage',{
    params:{
      pageSize: 7,
      pageNum: 1,
    }
  }).then(res => {
    activityList.value = res.data?.list;
  })
}

onMounted( () => loadActivity())
</script>

<style lang="less" scoped>
.container {
  padding: 16px 0 20px 0;
}

.general-card {
  width: 100%;
  min-height: 300px;
  padding: 0;
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

.category-item {
  padding: 5px 10px;
  //border: 1px solid #333;
  font-size: 17px;
  border-radius: 5px;
  margin-right: 10px;
  cursor: pointer;
}

.category-active {
  border: none;
  background-color: #2A60C9;
  color: #fff;
}
</style>