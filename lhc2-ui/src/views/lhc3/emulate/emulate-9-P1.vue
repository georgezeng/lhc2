<style scoped>
    @import "../../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="lhc3-emulate-9-P1"/>
            </Header>
            <Content class="content">
                <EmulateTable suffix="1" tables="9" type="P1" />
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
