import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Test class that will test the methods in the EdgeField class
 *
 * @author Brendon Strowe
 * @author Brett Phillips
 * @author Steven Ricci
 *
 */
public class EdgeTableTest {
    //Declare the test object
    EdgeTable testObj;

    /**
     * Set up the test object before running each test
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        testObj = new EdgeTable("2|aTestName");
        runner();
    }

    /**
     * Method that will call different mutator and
     * accessor methods
     */
    public void runner() {
        testGetNumFigure();
        testGetName();
        //testAddRelatedTable();
        //testGetRelatedTablesArray();
        //testGetRelatedFieldsArray();
        //testSetRelatedField();
        //testGetNativeFieldsArray();
        //testAddNativeField();
        //testMoveFieldUp();
        //testMoveFieldDown();
        //testMakeArrays();
        testToString();
    }

    //ACCESSOR METHODS

    @Test
    public void testGetNumFigure() {
        assertEquals("numFigure was initialized to 2, so it should be 2", 2, testObj.getNumFigure());
    }

    @Test
    public void testGetName() {
        assertEquals("name was initialized to aTestName, so it should be aTestName", "aTestName", testObj.getName());
    }

    //@Test
    public void testGetRelatedTablesArray() {
        //Method is tested in the testAddRelatedTables();
    }

    //@Test
    public void testGetRelatedFieldsArray() {
        //Method is tested in the testSetRelatedFields();
    }

    //@Test
    public void testGetNativeFieldsArray() {
        //Method is tested in the testAddNativeField();, testMoveFieldDown();, testMoveFieldUp();
    }

    //MUTATOR METHODS

    @Test
    public void testSetRelatedField() {
        testObj.addNativeField(1);
        testObj.makeArrays();
        testObj.setRelatedField(0, 3);
        assertArrayEquals(new int[]{3}, testObj.getRelatedFieldsArray());
    }

    //OTHER METHODS

    @Test
    public void testAddRelatedTable() {
        testObj.addRelatedTable(1);
        testObj.makeArrays();
        assertArrayEquals(new int[]{1}, testObj.getRelatedTablesArray());
    }

    @Test
    public void testAddNativeField() {
        testObj.addNativeField(5);
        testObj.makeArrays();
        assertArrayEquals(new int[]{5}, testObj.getNativeFieldsArray());
    }

    @Test
    public void testMoveFieldUp() {
        testObj.addNativeField(1);
        testObj.addNativeField(3);
        testObj.makeArrays();
        testObj.moveFieldUp(1);
        assertArrayEquals(new int[]{3, 1}, testObj.getNativeFieldsArray());
    }

    @Test
    public void testMoveFieldDown() {
        testObj.addNativeField(1);
        testObj.addNativeField(3);
        testObj.addNativeField(6);
        testObj.makeArrays();
        testObj.moveFieldDown(0);
        assertArrayEquals(new int[]{3, 1, 6}, testObj.getNativeFieldsArray());
    }

    //@Test
    public void testMakeArrays() {
        //Method is tested in the testAddRelatedTables();, testAddNativeField();, and testSetRelatedFields(),
        //testMoveFieldUp();, testMoveFieldDown();
    }

    @Test
    public void testToString() {
    }
}
