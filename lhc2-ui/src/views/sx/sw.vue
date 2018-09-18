<template>
    <div>
        <Datatable activeName="sxsw"
                   title="生肖顺位"
                   :cols="cols"
                   func="getSwList"
                   module="sx"/>
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
                    const sx = row[`sw${index}sx`].text;
                    return `${data} (${sx})`
                }, (row) => {
                    return row.sx.text;
                })
            }
        }
    }
</script>