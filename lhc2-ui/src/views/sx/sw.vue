<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="sxzf"/>
            </Header>
            <Content class="content">
                <Card>
                    <p slot="title">
                        <Icon type="ios-albums-outline"/>
                        生肖顺位
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
                            return h('span', {}, `${params.row.num} (${params.row.sx.text})`);
                        }
                    },
                    {
                        title: '顺位1',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.sw1;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, `${data} (${params.row.sw1sx.text})`);
                        }
                    },
                    {
                        title: '顺位2',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.sw2;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, `${data} (${params.row.sw2sx.text})`);
                        }
                    },
                    {
                        title: '顺位3',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.sw3;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, `${data} (${params.row.sw3sx.text})`);
                        }
                    },
                    {
                        title: '顺位4',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.sw4;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, `${data} (${params.row.sw4sx.text})`);
                        }
                    },
                    {
                        title: '顺位5',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.sw5;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, `${data} (${params.row.sw5sx.text})`);
                        }
                    },
                    {
                        title: '顺位6',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.sw6;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, `${data} (${params.row.sw6sx.text})`);
                        }
                    },
                    {
                        title: '顺位7',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.sw7;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, `${data} (${params.row.sw7sx.text})`);
                        }
                    },
                    {
                        title: '顺位8',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.sw8;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, `${data} (${params.row.sw8sx.text})`);
                        }
                    },
                    {
                        title: '顺位9',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.sw9;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, `${data} (${params.row.sw9sx.text})`);
                        }
                    },
                    {
                        title: '顺位10',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.sw10;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, `${data} (${params.row.sw10sx.text})`);
                        }
                    },
                    {
                        title: '顺位11',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.sw11;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, `${data} (${params.row.sw11sx.text})`);
                        }
                    },
                    {
                        title: '顺位12',
                        minWidth: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.sw12;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, `${data} (${params.row.sw12sx.text})`);
                        }
                    },
                ]
            }
        },
        methods: {
            loadData() {
                API.getSxswList().then(data => {
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
