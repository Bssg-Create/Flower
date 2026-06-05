<template>
  <el-container style="height:100vh;">
    <el-header style="background:#fff;display:flex;align-items:center;gap:12px;box-shadow:0 1px 4px rgba(0,0,0,.08);">
      <h3 style="color:#409eff;cursor:pointer;">Flower</h3><el-divider direction="vertical"/><span>DIY花束制作</span>
      <div style="margin-left:auto;display:flex;gap:8px;"><el-button size="small">撤销</el-button><el-button size="small">重做</el-button><el-button type="success" size="small">一键推荐</el-button><el-button type="primary" size="small">保存作品</el-button></div>
    </el-header>
    <el-container style="flex:1;">
      <el-aside width="260px" style="background:#fff;border-right:1px solid #ebeef5;padding:12px;">
        <el-tabs v-model="tab"><el-tab-pane label="花材" name="flower"/><el-tab-pane label="丝带" name="ribbon"/><el-tab-pane label="贺卡" name="card"/><el-tab-pane label="灯串" name="light"/></el-tabs>
        <div style="display:grid;grid-template-columns:1fr 1fr;gap:8px;margin-top:8px;"><div v-for="m in 8" :key="m" style="height:80px;background:linear-gradient(135deg,#fef9ef,#fbc2eb);border-radius:8px;display:flex;align-items:center;justify-content:center;font-size:28px;cursor:grab;border:1px solid #ebeef5;">Flower</div></div>
      </el-aside>
      <el-main style="background:#fafafa;display:flex;align-items:center;justify-content:center;"><div style="width:500px;height:500px;border:2px dashed #dcdfe6;border-radius:12px;display:flex;align-items:center;justify-content:center;color:#c0c4cc;font-size:16px;">将左侧素材拖拽到此处编排花束</div></el-main>
    </el-container>
  </el-container>
</template>
<script setup>import { ref } from 'vue'; const tab=ref('flower')</script>