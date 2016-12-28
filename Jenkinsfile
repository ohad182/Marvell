node { // <1>
    stage('Build') { // <2>
        echo 'MTS branch'
        sh 'make' // <3>
    }

    stage('Test') {
        sh 'make check'
        junit 'reports/**/*.xml' // <4>
    }

    stage('Deploy') {
        sh 'make publish'
    }
}
