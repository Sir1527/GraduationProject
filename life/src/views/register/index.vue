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
        <img src="@/assets/images/login.png" alt="" style="width: 90%; border-radius: 5px;"/>
      </div>
      <div style="width: 350px; padding: 50px 30px; box-shadow:  0 0 10px rgba(0, 0, 0 ,.1); background-color: white; border-radius: 5px;">
        <div style="text-align: center; font-size: 22px; margin-bottom: 30px; font-weight: bold; color: #2A60C9">欢 迎 注 册</div>
        <div class="login-form-wrapper">
          <div class="login-form-error-msg"></div>
          <a-form
              ref="loginForm"
              class="login-form"
              layout="vertical"
          >
            <a-form-item
                field="username"
                :validate-trigger="['change', 'blur']"
                hide-label
            >
              <a-input placeholder="请输入账号">
                <template #prefix>
                  <icon-user />
                </template>
              </a-input>
            </a-form-item>
            <a-form-item
                field="password"
                :validate-trigger="['change', 'blur']"
                hide-label
            >
              <a-input-password
                  placeholder="请输入密码"
                  allow-clear
              >
                <template #prefix>
                  <icon-lock />
                </template>
              </a-input-password>
            </a-form-item>
            <a-form-item
                field="password"
                :validate-trigger="['change', 'blur']"
                hide-label
            >
              <a-input-password
                  allow-clear
                  placeholder="请确认密码"
              >
                <template #prefix>
                  <icon-lock />
                </template>
              </a-input-password>
            </a-form-item>
            <a-space :size="16" direction="vertical">
              <a-button type="primary" html-type="submit" long >
                注册账号
              </a-button>
              <a-button @click="$router.push('/login')" type="text" long class="login-form-register-btn">
                登录
              </a-button>
            </a-space>
          </a-form>
        </div>
      </div>
    </div>

  </div>
</template>

<script setup lang="ts">

</script>

<style scoped lang="less">

</style>