<template>
    <div>
        <Datatable activeName="lhc3-seqg-yz"
                   title="十二区G遗值"
                   :cols="cols"
                   func="getLhc3YzList"
                   module="seqg"/>
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
