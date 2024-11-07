FROM gradle:8.10.2-jdk17

WORKDIR /app/order-service
COPY src ./src
COPY build.gradle settings.gradle ./

RUN gradle clean bootJar -i --stacktrace

ENTRYPOINT ["java", "-jar", "/app/order-service/build/libs/order-service-0.0.1-SNAPSHOT.jar"]