package FW_PageObjects;

//::Reference:: http://toolsqa.com/selenium-webdriver/page-object-model/
//Note: all example applied for (https://www.google.com/gmail)

import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class LogIn_Page {

	private static WebElement element = null;

	public static WebElement txtbx_UserName(WebDriver driver) {

		element = driver.findElement(By.id("identifierId"));

		return element;

	}

	public static WebElement btn_Next(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id='identifierNext']"));

		return element;

	}

	public static WebElement txtbx_Password(WebDriver driver) {

		element = driver.findElement(By.name("password"));

		return element;
	}

	public static WebElement btn_LogIn(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id='passwordNext']"));

		return element;

	}
}
