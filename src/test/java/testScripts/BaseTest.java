package testScripts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utilities.ConfigurationReader;
import utilities.Driver;

class BaseTest {

	private static final Logger console = LoggerFactory.getLogger(BaseTest.class);
	@BeforeEach
	public void setUp() {
		String url = ConfigurationReader.getProperty("ui.baseUrl");
		String browser = ConfigurationReader.getProperty("browser");
		Driver.get().get(url);
		console.info("Open url {} successfully in {} browser",url,browser);
	}

	@AfterEach
	public void tearDown() {
		Driver.get().quit();
		console.info("Quitting the browser session after execution");
	}
}
