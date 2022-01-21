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
                        sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-maven -Dsonar.sources=src -Dsonar.java.binaries=."
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
        stage('upload Nexus') {
            steps {
                script {
                    def scannerHome = tool 'sonar-scanner';
                    withSonarQubeEnv('sonarqube-server') { 
                        sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-maven -Dsonar.sources=src -Dsonar.java.binaries=."
                    }
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
