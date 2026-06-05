import { createRouter, createWebHistory } from 'vue-router'
const routes = [
  { path: '/', component: () => import('@/views/Home.vue'), meta: { requiresAuth: true } },
  { path: '/login', component: () => import('@/views/Login.vue') },
  { path: '/products', component: () => import('@/views/ProductList.vue'), meta: { requiresAuth: true } },
  { path: '/product/:id', component: () => import('@/views/ProductDetail.vue'), meta: { requiresAuth: true } },
  { path: '/diy', component: () => import('@/views/DiyWorkshop.vue'), meta: { requiresAuth: true } },
  { path: '/cart', component: () => import('@/views/Cart.vue'), meta: { requiresAuth: true } },
  { path: '/orders', component: () => import('@/views/Orders.vue'), meta: { requiresAuth: true } },
  { path: '/admin', component: () => import('@/views/admin/AdminLayout.vue'), meta: { requiresAuth: true },
    children: [
      { path: '', component: () => import('@/views/admin/Dashboard.vue') },
      { path: 'products', component: () => import('@/views/admin/Products.vue') },
      { path: 'orders', component: () => import('@/views/admin/Orders.vue') }
    ]
  }
]
const router = createRouter({ history: createWebHistory(), routes })
router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token')
  if (to.path === '/login') {
    if (token) next('/')
    else next()
  } else if (to.meta.requiresAuth) {
    if (!token) next('/login')
    else next()
  } else {
    next()
  }
})
export default router
