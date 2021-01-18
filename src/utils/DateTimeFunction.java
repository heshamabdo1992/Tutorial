package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeFunction {

	public static String ConvertDateFormat(String inputfPattern, String outputPattern, String GivenDate)
			throws ParseException {

		// System.out.println("The Month characters ONLY have to be capital like 'dd MM yyyy' ");

		SimpleDateFormat inputFormat = new SimpleDateFormat(inputfPattern);
		SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

		Date date = null;
		String requiredDate = null;

		date = inputFormat.parse(GivenDate);
		requiredDate = outputFormat.format(date);
		return requiredDate;
	}

	public static String Get_Current_date_time() {
		 
		 // Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 
		 //get current date time with Date()
		 Date Current_date_time = new Date();
		 
		 
		 // Now format the date
		 String date1= dateFormat.format(Current_date_time);
				 
		 // Return date time
		 return date1; 
		 }
	
	
	public String Get_Current_date(String Format){
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(Format);
		LocalDate Current_date_time = LocalDate.now();
		String date1=dateFormat.format(Current_date_time); //2016/11/16
		return date1;
	}
	
	public static String Get_Current_time() {
		 
		 // Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		 
		 //get current date time with Date()
		 Date Current_date_time = new Date();
		 
		 
		 // Now format the date
		 String date1= dateFormat.format(Current_date_time);
		 
		 // Return date time
		 return date1; 
		 }
	
	public static int GetAgeYears(int YYYY, int MonthNumber, int Day) {

		LocalDate today = LocalDate.now(); // Today's date
		// LocalDate birthday = LocalDate.of(2019, Month.JULY, 1); //Birth date
		LocalDate birthday = LocalDate.of(YYYY, MonthNumber, Day);
		//
		Period p = Period.between(birthday, today);

//		// Now access the values as below
//		System.out.println("Dayes: " + p.getDays());
//		System.out.println("Months: " + p.getMonths());
//		System.out.println("Years: " + p.getYears());

		return p.getYears();

	}
}
