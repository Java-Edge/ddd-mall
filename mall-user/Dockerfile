FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/mall-user.jar /app/

ENV TZ=Asia/Shanghai
ENV JAVA_OPTS="-Xms256m -Xmx512m"

CMD java $JAVA_OPTS -jar mall-user.jar
