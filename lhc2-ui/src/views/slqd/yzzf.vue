<template>
    <div>
        <Datatable activeName="slqdyzzf"
                   title="十六区D"
                   :yzcols="yzcols"
                   :zfcols="zfcols"
                   yzfunc="getYzList"
                   zffunc="getZfList"
                   module="slqd"/>
    </div>
</template>
<script>
    import Datatable from '../common/pos-datatable-zfyz.vue';
    import datatable from '../common/pos-datatable';

    export default {
        components: {
            Datatable
        },
        data() {
            return {
                yzcols: datatable.cols(0, 16, (index) => {
                    return "位" + index;
                }, (index) => {
                    return "w" + index;
                }),
                zfcols: datatable.cols(0, 16, (index) => {
                    return "振幅" + index;
                }, (index) => {
                    return "zf" + index;
                })
            }
        }
    }
</script>