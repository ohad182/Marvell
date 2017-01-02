#!groovy

pipeline {
  agent label : 'pt-lt0582'
  stages {
    stage('Call another script'){
      steps{
        script{
          def externalCall = load "CIGlobalLib/util.groovy"
          externalCall("external call")
        }
      }
    }
    
    stage('Call Global Library - print something'){
  steps{
     script{
       
        def fileUtils = new com.marvell.ciutils.FileUtils(this)
       fileUtils.printSomething()
     }
  }
}
    
stage('Call Global Library - print details'){
  steps{
     script{
       
        def fileUtils = new com.marvell.ciutils.FileUtils(this)
       fileUtils.printInfo()
     }
  }
}

    stage('user Library 1'){
      steps{
       bat "echo USER=%USERNAME%"
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
