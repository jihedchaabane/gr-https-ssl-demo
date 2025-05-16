FROM openjdk:21
WORKDIR /var/lib/jenkins/workspace/jars
ADD target/gr-https-ssl-ms0-orchestrator-0.0.1-SNAPSHOT.jar gr-https-ssl-ms0-orchestrator.jar
COPY target/gr-https-ssl-ms0-orchestrator-0.0.1-SNAPSHOT.jar gr-https-ssl-ms0-orchestrator-0.0.1-SNAPSHOT.jar
EXPOSE 1000
ENTRYPOINT ["java", "-jar", "gr-https-ssl-ms0-orchestrator-0.0.1-SNAPSHOT.jar"]