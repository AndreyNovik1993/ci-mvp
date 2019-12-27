#Starting off with the Jenkins base Image
#FROM  jenkins/jenkins:2.187
FROM jenkins/jenkins

# Installing the plugins we need using the in-built install-plugins.sh script
RUN /usr/local/bin/install-plugins.sh git  job-dsl sonar-quality-gates configuration-as-code  docker-plugin configuration-as-code-support \
artifactory build-pipeline authorize-project xunit cppcheck locale sonar matrix-auth credentials-binding swarm \
workflow-aggregator docker-workflow cmakebuilder

 
# Setting up environment variables for Jenkins admin user
ENV JENKINS_USER admin
ENV JENKINS_PASS admin
 
# Skip the initial setup wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false 
ENV JAVA_OPTS -Dhudson.security.csrf.GlobalCrumbIssuerConfiguration=false 
ENV JAVA_OPTS -Djava.awt.headless=true 
ENV JAVA_OPTS -Djava.net.preferIPv4Stack=true
 
# Start-up scripts to set number of executors and creating the admin user
#COPY executors.groovy /usr/share/jenkins/ref/init.groovy.d/
#COPY default-user.groovy /usr/share/jenkins/ref/init.groovy.d/
copy ./groovy/*.groovy /usr/share/jenkins/ref/init.groovy.d/ 
copy jenkins.yaml /var/jenkins_home/


VOLUME /var/jenkins_home
