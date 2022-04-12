FROM openjdk:11
COPY "./target/demo-0.0.1-SNAPSHOT.jar" "restar.jar"
EXPOSE 4369
ENTRYPOINT ["java","-jar","restar.jar"]