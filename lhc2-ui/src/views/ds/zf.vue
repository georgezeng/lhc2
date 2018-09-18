<template>
    <div>
        <Datatable activeName="dszf"
                   title="单双振幅"
                   :cols="cols"
                   func="getZfList"
                   module="ds"/>
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
                }, null, (row) => {
                    let i = row.pos;
                    let txt = '';
                    switch(i+1) {
                        case 1: txt = "0单"; break;
                        case 2: txt = "0双"; break;
                        case 3: txt = "1单"; break;
                        case 4: txt = "1双"; break;
                        case 5: txt = "2单"; break;
                        case 6: txt = "2双"; break;
                        case 7: txt = "3单"; break;
                        case 8: txt = "3双"; break;
                        case 9: txt = "4单"; break;
                        case 10: txt = "4双"; break;
                    }
                    return txt;
                })
            }
        }
    }
</script>
