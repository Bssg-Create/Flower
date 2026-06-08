<template>
  <el-container>
    <el-header style="background:#fff;display:flex;align-items:center;justify-content:space-between;box-shadow:0 1px 4px rgba(0,0,0,.08);padding:0 20px;">
      <h2 style="color:#409eff;cursor:pointer;" @click="$router.push('/')">Flower</h2>
      <div>
        <el-button link @click="$router.push('/products')">商品列表</el-button>
        <el-button link @click="$router.push('/diy')">DIY制作</el-button>
        <el-button link @click="$router.push('/cart')">购物车</el-button>
        <el-button link @click="$router.push('/orders')">我的订单</el-button>
        <el-button link @click="$router.push('/login')">登录</el-button>
      </div>
    </el-header>
    <el-main>
      <div style="text-align:center;padding:40px 0;">
        <h1 style="font-size:36px;color:#303133;">精选鲜花，传递心意</h1>
        <p style="color:#909399;margin-top:12px;">每一束花都是用心之作</p>
      </div>
      <el-row :gutter="16">
        <el-col :span="6" v-for="p in products" :key="p.id">
          <el-card :body-style="{padding:'12px'}" shadow="hover" style="cursor:pointer;" @click="$router.push('/product/'+p.id)">
            <div style="height:160px;background:linear-gradient(135deg,#fbc2eb,#a6c1ee);border-radius:8px;display:flex;align-items:center;justify-content:center;font-size:48px;">Flower</div>
            <div style="margin-top:8px;font-size:14px;font-weight:500;">{{p.name}}</div>
            <div style="color:#f56c6c;font-size:16px;font-weight:bold;margin-top:4px;">{{p.price}}</div>
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
    const res = await getProducts({ page: 1, size: 4 })
    products.value = res.data && res.data.records ? res.data.records : []
  } catch(e) {}
})
</script>