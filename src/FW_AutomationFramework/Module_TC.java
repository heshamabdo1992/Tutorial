package FW_AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

// Import package FW_Modular_actions.*

import FW_Modular_actions.SignIn_Action;

import FW_PageObjects.Home_Page;

public class Module_TC {

	private static WebDriver driver = null;

	public static void main(String[] args) {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.com/gmail");

		// Use your Module SignIn now

		SignIn_Action.Execute(driver);

		System.out.println("Login Successfully, now it is the time to Log Off buddy.");

		Home_Page.lnk_LogOut(driver).click();

		driver.quit();

	}

}

/* Modularity  ‰„ÿÌ…
 ********************
 * In most of the web application we have few set of actions which are always executed in the series of actions.
 * Rather than writing those actions again and again in our test, 
 * we can club those actions in to a method and then calling that method in our test script.
 * Modularity avoids duplicacy of code. 
 * In future if there is any change in the series of action, all you have to do is to make changes in your main modular method script. 
 * No test case will be impacted with the change.
 
::Reference:: http://toolsqa.com/selenium-webdriver/modular-driven/
Note: all example applied for (https://www.google.com/gmail)

Modularity Guide Note:
=======================
  *1- Page class (Home_Page) define page element per methods.
  *2- Action class (SignIn_Action) define action steps regardless to used pages (almost 1 action class use more that 1 page).
  *3- Test Case (Module_TC) call action class.<<<< As current Script <<<<
  */
