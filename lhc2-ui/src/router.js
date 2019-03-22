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
            path: '/stat-s2-s3',
            name: 'stat-s2-s3',
            meta: {
                title: `${prefix}数据统计-顺2-顺3`
            },
            component: (resolve) => require(['./views/stat/stat-s2-s3.vue'], resolve)
        },
        {
            path: '/stat-16-10',
            name: 'stat-16-10',
            meta: {
                title: `${prefix}数据统计-16&10`
            },
            component: (resolve) => require(['./views/stat/stat-16-10.vue'], resolve)
        },
        {
            path: '/stat-P2',
            name: 'stat-P2',
            meta: {
                title: `${prefix}数据统计-类型2`
            },
            component: (resolve) => require(['./views/stat/stat-P2.vue'], resolve)
        },
        {
            path: '/stat-P3',
            name: 'stat-P3',
            meta: {
                title: `${prefix}数据统计-类型3`
            },
            component: (resolve) => require(['./views/stat/stat-P3.vue'], resolve)
        },
        {
            path: '/stat-P2-P3',
            name: 'stat-P2-P3',
            meta: {
                title: `${prefix}数据统计-类型2-类型3`
            },
            component: (resolve) => require(['./views/stat/stat-P2-P3.vue'], resolve)
        },
        {
            path: '/comparision16',
            name: 'comparision16',
            meta: {
                title: `${prefix}数据对比-16`
            },
            component: (resolve) => require(['./views/comparision/comparision-16.vue'], resolve)
        },
        {
            path: '/comparision10',
            name: 'comparision10',
            meta: {
                title: `${prefix}数据对比-10`
            },
            component: (resolve) => require(['./views/comparision/comparision-10.vue'], resolve)
        },
        {
            path: '/comparision2-33',
            name: 'comparision2-33',
            meta: {
                title: `${prefix}数据对比2-33`
            },
            component: (resolve) => require(['./views/comparision2/comparision-33.vue'], resolve)
        },
        {
            path: '/comparision2-24',
            name: 'comparision2-24',
            meta: {
                title: `${prefix}数据对比2-24`
            },
            component: (resolve) => require(['./views/comparision2/comparision-24.vue'], resolve)
        },
        {
            path: '/comparision2-20',
            name: 'comparision2-20',
            meta: {
                title: `${prefix}数据对比2-20`
            },
            component: (resolve) => require(['./views/comparision2/comparision-20.vue'], resolve)
        },
        {
            path: '/comparision2-16',
            name: 'comparision2-16',
            meta: {
                title: `${prefix}数据对比2-16`
            },
            component: (resolve) => require(['./views/comparision2/comparision-16.vue'], resolve)
        },
        {
            path: '/comparision2-14',
            name: 'comparision2-14',
            meta: {
                title: `${prefix}数据对比2-14`
            },
            component: (resolve) => require(['./views/comparision2/comparision-14.vue'], resolve)
        },
        {
            path: '/comparision2-12',
            name: 'comparision2-12',
            meta: {
                title: `${prefix}数据对比2-12`
            },
            component: (resolve) => require(['./views/comparision2/comparision-12.vue'], resolve)
        },
        {
            path: '/comparision2-10',
            name: 'comparision2-10',
            meta: {
                title: `${prefix}数据对比2-10`
            },
            component: (resolve) => require(['./views/comparision2/comparision-10.vue'], resolve)
        },
        {
            path: '/comparision2-8',
            name: 'comparision2-8',
            meta: {
                title: `${prefix}数据对比2-8`
            },
            component: (resolve) => require(['./views/comparision2/comparision-8.vue'], resolve)
        },
        {
            path: '/comparision2-4',
            name: 'comparision2-4',
            meta: {
                title: `${prefix}数据对比2-4`
            },
            component: (resolve) => require(['./views/comparision2/comparision-4.vue'], resolve)
        },
        {
            path: '/comparision2-2',
            name: 'comparision2-2',
            meta: {
                title: `${prefix}数据对比2-2`
            },
            component: (resolve) => require(['./views/comparision2/comparision-2.vue'], resolve)
        },
        {
            path: '/comparision2-1',
            name: 'comparision2-1',
            meta: {
                title: `${prefix}数据对比2-2`
            },
            component: (resolve) => require(['./views/comparision2/comparision-1.vue'], resolve)
        },
        {
            path: '/comparision3-16',
            name: 'comparision3-16',
            meta: {
                title: `${prefix}数据对比3-16`
            },
            component: (resolve) => require(['./views/comparision3/comparision-16.vue'], resolve)
        },
        {
            path: '/comparision3-14',
            name: 'comparision3-14',
            meta: {
                title: `${prefix}数据对比3-14`
            },
            component: (resolve) => require(['./views/comparision3/comparision-14.vue'], resolve)
        },
        {
            path: '/comparision3-8',
            name: 'comparision3-8',
            meta: {
                title: `${prefix}数据对比3-8`
            },
            component: (resolve) => require(['./views/comparision3/comparision-8.vue'], resolve)
        },
        {
            path: '/comparision3-4',
            name: 'comparision3-4',
            meta: {
                title: `${prefix}数据对比3-4`
            },
            component: (resolve) => require(['./views/comparision3/comparision-4.vue'], resolve)
        },
        {
            path: '/comparision3-3',
            name: 'comparision3-3',
            meta: {
                title: `${prefix}数据对比3-3`
            },
            component: (resolve) => require(['./views/comparision3/comparision-3.vue'], resolve)
        },
        {
            path: '/comparision3-2',
            name: 'comparision3-2',
            meta: {
                title: `${prefix}数据对比3-2`
            },
            component: (resolve) => require(['./views/comparision3/comparision-2.vue'], resolve)
        },
        {
            path: '/comparision3-1',
            name: 'comparision3-1',
            meta: {
                title: `${prefix}数据对比3-1`
            },
            component: (resolve) => require(['./views/comparision3/comparision-1.vue'], resolve)
        },
        {
            path: '/emulate16',
            name: 'emulate16',
            meta: {
                title: `${prefix}数据模拟-16`
            },
            component: (resolve) => require(['./views/emulate/emulate-16.vue'], resolve)
        },
        {
            path: '/emulate10',
            name: 'emulate10',
            meta: {
                title: `${prefix}数据模拟-10`
            },
            component: (resolve) => require(['./views/emulate/emulate-10.vue'], resolve)
        },
        {
            path: '/emulate2-33',
            name: 'emulate2-33',
            meta: {
                title: `${prefix}数据模拟2-33`
            },
            component: (resolve) => require(['./views/emulate2/emulate-33.vue'], resolve)
        },
        {
            path: '/emulate2-24',
            name: 'emulate2-24',
            meta: {
                title: `${prefix}数据模拟2-24`
            },
            component: (resolve) => require(['./views/emulate2/emulate-24.vue'], resolve)
        },
        {
            path: '/emulate2-20',
            name: 'emulate2-20',
            meta: {
                title: `${prefix}数据模拟2-20`
            },
            component: (resolve) => require(['./views/emulate2/emulate-20.vue'], resolve)
        },
        {
            path: '/emulate2-16',
            name: 'emulate2-16',
            meta: {
                title: `${prefix}数据模拟2-16`
            },
            component: (resolve) => require(['./views/emulate2/emulate-16.vue'], resolve)
        },
        {
            path: '/emulate2-14',
            name: 'emulate2-14',
            meta: {
                title: `${prefix}数据模拟2-14`
            },
            component: (resolve) => require(['./views/emulate2/emulate-14.vue'], resolve)
        },
        {
            path: '/emulate2-12',
            name: 'emulate2-12',
            meta: {
                title: `${prefix}数据模拟2-12`
            },
            component: (resolve) => require(['./views/emulate2/emulate-12.vue'], resolve)
        },
        {
            path: '/emulate2-10',
            name: 'emulate2-10',
            meta: {
                title: `${prefix}数据模拟2-10`
            },
            component: (resolve) => require(['./views/emulate2/emulate-10.vue'], resolve)
        },
        {
            path: '/emulate2-8',
            name: 'emulate2-8',
            meta: {
                title: `${prefix}数据模拟2-8`
            },
            component: (resolve) => require(['./views/emulate2/emulate-8.vue'], resolve)
        },
        {
            path: '/emulate2-4',
            name: 'emulate2-4',
            meta: {
                title: `${prefix}数据模拟2-4`
            },
            component: (resolve) => require(['./views/emulate2/emulate-4.vue'], resolve)
        },
        {
            path: '/emulate2-2',
            name: 'emulate2-2',
            meta: {
                title: `${prefix}数据模拟2-2`
            },
            component: (resolve) => require(['./views/emulate2/emulate-2.vue'], resolve)
        },
        {
            path: '/emulate2-1',
            name: 'emulate2-1',
            meta: {
                title: `${prefix}数据模拟2-1`
            },
            component: (resolve) => require(['./views/emulate2/emulate-1.vue'], resolve)
        },
        {
            path: '/emulate3-16',
            name: 'emulate3-16',
            meta: {
                title: `${prefix}数据模拟3-16`
            },
            component: (resolve) => require(['./views/emulate3/emulate-16.vue'], resolve)
        },
        {
            path: '/emulate3-14',
            name: 'emulate3-14',
            meta: {
                title: `${prefix}数据模拟3-14`
            },
            component: (resolve) => require(['./views/emulate3/emulate-14.vue'], resolve)
        },
        {
            path: '/emulate3-8',
            name: 'emulate3-8',
            meta: {
                title: `${prefix}数据模拟3-8`
            },
            component: (resolve) => require(['./views/emulate3/emulate-8.vue'], resolve)
        },
        {
            path: '/emulate3-4',
            name: 'emulate3-4',
            meta: {
                title: `${prefix}数据模拟3-4`
            },
            component: (resolve) => require(['./views/emulate3/emulate-4.vue'], resolve)
        },
        {
            path: '/emulate3-3',
            name: 'emulate3-3',
            meta: {
                title: `${prefix}数据模拟3-3`
            },
            component: (resolve) => require(['./views/emulate3/emulate-3.vue'], resolve)
        },
        {
            path: '/emulate3-2',
            name: 'emulate3-2',
            meta: {
                title: `${prefix}数据模拟3-2`
            },
            component: (resolve) => require(['./views/emulate3/emulate-2.vue'], resolve)
        },
        {
            path: '/emulate3-1',
            name: 'emulate3-1',
            meta: {
                title: `${prefix}数据模拟3-1`
            },
            component: (resolve) => require(['./views/emulate3/emulate-1.vue'], resolve)
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
            path: '/slqayzzf',
            name: 'slqayzzf',
            meta: {
                title: `${prefix}十六区A`
            },
            component: (resolve) => require(['./views/slqa/yzzf.vue'], resolve)
        },
        {
            path: '/slqbyzzf',
            name: 'slqbyzzf',
            meta: {
                title: `${prefix}十六区B`
            },
            component: (resolve) => require(['./views/slqb/yzzf.vue'], resolve)
        },
        {
            path: '/slqcyzzf',
            name: 'slqcyzzf',
            meta: {
                title: `${prefix}十六区C`
            },
            component: (resolve) => require(['./views/slqc/yzzf.vue'], resolve)
        },
        {
            path: '/slqdyzzf',
            name: 'slqdyzzf',
            meta: {
                title: `${prefix}十六区D`
            },
            component: (resolve) => require(['./views/slqd/yzzf.vue'], resolve)
        },
        {
            path: '/slqbsyzzf',
            name: 'slqbsyzzf',
            meta: {
                title: `${prefix}十六区-波色`
            },
            component: (resolve) => require(['./views/slqbs/yzzf.vue'], resolve)
        },
        {
            path: '/slqwxyzzf',
            name: 'slqwxyzzf',
            meta: {
                title: `${prefix}十六区-五行`
            },
            component: (resolve) => require(['./views/slqwx/yzzf.vue'], resolve)
        },
        {
            path: '/slqzsyzzf',
            name: 'slqzsyzzf',
            meta: {
                title: `${prefix}十六区-质数`
            },
            component: (resolve) => require(['./views/slqzs/yzzf.vue'], resolve)
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
        },
        {
            path: '/fdyz',
            name: 'fdyz',
            meta: {
                title: `${prefix}十二分段遗值`
            },
            component: (resolve) => require(['./views/fd/yz.vue'], resolve)
        },
        {
            path: '/fdsw',
            name: 'fdsw',
            meta: {
                title: `${prefix}十二分段顺位`
            },
            component: (resolve) => require(['./views/fd/sw.vue'], resolve)
        },
        {
            path: '/dxds',
            name: 'dxds',
            meta: {
                title: `${prefix}小大单双`
            },
            component: (resolve) => require(['./views/dxds/yzzf.vue'], resolve)
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