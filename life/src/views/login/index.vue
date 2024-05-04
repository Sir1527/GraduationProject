<template>
  <div class="container">
    <div style="height: 60px; background-color: white">
      <div style="width: 60%; height: 100%; display: flex; align-items: center; margin:  0 auto">
        <img src="@/assets/images/logo.png" alt="" style="width: 40px" />
        <span style="color: #2A60C9; font-size: 24px; font-weight: bold; margin-left: 10px">老年人生活助手</span>
      </div>
    </div>
    <div style="height: calc(100vh - 60px); width: 60%; margin:  0 auto; display: flex; align-items: center">
      <div style="flex: 1">
        <img src="@/assets/images/login.png" alt="" style="width: 90%; border-radius: 5px;" />
      </div>
      <div
        style="width: 350px; padding: 50px 30px; box-shadow:  0 0 10px rgba(0, 0, 0 ,.1); background-color: white; border-radius: 5px;">
        <div style="text-align: center; font-size: 22px; margin-bottom: 30px; font-weight: bold; color: #2A60C9">欢 迎 使 用
        </div>
        <div class="login-form-wrapper">
          <div class="login-form-error-msg"></div>
          <a-form :model="form"  class="login-form" layout="vertical" @submit="handleSubmit">
            <a-form-item field="username" :validate-trigger="['change', 'blur']" hide-label>
              <a-input v-model="form.username">
                <template #prefix>
                  <icon-user />
                </template>
              </a-input>
            </a-form-item>
            <a-form-item field="password" :validate-trigger="['change', 'blur']" hide-label>
              <a-input-password allow-clear v-model="form.password">
                <template #prefix>
                  <icon-lock />
                </template>
              </a-input-password>
            </a-form-item>
            <a-space :size="16" direction="vertical">
              <div class="login-form-password-actions">
                <a-checkbox checked="rememberPassword">
                  记住密码
                </a-checkbox>
                <a-link style="margin-left: 85px;color: #666666">忘记密码</a-link>
              </div>
              <a-button type="primary" html-type="submit" long>
                登陆
              </a-button>
              <a-button type="text" long class="login-form-register-btn">
                注册账号
              </a-button>
            </a-space>
          </a-form>
        </div>
      </div>
    </div>

  </div>
</template>

<script setup lang="ts">
import { reactive } from "vue";

import {setToken, setUserCAvatar, setUserId} from "@/utils/auth";
import type { LoginFormData, RespUserData } from "@/api/user/type";
import { reqLogin } from "@/api/user/user";
import {useUserStore} from "@/store";

const userStore = useUserStore();
const form: LoginFormData = reactive({role: "USER"})

const login = async () => {
  const res: RespUserData = await reqLogin(form);
  if(res.code === '200') {
    const token = res.data?.token;
    setUserId(String (res.data?.id))
    setToken(String (token));
    setUserCAvatar(String (res.data?.avatar))
    setTimeout( () => {
      location.href = '/home'
    })
  } else {
    alert("账号密码错误")
  }
}

const loginU = async () => {
  await userStore.login(form)
}

const handleSubmit = () => {
  login()
}
</script>