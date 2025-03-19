# Stage 1: Build
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app

# Copy the project files
COPY . .

# Verify files exist (for debugging)
RUN ls -la

# Build the project
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the correctly named JAR file
COPY --from=build /app/target/MultiFoodDelivery-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
