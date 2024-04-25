<template>
  <div class="container">
    <a-card :style="{width:'500px',height:'600px'}">
      <h1>血压</h1>
      <blood-pressure />
    </a-card>
  </div>

</template>

<script setup lang="ts">

import BloodPressure from "@/views/health/components/bloodPressure .vue";
</script>

<style scoped lang="less">
.container {
  padding: 16px 0 20px 0;
}

</style>