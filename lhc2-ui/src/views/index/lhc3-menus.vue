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
        <MenuItem name="lhc3-tm">
            <Icon type="ios-paper" />
            特码管理
        </MenuItem>
        <Submenu name="analyze">
            <template slot="title">
                <Icon type="ios-stats" />
                数据分析
            </template>
            <MenuGroup title="十二区A">
                <MenuItem name="lhc3-seqa-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqa-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqa-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区B">
                <MenuItem name="lhc3-seqb-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqb-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqb-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区C">
                <MenuItem name="lhc3-seqc-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqc-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqc-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区D">
                <MenuItem name="lhc3-seqd-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqd-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqd-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区E">
                <MenuItem name="lhc3-seqe-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqe-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqe-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区F">
                <MenuItem name="lhc3-seqf-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqf-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqf-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区G">
                <MenuItem name="lhc3-seqg-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqg-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqg-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区H">
                <MenuItem name="lhc3-seqh-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqh-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqh-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区I">
                <MenuItem name="lhc3-seqi-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqi-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqi-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区J">
                <MenuItem name="lhc3-seqj-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqj-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqj-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区K">
                <MenuItem name="lhc3-seqk-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqk-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqk-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区L">
                <MenuItem name="lhc3-seql-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seql-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seql-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区M">
                <MenuItem name="lhc3-seqm-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqm-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqm-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区N">
                <MenuItem name="lhc3-seqn-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqn-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqn-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区O">
                <MenuItem name="lhc3-seqo-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqo-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqo-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区P">
                <MenuItem name="lhc3-seqp-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqp-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqp-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区Q">
                <MenuItem name="lhc3-seqq-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqq-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqq-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二区R">
                <MenuItem name="lhc3-seqr-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-seqr-zf">振幅表</MenuItem>
                <MenuItem name="lhc3-seqr-sw">顺表</MenuItem>
            </MenuGroup>
            <MenuGroup title="十二分段">
                <MenuItem name="lhc3-fd-yz">遗值表</MenuItem>
                <MenuItem name="lhc3-fd-sw">顺表</MenuItem>
            </MenuGroup>
        </Submenu>
        <Submenu name="stake">
            <template slot="title">
                <Icon type="ios-stats" />
                投注
            </template>
            <!--
            <MenuItem name="lhc3-stat-P1">类型1</MenuItem>
            <MenuItem name="lhc3-stat-P2">类型2</MenuItem>
            <MenuItem name="lhc3-stat-P3">类型3</MenuItem>
            <MenuItem name="lhc3-stat-P4">类型4</MenuItem>
            <MenuItem name="lhc3-stat-P5">类型5</MenuItem>
            <MenuItem name="lhc3-stat-P6">类型6</MenuItem>
            -->
            <MenuItem name="lhc3-stake-P7A">类型7A-投注</MenuItem>
            <MenuItem name="lhc3-stake-P7B">类型7B-投注</MenuItem>
            <MenuItem name="lhc3-stake-P8">类型8-投注</MenuItem>
        </Submenu>
        <Submenu name="stat">
            <template slot="title">
                <Icon type="ios-stats" />
                数据统计
            </template>
            <!--
            <MenuItem name="lhc3-stat-P1">类型1</MenuItem>
            <MenuItem name="lhc3-stat-P2">类型2</MenuItem>
            <MenuItem name="lhc3-stat-P3">类型3</MenuItem>
            <MenuItem name="lhc3-stat-P4">类型4</MenuItem>
            <MenuItem name="lhc3-stat-P5">类型5</MenuItem>
            <MenuItem name="lhc3-stat-P6">类型6</MenuItem>
            -->
            <MenuItem name="lhc3-stat-1-P7A">类型7A-1</MenuItem>
            <MenuItem name="lhc3-stat-2-P7A">类型7A-2</MenuItem>
            <MenuItem name="lhc3-stat-3-P7A">类型7A-3</MenuItem>
            <MenuItem name="lhc3-stat-4-P7A">类型7A-4</MenuItem>
            <MenuItem name="lhc3-stat-P7A">类型7A-16</MenuItem>
            <MenuItem name="lhc3-stat-1-P7B">类型7B-1</MenuItem>
            <MenuItem name="lhc3-stat-2-P7B">类型7B-2</MenuItem>
            <MenuItem name="lhc3-stat-3-P7B">类型7B-3</MenuItem>
            <MenuItem name="lhc3-stat-P7B">类型7B-15</MenuItem>
            <MenuItem name="lhc3-stat-1-P8">类型8-1</MenuItem>
            <MenuItem name="lhc3-stat-2-P8">类型8-2</MenuItem>
            <MenuItem name="lhc3-stat-3-P8">类型8-3</MenuItem>
            <MenuItem name="lhc3-stat-4-P8">类型8-4</MenuItem>
            <MenuItem name="lhc3-stat-5-P8">类型8-5</MenuItem>
            <MenuItem name="lhc3-stat-P8">类型8-20</MenuItem>
        </Submenu>
        <Submenu name="comparision">
            <template slot="title">
                <Icon type="ios-stats" />
                数据对比
            </template>
            <!--
            <MenuGroup title="类型1">
                <MenuItem name="lhc3-comparision-9-P1">9表-1</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型2">
                <MenuItem name="lhc3-comparision-12-P2">9表-2</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型3">
                <MenuItem name="lhc3-comparision-12-P3">9表-3</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型4">
                <MenuItem name="lhc3-comparision-9-P4">9表-4</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型5">
                <MenuItem name="lhc3-comparision-3-P5">9表-5</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型6">
                <MenuItem name="lhc3-comparision-3-P6">9表-6</MenuItem>
            </MenuGroup>
            -->
            <MenuGroup title="类型7A">
                <MenuItem name="lhc3-comparision-1-P7A">4表-1</MenuItem>
                <MenuItem name="lhc3-comparision-2-P7A">4表-2</MenuItem>
                <MenuItem name="lhc3-comparision-3-P7A">4表-3</MenuItem>
                <MenuItem name="lhc3-comparision-4-P7A">4表-4</MenuItem>
                <MenuItem name="lhc3-comparision-16-P7A">16表</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型7B">
                <MenuItem name="lhc3-comparision-1-P7B">5表-1</MenuItem>
                <MenuItem name="lhc3-comparision-2-P7B">5表-2</MenuItem>
                <MenuItem name="lhc3-comparision-3-P7B">5表-3</MenuItem>
                <MenuItem name="lhc3-comparision-15-P7B">15表</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型8">
                <MenuItem name="lhc3-comparision-1-P8">4表-1</MenuItem>
                <MenuItem name="lhc3-comparision-2-P8">4表-2</MenuItem>
                <MenuItem name="lhc3-comparision-3-P8">4表-3</MenuItem>
                <MenuItem name="lhc3-comparision-4-P8">4表-4</MenuItem>
                <MenuItem name="lhc3-comparision-5-P8">4表-5</MenuItem>
                <MenuItem name="lhc3-comparision-20-P8">20表</MenuItem>
            </MenuGroup>
        </Submenu>
        <!--
        <Submenu name="emulate">
            <template slot="title">
                <Icon type="ios-stats" />
                数据模拟
            </template>
            <MenuGroup title="类型1">
                <MenuItem name="lhc3-emulate-9-P1">9表-1</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型2">
                <MenuItem name="lhc3-emulate-12-P2">9表-2</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型3">
                <MenuItem name="lhc3-emulate-12-P3">9表-3</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型4">
                <MenuItem name="lhc3-emulate-9-P4">9表-4</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型5">
                <MenuItem name="lhc3-emulate-3-P5">9表-5</MenuItem>
            </MenuGroup>
            <MenuGroup title="类型6">
                <MenuItem name="lhc3-emulate-3-P6">9表-6</MenuItem>
            </MenuGroup>
        </Submenu>
        -->
        <MenuItem name="tm">
            <Icon type="ios-paper" />
            版本2
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
