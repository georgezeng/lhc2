<template>
    <div>
        <Datatable activeName="mwzf"
                   title="末位振幅"
                   :cols="cols"
                   func="getZfList"
                   module="mw"/>
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
