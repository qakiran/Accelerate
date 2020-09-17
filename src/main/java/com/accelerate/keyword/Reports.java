package com.accelerate.keyword;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.accelerate.pages.DataEntryPage;
import com.accelerate.pages.LoginPage;
import com.accelerate.pages.ReportsPage;
import com.accelerate.pages.WorksheetPage;
import com.fiserv.framework.Report;
import com.fiserv.framework.constants.KeywordConstants;
import com.fiserv.keyword.Keywords;

public class Reports extends ReportsPage {
	Logger log = Logger.getLogger(login.class.getName());
	public DataEntryPage dea = new DataEntryPage();

	@Keywords(description = "Run Report", category = "Reports", author = "ATeam")

	
	public void runReports() {
		try {
			Thread.sleep(10000);
			clickReportsTab();
			Thread.sleep(20000);
			clickFinalDecLoanRpt();
			Thread.sleep(20000);
			// closeReports();
			/*
			 * enterStartDate(KeywordConstants.getKeyWordData().get("StartDate")
			 * );
			 * enterEndDate(KeywordConstants.getKeyWordData().get("EndDate"));
			 * Thread.sleep(30000); clickRunRpt();
			 */
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
