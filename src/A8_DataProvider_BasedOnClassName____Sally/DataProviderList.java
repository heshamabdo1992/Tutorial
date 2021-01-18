package A8_DataProvider_BasedOnClassName____Sally;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderList {	
	WebDriver driver;
	WebDriverWait wait;
	
	@DataProvider(name = "Accounts")
	public Object[][] Users() {
	String[][] Data = { { "sally.sedky@paxerahealth.com", "Test1234" },
						{ "shanounty@hotmail.com", "Test1234" }};
	return Data;
	}

	@BeforeMethod
	public void setup(){
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30, 1000);
		driver.manage().window().maximize();
		driver.get("https://carepassport.net/patients/Login.aspx");
	}

	@Test(dataProvider = "Accounts")//TestCase1 (Normal Login)
	public void login_testcase(String username, String password) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='txt_UserName']")));
		driver.findElement(By.xpath("//*[@id='txt_UserName']")).clear();
		driver.findElement(By.xpath("//*[@id='txt_UserName']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='txt_Password_login']")).clear();
		driver.findElement(By.xpath("//*[@id='txt_Password_login']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='LoginButton']")).click();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
