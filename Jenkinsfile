pipeline {
    agent {
        label 'JavaAgent'
    }
    environment {
            NEXUS_URL = "${NEXUS_1}"
            DOCKER_USERNAME = "${NEXUS_DOCKER_USERNAME}"
            NEXUS_PASSWORD = credentials('DEPLOY_USER_PASSWORD')
     }
    stages {
        stage('compile') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('docker build') {
            steps {
                script {
                    docker.build("rocket5mg")
                }
            }
        }
        stage('push image to nexus')
            steps {
                    script {
                        sh 'echo ${NEXUS_PASSWORD} | docker login ${NEXUS_URL} --username ${DOCKER_USERNAME} --password-stdin'
                        docker.image("rocket5mg").push()
                    }
            }
        }
    }

