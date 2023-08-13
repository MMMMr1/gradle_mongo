FROM gradle:jdk17 as gradleimagecrawler
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build

FROM openjdk:17
WORKDIR /app
COPY --from=gradleimagecrawler /home/gradle/source/build/libs/domain-crawler-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java","-jar","domain-crawler-0.0.1-SNAPSHOT.jar"]