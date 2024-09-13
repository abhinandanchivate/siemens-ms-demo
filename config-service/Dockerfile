# Use official OpenJDK image as base
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR
COPY target/*.jar /app/config-server.jar

# Expose the port the app runs on
EXPOSE 8888

# Run the JAR file
ENTRYPOINT ["java", "-jar", "config-server.jar"]
