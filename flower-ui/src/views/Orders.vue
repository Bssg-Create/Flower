<template>
  <el-container>
    <el-header style="background:#fff;display:flex;align-items:center;justify-content:space-between;box-shadow:0 1px 4px rgba(0,0,0,.08);padding:0 20px;">
      <h3 style="color:#409eff;cursor:pointer;" @click="$router.push('/')">Flower</h3>
      <div><el-button type="text" @click="$router.push('/products')">商品列表</el-button><el-button type="text" @click="$router.push('/cart')">购物车</el-button></div>
    </el-header>
    <el-main>
      <el-tabs v-model="tab">
        <el-tab-pane label="全部" name="all"/><el-tab-pane label="待付款" name="1"/><el-tab-pane label="待发货" name="2"/><el-tab-pane label="运输中" name="3"/><el-tab-pane label="已完成" name="4"/>
      </el-tabs>
      <el-empty v-if="!orders.length" description="暂无订单" />
      <el-card v-for="o in orders" :key="o.id" style="margin-bottom:12px;">
        <div style="display:flex;justify-content:space-between;margin-bottom:8px;"><span style="color:#909399;">订单号：{{o.orderNo || o.no}}</span><el-tag :type="statusTag(o.status)">{{statusText(o.status)}}</el-tag></div>
        <div style="display:flex;gap:8px;margin-bottom:8px;">
          <div v-for="(item,i) in (o.items||[])" :key="i" style="width:50px;height:50px;background:linear-gradient(135deg,#fbc2eb,#a6c1ee);border-radius:4px;display:flex;align-items:center;justify-content:center;font-size:12px;">{{item.productName}}</div>
        </div>
        <div style="text-align:right;font-weight:bold;">合计：{{ o.totalAmount || o.amt }}</div>
      </el-card>
    </el-main>
  </el-container>
</template>
<script setup>
import { ref, onMounted } from 'vue'
import { getOrders } from '@/api/order'
const tab = ref('all')
const orders = ref([])
const statusTag = (s) => ({1:'warning',2:'danger',3:'',4:'success'}[s]||'info')
const statusText = (s) => ({1:'待付款',2:'待发货',3:'运输中',4:'已完成',5:'已取消'}[s]||'未知')
onMounted(async () => { try { const r = await getOrders(); orders.value = r.data || [] } catch(e) {} })
</script>
