# Use OpenJDK 17 as the base image
FROM openjdk:17

# Set the working directory to /app
WORKDIR /app

# Copy the JAR file from the target directory to /app inside the container
COPY target/*.jar app.jar

# Expose port 8081
EXPOSE 8081

# Set the entry point to run the JAR file using the java command
ENTRYPOINT ["java", "-jar", "app.jar"]