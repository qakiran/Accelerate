package com.accelerate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.fiserv.framework.interfaces.ISynchronization;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.fiserv.framework.interfaces.IKeyboardAndMouseActions;

import com.accelerate.BaseElementPage;

public class CommonApplicationPage extends BaseElementPage {

	public void searchApp(String SearchApp) {
	}

	public By clickLogout = By.xpath("//a[@title='logout']");
	public By selectApplication = By.xpath("//span[text()='Application']");
	// public By clickNewApplication =
	// By.xpath("//a[@class='text-decoration-none-always d-flex
	// align-items-center popup-class']");
	public By clickNewApplication = By.xpath("//a[@title='New Application']");
	// public By clickNewConsumerApplication =
	// By.xpath("//li[@class='ng-star-inserted']/a[@tabindex='1']");
	public By clickNewConsumerApplication = By.xpath("//a[contains(text(),'New Consumer')]");

	// Quick Search
	public By QuickSearch = By.xpath("//*[@id=\"search\"]");
	public By QuickSearchicon = By.xpath(
			"//*[@class='input-group-btn smart-search-icon']/button[@type='button']/span[@class='k-i-search k-icon font-size-16 color-blue']");
	// public By Appdisplayed = By.xpath("//a[contains(text(),'0000027595')]");

	public By Appmenu = By.xpath("//a[@title='Application Menu']/i[text()='menu']");
	public By LoanDetails = By.xpath("//a[text()='Loan Details']");

	// Fees
	public By FeesAddons = By.xpath(
			"//h4[text()='Loan Details']/../../following-sibling::*/kendo-tabstrip/ul/li/following-sibling::*/span[contains(text(),'FEES & ADD ONS')]");
	public By FeesDesc = By.xpath("//app-manage-fees-form/div[2]/form/div/div[1]/div/kendo-dropdownlist/span/span[2]");
	public By FeeType = By.xpath("//label[text()=' Fee Type ']/../kendo-dropdownlist/span/span[2]");
	public By FeePayableTo = By.xpath("//app-manage-fees-form/div[2]/form/div/div[4]/div/input[@id='PayableTo']");
	public By FeeDebitAcct = By.xpath("//app-manage-fees-form/div[2]/form/div/div[5]/div/input[1]");
	public By FeeCreditAcct = By.xpath("//app-manage-fees-form/div[2]/form/div/div[6]/div/input[1]");
	public By FeePaidByBorrBefClosing = By
			.xpath("//app-manage-fees-form/div[2]/form/div[2]/div[6]/div/kendo-numerictextbox/span/input");
	public By FeePaidByBorrAtClosing = By
			.xpath("//app-manage-fees-form/div[2]/form/div[2]/div[7]/div/kendo-numerictextbox/span/input");
	public By FeeNoOfMonths = By
			.xpath("//app-manage-fees-form/div[2]/form/div[2]/div[9]/div/kendo-numerictextbox/span/input");
	public By FeeAdd = By.xpath(
			"//app-manage-fees/kendo-panelbar//kendo-panelbar-item/div/div/div/div[3]/div[3]/div/div/button[text()='Add']");
	public By FeeRecordDetails = By
			.xpath("//*[@id='k-panelbar-3-item-default-0']/span/div/span[3][not(contains(text(),'0 Record'))]");
	public By AddNewFee = By.xpath("//app-manage-fees/kendo-panelbar/kendo-panelbar-item/div/div/div/div[2]/div/a");

	// Addons

	public By AddonDesc = By.xpath(
			"//app-manage-addons-form/form/div/div/div/label[text()=' Description ']/../kendo-dropdownlist/span/span[2]");
	public By AddonType = By.xpath("//label[text()=' Add On Type ']/../kendo-dropdownlist/span/span[2]");
	public By AddonPayableTo = By.xpath("//app-manage-addons-form/form/div/div[4]/div/input[@id='PayableTo']");

	public By AddonDebitAcct = By
			.xpath("//app-manage-addons-form/form/div/div[5]/div/input[1]");

	public By AddonCreditAcct = By
			.xpath("//app-manage-addons-form/form/div/div[6]/div/input[@id='CrAccountNumber_maskedInput']");
	public By AddonPaidByBorrBefClosing = By
			.xpath("//app-manage-addons-form/form/div[2]/div[6]/div/kendo-numerictextbox/span/input");
	public By AddonPaidByBorrAtClosing = By
			.xpath("//app-manage-addons-form/form/div[2]/div[7]/div/kendo-numerictextbox/span/input");
	public By AddonSalesStatus = By
			.xpath("//app-addons-sales-history/form/div/div/div/div/kendo-dropdownlist/span/span[2]");
	public By AddonAdd = By.xpath(
			"//app-manage-addons/kendo-panelbar//kendo-panelbar-item/div/div/div/div[3]/div[3]/div/div/button[text()='Add']");
	public By AddonRecordDetails = By
			.xpath("//*[@id=\"k-panelbar-4-item-default-4\"]/span/div/span[3][contains(text(),'0')]");
	public By AddNewAddon = By.xpath("//app-manage-addons/kendo-panelbar/kendo-panelbar-item/div/div/div/div[2]/div/a");

	// Loan Calculator
	//public By CollapseLoanCalc = By.xpath("//*[@id='k-panelbar-0-item-default-0']/span/span");
	public By Salesstatus = By
			.xpath("//label[text()=' Sales Status '] /../kendo-dropdownlist/span/span[@class='k-input']");
	public By LoanCalcsave = By.xpath("//button[text()='Save']");
	public By CollapsePayprot = By.xpath("//*[@id='k-panelbar-2-item-default-2']/span/span");
	public By ContLoanAmt = By.xpath("//label[text()=' Loan Amount: ']/../kendo-numerictextbox/span/input");
	public By LoanCalcReqAmt = By.xpath("//label[text()=' Requested Amount ']/../kendo-numerictextbox/span/input");

	// Disbursement

	public By Disbursementtab = By.xpath("//h4[text()='Loan Details']/../../following-sibling::*/kendo-tabstrip/ul/li[4]/span[contains(text(),'DISBURSEMENTS')]");
	public By AddNewDisb = By.xpath("//div/a[2]");
	public By DisbPaymentMethod = By
			.xpath("//label[text()=' Payment Method ']/../kendo-dropdownlist/span/span[@class='k-select']");
	public By DisbPayableto = By
			.xpath("//label[text()=' Payable To ']/../div/kendo-combobox/span/span[@class='k-select']");
	public By DisbAmount = By.xpath("//label[text()=' Amount ']/../kendo-numerictextbox/span/input");
	public By DisbCreditAccount = By
			.xpath("//label[text()=' Credit Account ']/../input[@id='AccountNumber_maskedInput']");
	public By DisbDescription = By.xpath("//label[text()=' Description ']/../input");
	public By DisbReferenceNumber = By.xpath("//label[text()=' Reference Number ']/../input");
	public By DisbAdd1 = By.xpath("//label[text()=' Address 1 ']/../input[@id='FirstLine']");
	public By DisbAdd2 = By.xpath("//label[text()=' Address 2 ']/../input[@id='SecondLine']");
	public By DisbAdd3 = By.xpath("//label[text()=' Address 3 ']/../input[@id='ThirdLine']");
	public By DisbZipCode = By.xpath("//label[text()=' Zip Code ']/../div/input");
	public By DisbCity = By.xpath("//label[text()=' City ']/../input[@id='City']");
	public By AddDisb = By.xpath("//button[text()='Add']");

	// Repayment Method
	public By RepayMethod = By.xpath(" //label[text()=' Method '] /../kendo-dropdownlist/span/span[@class='k-select']");
	//public By RepayBilling = By.xpath("//*[@id='CashOptionCode_column']/div/div/app-segment-button/div/label[1]/text()");
	public By RepayBilling = By.xpath("//app-segment-button/div/label[1]");
	public By RepayMethodAccNo = By.xpath("//form//div/input[@id='RepayAccountNumber_maskedInput']");
	public By RepayMethodAccSuffix = By.xpath("//form//div/input[@id='RepayAccountSuffix_maskedInput']");
	public By DisbSave = By.xpath("//button[@type='submit']");

	
	public void clickLogout() {
		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		element.sync().pause(5);
		element.window().closeWindow();

	}

	public void selectApplication() {
		//element.sync().elementToBeClickable(selectApplication);
		element.sync().pause(25);
		element.click(selectApplication, "Click Application ");
		element.sync().pause(5);

	}

	public void clickNewConsumerBttn() {
		// try {
		// Thread.sleep(10000);
		// waitForElement(clickNewApplication);
		// wait.until(ExpectedConditions.elementToBeClickable(clickNewApplication));
		// element.sync().waitForElement(clickNewApplication);
		// element.sync().waitForSpinner(60);
		System.out.println("loading page completed");
	//	element.sync().pause(5);
		// element.sync().fluentWaitForElement(clickNewApplication);

		//element.sync().elementToBeClickable(clickNewApplication);
		element.sync().pause(20);
        
		element.click(clickNewApplication, "Click on New Application button");
		System.out.println("New Application button found");
		element.sync().pause(5);
		// Thread.sleep(10000);
		// k.mouseActions(clickNewConsumerApplication).wait(2000);
		// element.sync().waitForElement(clickNewConsumerApplication);
		// element.sync().elementToBeClickable(clickNewConsumerApplication);
		element.click(clickNewConsumerApplication, "Click on New Consumer Option");
		System.out.println("clicked on Create New Consumer");
		element.sync().pause(5);
		//element.sync().waitForSpinner(10);
	}
	/*
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public void quickSearch(String SearchApp) {
		try {
			Thread.sleep(20000);
			// element.sync().waitForElement(QuickSearch);
			System.out.println("inside the method quicksearch");
			element.sendKeys(QuickSearch, String.valueOf(SearchApp), "Enter Appid :" + SearchApp);
			element.mouseActions(QuickSearch).keyStroke("Enter");
			System.out.println("clicked enter key");
			// element.sync().pause(30);
			// element.sync().elementToBeClickable(QuickSearchicon);
			// element.click(QuickSearchicon,"Click search icon");

			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void appMenu() {
		System.out.println("inside appMenu function to hover over app menu");
		// element.sync().waitForSpinner(60);
		element.sync().pause(20);
		// newfunc.mouseHover(Appmenu);
		System.out.println("hovered on App menu");
		element.click(Appmenu, "");
		System.out.println("clicked App menu");
	}

	public void loanDetails() {
		try {
			Thread.sleep(5000);
			// element.sync().waitForElement(LoanDetails);
			element.click(LoanDetails, "");
			System.out.println("clicked Loan details menu");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void feesAddons() {
		try {
			Thread.sleep(5000);
			// element.sync().waitForElement(LoanDetails);
			element.click(FeesAddons, "");
			System.out.println("clicked fees and addons tab");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addNewFee() {
		boolean Recordvalue = element.isDisplayed(FeeRecordDetails);
		System.out.println(Recordvalue);

		if (Recordvalue) {
			element.click(AddNewFee, "");
			element.sync().pause(10);
		}
	}

	public void selectFeesDesc(String feedesc) {
		String feedescstr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + feedesc + "']";
		By selectfeedesc = By.xpath(feedescstr);
		element.sync().waitForElement(FeesDesc);
		element.click(FeesDesc, "Click on Desc DropDown");
		element.click(selectfeedesc, "");

	}

	public void enterFeesPayableTo(String feepayableto) {
		element.sync().pause(10);
		element.click(FeePayableTo, "");
		element.sendKeys(FeePayableTo, feepayableto, "");
	}

	public void enterFeesDebitAcct(String feedebitacct) {
		boolean eledisplayed = element.isDisplayed(FeeDebitAcct);
		if (!eledisplayed) {
			element.jsExecute().scrollToElement(FeesDesc);
		}
		element.click(FeeDebitAcct, "");
		element.sendKeys(FeeDebitAcct, feedebitacct, "");
	}

	public void enterFeesCreditAcct(String feecreditacct) {

		element.click(FeeCreditAcct, "");
		element.sendKeys(FeeCreditAcct, feecreditacct, "");
	}

	public void enterFeePaidbyBorrBefClosing(String beforeclosing) {

		element.click(FeePaidByBorrBefClosing, "");
		element.sendKeys(FeePaidByBorrBefClosing, beforeclosing, "");
		element.click(FeePaidByBorrAtClosing, "");
		element.sync().pause(5);
		element.jsExecute().scrollToElement(FeeDebitAcct);
	}

	public void feeAdd() {
		element.click(FeeAdd, "");
	}

	// IMD Addons

	public void addNewAddOn() {
		boolean Recordvalue2 = element.isDisplayed(AddonRecordDetails);

		System.out.println(Recordvalue2);

		if (!Recordvalue2) {
			element.click(AddNewAddon, "");
			element.sync().pause(10);
		}
	}

	public void selectAddonDesc(String addondesc) {
		String addondescstr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + addondesc
				+ "']";
		By selectaddondesc = By.xpath(addondescstr);
		element.sync().waitForElement(AddonDesc);
		element.click(AddonDesc, "Click on Desc DropDown");
		element.click(selectaddondesc, "");

	}

	public void selectAddonType(String addontype) {
		String Addontype = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + addontype + "']";
		By selectaddontype = By.xpath(Addontype);
		element.sync().waitForElement(AddonType);
		element.click(AddonType, "Click on Type DropDown");
		element.click(selectaddontype, "");
	}

	public void enteAddonPayableTo(String addonpayableto) {
		element.sync().pause(10);
		element.click(AddonPayableTo, "");
		element.sendKeys(AddonPayableTo, addonpayableto, "");
	}

	public void enterAddonDebitAcct(String addondebitacct) {
		boolean debitaactdisp = element.isDisplayed(AddonDebitAcct);
		if (!debitaactdisp) {
			element.jsExecute().scrollToElement(AddonDesc);
		}

		element.clear(AddonDebitAcct);
		element.sendKeys(AddonDebitAcct, addondebitacct, "");

	}

	public void enterAddonCreditAcct(String addoncreditacct) {

		element.click(AddonCreditAcct, "");
		element.sendKeys(AddonCreditAcct, addoncreditacct, "");
	}

	public void enterAddonPaidbyBorrBefClosing(String Addonbeforeclosing) {

		element.click(AddonPaidByBorrBefClosing, "");
		element.sendKeys(AddonPaidByBorrBefClosing, Addonbeforeclosing, "");
		element.click(AddonPaidByBorrAtClosing, "");
		element.sync().pause(5);
		element.jsExecute().scrollToElement(AddonDesc);
	}

	public void selectAddonSalesStatus(String addonsalesstatus) {
		element.jsExecute().scrollToBottom();
		String Addonsalesstatus = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ addonsalesstatus + "']";
		By selectaddonsalesstatus = By.xpath(Addonsalesstatus);
		element.sync().waitForElement(AddonSalesStatus);
		element.click(AddonSalesStatus, "Click on Salesstatus DropDown");
		element.click(selectaddonsalesstatus, "");
	}

	public void AddonAdd() {
		element.click(AddonAdd, "");
	}

	public void selectPPSalesStatus(String salesstatusPP) {
		element.jsExecute().scrollToElement(LoanCalcReqAmt);
		String PPSalesStatus = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + salesstatusPP
				+ "']";
		By PPSalesStatusdesc = By.xpath(PPSalesStatus);
		element.sync().pause(5);
		element.click(Salesstatus, "Click on Sales status DropDown");
		element.click(PPSalesStatusdesc, "");
		element.sync().pause(5);
		// element.sync().elementToBeClickable(LoanCalcsave);
		// element.click(LoanCalcsave,"");

	}

	public void enterContractDetails(String loanamt) {
		// element.click(CollapseLoanCalc, "");
		 element.sync().pause(5);
		// element.click(CollapsePayprot,"");
		element.jsExecute().scrollToElement(Salesstatus);
		element.sync().pause(5);
		element.click(ContLoanAmt, "");
		element.sendKeys(ContLoanAmt, loanamt, "");
		element.click(LoanCalcsave, "");
		element.sync().pause(5);
	}

	public void clickDisbtab() {
		element.jsExecute().scrollDownTo(0, 0);
		element.sync().pause(10);
		element.click(Disbursementtab, "");
		element.sync().pause(10);
	}

	public void clickAddNewDisb() {
		element.click(AddNewDisb, "");
		element.sync().pause(5);
	}

	public void selectDisbPaymentMethod(String paymentmeth) {
		String DisbPaymentMethodstr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ paymentmeth + "']";
		By Paymentmethoddesc = By.xpath(DisbPaymentMethodstr);
		element.sync().pause(5);
		element.click(DisbPaymentMethod, "");
		element.click(Paymentmethoddesc, "");
		element.sync().pause(5);

	}

	public void selectDisbPayableTo(String payableto) {
		String DisbPayableToStr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + payableto
				+ "']";
		By DisbPayableToDesc = By.xpath(DisbPayableToStr);
		element.sync().waitForElement(DisbPayableto);
		element.click(DisbPayableto, "");
		element.click(DisbPayableToDesc, "");
		element.sync().pause(5);

	}

	public void enterDisbAmount(String disbamount) {
		element.click(DisbAmount, "");
		element.sendKeys(DisbAmount, disbamount, "");
	}

	public void enterDisbCredAcct(String disbcredact) {
		element.click(DisbCreditAccount, "");
		element.sendKeys(DisbCreditAccount, disbcredact, "");
	}

	public void enterDisbDesc(String disbdesc) {
		element.jsExecute().scrollToElement(AddNewDisb);
		element.click(DisbDescription, "");
		element.sendKeys(DisbDescription, disbdesc, "");
	}

	public void enterDisbRefNo(String disbrefno) {
		element.click(DisbReferenceNumber, "");
		element.sendKeys(DisbReferenceNumber, disbrefno, "");
	}

	public void enterDisbAdd1(String disbadd1) {
		element.click(DisbAdd1, "");
		element.sendKeys(DisbAdd1, disbadd1, "");

	}

	public void enterDisbAdd2(String disbadd2) {
		element.click(DisbAdd2, "");
		element.sendKeys(DisbAdd2, disbadd2, "");

	}

	public void enterDisbAdd3(String disbadd3) {
		element.click(DisbAdd3, "");
		element.sendKeys(DisbAdd3, disbadd3, "");

	}

	public void enterDisbzipcode(String disbzipcode) {
		element.jsExecute().scrollToElement(DisbAdd1);
		element.sync().pause(2);
		element.click(DisbZipCode, "");
		element.sendKeys(DisbZipCode, disbzipcode, "");
		element.click(DisbCity, "");
		element.sync().pause(5);
		element.click(AddDisb, "");
		element.sync().pause(10);

	}

	public void selectCashRepayMethod(String repaymethod) {
		element.jsExecute().scrollToBottom();
		String RepayMethodStr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + repaymethod
				+ "']";
		By RepayMethodDesc = By.xpath(RepayMethodStr);
		// element.sync().waitForElement(DisbPayableto);
		element.click(RepayMethod, "");
		element.click(RepayMethodDesc, "");
		element.sync().pause(5);
		element.click(RepayBilling, "");
		element.sync().pause(5);
		element.click(DisbSave, "");
		element.sync().pause(10);

	}
	
	public void selectTransferRepayMethod(String repaymethod1) {
		element.jsExecute().scrollToBottom();
		String RepayMethodStr1 = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + repaymethod1
				+ "']";
		By RepayMethodDesc1 = By.xpath(RepayMethodStr1);
		// element.sync().waitForElement(DisbPayableto);
		element.click(RepayMethod, "");
		element.click(RepayMethodDesc1, "");
		element.sync().pause(5);
	}
	
	public void enterRepayMethodAccNo(String repaymethodaccno)
	{
		element.click(RepayMethodAccNo, "");
		element.sendKeys(RepayMethodAccNo, repaymethodaccno, "");
			}
	
	public void enterRepayMethodAccSuffix(String accsuffix)
	{
		element.click(RepayMethodAccSuffix, "");
		element.sendKeys(RepayMethodAccSuffix, accsuffix, "");
		element.click(DisbSave, "");
		element.sync().pause(5);
	}
}






