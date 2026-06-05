<template>
  <el-container>
    <el-header style="background:#fff;display:flex;align-items:center;justify-content:space-between;box-shadow:0 1px 4px rgba(0,0,0,.08);padding:0 20px;">
      <h2 style="color:#409eff;cursor:pointer;" @click="$router.push('/')">Flower</h2>
      <div>
        <el-button type="text" @click="$router.push('/products')">商品列表</el-button>
        <el-button type="text" @click="$router.push('/diy')">DIY制作</el-button>
        <el-button type="text" @click="$router.push('/cart')">购物车</el-button>
        <el-button type="text" @click="$router.push('/orders')">我的订单</el-button>
        <el-button type="text" @click="$router.push('/login')">登录</el-button>
      </div>
    </el-header>
    <el-main>
      <div style="background:linear-gradient(135deg,#ffecd2,#fcb69f);border-radius:12px;padding:60px;text-align:center;margin-bottom:30px;">
        <h1 style="font-size:32px;color:#8b4513;">鲜花物语 - 为爱绽放</h1>
        <p style="font-size:16px;color:#a0522d;margin:12px 0;">全场满199减30 | 新人首单9折</p>
      </div>
      <el-row :gutter="20">
        <el-col :span="6" v-for="(p,n) in products" :key="p.id">
          <el-card shadow="hover" @click="$router.push('/product/'+p.id)" style="cursor:pointer;">
            <div style="height:160px;background:linear-gradient(135deg,#fbc2eb,#a6c1ee);border-radius:8px;margin-bottom:12px;display:flex;align-items:center;justify-content:center;font-size:48px;">Flower</div>
            <div style="font-weight:600;">{{ p.name }}</div>
            <div style="color:#f56c6c;font-size:18px;">{{ p.price }}</div>
            <el-tag size="small" v-if="p.tag" style="margin-top:4px;">{{ p.tag }}</el-tag>
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
    products.value = (res.data && res.data.records) ? res.data.records : []
  } catch (e) {
    // fallback
    products.value = [
      { id:1, name:'99朵红玫瑰花束', price:299, tag:'热卖' },
      { id:2, name:'粉玫瑰花盒', price:199, tag:'新品' },
      { id:3, name:'阳光向日葵花束', price:168 },
      { id:4, name:'白百合花束', price:258 },
    ]
  }
})
</script>
