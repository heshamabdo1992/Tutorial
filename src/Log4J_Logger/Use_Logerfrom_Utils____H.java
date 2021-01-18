package Log4J_Logger;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Use_Logerfrom_Utils____H {

//	final  static Logger log = Logger.getLogger(Use_Logerfrom_Utils.class);
//	
//	
//	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
//		Logger log = Logger.getLogger(Log4J_Logger.Use_Logerfrom_Utils.class);
		
		try {
			driver.get("http://192.168.5.179");
			driver.findElement(By.id("txt_UserName1"));
			}catch (Exception ex) {
			utils.LogInFile	xxx = new utils.LogInFile(Log4J_Logger.Use_Logerfrom_Utils____H.class);

//			String Message=Thread.currentThread().getStackTrace()[1].getClassName();
//	        String FileName=Thread.currentThread().getStackTrace()[1].getFileName();
//	        String MethodName=Thread.currentThread().getStackTrace()[1].getMethodName();
////	        int LineNumber=Thread.currentThread().getStackTrace()[1].getLineNumber(); 
////	        String MessageDetails= FileName+" : "+MethodName+" : "+" : "+Message;
//	        String MessageDetails= Message +" : "+MethodName;
			
//			log.debug(ex.toString(),ex);
//			xxx.WriteLog(MessageDetails+" Line:"+Thread.currentThread().getStackTrace()[1].getLineNumber()+"\n"+ex);
//	        xxx.WriteLog("Sorry we have an error ..!!");
			xxx.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"\n",ex);
			
			
			xxx.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+": Success Message sample 'The process done successfully'");


		}
	}
	


}