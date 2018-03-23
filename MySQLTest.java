import java.io.*;
import java.util.ArrayList;

/**
 * Test class that will test the output of the Application.
 *
 * @author Brendon Strowe
 * @author Brett Phillips
 * @author Steven Ricci
 * @author Louie Trapani
 *
 */
public class MySQLTest {

	private BufferedReader br;

	public static final String EDGE_FILE_ID = "EDGE Diagram File"; //first line of .edg files should be this

	private File edgeFile = new File("./Courses.edg");
	private ArrayList<String> tableNames = new ArrayList<String>();

	//private EdgeConvertFileParser ecfp;
	//private CreateDDLMySQL testObj;

	/**
	 * Set up the test object before running each test
	 *
	 * @throws Exception
	 */
	public static void main(String args[]) {
		MySQLTest test = new MySQLTest();
	}

	public MySQLTest() {
		// Test if output file exists
		File currentDirectory = new File(".");
		File[] files = currentDirectory.listFiles();
		boolean fileExists = false;
		File sqlFile = new File(".");
		String databaseName = "";


		for (File file : files) {
			if (file.getName().indexOf(".sql") > -1) {
                fileExists = true;
				sqlFile = new File(file.getPath());
				break;
            }
        }
		if (!fileExists) {
			// Test fails
			System.out.println("TEST FAILED: No output SQL file exists in the running directory.");
			System.exit(0);
		} else {
			System.out.println("Found output SQL file: " + sqlFile.getName());
			try {
				br = new BufferedReader(new FileReader(sqlFile));
			} catch(FileNotFoundException e) {

			}
			String currentLine = "";
			try {
				while ((currentLine = br.readLine()) != null) {
					currentLine = currentLine.trim();
					if (currentLine.startsWith("CREATE TABLE ")) { //this has the name of the Database
						System.out.println(currentLine);
						databaseName = currentLine.substring(currentLine.indexOf("CREATE TABLE"), currentLine.indexOf("(") - 1); //get the name of the database
						break;
					}
				}
				if (databaseName.equals("")) {
					System.out.println("TEST FAILED: No database defined in Output file.");
					System.exit(0);
				}
			} catch(IOException e) {

			}
		}

		// Get the table names out of the `courses.edg` file.
		openFile(edgeFile);

		// Run `mysqlcheck -u myusername -p -c [output SQL file]`
		// Check if it passes with an `OK` message or an `ERROR` message from
		//   the command output.
		try {
			BufferedReader br;
			System.out.println("Running `mysql` command to attempt to create database from output SQL file…\n");
			Process mysqlProcess = Runtime.getRuntime().exec("mysql -u root -p < " + sqlFile.getName());
			mysqlProcess.waitFor();

			Process mysqlcheckProcess = Runtime.getRuntime().exec("mysqlcheck -u root -p -c CoursesDB");
			br = new BufferedReader(new InputStreamReader(mysqlcheckProcess.getInputStream()));
			System.out.println("`mysqltest` requires a password to login to the root user account.");
			mysqlcheckProcess.waitFor();
			System.out.println("Running `mysqltest`.");


			String line = br.readLine();
			System.out.println("");
			// Check if output matches expected
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
				if (line.toUpperCase().indexOf("ERROR") != -1) {
					System.out.println("TEST FAILED: Error in creating database from Output file.");
					System.exit(0);
				} else {
					String tableNameSql = line.substring(line.indexOf(databaseName) + 1, line.indexOf(" "));
					System.out.println(tableNameSql);
					boolean match = false;
					for (String tableName : tableNames) {
						if (tableName.toUpperCase().equals(tableNameSql.toUpperCase())) {
							match = true;
							break;
						}
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

	public void openFile(File inputFile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			//test for what kind of file we have
			String currentLine = br.readLine().trim();
			if (currentLine.startsWith(EDGE_FILE_ID)) {
				this.parseEdgeFile(inputFile); //parse the file
				br.close();
			}
		} // try
		catch (FileNotFoundException fnfe) {
			System.out.println("Cannot find edge file \"" + inputFile.getName() + "\".");
			System.exit(0);
		} // catch FileNotFoundException
		catch (IOException ioe) {
			System.out.println(ioe);
			System.exit(0);
		} // catch IOException
	} // openFile()

	public void parseEdgeFile(File inputFile) throws IOException {
		String currentLine = "";
		String tableName = "";
		boolean isEntity = false;
		int numFigure = 0;
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		while ((currentLine = br.readLine()) != null) {
			currentLine = currentLine.trim();
			if (currentLine.startsWith("Figure ")) { //this is the start of a Figure entry
				numFigure = Integer.parseInt(currentLine.substring(currentLine.indexOf(" ") + 1)); //get the Figure number
				currentLine = br.readLine().trim(); // this should be "{"
				currentLine = br.readLine().trim();
				if (!currentLine.startsWith("Style")) { // this is to weed out other Figures, like Labels
					continue;
				} else {
					String style = currentLine.substring(currentLine.indexOf("\"") + 1, currentLine.lastIndexOf("\"")); //get the Style parameter
					if (style.startsWith("Entity")) {
						isEntity = true;
					} else {
						continue;
					}
					currentLine = br.readLine().trim(); //this should be Text
					tableName = currentLine.substring(currentLine.indexOf("\"") + 1, currentLine.lastIndexOf("\"")).replaceAll(" ", ""); //get the Text parameter
					if (tableName.equals("")) {
						// Test failed with malformed SQL
						System.out.println("There are entities or attributes with blank names in this diagram.");
					break;
					}
				}
				int escape = tableName.indexOf("\\");
				if (escape > 0) { //Edge denotes a line break as "\line", disregard anything after a backslash
					tableName = tableName.substring(0, escape);
				}

				if (isEntity) { //create a new EdgeTable object and add it to the alTables ArrayList
					tableNames.add(tableName);
				}
				//reset flags
				isEntity = false;
			} // if("Figure")
		} // while()
	} // parseEdgeFile()
}
