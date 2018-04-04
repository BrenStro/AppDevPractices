import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test class that will test the methods in the EdgeField class
 *
 * @author Brendon Strowe
 * @author Brett Phillips
 * @author Steven Ricci
 * @author Louie Trapani
 *
 */
public class EdgeFieldTest {
    //Declare the test object
    EdgeField testObj;

    public EdgeFieldTest(int i, String s) {
        String inputString =  Integer.toString(i) + "|" + s;
        testObj = new EdgeField(inputString);
    }

    /**
     * Set up the test object before running each test
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        //testObj = new EdgeField("1|testName");
        //runner();
    }

    /**
     * Method that will call different mutator and
     * accessor methods
     */
    /*public void runner() {
       testGetNumFigure();
       testGetName();
       testGetTableID();
       testGetFieldBound();
       testGetDisallowNull();
       testGetIsPrimaryKey();
       testGetDefaultValue();
       testGetVarcharValue();
       testGetDataType();
       testGetStrDataType();
       testToString();
//       testSetTableID();
//       testSetTableBound();
//       testSetFieldBound();
//       testSetDisallowNull();
//       testSetIsPrimaryKey();
//       testSetDefaultValue();
//       testSetVarcharValue();
//       testSetDataType();
    }*/

    //ACCESSORS

    @Test
    public void testGetNumFigure() {
        assertEquals("numFigure was initialized to 1, so it should be 1", 1, testObj.getNumFigure());
    }

    @Test
    public void testGetName() {
        assertEquals("name was initialized to testName, so it should be testName", "testName", testObj.getName());
    }

    @Test
    public void testGetTableID() {
        assertEquals("tableID was initialized to 0, so it should be 0", 0, testObj.getTableID());
    }

    @Test
    public void testGetTableBound() {
        assertEquals("tableBound was initialized to 0, so it should be 0", 0, testObj.getTableBound());
    }

    @Test
    public void testGetFieldBound() {
        assertEquals("fieldBound was initialized to 0, so it should be 0", 0, testObj.getFieldBound());
    }

    @Test
    public void testGetDisallowNull() {
        assertEquals("disallowNull was initialized to false, so it should be false", false, testObj.getDisallowNull());
    }

    @Test
    public void testGetIsPrimaryKey() {
        assertEquals("isPrimaryKey was initialized to false, so it should be false", false, testObj.getIsPrimaryKey());
    }

    @Test
    public void testGetDefaultValue() {
        assertEquals("defaultValue was initialized to '', so it should be ''", "", testObj.getDefaultValue());
    }

    @Test
    public void testGetVarcharValue() {
        assertEquals("varcharValue was initialized to VARCHAR_DEFAULT_LENGTH, so it should be VARCHAR_DEFAULT_LENGTH", EdgeField.VARCHAR_DEFAULT_LENGTH, testObj.getVarcharValue());
    }

    @Test
    public void testGetDataType() {
        assertEquals("dataType was initialized to 0, so it should be 0", 0, testObj.getDataType());
    }

    @Test
    public void testGetStrDataType() {
        assertEquals("strDataType was initialized to {\"Varchar\", \"Boolean\", \"Integer\", \"Double\"}, so it should be {\"Varchar\", \"Boolean\", \"Integer\", \"Double\"}", new String[] {"Varchar", "Boolean", "Integer", "Double"}, EdgeField.getStrDataType());
    }

    //TO STRING

    @Test
    public void testToString() {
        assertEquals("toString should return a string with all of the properties", "1|testName|0|0|0|0|1|false|false|", testObj.toString());
    }

    //MUTATORS

    @Test
    public void testSetTableID() {
        testObj.setTableID(1);
        assertEquals("tableID was set to 1, so it should be 1", 1, testObj.getTableID());
    }

    @Test
    public void testSetTableBound() {
        testObj.setTableBound(1);
        assertEquals("tableBound was set to 1, so it should be 1", 1, testObj.getTableBound());
    }

    @Test
    public void testSetFieldBound() {
        testObj.setFieldBound(1);
        assertEquals("tableBound was set to 1, so it should be 1", 1, testObj.getFieldBound());
    }

    @Test
    public void testSetIsPrimaryKey() {
        testObj.setIsPrimaryKey(true);
        assertEquals("isPrimaryKey was set to true, so it should be true", true, testObj.getIsPrimaryKey());
    }

    @Test
    public void testSetDisallowNull() {
        testObj.setDisallowNull(true);
        assertEquals("disallowNull was set to true, so it should be true", true, testObj.getDisallowNull());
    }

    @Test
    public void testSetDefaultValue() {
        testObj.setDefaultValue("default");
        assertEquals("defaultValue was set to 'default', so it should be 'default'", "default", testObj.getDefaultValue());
    }

    @Test
    public void testSetVarcharValue() {
        testObj.setVarcharValue(2);
        assertEquals("varcharValue was set to 2, so it should be 2", 2, testObj.getVarcharValue());
    }

    @Test
    public void testSetDataType() {
        testObj.setDataType(1);
        assertEquals("dataType was set to 1, so it should be 1", 1, testObj.getDataType());
    }
}
