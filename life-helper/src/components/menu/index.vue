<script setup lang="ts">

</script>

<template>
  <div class="menu">
    <a-menu mode="horizontal" :default-selected-keys="['0']">
      <a-menu-item key="0" @click="$router.push('/home/index')">首页</a-menu-item>
      <a-menu-item key="1" @click="$router.push('/dashboard/workplace')">演示页</a-menu-item>
      <a-menu-item key="2" @click="$router.push('/test/index')">测试页</a-menu-item>
    </a-menu>
  </div>
</template>

<style scoped lang="less">

</style>