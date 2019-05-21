folder('job_dsl') { 

   description('folder for pipeline job')
  
}
pipelineJob('job_dsl/pipeline') {
      def repo = 'https://github.com/AndreyNovik1993/ci-mvp.git' 
      description("Pipeline for $repo") 
      definition { 
           cpsScm { 
               scm { 
                 git { remote { url(repo) } 
                   	branches('master') 
               	   	scriptPath('Jenkinsfile') 
                    	extensions { } 
		    }
	  } 
      } 
   } 
queue('job_dsl/pipeline')
}
