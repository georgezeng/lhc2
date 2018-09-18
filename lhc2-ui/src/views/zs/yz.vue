<template>
    <div>
        <Datatable activeName="zsyz"
                   title="质数遗值"
                   :cols="cols"
                   func="getYzList"
                   module="zs"/>
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
                cols: datatable.cols(0, 9, (index) => {
                    return "位" + index;
                }, (index) => {
                    return "w" + index;
                })
            }
        }
    }
</script>
