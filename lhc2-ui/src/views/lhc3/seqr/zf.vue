<template>
    <div>
        <Datatable activeName="lhc3-seqr-zf"
                   title="十二区R振幅"
                   :cols="cols"
                   func="getLhc3ZfList"
                   module="seqr"/>
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
                    return "振幅" + index;
                }, (index) => {
                    return "w" + index;
                })
            }
        }
    }
</script>
