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
        always {
            recordIssues(tools: [pmdParser(pattern: '**/build/reports/main.xml,**/build/reports/test.xml', reportEncoding: 'UTF-8')])
            junit '**/build/test-results/test/TEST-*.xml'
            archiveArtifacts 'target/*.jar'
        }
    }
}