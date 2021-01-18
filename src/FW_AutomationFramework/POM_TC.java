package FW_AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// Import package pageObject.*

import FW_PageObjects.Home_Page;

import FW_PageObjects.LogIn_Page;

import FW_PageObjects.EmailInbox_Page;

public class POM_TC {

	private static WebDriver driver = null;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.com/gmail/about/");

		// Use page Object library now

		Home_Page.lnk_MyAccount(driver).click();

		LogIn_Page.txtbx_UserName(driver).sendKeys("ahmed.ocp1@gmail.com");
		
		LogIn_Page.btn_Next(driver).click();

		LogIn_Page.txtbx_Password(driver).sendKeys("whatisyourname_1");

		LogIn_Page.btn_LogIn(driver).click();

		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

		EmailInbox_Page.AccountPopup(driver).click();
		EmailInbox_Page.lnk_LogOut(driver).click();

		driver.quit();

	}
}
/* Page Object Model ‰„Ê–Ã ﬂ«∆‰ «·’›Õ…
 * ************************************
 * Creating Selenium test cases can result in an unmaintainable project. 
 * One of the reasons is that too many duplicated code is used. 
 * Duplicated code could be caused by duplicated functionality and this will result in duplicated usage of locators. 
 * The disadvantage of duplicated code is that the project is less maintainable.
 * If some locator will change, you have to walk through the whole test code to adjust locators where necessary.
 * 
 * So
 * 
 * By using the page object model we can make non-brittle test code and reduce or eliminate duplicate test code. 
 * Beside of that it improves the readability and allows us to create interactive documentation. Last but not least, 
 * we can create tests with less keystroke. 
 * An implementation of the page object model can be achieved by separating the abstraction of the test object and the test scripts.

//::Reference:: http://toolsqa.com/selenium-webdriver/page-object-model/
//Note: all example applied for (https://www.google.com/gmail)

POM Guide Note:
================
  *1- Page class (Home_Page) define page element per methods.
  *2- Test Case (POM_TC) define action steps regardless to used pages (almost 1 TC use more that 1 page).<<<< As current Script <<<<
  *************************************************************************************
  *Course sample: Define better sample -Page contain (locators and Business "Actions")-
  *************************************************************************************
*/