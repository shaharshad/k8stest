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

        stage('Docker build & Deploy') {
            steps {
                script {
                    docker.withRegistry('http://localhost:5000') {
                        def customImage = docker.build("test:${env.BUILD_ID}")
                        customImage.push()
                    }
                }
            }
        }


    }
}
