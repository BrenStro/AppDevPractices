import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EdgeConvertCreateDDLTest extends EdgeConvertCreateDDLTestClass {
    EdgeConvertCreateDDLTestClass testObj;
    EdgeTable tbl = new EdgeTable("2|anotherTest");
    EdgeField fld = new EdgeField("1|test");



    public EdgeConvertCreateDDLTest() {
        tbl.addRelatedTable(1);
        tbl.addNativeField(1);
        tbl.makeArrays();
        EdgeTable[] tblArr = {tbl};
        EdgeField[] fldArr = {fld};
        testObj = new EdgeConvertCreateDDLTestClass(tblArr, fldArr);
    }

    @Before
    public void setUp() throws Exception {
        //runner();
    }

    /*public void runner() {
        testInitialize();
        testGetTable();
        testGetField();
    }*/

    @Test
    public void testGetTable() {
        assertEquals(tbl, testObj.getTable(2));
    }

    @Test
    public void testGetField() {
        assertEquals(fld, testObj.getField(1));
    }


    // Had to implement the abstract method
    @Override
    public String getDatabaseName() {
        return null;
    }

    @Override
    public String getProductName() {
        return null;
    }

    @Override
    public String getSQLString() {
        return null;
    }

    @Override
    public void createDDL() {

    }
}
