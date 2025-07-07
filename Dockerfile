# Use Java 21 base image
FROM openjdk:21-jdk-slim

# Create app directory
WORKDIR /app

# Copy the JAR and the lib/ folder
COPY LAB3_LOG430.jar app.jar
COPY lib/ lib/

# Run with classpath including all dependencies
ENTRYPOINT ["java", "-cp", "app.jar:lib/*", "Rest.ApiApplication"]