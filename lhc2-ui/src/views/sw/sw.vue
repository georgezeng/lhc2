<template>
    <div>
        <Datatable activeName="swsw"
                   title="首位顺位"
                   :cols="cols"
                   func="getSwList"
                   module="sw"/>
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
                cols: datatable.cols(1, 6, (index) => {
                    return "顺位" + index;
                }, (index) => {
                    return "sw" + index;
                }, datatable.swData)
            }
        }
    }
</script>
