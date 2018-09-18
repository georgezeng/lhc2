<template>
    <div>
        <Datatable activeName="dsyz"
                   title="单双遗值"
                   :cols="cols"
                   func="getYzList"
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
                cols: datatable.cols(1, 10, (i) => {
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
                }, (i) => {
                    let txt = '';
                    switch(i) {
                        case 1: txt = "odd0"; break;
                        case 2: txt = "even0"; break;
                        case 3: txt = "odd1"; break;
                        case 4: txt = "even1"; break;
                        case 5: txt = "odd2"; break;
                        case 6: txt = "even2"; break;
                        case 7: txt = "odd3"; break;
                        case 8: txt = "even3"; break;
                        case 9: txt = "odd4"; break;
                        case 10: txt = "even4"; break;
                    }
                    return txt;
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
