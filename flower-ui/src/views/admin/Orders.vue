<template>
  <div>
    <h3 style="margin-bottom:16px;">订单管理</h3>
    <el-table :data="list" border v-loading="loading">
      <el-table-column prop="orderNo" label="订单号" width="200"/>
      <el-table-column prop="userId" label="用户ID" width="80"/>
      <el-table-column prop="totalAmount" label="金额" width="100"/>
      <el-table-column prop="address" label="收货地址" min-width="150"/>
      <el-table-column label="状态" width="140">
        <template #default="{row}">
          <el-select v-model="row.status" size="small" @change="updateStatus(row)">
            <el-option label="待付款" :value="1"/>
            <el-option label="待发货" :value="2"/>
            <el-option label="运输中" :value="3"/>
            <el-option label="已完成" :value="4"/>
          </el-select>
        </template>
      </el-table-column>
      <el-table-column label="时间" width="180">
        <template #default="{row}">{{ row.createTime }}</template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script setup>
import { ref, onMounted } from 'vue'
import { getOrders, updateOrderStatus } from '@/api/admin/order'
import { ElMessage } from 'element-plus'

const list = ref([])
const loading = ref(false)

const fetchData = async () => {
  loading.value = true
  try {
    const r = await getOrders({ page: 1, size: 100 })
    list.value = r.data && r.data.records ? r.data.records : []
  } catch(e) {}
  loading.value = false
}

const updateStatus = async (row) => {
  try {
    await updateOrderStatus(row.id, row.status)
    ElMessage.success('状态已更新')
  } catch(e) {
    fetchData()
  }
}

onMounted(fetchData)
</script>