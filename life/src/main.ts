import { createApp } from 'vue'

import App from './App.vue'
import router from './router'
import store from './stores'
import ArcoVue from '@arco-design/web-vue';
import ArcoVueIcon from '@arco-design/web-vue/es/icon';
import '@arco-design/web-vue/dist/arco.css';
import '@/assets/style/global.less';

const app = createApp(App)

app.use(ArcoVue)
app.use(ArcoVueIcon)
app.use(store)
app.use(router)

app.mount('#app')