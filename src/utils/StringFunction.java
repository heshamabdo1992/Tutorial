

/**
 * Reference:: 
 * https://www.geeksforgeeks.org/split-string-java-examples/
 * https://www.rgagnon.com/javadetails/java-0438.html
 */
package utils;

public class StringFunction {

	public static String[] Splittext(String InputText, String RemoveString, int SellableNumber) {

		//	System.out.println("The InputText is: " + TdXpath);//ForTester

		String[] SplitTdArr = InputText.split(RemoveString, SellableNumber);
		
		return SplitTdArr;
	}
	
	public static String RemovePartOfTextByValue(String InputText, String RemoveText, int SellableNumber) {

		System.err.println("In 'RemovePartOfText' method the special character like (* +) need to added as following '\\+\\*' "); 
		String OutputText = "";
//		System.out.println("The InputText is: " + InputText);//ForTester
		String[] SplitTdArr = InputText.split(RemoveText, SellableNumber);
		
		for (String a : SplitTdArr)
			// System.out.println("After split"+a+"\n----------------");//ForTesterEye

			// Fill "OutputText" string
			OutputText = OutputText+a;
//			System.out.println("The New Text is: " + OutputText);//ForTester

		return OutputText;
	}
	
	public static String RemovePart2OfTextByValue(String InputText, String RemoveText, int SellableNumber) {

//		System.err.println("In 'RemovePartOfText' method the special character like (* +) need to added as following '\\+\\*' "); 
		String OutputText = "";
//		System.out.println("The InputText is: " + InputText);//ForTester
		String[] SplitTdArr = InputText.split(RemoveText, SellableNumber);
		
		for (String a : SplitTdArr){
			// System.out.println("After split"+a+"\n----------------");//ForTesterEye

			// Fill "OutputText" string
			OutputText = a;
			break;
		}
//			System.out.println("The New Text is: " + OutputText);//ForTester

		return OutputText;
	}
	
	public static String RemovePartOfTextByPosition(String InputText, int KeepValueStartPosition, int KeepValueEndPosition){
		
		String Output=InputText.substring(KeepValueStartPosition-1, KeepValueEndPosition);
		
		return Output;		
	}
	
	public static String RemovePartOfTextByPosition(String InputText, int LastRemovePosition){
		
		String Output=InputText.substring(LastRemovePosition);
		
		return Output;		
	}
	
	
	public static String Remove1stZeroFromString (String str) 
	    { 
	        // Count leading zeros 
	        int i = 0; 
	        while (i < str.length() && str.charAt(i) == '0') 
	            i++; 
	  
	        // Convert str into StringBuffer as Strings are immutable. 
	        StringBuffer sb = new StringBuffer(str); 
	  
	        // The  StringBuffer replace function removes 
	        // i characters from given index (0 here) 
	        sb.replace(0, i, ""); 
	  
	        return sb.toString();  // return in String 
	    } 
	 
}
