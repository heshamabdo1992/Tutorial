package FW_PageObjects;

//::Reference:: http://toolsqa.com/selenium-webdriver/page-object-model/
//Note: all example applied for (https://www.google.com/gmail)

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {

		private static WebElement element = null;

		public static WebElement lnk_MyAccount(WebDriver driver) {

			element = driver.findElement(By.xpath("//nav//a[2]"));

			return element;
		}

		public static WebElement AccountPopup (WebDriver driver){
			element =driver.findElement(By.xpath("//*[@id='gb']/div[1]//div[5]/div[1]//span"));
			return element;
		}
		
		
		public static WebElement lnk_LogOut(WebDriver driver) {

//			element = driver.findElement(By.xpath("//*[@id='gb_71']"));
//
//			return element;
		//OR		
			return driver.findElement(By.xpath("//*[@id='gb_71']"));
		}
	}