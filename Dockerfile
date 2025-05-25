# Etapa de construcción (Build stage)
FROM maven:3.8.8-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de empaquetado (Package stage)
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/your-app-name-0.0.1-SNAPSHOT.jar app.jar
# Asegúrate de reemplazar 'your-app-name-0.0.1-SNAPSHOT.jar' con el nombre real de tu JAR.

ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]