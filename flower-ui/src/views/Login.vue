<template>
  <div style="display:flex;justify-content:center;align-items:center;min-height:100vh;background:#f5f7fa;">
    <el-card style="width:400px;">
      <h2 style="text-align:center;margin-bottom:24px;color:#409eff;">Flower 登录</h2>
      <el-form :model="form" label-position="top">
        <el-form-item label="用户名"><el-input v-model="form.username" /></el-form-item>
        <el-form-item label="密码"><el-input v-model="form.password" type="password" show-password /></el-form-item>
        <el-form-item><el-button type="primary" style="width:100%;" @click="login">登 录</el-button></el-form-item>
      </el-form>
      <div style="text-align:center;color:#909399;">没有账号？<el-link type="primary" @click="s=true">立即注册</el-link></div>
      <el-dialog v-model="s" title="用户注册" width="360px">
        <el-form :model="rf"><el-form-item label="用户名"><el-input v-model="rf.username"/></el-form-item><el-form-item label="密码"><el-input v-model="rf.password" type="password"/></el-form-item><el-form-item label="手机号"><el-input v-model="rf.phone"/></el-form-item></el-form>
        <template #footer><el-button @click="s=false">取消</el-button><el-button type="primary" @click="reg">注册</el-button></template>
      </el-dialog>
    </el-card>
  </div>
</template>
<script setup>
import { ref,reactive } from 'vue'
import { useRouter } from 'vue-router'
import { useUserStore } from '@/store/user'
import { register } from '@/api/user'
import { ElMessage } from 'element-plus'
const router=useRouter(),store=useUserStore(),form=reactive({username:'',password:''})
const s=ref(false),rf=reactive({username:'',password:'',phone:''})
const login=async()=>{try{await store.login(form);ElMessage.success('ok');router.push('/')}catch(e){}}
const reg=async()=>{try{await register(rf);ElMessage.success('ok');s.value=false}catch(e){}}
</script>