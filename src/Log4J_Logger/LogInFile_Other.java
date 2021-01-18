//Reference: https://chercher.tech/java/log4j-java-selenium-webdriver
/** for accurate log data: it is preferred to add logger direct in TC Script */

package Log4J_Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogInFile_Other {
	
	static Logger logger = Logger.getLogger(LogInFile_Other.class);
	
	public static void main(String[] args) {
		//PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure(".\\ReadFrom\\log4j.properties");
        
        
        //log the message to file
        //=======================
        // TRACE - 5000 : This log4j level gives more detailed information than the DEBUG level and sits top of the hierarchy after ALL.
        logger.trace("This is a trace!");
        
        // DEBUG - 10000 : To debug the application, developers give the priority to debug. Level of message logged will be focused on providing support to an application developer
        logger.debug( "This is a debug!");

        
        // ERROR - 40000 : The ERROR level designates error events that might still allow the application to continue running, means a particular part is failing but not a showstopper.        
        logger.error("This is an Error!");

        // INFO - 20000 : Provides informational messages that highlight the progress of the application execution.
        logger.info("This is an info!");

        // FATAL - 50000 : The FATAL level designates very severe error events that will presumably lead the application to abort, means it is a showstopper.        
        logger.fatal("This is an Fatal!");

        // ALL -Integer.MIN_VAL : The ALL has the lowest possible rank and lowest int values, it is intended to turn on all logging.
        //log.all("This is an info message");
        
        // OFF - Integer.MAX_VAL : Does not capture any log and it's int value is Maximum value an integer can hold.        
//        logger.error("This is an info message");
        

	}
}