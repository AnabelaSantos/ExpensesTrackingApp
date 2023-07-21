FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY ${JAR_FILE} app.jar
COPY .mvn/ .mvn
COPY mvnw pom.xml
#RUN ./mvnw dependency:resolve
COPY src ./src
ENTRYPOINT ["java", "-jar", "/app.jar"]