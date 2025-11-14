# Spring Boot Auto Configuration Demo

## 项目概述

这是一个基于 Spring Boot 2.5.8 的示例项目，演示了如何创建和使用自定义的 Spring Boot Starter。该项目集成了 Redisson 客户端，提供了自动配置功能，并展示了条件化 Bean 注册的使用方式。

## 技术栈

- Java 8
- Spring Boot 2.5.8
- Maven 3.6+
- Redisson 3.x (通过自定义 starter 集成)
- 自定义 spring-boot-core 模块

## 项目结构

```
src/
├── main/
│   ├── java/com/lq/
│   │   ├── autoconfigure/          # 自动配置类
│   │   │   ├── CoreAutoConfiguration.java
│   │   │   └── YourConfiguration.java
│   │   ├── controller/             # 控制器层
│   │   │   └── RedisController.java
│   │   └── SpringBootAutoApplication.java  # 启动类
│   └── resources/
│       └── application.properties          # 应用配置
└── test/                                   # 测试代码
```

## 核心功能

### 1. Redisson 自动配置
项目通过 `redisson-spring-boot-starter` 依赖集成 Redisson 客户端，实现了 Redis 的自动配置。在应用启动时会根据 [application.properties](file:///Users/Java/project/Spring/spring-boot-auto/src/main/resources/application.properties) 中的配置自动创建 [RedissonClient](file:///Users/Java/project/Spring/spring-boot-auto/target/classes/org/redisson/api/RedissonClient.class#L23-L189) Bean。

相关配置项：
```properties
lq.redisson.host=localhost
lq.redisson.port=6379
lq.redisson.ssl=false
```

### 2. 自定义 Bean 配置
项目中包含两个配置类：

1. [YourConfiguration](file:///Users/Java/project/Spring/spring-boot-auto/src/main/java/com/lq/autoconfigure/YourConfiguration.java#L14-L19) - 创建了一个名为 `primaryProductService` 的 [ProductService](file:///Users/Java/project/Spring/spring-boot-auto/spring-boot-core/src/main/java/com/lq/service/ProductService.java#L8-L17) Bean
2. `ConditionalConfig` (通过 [@Import](file:///Users/Java/project/Spring/spring-boot-auto/spring-boot-core/src/main/java/com/lq/config/ConditionalConfig.java#L1-L21) 导入) - 条件化创建 `conditionalProductService` Bean

### 3. Redis 控制器
[RedisController](file:///Users/Java/project/Spring/spring-boot-auto/src/main/java/com/lq/controller/RedisController.java#L16-L25) 提供了一个简单的 REST 接口 `/query`，用于查询 Redis 中 key 的数量。

## 快速开始

### 环境要求
- Java 8 或更高版本
- Maven 3.6 或更高版本
- Redis 服务器 (本地或远程)

### 安装步骤

1. 克隆项目到本地
```bash
git clone <项目地址>
```

2. 进入项目目录
```bash
cd spring-boot-auto
```

3. 编译和打包
```bash
./mvnw clean package
```

4. 运行应用
```bash
./mvnw spring-boot:run
```

或者
```bash
java -jar target/spring-boot-auto-0.0.1-SNAPSHOT.jar
```

### 配置 Redis
确保 Redis 服务器正在运行，并且 [application.properties](file:///Users/Java/project/Spring/spring-boot-auto/src/main/resources/application.properties) 中的配置正确：
```properties
lq.redisson.host=localhost
lq.redisson.port=6379
```

如果需要修改 Redis 连接信息，请相应地更新这些配置项。

## 使用示例

启动应用后，可以通过以下 URL 访问 Redis 查询接口：

```
GET http://localhost:8080/query
```

该接口将返回当前 Redis 数据库中 key 的数量。

## 依赖说明

项目的依赖关系如下：

- `spring-boot-starter-web` - 提供 Web 功能
- `spring-boot-starter-test` - 提供测试支持
- `redisson-spring-boot-starter` - 自定义的 Redisson Starter
- `spring-boot-core` - 自定义的核心模块

注意：`redisson-spring-boot-starter` 和 `spring-boot-core` 是本地 SNAPSHOT 版本的依赖。

## 开发指南

### 添加新的自动配置
1. 在 [autoconfigure](file:///Users/Java/project/Spring/spring-boot-auto/src/main/java/com/lq/autoconfigure) 包下创建新的配置类
2. 使用 `@Configuration` 注解标记配置类
3. 根据需要添加 `@Conditional` 注解实现条件化配置

### 扩展控制器
1. 在 [controller](file:///Users/Java/project/Spring/spring-boot-auto/src/main/java/com/lq/controller) 包下创建新的控制器类
2. 使用 `@RestController` 注解标记控制器
3. 添加相应的请求映射方法

## 构建和部署

使用 Maven 进行构建：

```bash
# 清理、编译、测试和打包
./mvnw clean install

# 只打包
./mvnw package

# 运行应用
./mvnw spring-boot:run
```

生成的可执行 JAR 文件位于 `target/` 目录下。

## 许可证

本项目仅供学习和演示用途。