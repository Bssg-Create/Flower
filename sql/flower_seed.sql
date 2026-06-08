USE flower_db;

-- 商品分类 (column order: name, parent_id, sort, created_at, updated_at)
INSERT INTO category (name, parent_id, sort, created_at, updated_at) VALUES
('鲜花束', NULL, 1, NOW(), NOW()),
('花盒', NULL, 2, NOW(), NOW()),
('永生花', NULL, 3, NOW(), NOW()),
('花篮', NULL, 4, NOW(), NOW());

-- 商品 (columns: category_id, name, price, stock, status, description, holiday_tag)
INSERT INTO product (category_id, name, price, stock, status, description, holiday_tag, created_at, updated_at) VALUES
(1, '99朵红玫瑰花束', 299.00, 100, 1, '经典红玫瑰花束，99朵精选红玫瑰，搭配满天星和绿叶，浪漫首选', 'valentine', NOW(), NOW()),
(1, '33朵粉玫瑰花束', 259.00, 80, 1, '温柔粉玫瑰，33朵代表三生三世，适合表白送礼', 'valentine', NOW(), NOW()),
(1, '11朵蓝玫瑰花束', 199.00, 60, 1, '蓝色妖姬玫瑰花束，11朵代表一心一意', NULL, NOW(), NOW()),
(1, '百合康乃馨混搭花束', 219.00, 40, 1, '百合与康乃馨的完美搭配，温馨大方', 'mothersday', NOW(), NOW()),
(1, '12朵粉色康乃馨', 159.00, 70, 1, '粉色康乃馨代表母爱，母亲节首选', 'mothersday', NOW(), NOW()),
(2, '精致圆形花盒', 199.00, 30, 1, '韩式圆形花盒，内含玫瑰、绣球等多种花材', NULL, NOW(), NOW()),
(2, '心形玫瑰花盒', 259.00, 25, 1, '红色心形花盒，浪漫表白神器', 'valentine', NOW(), NOW()),
(3, '永生花玻璃罩', 399.00, 20, 1, '进口永生玫瑰，玻璃罩展示，可保存3-5年', NULL, NOW(), NOW()),
(3, '永生花相框', 299.00, 25, 1, '创意相框永生花，家居装饰首选', NULL, NOW(), NOW()),
(4, '开业花篮', 599.00, 15, 1, '喜庆开业大花篮，祝生意兴隆', NULL, NOW(), NOW()),
(4, '庆典花篮', 499.00, 15, 1, '适用于各种庆典活动的大花篮', NULL, NOW(), NOW());

-- DIY素材 (columns: name, type, image, price)
INSERT INTO diy_material (name, type, image, price, created_at, updated_at) VALUES
('红玫瑰', 'flower', '/material/rose-red.png', 5.00, NOW(), NOW()),
('粉玫瑰', 'flower', '/material/rose-pink.png', 5.00, NOW(), NOW()),
('白玫瑰', 'flower', '/material/rose-white.png', 5.00, NOW(), NOW()),
('百合', 'flower', '/material/lily.png', 6.00, NOW(), NOW()),
('康乃馨', 'flower', '/material/carnation.png', 4.00, NOW(), NOW()),
('满天星', 'flower', '/material/baby-breath.png', 3.00, NOW(), NOW()),
('向日葵', 'flower', '/material/sunflower.png', 7.00, NOW(), NOW()),
('绣球花', 'flower', '/material/hydrangea.png', 8.00, NOW(), NOW()),
('红色丝带', 'ribbon', '/material/ribbon-red.png', 2.00, NOW(), NOW()),
('粉色丝带', 'ribbon', '/material/ribbon-pink.png', 2.00, NOW(), NOW()),
('金色丝带', 'ribbon', '/material/ribbon-gold.png', 3.00, NOW(), NOW()),
('爱心贺卡', 'card', '/material/card-love.png', 3.00, NOW(), NOW()),
('生日贺卡', 'card', '/material/card-birthday.png', 3.00, NOW(), NOW()),
('暖色灯串', 'light', '/material/light-warm.png', 10.00, NOW(), NOW()),
('彩色灯串', 'light', '/material/light-color.png', 12.00, NOW(), NOW());

-- DIY包装 (columns: name, image)
INSERT INTO diy_packaging (name, image, created_at, updated_at) VALUES
('经典牛皮纸', '/pkg/kraft.png', NOW(), NOW()),
('白色雪梨纸', '/pkg/white.png', NOW(), NOW()),
('粉色花纸', '/pkg/pink.png', NOW(), NOW()),
('黑色高端纸', '/pkg/black.png', NOW(), NOW()),
('透明玻璃纸', '/pkg/clear.png', NOW(), NOW());

-- 运费模板 (columns: name, type, first_weight, first_price, continue_price)
INSERT INTO delivery_template (name, type, first_weight, first_price, continue_price, created_at, updated_at) VALUES
('同城配送', 'weight', 1.0, 15.00, 5.00, NOW(), NOW()),
('省内快递', 'weight', 1.0, 25.00, 8.00, NOW(), NOW()),
('省外快递', 'weight', 1.0, 35.00, 12.00, NOW(), NOW());