//import java.util.Arrays;

/**
 *
 * Circular list 
 * An implementation of a circular list with key and info.
 *
 */
 
 public class CircularList{
	 
	 protected Item[] array;
	 protected int maxLen;
	 protected int length = 0;
	 protected int start = 0;
	 
	public CircularList (int maxLen){
		array = new Item[maxLen];
		this.maxLen = maxLen;
		
	}
	 /**
   * public Item retrieve(int i)
   *
   * returns the item in the ith position if it exists in the list.
   * otherwise, returns null
   */
  public Item retrieve(int i)
  {
	  if (i < 0 || i >= length)
		  return null;
	  return array[Math.floorMod((start + i), maxLen)];
  }

  /**
   * public int insert(int i, int k, String s) 
   *
   * inserts an item to the ith position in list  with key k and  info s.
   * returns -1 if i<0 or i>n  or n=maxLen otherwise return 0.
   */
   public int insert(int i, int k, String s) {
	   if (i < 0 || i > length || length == maxLen)
		   return -1;
	   Item newItem = new Item(k, s);
	   if (length == 0) {
		   array[0] = newItem;
		   start = 0;
	   }
	   else if (i == 0) {
		   array[Math.floorMod((start - 1), maxLen)] = newItem;
		   start = Math.floorMod((start - 1), maxLen);
	   }
	   else if (i == length) {
		   array[Math.floorMod((start + i), maxLen)] = newItem;
	   }
	   else if (i < Math.floor(length/2)) {
		   shiftL(i, "insert");
		   start = Math.floorMod((start - 1), maxLen);
		   array[Math.floorMod((start + i), maxLen)] = newItem;
	   }
	   else {
		   shiftR(i, "insert");
		   array[Math.floorMod((start + i), maxLen)] = newItem;
	   }
	   length++;
	   return 0;
   }

  /**
   * public int delete(int i)
   *
   * deletes an item in the ith posittion from the list.
	* returns -1 if i<0 or i>n-1 otherwise returns 0.
   */
   public int delete(int i)
   {
	   if (i < 0 || i >= length)
			  return -1;
	   if (i == 0) {
		   start = Math.floorMod((start + 1), maxLen);
	   }
	   else if (i == (length-1)) {
		   
	   }
	   else if (i < Math.floor(length/2)) {
		   shiftR(i, "delete");
		   start = Math.floorMod((start + 1), maxLen);
	   }
	   else { // i >= n/2
		   shiftL(i, "delete");
	   }
	   length--;
	   return 0;
   }
   
   /**
    * private void shiftR(int i) 
    *
    * Utility function.
    * Increases by one indexes smaller than i.
    */
   private void shiftR(int i, String mode) {
	   switch (mode) {
		   case "delete":
			   for (int j = 0; j < i ; j++) {
				   array[Math.floorMod((start + i - j), maxLen)] = array[Math.floorMod((start + i - j - 1), maxLen)];
			   }
			   break;
		   case "insert":
			   for (int j = 0; j < (length - i) ; j++) {
				   array[Math.floorMod((start + length - j), maxLen)] = array[Math.floorMod((start + length - j - 1), maxLen)];
			   }
		   
	   }
	   
   }
   
   /**
    * private void shiftL(int i) 
    *
    * Utility function.
    * Increases by one indexes bigger than i.
    */
   private void shiftL(int i, String mode) {
	   switch (mode) {
		   case "delete":
			   for (int j = 0; j < (length - i - 1) ; j++) { 
				   array[Math.floorMod((start + i + j), maxLen)] = array[Math.floorMod((start + i + j + 1), maxLen)];
			   }
			   break;
			case "insert":
			for (int j = 0; j <= i ; j++) {
				   array[Math.floorMod(start + j - 1, maxLen)] = array[(start + j) % maxLen];
			   }
	   }
   }
   
   /**
    * public String toString()
    *
    * Utility function.
    * Returns an ordered array of the current list.
    */
//   public String toString() {
//	   Item[] arr = new Item[length];
//	   for (int i = 0; i < arr.length; i++) {
//		   arr[i] = retrieve(i);
//	   }
//	   return Arrays.toString(arr);
//   }
 }
 
 
 
