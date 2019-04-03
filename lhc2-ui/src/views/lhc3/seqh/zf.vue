<template>
    <div>
        <Datatable activeName="lhc3-seqh-zf"
                   title="十二区H振幅"
                   :cols="cols"
                   func="getLhc3ZfList"
                   module="seqh"/>
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
