FROM adoptopenjdk/openjdk8

COPY build/libs/*.jar application.jar

CMD ["java", "-jar", "application.jar"]