pipeline {
    agent any
	environment {
    TMPDIR = '/tmp'
	}
    stages {
        stage ('Build') {

            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage ('Sonar-scanner') {

            steps {
                sh '/home/ec2-user/sonar-scanner-4.8.0.2856-linux/bin/sonar-scanner -Dsonar.login=sqa_6ae7a164be5e03314cc5863341ce819243d05111'
            }
        }
    }
}