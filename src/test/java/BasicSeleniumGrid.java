import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BasicSeleniumGrid {
	@Test
	public void launchBrowser() throws MalformedURLException {
		//System.setProperty("webdriver.gecko.driver", "E:\\NPN\\NPN Training - Selenium Architect Training\\drivers\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		WebDriver driver = new RemoteWebDriver (new URL("http://192.168.1.6:8082/wd/hub"), options);
		driver.get("https://google.com");
	}

}
