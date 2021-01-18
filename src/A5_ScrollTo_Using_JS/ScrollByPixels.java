package A5_ScrollTo_Using_JS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollByPixels {

	static WebDriver driver = new ChromeDriver(); // Create_instance_from_WebDriver_to_current_machine

	@BeforeMethod
	public void setup() {
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com"); // Use_(get)function_of_new_instance_to_send_URL
	}
/*::Reference:: ***********"check reference document in project"***********
	 
::Note:: (java script) 
 * 1- We can search for java script command search keyword(how to get element by id in javascript). like click on page button (Department)(document.getElementById("nav-link-shopall").click();)
 * 2- We can check java script code in web page (console)by click (Ctrl+Shift+j).... Because actually selenium deal with page Data Object Model (DOM). 
 * 3- but this JS in selenium object (JavascriptExecutor) as following:
 */

	@Test
	public void Scroll2Pixels() throws Exception {

		// ===== Scroll using javascript code up to position ================
		 JavascriptExecutor sssssssssssssss = (JavascriptExecutor)driver;
		 sssssssssssssss.executeScript("window.scrollBy(0, 500)");

//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)"); // valid

		// OR Reuse same code from utils Package
		Thread.sleep(1000);
		utils.ScrollTo_InJS.ScrollByPixels(driver, 0, 500);

	}

	@AfterMethod
	public void TearDown() {
		System.err.println("@AfterMethod");
		driver.quit();
	}
}
