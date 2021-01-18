package utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory_ForTest____example____HashMap{


		private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

		/*
		 * Factory method for getting browsers
		 ::Referance:: http://toolsqa.com/selenium-webdriver/factory-design-principle-in-frameworks/
		 
		 HashMap
		 =======
		 https://www.youtube.com/watch?v=rOADM99d_fY
		 https://automationtalks.com/2017/11/03/map-hashmap-testng-dataprovider/
		 */
		public static WebDriver getBrowser(String browserName) {
			WebDriver driver = null;

			switch (browserName) {
			case "Firefox":
				driver = drivers.get("Firefox");
				if (driver == null) {
					driver = new FirefoxDriver();
					drivers.put("Firefox", driver);
				}
				break;
			case "IE":
				driver = drivers.get("IE");
				if (driver == null) {
					System.setProperty("webdriver.ie.driver","C:\\WebDriver\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					drivers.put("IE", driver);
				}
				break;
			case "Chrome":
				driver = drivers.get("Chrome");
				if (driver == null) {
					System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\ChromeDriver.exe");
					driver = new ChromeDriver();
					drivers.put("Chrome", driver);
				}
				break;
			}
			return driver;
		}
		public static void closeAllDriver() {
			for (String key : drivers.keySet()) {
				drivers.get(key).close();
				drivers.get(key).quit();
			}
		}
	}
