<template>
  <div class="menu">
    <a-menu mode="horizontal" :selected-keys=keys>
      <a-menu-item key="/home" @click="$router.push('/home')">首页</a-menu-item>
      <a-menu-item key="/activity" @click="$router.push('/activity')">公益活动</a-menu-item>
      <a-menu-item key="/community" @click="$router.push('/community')">社区</a-menu-item>
      <a-menu-item key="/health" @click="$router.push('/health')">健康</a-menu-item>
    </a-menu>
  </div>
</template>

<script setup lang="ts">
import {useRoute} from "vue-router";
import {computed, onMounted, ref} from "vue";

const route = useRoute();
const keys = ref();

onMounted( () =>  computed( () => {
  keys.value = route.path;
  console.log(keys.value)
}))
</script>

<style scoped lang="less">

</style>