package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import utilities.Log;

public class LandingPage {

	WebDriver driver;
	
	@FindBy(xpath = "//button[text()='Get Started']") WebElement getStartedBtn;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void GoToLandingPage()
	{
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		Log.info("User navigated to DS Algo Landing page");
	}
	
	public void ClickOnGetStarted()
	{
		getStartedBtn.click();
		Log.info("User clicked on Get Started button on Landing Page");
	}
}
