package FW_AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import FW_PageObjects.*;

import FW_Utilities.Constant;

// Import Package utility.*

import FW_Utilities.ExcelUtils_________NeedErrorCheck;

import FW_Modular_actions.SignIn_Action_DDT_________NeedErrorCheck;

public class Apache_POI_TC_________NeedErrorCheck {

	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		// This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method

		ExcelUtils_________NeedErrorCheck.setExcelFile(Constant.Path_TestData + "\\"+Constant.File_TestData, "TestData");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(Constant.URL);

		SignIn_Action_DDT_________NeedErrorCheck.Execute(driver);

		System.out.println("Login Successfully, now it is the time to Log Off buddy.");

		Home_Page.lnk_LogOut(driver).click();

		driver.quit();

		// This is to send the PASS value to the Excel sheet in the result column.

		ExcelUtils_________NeedErrorCheck.setCellData("Pass", 1, 3);
	}
}
/* Reading data from the Excel
 * ****************************
 * We need a way to open this Excel sheet and read data from it within our Selenium test script. For this purpose, 
 * I use the Apache POI library, which allows you to read, create and edit Microsoft Office-documents using Java. 
 * The classes and methods we are going to use to read data from Excel sheet are located in the org.apache.poi.hssf.usermodel package.

 ::Reference:: http://toolsqa.com/selenium-webdriver/data-driven-testing-excel-poi/
 Note: all example applied for (https://www.google.com/gmail)

 DDT Guide Note:
================
  *1- Page class (Home_Page) define page element per methods.
  *2- Action class (SignIn_Action_DDT) defined action Read data from data file like excel using (ExcelUtils). 
  *3- Test Case (Apache_POI_TC) call action class.execute Only. <<<< As current Script <<<<
  */

NeedErrorCheck 
/*  
 * 1- Read From EXCEL
   *******************
http://toolsqa.com/selenium-tutorial/

http://toolsqa.com/selenium-webdriver/data-driven-testing-excel-poi/


http://automationtesting.in/read-data-from-excel-using-column-name/	

Consol Error: 
Exception in thread "main" java.lang.NoSuchMethodError: org.apache.poi.util.POILogger.log(ILjava/lang/Object;Ljava/lang/Throwable;)V

After resolve ISsue ISA
Check (A83_Excel_To_DProvider) execution in path:
D:\Eclips_Source\Eclipse_Mars2_WorkSpace\Tutorial\src\A83_Excel_To_DProvider*/
