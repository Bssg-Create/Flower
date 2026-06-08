import r from '../request'

export const getOrders = (params) => r.get('/admin/orders', { params })
export const updateOrderStatus = (id, status) => r.put(`/admin/orders/${id}/status`, null, { params: { status } })
