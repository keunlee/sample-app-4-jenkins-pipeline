node {
    stage('Clean workspace') {
        /* Running on a fresh Docker instance makes this redundant, but just in
        * case the host isn't configured to give us a new Docker image for every
        * build, make sure we clean things before we do anything
        */
        deleteDir()
        sh 'ls -lah'
    }

    stage('Checkout source') {
        checkout([
            $class: 'GitSCM',
            branches: [[name: '*/master']],
            doGenerateSubmoduleConfigurations: false,
            extensions: [],
            submoduleCfg: [],
            userRemoteConfigs: [[credentialsId: '7bb9430e-1d32-4db2-987d-5e5f7ea6c777', url: 'https://github.com/keunlee/sample-app-4-jenkins-pipeline.git']]
        ])
    }

    stage('Build & Test') {
        sh './gradlew build'
    }

    stage('Deploy') {
        sh 'echo "cf push -f manifest"'
    }

    stage('Run Integration Tests') {
        sh './gradlew itest'
    }

    stage('Run Sonar') {
        sh './gradlew sonarqube -Dsonar.host.url=http://172.17.0.3:9000 -Dsonar.login=fc7f8eb0a83a42342eb8ec8e75e1f1f05442834a'
    }
}