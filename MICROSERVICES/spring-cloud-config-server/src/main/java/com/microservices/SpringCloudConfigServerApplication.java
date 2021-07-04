package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//dependency: devtools,config server
//1.make folder anywhere named git-localconfig-repo
//2.open that folder in cmd and execute git init
//3. build path->link source->select that folder
//4. create limits-service.properties in that linked source in project and add properties for limits-service variables
//5.commit changes in local repository
//6. add the git repo path in project's application.properties
//7.add @EnableConfigServer in below file
//8. hit http://localhost:8888/limits-service/default and http://localhost:8080/limits
//9. create 2new properties files for dev and qa environment and commit them.
//10. hit http://localhost:8888/limits-service/qa and http://localhost:8888/limits-service/dev

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}
}
