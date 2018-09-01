import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExecution {
	
	public static Capabilities getOptions(String browser) {
		
		switch(browser) {
		
		case("firefox"):
			return new FirefoxOptions();
		case("chrome"):
			return new ChromeOptions();
		case("ie"):
			return new InternetExplorerOptions();
		default:
			return new FirefoxOptions();
		
		}
	}
	
	public static RemoteWebDriver launchBrowser(String browser) throws MalformedURLException {
		
		return new RemoteWebDriver(new URL ("http://192.168.1.6:8082/wd/hub"), getOptions(browser));
	}
	@Test
	@Parameters ({ "browser" })
	public void testParallelExecution(String browser) throws MalformedURLException {
		
		WebDriver driver;
		driver=launchBrowser(browser);
		driver.get("https://google.com");
		driver.manage().window().maximize();
	}

}
