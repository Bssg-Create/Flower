<template>
  <div>
    <div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:16px;">
      <h3>商品管理</h3>
      <el-button type="primary" @click="openAdd">新增商品</el-button>
    </div>
    <el-table :data="list" border v-loading="loading">
      <el-table-column prop="id" label="ID" width="60"/>
      <el-table-column prop="name" label="商品名称"/>
      <el-table-column prop="price" label="价格" width="100"/>
      <el-table-column prop="stock" label="库存" width="80"/>
      <el-table-column label="状态" width="80">
        <template #default="{row}">
          <el-tag :type="row.status===1?'success':'info'" size="small">{{row.status===1?'上架':'下架'}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="180">
        <template #default="{row}">
          <el-button size="small" @click="openEdit(row)">编辑</el-button>
          <el-button size="small" type="danger" @click="handleDelete(row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog v-model="dialogVisible" :title="isEdit?'编辑商品':'新增商品'" width="500px">
      <el-form label-width="80px">
        <el-form-item label="名称"><el-input v-model="form.name"/></el-form-item>
        <el-form-item label="价格"><el-input-number v-model="form.price" :min="0" :precision="2"/></el-form-item>
        <el-form-item label="库存"><el-input-number v-model="form.stock" :min="0"/></el-form-item>
        <el-form-item label="描述"><el-input v-model="form.description" type="textarea"/></el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible=false">取消</el-button>
        <el-button type="primary" @click="handleSave" :loading="saving">确认</el-button>
      </template>
    </el-dialog>
  </div>
</template>
<script setup>
import { ref, reactive, onMounted } from 'vue'
import { getProducts, createProduct, updateProduct, deleteProduct } from '@/api/admin/product'
import { ElMessage, ElMessageBox } from 'element-plus'

const list = ref([])
const loading = ref(false)
const saving = ref(false)
const dialogVisible = ref(false)
const isEdit = ref(false)
const editId = ref(null)
const form = reactive({ name: '', price: 0, stock: 0, description: '' })

const fetchData = async () => {
  loading.value = true
  try {
    const r = await getProducts({ page: 1, size: 100 })
    list.value = r.data && r.data.records ? r.data.records : []
  } catch(e) {}
  loading.value = false
}

const openAdd = () => {
  isEdit.value = false
  editId.value = null
  form.name = ''; form.price = 0; form.stock = 0; form.description = ''
  dialogVisible.value = true
}

const openEdit = (row) => {
  isEdit.value = true
  editId.value = row.id
  form.name = row.name
  form.price = row.price
  form.stock = row.stock
  form.description = row.description || ''
  dialogVisible.value = true
}

const handleSave = async () => {
  saving.value = true
  try {
    if (isEdit.value) {
      await updateProduct(editId.value, { ...form, categoryId: 1 })
      ElMessage.success('更新成功')
    } else {
      await createProduct({ ...form, categoryId: 1 })
      ElMessage.success('新增成功')
    }
    dialogVisible.value = false
    fetchData()
  } catch(e) {}
  saving.value = false
}

const handleDelete = async (id) => {
  try {
    await ElMessageBox.confirm('确定删除该商品？', '提示', { type: 'warning' })
    await deleteProduct(id)
    ElMessage.success('删除成功')
    fetchData()
  } catch(e) {}
}

onMounted(fetchData)
</script>