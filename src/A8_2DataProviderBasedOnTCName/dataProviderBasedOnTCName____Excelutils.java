package A8_2DataProviderBasedOnTCName;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderBasedOnTCName____Excelutils {

	public static WebDriver driver;
	private static ArrayList<Integer> iTestCaseRow;
	static String FilePath = ".\\ReadFrom\\user_login.xlsx";
	static String SheetName = "Sheet1";

	@BeforeMethod
	public void setup() {
		System.out.println("@BeforeMethod");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@DataProvider(name = "login")
	public static Object[][] credentials(Method m) throws Exception {

		// Setting up the Test Data Excel file
		ExcelUtils.setExcelFile(FilePath, SheetName);

		if(m.getName().equalsIgnoreCase("data_provider_ToPXadmin")){
		// Fetching the Test Case row number from the Test Data Sheet Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
		iTestCaseRow = ExcelUtils.getRowContains("pxadmin", 0);
	}else if (m.getName().equalsIgnoreCase("data_provider_ToUltima")){
		iTestCaseRow = ExcelUtils.getRowContains("ultima", 0);
	}
		Object[][] testObjArray = ExcelUtils.getTableArray(FilePath, SheetName,1, iTestCaseRow);

		return (testObjArray);
	}

	@Test(dataProvider = "login")
	public static void data_provider_ToPXadmin(String sUsername, String sPassword, String rownumber) throws Exception {
		System.out.println("@test:data_provider_ToPXadmin");
		System.out.println("The User Name is: " + sUsername + "\nThe password is : " + sPassword+ "\nThe rowNumber is: " + rownumber);

		driver.get("https://paxerahealth.us/pxadmin");
		WebElement username_field = driver.findElement(By.xpath("//*[@id=\"txt_UserName\"]"));
		WebElement password_field = driver.findElement(By.xpath("//*[@id=\"txt_Password\"]"));
		WebElement login_btn = driver.findElement(By.xpath("//*[@id=\"btn_Login\"]"));
		username_field.clear();
		password_field.clear();
		username_field.sendKeys(sUsername);
		password_field.sendKeys(sPassword);
		login_btn.click();
		// Thread.sleep(2000);

		try {
			WebElement profile = driver.findElement(By.xpath("//*[@id=\"lbl_admin_FullName\"]"));
			System.out.println(profile.getText());
			int rowN = Integer.parseInt(rownumber);
			write_excel(rowN, "Passed");
		} catch (Exception e) {
			WebElement message = driver.findElement(By.xpath("//*[@id=\"lbl_Error\"]/div/span"));
			Assert.assertTrue(message.getText().contains("Invalid user name or password"));
			;
			int rowN = Integer.parseInt(rownumber);
			write_excel(rowN, "Failed");
		}
	}


	@Test(dataProvider = "login")
	public static void data_provider_ToUltima(String sUsername, String sPassword, String rownumber) throws Exception {
		System.out.println("@test:data_provider_ToUltima");
		System.out.println("The User Name is: " + sUsername + "\nThe password is : " + sPassword+ "\nThe rowNumber is: " + rownumber);

		driver.get("https://paxerahealth.us");
		WebElement username_field = driver.findElement(By.xpath("//*[@id=\"txt_UserName\"]"));
		WebElement password_field = driver.findElement(By.xpath("//*[@id=\"txt_Password\"]"));
		WebElement login_btn = driver.findElement(By.xpath("//*[@id=\"btn_Login\"]"));
		username_field.clear();
		password_field.clear();
		username_field.sendKeys(sUsername);
		password_field.sendKeys(sPassword);
		login_btn.click();
		// Thread.sleep(2000);

		try {
			WebElement profile = driver.findElement(By.xpath("//*[@id=\"lbl_admin_FullName\"]"));
			System.out.println(profile.getText());
			int rowN = Integer.parseInt(rownumber);
			write_excel(rowN, "Passed");
		} catch (Exception e) {
			WebElement message = driver.findElement(By.xpath("//*[@id=\"lbl_Error\"]/div/span"));
			Assert.assertTrue(message.getText().contains("Invalid user name or password"));
			;
			int rowN = Integer.parseInt(rownumber);
			write_excel(rowN, "Failed");
		}
	}
	
	public static void write_excel(int rownum, String Result) throws Exception {

		write_excel_specificCell eat = new write_excel_specificCell(FilePath);
		eat.setCellData(SheetName, 3, rownum, Result);
	}

	@AfterMethod
	public static void TearDown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}
}
