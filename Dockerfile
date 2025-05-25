# Etapa de construcción (Build stage)
FROM maven:3.8.8-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de empaquetado (Package stage)
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/myTicket-00.1-SNAPSHOT.jar app.jar
# ¡Esta línea es la importante, ahora confirmada!

ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]