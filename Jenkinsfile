pipeline {
    agent any

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
