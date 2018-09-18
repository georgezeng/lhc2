<template>
    <div>
        <Datatable activeName="bsyz"
                   title="波色遗值"
                   :cols="cols"
                   func="getYzList"
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
                cols: datatable.cols(1, 10, (i) => {
                    let txt = null;
                    let index = 0;
                    if (i < 4) {
                        txt = '红';
                        index = i;
                    } else if (i < 7) {
                        txt = '蓝';
                        const pos = i % 3;
                        if (pos != 0) {
                            index = pos;
                        } else {
                            index = 3;
                        }
                    } else {
                        txt = '绿';
                        const pos = i % 3;
                        if (pos != 0) {
                            index = i % 3;
                        } else {
                            index = 3;
                        }
                    }
                    return txt + index;
                }, (i) => {
                    let field = null;
                    let index = 0;
                    if (i < 4) {
                        field = 'red';
                        index = i;
                    } else if (i < 7) {
                        field = 'blue';
                        const pos = i % 3;
                        if (pos != 0) {
                            index = pos;
                        } else {
                            index = 3;
                        }
                    } else {
                        field = 'green';
                        const pos = i % 3;
                        if (pos != 0) {
                            index = pos;
                        } else {
                            index = 3;
                        }
                    }
                    return field + index;
                }, null, (i) => {
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
