FROM openjdk:11.0.3-jdk-slim

EXPOSE 8080

WORKDIR /usr/local/bin

COPY ./target/childminder-0.0.1-SNAPSHOT.jar childminder.jar

CMD ["java", "-jar", "childminder.jar"]