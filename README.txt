Simple application to integrate Spring with AngularJS using the following:


- Spring has been configured with Spring Boot with the following modules
	1-	Spring Data JPA ->  as persistence layer.
	2-	Spring Data REST with Spring HATEOAS ->  for Rest Services layer that interacts with AngularJS.
	3-	Spring Security ->  for Authentication and Authorization Application.
	4-	Spring MVC con Thymeleaf ->  mainly it used to manage the lists of consultation and all views that do not have forms.
	5-	AngularJS ->  It is used to view the detail forms.
	6-	Bootstrap + Angular-ui + Font Awesome + Angular-Show-Errors ->  for the design and layout of the front end.
	7-	JUnit ->  unit tests.

	
- Database server and embedded are used for example: H2 y Tomcat.


- To create reports using JasperReports. Pom has been set for that from the /src/main/resources/static/reports/*.jrxml files and generate /src/main/webapp/jasper/*.jasper. To do so just run mvn generate-resources.


- Dependency management is done with: Maven y bower.


Installation
1- Install maven (used version 3.0.5)
2- Install the wraper of maven for spring-boot: mvn -N io.takari:maven:wrapper
3- It can be run in several ways:
	With maven:	mvn spring-boot:run. 
	ó
	Building the jar:  mvn clean package 
	And running:       java -jar target/springangularjs-0.0.1-SNAPSHOT.jar

4- If all goes well the application will run on: http://localhost:8080/
	
	
4- Copy and import the Eclipse project as a Maven project.
5- Remember that to change js libraries Bower necessary. For that:
    a- Install node.js (https://nodejs.org/)
    b- Install git (https://git-scm.com/download/win)
    c- Install bower con: npm install -g bower
    d- Finally running "install bower" in the project we placed in the /src/main/resources/static/bower_components versions of the libraries listed in bower.json.
	
	


