package utilities;


public class HandleExceptions {
	public static void Handle(Exception ex)
	{
		Log.error(ex.getMessage());
		Log.endTestCase();
		//Screenshots.CaptureScreenshot(testContext.getWebDriverManager().getDriver());
	}

}
