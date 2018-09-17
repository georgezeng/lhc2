<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="seqsw"/>
            </Header>
            <Content class="content">
                <Card>
                    <p slot="title">
                        <Icon type="ios-albums-outline"/>
                        十二区顺位
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
            const len = 13;
            for(let i = 1; i < len; i++) {
                const col = {
                    title: '顺位' + i,
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
                };
                if (i < len - 1) {
                    col.width = 60;
                } else {
                    col.minWidth = 60;
                }
                cols.push(col);
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
                    ...cols
                ]
            }
        },
        methods: {
            loadData() {
                API.getSwList('seq').then(data => {
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
