pipeline {
    agent any

    // environment {
    //     DOCKER_IMAGE = 'my-spring-boot-project:latest'
    // }

    // tools {
    //     maven '3.9.6'
    //     //jdk 'JDK 17'
    // }

    stages {
        stage('Build') {
            steps {
                // echo "fetch the source code from this -> ${DIRECTORY_PATH}"
                echo 'Building'
                echo 'Build automation tool: Maven'
                bat 'java -version'
                bat 'mvn -version'
                bat 'docker --version'
                bat 'mvn clean package'
            // sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                // echo "unit testing using -> Katalon"
                // echo "integration testing using -> Selenium"
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
                echo "building docker image"
                bat "docker --version"
                bat "docker build -t my-spring-boot-project ."
                // script {
                //     docker.build(env.DOCKER_IMAGE)
                // }
            }
        }

        stage('Docker Deployment') {
            steps {
                echo "Docker Deployment"
                bat "docker-compose down"
                bat "docker up --build"
            }
        }

    // stage('Security Scan') {
    //     steps {
    //         echo "Perform a security scan on the code using -> OWASP Dependency-Check"
    //     }
    //     post{
    //         success{
    //             emailext(
    //                 to: 'daezelgoyal01@gmail.com',
    //                 subject: 'Security Scan',
    //                 body: 'Security Scan Tests successfuly completed!!!',
    //                 attachLog: true
    //             )
    //         }
    //         failure{
    //             emailext(
    //                 to: 'daezelgoyal01@gmail.com',
    //                 subject: 'Security Scan',
    //                 body: 'Security Scan Tests Failed!!!',
    //                 attachLog: true
    //             )
    //         }
    //     }
    // }
    // stage('Deploy to Staging'){
    //     steps{
    //         echo "deploy the application to ${TESTING_ENVIRONMENT}"
    //     }
    // }
    // stage('integration test on staging') {
    //     steps {
    //         echo 'running integration test on staging'
    //     }
    // }
    // stage('Deploy to Production'){
    //     steps{
    //         echo "Deployment to ->  ${PRODUCTION_ENVIRONMENT} Started and completed!"
    //     }
    // }
    }
}
