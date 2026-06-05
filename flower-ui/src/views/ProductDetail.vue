<template>
  <div style="max-width:1200px;margin:0 auto;padding:24px;">
    <el-button type="text" @click="">返回</el-button>
    <el-row :gutter="24" style="margin-top:16px;">
      <el-col :span="10"><div style="width:100%;height:400px;background:linear-gradient(135deg,#fbc2eb,#a6c1ee);border-radius:12px;display:flex;align-items:center;justify-content:center;font-size:80px;">Flower</div></el-col>
      <el-col :span="14">
        <h2>99朵红玫瑰花束</h2>
        <p style="color:#909399;">精选厄瓜多尔大花玫瑰</p>
        <div style="background:#fef0f0;padding:16px;border-radius:8px;margin:16px 0;"><span style="font-size:28px;color:#f56c6c;font-weight:bold;">299.00</span><span style="color:#c0c4cc;text-decoration:line-through;margin-left:12px;">399.00</span></div>
        <div style="margin:16px 0;"><p style="font-weight:600;margin-bottom:8px;">规格：</p><el-radio-group v-model="spec"><el-radio-button label="9朵"/><el-radio-button label="33朵"/><el-radio-button label="99朵"/></el-radio-group></div>
        <div style="margin-top:24px;display:flex;gap:12px;"><el-button type="primary" size="large">加入购物车</el-button><el-button type="warning" size="large">立即购买</el-button></div>
      </el-col>
    </el-row>
  </div>
</template>
<script setup>import { ref } from 'vue'; const spec=ref('99朵')</script>