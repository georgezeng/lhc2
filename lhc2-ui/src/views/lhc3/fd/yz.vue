<template>
    <div>
        <Datatable activeName="lhc3-fd-yz"
                   title="十二分段遗值"
                   :cols="cols"
                   func="getLhc3YzList"
                   module="fd"/>
    </div>
</template>
<script>
    import Datatable from '../common/datatable.vue';
    import datatable from '../common/datatable';

    export default {
        components: {
            Datatable
        },
        data() {
            return {
                cols: datatable.cols(1, 50, (i) => {
                    return '号码' + i;
                }, (i) => {
                    return 'w' + i;
                }, null, (row) => {
                    return null;
                })
            }
        }
    }
</script>
