package DownloadFileandvalidate;
//Reference:: https://www.swtestacademy.com/download-file-in-selenium/

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DownloadAndValidate {

	public static void  main (String [] arg) throws InterruptedException{
		
		//Step 1: Create WebDriver and Add Options
		//=========================================
		String downloadFilepath = "C:\\Users\\A.Tokhi\\Downloads";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty(downloadFilepath));
		 
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		
		//Step 2: Download the file
		//==========================
		driver.navigate().to("http://xcal1.vodafone.co.uk/");
		 
		//We find the download links
		WebElement Element =driver.findElement(By.xpath("/html/body/table/tbody/tr[16]/td[1]/a/img"));
		 
		//Click the last one to download 5MB file :)
//		WebElement el = list.get(list.size()-1);
		Element.click();
		Thread.sleep(15000);
		 
		
		//Step 3: Check The File in Folder
		//==================================
		File folder = new File(downloadFilepath);
		 
		//List the files on that folder
		File[] listOfFiles = folder.listFiles();
		boolean found = false;
		File f = null;
		     //Look for the file in the files
		     // You should write smart REGEX according to the filename
		     for (File listOfFile : listOfFiles) {
		         if (listOfFile.isFile()) {
		              String fileName = listOfFile.getName();
		               System.out.println("File " + listOfFile.getName());
		               if (fileName.matches("5MB.zip")) {
		                   f = new File(fileName);
		                   found = true;
		                }
		            }
		        }
//		Assert.assertTrue(found, "Downloaded document is not found");
		assertTrue(found);
		System.out.println("The file is 'downloaded' successfully.");
		f.deleteOnExit();
		System.out.println("The downloaded file 'deleted' successfully.");
		driver.quit();
	}
}
