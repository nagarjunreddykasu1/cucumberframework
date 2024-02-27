pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the project'
            }
        }
        stage('Testing') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/nagarjunreddykasu1/cucumberframework.git']])
                bat 'mvn clean test'
                echo 'Testing the project'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the project'
            }
        }
    }
}
