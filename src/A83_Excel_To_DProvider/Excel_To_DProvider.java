package A83_Excel_To_DProvider;
/*
Step 1: First create a method to read excel data and return string array.
Step 2: Create before class and after class methods which helps in getting the browser and closing them when done.
Step 3: Create a data provider which actually gets the values by reading the excel.
Step 4: Create a Test which takes two parameters username and password.
Step 5: Add data provider name for @Test method to receive data from dataprovider.
*/

//Referance: https://testily.wordpress.com/2014/05/19/reading-spreadsheet-contents-into-2d-array-using-apache-poi/
import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

public class Excel_To_DProvider {

	static WebDriver driver; 

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		System.out.println("@BeforeMethod");
		driver = new ChromeDriver();
		driver.get("https://juliemr.github.io/protractor-demo/"); 

	}

	@AfterMethod(alwaysRun = true)
	public void TearDown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}

	public void Calc(String x, String Opcode, String y) {
		driver.findElement(By.xpath("//input[1]")).clear();
		driver.findElement(By.xpath("//input[1]")).sendKeys(x);

		driver.findElement(By.xpath("//input[2]")).clear();
		driver.findElement(By.xpath("//input[2]")).sendKeys(y);

		Select operator = new Select(driver.findElement(By.xpath("//select")));
		operator.selectByVisibleText(Opcode);

		driver.findElement(By.id("gobutton")).click();

	}

	public void assertResult(String z) {
		WebDriverWait wait = new WebDriverWait(driver, 60, 250);
		
		// >>>>> Need check <<<< because assert take long time in this method ======================
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@class='ng-binding']"), z));
		// OR
		// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[contains(.,'" +z+ "')]")));

	}
	@DataProvider(name = "CalaCSVData")
	public Object[][] dataProvider() throws IOException {
		// Access spreadsheet
		System.out.println("==========================================\nAccessing spreadsheet and setting up Array\n===========================================");
		File myFile = new File("./ReadFrom/CalcInput.xls");
		FileInputStream myStream = new FileInputStream(myFile);
		HSSFWorkbook myWorkbook = new HSSFWorkbook(myStream);
		HSSFSheet mySheet = myWorkbook.getSheetAt(0);

		int numRows = mySheet.getLastRowNum() + 1;
		int numCols = mySheet.getRow(0).getLastCellNum();

		String[][] excelData = new String[numRows][numCols];

		System.out.println("=================\nPopulating Array\n=================");
		for (int i = 0; i < numRows; i++) {
			HSSFRow row = mySheet.getRow(i);

			System.err.println("Next Row value");
			for (int j = 0; j < numCols; j++) {
				HSSFCell cell = row.getCell(j);
				
//				String value = cell.getStringCellValue();
			//OR	
				String value = String.valueOf(cell);
				excelData[i][j] = value;
				
				System.out.println("The value is: "+value);
			}
		}
		return excelData;
		
//		//Print for test only
//		System.out.println("=========================\nArray population complete\n=========================");
//		//Loop for print
//		// 1- loop in 2D array [MyData] Rows. 
//		for (int i = 0; i < excelData.length; i++) {
//			String[] inner = excelData[i];
//
//			// 1- loop in 2D array [MyData] columns.
//			for (int j = 0; j < inner.length; j++) {
//				if (j == inner.length - 1)
//					System.out.print(excelData[i][j]);
//				else
//					System.out.print(excelData[i][j] + ",");
//			}
//			System.out.println();
//		}	
	}
	// ==== Fill data using TestNG (DataProvider)============
	@Test(dataProvider = "CalaCSVData")
	public void TestCalcParamitarized(String in1, String Op, String in2, String Expec) {
		Calc(in1, Op, in2);
		assertResult(Expec);

	}
}