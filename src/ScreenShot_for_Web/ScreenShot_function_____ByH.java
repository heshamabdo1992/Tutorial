package ScreenShot_for_Web;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
//import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import org.apache.commons.io.FileUtils;

public class ScreenShot_function_____ByH {
	public static WebDriver driver;
	static JavascriptExecutor js;

	@BeforeMethod
	public void setup() {
		System.out.println("@BeforeMethod");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public static void ScreenShot_run() throws Exception {
		System.out.println("@test:TestCase1");
		driver.get("http://demo.guru99.com/test/guru99home/");
		// takeSnapShot(driver, "G://testGurr99home.png") ;

		// WebElement
		// Element=driver.findElement(By.xpath("//*[@id='rt-feature']/div/div[1]/div/div/div/div[1]/div[3]/div/div/div/div/div[1]/div/div/h4/a"));
		WebElement Element = driver.findElement(By.xpath("//*[@id='rt-maintop']/div/div[1]/div/div/div/div/div[2]/div/img"));

		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(Element); actions.perform();
		 */
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", Element);

		Thread.sleep(3000);
		
		Screenshot screenshot = new AShot().takeScreenshot(driver, Element);
		ImageIO.write(screenshot.getImage(), "PNG", new File("D:\\div_element.png"));
		
//		takeSnapShotforelement(driver, "D://testGurr99home2.png", Element);
		Thread.sleep(3000);

	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public static void takeSnapShotforelement(WebDriver webdriver, String fileWithPath, WebElement ele)throws Exception {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Used selenium getSize() method to get height and width of element.

		// Used selenium Point class to get x y coordinates of Image element.
		// get location(x y coordinates) of the element.
		// Get the location of element on the page
		Point point = ele.getLocation();

		// Retrieve width of element.
		int ImageWidth = ele.getSize().getWidth();
		// Retrieve height of element.
		int ImageHeight = ele.getSize().getHeight();
		

		// Get width and height of the element
		int xcord = point.getX();
		
		int ycord = point.getY();

		// ------ for printing only --------- 
		System.out.println(xcord + "  " + ycord);
		System.out.println(ImageWidth + "   " + ImageHeight);
		
		int imageW =xcord + ImageWidth;
		int ImgaeH =ycord+ImageHeight;
		System.out.println("The image dimention: \n The width ="  +imageW + "\n The Height ="+ImgaeH );
		//-----------------------------------
		BufferedImage fullimage = null;
		fullimage = ImageIO.read(SrcFile);

		// Crop element from viewable area's screenshot to get element's
		// screenshot
		BufferedImage dest = fullimage.getSubimage(xcord, ycord, ImageWidth, ImageHeight);
		ImageIO.write(dest, "png", SrcFile);
		// Copy the element screenshot to disk
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}

	@AfterMethod
	public static void TearDown() {
		System.out.println("@AfterMethod");
		driver.quit();
	}
}
