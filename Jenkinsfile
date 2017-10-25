pipeline {
  agent {
    node {
      label 'Ambiente'
    }
    
  }
  stages {
    stage('GitHub') {
      steps {
        echo 'Obteniendo ...'
      }
    }
    stage('Test') {
      steps {
        echo 'Testing..'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploying....'
        echo 'gfgfgfg'
      }
    }
  }
  environment {
    Desarrollo = 'DEV'
  }
}