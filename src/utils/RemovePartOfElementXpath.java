
/**
 * Reference:: https://www.geeksforgeeks.org/split-string-java-examples/
 */
package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RemovePartOfElementXpath {

	public static String RemovePartOfXpath(WebDriver driver, WebElement Element, String RemoveString, int SellableNumber) {

		String TdXpath = utils.AbsoluteXPathOfElement.getAbsoluteXPath(driver, Element);

//		System.out.println("The entered Xpath is: " + TdXpath);//ForTester
		String[] SplitTdArr = TdXpath.split(RemoveString, SellableNumber);
		for (String a : SplitTdArr)
			// System.out.println("After split"+a+"\n----------------");//ForTester

			// After modification TdXpath Concatenate part1+Part2
			TdXpath = SplitTdArr[0] + SplitTdArr[1];
//		System.out.println("The New Xpath is: " + TdXpath);//ForTester

		return TdXpath;
	}

	
	public static String ReplacePartOfXpath(WebDriver driver, WebElement Element, String RemoveText, String ReplacementText, int SellableNumber) {

		String TdXpath = utils.AbsoluteXPathOfElement.getAbsoluteXPath(driver, Element);

//		System.out.println("The entered Xpath is: " + TdXpath);//ForTester
		String[] SplitTdArr = TdXpath.split(RemoveText, SellableNumber);
		for (String a : SplitTdArr)
			// System.out.println("After split
			// "+a+"\n----------------");//ForTesterEye

			// After modification TdXpath Concatenate part1+Part2
			TdXpath = SplitTdArr[0] +ReplacementText+ SplitTdArr[1];
//		System.out.println("The New Xpath is: " + TdXpath);//ForTester

		return TdXpath;
	}
}