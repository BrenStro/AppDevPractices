import java.util.*;

public class EdgeTable {
   private int numFigure;
   private String name;
   private ArrayList alRelatedTables, alNativeFields;
   private int[] relatedTables, relatedFields, nativeFields;
   
   public EdgeTable(String inputString) {
      StringTokenizer st = new StringTokenizer(inputString, EdgeConvertFileParser.DELIM);
      numFigure = Integer.parseInt(st.nextToken());
      name = st.nextToken();
      alRelatedTables = new ArrayList();
      alNativeFields = new ArrayList();
   }
   
   public int getNumFigure() {
      return numFigure;
   }
   
   public String getName() {
      return name;
   }
   
   public void addRelatedTable(int relatedTable) {
      alRelatedTables.add(new Integer(relatedTable));
   }
   
   public int[] getRelatedTablesArray() {
      return relatedTables;
   }
   
   public int[] getRelatedFieldsArray() {
      return relatedFields;
   }
   
   public void setRelatedField(int index, int relatedValue) {
      relatedFields[index] = relatedValue;
   }
   
   public int[] getNativeFieldsArray() {
      return nativeFields;
   }

   public void addNativeField(int value) {
      alNativeFields.add(new Integer(value));
   }

   public void moveFieldUp(int index) { //move the field closer to the beginning of the list
      if (index == 0) {
         return;
      }
      int tempNative = nativeFields[index - 1]; //save element at destination index
      nativeFields[index - 1] = nativeFields[index]; //copy target element to destination
      nativeFields[index] = tempNative; //copy saved element to target's original location
      int tempRelated = relatedFields[index - 1]; //save element at destination index
      relatedFields[index - 1] = relatedFields[index]; //copy target element to destination
      relatedFields[index] = tempRelated; //copy saved element to target's original location
   }
   
   public void moveFieldDown(int index) { //move the field closer to the end of the list
      if (index == (nativeFields.length - 1)) {
         return;
      }
      int tempNative = nativeFields[index + 1]; //save element at destination index
      nativeFields[index + 1] = nativeFields[index]; //copy target element to destination
      nativeFields[index] = tempNative; //copy saved element to target's original location
      int tempRelated = relatedFields[index + 1]; //save element at destination index
      relatedFields[index + 1] = relatedFields[index]; //copy target element to destination
      relatedFields[index] = tempRelated; //copy saved element to target's original location
   }

   public void makeArrays() { //convert the ArrayLists into int[]
      assignArrays(nativeFields, alRelatedTables);
      assignArrays(relatedTables, alRelatedTables);
      
      relatedFields = new int[nativeFields.length];
      for (int i = 0; i < relatedFields.length; i++) {
         relatedFields[i] = 0;
      }
   }

   //TODO: - REFACTORED CODE
   /**
    * Method that will take in two arrays and loop
    * through them in order to get the columns/fields
    * from each table.
    *
    * @param array
    * @param lists
    */
   public void assignArrays(int[] array, ArrayList lists) {
      Integer[] temp = {};

      array = new int[temp.length];
      temp = (Integer[])lists.toArray(new Integer[lists.size()]);

      for (int i = 0; i < temp.length; i++) {
         array[i] = temp[i].intValue();
      }
   }

   public void appendString(StringBuffer buffer, int[] array) {
      for (int i = 0; i < array.length; i++) {
         buffer.append(array[i]);
         if (i < (array.length - 1)){
            buffer.append(EdgeConvertFileParser.DELIM);
         }
      }
   }

   //TODO: - REFACTORED CODE
   /**
    * Method that will take in a string buffer
    * and the array to be parsed. It will loop
    * through the array and parse it to get the field values
    * and append it to a string to print out.
    *
    * @param array
    * @param lists
    */
   public String toString() {
      StringBuffer sb = new StringBuffer();
      sb.append("Table: " + numFigure + "\r\n");
      sb.append("{\r\n");
      sb.append("TableName: " + name + "\r\n");
      sb.append("NativeFields: ");
      appendString(sb, nativeFields);

      sb.append("\r\nRelatedTables: ");
      appendString(sb, relatedTables);

      sb.append("\r\nRelatedFields: ");
      appendString(sb, relatedFields);
      sb.append("\r\n}\r\n");
      
      return sb.toString();
   }
}
