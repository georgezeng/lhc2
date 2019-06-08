<style scoped>
    @import "../../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="lhc3-stat-P1"/>
            </Header>
            <Content class="content">
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                         类型6统计
                    </p>
                    <Table stripe border size="small" :loading="loading" :columns="columns" :data="data"/>
                    <div class="page">
                        <Page :total="total"
                              :page-size="queryInfo.page.size"
                              :current="queryInfo.page.num"
                              @on-change="changePage"/>
                    </div>
                    <div style="clear:both;"></div>
                </Card>
            </Content>
            <Footer/>
        </Layout>
    </div>
</template>
<script>
    import Menus from '../../index/lhc3-menus.vue';
    import Footer from '../../index/footer.vue';
    import API from '../../../libs/api';

    export default {
        components: {
            Menus,
            Footer
        },
        data() {
            const self = this;
            return {
                queryInfo: {
                    data: {
                        expected: 3,
                        type: 'P6'
                    },
                    page: {
                        num: 1,
                        size: 50,
                        property: 'phase',
                        order: 'DESC'
                    }
                },
                loading: true,
                data: [],
                total: 0,
                columns: [
                    {
                        title: '期数',
                        width: 120,
                        render(h, params) {
                            return h('span', {}, params.row.phase);
                        }
                    },
                    {
                        title: '0次',
                        minWidth: 350,
                        render(h, params) {
                            return h('span', {}, params.row.time0);
                        }
                    },
                    {
                        title: '1次',
                        minWidth: 350,
                        render(h, params) {
                            return h('span', {}, params.row.time1);
                        }
                    },
                    {
                        title: '2次',
                        width: 300,
                        render(h, params) {
                            return h('span', {}, params.row.time2);
                        }
                    },
                    {
                        title: '3+次',
                        width: 200,
                        render(h, params) {
                            return h('span', {}, params.row.time3Plus);
                        }
                    }
                ]
            }
        },
        methods: {
            loadData() {
                this.loading = true;
                API.getLhc3PickNums(this.queryInfo).then(result => {
                    this.data = result.list
                    this.total = result.total
                    this.loading = false;
                }).catch(e => {
                    this.loading = false;
                });
            },
            changePage(pageNo) {
                this.queryInfo.page.num = pageNo;
                this.loadData();
            }
        },
        mounted() {
            this.loadData();
        }
    }
</script>
