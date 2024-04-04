import {createRouter, createWebHistory} from "vue-router";
import Layout from "@/layout/default-layout.vue";
import Home from "@/views/home/index.vue";
import Login from "@/views/login/index.vue";
import Register from "@/views/register/index.vue";
import Activity from "@/views/activity/index.vue"
import Community from "@/views/community/index.vue"
import Health from "@/views/health/index.vue"

import {getToken} from "@/utils/auth";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // path和component对应关系的位置
  routes: [
    {
      path: '/',
      component: Layout,
      children: [
        {
          path: '/home',
          component: Home,
          meta: {
            title: '首页',
            order: 1,
          }
        },
        {
          path: '/activity',
          component: Activity,
          meta: {
            title: '活动'
          }
        },
        {
          path: '/community',
          component: Community,
          meta: {
            title: '社区'
          }
        },
        {
          path: '/health',
          component: Health,
          meta: {
            title: '社区'
          }
        },
      ]
    },
    {
      path: '/login',
      component: Login,
      meta: {
        title: '登陆'
      }
    },
    {
      path: '/register',
      component: Register,
      meta: {
        title: '登陆'
      }
    },
  ]
})

export const notFoundRouter = {
  path: '/:pathMatch(.*)*',
  name: 'notFound',
  redirect: '404',
}

router.beforeEach(async (to, from,next) => {
  const token = getToken();
  if (token === null && to.path !== '/login' && to.path !== '/register' && to.path !== '/home'){
    next('/login')
  }else {
    next();
  }
})

export default router