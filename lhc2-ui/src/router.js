import Vue from 'vue';
import iView from 'iview';
import VueRouter from 'vue-router';
import Util from './libs/util';
import Cookies from 'js-cookie';

const prefix = 'LHC - ';

Vue.use(VueRouter);

// 路由配置
const RouterConfig = {
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
            path: '/',
            name: 'main',
            meta: {
                title: `${prefix}首页`
            }
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
        },
        {
            path: '/swyz',
            name: 'swyz',
            meta: {
                title: `${prefix}首位遗值`
            },
            component: (resolve) => require(['./views/sw/yz.vue'], resolve)
        },
        {
            path: '/swzf',
            name: 'swzf',
            meta: {
                title: `${prefix}首位振幅`
            },
            component: (resolve) => require(['./views/sw/zf.vue'], resolve)
        },
        {
            path: '/swsw',
            name: 'swsw',
            meta: {
                title: `${prefix}首位顺位`
            },
            component: (resolve) => require(['./views/sw/sw.vue'], resolve)
        },
        {
            path: '/mwyz',
            name: 'mwyz',
            meta: {
                title: `${prefix}末位遗值`
            },
            component: (resolve) => require(['./views/mw/yz.vue'], resolve)
        },
        {
            path: '/mwzf',
            name: 'mwzf',
            meta: {
                title: `${prefix}末位振幅`
            },
            component: (resolve) => require(['./views/mw/zf.vue'], resolve)
        },
        {
            path: '/mwsw',
            name: 'mwsw',
            meta: {
                title: `${prefix}末位顺位`
            },
            component: (resolve) => require(['./views/mw/sw.vue'], resolve)
        }
    ]
};
const router = new VueRouter(RouterConfig);

router.beforeEach((to, from, next) => {
    iView.LoadingBar.start();
    Util.title(to.meta.title);
    if (from.fullPath === '/' && to.fullPath !== '/tm') {
        next('/tm');
        return;
    }
    next();
});

router.afterEach((to, from, next) => {
    iView.LoadingBar.finish();
    window.scrollTo(0, 0);
});

export default router;