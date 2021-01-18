package A8_DataProvider_BasedOnClassName____Sally;
//https://www.toolsqa.com/selenium-webdriver/testng-data-provider-excel/
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import A8_DataProvider_BasedOnClassName____Sally.ExcelUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class testcase2 {

	private String sTestCaseName;
	private int iTestCaseRow;
	WebDriver driver;
	WebDriverWait wait;

  @BeforeMethod
  public void beforeMethod() throws Exception {
	  driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      wait = new WebDriverWait(driver, 30, 1000);
      driver.manage().window().maximize();
      driver.get("https://carepassport.net/patients/Login.aspx");	 
  }	

  @Test(dataProvider = "Authentication")
  public void f(String sUserName, String sPassword) throws InterruptedException {
	  
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='txt_UserName']")));
		driver.findElement(By.xpath("//*[@id='txt_UserName']")).clear();
		driver.findElement(By.xpath("//*[@id='txt_UserName']")).sendKeys(sUserName);
		driver.findElement(By.xpath("//*[@id='txt_Password_login']")).clear();
		driver.findElement(By.xpath("//*[@id='txt_Password_login']")).sendKeys(sPassword);
		driver.findElement(By.xpath("//*[@id='LoginButton']")).click();
		Thread.sleep(3000);

  }

  @AfterMethod
  public void afterMethod() {
	   driver.quit();
  }
  
  @DataProvider
  public Object[][] Authentication() throws Exception{
	    // Setting up the Test Data Excel file
	 	ExcelUtils.setExcelFile("D:\\eclips\\Work_Space\\Tutorial\\src\\DataProvider\\TestDataUsers.xlsx","Sheet1");
	 	sTestCaseName = this.toString(); 
	 	// This means the name of the class (testcase1)
	  	// From above method we get long test case name including package and class name etc.
	  	// The below method will refine your test case name, exactly the name use have used
	  	sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
	    // Fetching the Test Case row number from the Test Data Sheet
	    // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
	 	iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
	    Object[][] testObjArray = ExcelUtils.getTableArray("D:\\eclips\\Work_Space\\Tutorial\\src\\DataProvider\\TestDataUsers.xlsx","Sheet1",iTestCaseRow);
	    	return (testObjArray);
		}

}