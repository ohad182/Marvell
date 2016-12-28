#!/usr/bin/env groovy

pipeline {
  agent any
  stages {
    stage('Call another script'){
      steps{
        def rootDir = pwd()
        def stam = load "${rootDir}/CIGlobalLic/@script/util.Groovy "
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
