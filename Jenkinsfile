pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                dir ('/home/pablo/Escritorio/Diplomado-DevOps/Proyectos/ejemplo-maven') {
                    script {
                        sh "./mvnw clean compile -e"
                    }
                }    
            }
        }
        stage('Sonarqube Analisis') {
            steps {
                script {
                    def scannerHome = tool 'sonar-scanner';
                    withSonarQubeEnv('sonarqube-server') { 
                        sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-maven -Dsonar.sources=/home/pablo/Escritorio/Diplomado-DevOps/Proyectos/ejemplo-maven -Dsonar.java.binaries=."
                    }
                }
            }    
        }        
        stage('Test') {
            steps {
                dir ('/home/pablo/Escritorio/Diplomado-DevOps/Proyectos/ejemplo-maven') {
                    script {
                        sh "./mvnw clean test -e"
                    }
                }    
            }
        }
        stage('Jar') {
            steps {
                dir ('/home/pablo/Escritorio/Diplomado-DevOps/Proyectos/ejemplo-maven') {
                    script {
                        sh "./mvnw clean package -e"
                    }
                }    
            }
        }
        stage('Download Jar') {
           steps {
               script{
                  sh "curl -X GET -u 'admin:koba' http://localhost:8081/repository/repo-test/com/devopsusach2020/DevOpsUsach2020/0.0.1/DevOpsUsach2020-1.0.0.jar -O"
                  sh "ls -ltr"
                }
            }
        }
        stage('Nexus Upload'){
            steps{
                script {
                    nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-repo', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: '/home/pablo/Escritorio/Diplomado-DevOps/Proyectos/ejemplo-maven/build/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '1.0.0']]]
                }
            }
        }   
        stage('Run') {
            steps {
                dir ('/home/pablo/Escritorio/Diplomado-DevOps/Proyectos/ejemplo-maven') {
                    script {
                        sh "JENKINS_NODE_COOKIE=dontKillMe nohup bash mvnw spring-boot:run &"
                    }
                }    
            }
        }
    }
}