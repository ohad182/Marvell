#!/usr/bin/env groovy

pipeline {
  agent any
  stages {
    stage('Build') { 
      steps{
        script{
          def mts = new com.marvell.ciutils.MtsUtils(this)
          mts.startBuild()
        }
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
