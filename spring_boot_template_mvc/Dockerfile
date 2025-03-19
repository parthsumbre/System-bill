# # Stage 1: Build
# FROM maven:3.8.3-openjdk-17 AS build
# WORKDIR /app

# # Copy the project files
# COPY . .

# # Verify files exist (for debugging)
# RUN ls -la

# # Build the project
# RUN mvn clean package -DskipTests

# # Stage 2: Run
# FROM openjdk:17-jdk-slim
# WORKDIR /app

# # Copy the correctly named JAR file
# COPY --from=build /app/target/MultiFoodDelivery-0.0.1-SNAPSHOT.jar app.jar

# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "app.jar"]



# Use an official Maven image as the base
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the project files into the container
COPY . .

# Run Maven to build the project
RUN mvn clean package -DskipTests

# Use an official OpenJDK image to run the app
FROM openjdk:17-jdk

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
