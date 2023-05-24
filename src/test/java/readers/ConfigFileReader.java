package readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.BrowserType;

public class ConfigFileReader {

	private static Properties properties;
	private final String propertyFilePath= "src/test/resources/configs/Configuration.properties";

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
		
		if(browserName == null || browserName.equals("chrome")) 
			return BrowserType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) 
			return BrowserType.FIREFOX;
		else if(browserName.equals("edge")) 
			return BrowserType.EDGE;
		else 
			throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
	
	public long getImplicitWait() 
	{		
		String implicitlyWait = properties.getProperty("implicitWait");
		if(implicitlyWait != null) 
			return Long.parseLong(implicitlyWait);
		else 
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() 
	{
		String url = properties.getProperty("appUrl");
		if(url != null) 
			return url;
		else 
			throw new RuntimeException("appUrl not specified in the Configuration.properties file.");
	}
	
	public String getHomeUrl() 
	{
		String url = properties.getProperty("homeUrl");
		if(url != null) 
			return url;
		else 
			throw new RuntimeException("homeUrl not specified in the Configuration.properties file.");
	}
	

	public String getArrayPageUrl() 
	{
		String url = properties.getProperty("arrayPageUrl");
		if(url != null) 
			return url;
		else 
			throw new RuntimeException("arrayPageUrl not specified in the Configuration.properties file.");
	}
	
	public String getPracticePageUrl() 
	{
		String url = properties.getProperty("practicePageUrl");
		if(url != null) 
			return url;
		else 
			throw new RuntimeException("practicePageUrl not specified in the Configuration.properties file.");
	}
	
	public String getEditorPageUrl() 
	{
		String url = properties.getProperty("editorPageUrl");
		if(url != null) 
			return url;
		else 
			throw new RuntimeException("editorPageUrl not specified in the Configuration.properties file.");
	}
	
	public String getQuestionPageUrl() 
	{
		String url = properties.getProperty("questionPageUrl");
		if(url != null) 
			return url;
		else 
			throw new RuntimeException("questionPageUrl not specified in the Configuration.properties file.");
	}
	
	public static String getExcelPath() 
	{
		String path = properties.getProperty("excelPath");
		if(path != null) 
			return path;
		else 
			throw new RuntimeException("path not specified in the Configuration.properties file.");
	}
	
	public String getScreenshotPath() 
	{
		String path = properties.getProperty("screenshotPath");
		if(path != null) 
			return path;
		else 
			throw new RuntimeException("screenshotPath not specified in the Configuration.properties file.");
	}
	
	public String getExtentReportConfigPath() 
	{
		String path = properties.getProperty("extentReportConfigPath");
		if(path != null) 
			return path;
		else 
			throw new RuntimeException("extentReportConfigPath not specified in the Configuration.properties file.");
	}
	
	public String getDSAlgoUserName() 
	{
		String username = properties.getProperty("dsAlgoUserName");
		if(username != null) 
			return username;
		else 
			throw new RuntimeException("dsAlgoUserName not specified in the Configuration.properties file.");
	}
	
	public String getDSAlgoPassword() 
	{
		String password = properties.getProperty("dsAlgoPassword");
		if(password != null) 
			return password;
		else 
			throw new RuntimeException("dsAlgoPassword not specified in the Configuration.properties file.");
	}
	
	public String getValidLoginMsg() 
	{
		String msg = properties.getProperty("validLoginMsg");
		if(msg != null) 
			return msg;
		else 
			throw new RuntimeException("validLoginMsg not specified in the Configuration.properties file.");
	}
	
	public String getInvalidLoginMsg() 
	{
		String msg = properties.getProperty("invalidLoginMsg");
		if(msg != null) 
			return msg;
		else 
			throw new RuntimeException("invalidLoginMsg not specified in the Configuration.properties file.");
	}
	// Signin URL
		public static String loginPage() {
			String loginurl = properties.getProperty("loginurl");
			if (loginurl != null)
				return loginurl;
			else
				throw new RuntimeException("login not specified in the Config.properties file");
		}
	
	public String getLogoutSuccessMsg() 
	{
		String msg = properties.getProperty("logOutSuccessMsg");
		if(msg != null) 
			return msg;
		else 
			throw new RuntimeException("logOutSuccessMsg not specified in the Configuration.properties file.");
	}
	
	public String getLoginBtnText() 
	{
		String text = properties.getProperty("loginBtnText");
		if(text != null) 
			return text;
		else 
			throw new RuntimeException("loginBtnText not specified in the Configuration.properties file.");
	}
	
	// Registration URL
		public static String registerPageURL() {
			String registerurl = properties.getProperty("registerpageurl");
			if (registerurl != null)
				return registerurl;
			else
				throw new RuntimeException("registerpageurl not specified in the Config.properties file");
		}
	public static String tryEditorURL() {
		String tryeditorurl = properties.getProperty("tryeditorurl");
		if (tryeditorurl != null)
			return tryeditorurl;
		else
			throw new RuntimeException("tryeditorurl not specified in the Configuration.properties file.");
	}

	public static String geturl(String pagename) {
		String url = properties.getProperty(pagename);
		if (url != null)
			return url;
		else
			throw new RuntimeException(pagename + " url not specified in the Configuration.properties file.");
	}
	public static String tryURL(String pagename) {
		String url = properties.getProperty(pagename);
		if (url != null)
			return url;
		else
			throw new RuntimeException(pagename + "url not specified in the Configuration.properties file.");
	}
	public static String getEditorUrl() {
		String editorurl = properties.getProperty("editorurl");
		if (editorurl != null)
			return editorurl;
		else
			throw new RuntimeException("Editor url is not specified in the Configuration.properties file.");
	}
	// Tree
		public static String getTreeUrl() {
			String treeurl = properties.getProperty("treeurl");
			if (treeurl != null)
				return treeurl;
			else
				throw new RuntimeException("tree url not specified in the Configuration.properties file.");
		}
		public static String gettryhereurl() {
			String tryhereurl = properties.getProperty("tryhereurl");
			if (tryhereurl != null)
				return tryhereurl;
			else
				throw new RuntimeException("tryhereurl url not specified in the Configuration.properties file.");
		}
	}


