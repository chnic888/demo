## Spring Boot Demo

#### Running Application
```bash
./gradlew
```

#### Build Artifact
```bash
./gradlew clean build
```

#### Running Test
```bash
./gradlew clean test
```

#### Test Coverage Report
```bash
./gradlew clean jacocoTestReport
```

#### Build Docker Image
```bash
docker build -t chnic888/demo:v1 .
```

#### Running Docker Container
```bash
docker run -d -e SPRING_PROFILES_ACTIVE=dev -e MYSQL_URL='jdbc:mysql://xxx.xxx.xxx.xxx:3306/test?allowPublicKeyRetrieval=true&useSSL=false' -e MYSQL_USERNAME=root -e MYSQL_PASSWORD=root chnic888/demo:v1 
```
