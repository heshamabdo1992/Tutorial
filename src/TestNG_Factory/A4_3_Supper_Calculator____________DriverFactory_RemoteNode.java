package TestNG_Factory;

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


public class A4_3_Supper_Calculator____________DriverFactory_RemoteNode {

	WebDriver driver;
//	String browserName= "Chrome";	// user can remove this parameter and send it by XML file. 
	
	@Parameters({"URL","browserName"})
	@BeforeMethod
	public void setup(String URL, String browserName) throws Exception {

// ==== Call method from (Web Driver Factory) Class from (utils) package ====	
		
		// 0- search for "selenium standalone url" ->http://localhost:4444/wd/hub
		// 1- Create instance from webDriver to remote host
		// 2- Start StandAlone server using cmd command (java -jar +StandAlone.jar directory)as in snapshot.
		// 3- Other machine have to include (Webdriver.exe, StandAlone.jar)
		// 4- run script ......................... all steps as Appium workflow

		// ::Note:: in case of run in other machine replace (localhost with machine IP Like 192.0.0.172)		
		
		
		driver = utils.WebDriverFactory.RemoteWebDriver("localhost", "4444", browserName);
		driver.get(URL);	
//		URL="https://juliemr.github.io/protractor-demo/"
	}
	
	@AfterMethod
	public void TearDown() {
		System.out.println("@AfterMethod");
//		utils.BrowserFactory_ForTest.closeAllDriver();
		utils.WebDriverFactory.closeAllDriver();
	}

	
	public void Calc(String x, String Opcode, String y) {
		
		driver.findElement(By.xpath("//input[1]")).clear();
		driver.findElement(By.xpath("//input[1]")).sendKeys(x);

		driver.findElement(By.xpath("//input[2]")).clear();
		driver.findElement(By.xpath("//input[2]")).sendKeys(y);

		Select operator = new Select(driver.findElement(By.xpath("//select")));
		operator.selectByVisibleText(Opcode);

		driver.findElement(By.id("gobutton")).click();

	}

	public void assertResult(String z) {

		WebDriverWait wait = new WebDriverWait(driver, 60, 250);
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), z));
		// OR
		// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[contains(.,'" +z+ "')]")));

	}

	// ========= + operator====================
	@Test
	public void PlusOperator() throws Exception {
		Calc("5", "+", "5");
		assertResult("10");
				
	}

	
	
//	::Follow check error with::
//	https://stackoverflow.com/questions/45523264/org-testng-testngexception-cannot-inject-test-annotated-method-with-class-jav

}
