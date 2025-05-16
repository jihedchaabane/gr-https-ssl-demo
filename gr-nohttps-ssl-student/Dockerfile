FROM openjdk:21
WORKDIR /var/lib/jenkins/workspace/jars
ADD target/gr-nohttps-ssl-student-0.0.1-SNAPSHOT.jar gr-nohttps-ssl-student.jar
COPY target/gr-nohttps-ssl-student-0.0.1-SNAPSHOT.jar gr-nohttps-ssl-student-0.0.1-SNAPSHOT.jar
EXPOSE 1001
ENTRYPOINT ["java", "-jar", "gr-nohttps-ssl-student-0.0.1-SNAPSHOT.jar"]