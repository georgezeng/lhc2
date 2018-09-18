<template>
    <div>
        <Datatable activeName="z2yz"
                   title="杂2遗值"
                   :cols="cols"
                   func="getYzList"
                   module="z2"/>
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
                    return "位" + index;
                }, (index) => {
                    return "w" + index;
                })
            }
        }
    }
</script>