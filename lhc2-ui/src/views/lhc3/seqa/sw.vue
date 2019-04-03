<template>
    <div>
        <Datatable activeName="lhc3-seqa-sw"
                   title="十二区A顺位"
                   :cols="cols"
                   func="getLhc3SwList"
                   module="seqa"/>
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
