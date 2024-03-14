<template>
  <a-layout class="layout" :class="{ mobile: appStore.hideMenu }">
    <div v-if="navbar" class="layout-navbar">
      <NavBar />
    </div>
    <a-layout>
      <a-layout>
        <a-layout class="layout-content">
          <TabBar v-if="appStore.tabBar" />
          <a-layout-content>
              <PageLayout />
          </a-layout-content>
          <Footer v-if="footer" />
        </a-layout>
      </a-layout>
    </a-layout>
  </a-layout>
</template>

<script lang="ts" setup>
  import { ref, computed, provide, onMounted } from 'vue';
  import { useRouter, useRoute } from 'vue-router';
  import { useAppStore } from '@/store';
  import NavBar from '@/components/navbar/index.vue';
  import Footer from '@/components/footer/index.vue';
  import TabBar from '@/components/tab-bar/index.vue';
  import useResponsive from '@/hooks/responsive';
  import PageLayout from './page-layout.vue';

  const isInit = ref(false);
  const appStore = useAppStore();
  const router = useRouter();
  const route = useRoute();
  useResponsive(true);
  const navbar = computed(() => appStore.navbar);
  const footer = computed(() => appStore.footer);
  const drawerVisible = ref(false);
  provide('toggleDrawerMenu', () => {
    drawerVisible.value = !drawerVisible.value;
  });
  onMounted(() => {
    isInit.value = true;
  });
</script>

<style scoped lang="less">
  @nav-size-height: 60px;
  @layout-max-width: 1100px;

  .layout {
    width: 100%;
    height: 100%;
  }

  .layout-navbar {
    position: fixed;
    top: 0;
    left: 0;
    z-index: 100;
    width: 100%;
    height: @nav-size-height;
  }

  .layout-sider {
    position: fixed;
    top: 0;
    left: 0;
    z-index: 99;
    height: 100%;
    transition: all 0.2s cubic-bezier(0.34, 0.69, 0.1, 1);
    &::after {
      position: absolute;
      top: 0;
      right: -1px;
      display: block;
      width: 1px;
      height: 100%;
      background-color: var(--color-border);
      content: '';
    }

    > :deep(.arco-layout-sider-children) {
      overflow-y: hidden;
    }
  }

  .menu-wrapper {
    height: 100%;
    overflow: auto;
    overflow-x: hidden;
    :deep(.arco-menu) {
      ::-webkit-scrollbar {
        width: 12px;
        height: 4px;
      }

      ::-webkit-scrollbar-thumb {
        border: 4px solid transparent;
        background-clip: padding-box;
        border-radius: 7px;
        background-color: var(--color-text-4);
      }

      ::-webkit-scrollbar-thumb:hover {
        background-color: var(--color-text-3);
      }
    }
  }

  .layout-content {
    min-height: 100vh;
    overflow-y: hidden;
    padding-top: 60px;
    background-color: var(--color-fill-2);
    transition: padding 0.2s cubic-bezier(0.34, 0.69, 0.1, 1);
  }
</style>
