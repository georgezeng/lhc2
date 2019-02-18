<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="stat-P2"/>
            </Header>
            <Content class="content">
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        2表选号
                    </p>
                    <Table stripe border size="small" :loading="loading1" :columns="columns" :data="data1"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        4表选号
                    </p>
                    <Table stripe border size="small" :loading="loading2" :columns="columns" :data="data2"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        8表选号
                    </p>
                    <Table stripe border size="small" :loading="loading3" :columns="columns" :data="data3"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        10表选号
                    </p>
                    <Table stripe border size="small" :loading="loading4" :columns="columns" :data="data4"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        12表选号
                    </p>
                    <Table stripe border size="small" :loading="loading5" :columns="columns" :data="data5"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        16表选号
                    </p>
                    <Table stripe border size="small" :loading="loading6" :columns="columns" :data="data6"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        20表选号
                    </p>
                    <Table stripe border size="small" :loading="loading7" :columns="columns" :data="data7"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        24表选号
                    </p>
                    <Table stripe border size="small" :loading="loading8" :columns="columns" :data="data8"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        33表选号
                    </p>
                    <Table stripe border size="small" :loading="loading9" :columns="columns" :data="data9"/>
                </Card>
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
                loading1: true,
                loading2: true,
                loading3: true,
                loading4: true,
                loading5: true,
                loading6: true,
                loading7: true,
                loading8: true,
                loading9: true,
                data1: [],
                data2: [],
                data3: [],
                data4: [],
                data5: [],
                data6: [],
                data7: [],
                data8: [],
                data9: [],
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
            loadData() {
                this.changePage(1, 2, () => {
                    this.data1 = [];
                    return this.data1
                }, () => this.loading1 = true, () => this.loading1 = false);
                this.changePage(1, 4, () => {
                    this.data2 = [];
                    return this.data2
                }, () => this.loading2 = true, () => this.loading2 = false);
                this.changePage(1, 8, () => {
                    this.data3 = [];
                    return this.data3
                }, () => this.loading3 = true, () => this.loading3 = false);
                this.changePage(1, 10, () => {
                    this.data4 = [];
                    return this.data4
                }, () => this.loading4 = true, () => this.loading4 = false);
                this.changePage(1, 12, () => {
                    this.data5 = [];
                    return this.data5
                }, () => this.loading5 = true, () => this.loading5 = false);
                this.changePage(1, 16, () => {
                    this.data6 = [];
                    return this.data6
                }, () => this.loading6 = true, () => this.loading6 = false);
                this.changePage(1, 20, () => {
                    this.data7 = [];
                    return this.data7
                }, () => this.loading7 = true, () => this.loading7 = false);
                this.changePage(1, 24, () => {
                    this.data8 = [];
                    return this.data8
                }, () => this.loading8 = true, () => this.loading8 = false);
                this.changePage(1, 33, () => {
                    this.data9 = [];
                    return this.data9
                }, () => this.loading9 = true, () => this.loading9 = false);
            },
            changePage(pageNo, expected, initData, startLoading, stopLoading) {
                startLoading();
                API.getPickNums({
                    data: {
                        expected,
                        type: "P2"
                    },
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
                result = result[0];
                result.numArr0 = [];
                result.numArr123 = [];
                result.numArr4Plus = [];
                result.infos.map(info => {
                    switch (info.count) {
                        case 0:
                            result.numArr0.push(info.num);
                            break;
                        case 1:
                        case 2:
                        case 3:
                            result.numArr123.push(info.num);
                            break;
                        default:
                            result.numArr4Plus.push(info.num);
                    }
                });

                data.push({colName: '0次', nums: result.numArr0});
                data.push({colName: '1-3次', nums: result.numArr123});
                data.push({colName: '4次+', nums: result.numArr4Plus});

                return result;
            }
        },
        created() {
            this.loadData();
        }
    }
</script>
