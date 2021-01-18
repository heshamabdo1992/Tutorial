package A1_1_0_WebDriver;

// Reference: https://www.built.io/blog/run-selenium-tests-in-headless-browser

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriver_Using_SpecificProfile {

	// Define driver and create browser instance (Chrome)in class level to call it in all methods.
	WebDriver  driver;

	@BeforeMethod
	public void setup() {
		System.out.println("@BeforeMethod");
		System.out.println("Use chromedriver using 'specific profile'");
//		check chrome current profile profile directory: in browser URL: chrome://version/
		//========================================		
		// open web driver using specific profile
		//========================================
		ChromeOptions Options = new ChromeOptions();
		//default user
		Options.addArguments("--user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data"); //run with error
//		Options.addArguments("disable-infobars");
		//Options.addArguments("--disable-extensions");
		Options.addArguments("--start-maximized");
	    driver = new ChromeDriver(Options);
	    
	    //Or Run in normal mode without profile
//	    driver = new ChromeDriver();
	}

	@Test
	public void Login() {

		driver.get("https://www.facebook.com/");

		driver.findElement(By.id("email")).sendKeys("ahmed_ocp1@hotmail.com");
		driver.findElement(By.id("pass")).sendKeys("1020304050");

		driver.findElement(By.id("loginbutton")).click();

		// =========== Assert after in home page ==============
		Boolean xpathv = driver.findElement(By.xpath("//html[@id='facebook']//div[@id='u_0_a']//a[@title='Profile']//span[@class='_1vp5']")).isDisplayed();

		if (xpathv == true) // compare message content
			System.out.println("Test case is pass - user successfully login");
		else {
			System.out.println("Test case is fail - user can not login");
		}
	}

	@AfterMethod
	public void TearDown() {
		System.out.println("@AfterMethod");
		//driver.quit();
	}
}
