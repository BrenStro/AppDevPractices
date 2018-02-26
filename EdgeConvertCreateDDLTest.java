import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
        //super();
        //EdgeTable tbl = new EdgeTable("2|anotherTest");
        //EdgeField fld = new EdgeField("1|test");
        //super(new EdgeTable[]{new EdgeTable("2|anotherTest")}, new EdgeField[]{new EdgeField("1|test")});
//        EdgeTable tbl = new EdgeTable("1|test");
//        EdgeField fld = new EdgeField("1|anotherTest");
    }

    @Before
    public void setUp() throws Exception {
        testObj = new EdgeConvertCreateDDLTest();
        runner();
    }

    public void runner() {
        //testInitialize();
        //testGetTable();
        testGetField();
    }


    @Test
    public void testInitialize() {
    }

    @Test
    public void testGetTable() {
    }

    @Test
    public void testGetField() {
//        EdgeField[] tempFields = new  EdgeField[2];
//        EdgeField temp1 =  new EdgeField("1|testName");
//        EdgeField temp2 = new EdgeField("2|testName2");
//        tempFields[0] = temp1;
//        tempFields[1] = temp2;
//
//        assertEquals("GetField should return ", tempFields[0], testObj.getField(1));

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
