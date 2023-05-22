package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{

	// ThreadLocal used to manage the driver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal();

    // Private constructor to prevent the creation of new instances of Driver
    private DriverFactory(){}

    // Public method to access the driver instance (uses lazy instantiation)
    public static WebDriver getDriver(String browserType) {
        if (driver.get() == null) 
        {
        	if(browserType.equalsIgnoreCase("chrome"))
        	{
        		WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
        	}
        	else if(browserType.equalsIgnoreCase("firefox"))
        	{
        		WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
        	}
        }

        //driver.get().manage().deleteAllCookies();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        driver.get().manage().window().maximize();
        return driver.get();
    }

/*
Public method to quit the driver and 
remove the current thread's value for this thread-local variable
*/
    public static void quit() {
        driver.get().quit();
        driver.remove();
    }
}

