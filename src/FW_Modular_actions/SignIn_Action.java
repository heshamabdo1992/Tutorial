package FW_Modular_actions;

//::Reference:: http://toolsqa.com/selenium-webdriver/modular-driven/
//Note: all example applied for (https://www.google.com/gmail)

import org.openqa.selenium.WebDriver;

import FW_PageObjects.Home_Page;

import FW_PageObjects.LogIn_Page;

public class SignIn_Action {

	public static void Execute(WebDriver driver) {

		Home_Page.lnk_MyAccount(driver).click();

		LogIn_Page.txtbx_UserName(driver).sendKeys("ahmed.ocp1@gmail.com");

		LogIn_Page.btn_Next(driver).click();

		LogIn_Page.txtbx_Password(driver).sendKeys("whatisyourname_1");

		LogIn_Page.btn_LogIn(driver).click();
	}
}

/*
Modularity Guide Note:
=======================
  *1- Page class (Home_Page) define page element per methods.
  *2- Action class (SignIn_Action) define action steps regardless to used pages (almost 1 action class use more that 1 page).<<<< As current Script <<<<
  *3- Test Case (POM_TC) call action class.
 * */
