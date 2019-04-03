<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="lhc3-tm"/>
            </Header>
            <Content class="content">
                <Card>
                    <p slot="title" style="height: 35px;">
                        <Icon type="ios-albums-outline"/>
                        特码管理
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
    import Menus from '../index/lhc3-menus.vue';
    import Footer from '../index/footer.vue';
    import API from '../../libs/api';

    export default {
        components: {
            Menus,
            Footer
        },
        data() {
            const self = this;
            return {
                loading: true,
                queryInfo: {
                    page: {
                        num: 1,
                        size: 20,
                        property: 'phase',
                        order: 'DESC'
                    }
                },
                total: 0,
                data: [],
                columns: [
                    {
                        title: '期数',
                        width: 150,
                        key: 'phase'
                    },
                    {
                        title: '号码',
                        key: 'num'
                    }
                ]
            }
        },
        methods: {
            loadData() {
                this.loading = true;
                API.getLhc3TmList(this.queryInfo).then(data => {
                    this.loading = false;
                    this.data = data.list;
                    this.total = data.total;
                }).catch(ex => {
                    this.loading = false;
                });
            },
            changePage(pageNo) {
                this.queryInfo.page.num = pageNo;
                this.loadData();
            },
        },
        mounted() {
            this.loadData();
        }
    }
</script>
