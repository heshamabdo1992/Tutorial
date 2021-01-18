package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Games {
	WebDriver driver;
	
	public Page_Games (WebDriver driver) {
		this.driver = driver;
	}
	
	// locators
	By First_Game_Loca = By.xpath("//*[@id='body-content']//div[1]/div[2]/div[1]//div[2]/div[1]/div/div[2]/a[2]/span[.='  ']");
	By Last_Game_loca = By.xpath("//*[@id='body-content']/div[11]//div[1]//div[6]//div[2]/div[6]//div[2]/a[2]");
	
	
	public void Assert_CurrentPage(WebDriver driver) {
		utils.assertion.assert_CurrentPage_URL(driver, "https://play.google.com/store/apps/category/GAME");
		System.out.println("currently we open 'Games' Page");
	}

	public void click_On_1stGame() {
//		utils.Wait.visibiability(driver, First_Game_Loca);
		driver.findElement(First_Game_Loca).click();
	}

	public void click_on_LastGame() {	
		utils.Wait.visibiabilityOfElement(driver, Last_Game_loca);
		driver.findElement(Last_Game_loca).click();

	}

}
