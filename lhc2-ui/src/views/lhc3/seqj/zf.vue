<template>
    <div>
        <Datatable activeName="lhc3-seqj-zf"
                   title="十二区J振幅"
                   :cols="cols"
                   func="getLhc3ZfList"
                   module="seqj"/>
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
                    return "振幅" + (index - 1);
                }, (index) => {
                    return "w" + index;
                })
            }
        }
    }
</script>
