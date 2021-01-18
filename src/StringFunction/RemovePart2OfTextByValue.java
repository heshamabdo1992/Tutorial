package StringFunction;

public class RemovePart2OfTextByValue {

	public static void main (String []args){
		
		String x= "CarePassport (EST UTC -5)";
		System.out.println("The old  value is:"+x);
		
		x=utils.StringFunction.RemovePart2OfTextByValue(x, " ", 2);
		System.out.println("The new value is:"+x);
	}
}
