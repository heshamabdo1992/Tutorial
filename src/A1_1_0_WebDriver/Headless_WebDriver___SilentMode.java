package A1_1_0_WebDriver;

// Reference: https://www.built.io/blog/run-selenium-tests-in-headless-browser
// Reference: https://github.com/mdn/headless-examples/blob/master/headlessfirefox-gradle/src/main/java/com/mozilla/example/HeadlessFirefoxSeleniumExample.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Headless_WebDriver___SilentMode {

	// Define driver and create browser instance (Chrome)in class level to call it in all methods.
	WebDriver  driver;

    

	@BeforeMethod
	public void setup() {
		System.out.println("@BeforeMethod");
		System.out.println("Use chromedriver/FirefoxDriver  using 'headless' paramiter");
		
		//=================================================================		
		// use headless browser for many benefits as defined in "Reference"
		//=================================================================
		//Chrome
		ChromeOptions Options = new ChromeOptions();
		
		Options.addArguments("--headless");
		//Have to set windows size because default size is small (In Other example cannot find the element without This arg value)
		Options.addArguments("--window-size=1920,1080");
	
	    driver = new ChromeDriver(Options);
	    
	    
	   
//	    
	    //Or Run with normal mode "Visible"
//	    driver = new ChromeDriver();
	    
	    //FireFox
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		 firefoxBinary.addCommandLineOptions("--headless");
		
		 FirefoxOptions firefoxOptions = new FirefoxOptions();
		 firefoxOptions.setBinary(firefoxBinary);
		 driver = new FirefoxDriver(firefoxOptions);
		 
		//Or Run with normal mode "Visible"
//		 driver = new FirefoxDriver();
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
		driver.quit();
	}
}
