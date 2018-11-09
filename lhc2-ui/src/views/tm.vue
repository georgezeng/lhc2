<style scoped>
    @import "../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="tm"/>
                <Alert v-if="errors" type="error" show-icon closable
                       style="position: fixed; top: 70px; left: 20px; z-index: 100000;">
                    <ul>
                        <li v-for="error in errors">{{error}}</li>
                    </ul>
                </Alert>
            </Header>
            <Content class="content">
                <Card>
                    <p slot="title" style="height: 35px;">
                        <Icon type="ios-albums-outline"/>
                        特码管理
                    </p>
                    <div style="margin-bottom: 10px;">
                        <div style="float: left; width: 100px; margin-right: 10px;">
                            <i-input v-model="modal.data.phase"/>
                        </div>
                        <div style="float: left; width: 100px; margin-right: 10px;">
                            <i-input v-model="modal.data.num" element-id="numInput" />
                        </div>
                        <div style="float: left; width: 100px; margin-right: 10px;">
                            <Select style="margin-right: 10px;" v-model="modal.data.sx">
                                <Option v-for="sx in sxList"
                                        :value="sx.name"
                                        :key="sx.name">
                                    {{ sx.text }}
                                </Option>
                            </Select>
                        </div>
                        <Button style="margin: 0 10px;" type="primary" @click="add">新增+</Button>
                        <Poptip confirm transfer title="确定要清除所有吗" @on-ok="clear">
                            <Button type="error">清除所有</Button>
                        </Poptip>
                        <Poptip confirm transfer title="确定要清除当前页面吗" @on-ok="clearPage">
                            <Button style="margin: 0 10px;" type="warning">清除整页</Button>
                        </Poptip>
                        <Button :loading="calculation.loading" type="success" @click="calculate">{{calculation.text}}
                        </Button>
                    </div>
                    <Table stripe border size="small" :loading="loading" :columns="columns" :data="data"/>
                    <div class="page">
                        <Page :total="total"
                              :page-size="queryInfo.page.size"
                              :current="queryInfo.page.num"
                              @on-change="changePage"/>
                    </div>
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
    import extend from 'lodash/extend';
    import SxSelect from './index/sx-select.vue';
    import ICol from "iview/src/components/grid/col";

    let clearId;
    export default {
        components: {
            ICol,
            Menus,
            Footer
        },
        data() {
            const self = this;
            return {
                selectedSX: null,
                errors: null,
                sxList: [],
                modal: {
                    data: {
                        id: null,
                        phase: '',
                        num: null,
                        sx: null
                    },
                    loading: false
                },
                calculation: {
                    loading: false,
                    text: '计算'
                },
                loading: true,
                queryInfo: {
                    page: {
                        num: 1,
                        size: 20,
                        property: 'phase',
                        order: 'DESC'
                    }
                },
                total: 0,
                data: [],
                columns: [
                    {
                        title: '期数',
                        width: 100,
                        render(h, params) {
                            return h('i-input', {
                                props: {
                                    value: params.row.phase
                                },
                                on: {
                                    'on-change'(e) {
                                        params.row.phase = e.target.value;
                                    }
                                }
                            });
                        }
                    },
                    {
                        title: '号码',
                        width: 100,
                        render(h, params) {
                            return h('i-input', {
                                props: {
                                    value: params.row.num
                                },
                                on: {
                                    'on-change'(e) {
                                        params.row.num = e.target.value;
                                    }
                                }
                            });
                        }
                    },
                    {
                        title: '生肖',
                        width: 100,
                        render(h, params) {
                            return h(SxSelect, {
                                props: {
                                    list: self.sxList,
                                    sx: params.row.sx.name
                                },
                                on: {
                                    change(sx) {
                                        params.row.sx = sx;
                                    }
                                }

                            });
                        }
                    },
                    {
                        title: '操作',
                        minWidth: 150,
                        render(h, params) {
                            return h('div', {}, [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small',
                                        icon: 'ios-clipboard',
                                    },
                                    on: {
                                        click: () => {
                                            self.update(extend({}, params.row,
                                                {
                                                    sx: params.row.sx.name ? params.row.sx.name : params.row.sx
                                                }));
                                        }
                                    }
                                }, '保存'),
                                ' ',
                                h('Poptip', {
                                    props: {
                                        confirm: true,
                                        title: `您确定要删除记录吗`,
                                        transfer: true
                                    },
                                    on: {
                                        'on-ok': () => {
                                            API.deleteTm(params.row.id).then(data => {
                                                self.modal.data.phase = null;
                                                self.queryInfo.page.num = 1;
                                                document.getElementById("numInput").focus();
                                                self.loadData();
                                            });
                                        }
                                    }
                                }, [
                                    h('Button', {
                                        props: {
                                            size: 'small',
                                            icon: 'ios-trash'
                                        }
                                    }, '删除')
                                ])
                            ]);
                        }
                    }
                ]
            }
        },
        methods: {
            loadSxList() {
                API.getSxList().then(data => {
                    this.sxList = data || [];
                })
            },
            loadData() {
                this.loading = true;
                API.getTmList(this.queryInfo).then(data => {
                    this.loading = false;
                    this.data = data.list;
                    this.total = data.total;
                    if (!this.modal.data.phase) {
                        this.modal.data.phase = this.data[0].phase + 1;
                    }
                }).catch(ex => {
                    this.loading = false;
                });
            },
            changePage(pageNo) {
                this.queryInfo.page.num = pageNo;
                this.loadData();
            },
            add() {
                this.modal.loading = true;
                API.saveTm(this.modal.data).then(data => {
                    this.loadData();
                    this.modal.loading = false;
                    this.modal.data.phase++;
                    this.modal.data.num = null;
                    this.modal.data.sx = null;
                    document.getElementById("numInput").focus();
                    this.$Message.success('保存成功');
                });
            },
            update(data) {
                API.saveTm(data).then(data => {
                    this.$Message.success('保存成功');
                });
            },
            calculate() {
                this.errors = null;
                this.calculation = {
                    loading: true,
                    text: '计算中...'
                }
                API.calculate().then(errors => {
                    if (errors && errors.length == 0) {
                        this.calculationFinish();
                        this.$Message.success('计算完成！');
                    } else {
                        this.calculationFinish(errors);
                    }
                }).catch(ex => {
                    this.errors = [ex.message];
                });
            },
            calculationFinish(errors) {
                this.calculation = {
                    loading: false,
                    text: '计算'
                }
                if (errors && errors.length > 0) {
                    this.errors = errors;
                }
            },
            loadCalculationStatus() {
                API.loadCalculationStatus().then(data => {
                    if (data.status == 2) {
                        if (!data.errors || data.errors.length == 0) {
                            this.calculationFinish();
                            this.$Message.success('计算完成！');
                        } else {
                            this.calculationFinish(data.errors);
                        }
                    } else {
                        if (data.status == 1) {
                            this.calculation = {
                                loading: true,
                                text: '计算中...'
                            }
                        } else {
                            this.calculationFinish();
                        }
                    }
                    setTimeout(this.loadCalculationStatus, 1000);
                }).catch(ex => {
                    setTimeout(this.loadCalculationStatus, 1000);
                });
            },
            clearPage() {
                API.clearTmWithPage(this.queryInfo.page).then(data => {
                    this.$Message.success('删除成功！');
                    this.queryInfo.page.num = 1;
                    this.loadData();
                });
            },
            clear() {
                API.clearTm().then(data => {
                    this.$Message.success('清除成功！');
                    this.modal.data.phase = null;
                    this.queryInfo.page.num = 1;
                    document.getElementById("numInput").focus();
                    this.loadData();
                });
            }
        },
        watch: {
            selectedSX: function (val) {
                this.modal.data.sx = val;
            }
        },
        created() {
            this.loadSxList();
            this.loadData();
            // this.loadCalculationStatus();
        }
    }
</script>
