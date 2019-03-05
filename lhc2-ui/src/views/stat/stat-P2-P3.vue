<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="stat-P2-P3"/>
            </Header>
            <Content class="content">
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        类型2: 16表(1+次) - 类型3: 16表(0次 + 3+次)
                    </p>
                    <Table stripe border size="small" :loading="loading1" :columns="columns" :data="data1"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        类型2: 16表(1+次) - 类型3: 16表(1+次)
                    </p>
                    <Table stripe border size="small" :loading="loading2" :columns="columns" :data="data2"/>
                </Card>
                <br/>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        类型3: 4(0次) - 类型2: 16表(1+次)
                    </p>
                    <Table stripe border size="small" :loading="loading3" :columns="columns" :data="data3"/>
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
                data1: [],
                data2: [],
                data3: [],
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
                this.loading1 = true;
                API.getPickNums({
                    data: {
                        expected: 16,
                        type: "P2"
                    },
                    page: this.queryInfo.page
                }).then(result1 => {
                    API.getPickNums({
                        data: {
                            expected: 16,
                            type: "P3"
                        },
                        page: this.queryInfo.page
                    }).then(result2 => {
                        this.loading1 = false;
                        let includeArr = [];
                        let r1 = result1.list[0];
                        let r2 = result2.list[0];
                        r1.infos.map(info1 => {
                            if (info1.count > 0) {
                                out: for (let i = 0; i < r2.infos.length; i++) {
                                    let info2 = r2.infos[i];
                                    if (info1.num == info2.num) {
                                        switch (info2.count) {
                                            case 1:
                                            case 2: break;
                                            default:
                                                if (!includeArr.includes(info2.num)) {
                                                    includeArr.push(info2.num);
                                                }
                                                break out;
                                        }
                                    }
                                }
                            }
                        });
                        // let arr = [];
                        // r1.infos.map(info1 => {
                        //     if (info1.count == 0) {
                        //         if (!excludeArr.includes(info1.num)) {
                        //             arr.push(info1.num);
                        //         }
                        //     }
                        // });
                        this.data1 = [{colName: '交集', nums: includeArr}];
                    });
                });

                this.loading2 = true;
                API.getPickNums({
                    data: {
                        expected: 16,
                        type: "P2"
                    },
                    page: this.queryInfo.page
                }).then(result1 => {
                    API.getPickNums({
                        data: {
                            expected: 16,
                            type: "P3"
                        },
                        page: this.queryInfo.page
                    }).then(result2 => {
                        this.loading2 = false;
                        let includeArr = [];
                        let r1 = result1.list[0];
                        let r2 = result2.list[0];
                        r1.infos.map(info1 => {
                            if (info1.count > 0) {
                                out: for (let i = 0; i < r2.infos.length; i++) {
                                    let info2 = r2.infos[i];
                                    if (info1.num == info2.num) {
                                        switch (info2.count) {
                                            case 0: break;
                                            default:
                                                if (!includeArr.includes(info2.num)) {
                                                    includeArr.push(info2.num);
                                                }
                                                break out;
                                        }
                                    }
                                }
                            }
                        });
                        // let arr = [];
                        // r1.infos.map(info1 => {
                        //     if (info1.count == 0) {
                        //         if (!excludeArr.includes(info1.num)) {
                        //             arr.push(info1.num);
                        //         }
                        //     }
                        // });
                        this.data2 = [{colName: '交集', nums: includeArr}];
                    });
                });

                this.loading3 = true;
                API.getPickNums({
                    data: {
                        expected: 4,
                        type: "P3"
                    },
                    page: this.queryInfo.page
                }).then(result1 => {
                    API.getPickNums({
                        data: {
                            expected: 16,
                            type: "P2"
                        },
                        page: this.queryInfo.page
                    }).then(result2 => {
                        this.loading3 = false;
                        let includeArr = [];
                        let r1 = result1.list[0];
                        let r2 = result2.list[0];
                        r1.infos.map(info1 => {
                            if (info1.count > 0) {
                                out: for (let i = 0; i < r2.infos.length; i++) {
                                    let info2 = r2.infos[i];
                                    if (info1.num == info2.num) {
                                        switch (info2.count) {
                                            case 0: break;
                                            default:
                                                if (!includeArr.includes(info2.num)) {
                                                    includeArr.push(info2.num);
                                                }
                                                break out;
                                        }
                                    }
                                }
                            }
                        });
                        // let arr = [];
                        // r1.infos.map(info1 => {
                        //     if (info1.count == 0) {
                        //         if (!excludeArr.includes(info1.num)) {
                        //             arr.push(info1.num);
                        //         }
                        //     }
                        // });
                        this.data3 = [{colName: '交集', nums: includeArr}];
                    });
                });
            }
        },
        created() {
            this.loadData();
        }
    }
</script>
