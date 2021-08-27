package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utilities.BrowserUtils;
import utilities.Driver;

public class HomePage {

	private static final Logger console = LoggerFactory.getLogger(HomePage.class);
	public HomePage() {
		PageFactory.initElements(Driver.get(), this);
	}

	@FindBy(css = "input[name='q']")
	private WebElement inputTxtBox;

	@FindBy(css = "#search")
	private WebElement searchDiv;

	@FindBy(xpath = "//div[@id='search']//h3[contains(.,'Open Lending')]/parent::a[contains(@href,'lending')]")
	private List<WebElement> searchResults;

	@FindBy(xpath = "//div[@id='search']//h3[contains(.,'Open Lending')]/parent::a[contains(@href,'lending')][contains(.,'LinkedIn')]")
	private WebElement linkedInLnk;

	public boolean searchText(String searchText) {
		console.info("searching text {} in google search box ",searchText);
		boolean searchResult = true;
		BrowserUtils.typeText(inputTxtBox, searchText,"Search textBox");
		inputTxtBox.sendKeys(Keys.chord(Keys.ENTER));
		try {
			WebElement searchWb = BrowserUtils.waitForVisibility(searchDiv, 90);
			searchResult = searchWb.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			searchResult = false;
		}
		return searchResult;

	}
}
