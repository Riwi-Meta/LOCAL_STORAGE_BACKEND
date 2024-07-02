FROM maven:3.8.5-openjdk-17 as builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ ./src/
RUN mvn clean package -DskipTests=true

FROM eclipse-temurin:17-jdk-alpine as prod
RUN mkdir /app
COPY --from=builder /app/target/*.jar riwi-local-storage-0.0.1-SNAPSHOT.jar

WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","/riwi-local-storage-0.0.1-SNAPSHOT.jar"]