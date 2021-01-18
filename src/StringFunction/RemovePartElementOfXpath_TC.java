package StringFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemovePartElementOfXpath_TC {

	static WebDriver driver= new ChromeDriver();
	
	public static void main(String arg[]){

		driver.get("https://www.geeksforgeeks.org/split-string-java-examples/");		
		driver.findElement(By.xpath("//*[@id='main']/div[1]/div/ul/li[3]/a")); 
		WebElement elementExample=driver.findElement(By.xpath("//*[@id='main']/div[1]/div/ul/li[3]/a")); 
				
		 String NewXparth=utils.RemovePartOfElementXpath.RemovePartOfXpath(driver, elementExample, "div\\[2\\]", 2);
		 
		 System.out.println("-------Replacement-------");
		 String ReplacenetText=utils.RemovePartOfElementXpath.ReplacePartOfXpath(driver, elementExample, "div\\[2\\]", "TestText", 2);
		 
		 driver.quit();
	}
	
}
