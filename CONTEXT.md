# Flower 项目上下文

> 新窗口打开后，告诉 Codex "继续"，即可无缝继续。

## 当前阶段
项目可正常运行，登录/注册 API 已修复，前后端联通。

## 已完成
- [x] **flower-common**: base/枚举/异常/JwtUtil/RequestHolder
- [x] **flower-security**: JWT认证 + User/Admin + Security，实体映射已修复
- [x] **flower-service**: 16实体+16Mapper+16Service (zzyl风格)
- [x] **flower-web**: 7Controller + SPA路由转发 + 全局异常
- [x] **flower-ui**: Vue3+ElementPlus+Vite (用户7页+管理3页)
- [x] 数据库SQL · Word文档 · HTML效果图
- [x] **403 修复**: application-dev.yml + Redis启动
- [x] **路由守卫**: 未登录自动跳转 /login
- [x] **DataInitializer**: 启动时自动创建测试用户 testuser/123456
- [x] **500 修复**: User/Admin 实体 @TableField 映射 created_at/updated_at
- [x] **种子数据**: sql/flower_seed.sql (分类/商品/运费模板)

## 访问方式
- 浏览器打开 http://localhost:8080 自动跳转登录界面
- 测试账号: testuser / 123456
- 后端端口: 8080

## 环境
Java17 (D:\tools_two\jdk) · Maven3.9 · Node22 · MySQL8 (flower_db) · Redis (D:\Redis)

## 启动步骤
1. 确保 Redis 已启动: D:\Redis\Redis-win-x64-5.0.9\redis-server.exe
2. 确保 MySQL 已运行，flower_db 数据库已创建
3. 后端: IDEA 运行 FlowerApplication 或 `mvn spring-boot:run`
4. 首次启动会自动创建测试用户

## 数据库
- MySQL: localhost:3306/flower_db
- 用户: root / g1320957780
- SQL: sql/flower_db.sql (建表) + sql/flower_seed.sql (种子数据)

## 下一步
- 补充种子商品数据（目前商品表为空）
- 前端页面完善（产品详情、购物车结算）
- 管理员后台功能增强
- DIY 花束制作功能实现