package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Install_and_Review_goolgeStoreApp2 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		System.out.println(":@BeforeMethod");
		
//		ChromeOptions options = new ChromeOptions();	
//		options.addArguments("user-data-dir=C:\\Users\\Ahmed\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1"); 		
//		options.addArguments("disable-infobars");
//		options.addArguments("--start-maximized");
//		driver = new ChromeDriver(options);
		
		driver= new ChromeDriver();
	}

	 
	@Test
	public void Install_TC() throws InterruptedException {
		System.out.println(":@Test");		
		
		driver.get("https://play.google.com/");

		// click SignIn
		driver.findElement(By.xpath("//*[@id='gb_70']")).click();

		/**Assert current page*/
		assert_CurrentPage_URL(driver, "https://accounts.google.com/signin");
		
	
// 		//Assert for saved Credential Case1(have not saved account)
// 		String ChooseText=driver.findElement(By.xpath("//*[@id='headingText']/content")).getText();
// 		Assert.assertEquals("Sign In", ChooseText,"There is not saved crediential");
//
 		/**The following section with be removed after user browser profile*/
 		//EnterUser
 		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("ahmed.ocp1@gmail.com");
 		driver.findElement(By.xpath("//*[@id='identifierNext']//span")).click();
 		
 		//Wait page load & assert
 		By Password_Loca = By.xpath("//*[@id='password']//input");
 		utils.Wait.visibiabilityOfElement(driver, Password_Loca);
 		
 		
 		//Enter Password
 		driver.findElement(By.xpath("//*[@id='password']//input")).sendKeys("whatisyourname_1");
 		driver.findElement(By.xpath("//*[@id='passwordNext']//span")).click();
 		
 		
		
		/** assert for saved 1 account*/
//		String ChooseText = driver.findElement(By.xpath("//*[@id='headingText']/content")).getText();
//		Assert.assertTrue(ChooseText.contains("Hi Ahmed"));

		 /**assert /for saved >1 account*/
// 		Assert.assertEquals("Choose an account", ChooseText,"There is not saved credential");

 		//Wait page load & assert
 		By entertainment_Loca = By.xpath("//*[@id='wrapper']//div/ul/li[1]//span[2]");
 		utils.Wait.visibiabilityOfElement(driver, entertainment_Loca);
 		System.out.println("Assert 'entertainment' is done");
//		//Assert current page
//		assert_CurrentPage_URL(driver, "https://play.google.com/store");

		//Click Apps
		driver.findElement(By.xpath("//*[@id='wrapper']//li[2]//span[2]")).click();
		
		//Wait page load & assert
//		By Games_Loca = By.xpath("//*[@id='fcxH9b']/div[1]/c-wiz[1]//li[1]//li[4]/a");
		By Games_Loca = By.xpath("//*[contains (@class,'wrapper')]/div[1]//li[1]//li[4]/a");
		
		utils.Wait.visibiabilityOfElement(driver, Games_Loca);
		System.out.println("Assert Game page is done");
		
		//Click games
		driver.findElement(Games_Loca).click();
		
		By First_Game_Loca = By.xpath("//*[@id='body-content']//div[1]/div[2]/div[1]//div[2]/div[1]/div/div[2]/a[2]");
		utils.Wait.visibiabilityOfElement(driver, First_Game_Loca);
		
		assert_CurrentPage_URL(driver, "https://play.google.com/store/apps/category/GAME");
		System.out.println("Assert open 'game page' is done");
		
		//click on 1st game 
		driver.findElement(By.xpath("//*[@id='body-content']//div[1]/div[2]/div[1]//div[2]/div[1]/div/div[2]/a[2]")).click();
		
		assert_CurrentPage_URL(driver, "https://play.google.com/store/apps/details?");
		System.out.println("Assert '1st game Detail' is done");
		
		String GameName=driver.findElement(By.xpath("//*[@id='fcxH9b']//h1/span")).getText();
		
		driver.findElement(By.xpath("//*[@id='fcxH9b']//wishlist-add/button/span[2]")).click();

		//Assert for added game to wish-list
		String ChooseText1 = driver.findElement(By.xpath("//*[@id='fcxH9b']//wishlist-added/button/span[3]")).getText();
		Assert.assertTrue(ChooseText1.contains("Remove"));
		System.out.println("The 1st Game added to wishlist");

		//Click games
		driver.findElement(Games_Loca).click();
		
		//Scroll to end of page
		utils.ScrollTo_InJS.ScrollToEnd_In_dynamic_loading(driver);
		Thread.sleep(2000);
		
		//click on Last game to wish-list
		By Lats_Game_loca= By.xpath("//*[@id='body-content']/div[11]//div[1]//div[6]//div[2]/div[6]//div[2]/a[2]");
		utils.Wait.visibiabilityOfElement(driver, Lats_Game_loca);
		driver.findElement(By.xpath("//*[@id='body-content']/div[11]//div[1]//div[6]//div[2]/div[6]//div[2]/a[2]")).click();

		//Assert for added game to wish-list
		ChooseText1 = driver.findElement(By.xpath("//*[@id='fcxH9b']//wishlist-added/button/span[3]")).getText();			   
		Assert.assertTrue(ChooseText1.contains("Remove"));
		System.out.println("The Last Game added to wishlist");
		
	}

	public void assert_CurrentPage_URL(WebDriver driver, String URL) {

		String currentPage = driver.getCurrentUrl();
		Assert.assertTrue(currentPage.contains(URL));
	}

	@AfterMethod
	public void Teardown() {
		System.out.println(":@AfterMethod");
		driver.quit();
	}

}
