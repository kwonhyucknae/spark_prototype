pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn install'
      }
    }

  }
  tools {
    maven 'maven'
    jdk 'jdk8'
  }
}