FROM openjdk:11-jre-slim

ARG EVENT_STORE_DEMO_VERSION

# We are going to work at /opt

COPY target/admission-event-service-${EVENT_STORE_DEMO_VERSION}.jar /opt/admission-event-service/admission-event-service.jar

WORKDIR /opt/admission-event-service
ENTRYPOINT ["java", "-jar", "admission-event-service.jar"]