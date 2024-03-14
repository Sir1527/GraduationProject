import { DEFAULT_LAYOUT } from '../base';
import { AppRouteRecordRaw } from '../types';

const HOME: AppRouteRecordRaw = {
    path: '/home',
    name: 'home',
    component: DEFAULT_LAYOUT,
    meta: {
        locale: 'menu.home',
        requiresAuth: true,
        order: 0,
    },
    children: [
        {
            path: 'index',
            name: 'index',
            component: () => import('@/views/home/index.vue'),
            meta: {
                locale: 'menu.dashboard.workplace',
                requiresAuth: true,
                roles: ['*'],
            },
        },
    ],
};

export default HOME;