# Problem: Find the celebrity

## Description:
- In a team of n people, a celebrity is known by everyone but he/she doesn't know anybody.

# Solution!

The algorithm solution was raised, taking into account two business rules

  - A celebrity should not meet any person on the team
  - All team members should know that person
  
The project was developed under the SpringBoot framework, using Java 8, SpringBoot 2.2.4.RELEASE
and Maven.
This project was generated with Spring Initializr https://start.spring.io/

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

In the first column goes the person, and the second column goes the person who is known,
for example. If the person does not know anyone, the second column is empty
In the application there is a function that read the file under this structure and is able to build the structure of people with their respective relationships