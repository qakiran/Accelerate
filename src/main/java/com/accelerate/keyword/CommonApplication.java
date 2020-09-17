package com.accelerate.keyword;
//test 


import com.accelerate.pages.CommonApplicationPage;
import com.fiserv.keyword.Keywords;
import com.fiserv.framework.constants.KeywordConstants;

public class CommonApplication extends CommonApplicationPage {

	@Keywords(description = "Click New Consumer", category = "CreateApp", author = "ATeam")
	public void clickNewConsumer() {
		selectApplication();
		clickNewConsumerBttn();
	}

	@Keywords(description = "Quick Search", category = "SearchApp", author = "ATeam")
	public void searchApp() {
		selectApplication();
		quickSearch(KeywordConstants.getKeyWordData().get("Appid"));

	}

	@Keywords(description = "Logout of Application", category = "Logout", author = "ATeam")
	public void getLogout() {
		clickLogout();
		element.window().closeWindow();

	}

	/*
	 * @Keywords(description = "Add IMD Fees", category = "Loan Details", author
	 * = "ATeam") public void addIMDFee() { try {
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
	 */

	/*
	 * @Keywords(description = "Add IMD Addons", category = "Loan Details",
	 * author = "ATeam") public void addIMDAddon() {
	 * 
	 * System.out.println("executing appmenu steps"); try { Thread.sleep(10000);
	 * 
	 * /* System.out.println("Application menu function"); appMenu();
	 * loanDetails(); element.sync().pause(20); feesAddons();
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
	 * "AddonSalesStatus")); AddonAdd(); element.sync().pause(10); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

	@Keywords(description = "Enter Loan Calculation Details", category = "Loan Details", author = "ATeam")
	public void addContractDetails() {
		element.sync().pause(5);
		appMenu();
		//element.sync().pause(5);
		loanDetails();
		element.sync().pause(10);
		selectPPSalesStatus(KeywordConstants.getKeyWordData().get("PPSalesStatus"));
		enterContractDetails(KeywordConstants.getKeyWordData().get("ContDetLoanAmt"));
		element.sync().pause(10);

	}

	@Keywords(description = "Add IMD Fees", category = "Loan Details", author = "ATeam")
	public void addIMDFee() {
		try {
			/*
			 * System.out.println("executing appmenu steps");
			 * Thread.sleep(20000);
			 * System.out.println("Application menu function"); appMenu();
			 * loanDetails();
			 */
			Thread.sleep(1000);
			feesAddons();
			element.sync().pause(5);
			// addNewFee();
			selectFeesDesc(KeywordConstants.getKeyWordData().get("FeesDesc"));
			enterFeesPayableTo(KeywordConstants.getKeyWordData().get("FeePayableTo"));
			// enterFeesDebitAcct(KeywordConstants.getKeyWordData().get("FeesDebit"));
			// enterFeesCreditAcct(KeywordConstants.getKeyWordData().get("FeesCredit"));
			enterFeePaidbyBorrBefClosing(KeywordConstants.getKeyWordData().get("FeesPaidByBorrBefClosing"));
			feeAdd();
			element.sync().pause(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Keywords(description = "Add IMD Addons", category = "Loan Details", author = "ATeam")
	public void addIMDAddon() {

		System.out.println("executing appmenu steps");
		try {
			Thread.sleep(2000);

			/*
			 * System.out.println("Application menu function"); appMenu();
			 * loanDetails(); element.sync().pause(20); feesAddons();
			 * element.sync().pause(10);
			 */
			element.jsExecute().scrollToBottom();
			// addNewAddOn();
			selectAddonDesc(KeywordConstants.getKeyWordData().get("AddonDesc"));
			selectAddonType(KeywordConstants.getKeyWordData().get("AddonType"));
			enteAddonPayableTo(KeywordConstants.getKeyWordData().get("AddonPayableTo"));
			enterAddonDebitAcct(KeywordConstants.getKeyWordData().get("AddonDebit"));
			enterAddonCreditAcct(KeywordConstants.getKeyWordData().get("AddonCredit"));
			enterAddonPaidbyBorrBefClosing(KeywordConstants.getKeyWordData().get("AddonPaidByBorrBefClosing"));
			selectAddonSalesStatus(KeywordConstants.getKeyWordData().get("AddonSalesStatus"));
			AddonAdd();
			element.sync().pause(10);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Keywords(description = "Add Disbursement", category = "Loan Details", author = "ATeam")
	public void addDisbursement() {
		
		 element.sync().pause(10); 
		 appMenu(); 
		 element.sync().pause(5);
		 loanDetails();
		 element.sync().pause(10);
		clickDisbtab();
		element.sync().pause(2);
		clickAddNewDisb();
		element.sync().pause(2);
		selectDisbPaymentMethod(KeywordConstants.getKeyWordData().get("DisbPaymentMethod"));
		selectDisbPayableTo(KeywordConstants.getKeyWordData().get("DisbPayableTo"));
		enterDisbAmount(KeywordConstants.getKeyWordData().get("DisbAmount"));
		enterDisbCredAcct(KeywordConstants.getKeyWordData().get("DisbCreditAccount"));
		enterDisbDesc(KeywordConstants.getKeyWordData().get("DisbDesc"));
		enterDisbRefNo(KeywordConstants.getKeyWordData().get("DisbRefNo"));
		enterDisbAdd1(KeywordConstants.getKeyWordData().get("DisbAdd1"));
		enterDisbAdd2(KeywordConstants.getKeyWordData().get("DisbAdd2"));
		enterDisbAdd3(KeywordConstants.getKeyWordData().get("DisbAdd3"));
		enterDisbzipcode(KeywordConstants.getKeyWordData().get("DisbZipCode"));
		element.sync().pause(5);
	}

	@Keywords(description = "Select Repay Method-Cash", category = "Loan Details", author = "ATeam")
	public void repaymethodcash() {
		selectCashRepayMethod(KeywordConstants.getKeyWordData().get("RepayMethod1"));
	}
	
	@Keywords(description = "Select Repay Method-Transfer", category = "Loan Details", author = "ATeam")
	public void repaymethodtransfer() {
		selectTransferRepayMethod(KeywordConstants.getKeyWordData().get("RepayMethod2"));
		enterRepayMethodAccNo(KeywordConstants.getKeyWordData().get("RepayMethodAccNo"));
		enterRepayMethodAccSuffix(KeywordConstants.getKeyWordData().get("RepayMethodAccSuffix"));
	}
    }

