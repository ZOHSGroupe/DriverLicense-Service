# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/spring-boot-app.jar /app/app.jar

# Expose the port that your Spring Boot application runs on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]
