import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/login'
        },
        {
            path: '/home',
            component: () => import('@/views/home/index.vue'),
            meta: { title: '功能' },
            children: [
                {
                    path: '/mapshow',
                    component: () => import('@/views/page/Mapshow.vue'),
                    meta: { title: '地图显示' }
                },
                {
                    path: '/control',
                    component: () => import('@/views/page/Control.vue'),
                    meta: { title: '摄像头监控' },
                },
                {
                    path: '/playback',
                    component: () => import('@/views/page/Playback.vue'),
                    meta: { title: '视频回放' }
                },
                {
                    path: '/statistics',
                    component: () => import('@/views/page/Statistics.vue'),
                    meta: { title: '数据统计' }
                },
                {
                    path: '/cameralist',
                    component: () => import('@/views/manager/Cameralist.vue'),
                    meta: { title: '摄像头列表', permission: true }
                },
                {
                    path: '/addcamera',
                    component: () => import('@/views/manager/Addcamera.vue'),
                    meta: { title: '摄像头添加', permission: true }
                },
                {
                    path: '/userlist',
                    component: () => import('@/views/manager/Userlist.vue'),
                    meta: { title: '摄像头列表', permission: true }
                },
                {
                    path: '/adduser',
                    component: () => import('@/views/manager/Adduser.vue'),
                    meta: { title: '摄像头添加', permission: true }
                },
                {
                    path: '/403',
                    component: () => import('@/views/manager/403.vue'),
                    meta: { title: '403' }
                },
               
            ]
        },
        {
            path: '/login',
            component: () => import('@/views/login/index.vue'),
            meta: { title: '登录' }
        },
        {
            path: '/register',
            component: () => import('@/views/register/index.vue'),
            meta: { title: '注册' }
        }
    ]
});
