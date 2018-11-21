<template>
    <div>
        <div class="layout">
            <Layout>
                <Header class="menus">
                    <Menus :activeName="dxds"/>
                </Header>
                <Content class="content">
                    <Card>
                        <p slot="title">
                            <Icon type="ios-albums-outline"/>
                            小大单双1-遗值 / 小大单双2-遗值 / 小大单双2-振幅
                        </p>
                        <Table stripe border class="times-colors" size="small" style="float:left; width: 30%;"
                               :loading="loading1" :columns="columns1" :data="data1"/>
                        <Table stripe border class="times-colors" size="small" style="float:left; width: 30%;"
                               :loading="loading2" :columns="columns2" :data="data2"/>
                        <Table stripe border class="times-colors" size="small" style="float:left; width: 40%;"
                               :loading="loading3" :columns="columns3" :data="data3"/>
                        <div style="clear:both;"></div>
                    </Card>
                </Content>
                <Footer/>
            </Layout>
        </div>
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
            function renderColumn(h, params, field) {
                const style = {};
                style['padding'] = '10px';
                const data = params.row[`${field}`];
                if (data != null && data == 0) {
                    style['background-color'] = 'red';
                    style['color'] = 'white';
                    style['font-weight'] = 'bold';
                }
                return h('span', {style}, data);
            }

            return {
                loading1: true,
                loading2: true,
                loading3: true,
                data1: [],
                data2: [],
                data3: [],
                columns1: [
                    {
                        title: '期数',
                        width: 60,
                        key: 'phase'
                    },
                    {
                        title: '特码',
                        width: 60,
                        key: 'num'
                    },
                    {
                        title: '小',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'small');
                        }
                    },
                    {
                        title: '大',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'large');
                        }
                    },
                    {
                        title: '单',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'odd');
                        }
                    },
                    {
                        title: '双',
                        minWidth: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'even');
                        }
                    },
                    {
                        title: '',
                        minWidth: 30,
                        render(h, params) {
                            return h('span', {}, '');
                        }
                    }
                ],
                columns2: [
                    {
                        title: '小单',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'smallOdd');
                        }
                    },
                    {
                        title: '小双',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'smallEven');
                        }
                    },
                    {
                        title: '大单',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'largeOdd');
                        }
                    },
                    {
                        title: '大双',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'largeEven');
                        }
                    },
                    {
                        title: '红绿',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.rg;
                            if (data != null) {
                                style['background-color'] = params.row.rgColor;
                                style['color'] = 'white';
                                style['font-weight'] = 'bold';
                                return h('span', {style}, data);
                            } else {
                                return h('span', {style}, '');
                            }
                        }
                    },
                    {
                        title: '',
                        minWidth: 30,
                        render(h, params) {
                            return h('span', {}, '');
                        }
                    }
                ],
                columns3: [
                    {
                        title: '振0',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'zf0');
                        }
                    },
                    {
                        title: '振1',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'zf1');
                        }
                    },
                    {
                        title: '振2',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'zf2');
                        }
                    },
                    {
                        title: '振3',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'zf3');
                        }
                    },
                    {
                        title: '红绿',
                        width: 60,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.rg;
                            if (data != null) {
                                style['background-color'] = params.row.rgColor;
                                style['color'] = 'white';
                                style['font-weight'] = 'bold';
                                return h('span', {style}, data);
                            } else {
                                return h('span', {style}, '');
                            }
                        }
                    },
                    {
                        title: '',
                        minWidth: 30,
                        render(h, params) {
                            return h('span', {}, '');
                        }
                    }
                ],
            }
        },
        methods: {
            loadData() {
                API.getDxds1yz().then(data => {
                    this.loading1 = false;
                    this.data1 = data;
                }).catch(ex => {
                    this.loading1 = false;
                });
                API.getDxds2yz().then(data => {
                    this.loading2 = false;
                    this.data2 = data;
                }).catch(ex => {
                    this.loading2 = false;
                });
                API.getDxds2zf().then(data => {
                    this.loading3 = false;
                    this.data3 = [
                        {
                            zf0: null,
                            zf1: null,
                            zf2: null,
                            zf3: null
                        },
                        ...data
                    ];
                }).catch(ex => {
                    this.loading3 = false;
                });
            }
        },
        created() {
            this.loadData();
        }
    }
</script>
