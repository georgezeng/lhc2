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
            <MenuGroup title="小大单双">
                <MenuItem name="dxds">遗值表/振幅表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十六区">
                <MenuItem name="slqayzzf">A 遗值表/振幅表</MenuItem>
                <MenuItem name="slqbyzzf">B 遗值表/振幅表</MenuItem>
                <MenuItem name="slqcyzzf">C 遗值表/振幅表</MenuItem>
                <MenuItem name="slqdyzzf">D 遗值表/振幅表</MenuItem>
                <MenuItem name="slqbsyzzf">波色 遗值表/振幅表</MenuItem>
                <MenuItem name="slqwxyzzf">五行 遗值表/振幅表</MenuItem>
                <MenuItem name="slqzsyzzf">质数 遗值表/振幅表</MenuItem>
            </MenuGroup>
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
            <MenuGroup title="十二分段">
                <MenuItem name="fdyz">遗值表</MenuItem>
                <MenuItem name="fdsw">顺表</MenuItem>
            </MenuGroup>
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
        <Submenu name="stat">
            <template slot="title">
                <Icon type="ios-stats" />
                数据统计
            </template>
            <MenuItem name="stat-s2-s3">顺2-顺3</MenuItem>
            <!--
            <MenuItem name="stat-16-10">16&10</MenuItem>
            -->
            <MenuItem name="stat-P2">类型2</MenuItem>
            <MenuItem name="stat-P3">类型3</MenuItem>
        </Submenu>
        <Submenu name="comparision">
            <template slot="title">
                <Icon type="ios-stats" />
                数据对比
            </template>
            <!--
            <MenuGroup title="类型1">
                <MenuItem name="comparision16">16表</MenuItem>
                <MenuItem name="comparision10">10表</MenuItem>
            </MenuGroup>
            -->
            <MenuGroup title="类型2">
                <!--
                <MenuItem name="comparision2-33">33表</MenuItem>
                <MenuItem name="comparision2-24">24表</MenuItem>
                <MenuItem name="comparision2-20">20表</MenuItem>
                <MenuItem name="comparision2-16">16表</MenuItem>
                <MenuItem name="comparision2-10">10表</MenuItem>
                -->
                <MenuItem name="comparision2-12">12表</MenuItem>
                <MenuItem name="comparision2-8">8表</MenuItem>
                <MenuItem name="comparision2-4">4表</MenuItem>
                <MenuItem name="comparision2-2">2表</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型3">
                <!--
                <MenuItem name="comparision3-8">8表</MenuItem>
                <MenuItem name="comparision3-4">4表</MenuItem>
                -->
                <MenuItem name="comparision3-16">16表</MenuItem>
                <MenuItem name="comparision3-3">3表</MenuItem>
                <MenuItem name="comparision3-2">2表</MenuItem>
            </MenuGroup>
        </Submenu>
        <Submenu name="emulate">
            <template slot="title">
                <Icon type="ios-stats" />
                数据模拟
            </template>
            <!--
            <MenuGroup title="类型1">
                <MenuItem name="emulate16">16表</MenuItem>
                <MenuItem name="emulate10">10表</MenuItem>
            </MenuGroup>
            -->
            <MenuGroup title="类型2">
                <!--
                <MenuItem name="emulate2-33">33表</MenuItem>
                <MenuItem name="emulate2-24">24表</MenuItem>
                <MenuItem name="emulate2-20">20表</MenuItem>
                <MenuItem name="emulate2-16">16表</MenuItem>
                <MenuItem name="emulate2-10">10表</MenuItem>
                -->
                <MenuItem name="emulate2-12">12表</MenuItem>
                <MenuItem name="emulate2-8">8表</MenuItem>
                <MenuItem name="emulate2-4">4表</MenuItem>
                <MenuItem name="emulate2-2">2表</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型3">
                <!--
                <MenuItem name="emulate3-8">8表</MenuItem>
                <MenuItem name="emulate3-4">4表</MenuItem>
                -->
                <MenuItem name="emulate3-16">16表</MenuItem>
                <MenuItem name="emulate3-3">3表</MenuItem>
                <MenuItem name="emulate3-2">2表</MenuItem>
            </MenuGroup>
        </Submenu>
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
