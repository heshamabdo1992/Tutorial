package utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class assertion {

	public static void assert_CurrentPage_URL(WebDriver driver, String URL) {

		String currentPage = driver.getCurrentUrl();
		Assert.assertTrue(currentPage.contains(URL));
	}
}
