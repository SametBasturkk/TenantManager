FROM eclipse-temurin:21.0.2_13-jre
ADD target/TenantManager-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]