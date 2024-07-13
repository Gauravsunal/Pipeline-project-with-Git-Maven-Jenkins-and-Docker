FROM openjdk
ADD target/*.jar /
ENTRYPOINT ["java", "-jar","/Assignment_7-1.0-SNAPSHOT.jar"]
EXPOSE 8080