// imports
import jenkins.model.Jenkins
import jenkins.model.JenkinsLocationConfiguration

// parameters
def jenkinsParameters = [
  email:  'Uladzimir Amelyanovich <uladzimir_amelyanovich@epam.com>',
  url:    'http://jenkins:8080/'
]

// get Jenkins location configuration
def jenkinsLocationConfiguration = JenkinsLocationConfiguration.get()

// set Jenkins URL
jenkinsLocationConfiguration.setUrl(jenkinsParameters.url)

// set Jenkins admin email address
jenkinsLocationConfiguration.setAdminAddress(jenkinsParameters.email)

// save current Jenkins state to disk
jenkinsLocationConfiguration.save()
