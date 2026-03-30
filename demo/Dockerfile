FROM eclipse-temurin:25-jdk
ENV DB_URL=jdbc:mysql://mydb:3306/demo DB_USER=root DB_PASSWORD=1234 DB_DRIVER=com.mysql.cj.jdbc.Driver
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE}  demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
