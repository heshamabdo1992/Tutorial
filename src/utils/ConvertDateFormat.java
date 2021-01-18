package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDateFormat {
	
	public static String ConvertDateFormat1 (String inputfPattern, String outputPattern, String GivenDate) throws ParseException{
		   
		System.out.println("The Moth characters ONLY have to be capital like 'dd MM yyyy' ");
		
		   SimpleDateFormat inputFormat = new SimpleDateFormat(inputfPattern);
		   SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
		   
		   Date date=null;
		   String requiredDate=null;
		   
		   date = inputFormat.parse(GivenDate);
		   requiredDate = outputFormat.format(date);
		   return requiredDate;
	}
}
