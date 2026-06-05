# Flower 项目上下文

> 新窗口打开后，告诉 Codex "继续" 或 "读 CONTEXT.md"，即可无缝继续。

## 当前阶段
数据库设计已完成，SQL 已生成，下一步搭建后端工程骨架。

## 已完成
- [x] 项目设计方案定稿
- [x] Git 仓库初始化 + 远程关联 + 首次提交推送
- [x] Word 项目介绍文档 → `docs/Flower项目介绍.docx`
- [x] HTML 前端效果图 → `mockup/前端效果图.html`
- [x] AGENTS.md 项目规则（Git提交/方案先行/安装说明/上下文更新）
- [x] 数据库初始化 SQL → `docs/flower_db.sql`（18张表，纯DDL，数据库名 flower_db）

## 下一步
1. 搭建 Spring Boot Maven 多模块工程骨架
   - flower-common（公共模块：Entity/DTO/Utils）
   - flower-security（认证授权）
   - flower-service（核心业务）
   - flower-web（控制层+启动入口）
2. 创建 Vue 3 前端工程（flower-ui）
3. 编写各模块代码

## 关键文件
- 完整设计方案：`C:\Users\郭宏兴\.codex/attachments/b0d3f91e-fbda-4257-ba6a-702d6a93e50f/pasted-text.txt`
- Word 文档：`docs/Flower项目介绍.docx`
- 前端效果图：`mockup/前端效果图.html`
- 数据库 SQL：`docs/flower_db.sql`
- 项目规则：`AGENTS.md`

## 注意事项
- 用户偏好：安装新工具前先说明作用和大小，再询问是否安装
- 我有想法/方案时先说明，由用户做决定
- 支付为模拟支付，非真实对接
- 数据库名 flower_db，UTF-8 编码，拖入 MySQL Workbench 运行
