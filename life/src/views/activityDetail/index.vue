<template>
  <div class="container">
    <a-card :bordered=false>
        <div style="display: flex; grid-gap: 20px;">
          <a-image :src="activity.cover" alt="" width="460px" height="300px" fit="cover"></a-image>
          <div style="flex: 1">
            <div style="font-size: 22px; margin-bottom: 40px">{{activity.name }}</div>
            <div class="item"><span style="color: #333">活动简介：</span>{{activity.descr }}</div>
            <div class="item"><span style="color: #333">活动日期：</span>{{ activity.start }} ~ {{ activity.end }}</div>
            <div class="item"><span style="color: #333">活动地址：</span>{{ activity.address }}</div>
            <div>
              <a-button @click="handleClick" size="medium" type="primary" v-if="activity.status === '未报名'" >开始报名</a-button>
              <a-button size="medium" type="primary" v-if="activity.status === '已报名'" disabled key="sign">已报名</a-button>
              <a-button size="medium" type="primary" v-if="activity.status === '未开始'" disabled key="notstart">活动未开始</a-button>
              <a-button size="medium" type="primary" v-if="activity.status === '已结束'" disabled key="notend">活动已结束</a-button>
            </div>
          </div>
        </div>
        <div style="margin-bottom: 30px; font-size: 22px; font-weight: bold; text-align: center">- 活动详情 -</div>
        <div class="w-e-text" style="line-height: 26px">
            <div v-html="activity.content"></div>
        </div>

      <a-modal v-model:visible="visible" @ok="sign">
        <template #title>
          填写报名信息
        </template>
        <a-input :style="{width:'100'}" placeholder="请输入电话号吗" allow-clear v-model=form.phone>
          <template #prefix>
            <icon-phone />
          </template>
        </a-input>
      </a-modal>
    </a-card>

    <a-card :bordered="false" style="margin-top: 15px">
      <components :fid=id module="activity"></components>
    </a-card>


  </div>
</template>

<script setup lang="ts">
import {useRoute} from "vue-router";
import {onMounted, reactive, ref} from "vue";
import {reqActivity} from "@/api/activity/activity";
import type {activity, form, respActivity} from "@/api/activity/type";
import components from "@/components/comment/index.vue";
import request from "@/utils/http";
import {getUserId} from "@/utils/auth";

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
  })
}
onMounted( () => load(id))

const visible = ref(false);
const handleClick = () => {
  visible.value = true;
};

const form: form | any = reactive({})
const userId = getUserId();

const sign = () => {
  form.userId = userId;
  form.activityId = id;
  request.post<any,respActivity>('/activitySign/add', form).then(res => {
    if (res.code === '200'){
      visible.value = false;
      load(id)
    } else {
      alert('错误')
    }
  })
}

const handleOk = () => {
  visible.value = false;
  console.log(form.phone)
};

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