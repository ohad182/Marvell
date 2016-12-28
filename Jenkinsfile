#!/usr/bin/env groovy

pipeline {
  agent any
  stages {
    stage('Call another script'){
      steps{
         def stam = load 'CIGlobalLic/util.groovy'
         stam "master"
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
