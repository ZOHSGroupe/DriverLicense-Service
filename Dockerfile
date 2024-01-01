FROM ubuntu:latest
LABEL authors="hajar"

ENTRYPOINT ["top", "-b"]
# Use the official OpenJDK base image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/DriverLicense-Service-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port the app runs on
EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "/app/app.jar"]
