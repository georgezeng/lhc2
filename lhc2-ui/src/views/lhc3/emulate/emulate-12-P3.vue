<style scoped>
    @import "../../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="lhc3-emulate-12-P3"/>
            </Header>
            <Content class="content">
                <EmulateTable tables="9" type="P3" />
            </Content>
            <Footer/>
        </Layout>
    </div>
</template>
<script>
    import Menus from '../../index/lhc3-menus.vue';
    import Footer from '../../index/footer.vue';
    import EmulateTable from '../../common/lhc3-emulate-tables.vue';

    export default {
        components: {
            Menus,
            Footer,
            EmulateTable
        }
    }
</script>
