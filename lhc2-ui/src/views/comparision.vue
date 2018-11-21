<style scoped>
    @import "../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="comparision"/>
            </Header>
            <Content class="content">
                <Card>
                    <p slot="title">
                        <Icon type="ios-stats-outline"/>
                        16表次数/颜色遗值表
                    </p>
                    <Table class="times-colors" style="float:left; width: 30%;" stripe border size="small" :loading="loading1"
                           :columns="columns1" :data="data1"/>
                    <Table class="times-colors" style="float:left; width: 70%;" stripe border size="small" :loading="loading2"
                           :columns="columns2" :data="data2"/>
                    <div style="clear:both;"></div>
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
                loading1: true,
                loading2: true,
                data1: [],
                data2: [],
                columns1: [
                    {
                        title: '期数',
                        width: 50,
                        key: 'phase'
                    },
                    {
                        title: '特码',
                        width: 50,
                        key: 'num'
                    },
                    {
                        title: '0次',
                        width: 50,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.time0;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                                style['font-weight'] = 'bold';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '1-2次',
                        width: 50,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.time12;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                                style['font-weight'] = 'bold';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '3次+',
                        width: 50,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.time3Plus;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                                style['font-weight'] = 'bold';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '振0',
                        width: 50,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf0;
                            if (data != null && data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                                style['font-weight'] = 'bold';
                            }
                            return h('span', {style}, data == null ? '' : data);
                        }
                    },
                    {
                        title: '振1',
                        width: 50,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf1;
                            if (data != null && data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                                style['font-weight'] = 'bold';
                            }
                            return h('span', {style}, data == null ? '' : data);
                        }
                    },
                    {
                        title: '振2',
                        width: 50,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.zf2;
                            if (data != null && data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                                style['font-weight'] = 'bold';
                            }
                            return h('span', {style}, data == null ? '' : data);
                        }
                    },
                    {
                        title: '',
                        minWidth: 30,
                        render(h, params) {
                            return h('span', {});
                        }
                    }
                ],
                columns2: [
                    {
                        title: '绿5',
                        width: 55,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.g5;
                            const color = params.row.g5Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '绿4',
                        width: 55,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.g4;
                            const color = params.row.g4Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '绿3',
                        width: 55,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.g3;
                            const color = params.row.g3Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '绿2',
                        width: 55,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.g2;
                            const color = params.row.g2Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '绿1',
                        width: 55,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.g1;
                            const color = params.row.g1Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '',
                        width: 30,
                        render(h, params) {
                            return h('span', {}, '');
                        }
                    },
                    {
                        title: '红绿',
                        width: 50,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.yz;
                            const color = params.row.yzColor;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '',
                        width: 30,
                        render(h, params) {
                            return h('span', {});
                        }
                    },
                    {
                        title: '红白',
                        width: 55,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.wr;
                            const color = params.row.wrColor;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '',
                        width: 30,
                        render(h, params) {
                            return h('span', {}, '');
                        }
                    },
                    {
                        title: '红1',
                        width: 55,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.r1;
                            const color = params.row.r1Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '红2',
                        width: 55,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.r2;
                            const color = params.row.r2Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '红3',
                        width: 55,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.r3;
                            const color = params.row.r3Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '红4',
                        width: 55,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.r4;
                            const color = params.row.r4Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '红5',
                        width: 55,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.r5;
                            const color = params.row.r5Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '',
                        minWidth: 30,
                        render(h, params) {
                            return h('span', {});
                        }
                    }
                ]
            }
        },
        methods: {
            loadData() {
                API.getTimes("16").then(data => {
                    this.loading1 = false;
                    this.data1 = data;
                    this.data1[0].zf0 = null;
                    this.data1[0].zf1 = null;
                    this.data1[0].zf2 = null;
                });
                API.getColors("16").then(data => {
                    this.loading2 = false;
                    this.data2 = data;
                });
            }
        },
        created() {
            this.loadData();
        }
    }
</script>
