FROM openjdk:17
WORKDIR /app

COPY build/libs/user-service-0.0.1-SNAPSHOT.jar /app/user-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","user-service-0.0.1-SNAPSHOT.jar"]