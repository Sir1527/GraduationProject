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
        <a-card :body-style="{ padding: '0 10px', height: '290px' }" :bordered="false">
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
                  <div>
                    <span style="margin-right: 5px"><icon-clock-circle />{{ item.time }}</span>
                    <span><icon-eye />{{ item.count }}</span>
                  </div>
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
          <a-list :bordered="false">
            <a-list-item action-layout="vertical">
              <a-list-item-meta action-layout="vertical" title="志愿服务树时代新风雷锋精神放璀璨光芒">
                <template>
                  <span><icon-heart />83</span>
                  <span><icon-star />1</span>
                  <span><icon-message />Reply</span>
                </template>
                <template #avatar>
                  <a-avatar shape="square">
                    <img alt="avatar"
                         src="https://dfzximg02.dftoutiao.com\/news\/20240329\/20240329134855_01ef0f6fb366a2cc9e1a7c07e4bddf6a_1_mwpm_03201609.jpeg" />
                  </a-avatar>
                </template>

              </a-list-item-meta>
            </a-list-item>
            <a-list-item action-layout="vertical">
              <a-list-item-meta action-layout="vertical" title="志愿服务树时代新风雷锋精神放璀璨光芒">
                <template>
                  <span><icon-heart />83</span>
                  <span><icon-star />1</span>
                  <span><icon-message />Reply</span>
                </template>
                <template #avatar>
                  <a-avatar shape="square">
                    <img alt="avatar"
                      src="https://dfzximg02.dftoutiao.com\/news\/20240329\/20240329134855_01ef0f6fb366a2cc9e1a7c07e4bddf6a_1_mwpm_03201609.jpeg" />
                  </a-avatar>
                </template>

              </a-list-item-meta>
            </a-list-item>
            <a-list-item action-layout="vertical">
              <a-list-item-meta action-layout="vertical" title="【爷爷奶奶的新年礼物】——“边陲暖心行情系夕阳红”">
                <template>
                  <span><icon-heart />83</span>
                  <span><icon-star />1</span>
                  <span><icon-message />Reply</span>
                </template>
                <template #avatar>
                  <a-avatar shape="square">
                    <img alt="avatar"
                      src="https://dfzximg02.dftoutiao.com\/news\/20240329\/20240329134855_01ef0f6fb366a2cc9e1a7c07e4bddf6a_2_mwpm_03201609.jpeg" />
                  </a-avatar>
                </template>

              </a-list-item-meta>
            </a-list-item>
            <a-list-item action-layout="vertical">
              <a-list-item-meta action-layout="vertical" title="冬病夏治”麻布社区健康知识科普活动">
                <template>
                  <span><icon-heart />83</span>
                  <span><icon-star />1</span>
                  <span><icon-message />Reply</span>
                </template>
                <template #avatar>
                  <a-avatar shape="square">
                    <img alt="avatar"
                      src="https://dfzximg02.dftoutiao.com\/news\/20240329\/20240329134855_01ef0f6fb366a2cc9e1a7c07e4bddf6a_3_mwpm_03201609.jpeg" />
                  </a-avatar>
                </template>

              </a-list-item-meta>
            </a-list-item>
            <a-list-item action-layout="vertical">
              <a-list-item-meta action-layout="vertical" title="支部结对聚合力 携手共建保健康">
                <template>
                  <span><icon-heart />83</span>
                  <span><icon-star />1</span>
                  <span><icon-message />Reply</span>
                </template>
                <template #avatar>
                  <a-avatar shape="square">
                    <img alt="avatar"
                      src="https://dfzximg02.dftoutiao.com\/news\/20240329\/20240329124738_95c9dd1c1a5dddb953493d4e4d4e3101_1_mwpm_03201609.jpeg" />
                  </a-avatar>
                </template>

              </a-list-item-meta>
              <template #actions>
              </template>
            </a-list-item>
            <a-list-item action-layout="vertical">
              <a-list-item-meta action-layout="vertical" title="季度集体生日会，让“银发”志愿者感受“大家庭”的温暖">
                <template #avatar>
                  <a-avatar shape="square">
                    <img alt="avatar"
                      src="https://dfzximg02.dftoutiao.com\/news\/20240329\/20240329114533_6425a0a86e2b87e774f2c1d6ca24572c_1_mwpm_03201609.jpeg" />
                  </a-avatar>
                </template>

              </a-list-item-meta>
              <template #actions>
              </template>
            </a-list-item>
            <a-list-item action-layout="vertical">
              <a-list-item-meta action-layout="vertical" title="冬病夏治”麻布社区健康知识科普活动">
                <template #avatar>
                  <a-avatar shape="square">
                    <img alt="avatar"
                      src="https://dfzximg02.dftoutiao.com\/news\/20240329\/20240329114533_6425a0a86e2b87e774f2c1d6ca24572c_2_mwpm_03201609.jpeg" />
                  </a-avatar>
                </template>

              </a-list-item-meta>
            </a-list-item>

          </a-list>

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
const getTableData = async () => {
  const res = await getTableDateAPI();
  newsData.total = res.data.total;
  newsData.pageSize = res.data.pageSize;
  newsData.pageNum =res.data.pageNum;
  newsData.list = res.data.list
  paginationProps.total = newsData.total;
}

let pageNum = ref(1);
let  pageSize = ref(4);
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

const categoryList: any = ref([]);
const loadCategory = () => {
  request.get<respCategory>('/category/selectAll').then(res => {
    categoryList.value = res.data;
    console.log(categoryList.value)
  })
}
onMounted(() => loadCategory())

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