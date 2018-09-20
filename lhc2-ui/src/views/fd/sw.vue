<template>
    <div>
        <Datatable activeName="fdsw"
                   title="十二分段顺位"
                   :cols="cols"
                   func="getSwList"
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
                cols: datatable.cols(1, 13, (index) => {
                    return "顺位" + index;
                }, (index) => {
                    return "sw" + index;
                }, (index, row) => {
                    const data = row[`sw${index}`];
                    const pos = row[`sw${index}Arr`];
                    return `${data} (${pos})`
                }, (row) => {
                    return null;
                }, 120)
            }
        }
    }
</script>
