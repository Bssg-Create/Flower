# Flower 项目上下文

> 新窗口打开后，告诉 Codex "继续"，即可无缝继续。

## 当前阶段
项目功能完整可用，前后端联通，管理后台已接入真实数据。

## 功能清单

### 用户端
- [x] 注册/登录（JWT + BCrypt）
- [x] 商品浏览（分页、分类筛选）
- [x] 商品详情
- [x] 加入购物车
- [x] 下单（自动扣库存、生成订单号）
- [x] 订单列表
- [x] DIY花束素材浏览

### 管理端
- [x] 仪表盘（商品/订单/用户统计）
- [x] 商品管理（增删改查，接入真实API）
- [x] 订单管理（列表、状态更新）

### 基础设施
- [x] Spring Security + JWT 认证
- [x] 路由守卫（未登录跳转 /login）
- [x] 实体字段映射修复（@TableField + -parameters）
- [x] 种子数据（11商品/15DIY素材/5包装/3运费）
- [x] 测试账号自动创建

## 访问方式
- 浏览器: http://localhost:8080 → 自动跳转登录
- 用户端: testuser / 123456
- 管理端: 登录后访问 /admin

## 环境
Java17 · Maven3.9 · Node22 · MySQL8 (flower_db) · Redis

## 启动
1. Redis: D:\Redis\Redis-win-x64-5.0.9\redis-server.exe
2. MySQL: 确保运行，导入 sql/flower_db.sql + sql/flower_seed.sql
3. 后端: IDEA 运行 FlowerApplication 或 `mvn spring-boot:run`
4. 前端: 已内置在 static/，无需单独启动