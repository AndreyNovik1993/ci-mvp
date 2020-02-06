Case Introduction
-
You have been assigned on a project as a build engineer. Project is a solution for embedded systems. Your team members are strong C++ developers who are focused on development of the solution. At the moment they are having difficulties with integration of developed modules. Team has to waste a lot of time on manual activities like checking code style, building, testing and so on.
Team decided to try the Continuous Integration (**CI**) approach and to automate some everyday activities. Your team isn't familiar with CI and they have asked you to prepare proposal which should include documentation and minimum viable product (**MVP**).

Work Description
- 
- Create you own repository in Github. You can take [this repository](https://git.epam.com/pavel_shchetska/ci-mvp) as example if it is usefull for you; 
- Put your documentation into README.md file. It should be in *markdown* format;
- Once you're ready, send letter to pavel_shchetska@epam.com with link to you own repository. 

## Tasks
##### 1. You have to prepare development environment which will be based on docker technology and include the next instances:
- Jenkins master;
- Jenkins Agent;
- SonarQube\*;
- Artifactory
- Git (In this case you don't need to run additional container with git, just use github)

![image](/scheme.jpg)

**NOTE:**
_Environment is configured and doesn't require additional manual steps from user. (exclude the seed job)_

**Configuration details:**
- Authorization is disabled. If it's impossible to disable authentication use admin user with admin password. Admin is usually available for all services;
- All necessary plugins are installed;
- С/С++ rules are configured in SonarQube\*;
- Quality Gates for C/C++ project are configured in SonarQube\**;
- I can specify the number of Jenkins agents\***;
- On-demand Jenkins agents\****.

##### 2. Create Jenkins items.
Seed item:
- Configure the seed job manually. Seed job is Jenkins item which is based on [JobDSL plugin](https://github.com/jenkinsci/job-dsl-plugin);
- Prepare script which will create this via Jenkins API\*;
- The seed job is created automatically (using either shell script or Makefile) and available after running Jenkins. In case of using Makefile the job should be created by calling `make seed-job` command\*;
- The seed job should monitor the repository, take DSL files from ./job folder, generate Jenkins items and execute one after generation\**.

**Pipeline item:**
Create DSL declaration for Jenkins pipeline item which will work with _Jenkinsfile_ from a repository. [Jenkins pipeline DSL declaration](https://jenkinsci.github.io/job-dsl-plugin/#method/javaposse.jobdsl.dsl.DslFactory.pipelineJob).

Finally you will get two Jenkins items:
- seed item;
- pipeline item.


##### 3. Automate build process for a project.
- Find C/C++ project at Github (check a license of a project before you start using one). For example, you can take the [curl](https://github.com/curl/curl);
- Implement declarative or scripted pipeline for you project. This pipeline should contain the following steps:
-- checkout project repository
-- build
-- execute unit tests
-- execute `sonar-scanner` and push result into SonarQube
-- prepare build artifact
-- check quality gates in SonarQube; fail job if quality gates are not passed
-- push the artifact into artifactory;
- build results and links to sonar and artifactory should be available on build dashboard in Jenkins.

##### 4. Prepare documentation.
All documentation for your project has to be put into README.md file and written in markdown 

## Acceptance criteria:
- File of docker-compose is prepared and located in git repository;
- The environment is launched via docker-compose. Environment is available and doesn't need additional manual configuration;
- Seed job creation is well-documented in the README.md file. (seed job is available\*);
- Seed job after its run creates Pipeline job and triggers it;
- Pipeline job takes project from github and builds, tests, checks and etc;
- Project analysis results are displayed on SonarQube dashboard;
- There's a binary artifact available in Artifactory;
- Build results and links to SonarQube and Artifactory are available on build dashboard in Jenkins;
- Documentation is available.



## Jenkins auto build with creating seed job, and reading Jenkinsfile

# Description of installing and running a project. 
1. Clone a git repository use a command: "git clone https://github.com/AndreyNovik1993/ci_test-task.git"
2. Install docker and docker-compose to your enviroment
3. Create folder for an artifactory /opt/artifactory/ with perrmission 777. 
4. Run command "docker-compose -f docker-compose.yml up -d --build"  in the directory where a project was cloned 
5. After will be complited docker-compose command wait several minutes until all docker enviroment start 
6. If you have to auto create seed_job will run script ./add_job.sh.
7. if you have to run jobs are configured in the jenkins automaticly, will connect to jenkins http://localost:8080 and run these jobs manually.  

P.S If you have problems with running pipeline on the stage (SonarQube), please will wait more time and restart script ./add_job.sh again. 
Warning!!! Run tasks in the docker containers on the  host or VM with memory > 4Gb.  

If you have to see resoults a static code analizy in the sonarqube will visit page http://localhost:9000, artifactory will visit  a page http://localhost:8081. 

All jobs are configured to use jenkins _as_a_code plugin. Pipelines are described on the Declarative language.