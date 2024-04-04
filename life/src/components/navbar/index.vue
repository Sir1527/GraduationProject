<template>
  <div class="navbar">
    <div class="left-side">
      <a-space>
        <img
          alt="logo"
          src="//p3-armor.byteimg.com/tos-cn-i-49unhts6dw/dfdba5317c0c20ce20e64fac803d52bc.svg~tplv-49unhts6dw-image.image"
        />
      </a-space>
    </div>
    <div class="center-side">
      <Menu/>
    </div>
    <ul class="right-side">
      <li>
        <a-tooltip
            :content="
            theme === 'light'
              ? '点击切换为暗黑模式'
              : '点击切换为亮色模式'
          "
        >
          <a-button
              class="nav-btn"
              type="outline"
              :shape="'circle'"
              @click="handleToggleTheme"
          >
            <template #icon>
              <icon-moon-fill v-if="theme === 'dark'" />
              <icon-sun-fill v-else />
            </template>
          </a-button>
        </a-tooltip>
      </li>
      <li>
        <a-tooltip
            :content="
            isFullscreen
              ? '点击退出全屏模式'
              : '点击切换全屏模式'
          "
        >
          <a-button
              class="nav-btn"
              type="outline"
              :shape="'circle'"
              @click="toggleFullScreen"
          >
            <template #icon>
              <icon-fullscreen-exit v-if="isFullscreen" />
              <icon-fullscreen v-else />
            </template>
          </a-button>
        </a-tooltip>
      </li>
    </ul>
  </div>
</template>

<script lang="ts" setup>
import Menu from '@/components/menu/index.vue';

import {useAppStore} from "@/stores";
import {computed} from "vue";
import {useDark, useFullscreen, useToggle} from "@vueuse/core";

const appStore = useAppStore();

const { isFullscreen, toggle: toggleFullScreen } = useFullscreen();

const theme = computed( () => {
  return appStore.theme;
});

const isDark = useDark({
  selector: 'body',
  attribute: 'arco-theme',
  valueDark: 'dark',
  valueLight: 'light',
  storageKey: 'arco-theme',
  onChanged(dark: boolean) {
    appStore.toggleTheme(dark);
  }
});

const toggleTheme = useToggle(isDark);
const handleToggleTheme = () => {
  toggleTheme();
}
</script>

<style scoped lang="less">
  .navbar {
    display: flex;
    justify-content: space-between;
    height: 100%;
    background-color: var(--color-bg-2);

  }


  .left-side {
    display: flex;
    align-items: center;
    padding-left: 20px;
  }

  .center-side {
    height: 60px;
    flex: 1;
  }

  .right-side {
    display: flex;
    padding-right: 20px;
    list-style: none;
    :deep(.locale-select) {
      border-radius: 20px;
    }
    li {
      display: flex;
      align-items: center;
      padding: 0 10px;
    }

    a {
      color: var(--color-text-1);
      text-decoration: none;
    }
    .nav-btn {
      border-color: rgb(var(--gray-2));
      color: rgb(var(--gray-8));
      font-size: 16px;
    }
    .trigger-btn,
    .ref-btn {
      position: absolute;
      bottom: 14px;
    }
    .trigger-btn {
      margin-left: 14px;
    }
  }
</style>

<style lang="less">
  .message-popover {
    .arco-popover-content {
      margin-top: 0;
    }
  }
</style>
