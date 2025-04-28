#!/bin/bash

# 构建所有服务
echo "===== 构建所有微服务 ====="
mvn clean package -DskipTests

# 启动所有服务
echo "===== 启动所有容器 ====="
docker-compose up -d

# 显示服务状态
echo "===== 显示服务状态 ====="
docker-compose ps
