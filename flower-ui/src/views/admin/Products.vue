<template>
  <div>
    <div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:16px;"><h3>商品管理</h3><el-button type="primary" @click="s=true">新增商品</el-button></div>
    <el-table :data="list" border>
      <el-table-column prop="id" label="ID" width="60"/><el-table-column prop="name" label="商品名称"/><el-table-column prop="price" label="价格"/><el-table-column prop="stock" label="库存"/><el-table-column prop="status" label="状态"><template #default="{row}"><el-tag :type="row.status===1?'success':'info'" size="small">{{row.status===1?'上架':'下架'}}</el-tag></template></el-table-column>
      <el-table-column label="操作" width="150"><template><el-button size="small">编辑</el-button><el-button size="small" type="danger">删除</el-button></template></el-table-column>
    </el-table>
    <el-dialog v-model="s" title="新增商品" width="500px"><el-form label-width="80px"><el-form-item label="名称"><el-input/></el-form-item><el-form-item label="分类"><el-select style="width:100%"><el-option label="玫瑰"/></el-select></el-form-item><el-form-item label="价格"><el-input-number :min="0"/></el-form-item><el-form-item label="库存"><el-input-number :min="0"/></el-form-item></el-form><template #footer><el-button @click="s=false">取消</el-button><el-button type="primary" @click="s=false">确认</el-button></template></el-dialog>
  </div>
</template>
<script setup>import { ref } from 'vue'
const s=ref(false)
const list=ref([{id:1,name:'99朵红玫瑰花束',price:299,stock:128,status:1},{id:2,name:'阳光向日葵',price:168,stock:86,status:1},{id:3,name:'白百合花束',price:258,stock:52,status:1},{id:4,name:'粉康乃馨',price:188,stock:0,status:0}])</script>