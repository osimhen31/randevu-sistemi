FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . /app

RUN ./mvnw clean install -DskipTests

EXPOSE 10000

CMD ["java", "-jar", "target/randevusistemi-0.0.1-SNAPSHOT.jar"]