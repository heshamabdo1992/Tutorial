package A4_Select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class A4_2_2_Get_The_Selected_Value {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_option_selected"); // Use_(get)function_of_new_instance_to_send_URL
	}

	@Test
	public void testselect() throws InterruptedException {
		
		driver.switchTo().frame("iframeResult");
		Select careselect = new Select(driver.findElement(By.tagName("select")));

		// === Select from list ================================
		 
				
		careselect.selectByIndex(1);		  // select by attribute name (Value) witch its value = opel.
		
		//=== Get The selected Value =========================
		
		WebElement option = careselect.getFirstSelectedOption();
		String Val = option.getText();
		
		//OR
//		String Val=careselect.getFirstSelectedOption().getText();	   
		
		
		//=== Print the selected Value =========================
		System.out.println("-----------------------------------------\nThe default selection value is: "+Val);   //Print the selection value.
		
		//OR
		System.out.println("-----------------------------------------\nThe default selection value is: "+careselect.getFirstSelectedOption().getText());

	}

	
	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
	
}
