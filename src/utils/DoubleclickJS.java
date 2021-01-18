package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DoubleclickJS {

	public static void DoubleClickJC(WebDriver driver, WebElement element){
		((JavascriptExecutor) driver).executeScript(
		
				  "var evt = document.createEvent('MouseEvents');" +
				  "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" +
				  "arguments[0].dispatchEvent(evt);", element);
				  
	}
}
