<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="analyze-1"/>
            </Header>
            <Content class="content">
                <div style="float:left; width:33%;">
                    <Table stripe border size="small" :loading="loading"
                           :columns="columns" :data="data"/>
                    <div class="page">
                        <Page :total="total"
                              :page-size="page.size"
                              :current="page.num"
                              @on-change="changePage"/>
                    </div>
                </div>
                <div style="float:left; width:33%;">
                    <Table stripe border size="small" :loading="loading"
                           :columns="columns" :data="data2"/>
                    <div class="page">
                        <Page :total="total2"
                              :page-size="page2.size"
                              :current="page2.num"
                              @on-change="changePage"/>
                    </div>
                </div>
                <div style="float:left; width:33%;">
                    <Table stripe border size="small" :loading="loading"
                           :columns="columns" :data="data3"/>
                    <div class="page">
                        <Page :total="total3"
                              :page-size="page3.size"
                              :current="page3.num"
                              @on-change="changePage"/>
                    </div>
                </div>
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
        components: {
            Menus,
            Footer
        },
        data() {
          return {
              loading: false,
              data: [],
              data2: [],
              data3: [],
              total: 0,
              total2: 0,
              total3: 0,
              page: {
                num: 1,
                size: 100,
                property: 'phase',
                order: 'DESC'
              },
              page2: {
                  num: 1,
                  size: 100,
                  property: 'phase',
                  order: 'DESC'
              },
              page3: {
                  num: 1,
                  size: 100,
                  property: 'phase',
                  order: 'DESC'
              },
              columns: [
                  {
                      title: '期数',
                      key: 'phase'
                  },
                  {
                      title: '特码',
                      width: 50,
                      key: 'tm'
                  },
                  {
                      title: '0次',
                      width: 50,
                      render(h, params) {
                          const style = {};
                          style['padding'] = '10px';
                          const data = params.row.yz0;
                          if (data == 0) {
                              style['background-color'] = 'red';
                              style['color'] = 'white';
                              style['font-weight'] = 'bold';
                          }
                          return h('span', {style}, data);
                      }
                  },
                  {
                      title: '1+次',
                      width: 50,
                      render(h, params) {
                          const style = {};
                          style['padding'] = '10px';
                          const data = params.row.yz1p;
                          if (data == 0) {
                              style['background-color'] = 'red';
                              style['color'] = 'white';
                              style['font-weight'] = 'bold';
                          }
                          return h('span', {style}, data);
                      }
                  },
                  {
                      title: '0次(浅色)',
                      width: 50,
                      render(h, params) {
                          const style = {};
                          style['padding'] = '10px';
                          const data = params.row.yz0light;
                          if (data == 0) {
                              style['background-color'] = 'orange';
                              style['color'] = 'white';
                              style['font-weight'] = 'bold';
                          }
                          return h('span', {style}, data);
                      }
                  },
                  {
                      title: '0次个数',
                      width: 50,
                      key: 'nums0'
                  },
                  {
                      title: '0次平均个数',
                      width: 50,
                      key: 'nums0Avg'
                  },
                  // {
                  //     title: '0次号码',
                  //     width: 50,
                  //     key: 'nums0arr'
                  // },
                  {
                      title: '1+次(浅色)',
                      width: 50,
                      render(h, params) {
                          const style = {};
                          style['padding'] = '10px';
                          const data = params.row.yz1pLight;
                          if (data == 0) {
                              style['background-color'] = 'orange';
                              style['color'] = 'white';
                              style['font-weight'] = 'bold';
                          }
                          return h('span', {style}, data);
                      }
                  },
                  {
                      title: '1+次个数',
                      width: 50,
                      key: 'nums1p'
                  },
                  {
                      title: '1+次平均个数',
                      width: 50,
                      key: 'nums1pAvg'
                  },
                  // {
                  //     title: '1+次号码',
                  //     width: 50,
                  //     key: 'nums1parr'
                  // },
              ]
          }
        },
        methods: {
            load() {
                this.loading = true
                API.getAnalyze1({
                    data: {
                        type: 'P1',
                        expected: 12,
                    },
                    page: this.page
                }).then(data => {
                    this.data = data.list
                    this.total = data.total
                    this.loading = false
                }).catch(e => {
                    this.loading = false
                })
                API.getAnalyze1({
                    data: {
                        type: 'P2',
                        expected: 12,
                    },
                    page: this.page2
                }).then(data => {
                    this.data2 = data.list
                    this.total2 = data.total
                    this.loading = false
                }).catch(e => {
                    this.loading = false
                })
                API.getAnalyze1({
                    data: {
                        type: 'P3',
                        expected: 12,
                    },
                    page: this.page3
                }).then(data => {
                    this.data3 = data.list
                    this.total3 = data.total
                    this.loading = false
                }).catch(e => {
                    this.loading = false
                })
            },
            changePage(pageNo) {
                this.page.num = pageNo
                this.load()
            }
        },
        mounted() {
          this.load()
        }
    }
</script>
