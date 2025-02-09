package ananthuProject.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import ananthuProject.TestComponents.BaseTest;
import ananthuProject.TestComponents.Retry;

public class CheckVisibility extends BaseTest {

	@Test(retryAnalyzer=Retry.class)
	public void checkHomePageBanner() {

		boolean visiblility = landingpage.checkVisibilityOfPromoText();
		assertFalse(visiblility);
	}

}
