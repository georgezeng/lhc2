<style scoped>
    .corner-number {
        float: right;
        border-radius: 41px;
        width: 16px;
        height: 16px;
        font-size: 0.5rem;
        position: absolute;
        right: -7px;
        top: 11px;
        background-color: red;
        color: white;
        font-weight: bold;
    }
</style>
<template>
    <Menu mode="horizontal" theme="dark" :active-name="activeName" @on-select="go">
        <MenuItem name="tm">
            <Icon type="ios-paper" />
            特码管理
        </MenuItem>
        <Submenu name="analyze">
            <template slot="title">
                <Icon type="ios-stats" />
                数据分析
            </template>
            <MenuGroup title="生肖">
                <MenuItem name="sxyz">遗值表</MenuItem>
                <MenuItem name="sxzf">振幅表</MenuItem>
                <MenuItem name="sxsw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="首位">
                <MenuItem name="swyz">遗值表</MenuItem>
                <MenuItem name="swzf">振幅表</MenuItem>
                <MenuItem name="swsw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="末位">
                <MenuItem name="mwyz">遗值表</MenuItem>
                <MenuItem name="mwzf">振幅表</MenuItem>
                <MenuItem name="mwsw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="合数">
                <MenuItem name="hsyz">遗值表</MenuItem>
                <MenuItem name="hszf">振幅表</MenuItem>
                <MenuItem name="hssw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="波色">
                <MenuItem name="bsyz">遗值表</MenuItem>
                <MenuItem name="bszf">振幅表</MenuItem>
                <MenuItem name="bssw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="质数">
                <MenuItem name="zsyz">遗值表</MenuItem>
                <MenuItem name="zszf">振幅表</MenuItem>
                <MenuItem name="zssw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="七区">
                <MenuItem name="qqyz">遗值表</MenuItem>
                <MenuItem name="qqzf">振幅表</MenuItem>
                <MenuItem name="qqsw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区">
                <MenuItem name="seqyz">遗值表</MenuItem>
                <MenuItem name="seqzf">振幅表</MenuItem>
                <MenuItem name="seqsw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十六区">
                <MenuItem name="slqyz">遗值表</MenuItem>
                <MenuItem name="slqzf">振幅表</MenuItem>
                <MenuItem name="slqsw">顺表</MenuItem>
            </MenuGroup>
            <!--
            <MenuGroup title="十二分段">
                <MenuItem name="sefdyz">遗值表</MenuItem>
                <MenuItem name="sefdzf">振幅表</MenuItem>
                <MenuItem name="sefdsw">顺表</MenuItem>
            </MenuGroup>
            -->
            <MenuGroup title="单双">
                <MenuItem name="dsyz">遗值表</MenuItem>
                <MenuItem name="dszf">振幅表</MenuItem>
                <MenuItem name="dssw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="配对">
                <MenuItem name="pdyz">遗值表</MenuItem>
                <MenuItem name="pdzf">振幅表</MenuItem>
                <MenuItem name="pdsw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="杂2">
                <MenuItem name="z2yz">遗值表</MenuItem>
                <MenuItem name="z2zf">振幅表</MenuItem>
                <MenuItem name="z2sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="杂7">
                <MenuItem name="z7yz">遗值表</MenuItem>
                <MenuItem name="z7zf">振幅表</MenuItem>
                <MenuItem name="z7sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="杂13">
                <MenuItem name="z13yz">遗值表</MenuItem>
                <MenuItem name="z13zf">振幅表</MenuItem>
                <MenuItem name="z13sw">顺表</MenuItem>
            </MenuGroup>
        </Submenu>
        <MenuItem name="stat">
            <Icon type="ios-stats" />
            数据统计
        </MenuItem>
    </Menu>
</template>
<script>
    import router from '../../router';

    export default {
        props: [
            'activeName'
        ],
        data() {
            return {
            };
        },
        methods: {
            go(name) {
                router.push({
                    name: name
                })
            }
        }
    }
</script>
