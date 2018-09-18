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
        },
        {
            path: '/hsyz',
            name: 'hsyz',
            meta: {
                title: `${prefix}合数遗值`
            },
            component: (resolve) => require(['./views/hs/yz.vue'], resolve)
        },
        {
            path: '/hszf',
            name: 'hszf',
            meta: {
                title: `${prefix}合数振幅`
            },
            component: (resolve) => require(['./views/hs/zf.vue'], resolve)
        },
        {
            path: '/hssw',
            name: 'hssw',
            meta: {
                title: `${prefix}合数顺位`
            },
            component: (resolve) => require(['./views/hs/sw.vue'], resolve)
        },
        {
            path: '/bsyz',
            name: 'bsyz',
            meta: {
                title: `${prefix}波色遗值`
            },
            component: (resolve) => require(['./views/bs/yz.vue'], resolve)
        },
        {
            path: '/bszf',
            name: 'bszf',
            meta: {
                title: `${prefix}波色振幅`
            },
            component: (resolve) => require(['./views/bs/zf.vue'], resolve)
        },
        {
            path: '/bssw',
            name: 'bssw',
            meta: {
                title: `${prefix}波色顺位`
            },
            component: (resolve) => require(['./views/bs/sw.vue'], resolve)
        },
        {
            path: '/zsyz',
            name: 'zsyz',
            meta: {
                title: `${prefix}质数遗值`
            },
            component: (resolve) => require(['./views/zs/yz.vue'], resolve)
        },
        {
            path: '/zszf',
            name: 'zszf',
            meta: {
                title: `${prefix}质数振幅`
            },
            component: (resolve) => require(['./views/zs/zf.vue'], resolve)
        },
        {
            path: '/zssw',
            name: 'zssw',
            meta: {
                title: `${prefix}质数顺位`
            },
            component: (resolve) => require(['./views/zs/sw.vue'], resolve)
        },
        {
            path: '/qqyz',
            name: 'qqyz',
            meta: {
                title: `${prefix}七区遗值`
            },
            component: (resolve) => require(['./views/qq/yz.vue'], resolve)
        },
        {
            path: '/qqzf',
            name: 'qqzf',
            meta: {
                title: `${prefix}七区振幅`
            },
            component: (resolve) => require(['./views/qq/zf.vue'], resolve)
        },
        {
            path: '/qqsw',
            name: 'qqsw',
            meta: {
                title: `${prefix}七区顺位`
            },
            component: (resolve) => require(['./views/qq/sw.vue'], resolve)
        },
        {
            path: '/seqyz',
            name: 'seqyz',
            meta: {
                title: `${prefix}十二区遗值`
            },
            component: (resolve) => require(['./views/seq/yz.vue'], resolve)
        },
        {
            path: '/seqzf',
            name: 'seqzf',
            meta: {
                title: `${prefix}十二区振幅`
            },
            component: (resolve) => require(['./views/seq/zf.vue'], resolve)
        },
        {
            path: '/seqsw',
            name: 'seqsw',
            meta: {
                title: `${prefix}十二区顺位`
            },
            component: (resolve) => require(['./views/seq/sw.vue'], resolve)
        },
        {
            path: '/slqyz',
            name: 'slqyz',
            meta: {
                title: `${prefix}十六区遗值`
            },
            component: (resolve) => require(['./views/slq/yz.vue'], resolve)
        },
        {
            path: '/slqzf',
            name: 'slqzf',
            meta: {
                title: `${prefix}十六区振幅`
            },
            component: (resolve) => require(['./views/slq/zf.vue'], resolve)
        },
        {
            path: '/slqsw',
            name: 'slqsw',
            meta: {
                title: `${prefix}十六区顺位`
            },
            component: (resolve) => require(['./views/slq/sw.vue'], resolve)
        },
        {
            path: '/pdyz',
            name: 'pdyz',
            meta: {
                title: `${prefix}配对遗值`
            },
            component: (resolve) => require(['./views/pd/yz.vue'], resolve)
        },
        {
            path: '/pdzf',
            name: 'pdzf',
            meta: {
                title: `${prefix}配对振幅`
            },
            component: (resolve) => require(['./views/pd/zf.vue'], resolve)
        },
        {
            path: '/pdsw',
            name: 'pdsw',
            meta: {
                title: `${prefix}配对顺位`
            },
            component: (resolve) => require(['./views/pd/sw.vue'], resolve)
        },
        {
            path: '/z2yz',
            name: 'z2yz',
            meta: {
                title: `${prefix}杂2遗值`
            },
            component: (resolve) => require(['./views/z2/yz.vue'], resolve)
        },
        {
            path: '/z2zf',
            name: 'z2zf',
            meta: {
                title: `${prefix}杂2振幅`
            },
            component: (resolve) => require(['./views/z2/zf.vue'], resolve)
        },
        {
            path: '/z2sw',
            name: 'z2sw',
            meta: {
                title: `${prefix}杂2顺位`
            },
            component: (resolve) => require(['./views/z2/sw.vue'], resolve)
        },
        {
            path: '/z7yz',
            name: 'z7yz',
            meta: {
                title: `${prefix}杂7遗值`
            },
            component: (resolve) => require(['./views/z7/yz.vue'], resolve)
        },
        {
            path: '/z7zf',
            name: 'z7zf',
            meta: {
                title: `${prefix}杂7振幅`
            },
            component: (resolve) => require(['./views/z7/zf.vue'], resolve)
        },
        {
            path: '/z7sw',
            name: 'z7sw',
            meta: {
                title: `${prefix}杂7顺位`
            },
            component: (resolve) => require(['./views/z7/sw.vue'], resolve)
        },
        {
            path: '/z13yz',
            name: 'z13yz',
            meta: {
                title: `${prefix}杂13遗值`
            },
            component: (resolve) => require(['./views/z13/yz.vue'], resolve)
        },
        {
            path: '/z13zf',
            name: 'z13zf',
            meta: {
                title: `${prefix}杂13振幅`
            },
            component: (resolve) => require(['./views/z13/zf.vue'], resolve)
        },
        {
            path: '/z13sw',
            name: 'z13sw',
            meta: {
                title: `${prefix}杂13顺位`
            },
            component: (resolve) => require(['./views/z13/sw.vue'], resolve)
        },
        {
            path: '/dsyz',
            name: 'dsyz',
            meta: {
                title: `${prefix}单双遗值`
            },
            component: (resolve) => require(['./views/ds/yz.vue'], resolve)
        },
        {
            path: '/dszf',
            name: 'dszf',
            meta: {
                title: `${prefix}单双振幅`
            },
            component: (resolve) => require(['./views/ds/zf.vue'], resolve)
        },
        {
            path: '/dssw',
            name: 'dssw',
            meta: {
                title: `${prefix}单双顺位`
            },
            component: (resolve) => require(['./views/ds/sw.vue'], resolve)
        }
    ]
};
const router = new VueRouter(RouterConfig);

router.beforeEach((to, from, next) => {
    iView.LoadingBar.start();
    Util.title(to.meta.title);
    if (from.fullPath === '/' && to.fullPath === '/') {
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