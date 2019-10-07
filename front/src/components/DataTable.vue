<template>
    <el-table
            :data="tableData"
            style="width: 100%">
        <el-table-column
                prop="date"
                label="Date"
                width="180">
        </el-table-column>
        <el-table-column
                prop="name"
                label="Nom"
                width="180">
        </el-table-column>
        <el-table-column
                prop="address"
                label="Adresse"
                width="240">
        </el-table-column>
    </el-table>
</template>

<script>
    export default {
        name: "DataTable",
        props: {
            tableData: Array
        }
    };
</script>

<style scoped lang="scss">
</style>
