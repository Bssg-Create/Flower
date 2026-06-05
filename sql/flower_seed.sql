-- ============================================================
-- Flower 测试种子数据
-- 运行方式: 在 flower_db.sql 之后运行
-- ============================================================
USE flower_db;

-- 测试用户 (密码: 123456, BCrypt加密)
INSERT INTO `user` (`username`, `password`, `phone`, `status`) VALUES
('testuser', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iAt6Z5Eh', '13800138000', 1);

-- 管理员
INSERT INTO `admin` (`username`, `password`, `status`) VALUES
('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iAt6Z5Eh', 1);

-- 商品分类
INSERT INTO `category` (`name`, `sort`) VALUES
('鲜花束', 1), ('花盒', 2), ('永生花', 3), ('花篮', 4);

-- 示例商品
INSERT INTO `product` (`category_id`, `name`, `price`, `stock`, `status`, `description`) VALUES
(1, '红玫瑰花束', 299.00, 100, 1, '99朵红玫瑰，爱意浓浓'),
(1, '粉玫瑰花束', 259.00, 80, 1, '33朵粉玫瑰，温柔浪漫'),
(2, '精致花盒', 199.00, 50, 1, '精美礼盒装'),
(3, '永生花礼盒', 399.00, 30, 1, '进口永生花，持久保存'),
(4, '开业花篮', 599.00, 20, 1, '喜庆开业大花篮');

-- 运费模板
INSERT INTO `delivery_template` (`name`, `base_fee`, `free_threshold`) VALUES
('同城配送', 15.00, 199.00),
('省内快递', 25.00, 299.00);
