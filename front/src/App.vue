<template>
    <el-container style="border: 1px solid #eee">
        <el-aside style="width: 200px">
            <el-menu :default-openeds="['1']">
                <el-menu-item index="1">Menu 1</el-menu-item>
                <el-menu-item index="2">Menu 2</el-menu-item>
                <el-menu-item index="3">Menu 3</el-menu-item>
                <el-submenu index="1">
                    <template slot="title">Navigator</template>
                    <el-menu-item index="1-1">Option 1</el-menu-item>
                    <el-menu-item index="1-2">Option 2</el-menu-item>
                    <el-menu-item index="1-3">Option 3</el-menu-item>
                    <el-menu-item index="1-4">Option 4</el-menu-item>
                </el-submenu>
            </el-menu>
        </el-aside>
        <el-container>
            <el-header style="text-align: right">
                <el-dropdown>
                    <i class="el-icon-setting" style="margin-right: 15px"></i>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>View</el-dropdown-item>
                        <el-dropdown-item>Add</el-dropdown-item>
                        <el-dropdown-item>Delete</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <span>{{ user }}</span>
            </el-header>
            <el-main>
                <router-view/>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        data() {
            return {
                user: 'vincent',
                activeName: 'first'
            };
        },
        methods: {
            handleClick(tab, event) {
                console.log(tab, event);
            }
        }
    };
</script>


<style lang="scss">
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }
    .el-aside {
        color: #333;
    }
</style>
