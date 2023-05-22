package readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader
{
	private Properties properties;
	private final String propertyFilePath="C:\\Users\\niles\\eclipse-workspace\\MyDSAlgo\\src\\test\\resources\\config.properties";
	
	//constructor of class
	public ConfigReader()
	{
		BufferedReader reader;
		try 
		{
			reader=new BufferedReader(new FileReader(propertyFilePath));
			properties=new Properties();
			try
			{
				properties.load(reader);
				reader.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at" +propertyFilePath);
		}
	}
	
	public String getDriverPath() 
	{
		String driverPath=properties.getProperty("driverPath");
		if(driverPath!=null) 
		return driverPath;
		else throw new RuntimeException("driverPath not specidied in the Configuration.properties file");
	} 
	
	public long getImplicitWait()
	{
		String implicitWait=properties.getProperty("implicitWait");
		if(implicitWait!=null)
			return Long.parseLong(implicitWait);
		else throw new RuntimeException("implicitWait not specified in the Configuration.properties file.");
	}
	
	public String getExcelFilePath()
	{
		String excelfilepath=properties.getProperty("excelfilepath");
		if(excelfilepath !=null)
			return excelfilepath;
		else throw new RuntimeException("excelfilepath not specified in configuration.properties file. path:"  +propertyFilePath);
	}
}

