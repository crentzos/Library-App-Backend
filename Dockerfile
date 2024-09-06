# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the build container
WORKDIR /app

# Copy the Maven project files to the container
COPY pom.xml .
COPY src ./src

# Build the Spring Boot application and skip tests
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-slim

# Set the working directory in the runtime container
WORKDIR /app

# Copy the built .jar file from the build stage to the runtime container
COPY --from=build /app/target/spring-boot-library-0.0.1-SNAPSHOT.jar spring-boot-library.jar

# Expose the port where the Spring Boot application will run (using HTTPS)
EXPOSE 8443

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "spring-boot-library.jar"]
