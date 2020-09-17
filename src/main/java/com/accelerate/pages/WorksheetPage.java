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
	// BrowserElement newfunc = new BrowserElement();

	public By Actions = By.xpath("//a[@title='Actions']/i[1]");
	public By Change = By.xpath("//li[7]/button[@tabindex='0']");
	// public By ChangeProduct =
	// By.xpath("//span[@id='drawerId-3_label']/../following-sibling::*/div/div/div/div/kendo-tabstrip/ul/li[2]");
	// public By ChangeProduct =
	// By.xpath("//span[contains(text(),'Change')]/../following-sibling::*/div/div/div/div/kendo-tabstrip/ul/li[@id='k-tabstrip-tab-1']");
	public By ChangeProduct = By
			.xpath("//span[@id='drawerId-5_label']/../following-sibling::*/div/div/div/div/kendo-tabstrip/ul/li[2]");
	public By ProductDropDown = By
			.xpath("//label[contains(text(),'Product')]/../kendo-dropdownlist/span/span[@class='k-input']");
	public By PurposeDropDown = By
			.xpath("//label[contains(text(),'Purpose')]/../kendo-dropdownlist/span/span[@class='k-input']");
	public By CPBranch = By.xpath("//label[@for='ProductBranch']/../div/kendo-autocomplete/kendo-searchbar/input");
	public By OKBttn = By.xpath("//button[contains(text(),'OK')]");
	public By YesBttn = By.xpath("//button[contains(text(),'Yes')]");
	public By AppInfo = By.xpath("//i[contains(text(),'info_outline ')]");
	public By DecisionMenu = By.xpath("//i[text()='gavel']");
	public By Approve = By.xpath("//velocity-leftnav//div[2]//li[1]/button");
	public By DecisionLoginUserName = By.xpath("//label[text()=' User Name ']/../input");
	public By DecisionLoginPassword = By.xpath("//label[text()=' Password ']/..//input");
	public By DecisionLoginOK = By.xpath("//button[text()='OK']");
	public By DecisionOk = By.xpath("//button[text()='Ok']");
	public By Workflow = By.xpath("//li[3]/button[@tabindex='0']");
	public By Withdraw = By.xpath("//li[4]/button[@tabindex='0']");
	public By WithdrawalReason = By
			.xpath("//label[text()='Withdrawal Reason']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By WithdrawOK = By.xpath("//button[text()='OK']");
	public By WithdrawAppYESbttn = By.xpath(
			"//div[text()='Withdraw Application']/../following-sibling::*/following-sibling::*/button[text()=' Yes ']");
	// public By DeliveryMethod = By.xpath("//li[@id='k-tabstrip-tab-3']/span");
	public By DeliveryMethod = By.xpath("//div/div/div/div/div/kendo-tabstrip/ul/li[@id='k-tabstrip-tab-3']/span");
	public By DelMethodDropdwn = By
			.xpath("//label[text()='Delivery Method']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By SubmitToWorkflow = By.xpath("//li[1]/button[@tabindex='0']");
	public By SubmitToWorkflowOK = By.xpath("//button[text()='OK']");
	public By CloseWorksheetbutton = By.xpath("//button[text='Close Worksheet']");
	public By CloseActionStatusWindow = By.xpath("//button[text()='Close']");

	
	
	
	/*
	 * public By Appmenu =
	 * By.xpath("//a[@title='Application Menu']/i[text()='menu']"); public By
	 * LoanDetails = By.xpath("//a[text()='Loan Details']");
	 */

	// Fees
	/*
	 * public By FeesAddons = By.
	 * xpath("//h4[text()='Loan Details']/../../following-sibling::* / kendo-tabstrip/ul/li/following-sibling::* /span[contains(text(),'FEES & ADD ONS')]"
	 * ); public By FeesDesc = By.xpath(
	 * "//app-manage-fees-form/div[2]/form/div/div[1]/div/kendo-dropdownlist/span/span[2]"
	 * ); public By FeeType = By.
	 * xpath("//label[text()=' Fee Type ']/../kendo-dropdownlist/span/span[2]");
	 * public By FeePayableTo = By.xpath(
	 * "//app-manage-fees-form/div[2]/form/div/div[4]/div/input[@id='PayableTo']"
	 * ); public By FeeDebitAcct =
	 * By.xpath("//app-manage-fees-form/div[2]/form/div/div[5]/div/input[1]");
	 * public By FeeCreditAcct =
	 * By.xpath("//app-manage-fees-form/div[2]/form/div/div[6]/div/input[1]");
	 * public By FeePaidByBorrBefClosing = By.xpath(
	 * "//app-manage-fees-form/div[2]/form/div[2]/div[6]/div/kendo-numerictextbox/span/input"
	 * ); public By FeePaidByBorrAtClosing = By.xpath(
	 * "//app-manage-fees-form/div[2]/form/div[2]/div[7]/div/kendo-numerictextbox/span/input"
	 * ); public By FeeNoOfMonths = By.xpath(
	 * "//app-manage-fees-form/div[2]/form/div[2]/div[9]/div/kendo-numerictextbox/span/input"
	 * ); public By FeeAdd = By.xpath(
	 * "//app-manage-fees/kendo-panelbar//kendo-panelbar-item/div/div/div/div[3]/div[3]/div/div/button[text()='Add']"
	 * ); public By FeeRecordDetails = By.
	 * xpath("//*[@id='k-panelbar-3-item-default-0']/span/div/span[3][not(contains(text(),'0 Record'))]"
	 * ); public By AddNewFee = By.xpath(
	 * "//app-manage-fees/kendo-panelbar/kendo-panelbar-item/div/div/div/div[2]/div/a"
	 * );
	 * 
	 * 
	 * 
	 * //Addons
	 * 
	 * public By AddonDesc = By.
	 * xpath("//app-manage-addons-form/form/div/div/div/label[text()=' Description ']/../kendo-dropdownlist/span/span[2]"
	 * ); public By AddonType = By.
	 * xpath("//label[text()=' Add On Type ']/../kendo-dropdownlist/span/span[2]"
	 * ); public By AddonPayableTo = By.xpath(
	 * "//app-manage-addons-form/form/div/div[4]/div/input[@id='PayableTo']");
	 * //public By AddonDebitAcct = By.xpath(
	 * "//app-manage-addons-form/form/div/div[5]/div/input[@id='DbAccountNumber']"
	 * ); public By AddonDebitAcct = By.xpath(
	 * "//app-manage-addons-form/form/div/div[5]/div/input[@id='DbAccountNumber_maskedInput']"
	 * ); //public By AddonCreditAcct = By.xpath(
	 * "//app-manage-addons-form/form/div/div[6]/div/input[@id='CrAccountNumber']"
	 * ); public By AddonCreditAcct = By.xpath(
	 * "//app-manage-addons-form/form/div/div[6]/div/input[@id='CrAccountNumber_maskedInput']"
	 * ); public By AddonPaidByBorrBefClosing = By.xpath(
	 * "//app-manage-addons-form/form/div[2]/div[6]/div/kendo-numerictextbox/span/input"
	 * ); public By AddonPaidByBorrAtClosing = By.xpath(
	 * "//app-manage-addons-form/form/div[2]/div[7]/div/kendo-numerictextbox/span/input"
	 * ); public By AddonSalesStatus = By.xpath(
	 * "//app-addons-sales-history/form/div/div/div/div/kendo-dropdownlist/span/span[2]"
	 * ); public By AddonAdd = By.xpath(
	 * "//app-manage-addons/kendo-panelbar//kendo-panelbar-item/div/div/div/div[3]/div[3]/div/div/button[text()='Add']"
	 * ); public By AddonRecordDetails = By.xpath(
	 * "//*[@id=\"k-panelbar-4-item-default-4\"]/span/div/span[3][contains(text(),'0')]"
	 * ); public By AddNewAddon = By.xpath(
	 * "//app-manage-addons/kendo-panelbar/kendo-panelbar-item/div/div/div/div[2]/div/a"
	 * );
	 */

	//Conditions
	public By Conditionstab = By.xpath(
			"//h4[text()='Loan Details']/../../following-sibling::* / kendo-tabstrip/ul/li[3]/span[text()='CONDITIONS']");
	public By TitleCondMet = By.xpath("//p[text()='All owners on title must sign at Settlement']/../div//app-segment-button//label[@title='Met']");
    public By SignedAppCondMet = By.xpath("//p[text()='Completed and Signed Application']/../div//app-segment-button//label[@title='Met']");
    public By ProofIDCondWaived = By.xpath("//p[text()='Proof of Identification for all borrowers']/../div//app-segment-button//label[@title='Waived']");
	public By SaveConditions = By.xpath("//app-conditions-container/fixed-actionbar//div/button[@type='submit']");
	
	
	
	//Functions
	public void clickActions() {
		try {
			Thread.sleep(5000);
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
		element.click(ChangeProduct, "");
	}

	public void selectProductforChange(String prodname) {
		try {
			String productstr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + prodname
					+ "']";
			By selectprodname = By.xpath(productstr);
			Thread.sleep(20000);
			element.click(ProductDropDown, "Click on Product DropDown");
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
			element.click(PurposeDropDown, "Click on Purpose DropDown");
			element.click(selectpurpose, "");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enterBranchforChange(String Branchname) {
		element.click(CPBranch, "");
		element.sendKeys(CPBranch, Branchname, "");
	}

	public void clickOKforChange() {
		element.click(OKBttn, "");

	}

	public void clickYesbttn() {
		element.click(YesBttn, "");

	}

	public void appInfo() {
		element.click(AppInfo, "");
	}

	/*
	 * public void clickChangeProduct2() { element.click(ChangeProduct2, ""); }
	 */

	public void clickWorkflow() {
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
			element.click(WithdrawalReason, "Click on reason DropDown");
			element.click(selectwithdrawalreason, "");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickWithdrawOK() {
		element.click(WithdrawOK, "");
	}

	public void withdrawAppYES() {
		element.click(WithdrawAppYESbttn, "");
	}

	public void clickDelMethod() {

		try {
			Thread.sleep(5000);
			element.click(DeliveryMethod, "");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("clicked del method tab");
	}

	public void selectDeliveryMethod(String delmethod)

	{
		try {
			String delmethodstr = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + delmethod
					+ "']";
			By selectdelmethod = By.xpath(delmethodstr);
			Thread.sleep(20000);
			element.click(DelMethodDropdwn, "Click on  DropDown");
			element.click(selectdelmethod, "");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * //Add new Fees and Addons public void appMenu() {
	 * System.out.println("inside appMenu function to hover over app menu");
	 * //element.sync().waitForSpinner(60); element.sync().pause(20); //
	 * newfunc.mouseHover(Appmenu); System.out.println("hovered on App menu");
	 * element.click(Appmenu,""); System.out.println("clicked App menu"); }
	 * 
	 * public void loanDetails() { try { Thread.sleep(20000); //
	 * element.sync().waitForElement(LoanDetails);
	 * element.click(LoanDetails,"");
	 * System.out.println("clicked Loan details menu"); Thread.sleep(20000); }
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * 
	 * public void feesAddons() { try { Thread.sleep(30000); //
	 * element.sync().waitForElement(LoanDetails); element.click(FeesAddons,"");
	 * System.out.println("clicked fees and addons tab"); Thread.sleep(20000); }
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } public void addNewFee() { boolean Recordvalue =
	 * element.isDisplayed(FeeRecordDetails); System.out.println(Recordvalue);
	 * 
	 * if (Recordvalue) { element.click(AddNewFee, "");
	 * element.sync().pause(10); } }
	 * 
	 * public void selectFeesDesc(String feedesc) { String feedescstr =
	 * "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"+
	 * feedesc+"']"; By selectfeedesc = By.xpath(feedescstr);
	 * element.sync().waitForElement(FeesDesc); element.click(FeesDesc,
	 * "Click on Desc DropDown"); element.click(selectfeedesc, "");
	 * 
	 * }
	 * 
	 * public void enterFeesPayableTo(String feepayableto) {
	 * element.sync().pause(10); element.click(FeePayableTo, "");
	 * element.sendKeys(FeePayableTo, feepayableto, ""); }
	 * 
	 * public void enterFeesDebitAcct(String feedebitacct) { boolean
	 * eledisplayed = element.isDisplayed(FeeDebitAcct); if(!eledisplayed) {
	 * element.jsExecute().scrollToElement(FeesDesc); }
	 * element.click(FeeDebitAcct, ""); element.sendKeys(FeeDebitAcct,
	 * feedebitacct, ""); }
	 * 
	 * 
	 * 
	 * public void enterFeesCreditAcct(String feecreditacct) {
	 * 
	 * element.click(FeeCreditAcct, ""); element.sendKeys(FeeCreditAcct,
	 * feecreditacct, ""); }
	 * 
	 * public void enterFeePaidbyBorrBefClosing(String beforeclosing) {
	 * 
	 * element.click(FeePaidByBorrBefClosing,"");
	 * element.sendKeys(FeePaidByBorrBefClosing, beforeclosing, "");
	 * element.click(FeePaidByBorrAtClosing,""); element.sync().pause(5);
	 * element.jsExecute().scrollToElement(FeeDebitAcct); }
	 * 
	 * public void feeAdd() { element.click(FeeAdd,""); }
	 * 
	 * //IMD Addons
	 * 
	 * public void addNewAddOn() { boolean Recordvalue2 =
	 * element.isDisplayed(AddonRecordDetails);
	 * 
	 * System.out.println(Recordvalue2);
	 * 
	 * if (!Recordvalue2) { element.click(AddNewAddon, "");
	 * element.sync().pause(10); } } public void selectAddonDesc(String
	 * addondesc) { String addondescstr =
	 * "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"+
	 * addondesc+"']"; By selectaddondesc = By.xpath(addondescstr);
	 * element.sync().waitForElement(AddonDesc); element.click(AddonDesc,
	 * "Click on Desc DropDown"); element.click(selectaddondesc, "");
	 * 
	 * }
	 * 
	 * public void selectAddonType(String addontype) { String Addontype =
	 * "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"+
	 * addontype+"']"; By selectaddontype = By.xpath(Addontype);
	 * element.sync().waitForElement(AddonType); element.click(AddonType,
	 * "Click on Type DropDown"); element.click(selectaddontype, ""); }
	 * 
	 * public void enteAddonPayableTo(String addonpayableto) {
	 * element.sync().pause(10); element.click(AddonPayableTo, "");
	 * element.sendKeys(AddonPayableTo, addonpayableto, ""); }
	 * 
	 * public void enterAddonDebitAcct(String addondebitacct) { boolean
	 * debitaactdisp = element.isDisplayed(AddonDebitAcct); if(!debitaactdisp) {
	 * element.jsExecute().scrollToElement(AddonDesc); }
	 * 
	 * element.clear(AddonDebitAcct); element.sendKeys(AddonDebitAcct,
	 * addondebitacct, "");
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void enterAddonCreditAcct(String addoncreditacct) {
	 * 
	 * element.click(AddonCreditAcct, ""); element.sendKeys(AddonCreditAcct,
	 * addoncreditacct, ""); }
	 * 
	 * public void enterAddonPaidbyBorrBefClosing(String Addonbeforeclosing) {
	 * 
	 * element.click(AddonPaidByBorrBefClosing,"");
	 * element.sendKeys(AddonPaidByBorrBefClosing, Addonbeforeclosing, "");
	 * element.click(AddonPaidByBorrAtClosing,""); element.sync().pause(5);
	 * element.jsExecute().scrollToElement(AddonDesc); } public void
	 * selectAddonSalesStatus(String addonsalesstatus) {
	 * element.jsExecute().scrollToBottom(); String Addonsalesstatus =
	 * "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"+
	 * addonsalesstatus+"']"; By selectaddonsalesstatus =
	 * By.xpath(Addonsalesstatus);
	 * element.sync().waitForElement(AddonSalesStatus);
	 * element.click(AddonSalesStatus, "Click on Salesstatus DropDown");
	 * element.click(selectaddonsalesstatus, ""); }
	 * 
	 * public void AddonAdd() { element.click(AddonAdd,""); }
	 */

	public void checkallConditions() {
		element.jsExecute().scrollDownTo(0, 0);
		element.click(Conditionstab, "");
		System.out.println("in conditions tab");
		element.click(TitleCondMet,"");
		element.click(SignedAppCondMet , "");
		element.click(ProofIDCondWaived , "");
		element.click(SaveConditions, "");
		
	}
	
	
	public void clickSubmitToWorkflow()
	{
		element.click(SubmitToWorkflow, "");
		element.click(SubmitToWorkflowOK, "");
		element.sync().waitForInvisibility(CloseWorksheetbutton);
		element.sync().waitForElement(CloseActionStatusWindow);
		element.click(CloseActionStatusWindow,"");
		
	}
	
	//Approve
	
	public void clickDecisionMenu()
	{
		element.sync().elementToBeClickable(DecisionMenu);
		element.sync().pause(10);
		element.click(DecisionMenu, "");
	}
	
	public void clickApprove()
	{
		element.sync().waitForElement(Approve);
		element.click(Approve, "");
	}
	
	public void  enterDecisionUserName(String decloginid)
	{
		element.sendKeys(DecisionLoginUserName, decloginid, "");
	}
	
	public void  enterDecisionPW(String decloginpw)
	{
		element.sendKeys(DecisionLoginPassword, decloginpw, "");
	}
	
	public void decisionLoginOk()
	{
		element.click(DecisionLoginOK, "");
	}
	
	public void decisionApprove()
	{
		element.sync().pause(10);
		element.click(DecisionOk, "");
		element.sync().waitForInvisibility(CloseWorksheetbutton);
		element.sync().waitForElement(CloseActionStatusWindow);
		element.click(CloseActionStatusWindow, "");
		
	}
}

