<template>
  <div class="container">
    <a-grid :cols="{ xs: 12, sm: 12, md: 12, lg: 24, xl: 24, xxl: 24 }" :colGap="12" :rowGap="16" class="grid-demo-grid">
      <a-grid-item :span="{ xs: 8, sm: 8, md: 6, lg: 8, xl: 8, xxl: 8 }" v-for="(item,index) in activityList">
        <a-card :style="{ width: '360px' }">
          <template #actions>
            <span class="icon-hover"> <icon-clock-circle /> {{ item.start }} - {{ item.end }}</span>
            <span class="icon-hover"> <IconShareInternal /> </span>
          </template>
          <template #cover>
            <div
                :style="{
          height: '204px',
          overflow: 'hidden',
        }"
            >
              <img
                  :style="{ width: '100%', transform: 'translateY(-20px)' }"
                  alt="dessert"
                  :src=item.cover
              />
            </div>
          </template>
          <a-card-meta :title= item.name>
          </a-card-meta>
        </a-card>
      </a-grid-item>
    </a-grid>
    <div style="width: 200px;margin: 30px auto">
      <a-pagination :total="20" :page-size="6" @change="a"/>
    </div>
  </div>
</template>

<script setup lang="ts">

import {reqActivityList} from "@/api/activity/activity";
import {onMounted, ref} from "vue";
import type {activity} from "@/api/activity/type";

const activityList: activity | null | any = ref<activity>();
const load = async () => {
  const res = await reqActivityList();
  activityList.value = res.data?.list;
  console.log(activityList)
}
onMounted(() => load())

const a = (num: number) => {
  console.log(num)
}
</script>

<style scoped lang="less">
.container {
  padding: 16px 20px;
  padding-bottom: 0;
}

</style>