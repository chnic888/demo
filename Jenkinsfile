pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

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