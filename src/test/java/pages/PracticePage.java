package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import managers.FileReaderManager;
import utilities.Log;

public class PracticePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@href='/question/1']") WebElement firstQuestionLink;

	public PracticePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnFirstQuestion()
	{
		firstQuestionLink.click();
		Log.info("User clicked on first question on Practice page");
	}
	
	public void VerifyQuestionPageOpened()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains(FileReaderManager.getInstance().getConfigReader().getQuestionPageUrl()));
		Log.info("Verified that user is on First Question Editor page");
	}
}
