<template>
    <div>
        <Datatable activeName="qqzf"
                   title="七区振幅"
                   :cols="cols"
                   func="getZfList"
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
                    return "振幅" + index;
                }, (index) => {
                    return "zf" + index;
                })
            }
        }
    }
</script>
