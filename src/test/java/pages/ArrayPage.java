package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import managers.FileReaderManager;
import utilities.Log;

public class ArrayPage {

	WebDriver driver;
	
	@FindBy(xpath = "//h4[contains(text(),'Array')]") WebElement pageHeading;
	@FindBy(xpath = "//a[@href='arrays-in-python']") WebElement arraysInPythonLink;
	@FindBy(xpath = "//p[text()='Arrays in Python']") WebElement arraysInPythonHeading;
	@FindBy(xpath = "//a[@href='/tryEditor']") WebElement tryEditorLink;
	@FindBy(xpath = "//a[@href='/array/practice']") WebElement practiceQuestionsLink;
	@FindBy(xpath = "//a[@href='/question/1']") WebElement firstQuestionLink;
	
	public ArrayPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to verify that page heading 'Array' is displayed.
	 * This means user is on Array Page.
	 */
	public void VerifyArrayPage()
	{
		Assert.assertTrue(pageHeading.isDisplayed());
		Log.info("Verified that user is one Array page");
	}
	
	/**
	 * This method is used to click on 'Arrays in Python' link on Array page.
	 */
	public void ClickOnArraysInPython()
	{
		arraysInPythonLink.click();
		Log.info("User clicked on Arrays in Python link");
	}
	
	/**
	 * This method is used to verify that page heading 'Arrays in Python' is displayed.
	 * This means user is on Arrays in Python Page.
	 */
	public void VerifyArraysinPythonPage()
	{
		Assert.assertTrue(arraysInPythonHeading.isDisplayed());
		Log.info("Verified that user is on Arrays in Python page");
	}
	
	
	public void ClickOnTryEditor()
	{
		tryEditorLink.click();
		Log.info("User clicked on Try here button");
	}
	
	public void VerifyTryEditorPage()
	{
		Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getEditorPageUrl());
		Log.info("Verified that user is on Editor page");
	}
	
	public void ClickOnPracticeQuestionsLink()
	{
		practiceQuestionsLink.click();
		Log.info("User clicked on Practice Questions Link button");
	}
	
	public void VerifyPracticePage()
	{
		Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getPracticePageUrl());
		Log.info("Verified that user is on Practice page");
	}
	
}
