<template>
    <div>
        <Datatable activeName="bszf"
                   title="波色振幅"
                   :cols="cols"
                   func="getZfList"
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
                cols: datatable.cols(0, 9, (index) => {
                    return "振幅" + index;
                }, (index) => {
                    return "zf" + index;
                }, (i) => {
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
