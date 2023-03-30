FROM docker.io/library/openjdk:11-slim
RUN apt-get update -y
RUN apt-get install maven -y
WORKDIR /opt
COPY . .
RUN mvn -B -DskipTests clean package
CMD ["java" , "-jar" , "./target/spring-boot-2.1.0.jar"]