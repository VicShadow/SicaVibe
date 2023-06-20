# Base image
FROM ubuntu:22.04
USER root

# Set the path to the SSH key file as an environment variable
ENV SSH_PRIVATE_KEY_PATH=id_rsa

# Update the package repositories and install dependencies
RUN apt-get update && \
    apt-get install -y \
    openjdk-17-jre maven mysql-server git && \
    apt-get clean

# Install Git and configure SSH for GitHub
#RUN mkdir -p ~/.ssh && \
#    chmod 700 ~/.ssh

#COPY $SSH_PRIVATE_KEY_PATH ~/.ssh/id_rsa

#RUN mkdir -p ~/SicaVibe/SicaVibeApp && \
#    chmod 700 ~/SicaVibe

WORKDIR ~/SicaVibe/

COPY SicaVibeApp/ SicaVibeApp/


#RUN chmod 600 ~/.ssh/id_rsa && \
#    ssh-keyscan -t rsa github.com >> ~/.ssh/known_hosts && \
#    git config --global core.sshCommand 'ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no'

# Configure SSH
#RUN chmod 600 /root/.ssh/id_rsa && \
#    echo "StrictHostKeyChecking no" >> /root/.ssh/config

# Clone the repository
#RUN git clone git@github.com:VicShadow/SicaVibe.git

# Setup the database
RUN mkdir /var/lib/mysql-files/SicaVibeImgs && \
    cp ~/SicaVibe/SicaVibeApp/scripts/imgs/* /var/lib/mysql-files/SicaVibeImgs/ && \
    mysql < ~/SicaVibe/SicaVibeApp/scripts/DBSicaVibeCreate.ddl && \
    mysql < ~/SicaVibe/SicaVibeApp/scripts/DBUserCreate.sql && \
    mysql < ~/SicaVibe/SicaVibeApp/scripts/DBPopulate.sql

# Build the Maven project and start the application
WORKDIR ~/SicaVibe/SicaVibeApp
RUN mvn clean package -f pom.xml && \
    mv target/SicaVibeApp-0.0.1-SNAPSHOT.jar ~/SicaVibeApp.jar && \
    mv scripts/startApp.sh ~ && \
    chmod +x ~/startApp.sh

# Expose the port for the application
EXPOSE 8080

# Start the application
CMD ["./startApp.sh"]
