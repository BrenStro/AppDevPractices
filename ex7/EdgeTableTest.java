<<<<<<< HEAD
package ex7;

=======
>>>>>>> origin/master
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Test class that will test the methods in the EdgeTable class
 *
 * @author Brendon Strowe
 * @author Brett Phillips
 * @author Steven Ricci
 * @author Louie Trapani
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
        //runner();
    }

    /**
     * Method that will call different mutator and
     * accessor methods
     */
    /*public void runner() {
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
    }*/

    //ACCESSOR METHODS

    @Test
    public void testGetNumFigure() {
        assertEquals("numFigure was initialized to 2, so it should be 2", 2, testObj.getNumFigure());
    }

    @Test
    public void testGetName() {
        assertEquals("name was initialized to aTestName, so it should be aTestName", "aTestName", testObj.getName());
    }

    @Test
    public void testGetRelatedTablesArray() {
        testObj.addRelatedTable(1);
        testObj.makeArrays();
        assertArrayEquals(new int[]{1}, testObj.getRelatedTablesArray());
    }

    //Test has to be run without testAddRelatedTable() and testMakeArrays()
    //@Test
    public void testGetRelatedFieldsArray() {
        testObj.addNativeField(1);
        testObj.makeArrays();
        assertArrayEquals(new int[]{0}, testObj.getRelatedFieldsArray());
    }

    @Test
    public void testGetNativeFieldsArray() {
        testObj.addNativeField(5);
        testObj.makeArrays();
        assertArrayEquals(new int[]{5}, testObj.getNativeFieldsArray());
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

    //Test has to be run without testMakeArrays() and testGetRelatedFieldsArray()
    //@Test
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

    //Test has to be run without testAddRelatedTable() and testGetRelatedFieldsArray()
    @Test
    public void testMakeArrays() {
        testObj.addNativeField(1);
        testObj.addRelatedTable(3);
        testObj.makeArrays();
        testObj.setRelatedField(0, 2);
        assertArrayEquals(new int[]{1}, testObj.getNativeFieldsArray());
        assertArrayEquals(new int[]{3}, testObj.getRelatedTablesArray());
        assertArrayEquals(new int[]{2}, testObj.getRelatedFieldsArray());
    }

    @Test
    public void testToString() {
    }
}
