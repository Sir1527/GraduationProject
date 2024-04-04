<template>
  <div class="menu">
    <a-menu mode="horizontal" :default-selected-keys="['0']">
      <a-menu-item key="0" @click="$router.push('/home')">首页</a-menu-item>
      <a-menu-item key="1" @click="$router.push('/dashboard/workplace')">新闻</a-menu-item>
      <a-menu-item key="2" @click="$router.push('/activity')">公益活动</a-menu-item>
      <a-menu-item key="3" @click="$router.push('/community')">社区</a-menu-item>
      <a-menu-item key="4" @click="$router.push('/health')">健康</a-menu-item>
    </a-menu>
  </div>
</template>

<script setup lang="ts">

</script>

<style scoped lang="less">

</style>