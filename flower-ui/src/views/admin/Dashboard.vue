<template>
  <div>
    <h3 style="margin-bottom:20px;">数据仪表盘</h3>
    <el-row :gutter="16">
      <el-col :span="8">
        <el-card :body-style="{padding:'20px',background:'linear-gradient(135deg,#667eea,#764ba2)',color:'#fff',borderRadius:'8px'}">
          <div style="font-size:14px;opacity:.85;">商品总数</div>
          <div style="font-size:32px;font-weight:bold;margin-top:8px;">{{ stats.productCount }}</div>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card :body-style="{padding:'20px',background:'linear-gradient(135deg,#f093fb,#f5576c)',color:'#fff',borderRadius:'8px'}">
          <div style="font-size:14px;opacity:.85;">订单总数</div>
          <div style="font-size:32px;font-weight:bold;margin-top:8px;">{{ stats.orderCount }}</div>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card :body-style="{padding:'20px',background:'linear-gradient(135deg,#4facfe,#00f2fe)',color:'#fff',borderRadius:'8px'}">
          <div style="font-size:14px;opacity:.85;">用户总数</div>
          <div style="font-size:32px;font-weight:bold;margin-top:8px;">{{ stats.userCount }}</div>
        </el-card>
      </el-col>
    </el-row>
    <el-card style="margin-top:20px;">
      <h4>最近订单</h4>
      <el-table :data="recentOrders" style="margin-top:12px;" v-loading="loading">
        <el-table-column prop="orderNo" label="订单号" width="200"/>
        <el-table-column prop="userId" label="用户ID" width="80"/>
        <el-table-column prop="totalAmount" label="金额" width="100"/>
        <el-table-column label="状态" width="100">
          <template #default="{row}">
            <el-tag :type="statusType(row.status)" size="small">{{ statusText(row.status) }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="时间" width="180"/>
      </el-table>
    </el-card>
  </div>
</template>
<script setup>
import { ref, reactive, onMounted } from 'vue'
import { getDashboard } from '@/api/admin/dashboard'
import { getOrders } from '@/api/admin/order'

const stats = reactive({ productCount: 0, orderCount: 0, userCount: 0 })
const recentOrders = ref([])
const loading = ref(false)

const statusText = (s) => ({1:'待付款',2:'待发货',3:'运输中',4:'已完成'}[s]||'未知')
const statusType = (s) => ({1:'warning',2:'danger',3:'',4:'success'}[s]||'info')

onMounted(async () => {
  loading.value = true
  try {
    const [dash, orders] = await Promise.all([
      getDashboard(),
      getOrders({ page: 1, size: 5 })
    ])
    if (dash.data) Object.assign(stats, dash.data)
    recentOrders.value = orders.data ? orders.data.records : []
  } catch(e) {}
  loading.value = false
})
</script>