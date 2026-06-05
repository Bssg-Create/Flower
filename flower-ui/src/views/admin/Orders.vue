<template>
  <div><h3 style="margin-bottom:16px;">订单管理</h3>
    <el-table :data="list" border>
      <el-table-column prop="no" label="订单号" width="180"/><el-table-column prop="user" label="用户"/><el-table-column prop="amt" label="金额"/>
      <el-table-column label="状态" width="140"><template #default="{row}"><el-select v-model="row.status" size="small" @change="upd(row)"><el-option label="待付款" :value="1"/><el-option label="待发货" :value="2"/><el-option label="运输中" :value="3"/><el-option label="已完成" :value="4"/></el-select></template></el-table-column>
      <el-table-column prop="addr" label="收货地址"/><el-table-column label="操作"><template><el-button size="small">详情</el-button></template></el-table-column>
    </el-table>
  </div>
</template>
<script setup>import { ref } from 'vue'; import { ElMessage } from 'element-plus'
const list=ref([{no:'20240604152030',user:'张三',amt:299,status:1,addr:'北京市朝阳区'},{no:'20240604151020',user:'李四',amt:168,status:2,addr:'上海市浦东新区'},{no:'20240604145005',user:'王五',amt:545,status:3,addr:'广州市天河区'}])
const upd=(r)=>{ElMessage.success('状态已更新')}</script>