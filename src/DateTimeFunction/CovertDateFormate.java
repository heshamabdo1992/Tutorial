package DateTimeFunction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CovertDateFormate {

	public static void main(String[] args) throws ParseException{
		
		String date=ConvertDateFormat("dd-mm-yyyy", "dd MMM yyyy", "31-05-2019");
		
		System.out.println("The new date formate is: "+ date);
		//===================================
		
		String Curentdate="2019-05-31";
		utils.ConvertDateFormat DFormat =new utils.ConvertDateFormat();
		Date date1=new Date();
		
		String NewDateFormate=DFormat.ConvertDateFormat1("yyyy-MM-dd", "dd MMM yyyy", Curentdate);
		
		System.out.println("The Utils New Date formate i: "+ NewDateFormate);
		
		
		
		
	}
	
	public static String ConvertDateFormat (String inputfPattern, String outputPattern, String GivenDate) throws ParseException{
		   
		   SimpleDateFormat inputFormat = new SimpleDateFormat(inputfPattern);
		   SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
		   
		   Date date=null;
		   String requiredDate=null;
		   
		   date = inputFormat.parse(GivenDate);
		   requiredDate = outputFormat.format(date);
		   return requiredDate;
	}
}
