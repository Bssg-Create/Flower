<template>
  <el-container>
    <el-header style="background:#fff;display:flex;align-items:center;justify-content:space-between;box-shadow:0 1px 4px rgba(0,0,0,.08);">
      <h3 style="color:#409eff;cursor:pointer;" @click="">Flower</h3>
      <div><el-button type="text" @click="">购物车</el-button><el-button type="text" @click="">我的订单</el-button></div>
    </el-header>
    <el-main>
      <el-row :gutter="16">
        <el-col :span="6" v-for="p in list" :key="p.id" style="margin-bottom:16px;">
          <el-card shadow="hover" @click="" style="cursor:pointer;">
            <div style="height:180px;background:linear-gradient(135deg,#fbc2eb,#a6c1ee);border-radius:6px;margin-bottom:12px;display:flex;align-items:center;justify-content:center;font-size:40px;">Flower</div>
            <div style="font-weight:600;">{{ p.name }}</div>
            <div style="color:#f56c6c;font-size:18px;font-weight:bold;">{{ p.price }}</div>
            <el-tag size="small" v-if="p.tag">{{ p.tag }}</el-tag>
          </el-card>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>
<script setup>
import { ref } from 'vue'
const list=ref([{id:1,name:'99朵红玫瑰花束',price:299,tag:'热卖'},{id:2,name:'粉玫瑰花盒',price:199,tag:'新品'},{id:3,name:'阳光向日葵花束',price:168},{id:4,name:'白百合花束',price:258},{id:5,name:'粉色康乃馨',price:188,tag:'母亲节'},{id:6,name:'多肉盆栽礼盒',price:128},{id:7,name:'薰衣草花束',price:158},{id:8,name:'满天星花束',price:99,tag:'新品'}])
</script>