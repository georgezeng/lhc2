<template>
    <div>
        <Datatable activeName="fdyz"
                   title="十二分段遗值"
                   :cols="cols"
                   func="getYzList"
                   module="fd"/>
    </div>
</template>
<script>
    import Datatable from '../common/pos-datatable.vue';
    import datatable from '../common/pos-datatable';

    export default {
        components: {
            Datatable
        },
        data() {
            return {
                cols: datatable.cols(1, 50, (i) => {
                    return '号码' + i;
                }, (i) => {
                    return 'num' + i;
                }, null, (row) => {
                    return null;
                })
            }
        }
    }
</script>
