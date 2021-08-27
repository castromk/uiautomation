package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtils;
import utilities.Driver;

public class LinkedInPage {

	public LinkedInPage() {
		PageFactory.initElements(Driver.get(), this);
	}

	@FindBy(css = "p[class*='org-top-card-summary__tagline'] , h4[class*='top-card-layout__second-subline']")
	private WebElement slogan;

	public String sloganText() {
		String sloganText = "";
		sloganText = BrowserUtils.getElementText(slogan,"slogan Text");
		return sloganText;
	}
}
