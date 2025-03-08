

# Stage 1: Build the JAR file
FROM maven:3.8.4-openjdk-17 AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn -B dependency:go-offline

COPY src src
RUN mvn -B clean install -DskipTests

# Stage 2: Copy the JAR file into a lightweight image
FROM eclipse-temurin:17

WORKDIR /app

COPY --from=builder /app/target/*.jar spring-boot-boilerplate.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-boot-boilerplate.jar"]