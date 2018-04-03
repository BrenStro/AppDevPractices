import java.io.*;

public class MainTester {

	private static BufferedReader br;

	public static void main(String[] args) {
		// if no args specified, use defaults
		if (args.length <= 0) {

		}
		// else, use values specified
		for (String arg : args) {
			if (arg.toLowerCase().indexOf("-h") != -1) {
				// Print help message
				System.out.println("HELP MESSAGE GOES HERE");
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

	public static void runTest(String testObject, String attributeString) {
		// Split the AttributeString into individual attributes
		String[] attributes = attributeString.split(",", 0);
		// Determine which test to run based on the specified TestObject name
		if (testObject.toLowerCase().equals("edgefield")) {
			EdgeFieldTest edgeFieldTest = new EdgeFieldTest(Integer.parseInt(attributes[0]), attributes[1]);
		} else if (testObject.toLowerCase().equals("edgetable")) {
			EdgeTableTest edgeTableTest = new EdgeTableTest(Integer.parseInt(attributes[0]), attributes[1]);
		}
	}

}
