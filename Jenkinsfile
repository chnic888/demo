pipeline {
    agent any

    environment {
       DOCKER_HOST = 'unix:///var/run/docker.sock'
    }

    stages {
        stage('Prepare') {
            steps {
                sh './gradlew clean'
            }
        }

        stage('Validate') {
            steps {
                sh './gradlew pmdMain pmdTest'
                sh './gradlew spotbugsMain spotbugsTest'
                sh './gradlew test'
            }
        }

        stage('Build') {
            steps {
                sh "./gradlew build"
            }
        }
   }

   post {
            success {
               junit '**/target/surefire-reports/TEST-*.xml'
               archiveArtifacts 'target/*.jar'
            }
    }
}