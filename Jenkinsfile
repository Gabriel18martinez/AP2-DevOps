pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Gabriel18martinez/AP2-DevOps.git'
            }
        }
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.8.6-jdk-11' // Use a versão do Maven e JDK que você precisa
                    args '-v /root/.m2:/root/.m2' // Mapeamento de volumes para cache de dependências Maven
                }
            }
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            agent {
                docker {
                    image 'maven:3.8.6-jdk-11'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }
}
