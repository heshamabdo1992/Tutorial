package DateTimeFunction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Get_date_time  {

	public static void main(String[] args) {
		 
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 
		 //get current date time with Date()
		 Date Current_date_time = new Date();
		 
		 
		 // Now format the date
		 String date1= dateFormat.format(Current_date_time);
		 
		 // Print the Date
		 System.out.println("Current Date Time is: "+date1);
		 
		System.out.println(utils.DateTimeFunction.Get_Current_date_time());
		 }
	
}
