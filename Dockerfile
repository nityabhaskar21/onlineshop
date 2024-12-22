FROM openjdk:17
EXPOSE 8080
ADD target/onlineshop-app.jar onlineshop-app.jar
ENTRYPOINT ["java","-jar","/onlineshop-app.jar"]