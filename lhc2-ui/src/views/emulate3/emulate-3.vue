<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="emulate3-3"/>
            </Header>
            <Content class="content">
                <EmulateTable tables="3" type="P3" />
            </Content>
            <Footer/>
        </Layout>
    </div>
</template>
<script>
    import Menus from '../index/menus.vue';
    import Footer from '../index/footer.vue';
    import EmulateTable from '../common/emulate-tables2.vue';

    export default {
        components: {
            Menus,
            Footer,
            EmulateTable
        }
    }
</script>
