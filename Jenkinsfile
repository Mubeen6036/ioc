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
                dir("GitHub"){
                    sh "mvn clean install"
                }
            }
        }
        stage("Test"){
            steps{
                dir("GitHub"){
                    sh "mvn test"
                }
            }
        }
    }
}
