<template>
  <a-form
      ref="formRef"
      class="form"
      :label-col-props="{ span: 8 }"
      :wrapper-col-props="{ span: 16 }"
  >
    <a-form-item
        field="email"
        label="邮箱"
    >
      <a-input
          placeholder="请输入邮箱地址，如xxx{'@'}bytedance.com"
      />
    </a-form-item>
    <a-form-item
        field="name"
        label="姓名"
    >
      <a-input
          placeholder="请输入昵称"
      />
    </a-form-item>
  </a-form>
</template>

<script setup lang="ts">

</script>

<style scoped lang="less">

</style>