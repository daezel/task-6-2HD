pipeline {
    agent any

    environment {
        DATADOG_API_KEY = credentials('datadog-api-key')
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building'
                echo 'Build automation tool: Maven'
                bat 'java -version'
                bat 'mvn -version'
                bat 'docker --version'
                bat 'mvn clean package'
            }
            post {
                success {
                    echo 'Build successful!!'
                }
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                success {
                    echo'Testing successful!!'
                }
            }
        }
        stage('Code Quality Check') {
            steps {
                echo 'checking the quality of the code'
                echo 'code analysis tool-> SonarQube'
                echo 'Done!!!'
                withSonarQubeEnv('sonarqube') {
                    bat 'mvn sonar:sonar'
                }
            }
        }

        stage('Docker image Build') {
            steps {
                echo 'building docker image'
                bat 'docker --version'
                bat 'docker build -t my-spring-boot-project .'
            }
        }

        stage('Docker Deployment') {
            steps {
                echo 'Docker Deployment'
                bat 'docker-compose down'
                bat 'docker-compose up -d --build'
            }
        }

        stage('Monitoring') {
            steps {
                bat '''
                    curl -X POST "https://api.datadoghq.com/api/v1/events" ^
                        -H "Content-Type: application/json" ^
                        -H "DD-API-KEY: %DATADOG_API_KEY%" ^
                        -d "{\\"title\\": \\"Deployment Successful\\", \\"text\\": \\"The application has been successfully deployed.\\", \\"alert_type\\": \\"success\\"}"
                '''
            }
            post {
                success {
                    echo 'Monitoring successful!!'
                }
            }
        }
    }
}
