package com.accelerate.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.accelerate.BaseElementPage;
import com.fiserv.framework.interfaces.ISynchronization;
import com.fiserv.framework.interfaces.IKeyboardAndMouseActions;

public class DataEntryPage extends BaseElementPage {

	public void dataEntryPage0(String productname, String ReqAmount, String deliverymethod, String branch, String ssn,
			String firstname, String middlename, String lastname) {
	}

	public void applicantSummary(String instrel, String dateofbirth, String maritalstatus, String driverslicense,
			String occupation, String preferred, String phoneno, String email1) {
	}

	public void applicantAddress(String addtype, String addstatus, String yrs, String monthlypayment, String adddesc,
			String add1, String zipcode) {
	}

	public void applicantEmployment(String employername, String emplenyrs, String empamount) {
	}

	public void collateral(String category, String name, String owner, String estimatedvalue) {
	}

	public By productDropDown = By.xpath("//label[@for='Product']/..//span[@class='k-input']");
	public By requestedAmt = By.xpath(
			"//label[contains(text(), 'Requested Amount')]/parent::*/following-sibling::*/span/input[contains(@class,'k-input')]");
	public By Branch = By.xpath("//input[@class='k-input' and @role='textbox']");
	public By deliveryMethodDropDown = By
			.xpath("//label[contains(text(), 'Delivery Method')]/following-sibling::*/span/span[@class='k-input']");
	public By SSN = By.xpath("//input[@id='SSN']");
	public By firstName = By.xpath("//input[@id='FirstName']");
	// public By CopyDataClosebttn =
	// By.xpath("//span[@id='drawerId-3_label']/parent::*/button[@id='drawer-close-button-drawerId-3']/span[@role='presentation']");
	public By copyDataClosebttn = By.xpath(
			"//span[contains(text(),'Copy Data ')]/../button[@aria-label='Close Drawer']/span[@role='presentation']");
	public By middleName = By.xpath("//input[@id='MiddleName']");
	public By lastName = By.xpath("//input[@id='LastName']");
	public By saveBttn = By.xpath("//button[@type='submit']");
	public By cashPriceIV = By.xpath("//label[contains(text(),'Cash Price')]/../kendo-numerictextbox/span/input");
	public By Dealer = By.xpath("//label[contains(text(),'Dealer')]/../div/kendo-autocomplete/kendo-searchbar/input");

	// Applicant Summary
	public By accountNo = By.xpath("//input[@id='AccountNumber_maskedInput']");
	public By instRelationship = By.xpath(
			"//label[contains(text(), 'Institution Relationship')]/following-sibling::*/span/span[@class='k-input']");
	public By DOB = By.xpath(
			"//label[contains(text(), 'Date of Birth ')]/parent::*/kendo-datepicker/span/kendo-dateinput/span/input[contains(@class,'k-input')]");
	public By maritalstatusDropDown = By.xpath(
			"//label[contains(text(), 'Marital Status')]/parent::*/kendo-dropdownlist/span/span[@class='k-input']");
	public By dlNumber = By.xpath("//input[@id='DriversLicenseNumber']");
	public By Occupation = By.xpath("//input[@id='Occupation']");
	public By occupationLength = By.xpath(
			"//label[contains(text(), ' Occupation Length ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");
	public By preferredMethod = By.xpath(
			"//label[contains(text(),'Preferred Method')]/parent::*/div/kendo-dropdownlist/span/span[contains(@class,'k-input')]");
	public By homePhone = By.xpath("//input[@id='HomeNumber']");
	public By contactFavorite = By
			.xpath("//input[@id='HomeNumber']/parent::*/label[@title='Click to select as favorite']");
	public By Email1 = By.xpath("//label[contains(text(),' Email 1 ')]/../div/input[@id='Primary']");
	public By SSN2 = By.xpath("//input[@id='IdentificationNumber']");
	public By firstName2 = By.xpath("//input[@id='FirstName']");
	public By lastName2 = By.xpath("//input[@id='LastName']");
	public By cancelApplicant = By
			.xpath("//*[@id='k-panelbar-1-item-default-5']/div/div/div/div/ul/li[2]/button/text()");

	// Address fields
	public By Address = By.xpath("//span[@data-compname='adressInformation']/parent::*");
	public By addressType = By
			.xpath("//label[contains(text(), 'Address Type')]/../kendo-dropdownlist/span/span[@class='k-input']");
	public By addressStatus = By.xpath("//label[text()=' Status ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By lengthYrs = By.xpath(
			"//label[text()=' Length ']/../div/kendo-numerictextbox/span[contains(@class,'k-numeric')]/input[contains(@class,'k-input')]");
	public By monthlyPayment = By
			.xpath("//label[text()=' Monthly Payment ']/../kendo-numerictextbox/span/input[@role='spinbutton']");
	public By addressDesc = By.xpath("//textarea[@id='AddressDesc']");
	public By address1 = By.xpath("//input[@id='FirstLine']");
	public By ZipCode = By.xpath("//label[contains(text(),'Zip Code')]/../div/input[@type='text']");
	public By City = By.xpath("//input[@id='City']");
	public By addButton = By.xpath("//button[@type='submit' and contains(text(),'Add')]");
	public By quickSearch = By.xpath("//*[@id='search']");
	public By address1NAS = By.xpath("(//input[@id='FirstLine'])[1]");
    public By zipcodeNAS = By.xpath("(//label[contains(text(),'Zip Code')]/../div/input[@type='text'])[1]");
	
	// Employment fields
	public By Employers = By.xpath("//span[@data-compname = 'employersInformation']/parent::*");
	public By empAdd1 = By.xpath("//input[@id='FirstLine']");
	public By empZipCode = By.xpath("//label[contains(text(),'Zip Code')]/../div/input[@type='text']");
	public By empCity = By.xpath("//input[@id='City']");
	public By empSupervisor = By.xpath("//input[@id='SupervisorName']");
	public By empType = By.xpath("//label[text()=' Type ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By employerName = By
			.xpath("//label[contains(text(),' Employer Name ')]/following-sibling::input[@id='Name']");
	public By employerLengthYr = By.xpath(
			"//label[contains(text(),'Length')]/../div/kendo-numerictextbox/span[contains(@class,'k-numeric')]/input[contains(@class,'k-input')]");
	public By employerPosition = By.xpath("//input[@id='PositionTitle']");
	public By employerAmount = By.xpath(
			"//label[contains(text(),' Amount ')]/../kendo-numerictextbox/span[contains(@class,'k-numeric')]/input[contains(@class,'k-input')]");
	public By Frequency = By.xpath(
			"//label[contains(text(),' Frequency ')]/../kendo-dropdownlist/span/span[contains(@class,'k-input')]");
	// public By Addbutton = By.xpath("//button[@type='submit']");
	public By CTRLM = By.xpath("//div[contains(text(), ' Ctrl + M')]");
	public By empAddress1NAS = By.xpath("(//input[@id='FirstLine'])[2]");
    public By empZipCodeNAS = By.xpath("(//label[contains(text(),'Zip Code')]/../div/input[@type='text'])[2]");

	// Income
	public By Income = By.xpath("//span[@data-compname = 'incomeInformation']/parent::*");
	public By addNewIncome = By.xpath("//a[@class='ml-auto mb-3 uppercase-link']/span");
	public By incomeType = By
			.xpath("//label[text()=' Income Type ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By incomeSource = By.xpath("//input[@id='SourceDescription']");
	public By incomeAmount = By.xpath(
			"//label[contains(text(), ' Amount ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");
	public By incomeAmountNAS = By.xpath("(//label[contains(text(), ' Amount ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')])[2]");

	// Asset
	public By Asset = By.xpath("//span[@data-compname = 'assestsInformation']/parent::*");
	public By assetType = By.xpath("//label[text()=' Asset Type ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By assetDescription = By.xpath("//textarea[@id='Description']");
	public By assetCashMarketValue = By.xpath(
			"//label[contains(text(),'Cash/Market Value ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");
	public By assetLoanBalance = By.xpath(
			"//label[contains(text(),'Loan Balance ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");
	// public By AssetAccountNumber =
	// By.xpath("//label[@for='AccountNumber']/../input[contains(@id,'AccountNumber')][1]");
	// public By AssetAccountNumber =
	// By.xpath("//label[@for='AccountNumber']/../div/input[@id='AccountNumber_maskedInput']");
	public By assetAccountNumber = By.xpath(
			"//label[contains(text(), 'Date Opened')]/../../..//label[contains(text(), 'Account Number')]//following::input[1] ");
	public By assetInstitution = By.xpath("//input[@id='InstitutionName']");
	public By assetDateOpened = By.xpath(
			"//label[contains(text(), 'Date Opened ')]/parent::*/kendo-datepicker/span/kendo-dateinput/span/input[contains(@class,'k-input')]");
	public By assetAddress1 = By.xpath("//input[@id='FirstLine']");
	public By assetZipCode = By.xpath("//label[contains(text(),'Zip Code')]/../div/input[@type='text']");
	public By assetAddress1NAS = By.xpath("(//input[@id='FirstLine'])[3]");
    public By assetZipCodeNAS = By.xpath("(//label[contains(text(),'Zip Code')]/../div/input[@type='text'])[3]");

	// Liabilities
	public By Liability = By.xpath("//span[@data-compname = 'liabilitiesInformation']/parent::*");
	public By liabilityType = By
			.xpath("//label[text()=' Liability Type ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By liabilityDescription = By.xpath("//textarea[@id='Description']");
	public By liabilityCashMarketValue = By.xpath(
			"//label[contains(text(),'Cash/Market Value ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");
	public By liabilityLoanBalance = By.xpath(
			"//label[contains(text(),'Loan Balance ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");
	public By liabilityAccountNumber = By.xpath(
			"//label[contains(text(), 'Date Opened')]/../../..//label[contains(text(), 'Account Number')]//following::input[1] ");
	public By liabilityInstitution = By.xpath("//input[@id='InstitutionName']");
	public By liabilityDateOpened = By.xpath(
			"//label[contains(text(), 'Date Opened ')]/parent::*/kendo-datepicker/span/kendo-dateinput/span/input[contains(@class,'k-input')]");
	public By liabilityAddress1 = By.xpath("//input[@id='FirstLine']");
	public By liabilityZipCode = By.xpath("//label[contains(text(),'Zip Code')]/../div/input[@type='text']");
	public By liabilityAddress1NAS = By.xpath("(//input[@id='FirstLine'])[4]");
    public By liabilityZipCodeNAS = By.xpath("(//label[contains(text(),'Zip Code')]/../div/input[@type='text'])[4]");

	// References
	public By References = By.xpath("//span[@data-compname = 'referencesInformation']/parent::*");
	public By referenceType = By
			.xpath("//label[text()=' Reference Type ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By referenceRelationship = By
			.xpath("//label[text()=' Relationship ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By referenceFirstName = By.xpath(
			"//div[text()=' Add New Reference ']/..//form/div/following-sibling::*/div/following-sibling::*/div/input[@id='FirstName']");
	public By referenceLastName = By.xpath(
			"//div[text()=' Add New Reference ']/..//form/div/following-sibling::*/div/following-sibling::*/div/input[@id='LastName']");
	public By referenceDOB = By.xpath(
			"//label[contains(text(),'Date Of Birth')]/../kendo-datepicker//kendo-dateinput//input[@class='k-input']");
	public By referencePhoneNumber = By.xpath("//input[@id='PhoneNumber']");
	public By referenceAddress1 = By.xpath("//input[@id='FirstLine']");
	public By referenceZipCode = By.xpath("//label[contains(text(),'Zip Code')]/../div/input[@type='text']");
	public By refAddress1NAS = By.xpath("(//input[@id='FirstLine'])[5]");
    public By refZipCodeNAS = By.xpath("(//label[contains(text(),'Zip Code')]/../div/input[@type='text'])[5]");
    public By refNASPhoneNumber = By.xpath("(//input[@id='PhoneNumber'])[2]");

	// Add Applicant
	public By addApplicant = By.xpath("//i[contains(text(),'person_add')]/..");
	public By regBCreditType = By.xpath("//button[text()='Yes']");

	// NAS
	public By communityProperty = By.xpath("//button[text()=' OK ']");
	public By borrowerType = By
			.xpath("//label[text()=' Borrower Type ']/../kendo-dropdownlist/span/span[@class='k-select']");
	public By Spouse = By.xpath("//label[text()=' Spouse ']/../kendo-dropdownlist/span/span[@class='k-select']");

	// ContractDetails

	public By roundPayment = By.xpath(
			"//*[@id=\"k-panelbar-2-item-default-6\"]/div/div/div[1]/form/div[1]/div[4]/velocity-form-checkbox/div/div/label");
	public By contractDetailsLoanAmount = By.xpath(
			"//div[@class='form-group']/label[contains(text(),'Loan Amount:')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");

	// Repayment Method
	public By rmTitle = By.xpath("//span[contains(text(),'Repayment Method')]");
	public By repaymentMethod = By.xpath(
			"//div[@id='RepaymentMethodID_column']/div/kendo-dropdownlist/span/span[contains(@class,'k-input')]");
	public By rmAccountNumber = By.xpath("//input[@id='RepayAccountNumber_maskedInput']");
	public By rmAccountSuffix = By.xpath("//input[@id='RepayAccountSuffix_maskedInput']");
	public By rmCompanyName = By.xpath("//input[@id='PayrollCompanyName']");

	// Payment protection

	public By salesStatus = By
			.xpath("///label[contains(text(),'Sales Status')]/..//span/span[contains(@class,'k-input')]");

	// comments

	public By Comment = By.xpath("//input[@id='NoteText']");

	// CollateralSelection
	public By collateralCategory = By.xpath("//label[contains(text(),'Category')]/..//span/span[@class='k-input']");
	public By collateralName = By.xpath("//label[contains(text(),'Name')]/..//span/span[@class='k-input']");

	// Residential Property Details
	public By ownerName = By.id("OwnerName");
	public By estimatedValue = By.xpath(
			"//label[contains(text(),'Estimated Value')]/..//span[contains(@class,'k-numeric')]/input[contains(@class,'k-input')]");

	// Mortgage Details
	public By mortgageDetails = By.xpath("//ul[@role='tablist']/li[3]/span[contains(text(),'Mortgage Details')]");
	public By lienPosition = By
			.xpath("//label[contains(text(),' Lien Position ')]/../kendo-dropdownlist/span/span[@class='k-input']");
	public By mortgageHolder = By.id("MortgageHolderName");
	public By mdPhoneNumber = By
			.xpath("//input[@id='MortgageHolderName']/../../following-sibling::*/div/input[@id='PhoneNumber']");
	public By mdDateOpen = By
			.xpath("//label[@for='MortgageDateOpened']/../kendo-datepicker/span/kendo-dateinput/span/input");
	public By mdExistingPI = By.xpath(
			"//app-mortgage-details-form/div/div/following-sibling::*/div/following-sibling::*/following-sibling::*/div/label[@for='MortgageExistingPI']/../kendo-numerictextbox/span/input");
	public By mdExistingPITI = By.xpath(
			"//app-mortgage-details-form/div/div/following-sibling::*/div/following-sibling::*/following-sibling::*/following-sibling::*/div/label[@for='MortgageExistingPITI']/../kendo-numerictextbox/span/input");
	public By mdMonthlypayment = By.xpath(
			"//app-mortgage-details-form/div/div/following-sibling::*/div/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/div/label[@for='MortgageMonthlyPayment']/../kendo-numerictextbox/span/input");
	public By mdIntRate = By.xpath(
			"//app-mortgage-details-form/div/div/following-sibling::*/div/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/div/label[@for='MortgageInterestRate']/../kendo-numerictextbox/span/input");
	public By mdBalance = By.xpath(
			"//app-mortgage-details-form/div/div/following-sibling::*/div/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/div/label[@for='MortgageBalance']/../kendo-numerictextbox/span/input");
	//public By MDPayoff = By.xpath("//app-mortgage-details-form/div/div/following-sibling::*/div/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/div/label[@for='MortgagePayoffAmount']/../kendo-numerictextbox/span/input");
	public By mdPayoff = By.xpath("//label[@for='MortgagePayoffAmount']/../kendo-numerictextbox/span/input");
	public By mdAddress1 = By.xpath("//app-mortgage-details-form/div/app-velocity-address/div/div/div/label[text()=' Address 1 ']/../input[@id='FirstLine']");
	public By mdZipCode = By.xpath("//app-mortgage-details-form/div/app-velocity-address/div[2]/div/div/label[text()=' Zip Code ']/../div/input");
	public By addMortgage = By.xpath("//app-mortgage-details/div/div/div/div/div/button[@type='submit']");
	
	//Real Estate Costs
	public By realEstateCosts = By.xpath("//ul[@role='tablist']/li[4]/span[contains(text(),'Real Estate Costs')]");
	public By escrowPaymentType = By.xpath("//label[text()=' Escrow Payment Type ']/../kendo-dropdownlist/span/span[@class='k-select']");
	public By costDescription = By.xpath("//input[@id='CostDescription']");
	public By reCostPayment = By.xpath("//label[@for='RealEstateCostsMonthlyPayment']/../kendo-numerictextbox/span/input");
	//public By Escrowed= By.xpath("//div/label[@for='IsEscrowedInd27']");
	public By Escrowed = By.xpath("//span[text()='Escrowed']/parent::*");
	public By addRECosts = By.xpath("//*[@id=\"k-tabstrip-tabpanel-3\"]/app-real-estate-costs/div/div/div[3]/div/div/button[2]");
	
	//RE insurance
	
	public By reInsurance = By.xpath("//ul[@role='tablist']/li[5]/span[@class='k-link' or text()='Insurance']");
	public By insPolicyType = By.xpath("//label[text()=' Policy Type ']/../kendo-dropdownlist/span/span[@class='k-select']");
	public By insPolicyNo = By.id("PolicyNumber");
	public By insExpDate = By.xpath("//label[text()=' Exp Date ']/../kendo-datepicker/span/kendo-dateinput/span/input");
	public By insCoverage = By.xpath("//label[text()=' Coverage ']/../kendo-numerictextbox/span/input");
	public By insDeductible = By.xpath("//label[text()=' Deductible ']/../kendo-numerictextbox/span/input");
	public By insPremium = By.xpath("//label[text()=' Premium ']/../kendo-numerictextbox/span/input");
	public By insCompany = By.id("InsuranceCompanyName");
	public By insAgent = By.id("InsuranceAgent");
	public By insPhone = By.xpath("//app-insurance-form/div/div/div[9]/div/input");
	public By insAddress1 = By.xpath("//app-insurance-form/div/app-velocity-address/div/div/div/input[@id='FirstLine']");
	public By insZipCode = By.xpath("//app-insurance-form/div/app-velocity-address/div/div/div/div/input");
	public By addInsurance = By.xpath("//app-insurance/div/div/div/div/div/button[@type='submit']");
	
	//Collateral Owner
	
	public By collateralOwner = By.xpath("//ul[@role='tablist']/li[6]/span[@class='k-link' or text()='Collateral Owners']");
	public By collateralOwnerName = By.xpath("//label[text()=' Other Owner Name ']/following-sibling::input[@id='OwnerName']");
	public By collOwnerAddress1 = By.xpath("//app-owners-form/div/app-velocity-address/div/div/div/label[text()=' Address 1 ']/following-sibling::input[@id='FirstLine']");
	public By collOwnerZipCode = By.xpath("//app-owners-form/div/app-velocity-address/div/div/div/label[text()=' Zip Code ']/../div/input");
	public By addCollateralOwner = By.xpath("//app-owners-form/../following-sibling::div/div/div/button[@type='submit']");
	
	
	
	//Existing Lien Info
	
	public By existingLien = By.xpath("//ul[@role='tablist']/li[7]/span[@class='k-link' or text()='Existing Lien Details']");
	public By lienHolder = By.xpath("//input[@id='LienHolder']");
	public By existLienPosition = By.xpath("//app-existing-lien-details-form/div//div/label[text()=' Lien Position ']/../kendo-dropdownlist/span/span/span");
	public By existLienDesc = By.xpath("//input[@id='Description']");
	public By existLienPhoneNo = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Phone Number ']/../input[@id='PhoneNumber']");
	public By existLienFaxNo = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Fax Number ']/../input[@id='FaxNumber']");
	public By existLienAccNo = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Account Number ']/../input[@id='AccountNumber']");
	public By existLienDateOpen = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Date Open ']/../kendo-datepicker/span/kendo-dateinput/span/input");
	public By existLienPI = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Existing PI ']/../kendo-numerictextbox/span/input");
	public By existLienPITI = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Existing PITI ']/../kendo-numerictextbox/span/input");
	public By existLienPayment = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Monthly Payment ']/../kendo-numerictextbox/span/input");
	public By existLienRate = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Int. Rate ']/../kendo-numerictextbox/span/input");
	public By existLienBalance = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Balance ']/../kendo-numerictextbox/span/input");
	public By existLienPayoff = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Pay Off ']/../kendo-numerictextbox/span/input");
	public By existLienDebtSpread = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Debt Spread Percentage ']/../kendo-numerictextbox/span/input");
	public By existLienAdd1 = By.xpath("//app-existing-lien-details-form/div/app-velocity-address/div/div/div/label[text()=' Address 1 ']/following-sibling::input[@id='FirstLine']");
	public By existLienZipCode = By.xpath("//app-existing-lien-details-form/div/app-velocity-address/div/div/div/label[text()=' Zip Code ']/../div/input");
	public By addExistLien = By.xpath("//app-existing-lien-details-form/../following-sibling::div/div/div/button[@type='submit']");
	
	//Lien Filing
	
	public By lienFiling = By.xpath("//ul[@role='tablist']/li[8]/span[@class='k-link' or text()='Lien Filing']");
	public By lienFilingYes = By.xpath("//app-lien-filing/div/div/div[1]/div/div[2]/app-segment-button/div/label[1]");
	public By whoFiled = By.xpath("//input[@id='LienFiledBy']");
	//public By DateFiled = By.xpath("//label[text()=' Date Filed ']/../kendo-datepicker/span/kendo-dateinput/span/input");
	public By dateFiled = By.xpath("//label[text()=' Date Filed ']/../kendo-datepicker/span/span/span");
	//public By DateReceived = By.xpath("//label[text()=' Date Received ']/../kendo-datepicker/span/kendo-dateinput/span/input");
	public By todaysDate = By.xpath("//span[@class='k-today']");
	public By dateReceived = By.xpath("//label[text()=' Date Received ']/../kendo-datepicker/span/span/span");
	
	
	// Titled Goods Collateral KBB details

	public By kbbYear = By.xpath("//label[@for='BlueBookModelYear']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By kbbMake = By.xpath("//label[@for='BlueBookMake']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By kbbModel = By.xpath("//label[@for='BlueBookModel']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By kbbSubModel = By
			.xpath("//label[@for='BlueBookSubModel']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By kbbBodyStyle = By
			.xpath("//label[@for='BlueBookBodyStyle']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By kbbEngineSize = By.xpath("//label[@for='BlueBookEngineSize']/../kendo-numerictextbox/span/input");
	public By kbbGetOptionsbttn = By.xpath("//button[text()='Get Options']");
	public By kbbGetPricing = By.xpath("//button[@id='cmdGetPricing']");
	public By kbbGetPricingYesbttn = By.xpath("//button[text()=' Yes ']");

	// click Next, Submit, Save
	public By nextBttn = By.xpath("//button[contains(text(),'Next')]");
	public By submitbttn = By.xpath("//button[contains(text(),'Submit')]");
	public By Save = By.xpath("//button[text()='Save']");

	// close action status window
	public By closeBttn = By.xpath("//button[contains(text(),'Close') and @class=' ml-auto btn btn-secondary']");
	
	//unsaved changes
	public By unsavedChangesYes = By.xpath("//button[text()=' Yes ']");

	// Data Entry page0

	public void selectProduct(String productname) {

		// try {
		
		System.out.println("in selectproduct method, waiting for sync");
		//element.sync().waitForElement(productDropDown);
		System.out.println("waiting for product dropdwn field");
		String productstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + productname
				+ "']";
		By selectproduct = By.xpath(productstring);
		// element.sync().fluentWaitForElement(productDropDown);
		// Thread.sleep(20000););

		// Thread.sleep(20000);
		//element.sync().pause(10);
		//element.sync().elementToBeClickable(productDropDown);
		element.sync().pause(30);
		element.click(productDropDown, "Click on Product DropDown");
		element.click(selectproduct, "");

		/*
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	public void enterRequestedAmt(String reqAmount) {
		System.out.println("inside the method enter amount");
		// try {
		element.sync().pause(5);
		element.sync().waitForElement(requestedAmt);
		element.click(requestedAmt, "");
		element.sendKeys(requestedAmt, reqAmount, "Enter RequestedAmt :" + reqAmount);
		//element.sendKeys(requestedAmt, reqAmount, "Enter RequestedAmt");
	}
	/*
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 */

	public void enterCashPriceIV(String cashPriceiv) {
		/*
		 * try { Thread.sleep(10000);
		 */
		element.sync().pause(10);
		System.out.println("enter cash price");
		element.click(cashPriceIV, "");
		System.out.println("cursor on cash price");
		element.sendKeys(cashPriceIV, cashPriceiv, "");
	}
	/*
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

	public void enterBranch(String branch) {
		System.out.println("inside the method enter branch");
		element.click(Branch, "");
		element.sendKeys(Branch, branch, "Enter Branch" + branch);
	}

	public void enterDealer(String dealer) {
		element.jsExecute().scrollToBottom();
		System.out.println("inside the method enter dealer");
		element.click(Dealer, "");
		element.sendKeys(Dealer, dealer, "Enter Dealer" + dealer);
	}

	public void selectdeliverymethod(String deliveryMethod) {
		element.sync().pause(5);
		String methodstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + deliveryMethod
				+ "']";
		By selectdeliverymethod = By.xpath(methodstring);
		element.click(deliveryMethodDropDown, "Click on Delivery Method  DropDown");
		element.click(selectdeliverymethod, "");
	}

	public void enterSSN(String ssn) {
		element.sync().pause(10);
		System.out.println("inside the method enter SSN");
		element.click(SSN, "Click SSN");
		element.sendKeys(SSN, ssn, "Enter SSN" + ssn);
	}

	public void enterFirstName(String first_Name) {
		element.click(firstName, "click First Name" + first_Name);
		/*
		 * try { Thread.sleep(15000);
		 */
		element.sync().pause(15);
		element.click(copyDataClosebttn, "Close the Copy Data page");
		element.sync().pause(10);
		/*
		 * Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		element.sync().waitForElement(firstName);
		element.sendKeys(firstName, first_Name, "Enter FirstName");
	}

	public void enterMiddleName(String middle_Name) {

		element.sendKeys(middleName, middle_Name, "Enter MiddleName :" + middle_Name);
	}

	public void enterLastName(String last_Name) {
		element.sendKeys(lastName, last_Name, "Enter lastname:" + last_Name);
	}

	public void clickSaveBttn() {
		element.sync().pause(5);
		element.click(saveBttn, "Click on Save button");
		System.out.println("Tried clicking Save");
	}

	// Applicant Summary
	public void selectInstReln(String instRel) {

		// try {
		String relationString = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + instRel
				+ "']";
		By selectReln = By.xpath(relationString);
		element.sync().pause(10);
		element.click(instRelationship, "Click on Inst Reln DropDown");
		element.click(selectReln, "");
		/*
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	public void enterDateOfBirth(String dateOfBirth) {
		element.jsExecute().scrollToElement(instRelationship);
		System.out.println("Scrolled until DOB element");
		element.click(DOB, "click on DOB");
		element.sendKeys(DOB, dateOfBirth, "Enter dateofbirth:" + dateOfBirth);
	}

	public void selectMaritalStatus(String maritalStatus) {

		// try {
		String maritalstatusstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ maritalStatus + "']";
		By selectmaritalstatus = By.xpath(maritalstatusstring);
		// Thread.sleep(20000);
		element.sync().waitForElement(maritalstatusDropDown);
		element.click(maritalstatusDropDown, "Click on Marital status DropDown");
		element.click(selectmaritalstatus, "");
	}

	/*
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
	public void enterDriversLicense(String driversLicense) {

		element.jsExecute().scrollToElement(maritalstatusDropDown);
		element.click(dlNumber, "click on DL");
		element.sendKeys(dlNumber, driversLicense, "Enter DL Number:" + driversLicense);
	}

	public void enterOccupation(String occupation) {

		element.click(Occupation, "click on occupation");
		System.out.println("clicked field occupation");
		element.sendKeys(Occupation, occupation, "Enter Occupation:" + occupation);
	}

	public void enterOccupationLength(String occupation_Length) {

		element.click(occupationLength, "click on occupationlength");
		System.out.println("clicked field occupation length");
		element.sendKeys(occupationLength, occupation_Length, "Enter Occupationlebgth:" + occupation_Length);
	}

	public void SelectPreferredMethod(String preferred) {
		element.jsExecute().scrollToElement(dlNumber);
		String preferredmethodstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ preferred + "']";
		By selectpreferredmethod = By.xpath(preferredmethodstring);
		element.click(preferredMethod, "Click on Preferred DropDown");
		element.click(selectpreferredmethod, "");
	}

	public void enterHomePhone(String phoneNo) {
		element.click(homePhone, "click phone");
		element.sendKeys(homePhone, phoneNo, "enter Phone Num");
	}

	public void selectfavcontact() {
		element.click(contactFavorite, "select fav contact");
	}

	public void enterEmail1(String email1) {
		element.click(Email1, "click email1");
		element.sendKeys(Email1, email1, "enter email1");
	}

	// CoApplicant Page
	public void enterSSN2(String ssn2) {
		element.click(SSN2, "click SSN2");
		element.sendKeys(SSN2, ssn2, "enter ssn");

	}

	public void enterFirstName2(String first_Name2) {
		element.jsExecute().scrollToElement(SSN2);
		element.click(firstName2, "click name");
		element.sendKeys(firstName2, first_Name2, "enter name");
	}

	public void enterLastName2(String last_name2) {
		element.click(lastName2, "click name");
		element.sendKeys(lastName2, last_name2, "enter lastname2");
	}

	// Address section

	public void clickAddress() {
		element.click(Address, "Click on Address");
	}

	public void selectAddressType(String addType) {

		// try {
		String addtypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + addType
				+ "']";
		By selecttype = By.xpath(addtypestring);
		element.sync().pause(10);
		element.click(addressType, "Click on Address Type DropDown");
		element.click(selecttype, "");

	}
	// catch (InterruptedException e) {
	// TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	public void scrolltoSSN2() {
		element.click(CTRLM, "");
		element.jsExecute().scrollToElement(SSN2);
		element.click(CTRLM, "");

	}

	public void scrolltoAddressStatus() {
		element.click(CTRLM, "");
		element.jsExecute().scrollDownTo(0, 0);
		element.click(CTRLM, "");
	}

	public void selectAddressStatus(String addstatus) {
		String addstatusstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + addstatus
				+ "']";
		By selectstatus = By.xpath(addstatusstring);
		element.click(addressStatus, "Click on Address Status DropDown");
		element.click(selectstatus, "");
	}

	public void enterLengthyrs(String yrs) {
		element.click(lengthYrs, "click length");
		element.sendKeys(lengthYrs, yrs, "enter yrs");
	}

	public void enterMonthlyPayment(String monthly_payment) {
		element.click(monthlyPayment, "click Payment");
		element.sendKeys(monthlyPayment, monthly_payment, "enter payment");
	}

	public void enterAddDesc(String addDesc) {

		element.click(addressDesc, "click desc");
		element.sendKeys(addressDesc, addDesc, "enter desc");

	}

	public void enterAddress1(String add1) {
		element.jsExecute().scrollToElement(address1);
		element.click(address1, "click add1");
		element.sendKeys(address1, add1, "enter add1");
	}

	public void enterZipCode(String zipcode) {
		element.jsExecute().scrollToElement(ZipCode);
		element.click(ZipCode, "click zipcode");
		element.sendKeys(ZipCode, zipcode, "enter zipcode");
		element.click(City, "click City");
	}

	public void addButton() {
		// try {
		// Thread.sleep(10000);
		element.sync().pause(10);
		element.click(addButton, "Add section details");
		// Thread.sleep(5000);
	}
	/*
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public void clickEmployers() {
		System.out.println("inside clickEmployers method");
		try {
			Thread.sleep(10000);
			System.out.println(" clickEmployers ");
			element.click(Employers, "click Employers");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterEmployername(String employername) {
		try {
			Thread.sleep(5000);
			element.click(employerName, "click employer name");
			element.sendKeys(employerName, employername, "enter employername");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterEmployerAddress(String emp_address) {
		element.sendKeys(empAdd1, emp_address, "enter address");
		System.out.println("Address displayed");
	}

	public void enterEmployerZipCode(String emp_Zipcode) {

		System.out.println("enter zipcode function");
		element.jsExecute().click(empZipCode);
		element.click(CTRLM, "click Ctrl+M");
		System.out.println("clicked on CTRL+M");

		element.click(empZipCode, "click zipcode");
		element.sendKeys(empZipCode, emp_Zipcode, "enter zipcode");
		element.click(empCity, "click City");
	}

	public void enterEmployerSupervisor(String supervisor) {
		element.jsExecute().scrollToElement(employerName);
		element.click(empSupervisor, "click on Supervisor");
		element.sendKeys(empSupervisor, supervisor, "enter supervisor name");
	}

	public void selectEmploymentType(String emp_type) {

		String emptypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + emp_type
				+ "']";
		By selectemptype = By.xpath(emptypestring);
		element.click(empType, "Click on Type dropdown");
		element.click(selectemptype, "");
	}

	public void enterEmployerLengthyrs(String emplenyrs) {
		element.jsExecute().scrollToElement(employerName);
		element.click(employerLengthYr, "click length");
		element.sendKeys(employerLengthYr, emplenyrs, "enter yrs");
	}

	public void enterEmployerPosition(String position) {
		element.sendKeys(employerPosition, position, "enter Position");
	}

	public void enterEmployerAmount(String emp_amount)

	{
		element.jsExecute().scrollToElement(employerLengthYr);
		element.click(employerAmount, "click amount");
		element.sendKeys(employerAmount, emp_amount, "enter amount");
		element.click(Frequency, "click Frequency to populate Monthly Payment data");
		element.click(CTRLM, "click CTRL+M");
	}

	/*
	 * public void AddButton() { try { Thread.sleep(5000);
	 * element.click(Addbutton, "add employer"); } catch (InterruptedException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } }
	 */

	// Other Income
	public void clickIncome() {
		System.out.println("inside clickIncome method");
		try {
			Thread.sleep(10000);
			System.out.println(" click Income ");
			element.click(Income, "click Income");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickAddNewIncome() {
		element.click(addNewIncome, "Add New");
	}

	public void selectIncomeType(String income_type) {
		element.jsExecute().scrollToElement(incomeSource);
		String incometypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + income_type
				+ "']";
		By selectincometype = By.xpath(incometypestring);
		element.click(incomeType, "Click on Type dropdown");
		element.click(selectincometype, "");
	}

	public void enterSourceDescription(String source_description) {
		element.click(incomeSource, "click on source");
		element.sendKeys(incomeSource, source_description, "enter source");
	}

	public void enterAmount(String amount) {
		element.click(incomeAmount, "click on Amount");
		element.sendKeys(incomeAmount, amount, "enter amount");
		element.click(incomeSource, "click to calculate monthly amount");
	}

	public void enterNASAmount(String amountNAS) {
		element.click(incomeAmountNAS, "click on Amount");
		element.sendKeys(incomeAmountNAS, amountNAS, "enter amount");
		element.click(incomeSource, "click to calculate monthly amount");
	}
	// Assets

	public void clickAssets() {
		try {
			Thread.sleep(10000);
			element.click(Asset, "click asset");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectAssetType(String asset_type) {
		try {
			Thread.sleep(5000);
			String assettypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
					+ asset_type + "']";
			By selectassettype = By.xpath(assettypestring);
			element.click(assetType, "Click on Type dropdown");
			element.click(selectassettype, "");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enterAssetDescription(String assetdescription) {
		element.sendKeys(assetDescription, assetdescription, "asset desc");
	}

	public void enterAssetCashMarketValue(String cashmarketvalue) {
		element.sendKeys(assetCashMarketValue, cashmarketvalue, "cash market value");
	}

	public void enterAssetLoanBalance(String loanbalance) {
		element.sendKeys(assetLoanBalance, loanbalance, "cash market value");
	}

	/*public void enterAssetAccountNumber(String assetaccountnumber) {
		try {

			element.click(AssetAccountNumber, "click account number");
			Thread.sleep(5000);
			element.sendKeys(AssetAccountNumber, assetaccountnumber, "asset account number");
			System.out.println("asset accnt number entered");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
	

	public void enterAssetInstitution(String institution) {
		element.jsExecute().scrollToElement(assetDateOpened);
		element.sendKeys(assetInstitution, institution, "enter institute name");
	}

	public void enterAssetDateOpened(String assetDate) {
		try {
			Thread.sleep(1000);
			element.click(assetDateOpened, "to enter date");
			element.sendKeys(assetDateOpened, assetDate, "asset date");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enterAssetAddress1(String address1) {
		element.sendKeys(assetAddress1, address1, "Address1");
	}

	public void enterAssetZipCode(String asset_zipcode) {
		element.sendKeys(assetZipCode, asset_zipcode, "asset zipcode");
		element.click(assetAddress1, "to populate city");
	}

	// Liability
	public void clickLiability() {
		element.jsExecute().scrollToBottom();
		System.out.println("Scrolle to bottom");
		try {
			Thread.sleep(10000);
			element.click(Liability, "click liability");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectLiabilityType(String liability_type) {
		try {
			Thread.sleep(10000);
			String liabilitytypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
					+ liability_type + "']";
			By selectliabilitytype = By.xpath(liabilitytypestring);
			element.click(liabilityType, "Click on Type dropdown");
			element.click(selectliabilitytype, "");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterLiabilityDescription(String liability_description) {
		element.sendKeys(liabilityDescription, liability_description, "liability desc");
	}

	public void enterLiabilityCashMarketValue(String liability_cashmarketvalue) {
		element.sendKeys(liabilityCashMarketValue, liability_cashmarketvalue, "cash market value");
	}

	public void enterLiabilityLoanBalance(String liability_loanbalance) {
		element.sendKeys(liabilityLoanBalance, liability_loanbalance, "loan balance");
	}

	public void enterLiabilityAccountNumber(String liability_accountnumber) {
		try {
			element.click(liabilityAccountNumber, "click account number");
			Thread.sleep(5000);
			element.sendKeys(liabilityAccountNumber, liability_accountnumber, "liability account number");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Liability accnt number not entered");
			e.printStackTrace();
		}

	}

	public void enterLiabilityInstitution(String liability_Institution) {
		element.jsExecute().scrollToElement(liabilityDateOpened);
		element.sendKeys(liabilityInstitution, liability_Institution, "enter institute name");
	}

	public void enterLiabilityDateOpened(String liability_date) {
		element.click(liabilityDateOpened, "date opened");
		element.sendKeys(liabilityDateOpened, liability_date, "liability date");
	}

	public void enterLiabilityAddress1(String liability_address1) {
		element.sendKeys(liabilityAddress1, liability_address1, "Address1");
	}

	public void enterLiabilityZipCode(String liability_zipcode) {

		element.sendKeys(liabilityZipCode, liability_zipcode, " zipcode");
		element.click(liabilityAddress1, "to populate city");
	}

	// References
	public void clickReferences()

	{
		element.jsExecute().scrollToBottom();
		try {
			Thread.sleep(10000);
			element.click(References, "click references");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectReferenceType(String reference_Type) {
		try {
			Thread.sleep(5000);
			String referencetypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
					+ reference_Type + "']";
			By selectreferencetype = By.xpath(referencetypestring);
			element.click(referenceType, "Click on Type dropdown");
			element.click(selectreferencetype, "");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectReferenceRelationship(String relationship) {
		try {
			Thread.sleep(5000);
			String referencerelnstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
					+ relationship + "']";
			By selectrelntype = By.xpath(referencerelnstring);
			element.click(referenceRelationship, "Click on Type dropdown");
			element.click(selectrelntype, "");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterReferenceFirstName(String reference_firstname) {
		element.sendKeys(referenceFirstName, reference_firstname, "firstname");
	}

	public void enterReferenceLastName(String reference_lastname) {
		element.sendKeys(referenceLastName, reference_lastname, "lastname");
	}

	public void enterReferenceDOB(String referencedob) {
		element.jsExecute().scrollToElement(referenceFirstName);
		element.sendKeys(referenceDOB, referencedob, "dob");
	}

	public void enterReferencePhoneNumber(String reference_phonenumber) {
		element.sendKeys(referencePhoneNumber, reference_phonenumber, "phone");
	}
	public void enterRefNASPhoneNumber(String ref_nasphonenumber) {
		element.sendKeys(refNASPhoneNumber, ref_nasphonenumber, "phone");
	}

	public void enterReferenceAddress1(String reference_address1) {
		element.sendKeys(referenceAddress1, reference_address1, "Address1");
	}

	public void enterReferenceZipCode(String reference_zipcode) {
		element.sendKeys(referenceZipCode, reference_zipcode, "reference zipcode");
		element.click(referenceAddress1, "");
	}

	// Add applicant
	public void addApplicant() {
		try {
			Thread.sleep(5000);
			element.click(addApplicant, "add new applicant");
			element.sync().pause(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void NASCommunityProperty() {
		//element.sync().elementToBeClickable(CommunityProperty);
		element.sync().pause(5);
		element.click(communityProperty, "click OK");
		System.out.println("Clicked OK on Community Property");
	}

	public void enterNASAddress1(String nas_add1)
	{
		element.jsExecute().scrollToElement(address1NAS);
		element.click(address1NAS, "");
		element.sendKeys(address1NAS, nas_add1, "");
	}
	public void enterNASZipCode(String naszc)
	{
		element.jsExecute().scrollToElement(zipcodeNAS);
		element.click(zipcodeNAS, "");
		element.sendKeys(zipcodeNAS, naszc, "");
		element.click(address1NAS, "populate city");
		element.sync().pause(3);
	}
	
	public void enterNASEmpAddress1(String emp_nasadd1)
	{
		element.click(empAddress1NAS, "");
		element.sendKeys(empAddress1NAS, emp_nasadd1, "");
	}
		
		public void enterNASEmpZipCode(String emp_zipcodenas)
		{

			System.out.println("enter zipcode function");
			element.jsExecute().click(empZipCodeNAS);
			element.click(CTRLM, "click Ctrl+M");
			System.out.println("clicked on CTRL+M");

			element.click(empZipCode, "click zipcode");
			element.sendKeys(empZipCodeNAS, emp_zipcodenas, "enter zipcode");
			element.click(empAddress1NAS, "click City");
			element.sync().pause(2);
		}

	
	
	public void enterNASAssetAddress1(String asset_nasadd1)
	{
		element.click(assetAddress1NAS, "");
		element.sendKeys(assetAddress1NAS, asset_nasadd1, "");
	}
	public void enterNASAssetZipCode(String asset_naszc)
	{
		element.click(assetZipCodeNAS, "");
		element.sendKeys(assetZipCodeNAS, asset_naszc, "");
	}
	
	public void enterNASLiabilityAddress1(String liability_nasadd1)
	{
		element.click(liabilityAddress1NAS, "");
		element.sendKeys(liabilityAddress1NAS, liability_nasadd1, "");
	}
	public void enterNASLiabilityZipCode(String liabilitynaszc)
	{
		element.click(liabilityZipCodeNAS, "");
		element.sendKeys(liabilityZipCodeNAS, liabilitynaszc, "");
	}
	
	public void enterNASRefAddress1(String ref_nasadd1)
	{
		element.click(refAddress1NAS, "");
		element.sendKeys(refAddress1NAS, ref_nasadd1, "");
	}
	public void enterNASRefZipCode(String refnaszc)
	{
		element.click(refZipCodeNAS, "");
		element.sendKeys(refZipCodeNAS, refnaszc, "");
	}
	
	public void selectBorrowerTypeNAS(String nas) {
		element.sync().pause(5);
		String NASstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + nas + "']";
		By selectNAS = By.xpath(NASstring);
		element.click(borrowerType, "Click on Type dropdown");
	//	element.sync().waitForElement(selectNAS);
		element.click(selectNAS, "");
	}

	public void selectSpouse(String spouse) {
		element.sync().waitForElement(Spouse);
		String Spousestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + spouse + "']";
		By selectspouse = By.xpath(Spousestring);
		element.click(Spouse, "Click on Type dropdown");
		element.sync().waitForElement(selectspouse);
		element.click(selectspouse, "");
	}

	public void enterContractDetailsLoanAmount(String cdloanamount) {
		try {
			Thread.sleep(5000);
			element.click(CTRLM, "click Ctrl+M");
			element.jsExecute().scrollToElementClick(roundPayment);
			element.click(contractDetailsLoanAmount, "click loan amount");
			element.sendKeys(contractDetailsLoanAmount, cdloanamount, "enter loan amount");
			element.click(CTRLM, "click Ctrl+M");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Repayment Method

	public void selectRepaymentMethod(String method) {

		try {
			element.jsExecute().scrollToElement(rmTitle);
			String methodstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + method
					+ "']";
			By selectmethod = By.xpath(methodstring);
			Thread.sleep(20000);
			element.click(repaymentMethod, "Click on Method DropDown");
			element.click(selectmethod, "");
			// element.click(CTRLM, "click ctrlm");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterRMAccountNumber(String accnt_number) {
		element.sendKeys(rmAccountNumber, accnt_number, "");
	}

	public void enterRMAccountSuffix(String accntsuffix) {
		element.sendKeys(rmAccountSuffix, accntsuffix, "");
	}

	public void enterRMCompanyName(String company) {
		element.sendKeys(rmCompanyName, company, "");
		element.click(CTRLM, "");
	}

	// Payment protection

	public void selectSalesStatus(String sales_status) {
		String salesstatusstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ sales_status + "']";
		By selectsalesstatus = By.xpath(salesstatusstring);
		element.click(salesStatus, "Click on Sales status DropDown");
		element.click(selectsalesstatus, "");
	}

	// Comments

	public void enterComment(String comment) {
		element.sendKeys(Comment, comment, "enter comments");
	}
	// Collateral

	public void selectCollateralCategory(String category) {
		String categorystring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + category
				+ "']";
		By selectcategory = By.xpath(categorystring);
		element.click(collateralCategory, "Click on Collateral Category");
		element.click(selectcategory, "");
	}

	public void selectCollateralName(String name) {
		String namestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + name + "']";
		By selectname = By.xpath(namestring);
		element.click(collateralName, "Click on Name");
		element.click(selectname, "");
	}

	// Real Estate Collateral
	public void enterOwnerName(String owner) {
		try {
			Thread.sleep(10000);
			element.click(ownerName, "name");
			element.sendKeys(ownerName, owner, "enter name");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterEstimatedValue(String estimated_value) {

		element.jsExecute().scrollToElement(ownerName);
		element.click(estimatedValue, "estimated value");
		element.sendKeys(estimatedValue, estimated_value, "enter value");
	}

	// Add RE Mortgage

	public void clickMortgage()

	{
		try {
			Thread.sleep(10000);
			element.click(mortgageDetails, "click mortgage");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectLien(String lien_position) {
		//element.jsExecute().scrollToElement(LienPosition);
		element.click(CTRLM, "");
		element.jsExecute().scrollDownTo(0, 0);
		element.click(CTRLM, "");
		element.sync().pause(5);
		String lienstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + lien_position
				+ "']";
		By selectlien = By.xpath(lienstring);
		element.click(lienPosition, "Click on Lien");
		element.click(selectlien, "");
		//element.sync().pause(5);
	}
	

	public void enterMortgageHolder(String mortgage_holder) {
		element.sendKeys(mortgageHolder, mortgage_holder, "");

	}

	public void enterMDPhone(String phone) {
		element.sendKeys(mdPhoneNumber, phone, "");
	}

	public void enterMDDateOpen(String date) {
		element.click(mdDateOpen, date);
		element.sendKeys(mdDateOpen, date, "");
	}

	public void enterMDPI(String pi) {
		element.sendKeys(mdExistingPI, pi, "");
	}

	public void enterMDPITI(String piti) {
		element.sendKeys(mdExistingPITI, piti, "");
	}

	public void enterMDPayment(String payment) {
		element.jsExecute().scrollToElement(mdMonthlypayment);
		element.sendKeys(mdMonthlypayment, payment, "");
	}

	public void enterMDIntRate(String intRate) {
		element.sendKeys(mdIntRate, intRate, "");
	}

	public void enterMDBalance(String balance) {
		element.sendKeys(mdBalance, balance, "");
	}

	public void enterMDPayoff(String md_payoff) {
	//	element.sync().pause(2);
		element.click(mdPayoff, "");
		System.out.println("clicked on payoff, enter value now");
	    element.sendKeys(mdPayoff, md_payoff, "");
		
	}
	
	public void enterMDAddress1(String md_address1)
	{
		element.jsExecute().scrollToBottom();
		
		element.click(mdAddress1, "");
		System.out.println("clicked address1, enter value now");
		element.sendKeys(mdAddress1,md_address1,"");
	}

	

	public void enterMDZipCode(String md_zipcode)
	{
		element.click(mdZipCode, "");
		System.out.println("clicked Zipcode, enter value now");
		element.sendKeys(mdZipCode,md_zipcode,"");
		element.click(mdAddress1, "populate values for zipcode");
		element.sync().pause(2);
	}
	
	public void addMortgage() {
		element.click(addMortgage, "");
		element.sync().pause(5);
	}

	//Add Real Estate Costs
	
	public void clickRECosts()
	{
		element.sync().pause(5);
		element.click(realEstateCosts, "");
	}
	
	public void selectEscrowPaymentType(String escrow_paytype)
	{
		element.sync().pause(5);
		String escrowstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + escrow_paytype
				+ "']";
		By selectescrowtype = By.xpath(escrowstring);
		element.click(escrowPaymentType, "");
		element.click(selectescrowtype, "");
		element.sync().pause(2);	
	}
	
	public void enterCostDescription(String cost_desc)
	{
				element.sendKeys(costDescription,cost_desc, "");
	}
	
	public void enterREMonthlyPayment(String re_monthlypayment)
	{
				element.sendKeys(reCostPayment ,re_monthlypayment, "");
	}
	
	public void checkEscrow()
	{
		//element.click(Escrowed, "check checkbox");
		//new Actions(driver).moveToElement(label, 1, 1).click().perform();
		 element.jsExecute().click(Escrowed);	
	
	}
	
	public void addRECosts()
	{
		
		element.click(addRECosts, "Add RE Costs");
		element.sync().pause(5);
	}
	
	//RE Insurance
	public void clickREInsurance()
	{
		element.sync().pause(5);
		element.jsExecute().scrollToBottom();
		element.click(reInsurance, "");
	}
	
	public void selectREInsurancePolicyType(String re_insurancepolicytype)
	{
		element.sync().pause(8);
		String repolicytypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + re_insurancepolicytype
				+ "']";
		By selectreinsurancepolicytype = By.xpath(repolicytypestring);
		element.click(insPolicyType , "");
		element.click(selectreinsurancepolicytype, "");
		element.sync().pause(2);	
	}
	
	public void enterInsPolicyNo(String ins_policyno)
	{
		element.click(insPolicyNo , "");
		element.sendKeys(insPolicyNo, ins_policyno, "");
	}
	
	
	public void enterInsExpdate(String ins_expdate)
	{
		element.click(insExpDate , "");
		element.sendKeys(insExpDate, ins_expdate, "");
	}
	
	
	public void enterinsCoverage(String ins_coverage)
	{
		element.sendKeys(insCoverage ,ins_coverage, "");
	}
	
	
	public void enterInsPremium(String ins_premium)
	{
		element.sendKeys(insPremium, ins_premium, "");
	}
	
	
	public void enterInsDeductible(String ins_deductible)
	{
		element.sendKeys(insDeductible , ins_deductible, "");
	}
	
	public void enterInsCompany(String ins_company)
	{
		element.sendKeys(insCompany, ins_company, "");
	}
	
	public void enterInsAgent(String ins_agent)
	{
		element.sendKeys(insAgent, ins_agent, "");
	}
	
	public void enterInsPhone(String ins_phone)
	{
		element.jsExecute().scrollToElement(insPolicyNo);
		element.click(insPhone, "");
		element.sendKeys(insPhone, ins_phone, "");
	}
	
	public void enterInsAddress1(String insAdd1)
	{
		element.click(insAddress1, "");
		element.sendKeys(insAddress1, insAdd1, "");
	}
	
	public void enterInsZipCode(String ins_zipcode)
	{
		element.click(insZipCode, "");
		element.sendKeys(insZipCode, ins_zipcode, "");
		element.click(insAddress1, "populate zipcode details");
	}

	public void addReInsurance()
	{
		element.sync().pause(5);
		element.click(addInsurance,"add REInsurance");
	}
	
	
	//Collateral Owner
	
	public void clickCollateralOwner()
	{
		element.sync().pause(5);
		element.jsExecute().scrollToBottom();
		element.click(collateralOwner, "");
		element.sync().pause(5);
	}
	
	public void enterCollOwnerName(String collOwnerName)
	{
		element.click(collateralOwnerName, "");
		element.sendKeys(collateralOwnerName, collOwnerName, "");
	}
	
	public void enterCollOwnerAddress1(String coll_owneradd1)
	{
		element.click(collOwnerAddress1, "");
		element.sendKeys(collOwnerAddress1, coll_owneradd1, "");
	}
	
	public void enterCollOwnerZipCode(String collowner_zipcode)
	{
		element.click(collOwnerZipCode,"");
		element.sendKeys(collOwnerZipCode, collowner_zipcode, "");
		element.click(collOwnerAddress1, "");
	}
	
	public void addCollOwner()
	{
		element.click(addCollateralOwner, "");
		element.sync().pause(5);
	}
	//Existing Lien details
	
	
	public void clickExistingLienDetails()
	{
		element.sync().pause(2);
		element.jsExecute().scrollToBottom();
		element.click(existingLien, "");
	}
	
	public void enterLienHolder(String lien_holder)
	{
		element.sync().pause(2);
		element.sendKeys(lienHolder, lien_holder, "");
	}
	
	public void selectExistLienPosition(String exist_lienposition) {
		String existlienstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + exist_lienposition
				+ "']";
		By selectexistlien = By.xpath(existlienstring);
		element.click(existLienPosition, "Click on Lien");
		element.click(selectexistlien, "");
		
	}
	
	public void enterExistLienDesc(String lien_desc)
	{
		element.sync().pause(2);
		element.sendKeys(existLienDesc , lien_desc, "");
	}
	
	public void enterExistLienPhoneNo(String lien_phoneno)
	{
		element.sync().pause(2);
		element.sendKeys(existLienPhoneNo , lien_phoneno, "");
	}
	
	public void enterExistLienfaxNo(String lien_faxno)
	{
		element.sync().pause(2);
		element.sendKeys(existLienFaxNo , lien_faxno, "");
	}
	
	public void enterExistLienAccNo(String lien_accno)
	{
		element.sync().pause(2);
		element.sendKeys(existLienAccNo  , lien_accno, "");
	}
	
	public void enterExistDateOpen(String lien_dateopen)
	{
		element.sync().pause(2);
		element.sendKeys(existLienDateOpen  , lien_dateopen, "");
	}
	public void enterExistLienPI(String lien_pi)
	{
		element.jsExecute().scrollToBottom();
		element.sync().pause(2);
		element.sendKeys(existLienPI  , lien_pi, "");
	}
	
	public void enterExistLienPITI(String lien_piti)
	{
		element.sync().pause(2);
		element.sendKeys(existLienPITI  , lien_piti, "");
	}
	
	public void enterExistLienPayment(String lienPayment)
	{
		element.sync().pause(2);
		element.sendKeys(existLienPayment  , lienPayment, "");
	}
	
	
	public void enterExistLienRate(String lien_rate)
	{
		element.sync().pause(2);
		element.sendKeys(existLienRate  , lien_rate, "");
	}
	
	public void enterExistLienBalance(String lien_balance)
	{
		element.sync().pause(2);
		element.sendKeys(existLienBalance  , lien_balance, "");
	}
	
	public void enterExistLienPayOff(String lien_payoff)
	{
		element.sync().pause(2);
		element.sendKeys(existLienPayoff  , lien_payoff, "");
	}
	public void enterExistLienDebtSpread(String lienDebtSpread)
	{
		element.sync().pause(2);
		element.sendKeys(existLienDebtSpread  , lienDebtSpread, "");
	}
	
	public void enterExistLienAddress1(String lien_add1)
	{
		
		element.sendKeys(existLienAdd1  , lien_add1, "");
	}
	
	public void enterExistLienZipCode(String lien_zipcode)
	{
		
		element.sendKeys(existLienZipCode  , lien_zipcode, "");
		element.click(existLienAdd1, "populate zipcode values");
		element.sync().pause(5);
	}
	
	public void addExistingLien()
	{
				element.click(addExistLien  , "");
				element.sync().pause(5);
	}
	
	//Lien Filing
	
	public void clickLienFiling()
	{
		element.jsExecute().scrollToBottom();
		element.click(lienFiling, "");
		element.sync().pause(5);
	}
	
	
	public void clickLienFilingYes()
	{
	element.click(lienFilingYes, "");
	
	}
	
	
	public void enterFiledBy(String filed_by)
	{
		element.sync().waitForElement(whoFiled);
		element.sendKeys(whoFiled, filed_by, "");
	}
	
	public void enterDateFiled()
	{
		element.click(dateFiled, "");
		element.sync().pause(2);
		element.click(todaysDate, "");
	}
	
	
	public void enterDateReceived()
	{
		element.click(dateReceived,"");
		element.sync().pause(2);
		element.click(todaysDate, "");
		
	}
	
	
	
	
	// Titled Goods KBB Collateral

	public void selectKBBYear(String kbb_year) {
		element.jsExecute().scrollToElementClick(kbbYear);
		String kbbyearstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + kbb_year
				+ "']";
		By selectkbbyear = By.xpath(kbbyearstring);
		element.click(kbbYear, "Click on year DropDown");
		element.click(selectkbbyear, "");
	}

	public void selectKBBMake(String kbb_make) {

		String kbbmakestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + kbb_make
				+ "']";
		By selectkbbmake = By.xpath(kbbmakestring);
		element.click(kbbMake, "Click on Make DropDown");
		element.click(selectkbbmake, "");
	}

	public void selectKBBModel(String kbb_model) {

		String kbbmodelstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + kbb_model
				+ "']";
		By selectkbbmodel = By.xpath(kbbmodelstring);
		element.click(kbbModel, "Click on model DropDown");
		element.click(selectkbbmodel, "");
	}

	public void selectKBBSubModel(String kbb_submodel) {

		String kbbsubmodelstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ kbb_submodel + "']";
		By selectkbbsubmodel = By.xpath(kbbsubmodelstring);
		element.click(kbbSubModel, "Click on submodel DropDown");
		element.click(selectkbbsubmodel, "");
	}

	public void selectKBBBodyStyle(String kbbbodystyle) {

		String kbbbodystylestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ kbbbodystyle + "']";
		By selectkbbbodystyle = By.xpath(kbbbodystylestring);
		element.click(kbbBodyStyle, "Click on Body style DropDown");
		element.click(selectkbbbodystyle, "");
	}

	public void clickKBBGetOptions() {
		element.click(kbbGetOptionsbttn, "");
	}

	public void clickKBBGetPricing() {
		element.jsExecute().scrollToElement(kbbEngineSize);
		element.click(kbbGetPricing, "");

	}
	

	public void clickKBBGetPricingYesbttn() {
		element.click(kbbGetPricingYesbttn, "");
		try {
			Thread.sleep(5000);
			element.jsExecute().scrollToElement(kbbYear);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickSave() {
		element.click(Save, "click Save");
	}

	public void clickNext() {
		try {
			Thread.sleep(5000);
			element.click(nextBttn, "click Next");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickSubmit() {
		element.click(submitbttn, "click Submit");
	}

	public void CloseActionStatuswindow() {
		element.click(closeBttn, "close action status window");
	}

	public void selectRegBCreditType() {
		element.sync().pause(5);
		element.click(regBCreditType, "click yes");
	}


//unsaved changes pop-up

public void unsavedchangesYes()
{
	element.click(unsavedChangesYes,"");
	element.sync().pause(5);
	
}
}









