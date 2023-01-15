pipeline { 
    agent any 
    triggers { pollSCM('H/5 * * * *') }
    stages {
        stage('Deploy') {
        steps {
            sh "cp index.jsp main.jsp /Users/elad/tomcat/webapps/test-elad"
        }
}
        stage('Selenium') {
            steps {
                sh "selenium-side-runner /Users/elad/devops-proj.side"
            }
        }
    }
}