<template>
    <div>
        <Datatable activeName="z7yz"
                   title="杂7遗值"
                   :cols="cols"
                   func="getYzList"
                   module="z7"/>
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
                cols: datatable.cols(0, 10, (index) => {
                    return "位" + index;
                }, (index) => {
                    return "w" + index;
                })
            }
        }
    }
</script>