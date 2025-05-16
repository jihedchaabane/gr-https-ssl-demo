FROM openjdk:21
WORKDIR /var/lib/jenkins/workspace/jars
ADD target/gr-nohttps-ssl-department-0.0.1-SNAPSHOT.jar gr-nohttps-ssl-department.jar
COPY target/gr-nohttps-ssl-department-0.0.1-SNAPSHOT.jar gr-nohttps-ssl-department-0.0.1-SNAPSHOT.jar
EXPOSE 1002
ENTRYPOINT ["java", "-jar", "gr-nohttps-ssl-department-0.0.1-SNAPSHOT.jar"]