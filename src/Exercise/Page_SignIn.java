package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_SignIn {
	WebDriver driver;

	public Page_SignIn (WebDriver driver) {
		this.driver = driver;
	}
//	Locators
	By Text_Account_Loca = By.xpath("//*[@id='identifierId']");
	By Button_AccountNext_loca = By.xpath("//*[@id='identifierNext']//span");
	By Password_Loca = By.xpath("//*[@id='password']//input");
	By Text_Password_Loca = By.xpath("//*[@id='password']//input");
	By Button_PassNext_Loca = By.xpath("//*[@id='passwordNext']//span");

		
		
	public void Assert_CurrentPage (WebDriver driver){
	utils.assertion.assert_CurrentPage_URL(driver, "https://accounts.google.com/signin");
	System.out.println("currently we open 'Sign In' Page");
	
	}
	
	public void Sign_In(String email, String password){
		
 		/**The following section with be removed after user browser profile*/
 		//EnterUser
		driver.findElement(Text_Account_Loca).clear();
		driver.findElement(Text_Account_Loca).sendKeys(email);
		driver.findElement(Button_AccountNext_loca).click();
 		
 		//Wait page load & assert
 		utils.Wait.visibiabilityOfElement(driver, Password_Loca);
 		
 		//Enter Password
 		driver.findElement(Text_Password_Loca).clear();
 		driver.findElement(Text_Password_Loca).sendKeys(password);
		driver.findElement(Button_PassNext_Loca).click();
	}
		public void Sign_In_withExistAccount(){
// 		//Assert for saved Credential Case1(have not saved account)
// 		String ChooseText=driver.findElement(By.xpath("//*[@id='headingText']/content")).getText();
// 		Assert.assertEquals("Sign In", ChooseText,"There is not saved crediential");
// 		
		
		/** assert for saved 1 account*/
//		String ChooseText = driver.findElement(By.xpath("//*[@id='headingText']/content")).getText();
//		Assert.assertTrue(ChooseText.contains("Hi Ahmed"));

		 /**assert /for saved >1 account*/
// 		Assert.assertEquals("Choose an account", ChooseText,"There is not saved credential");
	}
}
