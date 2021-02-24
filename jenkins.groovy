pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Compile Stage') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Build Stage') {
            steps {
                bat 'mvn install'
            }
        }

    }
}
