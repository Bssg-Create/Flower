<template>
  <el-container>
    <el-header style="background:#fff;display:flex;align-items:center;box-shadow:0 1px 4px rgba(0,0,0,.08);"><h3 style="color:#409eff;cursor:pointer;">Flower</h3></el-header>
    <el-main>
      <el-tabs v-model="tab"><el-tab-pane label="全部" name="all"/><el-tab-pane label="待付款" name="1"/><el-tab-pane label="待发货" name="2"/><el-tab-pane label="运输中" name="3"/><el-tab-pane label="已完成" name="4"/></el-tabs>
      <el-card v-for="o in list" :key="o.id" style="margin-bottom:12px;">
        <div style="display:flex;justify-content:space-between;margin-bottom:8px;"><span style="color:#909399;">订单号：{{o.no}}</span><el-tag :type="o.tt">{{o.st}}</el-tag></div>
        <div style="display:flex;gap:8px;margin-bottom:8px;"><div v-for="i in o.n" :key="i" style="width:50px;height:50px;background:linear-gradient(135deg,#fbc2eb,#a6c1ee);border-radius:4px;display:flex;align-items:center;justify-content:center;">Flower</div></div>
        <div style="text-align:right;font-weight:bold;">合计：{{o.amt}}</div>
      </el-card>
    </el-main>
  </el-container>
</template>
<script setup>import { ref } from 'vue'
const tab=ref('all')
const list=ref([{id:1,no:'20240604152030',amt:467,n:2,st:'已完成',tt:'success'},{id:2,no:'20240603213045',amt:199,n:1,st:'运输中',tt:'warning'},{id:3,no:'20240601100010',amt:545,n:3,st:'待发货',tt:'danger'}])</script>