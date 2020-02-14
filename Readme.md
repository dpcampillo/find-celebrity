# Find the celebrity

The project was developed under the SpringBoot framework, using Java 8, SpringBoot 2.2.4.RELEASE
and Maven.
This project was generated with Spring Initializr https://start.spring.io/

# Solution!

The algorithm solution was raised, taking into account two business rules

  - A celebrity should not meet any person on the team
  - All team members should know that person
 
The implementation can be found in the class
src/main/java/com/algorithms/findcelebrity/service/CelebrityRuleService.java

## Build 
- mvn clean install

## Run
- java -jar \<path to jar\>

## Test the Application
Now that app is running, there are several services exposed to execute the different operations such as adding people and relationships, as well as looking for the celebrity

This application implements Swagger for apis documentation, visit http://localhost:9087/swagger-ui.html.
In the project there are two examples of csv files for uploading relationships
- data/data-with-celebrity.csv
- data/data-without-celebrity.csv