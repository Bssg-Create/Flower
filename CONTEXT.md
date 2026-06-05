# Flower 项目上下文

> 新窗口打开后，告诉 Codex "继续" 或 "读 CONTEXT.md"，即可无缝继续。

## 当前阶段
后端 Spring Boot 多模块工程已完成（zzyl风格），编译通过。

## 已完成
- [x] 项目设计方案 · Word文档 · HTML效果图 · 数据库SQL
- [x] **flower-common**: base/枚举/异常/JwtUtil/RequestHolder
- [x] **flower-security**: User/Admin + JWT认证 + SecurityConfig
- [x] **flower-service**: 16实体+16Mapper+16Service (extends ServiceImpl)
- [x] **flower-web**: 7个Controller + CORS + 分页插件 + 全局异常

## 代码风格
参照 `D:\tools_two\zzyl\zzyl\zzyl` 项目：
- Service extends ServiceImpl<Mapper, Entity>（无接口层）
- 实体: @Builder @NoArgsConstructor @AllArgsConstructor
- 审计字段: createTime/updateTime/createBy/updateBy/remark
- ResponseResult.success()/error()
- JwtUtil 静态工具类 · RequestHolder 线程上下文

## 下一步
1. 创建 Vue 3 前端工程 (flower-ui)
2. 实现 DIY 拖拽画布
3. 前后端联调

## 环境
- Java 17: `D:\tools_two\jdk` 
- Maven: `$env:JAVA_HOME="D:\tools_two\jdk"; mvn -f D:\GProject\flower\pom.xml compile -s D:\GProject\flower\.m2\settings.xml`
- 数据库: flower_db (MySQL 8.0+)
- GitHub: https://github.com/Bssg-Create/Flower.git
