FROM maven:latest as builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src/ ./src/

RUN mvn clean package -DskipTests=true



FROM openjdk:21-jdk

RUN mkdir /app

COPY --from=builder /app/target/*.jar /app/spring-boot-lanchonete.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/spring-boot-lanchonete.jar" ]