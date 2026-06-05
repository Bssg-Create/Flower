import { createRouter, createWebHistory } from 'vue-router'
const routes = [
  { path: '/', component: () => import('@/views/Home.vue') },
  { path: '/login', component: () => import('@/views/Login.vue') },
  { path: '/products', component: () => import('@/views/ProductList.vue') },
  { path: '/product/:id', component: () => import('@/views/ProductDetail.vue') },
  { path: '/diy', component: () => import('@/views/DiyWorkshop.vue') },
  { path: '/cart', component: () => import('@/views/Cart.vue') },
  { path: '/orders', component: () => import('@/views/Orders.vue') },
  { path: '/admin', component: () => import('@/views/admin/AdminLayout.vue'),
    children: [
      { path: '', component: () => import('@/views/admin/Dashboard.vue') },
      { path: 'products', component: () => import('@/views/admin/Products.vue') },
      { path: 'orders', component: () => import('@/views/admin/Orders.vue') }
    ]
  }
]
export default createRouter({ history: createWebHistory(), routes })