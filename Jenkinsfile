pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://seu-repositorio.git'
            }
        }
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.8.6-jdk-11'
                    args '-v $HOME/.m2:/root/.m2' // Mapeamento de volumes para cache de dependências Maven
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
                    args '-v $HOME/.m2:/root/.m2'
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
