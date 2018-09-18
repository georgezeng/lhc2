<template>
    <div>
        <Datatable activeName="bssw"
                   title="波色顺位"
                   :cols="cols"
                   func="getSwList"
                   module="bs"/>
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
                cols: datatable.cols(1, 10, (index) => {
                    return "顺位" + index;
                }, (index) => {
                    return "sw" + index;
                }, datatable.swData, (row) => {
                    let i = row.pos;
                    let txt = null;
                    let index = 0;
                    if (i < 3) {
                        i++;
                        txt = '红';
                        index = i;
                    } else if (i < 6) {
                        txt = '蓝';
                        const pos = ++i % 3;
                        if (pos != 0) {
                            index = pos;
                        } else {
                            index = 3;
                        }
                    } else {
                        txt = '绿';
                        const pos = ++i % 3;
                        if (pos != 0) {
                            index = pos;
                        } else {
                            index = 3;
                        }
                    }
                    return txt + index;
                })
            }
        }
    }
</script>
