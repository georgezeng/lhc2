<template>
    <div>
        <Datatable activeName="z13yz"
                   title="杂13遗值"
                   :cols="cols"
                   func="getYzList"
                   module="z13"/>
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