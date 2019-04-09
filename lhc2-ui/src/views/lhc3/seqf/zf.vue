<template>
    <div>
        <Datatable activeName="lhc3-seqf-zf"
                   title="十二区F振幅"
                   :cols="cols"
                   func="getLhc3ZfList"
                   module="seqf"/>
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
