FROM openjdk:21
WORKDIR /var/lib/jenkins/workspace/jars
ADD target/gr-https-ssl-ms2-0.0.1-SNAPSHOT.jar gr-https-ssl-ms2.jar
COPY target/gr-https-ssl-ms2-0.0.1-SNAPSHOT.jar gr-https-ssl-ms2-0.0.1-SNAPSHOT.jar
EXPOSE 8442
ENTRYPOINT ["java", "-jar", "gr-https-ssl-ms2-0.0.1-SNAPSHOT.jar"]