package A8_1DDT_DataProvider;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class A8_3_MTest_MProvider {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		
		System.out.println("@BeforeMethod");
		driver = new ChromeDriver();
		driver.get("https://juliemr.github.io/protractor-demo/");
	}

	@AfterMethod
	public void tearDown() {
		
		System.out.println("@AfterMethod");	
		driver.quit();
	}	
	//@Test
	public void testCalc01() throws InterruptedException {
		calculate("1", "+", "1");
		assertExpected("2");
	}

//	@Test(dataProvider="My new data provider")
//	public void testCalc02(String in1, String op, String in2, String expected) throws InterruptedException {
////		calculate("1", "-", "1");
////		assertExpected("0");
//		System.out.println("in1 "+in1+" operation "+op +" in2 "+in2+" ="+expected);
//	}

	@Test(dataProvider = "My data provider name")
	public void testCalcParametrized(String in1, String op, String in2, String expected) {
		calculate(in1, op, in2);
		assertExpected(expected);
	}

	@DataProvider(name = "My data provider name")
	public Object[][] dataProvider() {
		String[][] data = { 
				{"1", "+","1","2" }, 
				{ "1", "-","1","0" }
				};
		return data;
	}


	
	@Test(dataProvider = "My new data provider2")
	public void testCalcParametrized2(String in1, String op, String in2, String expected) {
		calculate(in1, op, in2);
		assertExpected(expected);
	}
	
	
	@DataProvider(name = "My new data provider2")
	public Object[][] dataProvider2() {
		String[][] data = { 
				{ "1", "*","1","1" },
				{ "1", "*","-1","-1" }
				};
		return data;
	}

	public void assertExpected(String x) {
		WebDriverWait wait = new WebDriverWait(driver, 60, 100);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2[contains(.,'" + x + "')]")));
	}

	public void calculate(String x, String opcode, String y) {
		driver.findElement(By.xpath("//input[@ng-model='first']")).clear();
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys(x);
		driver.findElement(By.xpath("//input[@ng-model='second']")).clear();
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys(y);
		WebElement opElement = driver.findElement(By.xpath("//select"));
		Select op = new Select(opElement);
		op.selectByVisibleText(opcode);

		driver.findElement(By.tagName("button")).click();
	}


}
