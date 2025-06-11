FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . /app

RUN ./mvnw clean install

EXPOSE 10000

ENTRYPOINT ["java", "-jar", "target/randevu-sistemi-0.0.1-SNAPSHOT.jar"]