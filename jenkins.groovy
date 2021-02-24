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

        stage('Docker build') {
            steps {
                script {
                    docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }

        stage('Deploy Image') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }

    }
}
