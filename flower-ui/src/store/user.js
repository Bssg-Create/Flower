import { defineStore } from 'pinia'
import { ref } from 'vue'
import { login as api } from '@/api/user'
export const useUserStore=defineStore('user',()=>{
  const token=ref(localStorage.getItem('token')||'')
  const login=async d=>{const r=await api(d);token.value=r.data.token;localStorage.setItem('token',r.data.token);localStorage.setItem('username',r.data.username)}
  const logout=()=>{token.value='';localStorage.removeItem('token');localStorage.removeItem('username')}
  return{token,login,logout}
})