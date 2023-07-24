pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "3.9.2"
        jdk "jdk-11.0.15.1"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'first_branch', url: 'https://github.com/ryhor-dubrovin/qase-test-automation.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true -Dtoken=72b2653608fade7ce5de34b2db36aa9eafd86826f56f6517ffd90c084b383528 -Dbrowser=chrome -Demail=${email} -Dpassword=${password} -Dsurefire.suiteXmlFiles=src/test/resources/test.xml clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    // archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Reporting') {
            steps {
             script {
                 allure([
                             includeProperties: false,
                             jdk: '',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'allure-results']]
                ])
            }
            }
        }
    }
}
