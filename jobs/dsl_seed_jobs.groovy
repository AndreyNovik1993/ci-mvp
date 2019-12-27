folder('job_dsl_seed') { 

   description('folder for pipeline job')

}
pipelineJob('job_dsl_seed/curl_pipeline') {
      def repo = 'https://github.com/AndreyNovik1993/ci-mvp.git' 
      description("Pipeline for $repo") 
      definition { 
           cpsScm { 
               scm { 
                 git { remote { url(repo) } 
                   	branches('master') 
               	   	scriptPath('Jenkinsfile_curl') 
                    	extensions { } 
		    }
	  } 
      } 
   } 
queue('job_dsl_seed/curl_pipeline')
}
