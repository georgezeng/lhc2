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
                            小大单双1-遗值
                        </p>
                        <Table stripe border size="small" :loading="loading1" :columns="columns1" :data="data1"/>
                    </Card>
                    <br/>
                    <Card>
                        <p slot="title">
                            <Icon type="ios-albums-outline"/>
                            小大单双2-遗值
                        </p>
                        <Table stripe border size="small" :loading="loading2" :columns="columns2" :data="data2"/>
                    </Card>
                    <br/>
                    <Card>
                        <p slot="title">
                            <Icon type="ios-albums-outline"/>
                            小大单双2-振幅
                        </p>
                        <Table stripe border size="small" :loading="loading3" :columns="columns3" :data="data3"/>
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
                if (data == 0) {
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
                    }
                ],
                columns2: [
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
                        minWidth: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'largeEven');
                        }
                    }
                ],
                columns3: [
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
                        title: '小单',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'zf0');
                        }
                    },
                    {
                        title: '小双',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'zf1');
                        }
                    },
                    {
                        title: '大单',
                        width: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'zf2');
                        }
                    },
                    {
                        title: '大双',
                        minWidth: 60,
                        render(h, params) {
                            return renderColumn(h, params, 'zf3');
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
                    this.data3 = data;
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
