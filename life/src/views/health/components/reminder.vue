<template>
  <div>
    <div style="font-size: 20px">
      提醒事项
      <a-button  shape="circle" :style="{float: 'right',marginRight: '10px'}" @click="handleClick">
        <icon-plus />
      </a-button>
    </div>
    <div id="echarts1" ref="container" style="height: 330px;width: 550px;">
      <div style="margin-top: 20px">
        <a-col :flex="1" v-for="(item,index) in list" :key="index">
          <a-countdown
              title="剩余时间："
              :value="item.time + 1000 * 60 * 24 * 4"
              :now="item.time"
              format="D 天 H 时 m 分 s 秒"
          />
          <span style="font-size: 25px;margin-left: 10px">{{ item.title }}</span>
        </a-col>
      </div>
    </div>
  </div>

  <a-modal v-model:visible="visible" @ok="handleOk" @cancel="handleCancel">
    <template #title>
      新增提醒事项
    </template>

    请选择提醒时间：<br>
    <a-date-picker
        showTime
        defaultValue="2024-05-09 11:00:00"
        @change="onChange"
        :style="style"
    /><br>
    请选择提醒事项：<br>
    <a-input v-model="form.title"></a-input>
  </a-modal>

</template>

<script setup lang="ts">
import {onMounted, reactive, ref} from "vue";
import {reqReminder, reqReminderAdd} from "@/api/reminder/reminder";
import {getUserId} from "@/utils/auth";
import type {Reminder} from "@/api/reminder/type";

const now = Date.now();
const visible = ref(false);
const handleClick = () => {
  visible.value = true;
};
const handleOk = () => {
  visible.value = false;
  add();
  location.reload();
};
const handleCancel = () => {
  visible.value = false;
};

const onChange = (dateString:any, ) => {
  form.reminderTime = dateString;
};

const  style = { width: '200px', marginBottom: '24px', marginRight: '24px' }
const id = getUserId();
const list = ref();
const load = () => {
  reqReminder(id).then(res => {
    list.value = res.data;
    for (let i = 0; i < list.value.length; i++) {
      list.value[i].time = Date.parse(list.value[i].reminderTime);
      console.log(list.value[i].time);
    }
  })
}
onMounted( () => load())

const form = reactive<Reminder>({});
const add = () => {
  form.userId = id;
  reqReminderAdd(form).then(res => {

  })
}
</script>

<style scoped lang="less">

</style>