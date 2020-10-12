package com.accelerate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.accelerate.BrowserElement;
import com.accelerate.BaseElementPage;
import com.aventstack.extentreports.Status;
import com.fiserv.framework.Report;
import com.fiserv.framework.interfaces.ISynchronization;
import com.fiserv.framework.interfaces.IKeyboardAndMouseActions;

public class WorksheetPage extends BaseElementPage {
	
	public By appMenu = By.xpath("//a[@title='Application Menu']/i[text()='menu']"); 
    public By loanDetails = By.xpath("//a[text()='Loan Details']");
	

	public By Actions = By.xpath("//a[@title='Actions']/i[1]");
	public By Change = By.xpath("//li[7]/button[@tabindex='0']");
	public By changeProduct = By.xpath("//span[@id='drawerId-5_label']/../following-sibling::*/div/div/div/div/kendo-tabstrip/ul/li[2]");
	public By productDropDown = By.xpath("//label[contains(text(),'Product')]/../kendo-dropdownlist/span/span[@class='k-input']");
	public By purposeDropDown = By.xpath("//label[contains(text(),'Purpose')]/../kendo-dropdownlist/span/span[@class='k-input']");
	public By cpBranch = By.xpath("//label[@for='ProductBranch']/../div/kendo-autocomplete/kendo-searchbar/input");
	public By okBttn = By.xpath("//button[contains(text(),'OK')]");
	public By yesBttn = By.xpath("//button[contains(text(),'Yes')]");
	public By appInfo = By.xpath("//i[contains(text(),'info_outline ')]");
	public By decisionMenu = By.xpath("//i[text()='gavel']");
	public By approve = By.xpath("//velocity-leftnav//div[2]//li[1]/button");
	public By decisionLoginUserName = By.xpath("//label[text()=' User Name ']/../input");
	public By decisionLoginPassword = By.xpath("//label[text()=' Password ']/..//input");
	public By decisionLoginOK = By.xpath("//button[text()='OK']");
	public By decisionOk = By.xpath("//button[text()='Ok']");
	public By Workflow = By.xpath("//li[3]/button[@tabindex='0']");
	public By Withdraw = By.xpath("//li[4]/button[@tabindex='0']");
	public By withdrawalReason = By.xpath("//label[text()='Withdrawal Reason']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By withdrawOK = By.xpath("//button[text()='OK']");
	public By withdrawAppYESbttn = By.xpath("//div[text()='Withdraw Application']/../following-sibling::*/following-sibling::*/button[text()=' Yes ']");
	public By deliveryMethod = By.xpath("//div/div/div/div/div/kendo-tabstrip/ul/li[@id='k-tabstrip-tab-3']/span");
	public By delMethodDropdwn = By.xpath("//label[text()='Delivery Method']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By submitToWorkflow = By.xpath("//li[1]/button[@tabindex='0']");
	public By submitToWorkflowOK = By.xpath("//button[text()='OK']");
	public By closeWorksheetbutton = By.xpath("//button[text='Close Worksheet']");
	public By closeActionStatusWindow = By.xpath("//button[text()='Close']");
    public By fundingPrep = By.xpath("//li[2]/button[@tabindex='0']");
    public By acceptFunding = By.xpath("//li[2]/button[@tabindex='0']");
    public By acceptFundingClose = By.xpath("//button[text()='Close']"); 
    public By bookToHost = By.xpath("//li[2]/button[@tabindex='0']");
    public By confirmBTH = By.xpath("//button[text()=' Yes ']");
    public By closeBTH = By.xpath("//button[text()='Close']");
    
    //KeyData
    public By KeyData = By.xpath("//i[text()=' info_outline ']");
    
	
     
	
 // Fees
 	public By feesAddons = By.xpath("//h4[text()='Loan Details']/../../following-sibling::*/kendo-tabstrip/ul/li/following-sibling::*/span[contains(text(),'FEES & ADD ONS')]");
 	public By feesDesc = By.xpath("//app-manage-fees-form/div[2]/form/div/div[1]/div/kendo-dropdownlist/span/span[2]");
 	public By feeType = By.xpath("//label[text()=' Fee Type ']/../kendo-dropdownlist/span/span[2]");
 	public By feePayableTo = By.xpath("//app-manage-fees-form/div[2]/form/div/div[4]/div/input[@id='PayableTo']");
 	public By feeDebitAcct = By.xpath("//app-manage-fees-form/div[2]/form/div/div[5]/div/input[1]");
 	public By feeCreditAcct = By.xpath("//app-manage-fees-form/div[2]/form/div/div[6]/div/input[1]");
 	public By feePaidByBorrBefClosing = By.xpath("//app-manage-fees-form/div[2]/form/div[2]/div[6]/div/kendo-numerictextbox/span/input");
 	public By feePaidByBorrAtClosing = By.xpath("//app-manage-fees-form/div[2]/form/div[2]/div[7]/div/kendo-numerictextbox/span/input");
 	public By feeNoOfMonths = By.xpath("//app-manage-fees-form/div[2]/form/div[2]/div[9]/div/kendo-numerictextbox/span/input");
 	public By feeAdd = By.xpath("//app-manage-fees/kendo-panelbar//kendo-panelbar-item/div/div/div/div[3]/div[3]/div/div/button[text()='Add']");
 	public By feeRecordDetails = By.xpath("//*[@id='k-panelbar-3-item-default-0']/span/div/span[3][not(contains(text(),'0 Record'))]");
 	public By addNewFee = By.xpath("//app-manage-fees/kendo-panelbar/kendo-panelbar-item/div/div/div/div[2]/div/a");
 	
 // Addons

 	public By addonDesc = By.xpath("//app-manage-addons-form/form/div/div/div/label[text()=' Description ']/../kendo-dropdownlist/span/span[2]");
 	public By addonType = By.xpath("//label[text()=' Add On Type ']/../kendo-dropdownlist/span/span[2]");
 	public By addonPayableTo = By.xpath("//app-manage-addons-form/form/div/div[4]/div/input[@id='PayableTo']");
 	public By addonDebitAcct = By.xpath("//app-manage-addons-form/form/div/div[5]/div/input[1]");
 	public By addonCreditAcct = By.xpath("//app-manage-addons-form/form/div/div[6]/div/input[@id='CrAccountNumber_maskedInput']");
 	public By addonPaidByBorrBefClosing = By.xpath("//app-manage-addons-form/form/div[2]/div[6]/div/kendo-numerictextbox/span/input");
 	public By addonPaidByBorrAtClosing = By.xpath("//app-manage-addons-form/form/div[2]/div[7]/div/kendo-numerictextbox/span/input");
 	public By addonSalesStatus = By.xpath("//app-addons-sales-history/form/div/div/div/div/kendo-dropdownlist/span/span[2]");
 	public By addonAdd = By.xpath("//app-manage-addons/kendo-panelbar//kendo-panelbar-item/div/div/div/div[3]/div[3]/div/div/button[text()='Add']");
 	public By addonRecordDetails = By.xpath("//*[@id=\"k-panelbar-4-item-default-4\"]/span/div/span[3][contains(text(),'0')]");
 	public By addNewAddon = By.xpath("//app-manage-addons/kendo-panelbar/kendo-panelbar-item/div/div/div/div[2]/div/a");

 	// Loan Calculator
 	
 	public By salesstatus = By.xpath("//label[text()=' Sales Status '] /../kendo-dropdownlist/span/span[@class='k-input']");
 	public By loanCalcsave = By.xpath("//button[text()='Save']");
 	public By collapsePayprot = By.xpath("//*[@id='k-panelbar-2-item-default-2']/span/span");
 	public By contLoanAmt = By.xpath("//label[text()=' Loan Amount: ']/../kendo-numerictextbox/span/input");
 	public By loanCalcReqAmt = By.xpath("//label[text()=' Requested Amount ']/../kendo-numerictextbox/span/input");

 	// Disbursement

 	public By disbursementtab = By.xpath("//h4[text()='Loan Details']/../../following-sibling::*/kendo-tabstrip/ul/li[4]/span[contains(text(),'DISBURSEMENTS')]");
 	public By addNewDisb = By.xpath("//div/a[2]");
 	public By disbPaymentMethod = By.xpath("//label[text()=' Payment Method ']/../kendo-dropdownlist/span/span[@class='k-select']");
 	public By disbPayableto = By.xpath("//label[text()=' Payable To ']/../div/kendo-combobox/span/span[@class='k-select']");
 	public By disbAmount = By.xpath("//label[text()=' Amount ']/../kendo-numerictextbox/span/input");
 	public By disbCreditAccount = By.xpath("//label[text()=' Credit Account ']/../input[@id='AccountNumber_maskedInput']");
 	public By disbDescription = By.xpath("//label[text()=' Description ']/../input");
 	public By disbReferenceNumber = By.xpath("//label[text()=' Reference Number ']/../input");
 	public By disbAdd1 = By.xpath("//label[text()=' Address 1 ']/../input[@id='FirstLine']");
 	public By disbAdd2 = By.xpath("//label[text()=' Address 2 ']/../input[@id='SecondLine']");
 	public By disbAdd3 = By.xpath("//label[text()=' Address 3 ']/../input[@id='ThirdLine']");
 	public By disbZipCode = By.xpath("//label[text()=' Zip Code ']/../div/input");
 	public By disbCity = By.xpath("//label[text()=' City ']/../input[@id='City']");
 	public By addDisb = By.xpath("//button[text()='Add']");

 	// Repayment Method
 	
 	public By repayMethod = By.xpath(" //label[text()=' Method '] /../kendo-dropdownlist/span/span[@class='k-select']");
 	public By repayBilling = By.xpath("//app-segment-button/div/label[1]");
 	public By repayMethodAccNo = By.xpath("//form//div/input[@id='RepayAccountNumber_maskedInput']");
 	public By repayMethodAccSuffix = By.xpath("//form//div/input[@id='RepayAccountSuffix_maskedInput']");
 	public By disbSave = By.xpath("//button[@type='submit']");

	
	//Conditions
	public By conditionsTab = By.xpath("//h4[text()='Loan Details']/../../following-sibling::* / kendo-tabstrip/ul/li[3]/span[text()='CONDITIONS']");
	public By titleCondMet = By.xpath("//p[text()='All owners on title must sign at Settlement']/../div//app-segment-button//label[@title='Met']");
    public By signedAppCondMet = By.xpath("//p[text()='Completed and Signed Application']/../div//app-segment-button//label[@title='Met']");
    public By proofIDCondWaived = By.xpath("//p[text()='Proof of Identification for all borrowers']/../div//app-segment-button//label[@title='Waived']");
	public By saveConditions = By.xpath("//app-conditions-container/fixed-actionbar//div/button[@type='submit']");
	
	//HMDA page objects
	public By HMDA = By.xpath("//a[text()='HMDA/CRA']");
	public By stateCode = By.xpath("//label[text()=' State Code ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By countyCode = By.xpath("//label[text()=' County Code ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By censusTract = By.xpath("//label[text()=' Census Tract ']/../kendo-dropdownlist/span/span[@class='k-select']");
	public By regCallDescription = By.xpath("//label[text()=' Description ']/../kendo-dropdownlist/span/span[@class='k-select']");
	public By saveCRA = By.xpath("//button[text()='Save CRA']");
	public By hmdaGovInfo = By.xpath("//div[@class='hmda-header']/../following-sibling::*//li[2]/span[@class='k-link']");
	public By Race1 = By.xpath("//label [@for='AmericanIndianOrAlaskanNative25']");
	public By race1Tribe = By.xpath("//input[@id='Tribe']");
	public By genderFemale = By.xpath("//label[@for='Female44']");
	public By ethnicityNotLatino= By.xpath("//label[@for='NotHispanicOrLatino52']");
	public By saveGovInfo = By.xpath("//button[@type='submit']");
	public By hmdaLoanData = By.xpath("//div[@class='hmda-header']/../following-sibling::*//li[3]/span[@class='k-link']");
	public By hmdaPropertyData = By.xpath("//div[@class='hmda-header']/../following-sibling::*//li[4]/span[@class='k-link']");
	public By hmdaLoanType = By.xpath("//label[text()=' HMDA Loan Type ']/../kendo-dropdownlist//span[@class='k-select']");
	public By hmdaLoanPurpose = By.xpath("//label[text()=' Loan Purpose ']/../kendo-dropdownlist//span[@class='k-select']");
	public By rateSpread = By.id("RateSpread");
	public By hoepaStatus = By.xpath("//label[text()=' HOEPA Status ']/../kendo-dropdownlist//span[@class='k-select']");
	public By prepaymentPenaltyTerm = By.xpath("//label[text()=' Prepayment Penalty Term ']/../kendo-numerictextbox/span/input");
	public By saveLoanData = By.xpath("//button[@type='submit']");
	public By propertyStateCode = By.xpath("//label[text()=' State Code ']/../kendo-dropdownlist//span[@class='k-select']");
	public By propertyCountyCode = By.xpath("//label[text()=' County Code ']/../kendo-dropdownlist//span[@class='k-select']");
	public By propertyCensusTract = By.id("CensusTract");
	public By affordableUnits = By.id("MultiFamilyAffordableUnits");
	public By totalUnits = By.id("TotalUnits");
	public By lienStatus = By.xpath("//label[text()=' Lien Status ']/../kendo-dropdownlist//span[@class='k-select']");
	public By savePropertyData = By.xpath("//button[@type='submit']");
	public By otherAsian = By.id("OtherAsianName");
	
	
	//Functions
	public void appMenu() {
		System.out.println("inside appMenu function to hover over app menu");
		// element.sync().waitForSpinner(60);
		element.sync().pause(20);
		// newfunc.mouseHover(Appmenu);
		System.out.println("hovered on App menu");
		element.click(appMenu, "");
		System.out.println("clicked App menu");
	}

	public void loanDetails() {
		try {
			Thread.sleep(5000);
			// element.sync().waitForElement(LoanDetails);
			element.click(loanDetails, "");
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
			element.click(feesAddons, "");
			System.out.println("clicked fees and addons tab");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addNewFee() {
		boolean Recordvalue = element.isDisplayed(feeRecordDetails);
		System.out.println(Recordvalue);

		if (Recordvalue) {
			element.click(addNewFee, "");
			element.sync().pause(10);
		}
	}

	public void selectFeesDesc(String feeDesc) {
		String feedescstr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + feeDesc + "']";
		By selectfeedesc = By.xpath(feedescstr);
		element.sync().waitForElement(feesDesc);
		element.click(feesDesc, "Click on Desc DropDown");
		element.click(selectfeedesc, "");

	}

	public void enterFeesPayableTo(String feePayableto) {
		element.sync().pause(10);
		element.click(feePayableTo, "");
		element.sendKeys(feePayableTo, feePayableto, "");
	}

	public void enterFeesDebitAcct(String feeDebitacct) {
		boolean eledisplayed = element.isDisplayed(feeDebitAcct);
		if (!eledisplayed) {
			element.jsExecute().scrollToElement(feesDesc);
		}
		element.click(feeDebitAcct, "");
		element.sendKeys(feeDebitAcct, feeDebitacct, "");
	}

	public void enterFeesCreditAcct(String feeCreditacct) {

		element.click(feeCreditAcct, "");
		element.sendKeys(feeCreditAcct, feeCreditacct, "");
	}

	public void enterFeePaidbyBorrBefClosing(String beforeClosing) {

		element.click(feePaidByBorrBefClosing, "");
		element.sendKeys(feePaidByBorrBefClosing, beforeClosing, "");
		element.click(feePaidByBorrAtClosing, "");
		element.sync().pause(5);
		element.jsExecute().scrollToElement(feeDebitAcct);
	}

	public void feeAdd() {
		element.click(feeAdd, "");
	}

	// IMD Addons

	public void addNewAddOn() {
		boolean Recordvalue2 = element.isDisplayed(addonRecordDetails);

		System.out.println(Recordvalue2);

		if (!Recordvalue2) {
			element.click(addNewAddon, "");
			element.sync().pause(10);
		}
	}

	public void selectAddonDesc(String Addondesc) {
		String addondescstr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + Addondesc
				+ "']";
		By selectaddondesc = By.xpath(addondescstr);
		element.sync().waitForElement(addonDesc);
		element.click(addonDesc, "Click on Desc DropDown");
		element.click(selectaddondesc, "");

	}

	public void selectAddonType(String addontype) {
		String Addontype = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + addontype + "']";
		By selectaddontype = By.xpath(Addontype);
		element.sync().waitForElement(addonType);
		element.click(addonType, "Click on Type DropDown");
		element.click(selectaddontype, "");
	}

	public void enteAddonPayableTo(String addonpayableto) {
		element.sync().pause(10);
		element.click(addonPayableTo, "");
		element.sendKeys(addonPayableTo, addonpayableto, "");
	}

	public void enterAddonDebitAcct(String addondebitacct) {
		boolean debitaactdisp = element.isDisplayed(addonDebitAcct);
		if (!debitaactdisp) {
			element.jsExecute().scrollToElement(addonDesc);
		}

		element.clear(addonDebitAcct);
		element.sendKeys(addonDebitAcct, addondebitacct, "");

	}

	public void enterAddonCreditAcct(String addoncreditacct) {

		element.click(addonCreditAcct, "");
		element.sendKeys(addonCreditAcct, addoncreditacct, "");
	}

	public void enterAddonPaidbyBorrBefClosing(String addonbeforeclosing) {

		element.click(addonPaidByBorrBefClosing, "");
		element.sendKeys(addonPaidByBorrBefClosing, addonbeforeclosing, "");
		element.click(addonPaidByBorrAtClosing, "");
		element.sync().pause(5);
		element.jsExecute().scrollToElement(addonDesc);
	}

	public void selectAddonSalesStatus(String addonSalesstatus) {
		element.jsExecute().scrollToBottom();
		String Addonsalesstatus = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ addonSalesstatus + "']";
		By selectaddonsalesstatus = By.xpath(Addonsalesstatus);
		element.sync().waitForElement(addonSalesStatus);
		element.click(addonSalesStatus, "Click on Salesstatus DropDown");
		element.click(selectaddonsalesstatus, "");
	}

	public void AddonAdd() {
		element.click(addonAdd, "");
	}

	public void selectPPSalesStatus(String salesStatusPP) {
		element.jsExecute().scrollToElement(loanCalcReqAmt);
		String PPSalesStatus = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + salesStatusPP
				+ "']";
		By PPSalesStatusdesc = By.xpath(PPSalesStatus);
		element.sync().pause(5);
		element.click(salesstatus, "Click on Sales status DropDown");
		element.click(PPSalesStatusdesc, "");
		element.sync().pause(5);
		// element.sync().elementToBeClickable(LoanCalcsave);
		// element.click(LoanCalcsave,"");

	}

	public void enterContractDetails(String loanAmt) {
		// element.click(CollapseLoanCalc, "");
		 element.sync().pause(5);
		// element.click(CollapsePayprot,"");
		element.jsExecute().scrollToElement(salesstatus);
		element.sync().pause(5);
		element.click(contLoanAmt, "");
		element.sendKeys(contLoanAmt, loanAmt, "");
		element.click(loanCalcsave, "");
		element.sync().pause(5);
	}

	public void clickDisbtab() {
		element.jsExecute().scrollDownTo(0, 0);
		element.sync().pause(10);
		element.click(disbursementtab, "");
		element.sync().pause(10);
	}

	public void clickAddNewDisb() {
		element.click(addNewDisb, "");
		element.sync().pause(5);
	}

	public void selectDisbPaymentMethod(String paymentMeth) {
		String DisbPaymentMethodstr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ paymentMeth + "']";
		By Paymentmethoddesc = By.xpath(DisbPaymentMethodstr);
		element.sync().pause(5);
		element.click(disbPaymentMethod, "");
		element.click(Paymentmethoddesc, "");
		element.sync().pause(5);

	}

	public void selectDisbPayableTo(String payableTo) {
		String DisbPayableToStr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + payableTo
				+ "']";
		By DisbPayableToDesc = By.xpath(DisbPayableToStr);
		element.sync().waitForElement(disbPayableto);
		element.click(disbPayableto, "");
		element.click(DisbPayableToDesc, "");
		element.sync().pause(5);

	}

	public void enterDisbAmount(String disbAmount1) {
		element.click(disbAmount, "");
		element.sendKeys(disbAmount, disbAmount1, "");
	}

	public void enterDisbCredAcct(String disbCredact) {
		element.click(disbCreditAccount, "");
		element.sendKeys(disbCreditAccount, disbCredact, "");
	}

	public void enterDisbDesc(String disbDesc) {
		element.jsExecute().scrollToElement(addNewDisb);
		element.click(disbDescription, "");
		element.sendKeys(disbDescription, disbDesc, "");
	}

	public void enterDisbRefNo(String disbRefno) {
		element.click(disbReferenceNumber, "");
		element.sendKeys(disbReferenceNumber, disbRefno, "");
	}

	public void enterDisbAdd1(String disburseAdd1) {
		element.click(disbAdd1, "");
		element.sendKeys(disbAdd1, disburseAdd1, "");

	}

	public void enterDisbAdd2(String disburseAdd2) {
		element.click(disbAdd2, "");
		element.sendKeys(disbAdd2, disburseAdd2, "");

	}

	public void enterDisbAdd3(String disburseAdd3) {
		element.click(disbAdd3, "");
		element.sendKeys(disbAdd3, disburseAdd3, "");

	}

	public void enterDisbzipcode(String disbZipcode) {
		element.jsExecute().scrollToElement(disbAdd1);
		element.sync().pause(2);
		element.click(disbZipCode, "");
		element.sendKeys(disbZipCode, disbZipcode, "");
		element.click(disbCity, "");
		element.sync().pause(5);
		element.click(addDisb, "");
		element.sync().pause(10);

	}

	public void selectCashRepayMethod(String repaymentMethod) {
		element.jsExecute().scrollToBottom();
		String RepayMethodStr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + repaymentMethod
				+ "']";
		By RepayMethodDesc = By.xpath(RepayMethodStr);
		// element.sync().waitForElement(DisbPayableto);
		element.click(repayMethod, "");
		element.click(RepayMethodDesc, "");
		element.sync().pause(5);
		element.click(repayBilling, "");
		element.sync().pause(5);
		element.click(disbSave, "");
		element.sync().pause(10);

	}
	
	public void selectTransferRepayMethod(String repayMethod1) {
		element.jsExecute().scrollToBottom();
		String RepayMethodStr1 = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + repayMethod1
				+ "']";
		By RepayMethodDesc1 = By.xpath(RepayMethodStr1);
		// element.sync().waitForElement(DisbPayableto);
		element.click(repayMethod, "");
		element.click(RepayMethodDesc1, "");
		element.sync().pause(5);
	}
	
	public void enterRepayMethodAccNo(String repayMethodAccno)
	{
		element.click(repayMethodAccNo, "");
		element.sendKeys(repayMethodAccNo, repayMethodAccno, "");
			}
	
	public void enterRepayMethodAccSuffix(String accSuffix)
	{
		element.click(repayMethodAccSuffix, "");
		element.sendKeys(repayMethodAccSuffix, accSuffix, "");
		element.click(disbSave, "");
		element.sync().pause(5);
	}


	
	
	public void clickActions() {
		try {
			element.sync().waitForElement(Actions);
			Thread.sleep(10000);
			element.click(Actions, "");
			System.out.println("Clicked on actions menu");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickChange() {
		element.click(Change, "");
		// element.wait().until(ExpectedConditions.visibilityOfElementLocated(Change));
	}

	public void clickChangeProduct() {
		element.click(changeProduct, "");
	}

	public void selectProductforChange(String prodName) {
		try {
			String productstr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + prodName
					+ "']";
			By selectprodname = By.xpath(productstr);
			Thread.sleep(20000);
			element.click(productDropDown, "Click on Product DropDown");
			element.click(selectprodname, "");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectPurposeforChange(String purpose) {
		try {
			String purposestr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + purpose
					+ "']";
			By selectpurpose = By.xpath(purposestr);
			Thread.sleep(20000);
			element.click(purposeDropDown, "Click on Purpose DropDown");
			element.click(selectpurpose, "");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enterBranchforChange(String branchName) {
		element.click(cpBranch, "");
		element.sendKeys(cpBranch, branchName, "");
	}

	public void clickOKforChange() {
		element.click(okBttn, "");

	}

	public void clickYesbttn() {
		element.click(yesBttn, "");

	}

	public void appInfo() {
		element.click(appInfo, "");
	}

	/*
	 * public void clickChangeProduct2() { element.click(ChangeProduct2, ""); }
	 */

	public void clickWorkflow() {
		element.sync().pause(5);
		element.click(Workflow, "");
	}

	public void clickWithdraw() {
		element.click(Withdraw, "");
	}

	public void selectWithdrawalReason(String reason) {
		try {
			String withdrawalreasonstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
					+ reason + "']";
			By selectwithdrawalreason = By.xpath(withdrawalreasonstring);
			Thread.sleep(20000);
			element.click(withdrawalReason, "Click on reason DropDown");
			element.click(selectwithdrawalreason, "");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickWithdrawOK() {
		element.click(withdrawOK, "");
	}

	public void withdrawAppYES() {
		element.click(withdrawAppYESbttn, "");
	}

	public void clickDelMethod() {

		try {
			Thread.sleep(5000);
			element.click(deliveryMethod, "");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("clicked del method tab");
	}

	public void selectDeliveryMethod(String delMethod)

	{
		try {
			String delmethodstr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" +delMethod+ "']";
			By selectdelmethod = By.xpath(delmethodstr);
			Thread.sleep(20000);
			element.click(delMethodDropdwn, "Click on  DropDown");
			element.click(selectdelmethod, "");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void checkallConditions() {
		element.jsExecute().scrollDownTo(0, 0);
		element.click(conditionsTab, "");
		System.out.println("in conditions tab");
		element.click(titleCondMet,"");
		element.click(signedAppCondMet , "");
		element.click(proofIDCondWaived , "");
		element.click(saveConditions, "");
		
	}
	
	
	public void clickSubmitToWorkflow()
	{
		element.click(submitToWorkflow, "");
		element.click(submitToWorkflowOK, "");
		element.sync().waitForInvisibility(closeWorksheetbutton);
		element.sync().waitForElement(closeActionStatusWindow);
		element.sync().pause(5);
		element.click(closeActionStatusWindow,"");
		
	}
	
	//Approve
	
	public void clickDecisionMenu()
	{
		element.sync().elementToBeClickable(decisionMenu);
		element.sync().pause(10);
		element.click(decisionMenu, "");
	}
	
	public void clickApprove()
	{
		element.sync().waitForElement(approve);
		element.click(approve, "");
	}
	
	public void  enterDecisionUserName(String decLoginid)
	{
		element.sendKeys(decisionLoginUserName, decLoginid, "");
	}
	
	public void  enterDecisionPW(String decLoginpw)
	{
		element.sendKeys(decisionLoginPassword, decLoginpw, "");
	}
	
	public void decisionLoginOk()
	{
		element.click(decisionLoginOK, "");
	}
	
	public void decisionApprove()
	{
		element.sync().pause(10);
		element.click(decisionOk, "");
		element.sync().waitForInvisibility(closeWorksheetbutton);
		element.sync().waitForElement(closeActionStatusWindow);
		element.click(closeActionStatusWindow, "");
		
	}
	
	
	public void clickFundingprep()
	{
		element.sync().pause(10);
		element.click(fundingPrep, "");
		element.sync().pause(15);
	}
	
	public void clickAcceptFunding()
	{
		element.sync().pause(10);
		element.click(acceptFunding, "");
		element.sync().pause(5);
		
	}
	
	public void clickAcceptFundingClose()
	{
		element.sync().pause(15);
		//element.click(AcceptFundingClose, "");
	//	element.sync().waitForInvisibility(closeWorksheetbutton);
	//	element.sync().waitForElement(closeActionStatusWindow);
		element.click(acceptFundingClose, "");
		
	}
	
	public void clickHMDAMenu()
	{
		element.sync().pause(10);
		element.click(appMenu, "");
		element.click(HMDA, "");
		element.sync().pause(5);
	}
	
	public void selectCRAStateCode(String craStateCode)
	{
		element.sync().pause(5);
		String Statecodestr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" +craStateCode+ "']";
		By selectcracode = By.xpath(Statecodestr);
		element.click(stateCode, "Click on  DropDown");
		element.click(selectcracode, "");
	}
	
	public void selectCountyCode(String countyCode1)
	{
		String Countycodestr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" +countyCode1+ "']";
		By selectcountycode = By.xpath(Countycodestr);
		element.click(countyCode, "Click on  DropDown");
		element.click(selectcountycode, "");
	}
	
	public void selectCensusTract(String ct)
	{
		//float ct = Float.parseFloat(censustract);
		String Censustractstr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" +ct+ "']";
		By selectcensustract = By.xpath(Censustractstr);
		element.click(censusTract, "Click on  DropDown");
		element.click(selectcensustract, "");
	}
	
	public void selectRegCallDesc(String regDesc)
	{
		String regcalldesc = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" +regDesc+ "']";
		By selectregcalldesct = By.xpath(regcalldesc);
		element.click(regCallDescription, "Click on  DropDown");
		element.click(selectregcalldesct, "");
	}
	
	public void saveCRA()
	{
	element.sync().pause(2);
	element.click(saveCRA, "");
	element.sync().pause(5);
	}
	
	public void clickHMDAGov()
	{
		element.jsExecute().scrollDownTo(0, 0);
		element.sync().pause(5);
		element.click(hmdaGovInfo, "");
	}
	
	public void selectHMDAoptions(String race)
	{
		element.click(Race1, "");
		element.click(race1Tribe, "");
		element.sendKeys(race1Tribe, race, "");
		element.jsExecute().scrollToElement(otherAsian);
		element.click(genderFemale , "");
		element.jsExecute().scrollToBottom();
		element.click(ethnicityNotLatino, "");
		element.click(saveGovInfo, "");
		element.sync().pause(5);
	}
	
	
	public void clickHMDALoanData()
	{
		element.jsExecute().scrollDownTo(0, 0);
		element.click(hmdaLoanData, "");
		element.sync().pause(5);
	}
	
	public void selectHMDALoanType(String loanType)
	{
		String loantypestr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" +loanType+ "']";
		By selectloantype = By.xpath(loantypestr);
		element.click(hmdaLoanType, "Click on  DropDown");
		element.click(selectloantype, "");
	}
	
	
	public void selectHMDALoanPurpose(String loanPurpose)
	{
		String loanpurposestr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" +loanPurpose+ "']";
		By selectloanpurpose = By.xpath(loanpurposestr);
		element.click(hmdaLoanPurpose, "Click on  DropDown");
		element.click(selectloanpurpose, "");
	}
	
	public void enterRateSpread(String rateSpread1)
	{
		element.jsExecute().scrollToBottom();
		element.sync().pause(2);
		element.sendKeys(rateSpread, rateSpread1, "");
	}
	
	public void selectHOEPAStatus(String hoepa)
	{
		String hoepastr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" +hoepa+ "']";
		By selecthoepa = By.xpath(hoepastr);
		element.click(hoepaStatus, "Click on  DropDown");
		element.click(selecthoepa, "");
	}
	
	public void enterPenaltyTerm(String penaltyTerm)
	{
		element.sendKeys(prepaymentPenaltyTerm, penaltyTerm, "");
	}
	
	public void saveLoanData()
	{
		element.click(saveLoanData, "");
		element.sync().pause(5);
	}
	
	public void clickHMDALoanProperty()
	{
		element.jsExecute().scrollDownTo(0, 0);
		element.click(hmdaPropertyData, "");
		element.sync().pause(2);
	}
	public void selectPropStateCode(String propStateCode)
	{
		String propStateCodestr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" +propStateCode+ "']";
		By selectpropstatecode = By.xpath(propStateCodestr);
		element.click(propertyStateCode, "Click on  DropDown");
		element.click(selectpropstatecode, "");
	}
	public void selectpropertyCountyCode(String propCountyCode)
	{
		String propcountycodestr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" +propCountyCode+ "']";
		By selectpropcountycode = By.xpath(propcountycodestr);
		element.click(propertyCountyCode, "Click on  DropDown");
		element.click(selectpropcountycode, "");
	}
	
	public void enterPropCensusTract(String propCensusTract)
	{
		element.sendKeys(propertyCensusTract, propCensusTract, "");
	}
	
	public void enterAffordableUnits(String aUnits)
	{
		element.sendKeys(affordableUnits, aUnits, "");
	}
	
	public void enterTotalUnits(String totalUnits1)
	{
		element.sendKeys(totalUnits, totalUnits1, "");
	}
	
	public void savePropertyData()
	{
		element.click(savePropertyData, "");
	}
	
	public void clickBookToHost()
	{
		element.click(bookToHost, "");
		element.click(confirmBTH, "");
		element.sync().pause(10);
		element.click(closeBTH, "");
		element.sync().pause(10);
		
	}
	
	public void keyData()
	{
		element.click(KeyData, "");
	}
	
}

