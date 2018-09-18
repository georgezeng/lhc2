<template>
    <div>
        <Datatable activeName="z13sw"
                   title="杂13顺位"
                   :cols="cols"
                   func="getSwList"
                   module="z13"/>
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
                cols: datatable.cols(1, 13, (index) => {
                    return "顺位" + index;
                }, (index) => {
                    return "sw" + index;
                }, datatable.swData)
            }
        }
    }
</script>