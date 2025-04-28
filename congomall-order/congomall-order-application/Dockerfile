# 使用官方 Java 基础镜像
FROM openjdk:11-jre-slim

# 设置工作目录
WORKDIR /app

# 复制构建好的 jar 文件到容器中
COPY target/congomall-order-application-0.0.1-SNAPSHOT.jar app.jar

# 暴露服务端口
EXPOSE 8080

# 启动应用
ENTRYPOINT ["java", "-jar", "app.jar"]