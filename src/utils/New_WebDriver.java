package utils;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class New_WebDriver {

	static WebDriver driver = null;
	
	@Parameters("browserName")
	public static WebDriver Driver_Default(@Optional("chrome") String browserName) {
		System.out.println("@BeforeMethod");

		// utils.ReadingPropertiesFile data = new utils.ReadingPropertiesFile("./ReadFrom/RISConfig.properties");
		// // Read (Browser) from property file throw method in [utils] Package and add it in String variable [browser].
		// String browser = data.GetBrowser();

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	@Parameters("browserName")
	public static WebDriver Driver_Path(@Optional("chrome") String browserName,@Optional("./WebDriver/chromedriver.exe") String WebDriver_Path) {
		System.out.println("@BeforeMethod");
		System.out.println("Use chromedriver in project directory using 'System.setProperty'");

		if (browserName.equalsIgnoreCase("Chrome")) {
			// String WebDriver_Path= "./WebDriver/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", WebDriver_Path);

			driver = new ChromeDriver();
		}

		if (browserName.equalsIgnoreCase("firefox")) {
			// String WebDriver_Path= "./WebDriver/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", WebDriver_Path);

			driver = new FirefoxDriver();
		}
		 if (browserName.equalsIgnoreCase("ie")) {
//		 	// String WebDriver_Path= "./WebDriver/iexploredriver.exe";
			 System.setProperty("webdriver.ie.driver",WebDriver_Path);
			 driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		return driver;
		
	}
		 
	@Parameters("browserName")
	public static WebDriver Drover_RemotNode(@Optional("localhost") String IP, @Optional("4444") String Port,@Optional("chrome") String browserName) throws Exception {
		// ****Need search****
		// Run Multi WebDriver from same 'StandAlone Server node'

		System.out.println("Run Script throw Remote Node Connection");

		// 0- search for "selenium standalone url" -> http://localhost:4444/wd/hub
		// 1- Create instance from webDriver to remote host
		// 2- Start StandAlone server using cmd command (java -jar StandAlone.jar directory)as in snapshot.
		// 3- Other machine have to include (Webdriver.exe, StandAlone.jar)
		// 4- run script ......................... all steps as Appium workflow

		// ::Note:: in case of run in other machine replace (localhost with machine IP Like 192.0.0.172)

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new RemoteWebDriver(new URL("http://" + " IP " + ":" + " Port " + "/wd/hub"),DesiredCapabilities.chrome());
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new RemoteWebDriver(new URL("http://" + " IP " + ":" + " Port " + "/wd/hub"),DesiredCapabilities.firefox());
		}
		if (browserName.equalsIgnoreCase("IE")) {
			driver = new RemoteWebDriver(new URL("http://" + " IP " + ":" + " Port " + "/wd/hub"),DesiredCapabilities.internetExplorer());
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void closeAllDriver() {
		driver.close();
		driver.quit();
	}
	
//	::Follow check error with::
//	https://stackoverflow.com/questions/45523264/org-testng-testngexception-cannot-inject-test-annotated-method-with-class-jav
}