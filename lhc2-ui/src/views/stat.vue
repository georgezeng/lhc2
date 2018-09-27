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
                    <Table stripe border size="small" :loading="loading1" :columns="columns" :data="data1"/>
                </Card>
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        非49-统计
                    </p>
                    <Table stripe border size="small" :loading="loading2" :columns="columns" :data="data2"/>
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
            Footer,

        },
        data() {
            const self = this;
            return {
                loading1: true,
                loading2: true,
                data1: [],
                data2: [],
                columns: [
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
            }
        },
        created() {
            this.loadData();
        }
    }
</script>
