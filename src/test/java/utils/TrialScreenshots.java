package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TrialScreenshots 
{
	WebDriver driver;
	
		//Initialize Driver		
		public TrialScreenshots(WebDriver driver)
		{	
			this.driver = driver;
			PageFactory.initElements(driver, this);	
			//driver.get("https://dsportalapp.herokuapp.com");
		}
		
		public void takeScreenshot() throws IOException
		{
			//here we have to replace”:” and “space” because this thing is not supported in the file name. 
			//so for this we will convert this into string , 
			//then we will call replace method and concatenate .png .
			Date d = new Date();
	        String datestamp = d.toString().replace(":", "_").replace(" ", "_");// + ".png";
	        
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("C:\\Users\\niles\\eclipse-workspace\\MyDSAlgo\\screenshots\\firstTest"+ datestamp + ".jpeg")); 
			
		}
}
