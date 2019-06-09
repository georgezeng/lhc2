<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <Card>
        <p slot="title">
            <Icon type="ios-stats-outline"/>
            {{tables}}表次数/颜色遗值表
        </p>
        <Table class="times-colors" style="float:left; width: 30%;" stripe border size="small" :loading="loading1"
               :columns="columns1" :data="data1"/>
        <Table class="times-colors" style="float:left; width: 70%;" stripe border size="small" :loading="loading2"
               :columns="columns2" :data="data2"/>
        <div style="clear:both;"></div>
        <div class="page">
            <Page :total="total"
                  :page-size="queryInfo.page.size"
                  :current="queryInfo.page.num"
                  @on-change="changePage"/>
        </div>
        <div style="clear:both;"></div>
    </Card>
</template>
<script>
    import API from '../../libs/api';

    export default {
        props: [
            'tables',
            'type'
        ],
        data() {
            const self = this;
            return {
                loading1: true,
                loading2: true,
                data1: [],
                data2: [],
                queryInfo: {
                    page: {
                        num: 1,
                        size: 100,
                        property: 'phase',
                        order: 'DESC'
                    }
                },
                total: 0,
                columns1: [
                    {
                        title: '期数',
                        width: 120,
                        key: 'phase'
                    },
                    {
                        title: '特码',
                        width: 50,
                        key: 'num'
                    },
                    {
                        title: '0次/3+次',
                        width: 80,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.time03Plus;
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
                        width: 80,
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
                        title: '2+次',
                        width: 80,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.time2Plus;
                            if (data == 0) {
                                style['background-color'] = 'red';
                                style['color'] = 'white';
                                style['font-weight'] = 'bold';
                            }
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '',
                        render(h, params) {
                            return h('span', {}, '');
                        }
                    }
                ],
                columns2: [
                    {
                        title: '绿8',
                        width: 80,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.g8;
                            const color = params.row.g8Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '绿7',
                        width: 80,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.g7;
                            const color = params.row.g7Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '绿6',
                        width: 80,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.g6;
                            const color = params.row.g6Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '绿5',
                        width: 60,
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
                        width: 60,
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
                        width: 60,
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
                        width: 60,
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
                        width: 60,
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
                        width: 20,
                        render(h, params) {
                            return h('span', {}, '');
                        }
                    },
                    {
                        title: '红绿',
                        width: 55,
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
                        width: 20,
                        render(h, params) {
                            return h('span', {}, '');
                        }
                    },
                    {
                        title: '红1',
                        width: 60,
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
                        width: 60,
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
                        width: 60,
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
                        width: 60,
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
                        width: 60,
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
                        title: '红6',
                        width: 80,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.r6;
                            const color = params.row.r6Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '红7',
                        width: 80,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.r7;
                            const color = params.row.r7Color;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '红8',
                        width: 80,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.r8;
                            const color = params.row.r8Color;
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
                        render(h, params) {
                            return h('span', {});
                        }
                    },
                ]
            }
        },

        methods: {
            changePage(pageNo) {
                this.queryInfo.page.num = pageNo;
                this.loadData();
            },
            loadData(e) {
                this.loading1 = true;
                this.loading2 = true;
                API.getLhc3Times(this.tables, this.type, this.queryInfo).then(result => {
                    this.loading1 = false;
                    if (e) {
                        e.target.scrollingElement.scrollTop -= 1000
                    }
                    // this.data1 = this.data1.concat(result.list);
                    this.data1 = result.list
                    this.total = result.total
                }).catch(e => {
                    this.loading1 = false;
                });
                API.getLhc3Colors(this.tables, this.type, this.queryInfo).then(result => {
                    this.loading2 = false;
                    // this.data2 = this.data2.concat(result.list);
                    this.data2 = result.list
                }).catch(e => {
                    this.loading2 = false;
                });
            },
            scrollHandler(e) {
                if(document.body.scrollHeight - e.target.scrollingElement.scrollTop < 1000) {
                    this.queryInfo.page.num++;
                    this.loadData(e);
                }
            }
        },
        mounted() {
            this.loadData();
            // window.addEventListener('scroll', this.scrollHandler)
        },
        destroyed() {
            // window.removeEventListener('scroll', this.scrollHandler)
        }
    }
</script>
