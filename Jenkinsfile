pipeline {
    agent any
    tools {
        maven 'Maven3'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    // Your build commands (e.g., Maven or Gradle)
                    sh 'mvn clean install'
                }
            }
        }
    }
}
