pipeline {
    agent any

    tools {
        tool name: 'MAVEN_HOME', type: 'maven'
    }
    stages {
        stage('Clone sources') {
        	checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'bd188c3f-6b4c-4add-a1e8-bd5194c8aef7', url: 'https://github.com/mosen11/Ibeacons-backend.git/']]])

        }

        stage('Clean Build') {
            steps {
                echo "Here starts clean build "
                sh 'mvn clean install'
            }
        }
        stage('Sonar Test') {
            steps {
                sh 'mvn sonar:sonar'
            }
        }
    }
    post {
        always {
            echo 'Here is post part'
        }
        success {
            echo 'I succeeeded!'
            echo 'Finished ${env.BUILD_ID} on ${env.JENKINS_URL}'
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed to build'
            mail to: 'mosen11i@gmail.com',
                    subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                    body: "Something is wrong with ${env.BUILD_URL}"
        }
        changed {
            echo 'Things were different before...'

        }
    }
}