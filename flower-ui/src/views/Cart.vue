<template>
  <el-container>
    <el-header style="background:#fff;display:flex;align-items:center;justify-content:space-between;box-shadow:0 1px 4px rgba(0,0,0,.08);padding:0 20px;">
      <h3 style="color:#409eff;cursor:pointer;" @click="$router.push('/')">Flower</h3>
      <div><el-button type="text" @click="$router.push('/products')">继续购物</el-button><el-button type="text" @click="$router.push('/orders')">我的订单</el-button></div>
    </el-header>
    <el-main>
      <el-table :data="items" v-if="items.length">
        <el-table-column label="商品" width="300"><template #default="{row}"><div style="display:flex;align-items:center;gap:12px;">{{row.productName}}</div></template></el-table-column>
        <el-table-column label="单价" width="120"><template #default="{row}">{{row.price}}</template></el-table-column>
        <el-table-column label="数量" width="120"><template #default="{row}"><el-input-number v-model="row.quantity" :min="1" size="small"/></template></el-table-column>
        <el-table-column label="小计" width="120"><template #default="{row}">{{ (row.price||0) * (row.quantity||0) }}</template></el-table-column>
        <el-table-column label="操作"><template #default="{row}"><el-button type="danger" size="small" @click="remove(row.id)">删除</el-button></template></el-table-column>
      </el-table>
      <el-empty v-else description="购物车空空如也" />
      <div style="text-align:right;margin-top:20px;" v-if="items.length">
        <span>合计：</span><span style="font-size:24px;color:#f56c6c;font-weight:bold;">{{total}}</span>
        <el-button type="primary" size="large" style="margin-left:16px;" @click="checkout">去结算</el-button>
      </div>
    </el-main>
  </el-container>
</template>
<script setup>
import { ref,computed,onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { getCart, removeFromCart } from '@/api/cart'
import { ElMessage } from 'element-plus'
const router = useRouter()
const items = ref([])
const total = computed(() => items.value.reduce((s,i) => s + (i.price||0)*(i.quantity||0), 0))

onMounted(async () => { try { const r = await getCart(); items.value = r.data || [] } catch(e) {} })

const remove = async (id) => { try { await removeFromCart(id); items.value = items.value.filter(i => i.id !== id) } catch(e) {} }
const checkout = () => ElMessage.success('订单已提交') && router.push('/orders')
</script>
