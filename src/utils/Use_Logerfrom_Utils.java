package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Use_Logerfrom_Utils {

	public static void main(String[] args){
		
	
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://192.168.5.183/jhjkhjk");
		try {} catch (Exception ex)
		{System.out.println("Add User Exception\n*************\n"+ex.toString());}
	
}
}
