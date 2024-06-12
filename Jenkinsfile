pipeline{
    agent any
    stages{
//         stage("cleanup"){
//             steps{
//                 deleteDir()
//             }
//         }
        stage("Build"){
            steps{
//                 dir("ioc"){
                    sh "mvn clean install"
//                 }
            }
        }
        stage("Test"){
            steps{
//                 dir("ioc"){
                    sh "mvn test"
//                 }
            }
        }

        stage("Deploy"){
            steps{
                sh "java -jar /target/ioc-0.0.1-SNAPSHOT.jar"
            }
        }

    }
}
