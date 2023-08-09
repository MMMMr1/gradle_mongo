FROM gradle:jdk17 as gradleimagegateway
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build

FROM openjdk:17
WORKDIR /app
COPY --from=gradleimagegateway /home/gradle/source/build/libs/gateway-server-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java","-jar","gateway-server-0.0.1-SNAPSHOT.jar"]
