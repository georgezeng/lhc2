<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus :activeName="activeName"/>
            </Header>
            <Content class="content">
                <Card>
                    <p slot="title">
                        <Icon type="ios-albums-outline"/>
                        {{ title }}遗值表
                    </p>
                    <Table stripe border size="small" :loading="loading1" :columns="columns1" :data="data1"/>
                </Card>
                <br />
                <Card>
                    <p slot="title">
                        <Icon type="ios-albums-outline"/>
                        {{ title }}振幅表
                    </p>
                    <Table stripe border size="small" :loading="loading2" :columns="columns2" :data="data2"/>
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
                    this.data2 = data;
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
