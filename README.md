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
Run the below to compile and run this test:
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
