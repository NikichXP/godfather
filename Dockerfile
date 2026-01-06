FROM amazoncorretto:17-alpine

WORKDIR /app

COPY build/libs/app.jar .

EXPOSE 8761

CMD ["java", "-Xmx128M", "-jar", "app.jar"]
