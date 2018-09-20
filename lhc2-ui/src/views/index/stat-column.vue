<style scoped>
    .columnSpan {
        font-size: 16px;
        padding: 2px 5px;
        margin-right: 20px;
        background-color: red;
        color: white;
        font-weight: bold;
    }
</style>
<template>
    <div>
        <span class="columnSpan" v-for="num in nums">{{num}}</span>
    </div>
</template>
<script>
    import Menus from '../index/menus.vue';
    import Footer from '../index/footer.vue';
    import API from '../../libs/api';

    export default {
        props: [
            'nums'
        ],
        data() {
            return {
            }
        }
    }
</script>
