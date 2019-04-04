<template>
    <div>
        <Datatable activeName="lhc3-fd-sw"
                   title="十二分段顺位"
                   :cols="cols"
                   func="getLhc3SwList"
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
                cols: datatable.cols(1, 13, (index) => {
                    return "顺位" + index;
                }, (index) => {
                    return "w" + index;
                }, (index, row) => {
                    const data = row[`w${index}`];
                    const pos = row[`w${index}Arr`];
                    return `${data} (${pos})`
                }, (row) => {
                    return null;
                }, 120)
            }
        }
    }
</script>
