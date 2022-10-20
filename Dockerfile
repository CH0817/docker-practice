FROM maven:3.8.6-openjdk-11 AS builder
WORKDIR /usr/src/docker-practice
COPY pom.xml .
# 預載依賴，利用 docker cache 機制，除非 pom.xml 變更，否則都會使用 docker cache，但某些 jar 無法順利下載
RUN mvn -B dependency:go-offline
COPY . .
RUN mvn package -Dmaven.test.skip=true

FROM openjdk:11
MAINTAINER yu.chenhang@gmail.com
WORKDIR /app
COPY --from=builder /usr/src/docker-practice/target/docker-practice-1.0.0.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/docker-practice-1.0.0.jar"]