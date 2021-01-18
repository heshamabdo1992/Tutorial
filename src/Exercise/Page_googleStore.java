package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_googleStore {
	WebDriver driver;

	public Page_googleStore(WebDriver driver) {
		this.driver = driver;
	}
	
	By Button_signIn_Loca = By.xpath("//*[@id='gb_70']");
	By entertainment_Loca = By.xpath("//*[@id='wrapper']//div/ul/li[1]//span[2]");
	By Menu_App_Loca = By.xpath("//*[@id='wrapper']//li[2]//span[2]");

//	By Menu_Games_Loca = By.xpath("//*[@id='fcxH9b']/div[1]/c-wiz[1]//li[1]//li[4]/a");
	By Menu_Games_Loca = By.xpath("//*[contains (@class,'wrapper')]/div[1]//li[1]//li[4]/a");
	
	public void Assert_CurrentPage (WebDriver driver){
	utils.assertion.assert_CurrentPage_URL(driver, "https://play.google.com/store");
	System.out.println("currently we open 'Google Store' Page");
	}
	
	public void Click_Sign_In (){
		driver.findElement(Button_signIn_Loca).click();
	}
	
	public void wait_pageload_AferSignIn(){
 		utils.Wait.visibiabilityOfElement(driver, entertainment_Loca);
 		System.out.println("Assert 'entertainment' is done");
	}
	
	public void Click_App(){
		driver.findElement(Menu_App_Loca).click();
	
	}
	
	public void Wait_GameMenuLoad(){
		utils.Wait.visibiabilityOfElement(driver, Menu_Games_Loca);
		System.out.println("Assert 'Game Menu' is done");
	}
	public void Click_Games(){
		driver.findElement(Menu_Games_Loca).click();
		
	}
}
