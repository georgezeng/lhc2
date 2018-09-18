<template>
    <div>
        <Datatable activeName="qqyz"
                   title="七区遗值"
                   :cols="cols"
                   func="getYzList"
                   module="qq"/>
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
                cols: datatable.cols(0, 7, (index) => {
                    return "位" + index;
                }, (index) => {
                    return "w" + index;
                })
            }
        }
    }
</script>
