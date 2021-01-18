package A1_1_0_WebDriver;

import org.openqa.selenium.By;

/*open link using Utils web driver*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class DemoWordPress____________UtilsPackage {

	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeMethod
	public void setup(String browserName) {
		
//		WebDriver driver = utils.BrowserFactory.getBrowser("Chrome");
//		driver.get("https://juliemr.github.io/protractor-demo/");
		
		driver = utils.New_WebDriver.Driver_Default(browserName);
		driver.get("https://juliemr.github.io/protractor-demo/");			
	}
	
	@AfterMethod
	public void TearDown() {
		System.out.println("@AfterMethod");
//		utils.BrowserFactory.closeAllDriver();
		utils.New_WebDriver.closeAllDriver();
	}

	
	public void Calc(String x, String Opcode, String y) throws InterruptedException {
		
		driver.findElement(By.xpath("//input[1]")).clear();
		driver.findElement(By.xpath("//input[1]")).sendKeys(x);

		driver.findElement(By.xpath("//input[2]")).clear();
		driver.findElement(By.xpath("//input[2]")).sendKeys(y);

		Select operator = new Select(driver.findElement(By.xpath("//select")));
		operator.selectByVisibleText(Opcode);

		driver.findElement(By.id("gobutton")).click();
		
		
		Thread.sleep(5000);
	}

//	@Parameters("browserName")
	public void assertResult(String z) {

		WebDriverWait wait = new WebDriverWait(driver, 60, 250);
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), z));
		// OR
		// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[contains(.,'" +z+ "')]")));

	}

	// ========= + operator====================
//	@Parameters("browserName")
	@Test(groups= { "SmokeTest", "FullTest" })
	public void PlusOperator() throws Exception {
		Calc("5", "+", "5");
		assertResult("10");
	}
//	::Follow check error with::
//	https://stackoverflow.com/questions/45523264/org-testng-testngexception-cannot-inject-test-annotated-method-with-class-jav

}
