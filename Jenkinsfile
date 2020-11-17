pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('SCM: code update')
            {
                steps
                {
                    // checking out repository
                    git branch: 'master',
                        credentialsId: 'holman',
                        url: 'https://github.com/holmansnc/simple-java-maven.git'
                }
            }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
    post {
        always
        {
            // Generate Allure Report
            generateAllureReport()
        }
    }
}

// Generate Allure report function
def generateAllureReport()
    {
        try
        {
            allure([
                    commandline      : '2.5.0',
                    includeProperties: false,
                    jdk              : '',
                    properties       : [[key: 'allure.tests.management.pattern', value: 'http://tms.company.com/%s']],
                    reportBuildPolicy: 'ALWAYS',
                    results          : [[path: '/allure-results']]
            ])
        }
        catch (error)
        {
            error.message
        }
    }