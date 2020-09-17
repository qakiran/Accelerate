
package com.accelerate.keyword;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accelerate.pages.DataEntryPage;
import com.accelerate.pages.WorksheetPage;

import com.fiserv.framework.constants.KeywordConstants;
import com.fiserv.keyword.Keywords;

public class CreditCard extends DataEntryPage {
	protected WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, 60);

	Logger log = Logger.getLogger(DataEntry.class.getName());
	public WorksheetPage wp = new WorksheetPage();

	@Keywords(description = "Fill Data Entry Page 0-CC", category = "DataEntry", author = "ATeam")

	public void dataEntryPage0() {
		selectProduct(KeywordConstants.getKeyWordData().get("Product"));
		enterRequestedAmt(KeywordConstants.getKeyWordData().get("ReqAmt"));
		enterBranch(KeywordConstants.getKeyWordData().get("Branch"));
		selectdeliverymethod(KeywordConstants.getKeyWordData().get("DeliveryMethod"));
		enterSSN(KeywordConstants.getKeyWordData().get("SSN"));
		enterFirstName(KeywordConstants.getKeyWordData().get("FirstName"));
		enterMiddleName(KeywordConstants.getKeyWordData().get("MiddleName"));
		enterLastName(KeywordConstants.getKeyWordData().get("LastName"));
		clickSaveBttn();
	}
}


