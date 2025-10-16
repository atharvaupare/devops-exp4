pipeline {
  agent any
  tools {
    jdk 'jdk17'
    maven 'maven'
  }
  triggers {
    githubPush()
  }
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Test') {
      steps {
        // For Windows:
        bat 'mvn -B test'
        // (if on Linux/macOS, replace with: sh 'mvn -B test')
      }
    }
  }
  post {
    always {
      junit '**/target/surefire-reports/*.xml'
    }
  }
}
