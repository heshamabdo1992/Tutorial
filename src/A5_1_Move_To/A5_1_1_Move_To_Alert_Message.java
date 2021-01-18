package A5_1_Move_To;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class A5_1_1_Move_To_Alert_Message {

	WebDriver driver= new ChromeDriver();
	
	@Test
	public void MoveToAlertMSG () throws InterruptedException{
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		
		//---- Switch to frame ---------
		WebElement MyFrame= driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(MyFrame);		
		//OR
//		driver.switchTo().frame("iframeResult");
		//------------------------------
		driver.findElement(By.xpath("/html/body/button")).click();
		
		//--- Switch to Alert message -------
		Alert alert= driver.switchTo().alert();
		//-----------------------------------
		
		String Alertmessage= alert.getText();
		System.out.println("the alert message title: "+Alertmessage);
		Thread.sleep(1000);
		
		//--- Click "OK" button -----------
//		alert.accept();
		//OR
		driver.switchTo().alert().accept();
		//---------------------------------
		System.out.println("Ok button is clicked");
		driver.quit();
	}
}
