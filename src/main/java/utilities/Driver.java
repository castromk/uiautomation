package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private static final Logger console = LoggerFactory.getLogger(Driver.class);

	private Driver() {

	}

	private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

	public static WebDriver get() {
		String browser = System.getProperty("browser") != null ? System.getProperty("browser").trim()
				: ConfigurationReader.getProperty("browser");
		if (driverPool.get() == null) {

			synchronized (Driver.class) {

				switch (browser) {

				case "chrome":
					WebDriverManager.chromedriver().setup();
					driverPool.set(new ChromeDriver());
					driverPool.get().manage().window().maximize();
					driverPool.get().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					break;

				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driverPool.set(new FirefoxDriver());
					driverPool.get().manage().window().maximize();
					driverPool.get().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					break;
				}
			}
			console.info("Opening browser {} successfully", browser);
		}
		
		return driverPool.get();
	}

	public static void closeDriver() {
		if (driverPool.get() != null) {
			driverPool.get().quit();
			driverPool.remove();
		}
		console.info("Closed all open browser session successfully");
	}

}
