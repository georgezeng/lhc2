<template>
    <div>
        <Datatable activeName="dssw"
                   title="单双顺位"
                   :cols="cols"
                   func="getSwList"
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
                cols: datatable.cols(1, 11, (index) => {
                    return "顺位" + index;
                }, (index) => {
                    return "sw" + index;
                }, datatable.swData, (row) => {
                    let i = row.pos;
                    let txt = '';
                    switch(i) {
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
