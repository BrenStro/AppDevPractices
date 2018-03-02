# AppDevPractices

## Test Plan
We devised a simple plan in order to efficiently complete the testing of the four java files. Before writing any tests,
our plan is to read the requirements from the book to ensure that we fully understand what is asked of us. After everyone
in the group understands the requirements, we will begin to analyze the Java class files. By analyzing the Java class files,
we are able to ensure that everyone fully understands what each class does. After, we will distribute the Java class files
based on preference. After each person completes a test file, we plan to get together and review the test. This will get
us in the habit of code reviews for the future and also help us to understand the test that was written. If we have any
suggestions or changes for a particular test, before submission, then we can bring that up during this time.

## Commands to compile and run all the junit tests
1. javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \EdgeFieldTest.java
2. java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \org.junit.runner.JUnitCore EdgeFieldTest
3. javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \EdgeTableTest.java
4. java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \org.junit.runner.JUnitCore EdgeTableTest
5. javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \EdgeConvertCreateDDLTest.java
6. java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \org.junit.runner.JUnitCore EdgeConvertCreateDDLTest
7. javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \CreateDDLMySQLTest.java
8. java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \org.junit.runner.JUnitCore CreateDDLMySQLTest