import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test class that will test the methods in the CreateDDLMySQL class
 *
 * @author Brendon Strowe
 * @author Brett Phillips
 * @author Steven Ricci
 * @author Louie Trapani
 *
 */
public class CreateDDLMySQLTest {
    //Declare the test object
    CreateDDLMySQL testObj;

    /**
     * Set up the test object before running each test
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        testObj = new CreateDDLMySQL();
        runner();
    }

    /**
     * Method that will call different mutator and
     * accessor methods
     */
    public void runner() {
        testConvertStrBooleanToInt();
        //testGenerateDatabaseName();
        testGetDatabaseName();
        testGetProductName();
        testGetSQLString();
    }

    @Test
    public void testConvertStrBooleanToInt() {
        assertEquals("input is true, so it should be true", 1, testObj.convertStrBooleanToInt("true"));
    }

    //@Test
    public void testGenerateDatabaseName() {
        String temp = testObj.generateDatabaseName();
        assertEquals("databaseName returns " + temp + ", so it should be " + temp, "TestDB", testObj.getDatabaseName());
    }

    @Test
    public void testGetDatabaseName() {
        testObj.generateDatabaseName();
        assertEquals("databaseName is set as MySQLDB, so it should be MySQLDB", "MySQLDB", testObj.getDatabaseName());
    }

    @Test
    public void testGetProductName() {
        assertEquals("productName returns MySQL, so it should be MySQL", "MySQL", testObj.getProductName());
    }

    @Test
    public void testGetSQLString() {
    }
}
