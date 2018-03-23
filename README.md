# AppDevPractices

ISTE 422

Brett Phillips \
Steven Ricci \
Brendon Strowe \
Louie Trapani

## Test Plan
We devised a plan for testing of the output of the application as well as four select Java class files. Before writing any tests, our plan is to read the requirements from the book to ensure that we fully understand what is asked of us. After everyone in the group understands the requirements, we will write the test for the basic program output as this test does not require any understanding of the application code. Once complete, we will begin to analyze the Java class files. By analyzing the Java class files together, we are able to ensure that everyone fully understands what each class does. Once we have a good basic understanding of our classes, we will distribute the Java class files based on preference. Our tests will be based off of the JUnit examples provided to us. Once each person completes a test file, we plan to get together and review the test. This will get us in the habit of code reviews for the future and also help us to understand the test that was written. If we have any suggestions or changes for a particular test, before submission, then we can bring that up during this time.

## Tests

#### MySQLTest
This test checks for a valid output from the Application. If it succeeds, a success message will be output to the console. If a failure occurs, output will explain where in the test it failed. \
Run the below to compile and run this test. Note: this particular test runs the `mysql` and `mysqlcheck` commands as the root MySQL user as part of the test. When prompted for a password, please enter the password for the root user on your local MySQL instance.
```
javac MySQLTest.java
java MySQLTest
```

#### EdgeFieldTest
This test checks the `EdgeField` class using JUnit. \
Run the below to compile and run this test:
```
javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \EdgeFieldTest.java
java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \org.junit.runner.JUnitCore EdgeFieldTest
```

#### EdgeTableTest
This test checks the `EdgeTable` class using JUnit. \
Run the below to compile and run this test:
```
javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \EdgeTableTest.java
java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \org.junit.runner.JUnitCore EdgeTableTest
```

#### EdgeConvertCreateDDLTest
This test checks the `EdgeConvertCreateDDL` class using JUnit. \
Run the below to compile and run this test:
```
javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \EdgeConvertCreateDDLTest.java
java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \org.junit.runner.JUnitCore EdgeConvertCreateDDLTest
```

#### CreateDDLMySQLTest
This test checks the `CreateDDLMySQL` class using JUnit. \
Run the below to compile and run this test:
```
javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \CreateDDLMySQLTest.java
java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \org.junit.runner.JUnitCore CreateDDLMySQLTest
```

## SDLC
Our group plans on doing a hybrid SDLC utilizing parts of both the Waterfall Model and the Scrum Model. We chose a hybrid for several reasons. We have decided to use the Waterfall Model for its clearly defined and scheduled stages (requirements->analysis->implementation->maintenance) as well as the ability for each member in our group to verbally sign off on each stage since we have a strict deadline in terms of a project end date. By not revisiting past stages, we will be able to remain on track which will allow us to ultimately meet our software goal.

In addition, we have decided to pair this model with portions of the Scrum Model. By using the Scrum Model, we plan on developing a product backlog with items that need to be completed. From that backlog, we will prioritize each item based on which milestone it belongs to and when it is due. Furthermore, since this is a maintenance project and due to time constraints, we have decided to abandon the sprint portion of the Scrum model. With that being said, we will still have daily stand ups to allow team members to brief one another and keep close cooperation between the team.

We feel this hybrid approach should allow us to be successful in completing this project correctly and on time. Below, we have provided a product backlog that is prioritized by milestone due date. We have defined each item so that they are able to be accomplished by a single team member, however if the task is larger, multiple team members will be assigned to it (e.g. refactor the codebase).

#### Product Backlog
1. Analyze the codebase to ensure understanding all classes and methods - **
2. Create a JAR file that will run the program - M3
3. Update the README to add step by step instructions for the novice user to be able to run the JAR file/program - M3
4. Decide on two different screens of help - M4
5. Design the GUIs for the different screens of help - M4
6. Implement the different screens help - M4
7. Test to ensure the different screens of help work and convey the proper information - M4
8. Refactor the codebase - M5
9. Update the README to include refactored changes and why those changes were made - M5
10. Update the README to explain how our code solves the goals of the project - M5
```

## Flowchart
#### Due to our flowchart being so large, and Lucidchart limiting the number of objects we can use, we had to break this up into three separate files.
### FlowchartOne
This flowchart shows the actual opening of the edge and previously saved file. User can view tables, fields and manipulate the relationships and contents of each table. This flowchart also shows creating a DDL file.
###flowchartTwo
This flowchart shows the file save, save as and exit menu options.
###flowchartThree
This flowchart shows the options and help menu items and the process a user must go through to act on their specific sub-items.
```