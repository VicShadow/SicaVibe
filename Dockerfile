# Base image
FROM ubuntu:22.04

# Update the package repositories and install dependencies
RUN apt-get update && \
    apt-get install -y \
    openjdk-17-jre maven git && \
    apt-get clean

# Set the working directory
WORKDIR /SicaVibe/SicaVibeApp

# Copy the application files
COPY SicaVibeApp/ .

# Build the Maven project
RUN mvn clean package -f pom.xml

# Rename the built JAR file
RUN mv target/SicaVibeApp-0.0.1-SNAPSHOT.jar SicaVibeApp.jar

# Copy the start script
COPY SicaVibeApp/scripts/startApp.sh .

# Set the executable permission for the start script
RUN chmod +x startApp.sh

# Expose the port for the application
EXPOSE 8080

# Start the application
CMD bash startApp.sh
