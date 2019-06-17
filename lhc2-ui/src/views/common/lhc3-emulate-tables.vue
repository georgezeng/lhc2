<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <Card>
        <p slot="title">
            <Icon type="ios-stats-outline"/>
            {{tables}}表-{{suffix}} 模拟遗值表
        </p>
        <Table class="times-colors" style="float:left; width: 100%;" stripe border size="small" :loading="loading"
               :columns="columns" :data="data"/>
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
            'type',
            'suffix'
        ],
        data() {
            const self = this;
            return {
                loading: true,
                data: [],
                total: 0,
                queryInfo: {
                    page: {
                        num: 1,
                        size: 100,
                        property: 'phase',
                        order: 'DESC'
                    }
                },
                columns: [
                    {
                        title: '期数',
                        width: 120,
                        key: 'phase'
                    },
                    {
                        title: '红绿-红',
                        width: 80,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.yzr;
                            const color = params.row.yzrColor;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '红绿-绿',
                        width: 80,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.yzg;
                            const color = params.row.yzgColor;
                            style['background-color'] = color;
                            if (color != 'white') {
                                style['color'] = 'white';
                            }
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '红白-红',
                        width: 80,
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
                        title: '红绿-红-成本',
                        width: 100,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.yzrCost;
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '红绿-绿-成本',
                        width: 100,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.yzgCost;
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '红白-红-成本',
                        width: 100,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.wrCost;
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '红绿-红-收入',
                        width: 100,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.yzrIncome;
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '红绿-绿-收入',
                        width: 100,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.yzgIncome;
                            style['font-weight'] = 'bold';
                            return h('span', {style}, data);
                        }
                    },
                    {
                        title: '红白-红-收入',
                        width: 100,
                        render(h, params) {
                            const style = {};
                            style['padding'] = '10px';
                            const data = params.row.wrIncome;
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
            changePage(pageNo) {
                this.queryInfo.page.num = pageNo;
                this.loadData();
            },
            loadData(e) {
                this.loading = true;
                API.getLhc3Colors2(this.tables, this.type, this.queryInfo).then(result => {
                    this.loading = false;
                    if (e) {
                        e.target.scrollingElement.scrollTop -= 1000
                    }
                    // this.data = this.data.concat(result.list);
                    this.data = result.list
                    this.total = result.total
                }).catch(e => {
                    this.loading1 = false;
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
