pipeline {
  agent any
  stages {
    
    stage('Git') 
    {
      steps 
      {
        git(url: 'https://github.com/MarcoTulioGT/TomcatWS.git')
      }
    }
    stage('Build') {
      steps {
        echo 'Verificando...'
        sh 'pwd'
          script {
           def mvnHome = tool 'Maven_Oracle'
           env.PATH = "${mvnHome}/bin:${env.PATH}"
           echo "var mvnHome='${mvnHome}'"
           echo "var env.PATH='${env.PATH}'"
           echo 'Compilando aplicación'
           sh 'mvn deploy'
                }

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
