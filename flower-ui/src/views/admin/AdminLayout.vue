<template>
  <el-container style="min-height:100vh;">
    <el-aside width="200px" style="background:#304156;">
      <div style="padding:20px;text-align:center;color:#fff;font-size:18px;font-weight:bold;">Flower 后台</div>
      <el-menu :default-active="route.path" background-color="#304156" text-color="#bfcbd9" active-text-color="#409eff" router>
        <el-menu-item index="/admin">仪表盘</el-menu-item>
        <el-menu-item index="/admin/products">商品管理</el-menu-item>
        <el-menu-item index="/admin/orders">订单管理</el-menu-item>
      </el-menu>
      <div style="position:absolute;bottom:20px;width:100%;text-align:center;">
        <el-button link style="color:#bfcbd9;" @click="$router.push('/')">返回首页</el-button>
      </div>
    </el-aside>
    <el-container><el-main><router-view/></el-main></el-container>
  </el-container>
</template>
<script setup>import { useRoute } from 'vue-router'; const route=useRoute()</script>