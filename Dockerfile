FROM openjdk:11-jre-slim

ARG EVENT_STORE_DEMO_VERSION

# We are going to work at /opt

COPY target/event-store-demo-${EVENT_STORE_DEMO_VERSION}.jar /opt/event-store-demo/event-store-demo.jar

WORKDIR /opt/event-store-demo
ENTRYPOINT ["java", "-jar", "event-store-demo.jar"]