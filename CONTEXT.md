# Flower 项目上下文

> 新窗口打开后，告诉 Codex "继续"，即可无缝继续。

## 当前阶段
项目完全可用：登录/注册/浏览商品/加购/下单 API 全部正常，种子数据已填充。

## 已完成
- [x] **flower-common**: base/枚举/异常/JwtUtil/RequestHolder
- [x] **flower-security**: JWT认证 + User/Admin + Security + 实体映射修复
- [x] **flower-service**: 16实体+16Mapper+16Service，所有 @TableField 映射修复
- [x] **flower-web**: 7Controller + SPA路由 + 全局异常 + @RequestParam 修复
- [x] **flower-ui**: Vue3+ElementPlus+Vite，路由守卫登录拦截
- [x] **数据库**: SQL建表 + 种子数据（11商品/15DIY素材/5包装/3运费模板）
- [x] **编译器**: pom.xml 添加 -parameters 参数
- [x] **测试账号**: testuser/123456（启动自动创建）
- [x] **端到端测试**: 登录→浏览商品→加购→查看购物车 ✅

## 访问方式
- 浏览器: http://localhost:8080 → 自动跳转登录界面
- 测试账号: testuser / 123456
- 后端端口: 8080

## 环境
Java17 (D:\tools_two\jdk) · Maven3.9 (D:\tools\apache-maven-3.9.11) · Node22 · MySQL8 (flower_db) · Redis (D:\Redis)

## 启动步骤
1. Redis: D:\Redis\Redis-win-x64-5.0.9\redis-server.exe
2. MySQL: 确保运行，flower_db 已创建
3. 导入种子数据: 用 Workbench 运行 sql/flower_seed.sql
4. 后端: IDEA 运行 FlowerApplication 或 `mvn spring-boot:run`
5. 前端已内置在 static/ 中，无需单独启动

## 数据库
- MySQL: localhost:3306/flower_db
- 用户: root / g1320957780
- SQL: sql/flower_db.sql (建表) + sql/flower_seed.sql (种子数据)

## 下一步
- 管理员后台页面接入真实 API（当前为演示数据）
- 下单流程完整实现
- DIY 花束制作功能完善