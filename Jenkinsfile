#!groovy

pipeline {
  agent label : 'pt-lt0582'
  stages {
    stage('Call Global Library - print details'){
      steps{
       script{
           def fileUtils = new com.marvell.ciutils.FileUtils(this)
           fileUtils.printInfo()
            }
          }
        }
  

    stage('user name'){
      steps{
       bat "echo USER=%USERNAME%"
      }
    }
    stage('Build') { 
      steps{ 
        echo '''
MTS Build
deleting //fileril103/dev/USERS/ohadc/stam.txt
          '''
        script{
          try{
          def files = new com.marvell.ciutils.FileUtils(this)
          print files.deleteIfExists("//fileril103/dev/USERS/ohadc/stam.txt")
          }
          catch(err)
          {
            print err
          }
          
        }
      }
    }

    stage('Test') {
      steps{
       echo 'running gras'
         script{
           def grasRunner = new com.marvell.ciutils.GrasRunner(this)
           grasRunner.runGras()
         }
      }
    }

    stage('Deploy') {
      steps{
        echo 'MTS Deploy'
      }
    }
  }
  
  post {
    always {
      print 'always'
    }
    success {
      print 'pipeline success'
    }
    failure {
      print 'pipeline failed'
    }
  }
}
