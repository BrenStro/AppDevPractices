import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EdgeFieldTest {
    EdgeField testObj;

    @Before
    public void setUp() throws Exception {
        testObj = new EdgeField("1|testName");
        runner();
    }

    public void runner() {
       testGetNumFigure();
       testGetName();
       testGetTableID();
       //testSetTableID();
       //testSetTableBound();
       testGetFieldBound();
       //testSetFieldBound();
       testGetDisallowNull();
       //testSetDisallowNull();
       testGetIsPrimaryKey();
       //testSetIsPrimaryKey();
       testGetDefaultValue();
       //testSetDefaultValue();
       testGetVarcharValue();
       //testSetVarcharValue();
       testGetDataType();
       //testSetDataType();
       testGetStrDataType();
       testToString();
    }

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
    }

    //MUTATORS

    @Test
    public void testSetTableID() {
    }

    @Test
    public void testSetTableBound() {
    }

    @Test
    public void testSetFieldBound() {
    }

    @Test
    public void testSetIsPrimaryKey() {
    }

    @Test
    public void testSetDisallowNull() {
    }

    @Test
    public void testSetDefaultValue() {
    }

    @Test
    public void testSetVarcharValue() {
    }

    @Test
    public void testSetDataType() {
    }

    @Test
    public void testToString() {
    }
}
