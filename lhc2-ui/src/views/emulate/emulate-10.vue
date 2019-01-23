<style scoped>
    @import "../../styles/common.less";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header class="menus">
                <Menus activeName="emulate10"/>
            </Header>
            <Content class="content">
                <EmulateTable tables="10" type="P1" />
            </Content>
            <Footer/>
        </Layout>
    </div>
</template>
<script>
    import Menus from '../index/menus.vue';
    import Footer from '../index/footer.vue';
    import EmulateTable from '../common/emulate-tables.vue';

    export default {
        components: {
            Menus,
            Footer,
            EmulateTable
        }
    }
</script>
