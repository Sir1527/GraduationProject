import {createRouter, createWebHistory} from "vue-router";
import Layout from "@/layout/default-layout.vue";
import Home from "@/views/home/index.vue";
import Login from "@/views/login/index.vue";
import Register from "@/views/register/index.vue";
import Activity from "@/views/activity/index.vue";
import Community from "@/views/community/index.vue";
import Health from "@/views/health/index.vue";
import NewsDetail from '@/views/newsDetail/index.vue';
import ActivityDetail from "@/views/activityDetail/index.vue"
import PostDetail from "@/views/postDetail/index.vue"

import {getToken} from "@/utils/auth";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // path和component对应关系的位置
  routes: [
    {
      path: '/',
      component: Layout,
      redirect: '/home',
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
            title: '健康'
          }
        },
        {
          path: '/newsDetail',
          component: NewsDetail,
          meta: {
            title: '新闻详情'
          }
        },
        {
          path: '/activityDetail',
          component: ActivityDetail,
          meta: {
            title: '活动详情'
          }
        },
        {
          path: '/postDetail',
          component: PostDetail,
          meta: {
            title: '帖子详情'
          }
        }
      ],
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
    {
      path: '/:pathMatch(.*)*',
      name: 'NotFound',
      component: () => import('@/views/not-found/index.vue')
    },
  ]
})


router.beforeEach(async (to, from,next) => {
  const token = getToken();
  if (token === null && to.path !== '/login' && to.path !== '/register' && to.path !== '/home'){
    alert("请先登陆！")
    next('/login')
  }else {
    next();
  }
})
export default router