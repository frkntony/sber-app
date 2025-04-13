#FROM gradle:jdk17 AS builder
# закэшировал зависимости для тестов и билда, можно делать pre-pull раз в день на ci агент для быстрых сборок из-за локального резолва
# описал процесс формирования в файле Dockerfile-cache-ci
FROM  frkntony/gradle-cached-ci-builder:jdk17 as builder

WORKDIR /app
COPY . .

# можно добавить для тестов, добавил их в app>bin>test>org>example
#RUN gradle test --no-daemon

RUN gradle build --no-daemon

# перекладка в контейнер
FROM openjdk:17-jdk-slim AS container

WORKDIR /app

# перенос jar из билдера
COPY --from=builder /app/app/build/libs/app.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]