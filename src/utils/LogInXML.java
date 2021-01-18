//Reference: https://chercher.tech/java/log4j-java-selenium-webdriver

package utils;

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
		DOMConfigurator.configure("D:\\eclips\\Work_Space\\Tutorial\\ReadFrom\\log4j2.xml");

		//Log to file
		log.fatal("Log4j XML configuration is successful !!");
	}
}

