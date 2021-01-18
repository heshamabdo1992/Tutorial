package A8_DataProvider_BasedOnClassName____Sally;
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

//  https://www.toolsqa.com/selenium-webdriver/testng-data-provider-excel/
public class testcase1{

	private String sTestCaseName1;
	private String sTestCaseName2;
	private int iTestCaseRow;
	static String FilePath=".\\ReadFrom\\TestDataUsers.xlsx";
	static String SheetName="Sheet1";
	
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
  public void mmmm(String sUserName, String sPassword) throws InterruptedException {
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
	 	ExcelUtils.setExcelFile(FilePath,SheetName);
	 	sTestCaseName1 = this.toString(); 
	  	// From above method we get long test case name including package and class name etc.
	  	// The below method will refine your test case name, exactly the name use have used
	  	System.out.println(this.toString());
	 	
	 	sTestCaseName2 = ExcelUtils.getTestCaseName(this.toString()); // This means the name of the class (testcase2)
	    // Fetching the Test Case row number from the Test Data Sheet
	    // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
	 	iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName2,0);
	 
	 	Object[][] testObjArray = ExcelUtils.getTableArray(FilePath,SheetName,iTestCaseRow);
	    	return (testObjArray);

		}

}