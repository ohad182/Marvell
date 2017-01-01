#!groovy

pipeline {
  agent label : 'pt-lt0582'
  stages {
    stage('Call another script'){
      steps{
        script{
          def externalCall = load("CIGlobalLib\\util.groovy")
          externalCall("beer")
        }
      }
    }
    
stage('Call Global Library - print details'){
  steps{
   
     script{
       @Library('JenkinsCILib') _
       import com.marvell.utils.FileUtils
        def fileUtils = new FileUtils()
       fileUtils.printInfo()
     }
  }
}

    stage('Call Global Library 1'){
      steps{
       script{
          helloWorld "5";
         
       }
      }
    }
      
    
    stage('Build') { 
      steps{ 
        echo 'MTS Build'
      }
    }

    stage('Test') {
      steps{
       echo 'MTS Test'
      }
    }

    stage('Deploy') {
      steps{
        echo 'MTS Deploy'
      }
    }
  }
}
