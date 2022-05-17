FROM registry.access.redhat.com/ubi8/openjdk-11
COPY target/*.jar .
EXPOSE 8080
CMD ["java", "-Dfile.encoding=UTF-8", "-jar","app.jar"]
