<template>
    <div>
        <Datatable activeName="lhc3-seqk-yz"
                   title="十二区K遗值"
                   :cols="cols"
                   func="getLhc3YzList"
                   module="seqk"/>
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
                    return "位" + index;
                }, (index) => {
                    return "w" + index;
                })
            }
        }
    }
</script>
