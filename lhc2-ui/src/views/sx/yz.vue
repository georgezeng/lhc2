<template>
    <div>
        <Datatable activeName="sxyz"
                   title="生肖遗值"
                   :cols="cols"
                   func="getYzList"
                   module="sx"/>
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
                    switch(index) {
                        case 0: return '鼠';
                        case 1: return '牛';
                        case 2: return '虎';
                        case 3: return '兔';
                        case 4: return '龙';
                        case 5: return '蛇';
                        case 6: return '马';
                        case 7: return '羊';
                        case 8: return '猴';
                        case 9: return '鸡';
                        case 10: return '狗';
                        case 11: return '猪';
                        default: return '';
                    }
                }, (index) => {
                    switch(index) {
                        case 0: return 'shu';
                        case 1: return 'niu';
                        case 2: return 'hu';
                        case 3: return 'tu';
                        case 4: return 'lonng';
                        case 5: return 'she';
                        case 6: return 'ma';
                        case 7: return 'yang';
                        case 8: return 'hou';
                        case 9: return 'ji';
                        case 10: return 'gou';
                        case 11: return 'zhu';
                        default: return '';
                    }
                })
            }
        }
    }
</script>