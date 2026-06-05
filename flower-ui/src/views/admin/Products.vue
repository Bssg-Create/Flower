<template>
  <div>
    <div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:16px;"><h3>商品管理</h3><el-button type="primary" @click="s=true">新增商品</el-button></div>
    <el-table :data="list" border>
      <el-table-column prop="id" label="ID" width="60"/><el-table-column prop="name" label="商品名称"/><el-table-column prop="price" label="价格"/><el-table-column prop="stock" label="库存"/>
      <el-table-column label="状态"><template #default="{row}"><el-tag :type="row.status===1?'success':'info'" size="small">{{row.status===1?'上架':'下架'}}</el-tag></template></el-table-column>
      <el-table-column label="操作" width="180"><template><el-button size="small" @click="editRow">编辑</el-button><el-button size="small" type="danger">删除</el-button></template></el-table-column>
    </el-table>
    <el-dialog v-model="s" title="新增商品" width="500px"><el-form label-width="80px"><el-form-item label="名称"><el-input v-model="f.name"/></el-form-item><el-form-item label="价格"><el-input-number v-model="f.price" :min="0"/></el-form-item><el-form-item label="库存"><el-input-number v-model="f.stock" :min="0"/></el-form-item></el-form><template #footer><el-button @click="s=false">取消</el-button><el-button type="primary" @click="save">确认</el-button></template></el-dialog>
  </div>
</template>
<script setup>
import { ref, reactive, onMounted } from 'vue'
import { getProducts } from '@/api/product'
import { ElMessage } from 'element-plus'
const list=ref([]),s=ref(false),f=reactive({name:'',price:0,stock:0})
onMounted(async()=>{try{const r=await getProducts({page:1,size:100});list.value=r.data&&r.data.records?r.data.records:[]}catch(e){}})
const editRow=()=>ElMessage.info('编辑功能待实现')
const save=()=>{s.value=false;ElMessage.success('新增成功(演示)')}
</script>
