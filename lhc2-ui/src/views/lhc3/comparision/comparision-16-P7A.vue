<style scoped>
    @import "../../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="lhc3-comparision-16-P7A"/>
            </Header>
            <Content class="content">
                <ComparisionTable tables="16" type="P7A" />
            </Content>
            <Footer/>
        </Layout>
    </div>
</template>
<script>
    import Menus from '../../index/lhc3-menus.vue';
    import Footer from '../../index/footer.vue';
    import ComparisionTable from '../../common/lhc3-comparison-tables.vue';

    export default {
        components: {
            Menus,
            Footer,
            ComparisionTable
        }
    }
</script>
