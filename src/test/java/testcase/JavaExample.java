package testcase;

public class JavaExample{
   public static void main(String args[]){
	String str="1.23";
	//int inum = 0;

	/* converting the string to an int value 
	 * ,the value of inum2 would be 123 after
	 * conversion
	 */
	 double value = Double.parseDouble(str);
	 double value2=2;
		
	//int sum = inum+inum2;
	System.out.println("Result is: "+value);
	
	int IntValue = (int) value;
	int value1=IntValue*2;
	System.out.println("Result is: "+value1);
   }
}