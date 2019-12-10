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
                sh "./gradlew build -x pmdMain -x pmdTest -x spotbugsMain -x spotbugsTest -x test"
            }
        }
    }

    post {
        always {
            recordIssues enabledForFailure: true, tools: [pmdParser(pattern: '**/build/reports/pmd/*.xml', reportEncoding: 'UTF-8')]
            recordIssues enabledForFailure: true, tools: [spotBugs(pattern: '**/build/reports/spotbugs/*.xml', reportEncoding: 'UTF-8', useRankAsPriority: true)]
            junit allowEmptyResults: true, testResults: '**/build/test-results/test/TEST-*.xml'
            archiveArtifacts 'build/libs/*.jar'
        }
    }
}