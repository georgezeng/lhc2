<style scoped>
    @import "../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="stat"/>
            </Header>
            <Content class="content">
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        49-统计
                    </p>
                    <Table stripe border size="small" :loading="loading1" :columns="columns1" :data="data1"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        非49-统计
                    </p>
                    <Table stripe border size="small" :loading="loading2" :columns="columns1" :data="data2"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        16表选号
                    </p>
                    <Table stripe border size="small" :loading="loading9" :columns="columns2" :data="data9"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        14表选号
                    </p>
                    <Table stripe border size="small" :loading="loading3" :columns="columns2" :data="data3"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        10表选号
                    </p>
                    <Table stripe border size="small" :loading="loading4" :columns="columns2" :data="data4"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        7表选号
                    </p>
                    <Table stripe border size="small" :loading="loading5" :columns="columns2" :data="data5"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        4表选号
                    </p>
                    <Table stripe border size="small" :loading="loading6" :columns="columns2" :data="data6"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        16表/4表选号-合并
                    </p>
                    <Table stripe border size="small" :loading="loading10" :columns="columns2" :data="data10"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        14表/7表选号-合并
                    </p>
                    <Table stripe border size="small" :loading="loading7" :columns="columns2" :data="data7"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        14表/4表选号-合并
                    </p>
                    <Table stripe border size="small" :loading="loading8" :columns="columns2" :data="data8"/>
                </Card>
            </Content>
            <Footer/>
        </Layout>
    </div>
</template>
<script>
    import Menus from './index/menus.vue';
    import Footer from './index/footer.vue';
    import StatColumn from './index/stat-column.vue';
    import API from '../libs/api';

    export default {
        components: {
            Menus,
            Footer
        },
        data() {
            const self = this;
            return {
                queryInfo: {
                    page: {
                        num: 1,
                        size: 20,
                        property: 'phase',
                        order: 'DESC'
                    }
                },
                loading1: true,
                loading2: true,
                loading3: true,
                loading4: true,
                loading5: true,
                loading6: true,
                loading7: true,
                loading8: true,
                loading9: true,
                loading10: true,
                dataFor16: [],
                dataFor14: [],
                dataFor7: [],
                dataFor4: [],
                data1: [],
                data2: [],
                data3: [],
                data4: [],
                data5: [],
                data6: [],
                data7: [],
                data8: [],
                data9: [],
                data10: [],
                columns1: [
                    {
                        title: '次数',
                        width: 50,
                        key: 'count'
                    },
                    {
                        title: '个数',
                        width: 50,
                        render(h, params) {
                            return h('span', {}, params.row.nums ? params.row.nums.length : params.row.num);
                        }
                    },
                    {
                        title: '号码',
                        minWidth: 300,
                        render(h, params) {
                            if (params.row.nums) {
                                return h(StatColumn, {
                                    props: {
                                        nums: params.row.nums
                                    }
                                });
                            } else {
                                return h('span', {}, '');
                            }
                        }
                    },
                ],
                columns2: [
                    {
                        title: '定义',
                        width: 80,
                        render(h, params) {
                            return h('span', {}, params.row.colName);
                        }
                    },
                    {
                        title: '个数',
                        width: 50,
                        render(h, params) {
                            return h('span', {}, params.row.nums.length);
                        }
                    },
                    {
                        title: '#',
                        render(h, params) {
                            if (params.row.nums) {
                                return h(StatColumn, {
                                    props: {
                                        nums: params.row.nums
                                    }
                                });
                            } else {
                                return h('span', {}, '');
                            }
                        }
                    }
                ]
            }
        },
        methods: {
            loadData() {
                API.getStats1().then(data => {
                    this.loading1 = false;
                    let total = 0;
                    data.map(it => {
                        total += it.nums.length;
                    });
                    this.data1 = [
                        ...data,
                        {
                            count: '总数',
                            num: total,
                        }
                    ];
                });
                API.getStats2().then(data => {
                    this.loading2 = false;
                    let total = 0;
                    data.map(it => {
                        if (it.count > 0) {
                            total += it.nums.length;
                        }
                    });
                    this.data2 = [
                        ...data,
                        {
                            count: '总数',
                            num: total,
                        }
                    ];
                });
                this.changePage(1, 16, () => {
                    this.data9 = [];
                    return this.data9
                }, () => this.loading9 = true, () => this.loading9 = false);
                this.changePage(1, 14, () => {
                    this.data3 = [];
                    return this.data3
                }, () => this.loading3 = true, () => this.loading3 = false);
                this.changePage(1, 10, () => {
                    this.data4 = [];
                    return this.data4
                }, () => this.loading4 = true, () => this.loading4 = false);
                this.changePage(1, 7, () => {
                    this.data5 = [];
                    return this.data5
                }, () => this.loading5 = true, () => this.loading5 = false);
                this.changePage(1, 4, () => {
                    this.data6 = [];
                    return this.data6
                }, () => this.loading6 = true, () => this.loading6 = false);
                this.loadCombine();
            },
            changePage(pageNo, expected, initData, startLoading, stopLoading) {
                startLoading();
                API.getPickNums({
                    data: expected,
                    page: {
                        num: pageNo,
                        size: this.queryInfo.page.size,
                        property: this.queryInfo.page.property,
                        order: this.queryInfo.page.order
                    }
                }).then(result => {
                    stopLoading();
                    switch (expected) {
                        case 4:
                            this.dataFor5 = this.setupData2(result.list, initData());
                            break;
                        case 7:
                            this.dataFor7 = this.setupData2(result.list, initData());
                            break;
                        case 14:
                            this.dataFor14 = this.setupData1(result.list, initData());
                            break;
                        case 16:
                            this.dataFor16 = this.setupData1(result.list, initData());
                            break;
                        default: {
                            this.setupData1(result.list, initData());
                        }
                    }
                });
            },
            loadCombine() {
                if (this.dataFor4.numArr0 && this.dataFor4.numArr0.length > 0
                    && this.dataFor7.numArr0 && this.dataFor7.numArr0.length > 0
                    && this.dataFor14.numArr12 && this.dataFor14.numArr12.length > 0
                    && this.dataFor16.numArr12 && this.dataFor16.numArr12.length > 0) {

                    let data = [];
                    for (let i = 0; i < this.dataFor14.numArr12.length; i++) {
                        const numIn12 = this.dataFor14.numArr12[i];
                        for (let j = 0; j < this.dataFor7.numArr0.length; j++) {
                            const numIn0 = this.dataFor7.numArr0[j];
                            if (numIn12 == numIn0) {
                                data.push(numIn12);
                                break;
                            }
                        }
                    }
                    this.data7.push({colName: '0-12', nums: data});
                    this.loading7 = false;

                    data = [];
                    for (let i = 0; i < this.dataFor14.numArr12.length; i++) {
                        const numIn12 = this.dataFor14.numArr12[i];
                        for (let j = 0; j < this.dataFor5.numArr0.length; j++) {
                            const numIn0 = this.dataFor5.numArr0[j];
                            if (numIn12 == numIn0) {
                                data.push(numIn12);
                                break;
                            }
                        }
                    }
                    this.data8.push({colName: '0-12', nums: data});
                    this.loading8 = false;

                    data = [];
                    for (let i = 0; i < this.dataFor16.numArr12.length; i++) {
                        const numIn12 = this.dataFor16.numArr12[i];
                        for (let j = 0; j < this.dataFor4.numArr0.length; j++) {
                            const numIn0 = this.dataFor4.numArr0[j];
                            if (numIn12 == numIn0) {
                                data.push(numIn12);
                                break;
                            }
                        }
                    }
                    for (let i = 0; i < this.dataFor16.numArr34.length; i++) {
                        const numIn34 = this.dataFor16.numArr34[i];
                        for (let j = 0; j < this.dataFor4.numArr0.length; j++) {
                            const numIn0 = this.dataFor4.numArr0[j];
                            if (numIn34 == numIn0) {
                                data.push(numIn34);
                                break;
                            }
                        }
                    }
                    for (let i = 0; i < this.dataFor16.numArr5Plus.length; i++) {
                        const numIn5Plus = this.dataFor16.numArr5Plus[i];
                        for (let j = 0; j < this.dataFor5.numArr0.length; j++) {
                            const numIn0 = this.dataFor5.numArr0[j];
                            if (numIn5Plus == numIn0) {
                                data.push(numIn5Plus);
                                break;
                            }
                        }
                    }
                    this.data10.push({colName: '0-12-34-5', nums: data.sort((a,b)=>{return parseInt(a) - parseInt(b);})});
                    this.loading10 = false;

                } else {
                    setTimeout(this.loadCombine, 1000);
                }
            },
            setupData1(result, data) {
                result = result[0];
                result.numArr0 = [];
                result.numArr12 = [];
                result.numArr34 = [];
                result.numArr5Plus = [];
                result.infos.map(info => {
                    switch (info.count) {
                        case 0:
                            result.numArr0.push(info.num);
                            break;
                        case 1:
                        case 2:
                            result.numArr12.push(info.num);
                            break;
                        case 3:
                        case 4:
                            result.numArr34.push(info.num);
                            break;
                        default:
                            result.numArr5Plus.push(info.num);
                    }
                });

                data.push({colName: '0次', nums: result.numArr0});
                data.push({colName: '1-2次', nums: result.numArr12});
                data.push({colName: '3-4次', nums: result.numArr34});
                data.push({colName: '5次+', nums: result.numArr5Plus});

                return result;
            },
            setupData2(result, data) {
                result = result[0];
                result.numArr0 = [];
                result.numArr1 = [];
                result.numArr2Plus = [];
                result.infos.map(info => {
                    switch (info.count) {
                        case 0:
                            result.numArr0.push(info.num);
                            break;
                        case 1:
                            result.numArr1.push(info.num);
                            break;
                        default:
                            result.numArr2Plus.push(info.num);
                    }
                });

                data.push({colName: '0次', nums: result.numArr0});
                data.push({colName: '1次', nums: result.numArr1});
                data.push({colName: '2次+', nums: result.numArr2Plus});

                return result;
            }
        },
        created() {
            this.loadData();
        }
    }
</script>
