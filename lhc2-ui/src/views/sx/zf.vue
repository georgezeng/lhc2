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
                        生肖振幅
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
                        title: '振幅0',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf0;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '振幅1',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf1;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                            style['color'] = 'white';
                        }
                    },
                    {
                        title: '振幅2',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf2;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '振幅3',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf3;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '振幅4',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf4;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '振幅5',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf5;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '振幅6',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf6;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '振幅7',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf7;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '振幅8',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf8;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '振幅9',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf9;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '振幅10',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf10;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '振幅11',
                        minWidth: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf11;
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
                API.getZfList('sx').then(data => {
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
