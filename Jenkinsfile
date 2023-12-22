pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Your build commands (e.g., Maven or Gradle)
                    sh 'mvn clean install'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Your deployment commands
                    // (e.g., deploy to a test environment)
                }
            }
        }
    }
}
