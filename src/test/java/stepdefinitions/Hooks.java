package stepdefinitions;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import context.TestContext;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utilities.Screenshots;
import io.cucumber.java.AfterStep;

public class Hooks {

	TestContext testContext;
	static WebDriver driver;

	public Hooks(TestContext context) 
	{
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
	}

	@BeforeMethod
	public void BeforeSteps() 
	{
		
	}

	@AfterMethod
	public void AfterSteps() 
	{
		
	}
	
	@AfterStep
	public void AfterStep(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			Screenshots.CaptureScreenshot(driver);
			Allure.attachment("Myscreenshot",new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
		}
	}

}
