package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Page_GameDetails {
	WebDriver driver;
	
	public Page_GameDetails (WebDriver driver) {
		this.driver = driver;
	}
	
//	Locators
	By Icon_AddToWishList_Loca = By.xpath("//*[@id='fcxH9b']//wishlist-add/button/span[2]");
	By Label_GameName_Loca = By.xpath("//*[@id='fcxH9b']//h1/span");
	By Icon_RemoveIt_Loca = By.xpath("//*[@id='fcxH9b']//wishlist-added/button/span[3]");
	
	public void Assert_CurrentPage(WebDriver driver) {
		utils.assertion.assert_CurrentPage_URL(driver, "https://play.google.com/store/apps/details?");
		System.out.println("currently we open 'game Detail' Page");
	}
	
	public void Add_To_Wishlist (){
		String GameName=driver.findElement(Label_GameName_Loca).getText();		
		driver.findElement(Icon_AddToWishList_Loca).click();
	}
	
	public void Assert_GameAdded_ToWishList (){
		String ChooseText1 = driver.findElement(Icon_RemoveIt_Loca).getText();
		Assert.assertTrue(ChooseText1.contains("Remove"));
		System.out.println("The Game added to wishlist");		
		
	}
	
}
