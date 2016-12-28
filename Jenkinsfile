#!/usr/bin/env groovy
pipeline {
  agent label : 'pt-lt0104'
  stages {
    stage('Call another script'){
      steps{
        script{
          def externalCall = load("CIGlobalLib\\util.groovy")
          externalCall("beer")
        }
      }
    }
    
    stage('Call Global Library'){
      steps{
       script{
          acme.foo = "5";
          echo acme.foo; // print 5
          acme.say "Joe" // print "Hello world, Joe"
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
