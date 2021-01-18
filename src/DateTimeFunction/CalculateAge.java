package DateTimeFunction;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;

public class CalculateAge {

	public static void main (String [] arg) throws ParseException{
		

		int years=GetAgeYears(2016, 7, 12);
		
		System.out.println("the current years is: "+years );
	}
	
	
	
	public static int GetAgeYears (int YYYY, int MonthNumber, int Day ){
		
		LocalDate today = LocalDate.now();                          //Today's date
//		LocalDate birthday = LocalDate.of(2019, Month.JULY, 1);  //Birth date
		LocalDate birthday =LocalDate.of(YYYY, MonthNumber, Day);
//		 
		Period p = Period.between(birthday, today);
		 
		//Now access the values as below
		System.out.println("Dayes: "+p.getDays());
		System.out.println("Months: "+p.getMonths());
		System.out.println("Years: "+p.getYears());
		
		return p.getYears();
		
	}
}
