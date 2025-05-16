FROM openjdk:21
WORKDIR /var/lib/jenkins/workspace/jars
ADD target/gr-https-ssl-ms5-0.0.1-SNAPSHOT.jar gr-https-ssl-ms5.jar
COPY target/gr-https-ssl-ms5-0.0.1-SNAPSHOT.jar gr-https-ssl-ms5-0.0.1-SNAPSHOT.jar
EXPOSE 8445
ENTRYPOINT ["java", "-jar", "gr-https-ssl-ms5-0.0.1-SNAPSHOT.jar"]