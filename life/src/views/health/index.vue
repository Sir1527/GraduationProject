<template>
  <div class="container">
    <a-grid :cols="{ xs: 12, sm: 12, md: 12, lg: 24, xl: 24, xxl: 24 }" :colGap="12" :rowGap="16">
      <a-grid-item :span="{ xs: 24, sm: 24, md: 24, lg: 12, xl: 12, xxl: 12 }">
          <a-card>
            <BloodPressure></BloodPressure>
          </a-card>
      </a-grid-item>

      <a-grid-item :span="{ xs: 24, sm: 24, md: 24, lg: 12, xl: 12, xxl: 12 }">
        <a-card>

        </a-card>
      </a-grid-item>

      <a-grid-item :span="{ xs: 24, sm: 24, md: 24, lg: 12, xl: 12, xxl: 12 }">
        <a-card>

        </a-card>
      </a-grid-item>

      <a-grid-item :span="{ xs: 24, sm: 24, md: 24, lg: 12, xl: 12, xxl: 12 }">
        <a-card>

        </a-card>
      </a-grid-item>
    </a-grid>
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