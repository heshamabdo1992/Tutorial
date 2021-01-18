package FW_Modular_actions;

//::Reference:: http://toolsqa.com/selenium-webdriver/modular-driven/
//Note: all example applied for (https://www.google.com/gmail)

import org.openqa.selenium.WebDriver;

import FW_PageObjects.Home_Page;

import FW_PageObjects.LogIn_Page;

import FW_Utilities.ExcelUtils_________NeedErrorCheck;
 
    // Now this method does not need any arguments
 
    public class SignIn_Action_DDT_________NeedErrorCheck {
 
		public static void Execute(WebDriver driver) throws Exception{
 
			//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
 
			String sUserName = ExcelUtils_________NeedErrorCheck.getCellData(1, 1);
 
			String sPassword = ExcelUtils_________NeedErrorCheck.getCellData(1, 2);
 
			Home_Page.lnk_MyAccount(driver).click();
 
			LogIn_Page.txtbx_UserName(driver).sendKeys(sUserName);
 
			LogIn_Page.txtbx_Password(driver).sendKeys(sPassword);
 
			LogIn_Page.btn_LogIn(driver).click();
        }
}
    
 /*
 DDT Guide Note:
================
  *1- Page class (Home_Page) define page element per methods.
  *2- Action class (SignIn_Action_DDT) defined action Read data from data file like excel using (ExcelUtils). <<<< As current Script <<<<
  *3- Test Case (Apache_POI_TC) call action class.execute Only.
  */