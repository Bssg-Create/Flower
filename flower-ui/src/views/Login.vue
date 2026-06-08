<template>
  <div style="display:flex;justify-content:center;align-items:center;min-height:100vh;background:#f5f7fa;">
    <el-card style="width:400px;">
      <h2 style="text-align:center;margin-bottom:24px;color:#409eff;">Flower 登录</h2>
      <el-form :model="form" label-position="top">
        <el-form-item label="用户名"><el-input v-model="form.username" placeholder="请输入用户名" /></el-form-item>
        <el-form-item label="密码"><el-input v-model="form.password" type="password" placeholder="请输入密码" show-password /></el-form-item>
        <el-form-item><el-button type="primary" style="width:100%;" @click="handleLogin">登 录</el-button></el-form-item>
      </el-form>
      <div style="text-align:center;color:#909399;">没有账号？<el-link type="primary" @click="s=true">立即注册</el-link></div>

      <el-dialog v-model="s" title="用户注册" width="360px">
        <el-form :model="rf">
          <el-form-item label="用户名"><el-input v-model="rf.username" placeholder="用户名" /></el-form-item>
          <el-form-item label="密码"><el-input v-model="rf.password" type="password" placeholder="密码" /></el-form-item>
          <el-form-item label="手机号"><el-input v-model="rf.phone" placeholder="手机号" /></el-form-item>
        </el-form>
        <template #footer><el-button @click="s=false">取消</el-button><el-button type="primary" @click="handleReg">注册</el-button></template>
      </el-dialog>
    </el-card>
  </div>
</template>
<script setup>
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'
import { useUserStore } from '@/store/user'
import { register } from '@/api/user'
import { ElMessage } from 'element-plus'
const router = useRouter()
const store = useUserStore()
const form = reactive({ username: '', password: '' })
const s = ref(false)
const rf = reactive({ username: '', password: '', phone: '' })

const handleLogin = async () => {
  if (!form.username || !form.password) { ElMessage.warning('请输入用户名和密码'); return }
  try {
    await store.login(form)
    ElMessage.success('登录成功')
    router.push('/')
  } catch (e) {}
}

const handleReg = async () => {
  if (!rf.username || !rf.password) { ElMessage.warning('请填写用户名和密码'); return }
  try {
    await register(rf)
    ElMessage.success('注册成功，请登录')
    s.value = false
  } catch (e) {}
}
</script>