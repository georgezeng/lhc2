<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus :activeName="activeName"/>
            </Header>
            <Content class="content" style="overflow: auto;">
                <Card style="width: 140%;">
                    <p slot="title">
                        <Icon type="ios-albums-outline"/>
                        {{ title }}遗值表/振幅表
                    </p>
                    <Table class="times-colors" style="float:left; width: 50%" stripe border size="small" :loading="loading1" :columns="columns1" :data="data1"/>
                    <Table class="times-colors" style="float:left; width: 50%" stripe border size="small" :loading="loading2" :columns="columns2" :data="data2"/>
                    <div style="clear:both;"></div>
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
        props: [
            'activeName',
            'title',
            'yzcols',
            'zfcols',
            'yzfunc',
            'zffunc',
            'module'
        ],
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
                        width: 60,
                        key: 'phase',
                    },
                    ...this.yzcols
                ],
                columns2: [
                    {
                        title: '期数',
                        width: 60,
                        key: 'phase',
                    },
                    ...this.zfcols
                ]
            }
        },
        methods: {
            loadData() {
                API[this.yzfunc].call(API, this.module).then(data => {
                    this.loading1 = false;
                    this.data1 = data;
                }).catch(ex => {
                    this.loading1 = false;
                });
                API[this.zffunc].call(API, this.module).then(data => {
                    this.loading2 = false;
                    this.data2 = [
                        {
                            phase: '',
                            num: null,
                            pos: null,
                            zf0: null,
                            zf1: null,
                            zf2: null,
                            zf3: null,
                            zf4: null,
                            zf5: null,
                            zf6: null,
                            zf7: null,
                            zf8: null,
                            zf9: null,
                            zf10: null,
                            zf11: null,
                            zf12: null,
                            zf13: null,
                            zf14: null,
                            zf15: null
                        },
                        ...data
                    ]
                }).catch(ex => {
                    this.loading2 = false;
                });
            }
        },
        created() {
            this.loadData();
        }
    }
</script>
