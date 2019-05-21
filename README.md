## Jenkins auto build with creating seed job, and reading Jenkinsfile

# For install and runing project do next steps: 
1. Clone git repository: git clone https://github.com/AndreyNovik1993/ci_test-task.git
2. Install docker on your enviroment
3. Run command "docker-compose -f docker-compose.yml up -d"  in directory when git cloned
4. After complited docker-compose command wait several minutes until all docker enviroment start 
5. Run commnad ./add_job.sh seed job will be create after 5s and after creating pipeline job will run once.

If you want see resolts for sonarqube visit page http://localhost:9000, artifactory with build http://localhost:8081. 
All workflow watched in http://localhost:8080/blue/organizations/jenkins/job_dsl%2Fpipeline/detail/pipeline/1/pipeline or http://localhost:8080/job/job_dsl/job/pipeline/


Config for creating seed job saved in file -> config.xml 

Config for creating pipeline job saved in file -> jobs/pipeline.groovy
