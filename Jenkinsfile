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
        stage ('Dockerbuild') {
             steps {
                sh 'sudo docker build -t springbootjava .'
             }
        }
        stage ('Dockerpush') {

            steps {
                withCredentials([aws(credentialsId: 'aws-cli-creds', region: 'ap-southeast-1')]) {

                    sh 'aws ecr get-login-password --region ap-southeast-1 | sudo docker login --username AWS --password-stdin 314503617348.dkr.ecr.ap-southeast-1.amazonaws.com'
                    sh 'sudo docker tag springbootjava:latest 314503617348.dkr.ecr.ap-southeast-1.amazonaws.com/springbootjava:latest'
                    sh 'sudo docker push 314503617348.dkr.ecr.ap-southeast-1.amazonaws.com/springbootjava:latest'
                }
            }
        }
        stage ('Deploy-dockercompose') {

            steps{

                sh 'scp -i "jenkins-jeni.pem" docker-compose.yml ec2-user@ec2-13-212-160-69.ap-southeast-1.compute.amazonaws.com:~'
                sh 'ssh -i "jenkins-jeni.pem" ec2-user@ec2-13-212-160-69.ap-southeast-1.compute.amazonaws.com cd ~; sudo docker-compose up -d'
            }
        }
    }
}