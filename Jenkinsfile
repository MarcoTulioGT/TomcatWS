pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Compilando...'
        echo 'Empaquetando...'
        echo 'Desplegando...'
        sh 'mvn --version'
      }
    }
    stage('Test') {
      steps {
        echo 'Testing..'
      }
    }
    stage('Artefactory') {
      steps {
        echo 'Deploying....'
      }
    }
  }
}