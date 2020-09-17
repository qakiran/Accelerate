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
	public By RequestedAmt = By.xpath(
			"//label[contains(text(), 'Requested Amount')]/parent::*/following-sibling::*/span/input[contains(@class,'k-input')]");
	public By Branch = By.xpath("//input[@class='k-input' and @role='textbox']");
	public By DeliveryMethodDropDown = By
			.xpath("//label[contains(text(), 'Delivery Method')]/following-sibling::*/span/span[@class='k-input']");
	public By SSN = By.xpath("//input[@id='SSN']");
	public By FirstName = By.xpath("//input[@id='FirstName']");
	// public By CopyDataClosebttn =
	// By.xpath("//span[@id='drawerId-3_label']/parent::*/button[@id='drawer-close-button-drawerId-3']/span[@role='presentation']");
	public By CopyDataClosebttn = By.xpath(
			"//span[contains(text(),'Copy Data ')]/../button[@aria-label='Close Drawer']/span[@role='presentation']");
	public By MiddleName = By.xpath("//input[@id='MiddleName']");
	public By LastName = By.xpath("//input[@id='LastName']");
	public By Savebttn = By.xpath("//button[@type='submit']");
	public By CashPriceIV = By.xpath("//label[contains(text(),'Cash Price')]/../kendo-numerictextbox/span/input");
	public By Dealer = By.xpath("//label[contains(text(),'Dealer')]/../div/kendo-autocomplete/kendo-searchbar/input");

	// Applicant Summary
	public By AccountNo = By.xpath("//input[@id='AccountNumber_maskedInput']");
	public By InstRelationship = By.xpath(
			"//label[contains(text(), 'Institution Relationship')]/following-sibling::*/span/span[@class='k-input']");
	public By DOB = By.xpath(
			"//label[contains(text(), 'Date of Birth ')]/parent::*/kendo-datepicker/span/kendo-dateinput/span/input[contains(@class,'k-input')]");
	public By MaritalstatusDropDown = By.xpath(
			"//label[contains(text(), 'Marital Status')]/parent::*/kendo-dropdownlist/span/span[@class='k-input']");
	public By DLNumber = By.xpath("//input[@id='DriversLicenseNumber']");
	public By Occupation = By.xpath("//input[@id='Occupation']");
	public By OccupationLength = By.xpath(
			"//label[contains(text(), ' Occupation Length ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");
	public By PreferredMethod = By.xpath(
			"//label[contains(text(),'Preferred Method')]/parent::*/div/kendo-dropdownlist/span/span[contains(@class,'k-input')]");
	public By HomePhone = By.xpath("//input[@id='HomeNumber']");
	public By ContactFavorite = By
			.xpath("//input[@id='HomeNumber']/parent::*/label[@title='Click to select as favorite']");
	public By Email1 = By.xpath("//label[contains(text(),' Email 1 ')]/../div/input[@id='Primary']");
	public By SSN2 = By.xpath("//input[@id='IdentificationNumber']");
	public By FirstName2 = By.xpath("//input[@id='FirstName']");
	public By LastName2 = By.xpath("//input[@id='LastName']");
	public By CancelApplicant = By
			.xpath("//*[@id='k-panelbar-1-item-default-5']/div/div/div/div/ul/li[2]/button/text()");

	// Address fields
	public By Address = By.xpath("//span[@data-compname='adressInformation']/parent::*");
	public By AddressType = By
			.xpath("//label[contains(text(), 'Address Type')]/../kendo-dropdownlist/span/span[@class='k-input']");
	public By AddressStatus = By.xpath("//label[text()=' Status ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By Lengthyrs = By.xpath(
			"//label[text()=' Length ']/../div/kendo-numerictextbox/span[contains(@class,'k-numeric')]/input[contains(@class,'k-input')]");
	public By MonthlyPayment = By
			.xpath("//label[text()=' Monthly Payment ']/../kendo-numerictextbox/span/input[@role='spinbutton']");
	public By AddressDesc = By.xpath("//textarea[@id='AddressDesc']");
	public By Address1 = By.xpath("//input[@id='FirstLine']");
	public By ZipCode = By.xpath("//label[contains(text(),'Zip Code')]/../div/input[@type='text']");
	public By City = By.xpath("//input[@id='City']");
	public By AddButton = By.xpath("//button[@type='submit' and contains(text(),'Add')]");
	public By QuickSearch = By.xpath("//*[@id='search']");
	public By Address1NAS = By.xpath("(//input[@id='FirstLine'])[1]");
    public By ZipCodeNAS = By.xpath("(//label[contains(text(),'Zip Code')]/../div/input[@type='text'])[1]");
	
	// Employment fields
	public By Employers = By.xpath("//span[@data-compname = 'employersInformation']/parent::*");
	public By EmpAdd1 = By.xpath("//input[@id='FirstLine']");
	public By EmpZipCode = By.xpath("//label[contains(text(),'Zip Code')]/../div/input[@type='text']");
	public By EmpCity = By.xpath("//input[@id='City']");
	public By EmpSupervisor = By.xpath("//input[@id='SupervisorName']");
	public By EmpType = By.xpath("//label[text()=' Type ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By EmployerName = By
			.xpath("//label[contains(text(),' Employer Name ')]/following-sibling::input[@id='Name']");
	public By EmployerLengthYr = By.xpath(
			"//label[contains(text(),'Length')]/../div/kendo-numerictextbox/span[contains(@class,'k-numeric')]/input[contains(@class,'k-input')]");
	public By EmployerPosition = By.xpath("//input[@id='PositionTitle']");
	public By EmployerAmount = By.xpath(
			"//label[contains(text(),' Amount ')]/../kendo-numerictextbox/span[contains(@class,'k-numeric')]/input[contains(@class,'k-input')]");
	public By Frequency = By.xpath(
			"//label[contains(text(),' Frequency ')]/../kendo-dropdownlist/span/span[contains(@class,'k-input')]");
	// public By Addbutton = By.xpath("//button[@type='submit']");
	public By CTRLM = By.xpath("//div[contains(text(), ' Ctrl + M')]");
	public By EmpAddress1NAS = By.xpath("(//input[@id='FirstLine'])[2]");
    public By EmpZipCodeNAS = By.xpath("(//label[contains(text(),'Zip Code')]/../div/input[@type='text'])[2]");

	// Income
	public By Income = By.xpath("//span[@data-compname = 'incomeInformation']/parent::*");
	public By AddNewIncome = By.xpath("//a[@class='ml-auto mb-3 uppercase-link']/span");
	public By IncomeType = By
			.xpath("//label[text()=' Income Type ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By IncomeSource = By.xpath("//input[@id='SourceDescription']");
	public By IncomeAmount = By.xpath(
			"//label[contains(text(), ' Amount ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");
	public By IncomeAmountNAS = By.xpath("(//label[contains(text(), ' Amount ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')])[2]");

	// Asset
	public By Asset = By.xpath("//span[@data-compname = 'assestsInformation']/parent::*");
	public By AssetType = By.xpath("//label[text()=' Asset Type ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By AssetDescription = By.xpath("//textarea[@id='Description']");
	public By AssetCashMarketValue = By.xpath(
			"//label[contains(text(),'Cash/Market Value ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");
	public By AssetLoanBalance = By.xpath(
			"//label[contains(text(),'Loan Balance ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");
	// public By AssetAccountNumber =
	// By.xpath("//label[@for='AccountNumber']/../input[contains(@id,'AccountNumber')][1]");
	// public By AssetAccountNumber =
	// By.xpath("//label[@for='AccountNumber']/../div/input[@id='AccountNumber_maskedInput']");
	public By AssetAccountNumber = By.xpath(
			"//label[contains(text(), 'Date Opened')]/../../..//label[contains(text(), 'Account Number')]//following::input[1] ");
	public By AssetInstitution = By.xpath("//input[@id='InstitutionName']");
	public By AssetDateOpened = By.xpath(
			"//label[contains(text(), 'Date Opened ')]/parent::*/kendo-datepicker/span/kendo-dateinput/span/input[contains(@class,'k-input')]");
	public By AssetAddress1 = By.xpath("//input[@id='FirstLine']");
	public By AssetZipCode = By.xpath("//label[contains(text(),'Zip Code')]/../div/input[@type='text']");
	public By AssetAddress1NAS = By.xpath("(//input[@id='FirstLine'])[3]");
    public By AssetZipCodeNAS = By.xpath("(//label[contains(text(),'Zip Code')]/../div/input[@type='text'])[3]");

	// Liabilities
	public By Liability = By.xpath("//span[@data-compname = 'liabilitiesInformation']/parent::*");
	public By LiabilityType = By
			.xpath("//label[text()=' Liability Type ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By LiabilityDescription = By.xpath("//textarea[@id='Description']");
	public By LiabilityCashMarketValue = By.xpath(
			"//label[contains(text(),'Cash/Market Value ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");
	public By LiabilityLoanBalance = By.xpath(
			"//label[contains(text(),'Loan Balance ')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");
	public By LiabilityAccountNumber = By.xpath(
			"//label[contains(text(), 'Date Opened')]/../../..//label[contains(text(), 'Account Number')]//following::input[1] ");
	public By LiabilityInstitution = By.xpath("//input[@id='InstitutionName']");
	public By LiabilityDateOpened = By.xpath(
			"//label[contains(text(), 'Date Opened ')]/parent::*/kendo-datepicker/span/kendo-dateinput/span/input[contains(@class,'k-input')]");
	public By LiabilityAddress1 = By.xpath("//input[@id='FirstLine']");
	public By LiabilityZipCode = By.xpath("//label[contains(text(),'Zip Code')]/../div/input[@type='text']");
	public By LiabilityAddress1NAS = By.xpath("(//input[@id='FirstLine'])[4]");
    public By LiabilityZipCodeNAS = By.xpath("(//label[contains(text(),'Zip Code')]/../div/input[@type='text'])[4]");

	// References
	public By References = By.xpath("//span[@data-compname = 'referencesInformation']/parent::*");
	public By ReferenceType = By
			.xpath("//label[text()=' Reference Type ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By ReferenceRelationship = By
			.xpath("//label[text()=' Relationship ']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By ReferenceFirstName = By.xpath(
			"//div[text()=' Add New Reference ']/..//form/div/following-sibling::*/div/following-sibling::*/div/input[@id='FirstName']");
	public By ReferenceLastName = By.xpath(
			"//div[text()=' Add New Reference ']/..//form/div/following-sibling::*/div/following-sibling::*/div/input[@id='LastName']");
	public By ReferenceDOB = By.xpath(
			"//label[contains(text(),'Date Of Birth')]/../kendo-datepicker//kendo-dateinput//input[@class='k-input']");
	public By ReferencePhoneNumber = By.xpath("//input[@id='PhoneNumber']");
	public By ReferenceAddress1 = By.xpath("//input[@id='FirstLine']");
	public By ReferenceZipCode = By.xpath("//label[contains(text(),'Zip Code')]/../div/input[@type='text']");
	public By RefAddress1NAS = By.xpath("(//input[@id='FirstLine'])[5]");
    public By RefZipCodeNAS = By.xpath("(//label[contains(text(),'Zip Code')]/../div/input[@type='text'])[5]");
    public By RefNASPhoneNumber = By.xpath("(//input[@id='PhoneNumber'])[2]");

	// Add Applicant
	public By AddApplicant = By.xpath("//i[contains(text(),'person_add')]/..");
	public By RegBCreditType = By.xpath("//button[text()='Yes']");

	// NAS
	public By CommunityProperty = By.xpath("//button[text()=' OK ']");
	public By BorrowerType = By
			.xpath("//label[text()=' Borrower Type ']/../kendo-dropdownlist/span/span[@class='k-select']");
	public By Spouse = By.xpath("//label[text()=' Spouse ']/../kendo-dropdownlist/span/span[@class='k-select']");

	// ContractDetails

	public By RoundPayment = By.xpath(
			"//*[@id=\"k-panelbar-2-item-default-6\"]/div/div/div[1]/form/div[1]/div[4]/velocity-form-checkbox/div/div/label");
	public By ContractDetailsLoanAmount = By.xpath(
			"//div[@class='form-group']/label[contains(text(),'Loan Amount:')]/../kendo-numerictextbox/span/input[contains(@class,'k-input')]");

	// Repayment Method
	public By RMTitle = By.xpath("//span[contains(text(),'Repayment Method')]");
	public By RepaymentMethod = By.xpath(
			"//div[@id='RepaymentMethodID_column']/div/kendo-dropdownlist/span/span[contains(@class,'k-input')]");
	public By RMAccountNumber = By.xpath("//input[@id='RepayAccountNumber_maskedInput']");
	public By RMAccountSuffix = By.xpath("//input[@id='RepayAccountSuffix_maskedInput']");
	public By RMCompanyName = By.xpath("//input[@id='PayrollCompanyName']");

	// Payment protection

	public By SalesStatus = By
			.xpath("///label[contains(text(),'Sales Status')]/..//span/span[contains(@class,'k-input')]");

	// comments

	public By Comment = By.xpath("//input[@id='NoteText']");

	// CollateralSelection
	public By CollateralCategory = By.xpath("//label[contains(text(),'Category')]/..//span/span[@class='k-input']");
	public By CollateralName = By.xpath("//label[contains(text(),'Name')]/..//span/span[@class='k-input']");

	// Residential Property Details
	public By OwnerName = By.id("OwnerName");
	public By EstimatedValue = By.xpath(
			"//label[contains(text(),'Estimated Value')]/..//span[contains(@class,'k-numeric')]/input[contains(@class,'k-input')]");

	// Mortgage Details
	public By MortgageDetails = By.xpath("//ul[@role='tablist']/li[3]/span[contains(text(),'Mortgage Details')]");
	public By LienPosition = By
			.xpath("//label[contains(text(),' Lien Position ')]/../kendo-dropdownlist/span/span[@class='k-input']");
	public By MortgageHolder = By.id("MortgageHolderName");
	public By MDPhoneNumber = By
			.xpath("//input[@id='MortgageHolderName']/../../following-sibling::*/div/input[@id='PhoneNumber']");
	public By MDDateOpen = By
			.xpath("//label[@for='MortgageDateOpened']/../kendo-datepicker/span/kendo-dateinput/span/input");
	public By MDExistingPI = By.xpath(
			"//app-mortgage-details-form/div/div/following-sibling::*/div/following-sibling::*/following-sibling::*/div/label[@for='MortgageExistingPI']/../kendo-numerictextbox/span/input");
	public By MDExistingPITI = By.xpath(
			"//app-mortgage-details-form/div/div/following-sibling::*/div/following-sibling::*/following-sibling::*/following-sibling::*/div/label[@for='MortgageExistingPITI']/../kendo-numerictextbox/span/input");
	public By MDMonthlypayment = By.xpath(
			"//app-mortgage-details-form/div/div/following-sibling::*/div/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/div/label[@for='MortgageMonthlyPayment']/../kendo-numerictextbox/span/input");
	public By MDIntRate = By.xpath(
			"//app-mortgage-details-form/div/div/following-sibling::*/div/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/div/label[@for='MortgageInterestRate']/../kendo-numerictextbox/span/input");
	public By MDBalance = By.xpath(
			"//app-mortgage-details-form/div/div/following-sibling::*/div/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/div/label[@for='MortgageBalance']/../kendo-numerictextbox/span/input");
	//public By MDPayoff = By.xpath("//app-mortgage-details-form/div/div/following-sibling::*/div/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/following-sibling::*/div/label[@for='MortgagePayoffAmount']/../kendo-numerictextbox/span/input");
	public By MDPayoff = By.xpath("//label[@for='MortgagePayoffAmount']/../kendo-numerictextbox/span/input");
	public By MDAddress1 = By.xpath("//app-mortgage-details-form/div/app-velocity-address/div/div/div/label[text()=' Address 1 ']/../input[@id='FirstLine']");
	public By MDZipCode = By.xpath("//app-mortgage-details-form/div/app-velocity-address/div[2]/div/div/label[text()=' Zip Code ']/../div/input");
	public By AddMortgage = By.xpath("//app-mortgage-details/div/div/div/div/div/button[@type='submit']");
	
	//Real Estate Costs
	public By RealEstateCosts = By.xpath("//ul[@role='tablist']/li[4]/span[contains(text(),'Real Estate Costs')]");
	public By EscrowPaymentType = By.xpath("//label[text()=' Escrow Payment Type ']/../kendo-dropdownlist/span/span[@class='k-select']");
	public By CostDescription = By.xpath("//input[@id='CostDescription']");
	public By RECostPayment = By.xpath("//label[@for='RealEstateCostsMonthlyPayment']/../kendo-numerictextbox/span/input");
	//public By Escrowed= By.xpath("//div/label[@for='IsEscrowedInd27']");
	public By Escrowed = By.xpath("//span[text()='Escrowed']/parent::*");
	public By AddRECosts = By.xpath("//*[@id=\"k-tabstrip-tabpanel-3\"]/app-real-estate-costs/div/div/div[3]/div/div/button[2]");
	
	//RE insurance
	
	public By REInsurance = By.xpath("//ul[@role='tablist']/li[5]/span[@class='k-link' or text()='Insurance']");
	public By InsPolicyType = By.xpath("//label[text()=' Policy Type ']/../kendo-dropdownlist/span/span[@class='k-select']");
	public By InsPolicyNo = By.id("PolicyNumber");
	public By InsExpDate = By.xpath("//label[text()=' Exp Date ']/../kendo-datepicker/span/kendo-dateinput/span/input");
	public By InsCoverage = By.xpath("//label[text()=' Coverage ']/../kendo-numerictextbox/span/input");
	public By InsDeductible = By.xpath("//label[text()=' Deductible ']/../kendo-numerictextbox/span/input");
	public By InsPremium = By.xpath("//label[text()=' Premium ']/../kendo-numerictextbox/span/input");
	public By InsCompany = By.id("InsuranceCompanyName");
	public By InsAgent = By.id("InsuranceAgent");
	public By InsPhone = By.xpath("//app-insurance-form/div/div/div[9]/div/input");
	public By InsAddress1 = By.xpath("//app-insurance-form/div/app-velocity-address/div/div/div/input[@id='FirstLine']");
	public By InsZipCode = By.xpath("//app-insurance-form/div/app-velocity-address/div/div/div/div/input");
	public By AddInsurance = By.xpath("//app-insurance/div/div/div/div/div/button[@type='submit']");
	
	//Collateral Owner
	
	public By CollateralOwner = By.xpath("//ul[@role='tablist']/li[6]/span[@class='k-link' or text()='Collateral Owners']");
	public By CollateralOwnerName = By.xpath("//label[text()=' Other Owner Name ']/following-sibling::input[@id='OwnerName']");
	public By CollOwnerAddress1 = By.xpath("//app-owners-form/div/app-velocity-address/div/div/div/label[text()=' Address 1 ']/following-sibling::input[@id='FirstLine']");
	public By CollOwnerZipCode = By.xpath("//app-owners-form/div/app-velocity-address/div/div/div/label[text()=' Zip Code ']/../div/input");
	public By AddCollateralOwner = By.xpath("//app-owners-form/../following-sibling::div/div/div/button[@type='submit']");
	
	
	
	//Existing Lien Info
	
	public By ExistingLien = By.xpath("//ul[@role='tablist']/li[7]/span[@class='k-link' or text()='Existing Lien Details']");
	public By LienHolder = By.xpath("//input[@id='LienHolder']");
	public By ExistLienPosition = By.xpath("//app-existing-lien-details-form/div//div/label[text()=' Lien Position ']/../kendo-dropdownlist/span/span/span");
	public By ExistLienDesc = By.xpath("//input[@id='Description']");
	public By ExistLienPhoneNo = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Phone Number ']/../input[@id='PhoneNumber']");
	public By ExistLienFaxNo = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Fax Number ']/../input[@id='FaxNumber']");
	public By ExistLienAccNo = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Account Number ']/../input[@id='AccountNumber']");
	public By ExistLienDateOpen = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Date Open ']/../kendo-datepicker/span/kendo-dateinput/span/input");
	public By ExistLienPI = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Existing PI ']/../kendo-numerictextbox/span/input");
	public By ExistLienPITI = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Existing PITI ']/../kendo-numerictextbox/span/input");
	public By ExistLienPayment = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Monthly Payment ']/../kendo-numerictextbox/span/input");
	public By ExistLienRate = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Int. Rate ']/../kendo-numerictextbox/span/input");
	public By ExistLienBalance = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Balance ']/../kendo-numerictextbox/span/input");
	public By ExistLienPayoff = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Pay Off ']/../kendo-numerictextbox/span/input");
	public By ExistLienDebtSpread = By.xpath("//app-existing-lien-details-form/div/div/div/div/label[text()=' Debt Spread Percentage ']/../kendo-numerictextbox/span/input");
	public By ExistLienAdd1 = By.xpath("//app-existing-lien-details-form/div/app-velocity-address/div/div/div/label[text()=' Address 1 ']/following-sibling::input[@id='FirstLine']");
	public By ExistLienZipCode = By.xpath("//app-existing-lien-details-form/div/app-velocity-address/div/div/div/label[text()=' Zip Code ']/../div/input");
	public By AddExistLien = By.xpath("//app-existing-lien-details-form/../following-sibling::div/div/div/button[@type='submit']");
	
	//Lien Filing
	
	public By LienFiling = By.xpath("//ul[@role='tablist']/li[8]/span[@class='k-link' or text()='Lien Filing']");
	public By LienFilingYes = By.xpath("//app-lien-filing/div/div/div[1]/div/div[2]/app-segment-button/div/label[1]");
	public By WhoFiled = By.xpath("//input[@id='LienFiledBy']");
	//public By DateFiled = By.xpath("//label[text()=' Date Filed ']/../kendo-datepicker/span/kendo-dateinput/span/input");
	public By DateFiled = By.xpath("//label[text()=' Date Filed ']/../kendo-datepicker/span/span/span");
	//public By DateReceived = By.xpath("//label[text()=' Date Received ']/../kendo-datepicker/span/kendo-dateinput/span/input");
	public By TodaysDate = By.xpath("//span[@class='k-today']");
	public By DateReceived = By.xpath("//label[text()=' Date Received ']/../kendo-datepicker/span/span/span");
	
	
	// Titled Goods Collateral KBB details

	public By KBBYear = By.xpath("//label[@for='BlueBookModelYear']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By KBBMake = By.xpath("//label[@for='BlueBookMake']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By KBBModel = By.xpath("//label[@for='BlueBookModel']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By KBBSubModel = By
			.xpath("//label[@for='BlueBookSubModel']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By KBBBodyStyle = By
			.xpath("//label[@for='BlueBookBodyStyle']/../kendo-dropdownlist/span/span[@class='k-input']");
	public By KBBEngineSize = By.xpath("//label[@for='BlueBookEngineSize']/../kendo-numerictextbox/span/input");
	public By KBBGetOptionsbttn = By.xpath("//button[text()='Get Options']");
	public By KBBGetPricing = By.xpath("//button[@id='cmdGetPricing']");
	public By KBBGetPricingYesbttn = By.xpath("//button[text()=' Yes ']");

	// click Next, Submit, Save
	public By Nextbttn = By.xpath("//button[contains(text(),'Next')]");
	public By Submitbttn = By.xpath("//button[contains(text(),'Submit')]");
	public By Save = By.xpath("//button[text()='Save']");

	// close action status window
	public By Closebttn = By.xpath("//button[contains(text(),'Close') and @class=' ml-auto btn btn-secondary']");
	
	//unsaved changes
	public By UnsavedChangesYes = By.xpath("//button[text()=' Yes ']");

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

	public void enterRequestedAmt(String ReqAmount) {
		System.out.println("inside the method enter amount");
		// try {
		element.sync().pause(5);
		element.sync().waitForElement(RequestedAmt);
		element.click(RequestedAmt, "");
		element.sendKeys(RequestedAmt, ReqAmount, "Enter RequestedAmt :" + ReqAmount);
		element.sendKeys(RequestedAmt, ReqAmount, "Enter RequestedAmt");
	}
	/*
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 */

	public void enterCashPriceIV(String cashpriceiv) {
		/*
		 * try { Thread.sleep(10000);
		 */
		element.sync().pause(10);
		System.out.println("enter cash price");
		element.click(CashPriceIV, "");
		System.out.println("cursor on cash price");
		element.sendKeys(CashPriceIV, cashpriceiv, "");
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

	public void selectdeliverymethod(String deliverymethod) {
		element.sync().pause(5);
		String methodstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + deliverymethod
				+ "']";
		By selectdeliverymethod = By.xpath(methodstring);
		element.click(DeliveryMethodDropDown, "Click on Delivery Method  DropDown");
		element.click(selectdeliverymethod, "");
	}

	public void enterSSN(String ssn) {
		element.sync().pause(10);
		System.out.println("inside the method enter SSN");
		element.click(SSN, "Click SSN");
		element.sendKeys(SSN, ssn, "Enter SSN" + ssn);
	}

	public void enterFirstName(String firstname) {
		element.click(FirstName, "click First Name" + firstname);
		/*
		 * try { Thread.sleep(15000);
		 */
		element.sync().pause(15);
		element.click(CopyDataClosebttn, "Close the Copy Data page");
		element.sync().pause(10);
		/*
		 * Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		element.sync().waitForElement(FirstName);
		element.sendKeys(FirstName, firstname, "Enter FirstName");
	}

	public void enterMiddleName(String middlename) {

		element.sendKeys(MiddleName, middlename, "Enter MiddleName :" + middlename);
	}

	public void enterLastName(String lastname) {
		element.sendKeys(LastName, lastname, "Enter lastname:" + lastname);
	}

	public void clickSaveBttn() {
		element.sync().pause(5);
		element.click(Savebttn, "Click on Save button");
		System.out.println("Tried clicking Save");
	}

	// Applicant Summary
	public void selectInstReln(String instrel) {

		// try {
		String relationstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + instrel
				+ "']";
		By selectreln = By.xpath(relationstring);
		element.sync().pause(10);
		element.click(InstRelationship, "Click on Inst Reln DropDown");
		element.click(selectreln, "");
		/*
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	public void enterDateOfBirth(String dateofbirth) {
		element.jsExecute().scrollToElement(InstRelationship);
		System.out.println("Scrolled until DOB element");
		element.click(DOB, "click on DOB");
		element.sendKeys(DOB, dateofbirth, "Enter dateofbirth:" + dateofbirth);
	}

	public void selectMaritalStatus(String maritalstatus) {

		// try {
		String maritalstatusstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ maritalstatus + "']";
		By selectmaritalstatus = By.xpath(maritalstatusstring);
		// Thread.sleep(20000);
		element.sync().waitForElement(MaritalstatusDropDown);
		element.click(MaritalstatusDropDown, "Click on Marital status DropDown");
		element.click(selectmaritalstatus, "");
	}

	/*
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
	public void enterDriversLicense(String driverslicense) {

		element.jsExecute().scrollToElement(MaritalstatusDropDown);
		element.click(DLNumber, "click on DL");
		element.sendKeys(DLNumber, driverslicense, "Enter DL Number:" + driverslicense);
	}

	public void enterOccupation(String occupation) {

		element.click(Occupation, "click on occupation");
		System.out.println("clicked field occupation");
		element.sendKeys(Occupation, occupation, "Enter Occupation:" + occupation);
	}

	public void enterOccupationLength(String occupationlength) {

		element.click(OccupationLength, "click on occupationlength");
		System.out.println("clicked field occupation length");
		element.sendKeys(OccupationLength, occupationlength, "Enter Occupationlebgth:" + occupationlength);
	}

	public void SelectPreferredMethod(String preferred) {
		element.jsExecute().scrollToElement(DLNumber);
		String preferredmethodstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ preferred + "']";
		By selectpreferredmethod = By.xpath(preferredmethodstring);
		element.click(PreferredMethod, "Click on Preferred DropDown");
		element.click(selectpreferredmethod, "");
	}

	public void enterHomePhone(String phoneno) {
		element.click(HomePhone, "click phone");
		element.sendKeys(HomePhone, phoneno, "enter Phone Num");
	}

	public void selectfavcontact() {
		element.click(ContactFavorite, "select fav contact");
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

	public void enterFirstName2(String firstname2) {
		element.jsExecute().scrollToElement(SSN2);
		element.click(FirstName2, "click name");
		element.sendKeys(FirstName2, firstname2, "enter name");
	}

	public void enterLastName2(String lastname2) {
		element.click(LastName2, "click name");
		element.sendKeys(LastName2, lastname2, "enter lastname2");
	}

	// Address section

	public void clickAddress() {
		element.click(Address, "Click on Address");
	}

	public void selectAddressType(String addtype) {

		// try {
		String addtypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + addtype
				+ "']";
		By selecttype = By.xpath(addtypestring);
		element.sync().pause(10);
		element.click(AddressType, "Click on Address Type DropDown");
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
		element.click(AddressStatus, "Click on Address Status DropDown");
		element.click(selectstatus, "");
	}

	public void enterLengthyrs(String yrs) {
		element.click(Lengthyrs, "click length");
		element.sendKeys(Lengthyrs, yrs, "enter yrs");
	}

	public void enterMonthlyPayment(String monthlypayment) {
		element.click(MonthlyPayment, "click Payment");
		element.sendKeys(MonthlyPayment, monthlypayment, "enter payment");
	}

	public void enterAddDesc(String adddesc) {

		element.click(AddressDesc, "click desc");
		element.sendKeys(AddressDesc, adddesc, "enter desc");

	}

	public void enterAddress1(String add1) {
		element.jsExecute().scrollToElement(Address1);
		element.click(Address1, "click add1");
		element.sendKeys(Address1, add1, "enter add1");
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
		element.click(AddButton, "Add section details");
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
			element.click(EmployerName, "click employer name");
			element.sendKeys(EmployerName, employername, "enter employername");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterEmployerAddress(String empaddress) {
		element.sendKeys(EmpAdd1, empaddress, "enter address");
		System.out.println("Address displayed");
	}

	public void enterEmployerZipCode(String empzipcode) {

		System.out.println("enter zipcode function");
		element.jsExecute().click(EmpZipCode);
		element.click(CTRLM, "click Ctrl+M");
		System.out.println("clicked on CTRL+M");

		element.click(EmpZipCode, "click zipcode");
		element.sendKeys(EmpZipCode, empzipcode, "enter zipcode");
		element.click(EmpCity, "click City");
	}

	public void enterEmployerSupervisor(String supervisor) {
		element.jsExecute().scrollToElement(EmployerName);
		element.click(EmpSupervisor, "click on Supervisor");
		element.sendKeys(EmpSupervisor, supervisor, "enter supervisor name");
	}

	public void selectEmploymentType(String emptype) {

		String emptypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + emptype
				+ "']";
		By selectemptype = By.xpath(emptypestring);
		element.click(EmpType, "Click on Type dropdown");
		element.click(selectemptype, "");
	}

	public void enterEmployerLengthyrs(String emplenyrs) {
		element.jsExecute().scrollToElement(EmployerName);
		element.click(EmployerLengthYr, "click length");
		element.sendKeys(EmployerLengthYr, emplenyrs, "enter yrs");
	}

	public void enterEmployerPosition(String position) {
		element.sendKeys(EmployerPosition, position, "enter Position");
	}

	public void enterEmployerAmount(String empamount)

	{
		element.jsExecute().scrollToElement(EmployerLengthYr);
		element.click(EmployerAmount, "click amount");
		element.sendKeys(EmployerAmount, empamount, "enter amount");
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
		element.click(AddNewIncome, "Add New");
	}

	public void selectIncomeType(String incometype) {
		element.jsExecute().scrollToElement(IncomeSource);
		String incometypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + incometype
				+ "']";
		By selectincometype = By.xpath(incometypestring);
		element.click(IncomeType, "Click on Type dropdown");
		element.click(selectincometype, "");
	}

	public void enterSourceDescription(String sourcedescription) {
		element.click(IncomeSource, "click on source");
		element.sendKeys(IncomeSource, sourcedescription, "enter source");
	}

	public void enterAmount(String amount) {
		element.click(IncomeAmount, "click on Amount");
		element.sendKeys(IncomeAmount, amount, "enter amount");
		element.click(IncomeSource, "click to calculate monthly amount");
	}

	public void enterNASAmount(String amountNAS) {
		element.click(IncomeAmountNAS, "click on Amount");
		element.sendKeys(IncomeAmountNAS, amountNAS, "enter amount");
		element.click(IncomeSource, "click to calculate monthly amount");
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

	public void selectAssetType(String assettype) {
		try {
			Thread.sleep(5000);
			String assettypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
					+ assettype + "']";
			By selectassettype = By.xpath(assettypestring);
			element.click(AssetType, "Click on Type dropdown");
			element.click(selectassettype, "");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enterAssetDescription(String assetdescription) {
		element.sendKeys(AssetDescription, assetdescription, "asset desc");
	}

	public void enterAssetCashMarketValue(String cashmarketvalue) {
		element.sendKeys(AssetCashMarketValue, cashmarketvalue, "cash market value");
	}

	public void enterAssetLoanBalance(String loanbalance) {
		element.sendKeys(AssetLoanBalance, loanbalance, "cash market value");
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
		element.jsExecute().scrollToElement(AssetDateOpened);
		element.sendKeys(AssetInstitution, institution, "enter institute name");
	}

	public void enterAssetDateOpened(String assetdate) {
		try {
			Thread.sleep(1000);
			element.click(AssetDateOpened, "to enter date");
			element.sendKeys(AssetDateOpened, assetdate, "asset date");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enterAssetAddress1(String address1) {
		element.sendKeys(AssetAddress1, address1, "Address1");
	}

	public void enterAssetZipCode(String assetzipcode) {
		element.sendKeys(AssetZipCode, assetzipcode, "asset zipcode");
		element.click(AssetAddress1, "to populate city");
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

	public void selectLiabilityType(String liabilitytype) {
		try {
			Thread.sleep(10000);
			String liabilitytypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
					+ liabilitytype + "']";
			By selectliabilitytype = By.xpath(liabilitytypestring);
			element.click(LiabilityType, "Click on Type dropdown");
			element.click(selectliabilitytype, "");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterLiabilityDescription(String liabilitydescription) {
		element.sendKeys(LiabilityDescription, liabilitydescription, "liability desc");
	}

	public void enterLiabilityCashMarketValue(String liabilitycashmarketvalue) {
		element.sendKeys(LiabilityCashMarketValue, liabilitycashmarketvalue, "cash market value");
	}

	public void enterLiabilityLoanBalance(String liabilityloanbalance) {
		element.sendKeys(LiabilityLoanBalance, liabilityloanbalance, "loan balance");
	}

	public void enterLiabilityAccountNumber(String liabilityaccountnumber) {
		try {
			element.click(LiabilityAccountNumber, "click account number");
			Thread.sleep(5000);
			element.sendKeys(LiabilityAccountNumber, liabilityaccountnumber, "liability account number");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Liability accnt number not entered");
			e.printStackTrace();
		}

	}

	public void enterLiabilityInstitution(String liabilityinstitution) {
		element.jsExecute().scrollToElement(LiabilityDateOpened);
		element.sendKeys(LiabilityInstitution, liabilityinstitution, "enter institute name");
	}

	public void enterLiabilityDateOpened(String liabilitydate) {
		element.click(LiabilityDateOpened, "date opened");
		element.sendKeys(LiabilityDateOpened, liabilitydate, "liability date");
	}

	public void enterLiabilityAddress1(String liabilityaddress1) {
		element.sendKeys(LiabilityAddress1, liabilityaddress1, "Address1");
	}

	public void enterLiabilityZipCode(String liabilityzipcode) {

		element.sendKeys(LiabilityZipCode, liabilityzipcode, " zipcode");
		element.click(LiabilityAddress1, "to populate city");
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

	public void selectReferenceType(String referencetype) {
		try {
			Thread.sleep(5000);
			String referencetypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
					+ referencetype + "']";
			By selectreferencetype = By.xpath(referencetypestring);
			element.click(ReferenceType, "Click on Type dropdown");
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
			element.click(ReferenceRelationship, "Click on Type dropdown");
			element.click(selectrelntype, "");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterReferenceFirstName(String referencefirstname) {
		element.sendKeys(ReferenceFirstName, referencefirstname, "firstname");
	}

	public void enterReferenceLastName(String referencelastname) {
		element.sendKeys(ReferenceLastName, referencelastname, "lastname");
	}

	public void enterReferenceDOB(String referencedob) {
		element.jsExecute().scrollToElement(ReferenceFirstName);
		element.sendKeys(ReferenceDOB, referencedob, "dob");
	}

	public void enterReferencePhoneNumber(String referencephonenumber) {
		element.sendKeys(ReferencePhoneNumber, referencephonenumber, "phone");
	}
	public void enterRefNASPhoneNumber(String refnasphonenumber) {
		element.sendKeys(RefNASPhoneNumber, refnasphonenumber, "phone");
	}

	public void enterReferenceAddress1(String referenceaddress1) {
		element.sendKeys(ReferenceAddress1, referenceaddress1, "Address1");
	}

	public void enterReferenceZipCode(String referencezipcode) {
		element.sendKeys(ReferenceZipCode, referencezipcode, "reference zipcode");
		element.click(ReferenceAddress1, "");
	}

	// Add applicant
	public void addApplicant() {
		try {
			Thread.sleep(5000);
			element.click(AddApplicant, "add new applicant");
			element.sync().pause(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void NASCommunityProperty() {
		//element.sync().elementToBeClickable(CommunityProperty);
		element.sync().pause(5);
		element.click(CommunityProperty, "click OK");
		System.out.println("Clicked OK on Community Property");
	}

	public void enterNASAddress1(String nasadd1)
	{
		element.jsExecute().scrollToElement(Address1NAS);
		element.click(Address1NAS, "");
		element.sendKeys(Address1NAS, nasadd1, "");
	}
	public void enterNASZipCode(String naszc)
	{
		element.jsExecute().scrollToElement(ZipCodeNAS);
		element.click(ZipCodeNAS, "");
		element.sendKeys(ZipCodeNAS, naszc, "");
		element.click(Address1NAS, "populate city");
		element.sync().pause(3);
	}
	
	public void enterNASEmpAddress1(String empnasadd1)
	{
		element.click(EmpAddress1NAS, "");
		element.sendKeys(EmpAddress1NAS, empnasadd1, "");
	}
		
		public void enterNASEmpZipCode(String empzipcodenas)
		{

			System.out.println("enter zipcode function");
			element.jsExecute().click(EmpZipCodeNAS);
			element.click(CTRLM, "click Ctrl+M");
			System.out.println("clicked on CTRL+M");

			element.click(EmpZipCode, "click zipcode");
			element.sendKeys(EmpZipCodeNAS, empzipcodenas, "enter zipcode");
			element.click(EmpAddress1NAS, "click City");
			element.sync().pause(2);
		}

	
	
	public void enterNASAssetAddress1(String assetnasadd1)
	{
		element.click(AssetAddress1NAS, "");
		element.sendKeys(AssetAddress1NAS, assetnasadd1, "");
	}
	public void enterNASAssetZipCode(String assetnaszc)
	{
		element.click(AssetZipCodeNAS, "");
		element.sendKeys(AssetZipCodeNAS, assetnaszc, "");
	}
	
	public void enterNASLiabilityAddress1(String liabilitynasadd1)
	{
		element.click(LiabilityAddress1NAS, "");
		element.sendKeys(LiabilityAddress1NAS, liabilitynasadd1, "");
	}
	public void enterNASLiabilityZipCode(String liabilitynaszc)
	{
		element.click(LiabilityZipCodeNAS, "");
		element.sendKeys(LiabilityZipCodeNAS, liabilitynaszc, "");
	}
	
	public void enterNASRefAddress1(String refnasadd1)
	{
		element.click(RefAddress1NAS, "");
		element.sendKeys(RefAddress1NAS, refnasadd1, "");
	}
	public void enterNASRefZipCode(String refnaszc)
	{
		element.click(RefZipCodeNAS, "");
		element.sendKeys(RefZipCodeNAS, refnaszc, "");
	}
	
	public void selectBorrowerTypeNAS(String nas) {
		element.sync().pause(5);
		String NASstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + nas + "']";
		By selectNAS = By.xpath(NASstring);
		element.click(BorrowerType, "Click on Type dropdown");
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
			element.jsExecute().scrollToElementClick(RoundPayment);
			element.click(ContractDetailsLoanAmount, "click loan amount");
			element.sendKeys(ContractDetailsLoanAmount, cdloanamount, "enter loan amount");
			element.click(CTRLM, "click Ctrl+M");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Repayment Method

	public void selectRepaymentMethod(String method) {

		try {
			element.jsExecute().scrollToElement(RMTitle);
			String methodstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + method
					+ "']";
			By selectmethod = By.xpath(methodstring);
			Thread.sleep(20000);
			element.click(RepaymentMethod, "Click on Method DropDown");
			element.click(selectmethod, "");
			// element.click(CTRLM, "click ctrlm");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterRMAccountNumber(String accntnumber) {
		element.sendKeys(RMAccountNumber, accntnumber, "");
	}

	public void enterRMAccountSuffix(String accntsuffix) {
		element.sendKeys(RMAccountSuffix, accntsuffix, "");
	}

	public void enterRMCompanyName(String company) {
		element.sendKeys(RMCompanyName, company, "");
		element.click(CTRLM, "");
	}

	// Payment protection

	public void selectSalesStatus(String salesstatus) {
		String salesstatusstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ salesstatus + "']";
		By selectsalesstatus = By.xpath(salesstatusstring);
		element.click(SalesStatus, "Click on Sales status DropDown");
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
		element.click(CollateralCategory, "Click on Collateral Category");
		element.click(selectcategory, "");
	}

	public void selectCollateralName(String name) {
		String namestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + name + "']";
		By selectname = By.xpath(namestring);
		element.click(CollateralName, "Click on Name");
		element.click(selectname, "");
	}

	// Real Estate Collateral
	public void enterOwnerName(String owner) {
		try {
			Thread.sleep(10000);
			element.click(OwnerName, "name");
			element.sendKeys(OwnerName, owner, "enter name");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterEstimatedValue(String estimatedvalue) {

		element.jsExecute().scrollToElement(OwnerName);
		element.click(EstimatedValue, "estimated value");
		element.sendKeys(EstimatedValue, estimatedvalue, "enter value");
	}

	// Add RE Mortgage

	public void clickMortgage()

	{
		try {
			Thread.sleep(10000);
			element.click(MortgageDetails, "click mortgage");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectLien(String lienposition) {
		//element.jsExecute().scrollToElement(LienPosition);
		element.click(CTRLM, "");
		element.jsExecute().scrollDownTo(0, 0);
		element.click(CTRLM, "");
		element.sync().pause(5);
		String lienstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + lienposition
				+ "']";
		By selectlien = By.xpath(lienstring);
		element.click(LienPosition, "Click on Lien");
		element.click(selectlien, "");
		//element.sync().pause(5);
	}
	

	public void enterMortgageHolder(String mortgageholder) {
		element.sendKeys(MortgageHolder, mortgageholder, "");

	}

	public void enterMDPhone(String phone) {
		element.sendKeys(MDPhoneNumber, phone, "");
	}

	public void enterMDDateOpen(String date) {
		element.click(MDDateOpen, date);
		element.sendKeys(MDDateOpen, date, "");
	}

	public void enterMDPI(String pi) {
		element.sendKeys(MDExistingPI, pi, "");
	}

	public void enterMDPITI(String piti) {
		element.sendKeys(MDExistingPITI, piti, "");
	}

	public void enterMDPayment(String payment) {
		element.jsExecute().scrollToElement(MDMonthlypayment);
		element.sendKeys(MDMonthlypayment, payment, "");
	}

	public void enterMDIntRate(String Intrate) {
		element.sendKeys(MDIntRate, Intrate, "");
	}

	public void enterMDBalance(String balance) {
		element.sendKeys(MDBalance, balance, "");
	}

	public void enterMDPayoff(String mdpayoff) {
	//	element.sync().pause(2);
		element.click(MDPayoff, "");
		System.out.println("clicked on payoff, enter value now");
	    element.sendKeys(MDPayoff, mdpayoff, "");
		
	}
	
	public void enterMDAddress1(String mdaddress1)
	{
		element.jsExecute().scrollToBottom();
		
		element.click(MDAddress1, "");
		System.out.println("clicked address1, enter value now");
		element.sendKeys(MDAddress1,mdaddress1,"");
	}

	

	public void enterMDZipCode(String mdzipcode)
	{
		element.click(MDZipCode, "");
		System.out.println("clicked Zipcode, enter value now");
		element.sendKeys(MDZipCode,mdzipcode,"");
		element.click(MDAddress1, "populate values for zipcode");
		element.sync().pause(2);
	}
	
	public void addMortgage() {
		element.click(AddMortgage, "");
		element.sync().pause(5);
	}

	//Add Real Estate Costs
	
	public void clickRECosts()
	{
		element.sync().pause(5);
		element.click(RealEstateCosts, "");
	}
	
	public void selectEscrowPaymentType(String escrowpaytype)
	{
		element.sync().pause(5);
		String escrowstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + escrowpaytype
				+ "']";
		By selectescrowtype = By.xpath(escrowstring);
		element.click(EscrowPaymentType, "");
		element.click(selectescrowtype, "");
		element.sync().pause(2);	
	}
	
	public void enterCostDescription(String costdesc)
	{
				element.sendKeys(CostDescription,costdesc, "");
	}
	
	public void enterREMonthlyPayment(String remonthlypayment)
	{
				element.sendKeys(RECostPayment ,remonthlypayment, "");
	}
	
	public void checkEscrow()
	{
		//element.click(Escrowed, "check checkbox");
		//new Actions(driver).moveToElement(label, 1, 1).click().perform();
		 element.jsExecute().click(Escrowed);	
	
	}
	
	public void addRECosts()
	{
		
		element.click(AddRECosts, "Add RE Costs");
		element.sync().pause(5);
	}
	
	//RE Insurance
	public void clickREInsurance()
	{
		element.sync().pause(5);
		element.jsExecute().scrollToBottom();
		element.click(REInsurance, "");
	}
	
	public void selectREInsurancePolicyType(String reinsurancepolicytype)
	{
		element.sync().pause(8);
		String repolicytypestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + reinsurancepolicytype
				+ "']";
		By selectreinsurancepolicytype = By.xpath(repolicytypestring);
		element.click(InsPolicyType , "");
		element.click(selectreinsurancepolicytype, "");
		element.sync().pause(2);	
	}
	
	public void enterInsPolicyNo(String inspolicyno)
	{
		element.click(InsPolicyNo , "");
		element.sendKeys(InsPolicyNo, inspolicyno, "");
	}
	
	
	public void enterInsExpdate(String insexpdate)
	{
		element.click(InsExpDate , "");
		element.sendKeys(InsExpDate, insexpdate, "");
	}
	
	
	public void enterinsCoverage(String inscoverage)
	{
		element.sendKeys(InsCoverage ,inscoverage, "");
	}
	
	
	public void enterInsPremium(String inspremium)
	{
		element.sendKeys(InsPremium, inspremium, "");
	}
	
	
	public void enterInsDeductible(String insdeductible)
	{
		element.sendKeys(InsDeductible , insdeductible, "");
	}
	
	public void enterInsCompany(String inscompany)
	{
		element.sendKeys(InsCompany, inscompany, "");
	}
	
	public void enterInsAgent(String insagent)
	{
		element.sendKeys(InsAgent, insagent, "");
	}
	
	public void enterInsPhone(String insphone)
	{
		element.jsExecute().scrollToElement(InsPolicyNo);
		element.click(InsPhone, "");
		element.sendKeys(InsPhone, insphone, "");
	}
	
	public void enterInsAddress1(String insadd1)
	{
		element.click(InsAddress1, "");
		element.sendKeys(InsAddress1, insadd1, "");
	}
	
	public void enterInsZipCode(String inszipcode)
	{
		element.click(InsZipCode, "");
		element.sendKeys(InsZipCode, inszipcode, "");
		element.click(InsAddress1, "populate zipcode details");
	}

	public void addReInsurance()
	{
		element.sync().pause(5);
		element.click(AddInsurance,"add REInsurance");
	}
	
	
	//Collateral Owner
	
	public void clickCollateralOwner()
	{
		element.sync().pause(5);
		element.jsExecute().scrollToBottom();
		element.click(CollateralOwner, "");
		element.sync().pause(5);
	}
	
	public void enterCollOwnerName(String collownername)
	{
		element.click(CollateralOwnerName, "");
		element.sendKeys(CollateralOwnerName, collownername, "");
	}
	
	public void enterCollOwnerAddress1(String collowneradd1)
	{
		element.click(CollOwnerAddress1, "");
		element.sendKeys(CollOwnerAddress1, collowneradd1, "");
	}
	
	public void enterCollOwnerZipCode(String collownerzipcode)
	{
		element.click(CollOwnerZipCode,"");
		element.sendKeys(CollOwnerZipCode, collownerzipcode, "");
		element.click(CollOwnerAddress1, "");
	}
	
	public void addCollOwner()
	{
		element.click(AddCollateralOwner, "");
		element.sync().pause(5);
	}
	//Existing Lien details
	
	
	public void clickExistingLienDetails()
	{
		element.sync().pause(2);
		element.jsExecute().scrollToBottom();
		element.click(ExistingLien, "");
	}
	
	public void enterLienHolder(String lienholder)
	{
		element.sync().pause(2);
		element.sendKeys(LienHolder, lienholder, "");
	}
	
	public void selectExistLienPosition(String existlienposition) {
		String existlienstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + existlienposition
				+ "']";
		By selectexistlien = By.xpath(existlienstring);
		element.click(ExistLienPosition, "Click on Lien");
		element.click(selectexistlien, "");
		
	}
	
	public void enterExistLienDesc(String liendesc)
	{
		element.sync().pause(2);
		element.sendKeys(ExistLienDesc , liendesc, "");
	}
	
	public void enterExistLienPhoneNo(String lienphoneno)
	{
		element.sync().pause(2);
		element.sendKeys(ExistLienPhoneNo , lienphoneno, "");
	}
	
	public void enterExistLienfaxNo(String lienfaxno)
	{
		element.sync().pause(2);
		element.sendKeys(ExistLienFaxNo , lienfaxno, "");
	}
	
	public void enterExistLienAccNo(String lienaccno)
	{
		element.sync().pause(2);
		element.sendKeys(ExistLienAccNo  , lienaccno, "");
	}
	
	public void enterExistDateOpen(String liendateopen)
	{
		element.sync().pause(2);
		element.sendKeys(ExistLienDateOpen  , liendateopen, "");
	}
	public void enterExistLienPI(String lienpi)
	{
		element.jsExecute().scrollToBottom();
		element.sync().pause(2);
		element.sendKeys(ExistLienPI  , lienpi, "");
	}
	
	public void enterExistLienPITI(String lienpiti)
	{
		element.sync().pause(2);
		element.sendKeys(ExistLienPITI  , lienpiti, "");
	}
	
	public void enterExistLienPayment(String lienpayment)
	{
		element.sync().pause(2);
		element.sendKeys(ExistLienPayment  , lienpayment, "");
	}
	
	
	public void enterExistLienRate(String lienrate)
	{
		element.sync().pause(2);
		element.sendKeys(ExistLienRate  , lienrate, "");
	}
	
	public void enterExistLienBalance(String lienbalance)
	{
		element.sync().pause(2);
		element.sendKeys(ExistLienBalance  , lienbalance, "");
	}
	
	public void enterExistLienPayOff(String lienpayoff)
	{
		element.sync().pause(2);
		element.sendKeys(ExistLienPayoff  , lienpayoff, "");
	}
	public void enterExistLienDebtSpread(String liendebtspread)
	{
		element.sync().pause(2);
		element.sendKeys(ExistLienDebtSpread  , liendebtspread, "");
	}
	
	public void enterExistLienAddress1(String lienadd1)
	{
		
		element.sendKeys(ExistLienAdd1  , lienadd1, "");
	}
	
	public void enterExistLienZipCode(String lienzipcode)
	{
		
		element.sendKeys(ExistLienZipCode  , lienzipcode, "");
		element.click(ExistLienAdd1, "populate zipcode values");
		element.sync().pause(5);
	}
	
	public void addExistingLien()
	{
				element.click(AddExistLien  , "");
				element.sync().pause(5);
	}
	
	//Lien Filing
	
	public void clickLienFiling()
	{
		element.jsExecute().scrollToBottom();
		element.click(LienFiling, "");
		element.sync().pause(5);
	}
	
	
	public void clickLienFilingYes()
	{
	element.click(LienFilingYes, "");
	
	}
	
	
	public void enterFiledBy(String filedby)
	{
		element.sync().waitForElement(WhoFiled);
		element.sendKeys(WhoFiled, filedby, "");
	}
	
	public void enterDateFiled(String datefiled)
	{
		element.click(DateFiled, "");
		element.sync().pause(2);
		element.click(TodaysDate, "");
	}
	
	
	public void enterDateReceived(String datereceived)
	{
		element.click(DateReceived,"");
		element.sync().pause(2);
		element.click(TodaysDate, "");
		
	}
	
	
	
	
	// Titled Goods KBB Collateral

	public void selectKBBYear(String kbbyear) {
		element.jsExecute().scrollToElementClick(KBBYear);
		String kbbyearstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + kbbyear
				+ "']";
		By selectkbbyear = By.xpath(kbbyearstring);
		element.click(KBBYear, "Click on year DropDown");
		element.click(selectkbbyear, "");
	}

	public void selectKBBMake(String kbbmake) {

		String kbbmakestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + kbbmake
				+ "']";
		By selectkbbmake = By.xpath(kbbmakestring);
		element.click(KBBMake, "Click on Make DropDown");
		element.click(selectkbbmake, "");
	}

	public void selectKBBModel(String kbbmodel) {

		String kbbmodelstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='" + kbbmodel
				+ "']";
		By selectkbbmodel = By.xpath(kbbmodelstring);
		element.click(KBBModel, "Click on model DropDown");
		element.click(selectkbbmodel, "");
	}

	public void selectKBBSubModel(String kbbsubmodel) {

		String kbbsubmodelstring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ kbbsubmodel + "']";
		By selectkbbsubmodel = By.xpath(kbbsubmodelstring);
		element.click(KBBSubModel, "Click on submodel DropDown");
		element.click(selectkbbsubmodel, "");
	}

	public void selectKBBBodyStyle(String kbbbodystyle) {

		String kbbbodystylestring = "//*[contains(@class,'k-animation-container')][@dir='ltr']//li[text()='"
				+ kbbbodystyle + "']";
		By selectkbbbodystyle = By.xpath(kbbbodystylestring);
		element.click(KBBBodyStyle, "Click on Body style DropDown");
		element.click(selectkbbbodystyle, "");
	}

	public void clickKBBGetOptions() {
		element.click(KBBGetOptionsbttn, "");
	}

	public void clickKBBGetPricing() {
		element.jsExecute().scrollToElement(KBBEngineSize);
		element.click(KBBGetPricing, "");

	}
	

	public void clickKBBGetPricingYesbttn() {
		element.click(KBBGetPricingYesbttn, "");
		try {
			Thread.sleep(5000);
			element.jsExecute().scrollToElement(KBBYear);
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
			element.click(Nextbttn, "click Next");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickSubmit() {
		element.click(Submitbttn, "click Submit");
	}

	public void CloseActionStatuswindow() {
		element.click(Closebttn, "close action status window");
	}

	public void selectRegBCreditType() {
		element.sync().pause(5);
		element.click(RegBCreditType, "click yes");
	}


//unsaved changes pop-up

public void unsavedchangesYes()
{
	element.click(UnsavedChangesYes,"");
	element.sync().pause(5);
	
}
}









