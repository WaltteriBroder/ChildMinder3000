FROM openjdk:8u181-jre-slim

EXPOSE 8080

WORKDIR /usr/local/bin

COPY ./target/childminder-0.0.1-SNAPSHOT.jar childminder.jar

CMD ["java", "-jar", "childminder.jar"]