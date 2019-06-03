pipeline { 
    agent any   
    stages { 
        stage("SCM") {
            steps { 
                #git 'https://github.com/ParadoxZero/GameMenu-cpp.git'
                git 'https://github.com/curl/curl.git'
            }
        }
        stage('Build') { 
            steps { 
                sh 'make'
                sh 'cppcheck --enable=information --xml --xml-version=2 src 2> cppcheck.xml'
            }
        }
        stage("Uniti test") { 
            steps { 
                publishCppcheck pattern:'cppcheck.xml'
            }
        }
        stage("SonarQube analysis") {
            environment {
            scannerHome = tool 'sonarqube_scanner'
            }
            
            steps { 
                withSonarQubeEnv('sonarqube_scanner') {
                    sh "${scannerHome}/bin/sonar-scanner -X  -Dsonar.host.url=http://sonarqube:9000  -Dsonar.language=c++ -Dsonar.projectName=test -Dsonar.lang.patterns.c++=**/*.cpp,**/*.h -Dsonar.projectVersion=1.1 -Dsonar.projectKey=My_project -Dsonar.lang.patterns.c=**/*.c,**/*.h -Dsonar.sources=src -Dsonar.tests=. -Dsonar.test.inclusions=**/*Test*/** -Dsonar.exclusions=**/*Test*/**"
                }
            }
        }
        stage("Quality Gate") {
            steps {
                sh 'curl "http://admin:admin@sonarqube:9000/api/webhooks/create" -X POST -d "name=jenkins&url=http://jenkins:8080/sonarqube-webhook/"'
                timeout(time: 1, unit: 'MINUTES') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    // Requires SonarQube Scanner for Jenkins 2.7+
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage("Push Artifactory") {
            steps { 
                sh 'curl -u admin:password -T build/GameMenu/GameMenu.o "http://artifactory:8081/artifactory/example-repo-local/"'
            }
        }
    }
}
