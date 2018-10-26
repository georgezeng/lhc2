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
                data1: [],
                data2: [],
                data3: [],
                data4: [],
                data5: [],
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
                    this.setupData(result.list, initData());
                });
            },
            setupData(result, data) {
                // result.map(item => {
                //
                // });
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
            },
        },
        created() {
            this.loadData();
        }
    }
</script>
