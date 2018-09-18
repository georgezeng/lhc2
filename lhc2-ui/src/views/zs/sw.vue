<template>
    <div>
        <Datatable activeName="zssw"
                   title="质数顺位"
                   :cols="cols"
                   func="getSwList"
                   module="zs"/>
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
                cols: datatable.cols(1, 10, (index) => {
                    return "顺位" + index;
                }, (index) => {
                    return "sw" + index;
                }, datatable.swData)
            }
        }
    }
</script>
