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
                    <Table stripe border size="small" :loading="loading3" :columns="columns2" :data="data3"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        16表选号
                    </p>
                    <Table stripe border size="small" :loading="loading4" :columns="columns2" :data="data4"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        14表选号
                    </p>
                    <Table stripe border size="small" :loading="loading5" :columns="columns2" :data="data5"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        10表选号
                    </p>
                    <Table stripe border size="small" :loading="loading6" :columns="columns2" :data="data6"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        9表选号
                    </p>
                    <Table stripe border size="small" :loading="loading7" :columns="columns2" :data="data7"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        4表选号
                    </p>
                    <Table stripe border size="small" :loading="loading8" :columns="columns2" :data="data8"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        19表/14表选号-合并
                    </p>
                    <Table stripe border size="small" :loading="loading9" :columns="columns2" :data="data9"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        16表/9表选号-合并
                    </p>
                    <Table stripe border size="small" :loading="loading10" :columns="columns2" :data="data10"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        19表/4表选号-合并
                    </p>
                    <Table stripe border size="small" :loading="loading11" :columns="columns2" :data="data11"/>
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
                loading11: true,
                dataFor19: [],
                dataFor16: [],
                dataFor9: [],
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
                data11: [],
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
                this.changePage(1, 19, () => {
                    this.data3 = [];
                    return this.data3
                }, () => this.loading3 = true, () => this.loading3 = false);
                this.changePage(1, 16, () => {
                    this.data4 = [];
                    return this.data4
                }, () => this.loading4 = true, () => this.loading4 = false);
                this.changePage(1, 14, () => {
                    this.data5 = [];
                    return this.data5
                }, () => this.loading5 = true, () => this.loading5 = false);
                this.changePage(1, 10, () => {
                    this.data6 = [];
                    return this.data6
                }, () => this.loading6 = true, () => this.loading6 = false);
                this.changePage(1, 9, () => {
                    this.data7 = [];
                    return this.data7
                }, () => this.loading7 = true, () => this.loading7 = false);
                this.changePage(1, 4, () => {
                    this.data8 = [];
                    return this.data8
                }, () => this.loading8 = true, () => this.loading8 = false);
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
                            this.dataFor4 = this.setupData2(result.list, initData());
                            break;
                        case 9:
                            this.dataFor9 = this.setupData2(result.list, initData());
                            break;
                        case 14:
                            this.dataFor14 = this.setupData3(result.list, initData());
                            breakreak;
                        case 16:
                            this.dataFor16 = this.setupData1(result.list, initData());
                            break;
                        case 19:
                            this.dataFor19 = this.setupData3(result.list, initData());
                            break;
                        default: {
                            this.setupData1(result.list, initData());
                        }
                    }
                });
            },
            loadCombine() {
                function loadNum(numArr, nums) {
                    if(numArr && numArr.length > 0) {
                        for(let i = 0; i < numArr.length; i++) {
                            nums.push(numArr[i]);
                        }
                    }
                }

                function loadData(numsForA, numsForB) {
                    const data = [];
                    for(let i = 0; i < numsForA.length; i++) {
                        const numInA = this.numsForA[i];
                        for(let j = 0; j < numsForB.length; j++) {
                            const numInB = this.numsForB[j];
                            if(numInA == numInB) {
                                data.push(numInA);
                                break;
                            }
                        }
                    }
                    return data;
                }

                const numsFor19_14 = [];
                loadNum(this.dataFor19.numArr0, numsFor19_14);
                loadNum(this.dataFor19.numArr1, numsFor19_14);
                loadNum(this.dataFor19.numArr2, numsFor19_14);

                const numsFor14 = [];
                loadNum(this.dataFor14.numArr1, numsFor14);
                loadNum(this.dataFor14.numArr2, numsFor14);
                loadNum(this.dataFor14.numArr3Plus, numsFor14);

                this.data9.push({colName: '012-123+', nums: loadData(numsFor19_14, numsFor14)});
                this.loading9 = false;

                const numsFor16 = [];
                loadNum(this.dataFor16.numArr12, numsFor16);
                loadNum(this.dataFor16.numArr34, numsFor16);
                loadNum(this.dataFor16.numArr5Plus, numsFor16);

                const numsFor9 = [];
                loadNum(this.dataFor9.numArr0, numsFor9);
                loadNum(this.dataFor9.numArr1, numsFor9);

                this.data10.push({colName: '12345+-01', nums: loadData(numsFor16, numsFor9)});
                this.loading10 = false;

                const numsFor19_4 = [];
                loadNum(this.dataFor19.numArr1, numsFor19_4);
                loadNum(this.dataFor19.numArr2, numsFor19_4);
                loadNum(this.dataFor19.numArr3T5, numsFor19_4);

                const numsFor4 = [];
                loadNum(this.dataFor4.numArr0, numsFor4);

                this.data11.push({colName: '12345-0', nums: loadData(numsFor19_4, numsFor4)});
                this.loading11 = false;
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
            },
            setupData3(result, data) {
                result = result[0];
                result.numArr0 = [];
                result.numArr1 = [];
                result.numArr2 = [];
                result.numArr3T5 = [];
                result.numArr3Plus = [];
                result.infos.map(info => {
                    switch (info.count) {
                        case 0:
                            result.numArr0.push(info.num);
                            break;
                        case 1:
                            result.numArr1.push(info.num);
                            break;
                        case 2:
                            result.numArr2.push(info.num);
                            break;
                        case 3:
                        case 4:
                        case 5:
                            result.numArr3T5.push(info.num);
                        default:
                            result.numArr3Plus.push(info.num);
                    }
                });

                data.push({colName: '0次', nums: result.numArr0});
                data.push({colName: '1次', nums: result.numArr1});
                data.push({colName: '2次', nums: result.numArr2});
                data.push({colName: '3-5次', nums: result.numArr3T5});
                data.push({colName: '3次+', nums: result.numArr3Plus});

                return result;
            }
        },
        created() {
            this.loadData();
        }
    }
</script>
