FROM maven:3.8.6-openjdk-11 as builder
MAINTAINER yu.chenhang@gmail.com
WORKDIR /build
COPY pom.xml .
RUN mvn -B dependency:go-offline
COPY . .
RUN mvn package

FROM openjdk:11
MAINTAINER yu.chenhang@gmail.com
WORKDIR /app
COPY --from=builder /build/docker-practice-1.0.0.jar .
EXPOSE 80
ENTRYPOINT ["java", "-jar", "/app/docker-practice-1.0.0.jar"]