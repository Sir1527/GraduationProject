<template>
  <a-card :bordered="false">
    <a-space :size="54">
      <a-upload
          list-type="picture-card"
          :show-upload-button="true"
          :show-file-list="false"
      >
        <template #upload-button>
          <a-avatar :size="100" class="info-avatar">
            <template #trigger-icon>
              <icon-camera />
            </template>
          </a-avatar>
        </template>
      </a-upload>
      <a-descriptions
          :data="renderData"
          :column="2"
          align="right"
          layout="inline-horizontal"
          :label-style="{
          width: '140px',
          fontWeight: 'normal',
          color: 'rgb(var(--gray-8))',
        }"
          :value-style="{
          width: '200px',
          paddingLeft: '8px',
          textAlign: 'left',
        }"
      >
      </a-descriptions>
    </a-space>
  </a-card>
</template>

<script lang="ts" setup>
import {onMounted, reactive} from 'vue';
import type { DescData } from '@arco-design/web-vue/es/descriptions/interface';
import {getEmail, getName, getPhone, getUserId, getUserName} from "@/utils/auth";
import {reqUserById} from "@/api/user/user";
import type {UserData} from "@/api/user/type";
import {useUserStore} from "@/store";
const userStore = useUserStore();

const id = getUserId();

const user: any = reactive<UserData>({});
const load = () => {
  reqUserById(id).then(res => {
    user.username = res.data?.username;
    userStore.setInfo(res.data)
    console.log(userStore.name);
  })
}
onMounted( () => load())

const renderData = [
  {
    label: 'ID:',
    value: getUserId(),
  },
  {
    label: '邮箱:',
    value: getEmail(),
  },
  {
    label: '昵称:',
    value: getUserName(),
  },
  {
    label: '姓名:',
    value: getName(),
  },
  {
    label: '电话:',
    value: getPhone(),
  },
] as DescData[];



</script>

<style scoped lang="less">
.arco-card {
  padding: 14px 0 4px 4px;
  border-radius: 4px;
}
:deep(.arco-avatar-trigger-icon-button) {
  width: 32px;
  height: 32px;
  line-height: 32px;
  background-color: #e8f3ff;
  .arco-icon-camera {
    margin-top: 8px;
    color: rgb(var(--arcoblue-6));
    font-size: 14px;
  }
}
</style>
