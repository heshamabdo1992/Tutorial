package A1_2_RemoteNode;

// Run Script in remote server

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class A2_RemoteNodeConnection____Parallel {

	
	WebDriver driver;
//	String Brow_Name= "Chrome";
	
	@Parameters({"browserName"})
	@BeforeMethod
	public void setup(String browserName) throws Exception {
	
		System.out.println("Run Script throw Remote Node Connection");

		// 0- search for "selenium standalone url" -> http://localhost:4444/wd/hub
		// 1- Create instance from webDriver to remote host
		// 2- Start StandAlone server using cmd command (java -jar + StandAlone.jar directory)as in snapshot.*on Remote PC*
		// 3- Other machine have to include (Webdriver.exe, StandAlone.jar)
		// 4- run script ......................... all steps as Appium workflow

		// ::Note:: in case of run in other machine replace (localhost with machine IP Like 192.0.0.172)
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
			driver = new RemoteWebDriver(new URL("http://192.168.5.183:4444/wd/hub"), DesiredCapabilities.chrome());
		}
		if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
			driver = new RemoteWebDriver(new URL("http://192.168.5.183:4444/wd/hub"), DesiredCapabilities.firefox());
		}
	
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
	
	}

	@Test
	public void FaceBook_Login () throws InterruptedException{		
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("ahmed_ocp1@hotmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("1020304050");
		driver.findElement(By.xpath("//*[@id='u_0_8']")).click();

		// ===== Assert for page load====
		Boolean xpathv = driver.findElement(By.xpath("//html[@id='facebook']//div[@id='u_0_a']//a[@title='Profile']//span[@class='_1vp5']")).isDisplayed();

		if (xpathv == true) // compare message content
			System.out.println("Test case is pass - user successfully login");
		else {
			System.out.println("'A2_RemoteNodeConnection____Parallel' Test case is fail - user can not login");
		}
		Thread.sleep(3000);
		driver.quit();
	}
}
