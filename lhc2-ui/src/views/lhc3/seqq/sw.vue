<template>
    <div>
        <Datatable activeName="lhc3-seqq-sw"
                   title="十二区Q顺位"
                   :cols="cols"
                   func="getLhc3SwList"
                   module="seqq"/>
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
                }, datatable.swData)
            }
        }
    }
</script>
