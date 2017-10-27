pipeline {
  agent any
  checkout scm
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
    stage('Artefactory') {
      steps {
        script{
                   // Get Artifactory server instance, defined in the Artifactory Plugin administration page.
        def server = Artifactory.server "Artifactory_CRM"
        // Create an Artifactory Maven instance.
       def rtMaven = Artifactory.newMavenBuild()
       def buildInfo
           rtMaven.tool = 'Maven_Oracle'
          rtMaven.deployer releaseRepo:'Tigo', server: server
           buildInfo = rtMaven.run pom: 'pom.xml', goals: 'clean install'
             server.publishBuildInfo buildInfo
        echo 'Deploying....'
        echo "RESULT: ${currentBuild.result}"
        }
      }
	  
	   mail body: 'Se desplego en Artefactory',
                     from: 'Ic@tigo.com.gt',
                     replyTo: 'ctcatalan@tigo.com.gt',
                     subject: 'El proyecto se desplego correctamente',
                     to: 'ctcatalan@tigo.com.gt'
    }
	
	
}

    post {
        always {
             echo "RESULT: ${currentBuild.result}"
        }
        failure {
            echo "RESULT: ${currentBuild.result}"
        }
    }
}
