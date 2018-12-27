<style scoped>
    @import "../../styles/common.less";
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
                        18表选号
                    </p>
                    <Table stripe border size="small" :loading="loading3" :columns="columns2" :data="data3"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        12表选号
                    </p>
                    <Table stripe border size="small" :loading="loading4" :columns="columns2" :data="data4"/>
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
                loading3: true,
                loading4: true,
                data3: [],
                data4: [],
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
                this.changePage(1, 18, () => {
                    this.data3 = [];
                    return this.data3
                }, () => this.loading3 = true, () => this.loading3 = false);
                this.changePage(1, 12, () => {
                    this.data4 = [];
                    return this.data4
                }, () => this.loading4 = true, () => this.loading4 = false);
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
                    this.setupData1(result.list, initData());
                });
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
                        default:
                            result.numArr3Plus.push(info.num);
                    }
                });

                data.push({colName: '0次', nums: result.numArr0});
                data.push({colName: '1次', nums: result.numArr1});
                data.push({colName: '2次', nums: result.numArr2});
                data.push({colName: '3次+', nums: result.numArr3Plus});

                return result;
            }
        },
        created() {
            this.loadData();
        }
    }
</script>
