# Stage 1: Build
FROM gradle:8.4-jdk17-alpine AS build
WORKDIR /app
COPY . .
RUN ./gradlew bootJar --no-daemon

# Stage 2: Run
FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=build /app/build/libs/app.jar .
EXPOSE 8761
CMD ["java", "-Xmx128M", "-jar", "app.jar"]
