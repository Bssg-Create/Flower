# Flower 项目上下文

> 新窗口打开后，告诉 Codex "继续"，即可无缝继续。

## 当前阶段
全部模块搭建完成，可启动运行。

## 已完成
- [x] **flower-common**: base/枚举/异常/JwtUtil/RequestHolder
- [x] **flower-security**: JWT认证 + User/Admin + Security
- [x] **flower-service**: 16实体+16Mapper+16Service (zzyl风格)
- [x] **flower-web**: 7Controller + CORS + 分页 + 全局异常
- [x] **flower-ui**: Vue3+ElementPlus+Vite (用户7页+管理3页)
- [x] 数据库SQL · Word文档 · HTML效果图

## 启动方式
后端: `mvn -f D:\GProject\flower\pom.xml compile -s D:\GProject\flower\.m2\settings.xml`
前端: `cd D:\GProject\flower\flower-ui && npm run dev`

## 环境
Java17(D:\tools_two\jdk) · Maven3.9 · Node22 · MySQL8(flower_db)
