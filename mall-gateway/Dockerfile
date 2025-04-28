FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/mall-gateway.jar /app/

ENV TZ=Asia/Shanghai
ENV JAVA_OPTS="-Xms256m -Xmx512m"

EXPOSE 8080

CMD java $JAVA_OPTS -jar mall-gateway.jar
