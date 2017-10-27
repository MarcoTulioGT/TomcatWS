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
    }
	
	  stage('Email') {
      steps {
	  emailext (
      subject: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
      body: """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
      recipientProviders: [[$class: 'DevelopersRecipientProvider']]
    )
	  }
	  }
	
}
}
