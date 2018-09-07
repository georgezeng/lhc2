import Vue from 'vue';
import iView from 'iview';
import VueRouter from 'vue-router';
import Util from './libs/util';
import App from './app.vue';

const prefix = 'LHC - ';

Vue.use(VueRouter);

// 路由配置
const RouterConfig = {
    mode: 'history',
    routes: [
        {
            path: '/login',
            name: 'login',
            meta: {
                title: `${prefix}登录页`
            },
            component: (resolve) => require(['./views/login.vue'], resolve)
        },
        {
            path: '/tm',
            name: 'tm',
            meta: {
                title: `${prefix}特码`
            },
            component: (resolve) => require(['./views/tm.vue'], resolve)
        },
        {
            path: '/sxyz',
            name: 'sxyz',
            meta: {
                title: `${prefix}生肖遗值`
            },
            component: (resolve) => require(['./views/sx/yz.vue'], resolve)
        },
        {
            path: '/sxzf',
            name: 'sxzf',
            meta: {
                title: `${prefix}生肖振幅`
            },
            component: (resolve) => require(['./views/sx/zf.vue'], resolve)
        },
        {
            path: '/sxsw',
            name: 'sxsw',
            meta: {
                title: `${prefix}生肖顺位`
            },
            component: (resolve) => require(['./views/sx/sw.vue'], resolve)
        }
    ]
};
const router = new VueRouter(RouterConfig);

router.beforeEach((to, from, next) => {
    iView.LoadingBar.start();
    Util.title(to.meta.title);
    next();
});

router.afterEach((to, from, next) => {
    iView.LoadingBar.finish();
    window.scrollTo(0, 0);
});

export default router;