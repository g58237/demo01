FROM eclipse-temurin:25-jdk
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE}  demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
