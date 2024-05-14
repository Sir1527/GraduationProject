<template>
  <a-form
    ref="formRef"
    :model="formData"
    class="form"
    :label-col-props="{ span: 8 }"
    :wrapper-col-props="{ span: 16 }"
  >
    <a-form-item
      field="email"
      label="邮箱"
      :rules="[
        {
          required: true,
          message: '请输入邮箱',
        },
      ]"
    >
      <a-input
        v-model="formData.email"
        placeholder="请输入邮箱地址，如xxx{'@'}bytedance.com"
      />
    </a-form-item>
    <a-form-item
        field="name"
        label="姓名"
        :rules="[
        {
          required: true,
          message: '请输入姓名',
        },
      ]"
    >
      <a-input
          v-model="formData.name"
          placeholder="请输入昵称"
      />
    </a-form-item>
    <a-form-item
      field="username"
      label="昵称"
      :rules="[
        {
          required: true,
          message: '请输入昵称',
        },
      ]"
    >
      <a-input
        v-model="formData.username"
        placeholder="请输入昵称"
      />
    </a-form-item>
    <a-form-item
        field="phone"
        label="电话"
        :rules="[
        {
          required: true,
          message: '请输入电话',
        },
      ]"
    >
      <a-input
          v-model="formData.phone"
          placeholder="请输入昵称"
      />
    </a-form-item>
    <a-form-item>
      <a-space>
        <a-button type="primary" @click="validate">
          保存
        </a-button>
        <a-button type="secondary" @click="reset">
          重置
        </a-button>
      </a-space>
    </a-form-item>
  </a-form>
</template>

<script lang="ts" setup>
import {reactive, ref} from 'vue';
  import type {UserData} from "@/api/user/type";
import {getUserId, setName, setPhone, setUserCAvatar, setUserEmail, setUserId, setUserName} from "@/utils/auth";
import {reqUserById, updateUser} from "@/api/user/user";
  const id: any = getUserId();
  const formRef = ref();
  const formData: UserData | any = reactive<UserData>({});
  const validate = async () => {
    formData.id = getUserId();
    updateUser(formData).then(res => {
    });
    location.reload();
  };
  const reset = async () => {
    await formRef.value?.resetFields();
  };
</script>

<style scoped lang="less">
  .form {
    width: 540px;
    margin: 0 auto;
  }
</style>
