FROM maven:3.8.6-openjdk-8 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests


FROM openjdk:8-jre-slim
COPY --from=build /app/target/socket-comm.jar /app/

ENTRYPOINT [ "java","-jar", "/app/socket-comm.jar" ]