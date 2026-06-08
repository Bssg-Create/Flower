import axios from 'axios'
import { ElMessage } from 'element-plus'
const r = axios.create({ baseURL: '/api', timeout: 10000 })

r.interceptors.request.use(c => {
  const t = localStorage.getItem('token')
  if (t) c.headers.Authorization = 'Bearer ' + t
  return c
})

r.interceptors.response.use(
  res => {
    if (res.data.code !== 200) {
      ElMessage.error(res.data.msg)
      return Promise.reject(res.data.msg)
    }
    return res.data
  },
  err => {
    if (err.response && err.response.status === 403) {
      ElMessage.error('请先登录')
      localStorage.removeItem('token')
      window.location.href = '/login'
      return Promise.reject(err)
    }
    ElMessage.error('网络错误')
    return Promise.reject(err)
  }
)

export default r