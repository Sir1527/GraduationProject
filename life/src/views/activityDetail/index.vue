<template>
  <div class="container">
    <a-card :bordered=false>
        <div style="display: flex; grid-gap: 20px;">
          <a-image :src="activity.cover" alt="" width="" height="300px" fit="cover"></a-image>
          <div style="flex: 1">
            <div style="font-size: 22px; margin-bottom: 40px">{{activity.name }}</div>
            <div class="item"><span style="color: #333">活动简介：</span>{{activity.descr }}</div>
            <div class="item"><span style="color: #333">活动日期：</span>{{ activity.start }} ~ {{ activity.end }}</div>
            <div class="item"><span style="color: #333">活动地址：</span>{{ activity.address }}</div>
            <div>
              <a-button size="medium" type="primary" v-if="activity.status === '未报名'" >开始报名</a-button>
              <a-button size="medium" type="primary" v-if="activity.status === '已报名'" disabled key="sign">已报名</a-button>
              <a-button size="medium" type="primary" v-if="activity.status === '未开始'" disabled key="notstart">活动未开始</a-button>
              <a-button size="medium" type="primary" v-if="activity.status === '已结束'" disabled key="notend">活动已结束</a-button>
            </div>
          </div>
        </div>
    </a-card>
  </div>
</template>

<script setup lang="ts">
import {useRoute} from "vue-router";
import {onMounted, reactive, type Ref, ref} from "vue";
import {reqActivity} from "@/api/activity/activity";
import type {activity} from "@/api/activity/type";

const route = useRoute();
const id = route.query.id

let activity = reactive<activity>({})
const load = (id: any) => {
  reqActivity(id).then(res => {
    activity.id = res.data?.id;
    activity.name = res.data?.name;
    activity.content = res.data?.content;
    activity.address = res.data?.address;
    activity.cover = res.data?.cover;
    activity.descr = res.data?.descr;
    activity.start = res.data?.start;
    activity.end = res.data?.end;
    activity.status = res.data?.status;
    console.log(activity.status)
  })
}

onMounted( () => load(id))
</script>

<style scoped lang="less">
.container {
  padding: 16px 0 20px 0;
}
.item {
  font-size: 16px;
  margin-bottom: 40px;
}
</style>