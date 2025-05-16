FROM openjdk:21
WORKDIR /var/lib/jenkins/workspace/jars
ADD target/gr-https-ssl-ms4-0.0.1-SNAPSHOT.jar gr-https-ssl-ms4.jar
COPY target/gr-https-ssl-ms4-0.0.1-SNAPSHOT.jar gr-https-ssl-ms4-0.0.1-SNAPSHOT.jar
EXPOSE 8444
ENTRYPOINT ["java", "-jar", "gr-https-ssl-ms4-0.0.1-SNAPSHOT.jar"]