import { createApp } from 'vue'

import App from './App.vue'
import router from './router'
import store from './store'
import echarts from './utils/echarts'
import ArcoVue from '@arco-design/web-vue';
import ArcoVueIcon from '@arco-design/web-vue/es/icon';
import '@arco-design/web-vue/dist/arco.css';
import '@/assets/style/global.less';
import { createPinia } from 'pinia';
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate';



const app = createApp(App)

const pinia = createPinia()
pinia.use(piniaPluginPersistedstate)
app.use(pinia)
app.use(ArcoVue)
app.use(ArcoVueIcon)
app.use(store)
app.use(router)
app.provide('$echarts', echarts)
app.mount('#app')