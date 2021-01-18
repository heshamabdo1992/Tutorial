package A1_2_RemoteNode;

// Run Script in remote server

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class A1_RemoteNodeConnection {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.out.println("Run Script throw Remote Node Connection");

		// 0- search for "selenium standalone url" -> http://localhost:4444/wd/hub
		// 1- Create instance from webDriver to remote host
		// 2- Start StandAlone server using cmd command (java -jar + StandAlone.jar directory)as in snapshot.*on Remote PC*
		// 3- Other machine have to include (Webdriver.exe, StandAlone.jar)
		// 4- run script ......................... all steps as Appium workflow

		// ::Note:: in case of run in other machine replace (localhost with machine IP Like 192.0.0.172)

		//Remote on local server
//		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
//		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
		
		//Remote on Another Machine server
		driver = new RemoteWebDriver(new URL("http://192.168.5.183:4444/wd/hub"), DesiredCapabilities.chrome());
//		driver = new RemoteWebDriver(new URL("http://192.168.5.183:4444/wd/hub"), DesiredCapabilities.firefox());
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("ahmed_ocp1@hotmail.com");
		driver.findElement(By.id("pass")).sendKeys("1020304050");
		driver.findElement(By.id("loginbutton")).click();

		// ===== Assert for page load====
		Boolean xpathv = driver
				.findElement(
						By.xpath("//html[@id='facebook']//div[@id='u_0_a']//a[@title='Profile']//span[@class='_1vp5']"))
				.isDisplayed();

		if (xpathv == true) // compare message content
			System.out.println("'A1_RemoteNodeConnection' Test case is pass - user successfully login");
		else {
			System.out.println("Test case is fail - user can not login");
		}
		Thread.sleep(3000);
		driver.quit();
	}
}
