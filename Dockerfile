FROM openjdk:8-alpine

LABEL maintainer=chnic888@gmail.com

ENV TZ=Asia/Shanghai

COPY build/libs/demo-1.0.jar /app/demo-1.0.jar

EXPOSE 8080

WORKDIR /app

ENTRYPOINT ["java", "-jar"]

CMD ["demo-1.0.jar"]