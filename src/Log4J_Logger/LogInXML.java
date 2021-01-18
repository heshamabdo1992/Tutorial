//Reference: https://chercher.tech/java/log4j-java-selenium-webdriver
/** for accurate log data: it is preferred to add logger direct in TC Script */

package Log4J_Logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LogInXML
{
	static Logger log = Logger.getLogger(LogInXML.class);

	public static void main(String[] args)
	{
		BasicConfigurator.configure();
		
		//DOMConfigurator is used to configure logger from xml configuration file
		DOMConfigurator.configure(".\\ReadFrom\\log4j.xml");

		//Log to file
		log.fatal("Log4j XML configuration is successful !!");
	}
}

