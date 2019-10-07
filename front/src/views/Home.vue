<template>
    <div class="home">
        <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="Simple" name="simple">
                <Message msg="Simple Application"/>
            </el-tab-pane>
            <el-tab-pane label="Cards" name="cards">
                <Cards msg="cards" />
            </el-tab-pane>
            <el-tab-pane label="Table" name="table">
                <DataTable :tableData="tableData" />
            </el-tab-pane>
            <el-tab-pane label="Help" name="help">
                <Help msg="Help"/>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    // @ is an alias to /src
    import Message from "@/components/Message.vue";
    import Help from "@/components/Help.vue";
    import Cards from "@/components/Cards.vue";
    import DataTable from "@/components/DataTable.vue";

    export default {
        name: "home",
        data() {
            return {
                activeName: 'simple',
                tableData: [{
                    date: '2016-05-03',
                    name: 'Tom',
                    address: 'No. 189, Grove St, Los Angeles'
                }, {
                    date: '2016-05-02',
                    name: 'Tom',
                    address: 'No. 189, Grove St, Los Angeles'
                }, {
                    date: '2016-05-04',
                    name: 'Tom',
                    address: 'No. 189, Grove St, Los Angeles'
                }, {
                    date: '2016-05-01',
                    name: 'Tom',
                    address: 'No. 189, Grove St, Los Angeles'
                }]
            }
        },
        components: {
            Message, Help, Cards, DataTable
        }
    };
</script>

<style lang="scss">
</style>
