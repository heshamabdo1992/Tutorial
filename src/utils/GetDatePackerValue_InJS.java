package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetDatePackerValue_InJS {

	public static String GetDatePackerValue(WebDriver driver, WebElement element){
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String AddingReadingDate = (String) jse.executeScript("return arguments[0].value", element);
		return AddingReadingDate;

	}
}
