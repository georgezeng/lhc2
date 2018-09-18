<template>
    <div>
        <Datatable activeName="hszf"
                   title="合数振幅"
                   :cols="cols"
                   func="getZfList"
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
                    return "振幅" + index;
                }, (index) => {
                    return "zf" + index;
                })
            }
        }
    }
</script>
