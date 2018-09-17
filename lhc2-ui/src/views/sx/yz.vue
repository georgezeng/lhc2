<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="sxyz"/>
            </Header>
            <Content class="content">
                <Card>
                    <p slot="title">
                        <Icon type="ios-albums-outline"/>
                        生肖遗值
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
                        renderHeader(h, col) {
                            return h('span', {
                                class: 'table-header-title'
                            }, '鼠')
                        },
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.shu;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        renderHeader(h, col) {
                            return h('span', {
                                class: 'table-header-title'
                            }, '牛')
                        },
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.niu;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                            style['color'] = 'white';
                        }
                    },
                    {
                        renderHeader(h, col) {
                            return h('span', {
                                class: 'table-header-title'
                            }, '虎')
                        },
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.hu;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        renderHeader(h, col) {
                            return h('span', {
                                class: 'table-header-title'
                            }, '兔')
                        },
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.tu;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        renderHeader(h, col) {
                            return h('span', {
                                class: 'table-header-title'
                            }, '龙')
                        },
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.lonng;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        renderHeader(h, col) {
                            return h('span', {
                                class: 'table-header-title'
                            }, '蛇')
                        },
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.she;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        renderHeader(h, col) {
                            return h('span', {
                                class: 'table-header-title'
                            }, '马')
                        },
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.ma;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        renderHeader(h, col) {
                            return h('span', {
                                class: 'table-header-title'
                            }, '羊')
                        },
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.yang;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        renderHeader(h, col) {
                            return h('span', {
                                class: 'table-header-title'
                            }, '猴')
                        },
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.hou;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        renderHeader(h, col) {
                            return h('span', {
                                class: 'table-header-title'
                            }, '鸡')
                        },
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.ji;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        renderHeader(h, col) {
                            return h('span', {
                                class: 'table-header-title'
                            }, '狗')
                        },
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.gou;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        renderHeader(h, col) {
                            return h('span', {
                                class: 'table-header-title'
                            }, '猪')
                        },
                        minWidth: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zhu;
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
                API.getYzList('sx').then(data => {
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
