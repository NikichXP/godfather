FROM openjdk:17-slim

WORKDIR /app

COPY build/libs/app.jar .

EXPOSE 8761

CMD ["java", "-Xmx128M", "-jar", "app.jar"]
