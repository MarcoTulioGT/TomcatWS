pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Compilando...'
        echo 'Empaquetando...'
        echo 'Desplegando...'
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