package Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Supper_Calculator______utils_Wait {
	
	WebDriver driver;
	
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

		// Call "utils" package > "Wait" class > "TextContains" Method in >>>This is called Wrapper method<<<

		utils.Wait.TextContains(driver, By.xpath("//h2[@class='ng-binding']"), z);
		
		}

	// ========= + operator====================
	@Test
	public void PlusOperator() throws Exception {
		Calc("5", "+", "5");
		
		// Call "utils" package > "Wait" class > "TextContains" Method in >>>This is called Wrapper method<<<
		utils.Wait.clickable(driver, By.xpath("//input[1]"));
		
		assertResult("10");				
	}


	@BeforeMethod
	public void Setup(){
		driver= new ChromeDriver();
		driver.get("https://juliemr.github.io/protractor-demo/");
	}
	
	@AfterMethod
	public void TearDown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}
}
