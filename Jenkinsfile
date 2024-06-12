pipeline{
    agent any
    stages{
        stage("cleanup"){
            steps{
                deleteDir()
            }
        }
        stage("Build"){
            steps{
                dir("ioc"){
                    sh "mvn clean install"
                }
            }
        }
        stage("Test"){
            steps{
                dir("ioc"){
                    sh "mvn test"
                }
            }
        }
    }
}
