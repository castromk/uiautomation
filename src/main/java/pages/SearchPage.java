package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SearchPage {

	public SearchPage() {
		PageFactory.initElements(Driver.get(), this);
	}

	private static final Logger console = LoggerFactory.getLogger(SearchPage.class);

	@FindBy(xpath = "//div[@id='search']//h3[contains(.,'Open Lending')]/parent::a[contains(@href,'lending')]")
	private List<WebElement> searchResults;

	@FindBy(xpath = "//div[@id='search']//h3[contains(.,'Open Lending')]/parent::a[contains(@href,'lending')][contains(.,'LinkedIn')]")
	private WebElement linkedInLnk;

	@FindBy(xpath = "//button[text()='Sign in'][@class='form-toggle']")
	private WebElement signInLnk;

	@FindBy(css = "#login-email")
	private WebElement emailtxtBox;

	@FindBy(css = "#login-password")
	private WebElement passwordTxtBox;

	@FindBy(css = "#login-submit")
	private WebElement SignInLinkedIn;

	public boolean navigateToLinkedInPage() {
		boolean navigate = true;
		BrowserUtils.clickWithJS(linkedInLnk, "Linked In Result");
		BrowserUtils.waitFor(5);
		String currentURL = Driver.get().getCurrentUrl();
		if (currentURL.contains("www.linkedin.com") && currentURL.contains("open-lending-inc.")) {
			console.info("navigate to {} url after  clicking on linked Link", currentURL);
			navigate = true;
		}else{
			if (loginToLinkedIn()) {
				navigate = true;
				console.info("Able to navigate to linked in page sucessfully");
			} else {
				console.info("Not able to navigate to linked in page sucessfully");
				navigate = false;
			}
		}

		return navigate;
	}

	public boolean loginToLinkedIn() {
		boolean doesLogin = true;
		BrowserUtils.clickWithJS(signInLnk, "SignIn link");
		String username = ConfigurationReader.getProperty("ui.email");
		String password = ConfigurationReader.getProperty("ui.password");
		BrowserUtils.typeText(emailtxtBox, ConfigurationReader.getProperty("ui.email"), "email text box");
		BrowserUtils.typeText(passwordTxtBox, ConfigurationReader.getProperty("ui.password"), "password textbox");
		BrowserUtils.clickWithJS(SignInLinkedIn, "Sign In Buttin");
		String currentURL = Driver.get().getCurrentUrl();
		console.info("navigate to {} url after performing logging with username {} & password {} ", currentURL,
				username, password);
		if (currentURL.contains("www.linkedin.com") && currentURL.contains("open-lending-inc.")) {
			doesLogin = true;
		} else {
			doesLogin = false;
		}
		return doesLogin;
	}
}
