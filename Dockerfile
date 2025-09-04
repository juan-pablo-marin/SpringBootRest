

#imagen modelo
FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/SpringBootRest-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_proyecto.jar
#levantar nuestra aplicacion cuando el contenedor inicie
ENTRYPOINT ["java","-jar","app_proyecto.jar"]
