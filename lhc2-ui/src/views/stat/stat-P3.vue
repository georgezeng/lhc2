<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="stat-P3"/>
            </Header>
            <Content class="content">
                <Table stripe border size="small" :loading="loading1" :columns="columns" :data="data1"/>
                <Table stripe border size="small" :loading="loading2" :columns="columns" :data="data2"/>
                <Table stripe border size="small" :loading="loading3" :columns="columns" :data="data3"/>
                <!--<br/>-->
                <!--<Card>-->
                <!--<p slot="title">-->
                <!--<Icon type="ios-stats-outline"/>-->
                <!--3表选号-->
                <!--</p>-->
                <!--<Table stripe border size="small" :loading="loading2" :columns="columns" :data="data2"/>-->
                <!--</Card>-->
                <!--<Card>-->
                <!--<p slot="title">-->
                <!--<Icon type="ios-stats-outline"/>-->
                <!--4表选号-->
                <!--</p>-->
                <!--<Table stripe border size="small" :loading="loading3" :columns="columns" :data="data3"/>-->
                <!--</Card>-->
                <!--<br/>-->
                <!--<Card>-->
                <!--<p slot="title">-->
                <!--<Icon type="ios-stats-outline"/>-->
                <!--8表选号-->
                <!--</p>-->
                <!--<Table stripe border size="small" :loading="loading4" :columns="columns" :data="data4"/>-->
                <!--</Card>-->
                <!--<br/>-->
                <Table stripe border size="small" :loading="loading4" :columns="columns" :data="data4"/>
            </Content>
            <Footer/>
        </Layout>
    </div>
</template>
<script>
    import Menus from '../index/menus.vue';
    import Footer from '../index/footer.vue';
    import StatColumn from '../index/stat-column.vue';
    import API from '../../libs/api';

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
                        size: 1,
                        property: 'phase',
                        order: 'DESC'
                    }
                },
                count: 0,
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
                columns: [
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
            sub1() {
                const t12 = this.data4[1].nums
                const t1 = this.data1[0].nums
                const arr = []
                for(let i in t12) {
                    let found = false
                    for(let j in t1) {
                        if(t1[j] == t12[i]) {
                            found = true
                            break
                        }
                    }
                    if(!found) {
                        arr.push(t12[i])
                    }
                }
                this.data1.push({colName: '1/2次 - 1+次', nums: arr})
            },
            sub2() {
                const t12 = this.data4[1].nums
                const t1 = this.data2[0].nums
                const arr = []
                for(let i in t12) {
                    let found = false
                    for(let j in t1) {
                        if(t1[j] == t12[i]) {
                            found = true
                            break
                        }
                    }
                    if(!found) {
                        arr.push(t12[i])
                    }
                }
                this.data2.push({colName: '1/2次 - 1+次', nums: arr})
            },
            sub3() {
                const t12 = this.data4[1].nums
                const t1 = this.data3[0].nums
                const arr = []
                for(let i in t12) {
                    let found = false
                    for(let j in t1) {
                        if(t1[j] == t12[i]) {
                            found = true
                            break
                        }
                    }
                    if(!found) {
                        arr.push(t12[i])
                    }
                }
                this.data3.push({colName: '1/2次 - 1+次', nums: arr})
            },
            loadData() {
                this.changePage(1, 1, () => {
                    this.data1 = [];
                    return this.data1
                }, () => this.loading1 = true, () => this.loading1 = false, 2);
                this.changePage(1, 2, () => {
                    this.data2 = [];
                    return this.data2
                }, () => this.loading2 = true, () => this.loading2 = false, 2);
                this.changePage(1, 3, () => {
                    this.data3 = [];
                    return this.data3
                }, () => this.loading3 = true, () => this.loading3 = false, 2);
                this.changePage(1, 12, () => {
                    this.data4 = [];
                    return this.data4
                }, () => this.loading4 = true, () => this.loading4 = false, 1);
            },
            changePage(pageNo, expected, initData, startLoading, stopLoading, type) {
                startLoading();
                API.getPickNums({
                    data: {
                        expected,
                        type: "P3"
                    },
                    page: {
                        num: pageNo,
                        size: this.queryInfo.page.size,
                        property: this.queryInfo.page.property,
                        order: this.queryInfo.page.order
                    }
                }).then(result => {
                    stopLoading();
                    if (type == 1) {

                        this.setupData1(result.list, initData());
                    } else {
                        this.setupData2(result.list, initData(), expected);
                    }
                    this.count++;
                });
            },
            setupData1(result, data) {
                result = result[0];
                result.numArr0 = [];
                result.numArr12 = [];
                result.numArr3Plus = [];
                result.infos.map(info => {
                    switch (info.count) {
                        case 0:
                            result.numArr0.push(info.num);
                            break;
                        case 1:
                        case 2:
                            result.numArr12.push(info.num);
                            break;
                        default:
                            result.numArr3Plus.push(info.num);
                    }
                });

                data.push({colName: '0次', nums: result.numArr0});
                data.push({colName: '1-2次', nums: result.numArr12});
                data.push({colName: '3次+', nums: result.numArr3Plus});

                return result;
            },
            setupData2(result, data, expected) {
                result = result[0];
                result.numArr0 = [];
                result.numArr12 = [];
                result.numArr3Plus = [];
                result.infos.map(info => {
                    switch (info.count) {
                        case 0:
                            result.numArr0.push(info.num);
                            break;
                        default:
                            result.numArr12.push(info.num);
                            break;
                        // default:
                        //     result.numArr3Plus.push(info.num);
                    }
                });

                // data.push({colName: '0次', nums: result.numArr0});
                data.push({colName: '4-' + expected + '表选号', nums: result.numArr12});
                // data.push({colName: '3次+', nums: result.numArr3Plus});

                return result;
            },
            initLoad() {
                if(this.count == 4) {
                    this.sub1()
                    this.sub2()
                    this.sub3()
                } else {
                    setTimeout(this.initLoad, 1000)
                }
            }
        },

        created() {
            this.loadData();
            this.initLoad();
        }
    }
</script>
