<template>
  <el-container>
    <el-header style="background:#fff;display:flex;align-items:center;justify-content:space-between;box-shadow:0 1px 4px rgba(0,0,0,.08);padding:0 20px;">
      <h3 style="color:#409eff;cursor:pointer;" @click="$router.push('/')">Flower</h3>
      <div>
        <el-button type="text" @click="$router.push('/diy')">DIY制作</el-button>
        <el-button type="text" @click="$router.push('/cart')">购物车</el-button>
        <el-button type="text" @click="$router.push('/orders')">我的订单</el-button>
      </div>
    </el-header>
    <el-main>
      <el-row :gutter="16">
        <el-col :span="6" v-for="p in products" :key="p.id" style="margin-bottom:16px;">
          <el-card shadow="hover" @click="$router.push('/product/'+p.id)" style="cursor:pointer;">
            <div style="height:180px;background:linear-gradient(135deg,#fbc2eb,#a6c1ee);border-radius:6px;margin-bottom:12px;display:flex;align-items:center;justify-content:center;font-size:40px;">Flower</div>
            <div style="font-weight:600;">{{ p.name }}</div>
            <div style="color:#f56c6c;font-size:18px;font-weight:bold;">{{ p.price }}</div>
            <el-tag size="small" v-if="p.holidayTag" style="margin-top:4px;">{{ p.holidayTag }}</el-tag>
          </el-card>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>
<script setup>
import { ref, onMounted } from 'vue'
import { getProducts } from '@/api/product'
const products = ref([])
onMounted(async () => {
  try {
    const res = await getProducts({ page: 1, size: 20 })
    products.value = res.data && res.data.records ? res.data.records : []
  } catch (e) {}
})
</script>
