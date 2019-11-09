## Spring Boot Demo

```bash
./gradlew clean test

./gradlew clean build

docker build -t chnic888/demo:v1 .

docker run -d -e SPRING_PROFILES_ACTIVE=dev -e MYSQL_URL='jdbc:mysql://192.168.0.104:3306/test?allowPublicKeyRetrieval=true&useSSL=false' -e MYSQL_USERNAME=root -e MYSQL_PASSWORD=root chnic888/demo:v1 
```