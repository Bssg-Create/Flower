<template>
  <el-container style="height:100vh;">
    <el-header style="background:#fff;display:flex;align-items:center;gap:12px;box-shadow:0 1px 4px rgba(0,0,0,.08);">
      <h3 style="color:#409eff;cursor:pointer;" @click="$router.push('/')">Flower</h3><el-divider direction="vertical"/><span>DIY花束制作</span>
      <div style="margin-left:auto;display:flex;gap:8px;"><el-button size="small" @click="$router.push('/cart')">购物车</el-button></div>
    </el-header>
    <el-container style="flex:1;">
      <el-aside width="260px" style="background:#fff;border-right:1px solid #ebeef5;padding:12px;">
        <el-tabs v-model="tab"><el-tab-pane label="花材" name="1"/><el-tab-pane label="丝带" name="2"/><el-tab-pane label="贺卡" name="3"/><el-tab-pane label="灯串" name="4"/></el-tabs>
        <div style="display:grid;grid-template-columns:1fr 1fr;gap:8px;margin-top:8px;">
          <div v-for="m in materials" :key="m.id" style="height:80px;background:linear-gradient(135deg,#fef9ef,#fbc2eb);border-radius:8px;display:flex;align-items:center;justify-content:center;font-size:12px;cursor:pointer;border:1px solid #ebeef5;">{{ m.name }}</div>
        </div>
      </el-aside>
      <el-main style="background:#fafafa;display:flex;align-items:center;justify-content:center;">
        <div style="width:500px;height:500px;border:2px dashed #dcdfe6;border-radius:12px;display:flex;align-items:center;justify-content:center;color:#c0c4cc;font-size:16px;">点击左侧素材编排花束</div>
      </el-main>
    </el-container>
  </el-container>
</template>
<script setup>
import { ref, onMounted } from 'vue'
import { getMaterials } from '@/api/diy'
const tab = ref('1')
const materials = ref([])
onMounted(async () => { try { const r = await getMaterials(); materials.value = r.data || [] } catch(e) {} })
</script>
