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
                        数据统计
                    </p>
                    <Table stripe border size="small" :loading="loading" :columns="columns" :data="data"/>
                </Card>
            </Content>
            <Footer/>
        </Layout>
    </div>
</template>
<script>
    import Menus from './index/menus.vue';
    import Footer from './index/footer.vue';
    import API from '../libs/api';

    export default {
        components: {
            Menus,
            Footer
        },
        data() {
            const self = this;
            return {
                loading: true,
                data: [],
                columns: [
                    {
                        title: '次数',
                        width: 50,
                        key: 'count'
                    },
                    {
                        title: '号码',
                        minWidth: 300,
                        render(h, params) {
                            return h('span', {}, params.row.nums.join(' '));
                        }
                    },
                ]
            }
        },
        methods: {
            loadData() {
                API.getStats().then(data => {
                    this.loading = false;
                    this.data = data || [];
                });
            }
        },
        created() {
            this.loadData();
        }
    }
</script>
