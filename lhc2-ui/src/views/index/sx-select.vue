<style scoped>
</style>
<template>
    <Select size="small" transfer v-model="value" @on-change="change">
        <Option v-for="sx in list"
                :value="sx.name"
                :key="sx.name">
            {{ sx.text }}
        </Option>
    </Select>
</template>
<script>
    export default {
        props: [
            'list',
            'sx'
        ],
        data() {
            return {
                value: this.sx
            };
        },
        methods: {
            change(value) {
                this.$emit('change', value);
            }
        }
    }
</script>
