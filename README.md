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
Our group plans on doing a hybrid SDLC utilizing parts of both the Waterfall Model and the Scrum Model. We have decided to incorporate aspects of the the Waterfall Model for its clearly defined and scheduled stages (requirements->analysis->implementation->maintenance) as well as the ability for each member in our group to verbally sign off on each stage. Since we have a strict deadline in terms of a project end date—as per myCourses Dropboxes—we will not be revisiting past stages unless absolutely necessary. Waterfall will keep us on track to ultimately meet our software goal. We have dedicated Brendon Strowe as Product Owner. He will be responsible for closely analyzing and understanding the requirements of the project as defined in the course `book.pdf`.

In addition, we have decided to pair Waterfall with portions of the Scrum Model. By using the Scrum Model, we plan on developing a product backlog with items that need to be completed. From that backlog, we will prioritize each item based on which milestone it belongs to and when it is due. Furthermore, since this is a maintenance project and due to time constraints, we have decided to abandon the sprint portion of the Scrum model. With that being said, we will still have stand up meetings to allow team members to brief one another and keep close cooperation between the team. After meetings, pair and group programming will be implemented to ensure thorough debugging and group-understanding of the inherited broken project.

We feel this hybrid approach should allow us to be successful in completing this project correctly and on time. Below, we have provided a product backlog that is prioritized by milestone due date. We have defined each item so that they are able to be accomplished by a single team member, however if the task is larger, multiple team members will be assigned to it (e.g. refactor the codebase).

#### Product Backlog
1. Analyze the codebase to ensure understanding all classes and methods - **
2. Write an ANT XML document which will compile the project - M3
3. The ANT build will compile and create a JAR file that can run the program - M3
4. Update the README to add step by step instructions for the novice user to be able to run the JAR file/program - M3
5. Decide on two different screens of help - M4
6. Design the GUIs for the different screens of help - M4
7. Implement the different screens help - M4
8. Test to ensure the different screens of help work and convey the proper information - M4
9. Refactor the codebase - M5
10. Update the README to include refactored changes and why those changes were made - M5
11. Update the README to explain how our code solves the goals of the project - M5

## Flowchart
#### Due to our flowchart being so large, and Lucidchart limiting the number of objects we can use, we had to break this up into three separate files. See flowchart directory in this root directory for the flowchart files.
### FlowchartOne
This flowchart shows the actual opening of the edge and previously saved file. User can view tables, fields and manipulate the relationships and contents of each table. This flowchart also shows creating a DDL file.

### FlowchartTwo
This flowchart shows the file save, save as and exit menu options.

### FlowchartThree
This flowchart shows the options and help menu items and the process a user must go through to act on their specific sub-items.

## Ex7 - Test Fixture
To run the automated tests created in Ex7 - Test Fixture, run the below commands:
```
javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar MainTester.java
java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar MainTester <OPTIONS>
````
### OPTIONS for command:

`-h`: help menu\
	EX. `MainTester -h`\
`-n`: what follows is the test object being tested\
	EX. `MainTester EdgeField -n "1,testName"`\
`-f`: what follows is the name of a test object file\
	EX. `MainTester -f testobjectfile.txt`

The following are examples of the full command prompt input:

`java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar  MainTester -h`\
`java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar  MainTester EdgeField -n "1,testName"`\
`java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar  MainTester -f testobjectfile.txt`

**NOTE: You must specify the class name to be tested as well, which is before the command option (`-n`)**

## Deployment Strategy

For this milestone, we decided to make an Ant build file (build.xml). This decision was made because not only is Ant Java-specific, but it also allows the user to compile, build, and create a JAR file all in one step. This simplified process makes for a more straight-forward process to get the user up-and-running.

**How to Build:**
The following steps will outline in detail how to compile the project:
1. Download and unzip the source code.
2. In a new terminal shell instance, navigate to the build directory inside the source directory you just unzipped (with `cd build`).
3. Run the command `ant clean-build`. Note: This command can be run at anytime to build a fresh copy of the project.

**How to Run:**
Once the above steps are followed to build the project, you can follow the below to run the application:
1. Navigate down into the newly created jar directory within the build directory. From the source directory, run `cd build/jar`.
2. Run the JAR file using the command `java -jar RunEdgeConvert.jar`.
3. The application should then launch successfully.

## Help System
Please see the Deployment Strategy for steps on how to compile and run the program.
Once the program is running, go to the help menu on the toolbar to view the help options.

## Refactored Abstracted Code
During our refactoring, the classes that we had changed were EdgeTable.java and CreateDDLMySQL.java. As we were analyzing the code, we noticed
that there was a lot of duplication within the codebase. Therefore, we spent majority of our refactoring extracting duplicated and unneeded code
and putting them into methods. By doing this, it allows the code to be more readable, maintainable, and extensible.

**EdgeTable.java** \
In this class, we created two methods (moveFields() and assignArrays()). These methods allow us to remove duplicated code
and extract it in to one common method. This allows us to easily call these methods by passing in the needed parameters. By doing this,
the code becomes easier to read, understand, and access.

**CreateDDLMySQL.java** \
In this class, we manipulated one method (convertStrBooleanToInt()). Here, we cleaned up the code to remove unneeded
lines. This allows us to make the method more readable and clean.

**What you would have to do to use a different DBMS or modeling programs file?** \
There is not too much that has to be done in regard to manipulating the program to use a different DBMS or modeling programs file. The main thing that would need to be changed is the
transition and use of interfaces. This would allow the code to be more abstract and, therefore, provide the ability to conform how the program is run given a specific file. By using interfaces,
specific classes can be called upon and instantiated during runtime to change the behavior of the program in terms of the DMBS or files that are used. The EdgeConvertCreateDDL abstract class already exists as a good candidate from which to build an interface for creating DDL for other database products.
Adding an interface to handle reading in different modeling files would require generalizing the code currently used to read-in Edge files—removing specific references to the format of Edge Files—and, similar to the way the process currently works for selecting an output DDL, allow the user to add classes for reading in specific types of modeling files (e.g. Edge and Save files). The rest of the application would then reference these abstracted methods instead of the Edge File methods which currently exist.