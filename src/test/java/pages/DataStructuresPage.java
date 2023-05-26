package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import managers.FileReaderManager;
import utilities.Log;

public class DataStructuresPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@href='time-complexity']") WebElement timeComplexityLink;
	@FindBy(xpath = "//p[text()='Time Complexity']") WebElement timeComplexityHeading;
	@FindBy(xpath = "//a[@href='/tryEditor']") WebElement tryEditorLink;
	
	
	public DataStructuresPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void VerifyDataStructuresPage()
	{
		Assert.assertEquals(driver.getTitle(), FileReaderManager.getInstance().getConfigReader().getDataStructureHeading());
		Log.info("Verified that user is on Data Structure page");
	}
	
	public void ClickOnTimeComplexity()
	{
		timeComplexityLink.click();
		Log.info("User clicked on Time Complexity link");
	}
	
	public void VerifyTimeComplexityPage()
	{
		Assert.assertTrue(timeComplexityHeading.isDisplayed());
		Log.info("Verified that user is on Time Complexity page");
	}
	
	public void ClickOnTryEditor()
	{
		tryEditorLink.click();
		Log.info("User clicked on Try here button");
	}
	
	
}
