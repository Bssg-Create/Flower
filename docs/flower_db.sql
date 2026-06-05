-- ============================================================
-- Flower 花卉销售管理系统 - 数据库初始化脚本
-- 版本: v1.0
-- 日期: 2026-06-05
-- 数据库: MySQL 8.0+
-- 说明: 纯建表语句，拖入 MySQL Workbench 运行即可
-- ============================================================

CREATE DATABASE IF NOT EXISTS flower_db
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;

USE flower_db;

-- ============================================================
-- 一、用户与商品模块
-- ============================================================

-- 1. 用户表
CREATE TABLE user (
    id          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    username    VARCHAR(50)  NOT NULL COMMENT '用户名',
    password    VARCHAR(255) NOT NULL COMMENT '密码（BCrypt加密）',
    phone       VARCHAR(20)  DEFAULT NULL COMMENT '手机号',
    avatar      VARCHAR(500) DEFAULT NULL COMMENT '头像URL',
    status      TINYINT      NOT NULL DEFAULT 1 COMMENT '状态：1-正常, 0-禁用',
    created_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE INDEX uk_username (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- 2. 商品分类表
CREATE TABLE category (
    id          BIGINT      NOT NULL AUTO_INCREMENT COMMENT '分类ID',
    name        VARCHAR(50) NOT NULL COMMENT '分类名称',
    parent_id   BIGINT      DEFAULT NULL COMMENT '父分类ID（NULL表示顶级分类）',
    sort        INT         NOT NULL DEFAULT 0 COMMENT '排序号',
    created_at  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    INDEX idx_parent_id (parent_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品分类表';

-- 3. 商品表
CREATE TABLE product (
    id           BIGINT        NOT NULL AUTO_INCREMENT COMMENT '商品ID',
    name         VARCHAR(200)  NOT NULL COMMENT '商品名称',
    category_id  BIGINT        NOT NULL COMMENT '所属分类ID',
    price        DECIMAL(10,2) NOT NULL COMMENT '价格',
    stock        INT           NOT NULL DEFAULT 0 COMMENT '库存数量',
    description  TEXT          DEFAULT NULL COMMENT '商品描述',
    cover        VARCHAR(500)  DEFAULT NULL COMMENT '封面图片URL',
    holiday_tag  VARCHAR(50)   DEFAULT NULL COMMENT '节日标签',
    status       TINYINT       NOT NULL DEFAULT 1 COMMENT '状态：1-上架, 0-下架',
    created_at   DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at   DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    INDEX idx_category_id (category_id),
    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品表';

-- 4. 商品图片表
CREATE TABLE product_image (
    id          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '图片ID',
    product_id  BIGINT       NOT NULL COMMENT '所属商品ID',
    url         VARCHAR(500) NOT NULL COMMENT '图片URL',
    sort        INT          NOT NULL DEFAULT 0 COMMENT '排序号',
    created_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id),
    INDEX idx_product_id (product_id),
    CONSTRAINT fk_image_product FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品图片表';

-- ============================================================
-- 二、节日专题模块
-- ============================================================

-- 5. 节日专题表
CREATE TABLE holiday_theme (
    id          BIGINT      NOT NULL AUTO_INCREMENT COMMENT '专题ID',
    name        VARCHAR(100) NOT NULL COMMENT '专题名称',
    banner      VARCHAR(500) DEFAULT NULL COMMENT 'Banner图片URL',
    start_time  DATETIME    NOT NULL COMMENT '开始时间',
    end_time    DATETIME    NOT NULL COMMENT '结束时间',
    status      TINYINT     NOT NULL DEFAULT 1 COMMENT '状态：1-启用, 0-禁用',
    created_at  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='节日专题表';

-- 6. 专题商品关联表
CREATE TABLE theme_product (
    id        BIGINT   NOT NULL AUTO_INCREMENT COMMENT '关联ID',
    theme_id  BIGINT   NOT NULL COMMENT '专题ID',
    product_id BIGINT  NOT NULL COMMENT '商品ID',
    sort      INT      NOT NULL DEFAULT 0 COMMENT '排序号',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id),
    INDEX idx_theme_id (theme_id),
    INDEX idx_product_id (product_id),
    CONSTRAINT fk_tp_theme FOREIGN KEY (theme_id) REFERENCES holiday_theme(id) ON DELETE CASCADE,
    CONSTRAINT fk_tp_product FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='专题商品关联表';

-- ============================================================
-- 三、DIY 模块
-- ============================================================

-- 7. DIY花材/配饰素材表
CREATE TABLE diy_material (
    id          BIGINT        NOT NULL AUTO_INCREMENT COMMENT '素材ID',
    name        VARCHAR(100)  NOT NULL COMMENT '素材名称',
    type        VARCHAR(20)   NOT NULL COMMENT '素材类型：flower-花材, ribbon-丝带, card-贺卡, light-灯串',
    image       VARCHAR(500)  NOT NULL COMMENT '素材图片URL',
    price       DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '素材价格',
    created_at  DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at  DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    INDEX idx_type (type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='DIY花材/配饰素材表';

-- 8. DIY包装效果图表
CREATE TABLE diy_packaging (
    id          BIGINT        NOT NULL AUTO_INCREMENT COMMENT '包装ID',
    name        VARCHAR(100)  NOT NULL COMMENT '包装名称',
    image       VARCHAR(500)  NOT NULL COMMENT '包装效果图URL',
    price       DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '包装价格',
    created_at  DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at  DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='DIY包装效果图表';

-- 9. 用户DIY作品表
CREATE TABLE diy_works (
    id           BIGINT        NOT NULL AUTO_INCREMENT COMMENT '作品ID',
    user_id      BIGINT        NOT NULL COMMENT '用户ID',
    packaging_id BIGINT        DEFAULT NULL COMMENT '包装ID',
    total_price  DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '总价',
    snapshot     TEXT          DEFAULT NULL COMMENT '作品快照（Base64图片）',
    status       TINYINT       NOT NULL DEFAULT 1 COMMENT '状态：1-正常, 0-已删除',
    created_at   DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at   DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    INDEX idx_user_id (user_id),
    CONSTRAINT fk_works_user FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT fk_works_packaging FOREIGN KEY (packaging_id) REFERENCES diy_packaging(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户DIY作品表';

-- 10. 作品素材明细表
CREATE TABLE diy_work_item (
    id          BIGINT         NOT NULL AUTO_INCREMENT COMMENT '明细ID',
    work_id     BIGINT         NOT NULL COMMENT '作品ID',
    material_id BIGINT         NOT NULL COMMENT '素材ID',
    x           DOUBLE         NOT NULL DEFAULT 0 COMMENT 'X坐标',
    y           DOUBLE         NOT NULL DEFAULT 0 COMMENT 'Y坐标',
    scale       DOUBLE         NOT NULL DEFAULT 1.0 COMMENT '缩放比例',
    rotation    DOUBLE         NOT NULL DEFAULT 0 COMMENT '旋转角度',
    z_index     INT            NOT NULL DEFAULT 0 COMMENT '层级',
    created_at  DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id),
    INDEX idx_work_id (work_id),
    CONSTRAINT fk_item_work FOREIGN KEY (work_id) REFERENCES diy_works(id) ON DELETE CASCADE,
    CONSTRAINT fk_item_material FOREIGN KEY (material_id) REFERENCES diy_material(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='作品素材明细表';

-- ============================================================
-- 四、交易与物流模块
-- ============================================================

-- 11. 购物车表
CREATE TABLE cart (
    id          BIGINT   NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
    user_id     BIGINT   NOT NULL COMMENT '用户ID',
    product_id  BIGINT   NOT NULL COMMENT '商品ID',
    quantity    INT      NOT NULL DEFAULT 1 COMMENT '数量',
    created_at  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE INDEX uk_user_product (user_id, product_id),
    CONSTRAINT fk_cart_user FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT fk_cart_product FOREIGN KEY (product_id) REFERENCES product(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='购物车表';

-- 12. 订单表
CREATE TABLE `order` (
    id            BIGINT        NOT NULL AUTO_INCREMENT COMMENT '订单ID',
    order_no      VARCHAR(32)   NOT NULL COMMENT '订单编号（唯一）',
    user_id       BIGINT        NOT NULL COMMENT '用户ID',
    total_amount  DECIMAL(10,2) NOT NULL COMMENT '订单总金额',
    status        TINYINT       NOT NULL DEFAULT 1 COMMENT '状态：1-待付款, 2-待发货, 3-运输中, 4-已完成, 5-已取消',
    delivery_type VARCHAR(20)   DEFAULT NULL COMMENT '配送方式：express-快递, local-同城速递, self-自取',
    address       VARCHAR(500)  DEFAULT NULL COMMENT '收货地址',
    created_at    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE INDEX uk_order_no (order_no),
    INDEX idx_user_id (user_id),
    INDEX idx_status (status),
    CONSTRAINT fk_order_user FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单表';

-- 13. 订单明细表
CREATE TABLE order_item (
    id          BIGINT        NOT NULL AUTO_INCREMENT COMMENT '明细ID',
    order_id    BIGINT        NOT NULL COMMENT '订单ID',
    product_id  BIGINT        NOT NULL COMMENT '商品ID',
    quantity    INT           NOT NULL COMMENT '数量',
    price       DECIMAL(10,2) NOT NULL COMMENT '下单时单价',
    created_at  DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id),
    INDEX idx_order_id (order_id),
    CONSTRAINT fk_item_order FOREIGN KEY (order_id) REFERENCES `order`(id) ON DELETE CASCADE,
    CONSTRAINT fk_item_product FOREIGN KEY (product_id) REFERENCES product(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单明细表';

-- 14. 物流追踪表
CREATE TABLE order_logistics (
    id           BIGINT      NOT NULL AUTO_INCREMENT COMMENT '物流ID',
    order_id     BIGINT      NOT NULL COMMENT '订单ID',
    tracking_no  VARCHAR(50) DEFAULT NULL COMMENT '快递单号',
    status       TINYINT     NOT NULL DEFAULT 1 COMMENT '状态：1-待揽收, 2-运输中, 3-派送中, 4-已签收',
    records      JSON        DEFAULT NULL COMMENT '物流轨迹记录（JSON数组）',
    created_at   DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at   DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE INDEX uk_order_id (order_id),
    CONSTRAINT fk_logistics_order FOREIGN KEY (order_id) REFERENCES `order`(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='物流追踪表';

-- 15. 评价表
CREATE TABLE review (
    id          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '评价ID',
    user_id     BIGINT       NOT NULL COMMENT '用户ID',
    product_id  BIGINT       NOT NULL COMMENT '商品ID',
    rating      TINYINT      NOT NULL COMMENT '评分（1-5星）',
    content     TEXT         DEFAULT NULL COMMENT '评价内容',
    images      JSON         DEFAULT NULL COMMENT '评价图片（JSON数组）',
    status      TINYINT      NOT NULL DEFAULT 1 COMMENT '状态：1-待审核, 2-已通过, 3-已拒绝',
    created_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    INDEX idx_user_id (user_id),
    INDEX idx_product_id (product_id),
    CONSTRAINT fk_review_user FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT fk_review_product FOREIGN KEY (product_id) REFERENCES product(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='评价表';

-- 16. 运费模板表
CREATE TABLE delivery_template (
    id              BIGINT        NOT NULL AUTO_INCREMENT COMMENT '模板ID',
    name            VARCHAR(100)  NOT NULL COMMENT '模板名称',
    type            VARCHAR(20)   NOT NULL COMMENT '计费方式：weight-按重量, piece-按件数',
    first_weight    DOUBLE        DEFAULT NULL COMMENT '首重（kg）',
    first_price     DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '首重/件价格',
    continue_price  DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '续重/件价格',
    created_at      DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='运费模板表';

-- ============================================================
-- 五、系统管理模块
-- ============================================================

-- 17. 管理员表
CREATE TABLE admin (
    id          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
    username    VARCHAR(50)  NOT NULL COMMENT '管理员用户名',
    password    VARCHAR(255) NOT NULL COMMENT '密码（BCrypt加密）',
    role        VARCHAR(50)  NOT NULL DEFAULT 'admin' COMMENT '角色标识',
    status      TINYINT      NOT NULL DEFAULT 1 COMMENT '状态：1-正常, 0-禁用',
    created_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE INDEX uk_admin_username (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员表';

-- 18. 角色权限表
CREATE TABLE admin_role (
    id          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    name        VARCHAR(50)  NOT NULL COMMENT '角色名称',
    permissions JSON         DEFAULT NULL COMMENT '权限列表（JSON数组）',
    created_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE INDEX uk_role_name (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色权限表';

-- ============================================================
-- 初始化完成
-- ============================================================
