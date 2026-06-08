<template>
  <el-container>
    <el-header style="background:#fff;display:flex;align-items:center;justify-content:space-between;box-shadow:0 1px 4px rgba(0,0,0,.08);padding:0 20px;">
      <h3 style="color:#409eff;cursor:pointer;" @click="$router.push('/')">Flower</h3>
      <div><el-button link @click="$router.push('/products')">商品列表</el-button><el-button link @click="$router.push('/cart')">购物车</el-button></div>
    </el-header>
    <el-main>
      <h3 style="margin-bottom:16px;">我的订单</h3>
      <el-table :data="orders" v-if="orders.length">
        <el-table-column prop="orderNo" label="订单号" width="200"/>
        <el-table-column label="商品" width="200">
          <template #default="{row}">
            <span v-for="item in row.items" :key="item.productId">{{ item.productName }} x{{ item.quantity }} </span>
          </template>
        </el-table-column>
        <el-table-column prop="totalAmount" label="金额" width="100"/>
        <el-table-column label="状态" width="100">
          <template #default="{row}">
            <el-tag :type="row.status===1?'warning':row.status===4?'success':''" size="small">{{ statusText(row.status) }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="时间" width="180"/>
      </el-table>
      <el-empty v-else description="暂无订单" />
    </el-main>
  </el-container>
</template>
<script setup>
import { ref, onMounted } from 'vue'
import { getOrders } from '@/api/order'
const orders = ref([])
const statusText = (s) => ({1:'待付款',2:'待发货',3:'运输中',4:'已完成'}[s]||'未知')
onMounted(async () => { try { const r = await getOrders(); orders.value = r.data || [] } catch(e) {} })
</script>