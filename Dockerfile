FROM openjdk:11
WORKDIR app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-boot-boilerplate.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-boot-boilerplate.jar"]