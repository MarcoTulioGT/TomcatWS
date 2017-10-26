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
           sh 'mvn clean'
                }

        echo 'Compilando...'
          sh 'mvn compile'
        echo 'Empaquetando...'
          sh 'mvn install'
        echo 'Desplegando...'
          sh 'mvn install'
      }
    }
    stage('Test') {
      steps {
        echo 'Testing..'
      }
    }
    node{
       // Get Artifactory server instance, defined in the Artifactory Plugin administration page.
    def server = Artifactory.server "SERVER_ID"
    // Create an Artifactory Maven instance.
    def rtMaven = Artifactory.newMavenBuild()
    def buildInfo
    stage('Artefactory') {
      steps {
        echo 'Deploying....'
      }
    }
    }
  }
}
