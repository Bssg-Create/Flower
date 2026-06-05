# Flower 项目上下文

> 新窗口打开后，告诉 Codex "继续" 或 "读 CONTEXT.md"，即可无缝继续。

## 当前阶段
Maven多模块工程骨架已搭建并编译通过，准备编写各模块代码。

## 已完成
- [x] 项目设计方案定稿
- [x] Git 仓库 + 远程关联 + 多次提交推送
- [x] Word 项目介绍文档 → `docs/`
- [x] HTML 前端效果图 → `mockup/`
- [x] AGENTS.md 项目专属规则（Git/方案/安装/CONTEXT）
- [x] 数据库 SQL → `sql/flower_db.sql`（18张表，已拖入Workbench运行）
- [x] Maven多模块工程骨架

## Maven 模块
| 模块 | 职责 | 关键依赖 |
|------|------|----------|
| flower-common | 公共模块 | Lombok, Hutool, Orika, FastJSON2 |
| flower-security | 认证授权 | Spring Security, JJWT |
| flower-service | 核心业务 | MyBatis-Plus, Druid, Redisson |
| flower-web | Web+启动 | Knife4j 4.5.0, 多环境配置 |

## 下一步
编写各模块核心代码：
1. flower-common: 实体类、DTO、枚举、异常、工具类
2. flower-security: Security配置、JWT过滤器、认证服务
3. flower-service: Mapper接口、Service接口与实现
4. flower-web: Controller（user/admin）、全局异常处理

## 环境信息
- Java: 17 (`D:\tools_two\jdk`)
- Maven: 3.9.11, 需设置 `$env:JAVA_HOME="D:\tools_two\jdk"`
- 本地Maven仓库: `D:\GProject\flower\.m2\repository`
- 编译命令: `mvn -f D:\GProject\flower\pom.xml compile -s D:\GProject\flower\.m2\settings.xml`
- 数据库: flower_db (MySQL 8.0+)

## 注意事项
- 安装工具前说明作用+大小，批准后再装
- 我有方案时先说明，由用户决定
- 每次改动后 add→commit→push
- 会话结束前更新此文件
