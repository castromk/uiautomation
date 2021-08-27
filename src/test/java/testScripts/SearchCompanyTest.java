package testScripts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pages.HomePage;
import pages.LinkedInPage;
import pages.SearchPage;
import utilities.JSONReader;

public class SearchCompanyTest extends BaseTest {
	private static final Logger console = LoggerFactory.getLogger(SearchCompanyTest.class);
	HomePage homePage = new HomePage();
	SearchPage searchPage = new SearchPage();
	LinkedInPage linkedInPage = new LinkedInPage();

	@Test
	@DisplayName("Search {Open lending} Text in google & Verify the linked in slongan for lending page")
	void verifySearchCompany() {
		console.info("Searching & validating \"open lending\" text & in linked page begins");
		try {
			// Check whether we are able to perform search or not
			if (!homePage.searchText(JSONReader.getData("searchText"))) {
				throw new Exception("not able to perform search text");
			}
			// check whether we are able to navigate or not
			if (!searchPage.navigateToLinkedInPage())
				throw new Exception("not able to navigate to linked In Page");

			assertEquals(linkedInPage.sloganText(), JSONReader.getData("sloganText"));

		} catch (Exception e) {
			fail("error occured due to " + e.getMessage());
			console.error("not able to perform search & validation due to {}",e.getMessage());
		} finally {
			console.info("Searching & validating \"open lending\" text & in linked page ends");
		}
	}

}
