<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="comparision16"/>
            </Header>
            <Content class="content">
                <ComparisionTable tables="16" type="P1" />
            </Content>
            <Footer/>
        </Layout>
    </div>
</template>
<script>
    import Menus from '../index/menus.vue';
    import Footer from '../index/footer.vue';
    import ComparisionTable from '../common/comparison-tables.vue';

    export default {
        components: {
            Menus,
            Footer,
            ComparisionTable
        }
    }
</script>
