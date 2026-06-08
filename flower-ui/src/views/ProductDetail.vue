<template>
  <div style="max-width:1200px;margin:0 auto;padding:24px;">
    <el-button link @click="$router.back()">返回</el-button>
    <el-row :gutter="24" style="margin-top:16px;">
      <el-col :span="10"><div style="width:100%;height:400px;background:linear-gradient(135deg,#fbc2eb,#a6c1ee);border-radius:12px;display:flex;align-items:center;justify-content:center;font-size:80px;">Flower</div></el-col>
      <el-col :span="14">
        <h2>{{ product.name }}</h2>
        <p style="color:#909399;">{{ product.description || '精选鲜花，品质保证' }}</p>
        <div style="background:#fef0f0;padding:16px;border-radius:8px;margin:16px 0;"><span style="font-size:28px;color:#f56c6c;font-weight:bold;">{{ product.price }}</span></div>
        <div style="margin-top:24px;display:flex;gap:12px;">
          <el-button type="primary" size="large" @click="addCart">加入购物车</el-button>
          <el-button type="warning" size="large" @click="buyNow">立即购买</el-button>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { getProduct } from '@/api/product'
import { addToCart } from '@/api/cart'
import { ElMessage } from 'element-plus'
const route = useRoute()
const router = useRouter()
const product = ref({})

onMounted(async () => {
  try {
    const res = await getProduct(route.params.id)
    product.value = res.data || {}
  } catch (e) { ElMessage.error('商品不存在') }
})

const addCart = async () => {
  try {
    await addToCart({ productId: product.value.id, quantity: 1 })
    ElMessage.success('已加入购物车')
  } catch (e) {}
}
const buyNow = () => { addCart(); router.push('/cart') }
</script>