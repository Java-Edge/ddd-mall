#!/bin/bash

# 停止所有服务
echo "===== 停止所有容器 ====="
docker-compose down

# 显示服务状态
echo "===== 显示服务状态 ====="
docker ps
