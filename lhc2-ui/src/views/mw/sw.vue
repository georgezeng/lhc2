<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="mxzf"/>
            </Header>
            <Content class="content">
                <Card>
                    <p slot="title">
                        <Icon type="ios-albums-outline"/>
                        末位顺位
                    </p>
                    <Table stripe border size="small" :loading="loading" :columns="columns" :data="data"/>
                </Card>
            </Content>
            <Footer/>
        </Layout>
    </div>
</template>
<script>
    import Menus from '../index/menus.vue';
    import Footer from '../index/footer.vue';
    import API from '../../libs/api';

    export default {
        components: {
            Menus,
            Footer
        },
        data() {
            const self = this;
            const cols = [];
            for(let i = 1; i < 10; i++) {
                cols.push({
                    title: '位' + i,
                    width: 60,
                    render(h, params) {
                        const style = {};
                        style['padding'] = '10px';
                        const data = params.row[`sw${i}`];
                        if (data == 0) {
                            style['background-color'] = 'red';
                            style['color'] = 'white';
                        }
                        return h('span', {style}, data);
                    }
                });
            }
            return {
                loading: true,
                data: [],
                columns: [
                    {
                        title: '期数',
                        width: 60,
                        key: 'phase',
                    },
                    {
                        title: '特码',
                        width: 60,
                        render(h, params) {
                            return h('span', {}, `${params.row.num} (位${params.row.pos})`);
                        }
                    },
                    ...cols,
                    {
                        title: '顺位10',
                        minWidth: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.sw10;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    }
                ]
            }
        },
        methods: {
            loadData() {
                API.getSwList('mw').then(data => {
                    this.loading = false;
                    this.data = data;
                }).catch(ex => {
                    this.loading = false;
                });
            }
        },
        created() {
            this.loadData();
        }
    }
</script>
