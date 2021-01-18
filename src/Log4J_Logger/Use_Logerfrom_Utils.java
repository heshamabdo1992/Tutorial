package Log4J_Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Use_Logerfrom_Utils {

//	private static Logger LOG = Logger.getLogger(Use_Logerfrom_Utils.class);
//	
//	
//	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		
		try {
			driver.get("http://192.168.5.183/");
			driver.findElement(By.id("txt_UserName1"));
			}catch (Exception ex) {
			utils.LogInFile	xxx = new utils.LogInFile(Log4J_Logger.Use_Logerfrom_Utils.class);
			
			String Message=ex.getStackTrace()[0].getClassName();
	        String FileName=ex.getStackTrace()[0].getFileName();
	        String MethodName=ex.getStackTrace()[0].getMethodName();
	        String LineNumber=Integer.toString(ex.getStackTrace()[0].getLineNumber());
	        
	        String MessageDetails= FileName+" : "+MethodName+" : "+ LineNumber+" : "+Message;
			xxx.WriteLog(MessageDetails);
			

			System.out.println("Check exeption in Log file");

		}
	}
}