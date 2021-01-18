//Reference: https://chercher.tech/java/log4j-java-selenium-webdriver
/** for accurate log data: it is preferred to add logger direct in TC Script */	

package Log4J_Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogInHTML {
	
	static Logger log = Logger.getLogger(LogInFile_Other.class);
	
	public static void main(String[] args) {
		
		//PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure("D:.\\ReadFrom\\log4j-html.properties");

        //log the message to file
        log.trace("This is a trace message");
        log.info("This is an info message");
        log.warn("This is an warn message");
        log.error("This is an error message");
        log.fatal("This is an fatal message");
	}
}