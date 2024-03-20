<template>
  <div class="container">
    <a-grid :cols="{ xs: 12, sm: 12, md: 12, lg: 24, xl: 24, xxl: 24 }" :colGap="12" :rowGap="16" class="grid-demo-grid">
      <a-grid-item span="12">
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
        <a-card :body-style="{ padding: '0 10px'} ">
          <div style="padding: 0">
            <a-menu mode="horizontal" :default-selected-keys="['0']" style="margin: 0">
              <a-menu-item key="0">最新咨询</a-menu-item>
              <a-menu-item key="1">最热咨询</a-menu-item>
            </a-menu>
            <div style="padding: 0 10px">
              <div v-for="item in topNews" :key="item.id" style="display: flex; grid-gap: 10px; margin: 10px 0; cursor: pointer">
                <div style="flex: 1; width: 0;margin: 1px 0;font-size: 15px; white-space: nowrap;overflow: hidden; text-overflow: ellipsis;">{{ item.title }}</div>
                <div style="color: #666; font-size: 13px;padding-top: 10px;margin: 1px 0;">{{ item.time }}</div>
              </div>
            </div>
          </div>
        </a-card>
      </a-grid-item>

      <a-grid-item :span="{ xs: 24, sm: 24, md: 24, lg: 17, xl: 17, xxl: 17 }">
          <a-menu mode="horizontal" :default-selected-keys="['0']">
            <a-menu-item key="0">全部</a-menu-item>
            <a-menu-item key="1">居家养老</a-menu-item>
            <a-menu-item key="2">养老金</a-menu-item>
            <a-menu-item key="3">养老模式</a-menu-item>
            <a-menu-item key="4">养老产业</a-menu-item>
            <a-menu-item key="5">养老服务</a-menu-item>
            <a-menu-item key="6">养老政策</a-menu-item>
            <a-menu-item key="7">养老动态</a-menu-item>
          </a-menu>
          <a-card :body-style = "{padding:'0 0 15px 0',}" :bordered="false">
            <a-list
                class="list-demo-action-layout"
                :bordered="false"
                :data="dataSource"
                :pagination-props="paginationProps"
            >
              <template #item="{ item }">
                <a-list-item class="list-demo-item" action-layout="vertical">
                  <template #actions>
                    <span><icon-heart />83</span>
                    <span><icon-star />{{ item.index }}</span>
                  </template>
                  <template #extra>
                    <div className="image-area">
                      <img alt="arco-design" :src="item.imageSrc" />
                    </div>
                  </template>
                  <a-list-item-meta
                      :description="item.description"
                  >
                  </a-list-item-meta>
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
            <a-list :bordered="false" :split="false">
              <a-list-item v-for="idx in 8" :key="idx">
                <a-list-item-meta
                    title="Beijing Bytedance Technology Co., Ltd."
                >
                  <template #avatar>
                    <a-avatar shape="square">
                      <img
                          alt="avatar"
                          src="https://p1-arco.byteimg.com/tos-cn-i-uwbnlip3yd/3ee5f13fb09879ecb5185e440cef6eb9.png~tplv-uwbnlip3yd-webp.webp"
                      />
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
import {reactive} from "vue";


const images = [
  '../src/assets/carousel/1.png',
  '../src/assets/carousel/2.png',
];

const topNews = [
  {id: "1",title:'印发推动乡镇敬老院高质量发展十条措施的通知',time : "2023-12-28 20:00:00"},
  {id: "1",title:'冬至吃饺子，九九养老•玖悦颐养中心陪你过一个温暖的节日！',time : "2023-12-28 20:00:00"},
  {id: "1",title:'西乡街道麻布社区开展“抗压有方”麻布社区长者慢病管理小组活动',time : "2023-12-28 20:00:00"},
  {id: "1",title:'【最新】2023年杭州高龄老人生活津贴标准调整啦',time : "2023-12-28 20:00:00"},
  {id: "1",title:'社区养老服务中心在并建成',time : "2023-12-28 20:00:00"},
  {id: "1",title:'特困老人的“温暖使者”',time : "2023-12-28 20:00:00"},
];

const names = ['Socrates', 'Balzac', 'Plato'];
const avatarSrc = [
  '//p1-arco.byteimg.com/tos-cn-i-uwbnlip3yd/a8c8cdb109cb051163646151a4a5083b.png~tplv-uwbnlip3yd-webp.webp',
  '//p1-arco.byteimg.com/tos-cn-i-uwbnlip3yd/e278888093bef8910e829486fb45dd69.png~tplv-uwbnlip3yd-webp.webp',
  '//p1-arco.byteimg.com/tos-cn-i-uwbnlip3yd/9eeb1800d9b78349b24682c3518ac4a3.png~tplv-uwbnlip3yd-webp.webp',
];
const imageSrc = [
  '//p1-arco.byteimg.com/tos-cn-i-uwbnlip3yd/29c1f9d7d17c503c5d7bf4e538cb7c4f.png~tplv-uwbnlip3yd-webp.webp',
  '//p1-arco.byteimg.com/tos-cn-i-uwbnlip3yd/04d7bc31dd67dcdf380bc3f6aa07599f.png~tplv-uwbnlip3yd-webp.webp',
  '//p1-arco.byteimg.com/tos-cn-i-uwbnlip3yd/1f61854a849a076318ed527c8fca1bbf.png~tplv-uwbnlip3yd-webp.webp',
];
const dataSource = new Array(15).fill(null).map((_, index) => {
  return {
    index: index,
    avatar: avatarSrc[index % avatarSrc.length],
    title: names[index % names.length],
    description:
        'Beijing ByteDance Technology Co., Ltd. is an enterprise located in China. ByteDance has products such as TikTok, Toutiao, volcano video and Douyin (the Chinese version of TikTok).',
    imageSrc: imageSrc[index % imageSrc.length],
  };
});

const paginationProps = reactive({
  defaultPageSize: 4,
  total: dataSource.length
})



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
</style>