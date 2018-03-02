import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Test class that will test the methods in the CreateDDLMySQL class
 *
 * @author Brendon Strowe
 * @author Brett Phillips
 * @author Steven Ricci
 * @author Louie Trapani
 *
 */
public class MySQLTest {


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
		for (File file : files) {
			if (file.getName().indexOf(".sql") > -1) {
                fileExists = true;
				sqlFile = new File(file.getPath());
				break;
            }
        }
		if (!fileExists) {
			// Test fails
			System.out.println("No SQL file exists in the running directory.");
			System.exit(0);
		} else {
			System.out.println("Found file " + sqlFile.getName());
		}

		// Run `mysqlcheck -u myusername -p -c [output SQL file]`
		// Check if it passes with an `OK` message or an `ERROR` message from
		//   the command output.

		// If `mysqlcheck` passes with `OK` messages for all tables, parse and
		//   loop through each table creted to see if it matches the list of
		//   tables specified in the `courses.edg` file.
		openFile(edgeFile);

		for (String tableName : tableNames) {
			System.out.println(tableName);
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
