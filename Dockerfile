FROM eclipse-temurin:21 AS builder

RUN mkdir /opt/build
WORKDIR /opt/build
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src
RUN chmod +x ./mvnw && ls -lah
RUN ./mvnw clean verify

FROM eclipse-temurin:21-jre
RUN mkdir /opt/app && chown 1001 -R /opt/app
USER 1001
WORKDIR /opt/app
COPY --chown=1001 --from=builder /opt/build/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
