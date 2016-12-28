#!/usr/bin/env groovy

pipeline {
  agent any
  stages {
    stage('Call another script'){
     
      def stam = load 'CIGlobalLic\util'
      stam "master"
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
