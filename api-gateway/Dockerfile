FROM gradle:jdk17 as gradleimageapi
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build

FROM openjdk:17
WORKDIR /app
COPY --from=gradleimageapi /home/gradle/source/build/libs/api-gateway-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java","-jar","api-gateway-0.0.1-SNAPSHOT.jar"]