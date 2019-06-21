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
                         类型7-4表-3统计
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
                        type: 'P7'
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
                        title: '1+次',
                        minWidth: 700,
                        render(h, params) {
                            return h('span', {}, params.row.time0);
                        }
                    },
                    {
                        title: '(1-2)次 - 1+次',
                        minWidth: 350,
                        render(h, params) {
                            return h('span', {}, params.row.time1);
                        }
                    }
                ]
            }
        },
        methods: {
            loadData() {
                this.loading = true;
                this.queryInfo.data.expected = 3
                API.getLhc3PickNums(this.queryInfo).then(b1 => {
                    this.queryInfo.data.expected = 12
                    API.getLhc3PickNums(this.queryInfo).then(result => {
                        this.total = result.total
                        this.data = []
                        for (let i in result.list) {
                            const row = {}
                            row.phase = result.list[i].phase
                            const tempb12 = result.list[i]
                            let time12 = ''
                            if (tempb12.time1) {
                                time12 += tempb12.time1
                            }
                            if (tempb12.time2) {
                                time12 += ',' + tempb12.time2
                            }
                            time12 = time12.split(',')
                            const tempb1 = b1.list[i]
                            row.time0 = ''
                            if (tempb1.time1) {
                                row.time0 += tempb1.time1
                            }
                            if (tempb1.time2) {
                                row.time0 += ',' + tempb1.time2
                            }
                            if (tempb1.time3Plus) {
                                row.time0 += ',' + tempb1.time3Plus
                            }
                            const time1Plus = row.time0.split(',')
                            row.time1 = []
                            for (let j in time12) {
                                let found = false
                                for (let k in time1Plus) {
                                    if (time12[j] == time1Plus[k]) {
                                        found = true
                                        break
                                    }
                                }
                                if (!found) {
                                    row.time1.push(time12[j])
                                }
                            }
                            row.time1 = row.time1.join(',')
                            this.data.push(row)
                        }
                        this.loading = false;
                    }).catch(e => {
                        this.loading = false;
                    });


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
