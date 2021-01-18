package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickItem_inJS {

	public static void ClickOn(WebDriver driver, WebElement WebElement){
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", WebElement);
		
	}
}
