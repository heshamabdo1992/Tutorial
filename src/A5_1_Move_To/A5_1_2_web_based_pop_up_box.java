package A5_1_Move_To;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//::Reference::( https://www.softwaretestinghelp.com/handle-alerts-popups-selenium-webdriver-selenium-tutorial-16/) 
public class A5_1_2_web_based_pop_up_box  {

	WebDriver driver= new ChromeDriver();
	
	@Test
	public void web_based_pop_up_box () throws InterruptedException{
		driver.get("D:/eclips/Work_Space/Tutorial/ReadFrom/WebPopUpBox.html");
//		driver.get("https://sweetalert2.github.io/");  // a lot of message types
		
		
		//1--- Click on "Try" button -----
		driver.findElement(By.xpath("//*[@id='selectTable']//tr[2]//button")).click();
		Thread.sleep(2000);
		
		//--- Switch to Alert and click OK -------
		Alert alert= driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		
		//2--- Click on "Try" button -----
		driver.findElement(By.xpath("//*[@id='selectTable']//tr[2]//button")).click();
		Thread.sleep(2000);
		
		//--- Switch to Alert and click cancel -------
		alert= driver.switchTo().alert();
		alert.dismiss();	
		Thread.sleep(2000);
		
		//3--- Click on "Try" button -----
		driver.findElement(By.xpath("//*[@id='selectTable']//tr[2]//button")).click();
		Thread.sleep(2000);
		
		//--- Switch to Alert and get alert text -------
		alert= driver.switchTo().alert();
		Thread.sleep(2000);
		
		//-----------
		String boxText= alert.getText();
		System.out.println("The alert text is: "+ boxText);
		
		//OR
//		System.out.println("The alert text is: "+alert.getText());
		
//		//4--- Click on "Try" button -----
//		driver.findElement(By.xpath("//*[@id='selectTable']//tr[2]//button")).click();
//		
//		//--- Switch to Alert and send text -------
//		alert= driver.switchTo().alert();
//		alert.sendKeys("Ahmed El Tokhi");
		//-----------
				

		driver.quit();
	}
}
