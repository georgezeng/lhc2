<style scoped>
    @import "../../../styles/common.less";
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
                        {{ title }}
                    </p>
                    <Table ref="table" stripe border size="small" :loading="loading" :columns="columns" :data="data"/>
                    <!--
                    <div class="page">
                        <Page :total="total"
                              :page-size="queryInfo.page.size"
                              :current="queryInfo.page.num"
                              @on-change="changePage"/>
                    </div>
                    <div style="clear:both;"></div>
                    -->
                </Card>
                <div style="height: 300px;"></div>
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
        props: [
            'activeName',
            'title',
            'cols',
            'func',
            'module'
        ],
        components: {
            Menus,
            Footer
        },
        data() {
            const self = this;
            return {
                loading: true,
                queryInfo: {
                    page: {
                        num: 1,
                        size: 100,
                        property: 'phase',
                        order: 'DESC'
                    }
                },
                total: 0,
                data: [],
                columns: [
                    {
                        title: '期数',
                        width: 120,
                        key: 'phase',
                    },
                    ...this.cols
                ]
            }
        },
        methods: {
            loadData(e) {
                this.loading = true;
                API[this.func].call(API, this.module, this.queryInfo).then(res => {
                    this.loading = false;
                    if (e) {
                        e.target.scrollingElement.scrollTop -= 1000
                    }
                    this.data = this.data.concat(res.list);
                    this.total = res.total;
                }).catch(ex => {
                    this.loading = false;
                });
            },
            changePage(pageNo) {
                this.queryInfo.page.num = pageNo;
                this.loadData();
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
            window.addEventListener('scroll', this.scrollHandler)
        },
        destroyed() {
            window.removeEventListener('scroll', this.scrollHandler)
        }
    }
</script>
