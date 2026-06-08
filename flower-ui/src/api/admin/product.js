import r from '../request'

export const getProducts = (params) => r.get('/admin/products', { params })
export const createProduct = (data) => r.post('/admin/products', data)
export const updateProduct = (id, data) => r.put(`/admin/products/${id}`, data)
export const deleteProduct = (id) => r.delete(`/admin/products/${id}`)
