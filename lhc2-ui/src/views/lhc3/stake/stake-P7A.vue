<style scoped>
    @import "../../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="lhc3-stake"/>
            </Header>
            <Content class="content">
                <Card>
                    <p slot="title" style="height: 35px;">
                        <Icon type="ios-albums-outline"/>
                        类型7A - 投注
                    </p>
                    <Table style="margin-bottom: 10px;" stripe border size="small" :loading="loading" :columns="columns1"
                           :data="data1"/>
                    <Table style="margin-bottom: 10px;" stripe border size="small" :loading="loading" :columns="columns2"
                           :data="data2"/>
                    <Table style="margin-bottom: 10px;" stripe border size="small" :loading="loading" :columns="columns3"
                           :data="data3"/>
                    <Table style="margin-bottom: 10px;" stripe border size="small" :loading="loading" :columns="columns4"
                           :data="data4"/>
                    <Table style="margin-bottom: 10px;" stripe border size="small" :loading="loading" :columns="columns5"
                           :data="data5"/>
                    <Table stripe border size="small" :loading="loading" :columns="columns6"
                           :data="data6"/>
                </Card>
            </Content>
            <Footer/>
        </Layout>
    </div>
</template>
<script>
    import Menus from '../../index/lhc3-menus.vue';
    import Footer from '../../index/footer.vue';
    import API from '../../../libs/api';

    export default {
        components: {
            Menus,
            Footer
        },
        data() {
            const self = this;
            return {
                loading: true,
                total: 0,
                data1: [],
                data2: [],
                data3: [],
                data4: [],
                data5: [],
                data6: [],
                columns1: [
                    {
                        title: '期数',
                        width: 150,
                        key: 'phase'
                    },
                    {
                        title: '特码',
                        width: 50,
                        key: 'num'
                    },
                    {
                        title: '1',
                        width: 50,
                        key: 'time1',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time1)
                        }
                    },
                    {
                        title: '2',
                        width: 50,
                        key: 'time2',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time2)
                        }
                    },
                    {
                        title: '3',
                        width: 50,
                        key: 'time3',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time3)
                        }
                    },
                    {
                        title: '4',
                        width: 50,
                        key: 'time4',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time4)
                        }
                    },
                    {
                        title: '5',
                        width: 50,
                        key: 'time5',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time5)
                        }
                    },
                    {
                        title: '6',
                        width: 50,
                        key: 'time6',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time6)
                        }
                    },
                    {
                        title: '7',
                        width: 50,
                        key: 'time7',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time7)
                        }
                    },
                    {
                        title: '8',
                        width: 50,
                        key: 'time8',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time8)
                        }
                    },
                    {
                        title: '9',
                        width: 50,
                        key: 'time9',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time9)
                        }
                    },
                    {
                        title: '10',
                        width: 50,
                        key: 'time10',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time10)
                        }
                    }
                ],
                columns2: [
                    {
                        title: '期数',
                        width: 150,
                        key: 'phase'
                    },
                    {
                        title: '特码',
                        width: 50,
                        key: 'num'
                    },
                    {
                        title: '11',
                        width: 50,
                        key: 'time11',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time11)
                        }
                    },
                    {
                        title: '12',
                        width: 50,
                        key: 'time12',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time12)
                        }
                    },
                    {
                        title: '13',
                        width: 50,
                        key: 'time13',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time13)
                        }
                    },
                    {
                        title: '14',
                        width: 50,
                        key: 'time14',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time14)
                        }
                    },
                    {
                        title: '15',
                        width: 50,
                        key: 'time15',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time15)
                        }
                    },
                    {
                        title: '16',
                        width: 50,
                        key: 'time16',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time16)
                        }
                    },
                    {
                        title: '17',
                        width: 50,
                        key: 'time17',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time17)
                        }
                    },
                    {
                        title: '18',
                        width: 50,
                        key: 'time18',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time18)
                        }
                    },
                    {
                        title: '19',
                        width: 50,
                        key: 'time19',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time19)
                        }
                    },
                    {
                        title: '20',
                        width: 50,
                        key: 'time20',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time20)
                        }
                    }
                ],
                columns3: [
                    {
                        title: '期数',
                        width: 150,
                        key: 'phase'
                    },
                    {
                        title: '特码',
                        width: 50,
                        key: 'num'
                    },
                    {
                        title: '21',
                        width: 50,
                        key: 'time21',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time21)
                        }
                    },
                    {
                        title: '22',
                        width: 50,
                        key: 'time22',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time22)
                        }
                    },
                    {
                        title: '23',
                        width: 50,
                        key: 'time23',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time23)
                        }
                    },
                    {
                        title: '24',
                        width: 50,
                        key: 'time24',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time24)
                        }
                    },
                    {
                        title: '25',
                        width: 50,
                        key: 'time25',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time25)
                        }
                    },
                    {
                        title: '26',
                        width: 50,
                        key: 'time26',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time26)
                        }
                    },
                    {
                        title: '27',
                        width: 50,
                        key: 'time27',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time27)
                        }
                    },
                    {
                        title: '28',
                        width: 50,
                        key: 'time28',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time28)
                        }
                    },
                    {
                        title: '29',
                        width: 50,
                        key: 'time29',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time29)
                        }
                    },
                    {
                        title: '30',
                        width: 50,
                        key: 'time30',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time30)
                        }
                    }
                ],
                columns4: [
                    {
                        title: '期数',
                        width: 150,
                        key: 'phase'
                    },
                    {
                        title: '特码',
                        width: 50,
                        key: 'num'
                    },
                    {
                        title: '31',
                        width: 50,
                        key: 'time31',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time31)
                        }
                    },
                    {
                        title: '32',
                        width: 50,
                        key: 'time32',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time32)
                        }
                    },
                    {
                        title: '33',
                        width: 50,
                        key: 'time33',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time33)
                        }
                    },
                    {
                        title: '34',
                        width: 50,
                        key: 'time34',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time34)
                        }
                    },
                    {
                        title: '35',
                        width: 50,
                        key: 'time35',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time35)
                        }
                    },
                    {
                        title: '36',
                        width: 50,
                        key: 'time36',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time36)
                        }
                    },
                    {
                        title: '37',
                        width: 50,
                        key: 'time37',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time37)
                        }
                    },
                    {
                        title: '38',
                        width: 50,
                        key: 'time38',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time38)
                        }
                    },
                    {
                        title: '39',
                        width: 50,
                        key: 'time39',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time39)
                        }
                    },
                    {
                        title: '40',
                        width: 50,
                        key: 'time40',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time40)
                        }
                    }
                ],
                columns5: [
                    {
                        title: '期数',
                        width: 150,
                        key: 'phase'
                    },
                    {
                        title: '特码',
                        width: 50,
                        key: 'num'
                    },
                    {
                        title: '41',
                        width: 50,
                        key: 'time41',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time41)
                        }
                    },
                    {
                        title: '42',
                        width: 50,
                        key: 'time42',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time42)
                        }
                    },
                    {
                        title: '43',
                        width: 50,
                        key: 'time43',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time43)
                        }
                    },
                    {
                        title: '44',
                        width: 50,
                        key: 'time4',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '45px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time44)
                        }
                    },
                    {
                        title: '45',
                        width: 50,
                        key: 'time45',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time45)
                        }
                    },
                    {
                        title: '46',
                        width: 50,
                        key: 'time46',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time46)
                        }
                    },
                    {
                        title: '47',
                        width: 50,
                        key: 'time47',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time47)
                        }
                    },
                    {
                        title: '48',
                        width: 50,
                        key: 'time48',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time48)
                        }
                    },
                    {
                        title: '49',
                        width: 50,
                        key: 'time49',
                        render: (h, params) => {
                            return h('span', {
                                style: {
                                    padding: '5px',
                                    backgroundColor: 'red'
                                }
                            }, params.row.time49)
                        }
                    },
                    {
                        title: '',
                        width: 50,
                    }
                ],
                columns6: [
                    {
                        title: '期数',
                        width: 150,
                        key: 'phase'
                    },
                    {
                        title: '特码',
                        width: 50,
                        key: 'num'
                    },
                    {
                        title: '当期下注金额',
                        key: 'currentAmount',
                    },
                    {
                        title: '上期奖金金额',
                        key: 'lastBonus',
                    },
                    {
                        title: '历史下注金额',
                        key: 'historyAmount',
                    },
                    {
                        title: '历史奖金金额',
                        key: 'historyBonus',
                    }
                ]
            }
        },
        methods: {
            loadData() {
                this.loading = true;
                API.getLhc3Stake('P7A').then(result => {
                    this.data1 = result
                    this.data2 = result
                    this.data3 = result
                    this.data4 = result
                    this.data5 = result
                    this.data6 = result
                    this.loading = false;
                }).catch(e => {
                    this.loading = false;
                });
            },
        },
        mounted() {
            this.loadData();
        }
    }
</script>
