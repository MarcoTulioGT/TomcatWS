pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Verificando...'
        script
        {
           echo 'Instala el paquete generado en el repositorio maven'
           sh 'mvn install -Dmaven.test.skip=true'

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
