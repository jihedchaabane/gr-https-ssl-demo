FROM openjdk:21
WORKDIR /var/lib/jenkins/workspace/jars
ADD target/gr-https-ssl-ms1-0.0.1-SNAPSHOT.jar gr-https-ssl-ms1.jar
COPY target/gr-https-ssl-ms1-0.0.1-SNAPSHOT.jar gr-https-ssl-ms1-0.0.1-SNAPSHOT.jar
EXPOSE 8441
ENTRYPOINT ["java", "-jar", "gr-https-ssl-ms1-0.0.1-SNAPSHOT.jar"]