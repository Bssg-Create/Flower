<template>
  <div>
    <h3 style="margin-bottom:20px;">数据仪表盘</h3>
    <el-row :gutter="16">
      <el-col :span="6" v-for="s in stats" :key="s.label"><el-card :body-style="{padding:'20px',background:s.color,color:'#fff',borderRadius:'8px'}"><div style="font-size:14px;opacity:.85;">{{s.label}}</div><div style="font-size:28px;font-weight:bold;margin-top:8px;">{{s.value}}</div><div style="font-size:12px;margin-top:4px;">{{s.trend}}</div></el-card></el-col>
    </el-row>
    <el-card style="margin-top:20px;"><h4>最近订单</h4>
      <el-table :data="orders" style="margin-top:12px;">
        <el-table-column prop="no" label="订单号" width="180"/><el-table-column prop="user" label="用户"/><el-table-column prop="amt" label="金额"/><el-table-column prop="st" label="状态"><template #default="{row}"><el-tag :type="row.tt" size="small">{{row.st}}</el-tag></template></el-table-column><el-table-column label="操作"><template><el-button size="small">详情</el-button></template></el-table-column>
      </el-table>
    </el-card>
  </div>
</template>
<script setup>import { ref } from 'vue'
const stats=ref([{label:'今日订单',value:128,trend:'+12.3%',color:'linear-gradient(135deg,#667eea,#764ba2)'},{label:'销售额',value:'28,960',trend:'+8.5%',color:'linear-gradient(135deg,#f093fb,#f5576c)'},{label:'新增用户',value:36,trend:'+15.7%',color:'linear-gradient(135deg,#4facfe,#00f2fe)'},{label:'在售商品',value:256,trend:'预警3件',color:'linear-gradient(135deg,#43e97b,#38f9d7)'}])
const orders=ref([{no:'20240604152030',user:'张三',amt:299,st:'已完成',tt:'success'},{no:'20240604151020',user:'李四',amt:168,st:'待发货',tt:'danger'},{no:'20240604145005',user:'王五',amt:545,st:'运输中',tt:'warning'}])</script>