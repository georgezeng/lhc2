<template>
    <div>
        <Datatable activeName="sxzf"
                   title="生肖振幅"
                   :cols="cols"
                   func="getZfList"
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
                cols: datatable.cols(0, 12, (index) => {
                    return "振幅" + index;
                }, (index) => {
                    return "zf" + index;
                }, null, (row) => {
                    return row.sx.text;
                })
            }
        }
    }
</script>
