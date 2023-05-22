package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log 
{
	private static Logger logger = LogManager.getLogger();

	//
	public static void startTestCase()
	{
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-S T A R T-"+"             XXXXXXXXXXXXXXXXXXXXXX");
	}

	//This is to print log for the ending of the test case
	public static void endTestCase()
	{
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
	}
	
	public static void info(String message)
	{
		logger.info(message);
	}
	
	public static void warn(String message)
	{
		logger.warn(message);
	}
	
	public static void error(String message)
	{
		logger.error(message);
	}
	
	public static void fatal(String message)
	{
		logger.fatal(message);
	}
	
	public static void debug(String message)
	{
		logger.debug(message);
	}
}
