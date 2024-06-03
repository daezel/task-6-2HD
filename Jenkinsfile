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
                    echo 'Build using MAVEN successful!!'
                }
                failure {
                    echo 'Build failed!'
                    emailext(
                        to: 'daezelgoyal01@gmail.com',
                        subject: 'Build Failed',
                        body: 'Build failed!!!',
                        attachLog: true
                    )
                }
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                success {
                    emailext(
                        to: 'daezelgoyal01@gmail.com',
                        subject: 'Testing',
                        body: 'Testing successfuly completed!!!', 
                        attachLog: true
                    )
                }
                failure{
                    emailext(
                        to: 'daezelgoyal01@gmail.com',
                        subject: 'Testing',
                        body: 'Testing Failed!!!', 
                        attachLog: true   
                    )
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
            post {
                success {
                    echo 'Code quality check successful!'
                }
                failure {
                    echo 'Code quality check failed!'
                    emailext(
                        to: 'daezelgoyal01@gmail.com',
                        subject: 'Code Quality Check Failed',
                        body: 'Code quality check failed!!!',
                        attachLog: true
                    )
                }
            }
        }

        stage('Docker image Build') {
            steps {
                echo 'building docker image'
                bat 'docker --version'
                bat 'docker build -t my-spring-boot-project .'
            }
            post {
                success {
                    echo 'Docker image build successful!'
                }
                failure {
                    echo 'Docker image build failed!'
                    emailext(
                        to: 'daezelgoyal01@gmail.com',
                        subject: 'Docker Image Build Failed',
                        body: 'Docker image build failed!!!',
                        attachLog: true
                    )
                }
            }
        }

        stage('Docker Deployment') {
            steps {
                echo 'Docker Deployment'
                bat 'docker-compose down'
                bat 'docker-compose up -d --build'
            }
            post {
                success {
                    echo 'Docker deployment successful!'
                }
                failure {
                    echo 'Docker deployment failed!'
                    emailext(
                        to: 'daezelgoyal01@gmail.com',
                        subject: 'Docker Deployment Failed',
                        body: 'Docker deployment failed!!!',
                        attachLog: true
                    )
                }
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
                failure {
                    echo 'Monitoring failed!'
                    emailext(
                        to: 'daezelgoyal01@gmail.com',
                        subject: 'Monitoring Failed',
                        body: 'Monitoring failed!!!',
                        attachLog: true
                    )
                }
            }
        }
    }
}
