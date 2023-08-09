FROM gradle:jdk17 as gradleimageeureka
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build

FROM openjdk:17
WORKDIR /app
COPY --from=gradleimageeureka /home/gradle/source/build/libs/eureka-server-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java","-jar","eureka-server-0.0.1-SNAPSHOT.jar"]
#ADD ./target/eureka-server.jar /app/
#
#CMD ["java", "-Xmx200m", "-jar", "/app/eureka-server.jar"]