package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollTo_InJS {

// ::Note:: we have to check action in webpage console (Ctrl+Shift+j) if action not valid search for valid JavaScript and inject it as following
// https://www.seleniumhq.org/docs/03_webdriver.jsp#using-javascript
	
	public static void ScrollToElement(WebDriver driver, WebElement element) {
/* ::Implementation Note:: 
 * When scroll to button not go to correct position But when scroll to image go to correct position.*/
		
//		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);     
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		// OR
		// javascriptExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",elme);
	}

	public static void ScrollToPosition (WebDriver driver,int x, int y){

		 ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, 500);"); //valid

	}
	
	public static void ScrollByPixels (WebDriver driver,int x, int y){
		
		// Scroll 100Pixels to the right	
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		javascriptExecutor.executeScript("window.scrollBy(0, 500)");	
		
		//OR
//		((JavascriptExecutor)driver).executeScript("window.scrollBy(x, y)"); 
		//##### valid but when reuse it in other method it git error (Unknowen error: unknown error: x is not defined)#######
		
		 /*Definition and Usage
		  * The scrollBy() method scrolls the document by the specified number of pixels.
		  * Note: For this method to work, the visible property of the window's scrollbar must be set to true!*/
	}
	public static void ScrollToEnd_In_dynamic_loading (WebDriver driver){
		try {
		    long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

		    while (true) {
		        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		        Thread.sleep(2000);

		        long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
		        if (newHeight == lastHeight) {
		            break;
		        }
		        lastHeight = newHeight;
		    }
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}

}
