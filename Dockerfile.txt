FROM openjdk:8
EXPOSE 9090
Add target/location-web.jar location-web.jar
ENTRYPOINT ["java","-jar","/location-web.jar"]