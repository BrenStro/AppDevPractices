
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.*;

public class MainTester {

	private static BufferedReader br;
	public static int num = 0;
	public static String test = "";

	public static void main(String[] args) {
		MainTester test = new MainTester();
		test.setup(args);
	}

	public void setup(String[] args) {
		// if no args specified, use defaults
		if (args.length <= 0) {
			String testObj = "EdgeField";
			String attributeString = "1,testName";
			System.out.println("Running default test with params: " + testObj + " " + attributeString);
			runTest(testObj, attributeString);
			return;
		}
		// else, use values specified
		for (String arg : args) {
			if (arg.toLowerCase().indexOf("-h") != -1) {
				// Print help message
				System.out.println("The following are a list of commands options:\n");
				System.out.println("-n: what follows is the test object being tested");
				System.out.println("\tEX. MainTester EdgeField -n \"1,testName\"");
				System.out.println("-h help menu");
				System.out.println("\tEX. MainTester -h");
				System.out.println("-f: what follows is the name of a test object file");
				System.out.println("\tEX. MainTester -f testobjectfile.txt");

				System.out.println("\n\nThe following are examples of the full command prompt input:\n");
				System.out.println("java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar  MainTester EdgeField -n \"1,testName\"");
				System.out.println("java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar  MainTester -h");
				System.out.println("java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar  MainTester -f testobjectfile.txt\n");

				System.out.println("NOTE: You must specify the class name to be tested as well, which is before the command option (-n)");

				break;
				// For inline object definition
			} else if (arg.toLowerCase().indexOf("-n") != -1) {
				// Process test object
				String testObject = args[0];
				runTest(testObject, args[args.length-1]);
				break;
				// For datafile object definition
			} else if (arg.toLowerCase().indexOf("-f") != -1) {
				File dataFile = new File(args[args.length-1]);
				try {
					br = new BufferedReader(new FileReader(dataFile));
				} catch(FileNotFoundException e) {
					System.out.println("Specified file " + args[args.length-1] + "not found! Please try again.");
					System.exit(0);
				}
				String currentLine = "";
				try {
					while ((currentLine = br.readLine()) != null) {
						currentLine = currentLine.trim();
						// Split the line into the TestObject Name and the Attribites
						String[] arguments = currentLine.split(",", 2);
						runTest(arguments[0], arguments[1]);
					}
				} catch(IOException e) {
					System.out.println("IO Exception encountered when reading from data file.");
					e.printStackTrace();
				}
				break;
			}
		}
	}


	public void runTest(String testObject, String attributeString) {
		// Split the AttributeString into individual attributes
		String[] attributes = attributeString.split(",", 0);
		// Determine which test to run based on the specified TestObject name
		if (testObject.toLowerCase().equals("edgefield")) {
			num = Integer.parseInt(attributes[0]);
			test = attributes[1];

			EdgeFieldTest edgeFieldTest = new EdgeFieldTest();
			Result result = JUnitCore.runClasses(EdgeFieldTest.class);
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}

			System.out.println("Was the test successful: " + result.wasSuccessful());
		} else if (testObject.toLowerCase().equals("edgetable")) {
			num = Integer.parseInt(attributes[0]);
			test = attributes[1];

			EdgeTableTest edgeTableTest = new EdgeTableTest();
			Result result = JUnitCore.runClasses(EdgeTableTest.class);
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}

			System.out.println("Was the test successful: " + result.wasSuccessful());
		}
	}

}
