#!/bin/bash
curl -s -XPOST 'http://localhost:8080/createItem?name=seed' -u admin:admin  --data-binary @config.xml -H "Content-Type:text/xml" > /dev/null 
if [ $? -eq 0 ] ;  
  then echo 'job add in jenkins and create pipeline. Please wait 60s when all enviroment start'
  sleep 60 && curl -X POST http://admin:admin@localhost:8080/job/seed/build
  if [ $? -eq 0 ]
    then echo 'job seeb will work  after 4s' 
  else
    curl -X POST http://admin:admin@localhost:8080/job/seed/build
  fi
else 
   echo 'job do not add jenkins, starting jenkins conteiner' 
fi
