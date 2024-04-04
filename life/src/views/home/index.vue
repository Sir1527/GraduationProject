<template>
  <div class="container">
    <a-grid :cols="{ xs: 12, sm: 12, md: 12, lg: 24, xl: 24, xxl: 24 }" :colGap="12" :rowGap="16">
      <a-grid-item :span="{ xs: 24, sm: 24, md: 24, lg: 12, xl: 12, xxl: 12 }">
        <a-carousel
            :style="{
            height: '290px',
            }"
            :auto-play="true"
            indicator-type="dot"
            show-arrow="hover"
        >
          <a-carousel-item v-for="(image, idx) in images" :key="idx">
            <img
                :src="image"
                :style="{
              width: '100%',
              }"
             alt=""/>
          </a-carousel-item>
        </a-carousel>
      </a-grid-item>

      <a-grid-item :span="{ xs: 24, sm: 24, md: 24, lg: 12, xl: 12, xxl: 12 }">
        <a-card :body-style="{ padding: '0 10px' , height: '290px'} " :bordered="false">
          <div style="padding: 0">
            <a-menu mode="horizontal" :default-selected-keys="['0']" style="margin: 0">
              <a-menu-item key="0" @click="getNewsTopList('new')" >最新咨询</a-menu-item>
              <a-menu-item key="1" @click="getNewsTopList('hot')" >最热咨询</a-menu-item>
            </a-menu>
            <div style="padding: 0 10px">
              <div v-for="item in topNews" :key="item.id" style="display: flex; grid-gap: 10px; margin: 10px 0; cursor: pointer; padding-top: 2px">
                <div style="flex: 1; width: 0;margin: 1px 0;font-size: 15px; white-space: nowrap;overflow: hidden; text-overflow: ellipsis;">{{ item.title }}</div>
                <div style="color: #666; font-size: 13px;padding-top: 0;margin: 1px 0;">{{ item.time }}</div>
              </div>
            </div>
          </div>
        </a-card>
      </a-grid-item>

      <a-grid-item :span="{ xs: 24, sm: 24, md: 24, lg: 17, xl: 17, xxl: 17 }">

          <a-menu mode="horizontal" :default-selected-keys="['0']">
            <a-menu-item key="0" >全部</a-menu-item>
            <a-menu-item key="1" >养老动态</a-menu-item>
            <a-menu-item key="2" >养老政策</a-menu-item>
            <a-menu-item key="3" >养老服务</a-menu-item>
            <a-menu-item key="4" >养老产业</a-menu-item>
            <a-menu-item key="5" >养老模式</a-menu-item>
            <a-menu-item key="6" >养老金</a-menu-item>
            <a-menu-item key="7" >居家养老</a-menu-item>
          </a-menu>

          <a-card :body-style = "{padding:'0 0 15px 0',}" :bordered="false">

            <a-list
                class="list-demo-action-layout"
                :bordered="false"
                :data="newsData.list"
                :pagination-props="paginationProps"
            >
              <template #item="{ item }">
                <a-list-item class="list-demo-item" action-layout="vertical">
                  <template #actions>
                    <div style="display: flex">
                      <span style="margin-right: 5px"><icon-clock-circle />{{ item.time }}</span>
                      <span><icon-eye />{{ item.count }}</span>
                    </div>
                  </template>
                  <template #extra>
                    <div className="image-area">
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

          <a-card :body-style="{ padding:'12px 0' }"
                  :bordered="false"
                  :header-style="{ padding: '30px 10px' }"
                  title="公益活动">
            <template #extra>
              <a-link>查看更多</a-link>
            </template>
            <a-list :bordered="false">

              <a-list-item action-layout="vertical">
                <a-list-item-meta
                    action-layout="vertical"
                    title="志愿服务树时代新风雷锋精神放璀璨光芒"
                >
                  <template #actions>
                    <span><icon-heart />83</span>
                    <span><icon-star />1</span>
                    <span><icon-message />Reply</span>
                  </template>
                  <template #avatar>
                    <a-avatar shape="square">
                      <img
                          alt="avatar"
                          src="https://dfzximg02.dftoutiao.com\/news\/20240329\/20240329134855_01ef0f6fb366a2cc9e1a7c07e4bddf6a_1_mwpm_03201609.jpeg"
                      />
                    </a-avatar>
                  </template>

                </a-list-item-meta>
                <template #actions>
                    <span style="margin-left: 180px"><icon-clock-circle />
                      2024-01-10
                    </span>
                </template>
              </a-list-item>
              <a-list-item action-layout="vertical">
                <a-list-item-meta
                    action-layout="vertical"
                    title="【爷爷奶奶的新年礼物】——“边陲暖心行情系夕阳红”"
                >
                  <template #actions>
                    <span><icon-heart />83</span>
                    <span><icon-star />1</span>
                    <span><icon-message />Reply</span>
                  </template>
                  <template #avatar>
                    <a-avatar shape="square">
                      <img
                          alt="avatar"
                          src="https://dfzximg02.dftoutiao.com\/news\/20240329\/20240329134855_01ef0f6fb366a2cc9e1a7c07e4bddf6a_2_mwpm_03201609.jpeg"
                      />
                    </a-avatar>
                  </template>

                </a-list-item-meta>
                <template #actions>
                    <span style="margin-left: 180px"><icon-clock-circle />
                      2024-01-30
                    </span>
                </template>
              </a-list-item>
              <a-list-item action-layout="vertical">
                <a-list-item-meta
                    action-layout="vertical"
                    title="冬病夏治”麻布社区健康知识科普活动"
                >
                  <template #actions>
                    <span><icon-heart />83</span>
                    <span><icon-star />1</span>
                    <span><icon-message />Reply</span>
                  </template>
                  <template #avatar>
                    <a-avatar shape="square">
                      <img
                          alt="avatar"
                          src="https://dfzximg02.dftoutiao.com\/news\/20240329\/20240329134855_01ef0f6fb366a2cc9e1a7c07e4bddf6a_3_mwpm_03201609.jpeg"
                      />
                    </a-avatar>
                  </template>

                </a-list-item-meta>
                <template #actions>
                    <span style="margin-left: 180px"><icon-clock-circle />
                      2023-12-29
                    </span>
                </template>
              </a-list-item>
              <a-list-item action-layout="vertical">
                <a-list-item-meta
                    action-layout="vertical"
                    title="支部结对聚合力 携手共建保健康"
                >
                  <template #actions>
                    <span><icon-heart />83</span>
                    <span><icon-star />1</span>
                    <span><icon-message />Reply</span>
                  </template>
                  <template #avatar>
                    <a-avatar shape="square">
                      <img
                          alt="avatar"
                          src="https://dfzximg02.dftoutiao.com\/news\/20240329\/20240329124738_95c9dd1c1a5dddb953493d4e4d4e3101_1_mwpm_03201609.jpeg"
                      />
                    </a-avatar>
                  </template>

                </a-list-item-meta>
                <template #actions>
                    <span style="margin-left: 180px"><icon-clock-circle />
                     2023-12-01
                    </span>
                </template>
              </a-list-item>
              <a-list-item action-layout="vertical">
                <a-list-item-meta
                    action-layout="vertical"
                    title="季度集体生日会，让“银发”志愿者感受“大家庭”的温暖"
                >
                  <template #avatar>
                    <a-avatar shape="square">
                      <img
                          alt="avatar"
                          src="https://dfzximg02.dftoutiao.com\/news\/20240329\/20240329114533_6425a0a86e2b87e774f2c1d6ca24572c_1_mwpm_03201609.jpeg"
                      />
                    </a-avatar>
                  </template>

                </a-list-item-meta>
                <template #actions>
                    <span style="margin-left: 180px"><icon-clock-circle />
                      2023-12-29
                    </span>
                </template>
              </a-list-item>
              <a-list-item action-layout="vertical">
                <a-list-item-meta
                    action-layout="vertical"
                    title="冬病夏治”麻布社区健康知识科普活动"
                >
                  <template #avatar>
                    <a-avatar shape="square">
                      <img
                          alt="avatar"
                          src="https://dfzximg02.dftoutiao.com\/news\/20240329\/20240329114533_6425a0a86e2b87e774f2c1d6ca24572c_2_mwpm_03201609.jpeg"
                      />
                    </a-avatar>
                  </template>

                </a-list-item-meta>
                <template #actions>
                    <span style="margin-left: 180px"><icon-clock-circle />
                     2023-12-01
                    </span>
                </template>
              </a-list-item>

            </a-list>

          </a-card>

      </a-grid-item>
    </a-grid>
  </div>
</template>

<script setup lang="ts">
import {onMounted, reactive, ref} from "vue";
import {getNewsTopListAPI, getTableDateAPI} from "@/api/news";

const images = [
  '../src/assets/carousel/1.png',
  '../src/assets/carousel/2.png',
];

const topNews = ref([
  {
    id:'',
    title:'',
    time:'',
  }
]);
const getNewsTopList = async (sort:string ) => {
  const res = await getNewsTopListAPI(sort)
  topNews.value = res.data;
}
onMounted(() => getNewsTopList('new'));


const categoryData = ref([
  {id: '',name: ''}
])

interface TableData {
  pageNum: number,
  pageSize: number,
  total: number,
  list: Array<[]>;
}

const newsData:TableData = reactive({

})

const paginationProps = reactive({
  defaultPageSize: 4,
  total: newsData.total,
})
const getTableData = async () => {
  const res = await getTableDateAPI();
  console.log(res)
  newsData.total = res.data.total;
  newsData.pageSize = res.data.pageSize;
  newsData.pageNum =res.data.pageNum;
  newsData.list = res.data.list
  paginationProps.total = newsData.total;
  console.log(newsData)
  console.log(newsData.total)
}
onMounted(() => getTableData());
console.log(newsData.total)


const activityList = ref([
  {
    id:1,
    name:'志愿服务树时代新风雷锋精'
  }
]);


</script>

<style lang="less" scoped>
.container {
  padding: 16px 20px;
  padding-bottom: 0;
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

.category-active {
  border: none;
  background-color: #2A60C9;
  color: #fff;
}


.category-item {
  padding: 5px 10px;
  border: 1px solid #333;
  border-radius: 5px;
  margin-right: 10px;
  cursor: pointer;
}

</style>