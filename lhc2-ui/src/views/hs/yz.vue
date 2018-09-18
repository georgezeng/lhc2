<template>
    <div>
        <Datatable activeName="hsyz"
                   title="合数遗值"
                   :cols="cols"
                   func="getYzList"
                   module="hs"/>
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
