<template>
  <div class="help">
    <h1>{{ msg }}</h1>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>Card name</span>
        <el-button style="float: right; padding: 3px 0" type="text">Bouton</el-button>
      </div>
      <div v-for="o in 4" :key="o" class="text item">
        {{'List item ' + o }}
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "Cards",
  props: {
    msg: String
  }
};
</script>

<style scoped lang="scss">
  .text {
    font-size: 14px;
  }
  .item {
    margin-bottom: 18px;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }
  .box-card {
    width: 240px;
  }
</style>
