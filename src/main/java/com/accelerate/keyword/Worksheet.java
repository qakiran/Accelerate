package com.accelerate.keyword;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.accelerate.pages.DataEntryPage;
import com.accelerate.pages.LoginPage;
import com.accelerate.pages.WorksheetPage;
import com.fiserv.framework.Report;
import com.fiserv.framework.constants.KeywordConstants;
import com.fiserv.keyword.Keywords;

public class Worksheet extends WorksheetPage {
	
	// protected WebDriver driver;
	// WebDriverWait wait=new WebDriverWait(driver, 20);
	Logger log = Logger.getLogger(login.class.getName());
	public DataEntryPage dea = new DataEntryPage();

	@Keywords(description = "Change product", category = "Actions", author = "ATeam")
	public void changeProduct() {
		try {
			Thread.sleep(10000);
			clickActions();
			Thread.sleep(15000);
			clickChange();
			clickChangeProduct();
			selectProductforChange(KeywordConstants.getKeyWordData().get("ProductforChange"));
			selectPurposeforChange(KeywordConstants.getKeyWordData().get("PurposeforChange"));
			enterBranchforChange(KeywordConstants.getKeyWordData().get("BranchforChange"));
			clickOKforChange();
			clickYesbttn();
			Thread.sleep(30000);
			dea.CloseActionStatuswindow();
			Thread.sleep(2000);
			appInfo();
			// Change Product to original
			clickActions();
			Thread.sleep(5000);
			clickChange();
			clickChangeProduct();
			selectProductforChange(KeywordConstants.getKeyWordData().get("ProductforChange2"));
			selectPurposeforChange(KeywordConstants.getKeyWordData().get("PurposeforChange2"));
			enterBranchforChange(KeywordConstants.getKeyWordData().get("BranchforChange2"));
			clickOKforChange();
			clickYesbttn();
			Thread.sleep(30000);
			dea.CloseActionStatuswindow();
			Thread.sleep(2000);
			appInfo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Keywords(description = "Change lender", category = "Actions", author = "ATeam")

	public void changeLender() {
		try {
			Thread.sleep(10000);
			clickActions();
			Thread.sleep(25000);
			clickChange();
			Thread.sleep(2000);
			clickOKforChange();
			clickYesbttn();
			Thread.sleep(30000);
			dea.CloseActionStatuswindow();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Keywords(description = "Change Delivery Method", category = "Actions", author = "ATeam")

	public void changeDelMethod() {
		try {
			Thread.sleep(20000);
			clickActions();
			Thread.sleep(25000);
			clickChange();
			Thread.sleep(12000);
			clickDelMethod();
			Thread.sleep(12000);
			selectDeliveryMethod(KeywordConstants.getKeyWordData().get("DeliveryMethod"));
			clickOKforChange();
			clickYesbttn();
			Thread.sleep(30000);
			dea.CloseActionStatuswindow();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Keywords(description = "Withdraw App", category = "Actions", author = "ATeam")

	public void withdrawApp() {
		try {
			Thread.sleep(10000);
			clickActions();
			Thread.sleep(25000);
			clickWorkflow();
			Thread.sleep(2000);
			clickWithdraw();
			selectWithdrawalReason(KeywordConstants.getKeyWordData().get("WithdrawalReason"));
			Thread.sleep(10000);
			clickWithdrawOK();
			Thread.sleep(2000);
			withdrawAppYES();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * @Keywords(description = "Add IMD Fees", category = "Loan Details", author
	 * = "ATeam")
	 * 
	 * public void addIMDFee() { try {
	 * System.out.println("executing appmenu steps"); Thread.sleep(20000);
	 * System.out.println("Application menu function"); appMenu();
	 * loanDetails(); element.sync().pause(5); feesAddons();
	 * element.sync().pause(5); //addNewFee();
	 * selectFeesDesc(KeywordConstants.getKeyWordData().get("FeesDesc"));
	 * enterFeesPayableTo(KeywordConstants.getKeyWordData().get("FeePayableTo"))
	 * ; enterFeesDebitAcct(KeywordConstants.getKeyWordData().get("FeesDebit"));
	 * enterFeesCreditAcct(KeywordConstants.getKeyWordData().get("FeesCredit"));
	 * enterFeePaidbyBorrBefClosing(KeywordConstants.getKeyWordData().get(
	 * "FeesPaidByBorrBefClosing")); feeAdd(); element.sync().pause(10);
	 * 
	 * } catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * @Keywords(description = "Add IMD Addons", category = "Loan Details",
	 * author = "ATeam") public void addIMDAddon() {
	 * 
	 * /*System.out.println("executing appmenu steps"); Thread.sleep(10000);
	 * System.out.println("Application menu function"); appMenu();
	 * loanDetails(); element.sync().pause(20); feesAddons();
	 */
	/*
	 * element.sync().pause(10); element.jsExecute().scrollToBottom();
	 * //addNewAddOn();
	 * selectAddonDesc(KeywordConstants.getKeyWordData().get("AddonDesc"));
	 * selectAddonType(KeywordConstants.getKeyWordData().get("AddonType"));
	 * enteAddonPayableTo(KeywordConstants.getKeyWordData().get("AddonPayableTo"
	 * ));
	 * enterAddonDebitAcct(KeywordConstants.getKeyWordData().get("AddonDebit"));
	 * enterAddonCreditAcct(KeywordConstants.getKeyWordData().get("AddonCredit")
	 * ); enterAddonPaidbyBorrBefClosing(KeywordConstants.getKeyWordData().get(
	 * "AddonPaidByBorrBefClosing"));
	 * selectAddonSalesStatus(KeywordConstants.getKeyWordData().get(
	 * "AddonSalesStatus")); AddonAdd(); element.sync().pause(10);
	 * 
	 * 
	 * }
	 */

	@Keywords(description = "Check Conditions", category = "Loan Details", author = "ATeam")
	public void checkConditions() {

		checkallConditions();
	}

	
	@Keywords(description = "Submit To Workflow", category = "Actions", author = "ATeam")
	public void submitToWorkflow() {

		clickActions();
		clickWorkflow();
		clickSubmitToWorkflow();
	}

	@Keywords(description = "Decision-Approve", category = "Decision", author = "ATeam")
	public void approveLoan() {

		clickDecisionMenu();
		clickApprove();
		enterDecisionUserName(KeywordConstants.getKeyWordData().get("DecisionLoginUsername"));
		enterDecisionPW(KeywordConstants.getKeyWordData().get("DecisionLoginPassword"));
		decisionLoginOk();
		decisionApprove();
	}

}




