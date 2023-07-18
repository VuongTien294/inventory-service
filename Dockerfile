FROM openjdk:8

COPY target/*.jar inventory-service.jar
EXPOSE 8284
ENTRYPOINT ["java","-jar","/inventory-service.jar"]