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
                <Modal ref="modal" v-model="modal.show" :footer-hide="true" title="编辑特码" :mask-closable="false">
                    <Form ref="form" :rules="modal.rules" :model="modal.data" :label-width="60">
                        <FormItem required label="期数" prop="phase">
                            <i-input v-model="modal.data.phase"/>
                        </FormItem>
                        <FormItem required label="号码" prop="num">
                            <i-input v-model="modal.data.num"/>
                        </FormItem>
                        <FormItem required label="生肖" prop="sx">
                            <Select v-model="selectedSX">
                                <Option v-for="sx in modal.sxList"
                                        :value="sx.name"
                                        :key="sx.name">
                                    {{ sx.text }}
                                </Option>
                            </Select>
                        </FormItem>
                        <FormItem>
                            <Button type="primary" :loading="modal.loading" @click="save" style="float:right;">保存
                            </Button>
                        </FormItem>
                    </Form>
                </Modal>
                <Card>
                    <p slot="title" style="height: 35px;">
                        <Icon type="ios-albums-outline"/>
                        特码管理
                        <Poptip confirm transfer title="确定要清除所有吗" @on-ok="clear">
                            <Button style="margin: 0 10px;" type="error">清除</Button>
                        </Poptip>
                        <Button style="margin: 0 10px 0 0;" type="primary" @click="toAdd">新增+</Button>
                        <Button :loading="calculation.loading" type="success" @click="calculate">{{calculation.text}}
                        </Button>
                    </p>
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
    import Cookies from 'js-cookie';
    import extend from 'lodash/extend';

    export default {
        components: {
            Menus,
            Footer
        },
        data() {
            const self = this;
            return {
                selectedSX: null,
                errors: null,
                modal: {
                    rules: {
                        phase: [
                            {required: true, message: '不能为空', trigger: 'blur'}
                        ],
                        num: [
                            {required: true, message: '不能为空', trigger: 'blur'}
                        ],
                        sx: [
                            {required: true, message: '不能为空', trigger: 'blur'}
                        ],
                    },
                    sxList: [],
                    data: {
                        id: null,
                        phase: '',
                        num: null,
                        sx: null
                    },
                    show: false,
                    loading: false
                },
                calculation: {
                    loading: Cookies.get('calLoading') === 'true',
                    text: Cookies.get('calLoading') === 'true' ? '计算中...' : '计算'
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
                        key: 'phase',
                    },
                    {
                        title: '号码',
                        width: 100,
                        key: 'num',
                    },
                    {
                        title: '生肖',
                        width: 100,
                        render(h, params) {
                            return h('span', {}, params.row.sx.text);
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
                                            self.modal.data = extend({}, params.row);
                                            self.selectedSX = params.row.sx.name;
                                            self.modal.data.sx = self.selectedSX;
                                            self.modal.data.num = params.row.num;
                                            self.modal.show = true;
                                        }
                                    }
                                }, '编辑'),
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
                    this.modal.sxList = data || [];
                })
            },
            loadData() {
                this.loading = true;
                API.getTmList(this.queryInfo).then(data => {
                    this.loading = false;
                    this.data = data.list;
                    this.total = data.total;
                }).catch(ex => {
                    this.loading = false;
                });
            },
            changePage(pageNo) {
                this.queryInfo.page.num = pageNo;
                this.loadData();
            },
            toAdd() {
                this.$refs.form.resetFields();
                this.modal.data.id = null;
                this.selectedSX = null;
                this.modal.show = true;
            },
            save() {
                this.$refs.form.validate((valid) => {
                    if (valid) {
                        this.modal.loading = true;
                        API.saveTm(this.modal.data).then(data => {
                            this.loadData();
                            this.modal.loading = false;
                            this.modal.show = false;
                            this.$Message.success('保存成功');
                        });
                    }
                });
            },
            calculate() {
                let self = this;
                this.$Modal.confirm({
                    title: '确认对话框',
                    content: '计算需要比较长的时间，是否确定开始计算 ?',
                    onOk() {
                        self.errors = null;
                        API.calculate().then(data => {
                            Cookies.set('calLoading', 'true');
                            self.calculation = {
                                loading: true,
                                text: '计算中...'
                            }
                        });
                    }
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
                    if (Cookies.get('calLoading') === 'true' && data.finished) {
                        Cookies.set('calLoading', 'false');
                        if (!data.errors || data.errors.length == 0) {
                            this.calculationFinish();
                            this.$Message.success('计算完成！');
                        } else {
                            this.calculationFinish(data.errors);
                        }
                    }
                    setTimeout(this.loadCalculationStatus, 3000);
                });
            },
            clear() {
                API.clearTm().then(data => {
                    this.$Message.success('清除成功！');
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
            this.loadCalculationStatus();
        }
    }
</script>
