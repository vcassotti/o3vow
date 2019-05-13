FROM openjdk:11-jre-slim
VOLUME /tmp
COPY actos-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
