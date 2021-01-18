package Exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Install_and_Review_goolgeApp_POM {
	
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

		Page_googleStore GStore_P = new Page_googleStore(driver);
		Page_SignIn Sign_P= new Page_SignIn(driver);
		Page_Games Games_P= new Page_Games(driver);
		Page_GameDetails GDetails_P= new Page_GameDetails(driver);
		
		
		GStore_P.Assert_CurrentPage(driver);
		GStore_P.Click_Sign_In();
		
		Sign_P.Assert_CurrentPage(driver);
		Sign_P.Sign_In("ahmed.ocp1@gmail.com", "whatisyourname_1");
		
		GStore_P.wait_pageload_AferSignIn();
		
		GStore_P.Click_App();
		
		GStore_P.Wait_GameMenuLoad();
		GStore_P.Click_Games();
		
		Games_P.Assert_CurrentPage(driver);
	
		>>>>need check<<<<
		Games_P.click_On_1stGame();
		
		GDetails_P.Assert_CurrentPage(driver);
		
		GDetails_P.Add_To_Wishlist();
		GDetails_P.Assert_GameAdded_ToWishList();
		
		GStore_P.Click_Games();
		
		//Scroll to end of page
		utils.Scroll.ScrollToEnd_In_dynamic_loading(driver);
		Thread.sleep(2000);
		
		Games_P.click_on_LastGame();
		
		GDetails_P.Assert_CurrentPage(driver);
		GDetails_P.Add_To_Wishlist();
		GDetails_P.Assert_GameAdded_ToWishList();
		
	}


	@AfterMethod
	public void Teardown() {
		System.out.println(":@AfterMethod");
		driver.quit();
	}

}
