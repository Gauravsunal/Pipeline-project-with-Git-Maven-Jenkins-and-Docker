# Pipeline-project-with-Git-Maven-Jenkins-and-Docker
![maven](https://github.com/user-attachments/assets/b17b5ea6-5171-4d63-a61b-ed62245e85fd)


# Automated Docker and Jenkins Setup on AWS EC2

## Launch EC2 Instance and Setup Docker

1. **Initialize an EC2 instance** to serve as the Docker host.
2. **Install Docker** and start the Docker service:
    ```bash
    yum install docker
    service docker start
    ```
3. **Create a Docker management user** and add it to the Docker group:
    ```bash
    useradd dockeradmin
    passwd dockeradmin
    usermod -aG docker dockeradmin
    ```

## Prepare Docker Environment

1. **Create a directory for the Docker setup**:
    ```bash
    mkdir /opt/docker
    ```

2. **Write a Dockerfile** in the created directory:
    ```Dockerfile
    ### vi /opt/docker/Dockerfile
    # Base image
    FROM tomcat:9-jre9

    # Maintainer information
    MAINTAINER "DEVOPS with KK"

    # Copy the WAR file into the container
    COPY ./webapp.war /usr/local/tomcat/webapps
    ```

## Configure Jenkins to Deploy Docker

1. **Access the Jenkins console** and configure the Docker server for remote command execution:
    - Navigate to `Manage Jenkins` -> `Configure System` -> `Publish over SSH`.
    - Add your Docker server and associated credentials.

2. **Create a Jenkins job** with the following configuration:

### Source Code Management
- **Repository**: `https://github.com/Gauravsunal/Pipeline-project-with-Git-Maven-Jenkins-and-Docker`
- **Branches to build**: `*/main`

### Build
- **Root POM**: `pom.xml`
- **Goals and options**: `clean install package`

### Post-Build Actions: Send Files/Execute Commands over SSH
- **Name**: `docker_host`
- **Source files**: `webapp/target/*.war`
- **Remove prefix**: `webapp/target`
- **Remote directory**: `/opt/docker`
- **Commands**:
    ```bash
    docker stop docker_demo;
    docker rm -f docker_demo;
    docker image rm -f docker_demo;
    cd /opt/docker;
    docker build -t docker_demo .
    ```

### Run Docker Container
- **Name**: `docker_host`
- **Commands**:
    ```bash
    docker run -d --name docker_demo -p 8090:8080 docker_demo
    ```

## Verify Deployment

1. **Log into the Docker host** and check for Docker images and containers (there should be none initially).
2. **Execute the Jenkins job**.
3. **Recheck the Docker host** for new images and containers. The Jenkins job should have created an image and started a container.

## Access the Web Application

- Open a browser and navigate to `<docker_host_Public_IP>:8081` to view the web application running in the container.


![jenkins pipeline](https://github.com/user-attachments/assets/56f4e76c-7c1f-4369-b878-a7dab37f0c73)

![1721143929676](https://github.com/user-attachments/assets/5c33a2eb-e2b9-489a-95aa-f1be1623a591)

