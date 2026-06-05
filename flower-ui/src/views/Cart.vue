<template>
  <el-container>
    <el-header style="background:#fff;display:flex;align-items:center;justify-content:space-between;box-shadow:0 1px 4px rgba(0,0,0,.08);"><h3 style="color:#409eff;cursor:pointer;">Flower</h3><span>购物车</span></el-header>
    <el-main>
      <el-table :data="items">
        <el-table-column label="商品" width="300"><template #default="{row}"><div style="display:flex;align-items:center;gap:12px;"><div style="width:60px;height:60px;border-radius:6px;background:linear-gradient(135deg,#ffecd2,#fcb69f);display:flex;align-items:center;justify-content:center;font-size:24px;">Flower</div><span>{{row.name}}</span></div></template></el-table-column>
        <el-table-column label="单价" width="120"><template #default="{row}">{{row.price}}</template></el-table-column>
        <el-table-column label="数量" width="120"><template #default="{row}"><el-input-number v-model="row.qty" :min="1" size="small"/></template></el-table-column>
        <el-table-column label="小计" width="120"><template #default="{row}">{{row.price*row.qty}}</template></el-table-column>
        <el-table-column label="操作"><template><el-button type="danger" size="small">删除</el-button></template></el-table-column>
      </el-table>
      <div style="text-align:right;margin-top:20px;"><span>合计：</span><span style="font-size:24px;color:#f56c6c;font-weight:bold;">{{total}}</span><el-button type="primary" size="large" style="margin-left:16px;">去结算</el-button></div>
    </el-main>
  </el-container>
</template>
<script setup>import { ref,computed } from 'vue'
const items=ref([{name:'99朵红玫瑰花束',price:299,qty:1},{name:'阳光向日葵花束',price:168,qty:2}])
const total=computed(()=>items.value.reduce((s,i)=>s+i.price*i.qty,0))</script>