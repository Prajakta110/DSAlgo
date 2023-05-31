package readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.BrowserType;

public class ConfigFileReader {

	private static Properties properties;
	private final String propertyFilePath = "src/test/resources/configs/Configuration.properties";

	public ConfigFileReader() 
	{
		BufferedReader reader;
		try 
		{
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try 
			{
				properties.load(reader);
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public BrowserType getBrowserType() 
	{
		String browserName = properties.getProperty("browserType");

		if (browserName == null || browserName.equals("chrome"))
			return BrowserType.CHROME;
		
		else if (browserName.equalsIgnoreCase("firefox"))
			return BrowserType.FIREFOX;
		
		else if (browserName.equals("edge"))
			return BrowserType.EDGE;
		
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public long getImplicitWait() 
	{
		String implicitlyWait = properties.getProperty("implicitWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() 
	{
		String url = properties.getProperty("appUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("appUrl not specified in the Configuration.properties file.");
	}

	public String getHomePageUrl() 
	{
		String url = properties.getProperty("homePageUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("homePageUrl not specified in the Configuration.properties file.");
	}
	
	public String getRegisterPageURL() {
		String registerurl = properties.getProperty("registerPageUrl");
		if (registerurl != null)
			return registerurl;
		else
			throw new RuntimeException("registerPageUrl not specified in the Config.properties file");
	}
	
	public String getArrayPageUrl() {
		String url = properties.getProperty("arrayPageUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("arrayPageUrl not specified in the Configuration.properties file.");
	}
	
	public String getTreePageUrl() {
		String url = properties.getProperty("treePageUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("treePageUrl not specified in the Configuration.properties file.");
	}
	
	public String getStackPageUrl() {
		String url = properties.getProperty("stackPageUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("stackPageUrl not specified in the Configuration.properties file.");
	}
	
	public String getLinkedListPageUrl() {
		String url = properties.getProperty("linkedListUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("linkedListUrl not specified in the Configuration.properties file.");
	}

	public String getPracticePageUrl() {
		String url = properties.getProperty("practicePageUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("practicePageUrl not specified in the Configuration.properties file.");
	}

	public String getEditorPageUrl() {
		String url = properties.getProperty("editorPageUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("editorPageUrl not specified in the Configuration.properties file.");
	}
	
	public String getLoginPageURL() {
		String loginurl = properties.getProperty("loginPageUrl");
		if (loginurl != null)
			return loginurl;
		else
			throw new RuntimeException("loginPageUrl not specified in the Config.properties file");
	}


	public String getQuestionPageUrl() {
		String url = properties.getProperty("questionPageUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("questionPageUrl not specified in the Configuration.properties file.");
	}
	
	public String getOperationInStackUrl() 
	{
		String url = properties.getProperty("operationInStackPageUrl");
		if(url != null) 
			return url;
		else 
			throw new RuntimeException("operationInStackPageUrl not specified in the Configuration.properties file.");
	}	
	
	public String getImplimentationUrl() 
	{
		String url = properties.getProperty("implimentationPageUrl");
		if(url != null) 
			return url;
		else 
			throw new RuntimeException("implimentationPageUrl not specified in the Configuration.properties file.");
	}	
	
	public String getStackApplicationUrl() 
	{
		String url = properties.getProperty("stackApplicationPageUrl");
		if(url != null) 
			return url;
		else 
			throw new RuntimeException("stackApplicationPageUrl not specified in the Configuration.properties file.");
	}	

	//readers
	
	public String getExcelPath() {
		String path = properties.getProperty("excelPath");
		if (path != null)
			return path;
		else
			throw new RuntimeException("path not specified in the Configuration.properties file.");
	}

	public String getScreenshotPath() {
		String path = properties.getProperty("screenshotPath");
		if (path != null)
			return path;
		else
			throw new RuntimeException("screenshotPath not specified in the Configuration.properties file.");
	}

	public String getDSAlgoUserName() {
		String username = properties.getProperty("dsAlgoUserName");
		if (username != null)
			return username;
		else
			throw new RuntimeException("dsAlgoUserName not specified in the Configuration.properties file.");
	}

	public String getDSAlgoPassword() {
		String password = properties.getProperty("dsAlgoPassword");
		if (password != null)
			return password;
		else
			throw new RuntimeException("dsAlgoPassword not specified in the Configuration.properties file.");
	}

	public String getValidLoginMsg() {
		String msg = properties.getProperty("validLoginMsg");
		if (msg != null)
			return msg;
		else
			throw new RuntimeException("validLoginMsg not specified in the Configuration.properties file.");
	}

	public String getInvalidLoginMsg() {
		String msg = properties.getProperty("invalidLoginMsg");
		if (msg != null)
			return msg;
		else
			throw new RuntimeException("invalidLoginMsg not specified in the Configuration.properties file.");
	}


	public String getLogoutSuccessMsg() {
		String msg = properties.getProperty("logOutSuccessMsg");
		if (msg != null)
			return msg;
		else
			throw new RuntimeException("logOutSuccessMsg not specified in the Configuration.properties file.");
	}

	public String getLoginBtnText() {
		String text = properties.getProperty("loginBtnText");
		if (text != null)
			return text;
		else
			throw new RuntimeException("loginBtnText not specified in the Configuration.properties file.");
	}

	public String getTreeHeading() {
		String heading = properties.getProperty("treeHeading");
		if (heading != null)
			return heading;
		else
			throw new RuntimeException("treeHeading not specified in the Configuration.properties file.");
	}
	
	public String getArrayHeading() {
		String heading = properties.getProperty("arrayHeading");
		if (heading != null)
			return heading;
		else
			throw new RuntimeException("arrayHeading not specified in the Configuration.properties file.");
	}
	
	public String getDataStructureHeading() {
		String heading = properties.getProperty("dataStructureHeading");
		if (heading != null)
			return heading;
		else
			throw new RuntimeException("dataStructureHeading not specified in the Configuration.properties file.");
	}

	public String geturl(String pagename) {
		String heading = properties.getProperty(pagename);
		if (heading != null)
			return heading;
		else
			throw new RuntimeException(pagename + " url not specified in the Configuration.properties file.");
	}

	public String tryURL(String pagename) {
		String url = properties.getProperty(pagename);
		if (url != null)
			return url;
		else
			throw new RuntimeException(pagename + "url not specified in the Configuration.properties file.");
	}
	
	public String getSuccessfulRegisterationMsg() {
		String msg = properties.getProperty("successfulRegisterationMsg");
		if (msg != null)
			return msg;
		else
			throw new RuntimeException("successfulRegisterationMsg not specified in the Configuration.properties file.");
	}
	
	public String getEmptyFieldMsg() {
		String msg = properties.getProperty("emptyFieldMsg");
		if (msg != null)
			return msg;
		else
			throw new RuntimeException("emptyFieldMsg not specified in the Configuration.properties file.");
	}

	public String getInvalidCredsMsg() {
		String msg = properties.getProperty("invalidCredsMsg");
		if (msg != null)
			return msg;
		else
			throw new RuntimeException("invalidCredsMsg not specified in the Configuration.properties file.");
	}

	public String getInvalidUserName() {
		String username = properties.getProperty("invalidUserName");
		if (username != null)
			return username;
		else
			throw new RuntimeException("invalidUserName not specified in the Configuration.properties file.");
	}
	
	public String getInvalidPassword() {
		String password = properties.getProperty("invalidPassword");
		if (password != null)
			return password;
		else
			throw new RuntimeException("invalidPassword not specified in the Configuration.properties file.");
	}
}
