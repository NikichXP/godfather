FROM gradle:8.4-jdk21 AS builder
WORKDIR /app
COPY . .
RUN ./gradlew bootJar --no-daemon

FROM amazoncorretto:21-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/app.jar .
EXPOSE 8761
CMD ["java", "-Xmx128M", "-jar", "app.jar"]
