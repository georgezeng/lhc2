<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <Card>
        <p slot="title">
            <Icon type="ios-stats-outline"/>
            {{tables}}表 模拟遗值表
        </p>
        <Table class="times-colors" style="float:left; width: 100%;" stripe border size="small" :loading="loading"
               :columns="columns" :data="data"/>
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
                loading: true,
                data: [],
                columns: [
                    {
                        title: '期数',
                        width: 50,
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
                API.getColors2(this.tables, this.type).then(data => {
                    this.loading = false;
                    this.data = data//.slice(19);
                });
            }
        },
        created() {
            this.loadData();
        }
    }
</script>
