import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CreateDDLMySQLTest {
    CreateDDLMySQL testObj;

    @Before
    public void setUp() throws Exception {
        testObj = new CreateDDLMySQL();
        runner();
    }

    public void runner() {
        testConvertStrBooleanToInt();
        testGenerateDatabaseName();
        testGetDatabaseName();
        testGetProductName();
        testGetSQLString();
    }

    @Test
    public void testConvertStrBooleanToInt() {
        assertEquals("input is true, so it should be true", 1, testObj.convertStrBooleanToInt("true"));
    }

    @Test
    public void testGenerateDatabaseName() {
        String temp = testObj.generateDatabaseName();
        assertEquals("databaseName returns " + temp + ", so it should be " + temp, "OurDB", testObj.getDatabaseName());
    }

    @Test
    public void testGetDatabaseName() {
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
