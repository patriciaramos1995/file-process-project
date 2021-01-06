FROM gradle:jdk11 AS build-java-11

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src
RUN gradle build -x test
 
FROM openjdk:11-jre-slim
EXPOSE 8090
COPY --from=build-java-11 /home/gradle/src/build/libs/*.jar /app.jar

ENTRYPOINT java --enable-preview $JAVA_OPTS -jar /app.jar
