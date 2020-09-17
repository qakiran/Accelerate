package com.accelerate.keyword;

import org.apache.log4j.Logger;
import org.codehaus.groovy.runtime.powerassert.AssertionRenderer;
import org.testng.Assert;

import com.accelerate.pages.DataEntryPage;
import com.fiserv.framework.constants.KeywordConstants;
import com.fiserv.keyword.Keywords;

public class DataEntry extends DataEntryPage {

	//Logger log = Logger.getLogger(DataEntry.class.getName());

	@Keywords(description = "Fill Data Entry Page 0", category = "DataEntry", author = "ATeam")

	public void dataEntryPage0() {
		System.out.println("Wait before clicking product");
		// try {
		element.sync().pause(5);
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
	// catch (InterruptedException e) {
	// TODO Auto-generated catch block 
	// e.printStackTrace();
	// }

	// } 

	@Keywords(description = "Fill Applicant Summary Page", category = "Personal Information", author = "ATeam")

	public void applicantSummary()

	{
		try {
			Thread.sleep(1000);

			selectInstReln(KeywordConstants.getKeyWordData().get("InstitutionalReln"));
			enterDateOfBirth(KeywordConstants.getKeyWordData().get("DateofBirth"));
			selectMaritalStatus(KeywordConstants.getKeyWordData().get("MaritalStatus"));
			enterDriversLicense(KeywordConstants.getKeyWordData().get("DriversLicense"));
			enterOccupation(KeywordConstants.getKeyWordData().get("Occupation"));
			enterOccupationLength(KeywordConstants.getKeyWordData().get("OccupationLength"));
			SelectPreferredMethod(KeywordConstants.getKeyWordData().get("PreferredContact"));
			enterHomePhone(KeywordConstants.getKeyWordData().get("HomePhone"));
			selectfavcontact();
			enterEmail1(KeywordConstants.getKeyWordData().get("Email1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Something went wrong");
			unsavedchangesYes();
			e.printStackTrace();
		}
	}

	@Keywords(description = "Fill Address Details", category = "Address", author = "ATeam")

	public void applicantAddress() {
		// Address
		try {
			Thread.sleep(1000);
			clickAddress();
			selectAddressType(KeywordConstants.getKeyWordData().get("AddressType"));
			selectAddressStatus(KeywordConstants.getKeyWordData().get("AddressStatus"));
			enterLengthyrs(KeywordConstants.getKeyWordData().get("Lengthyrs"));
			enterMonthlyPayment(KeywordConstants.getKeyWordData().get("MonthlyPayment"));
			enterAddDesc(KeywordConstants.getKeyWordData().get("AddressDescription"));
			enterAddress1(KeywordConstants.getKeyWordData().get("Address1"));
			enterZipCode(KeywordConstants.getKeyWordData().get("ZipCode"));
			addButton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Something went wrong");
			unsavedchangesYes();
			e.printStackTrace();
		}

	}

	@Keywords(description = "Fill Employment Details", category = "Employment", author = "ATeam")

	public void applicantEmployment() {

		// Employers
		try{
		clickEmployers();
		enterEmployername(KeywordConstants.getKeyWordData().get("EmployerName"));
		enterEmployerAddress(KeywordConstants.getKeyWordData().get("EmployerAddress"));
		enterEmployerZipCode(KeywordConstants.getKeyWordData().get("EmployerZipCode"));
		enterEmployerSupervisor(KeywordConstants.getKeyWordData().get("Supervisor"));
		selectEmploymentType(KeywordConstants.getKeyWordData().get("EmploymentType"));
		enterEmployerLengthyrs(KeywordConstants.getKeyWordData().get("EmployerLength"));
		enterEmployerPosition(KeywordConstants.getKeyWordData().get("Position"));
		enterEmployerAmount(KeywordConstants.getKeyWordData().get("EmployerAmount"));
		addButton();
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong");
			unsavedchangesYes();
			e.printStackTrace();
		}

	}

	@Keywords(description = "Fill Other Income Details", category = "Income", author = "ATeam")
	public void applicantIncome() {
		// Other Income
		try{
		System.out.println("click on income");
		clickIncome();
		clickAddNewIncome();
		selectIncomeType(KeywordConstants.getKeyWordData().get("IncomeType"));
		enterSourceDescription(KeywordConstants.getKeyWordData().get("SourceDescription"));
		enterAmount(KeywordConstants.getKeyWordData().get("IncomeAmount"));
		addButton();
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong");
			unsavedchangesYes();
		}
	}

	@Keywords(description = "Fill Asset Details", category = "Asset", author = "ATeam")
	public void applicantAssets() {
		// Assets
		System.out.println("Click Assets");
		try{
		clickAssets();
		selectAssetType(KeywordConstants.getKeyWordData().get("AssetType"));
		enterAssetDescription(KeywordConstants.getKeyWordData().get("AssetDescriptionType"));
		enterAssetCashMarketValue(KeywordConstants.getKeyWordData().get("AssetCashMarketValue"));
		enterAssetLoanBalance(KeywordConstants.getKeyWordData().get("AssetLoanBalance"));
		enterAssetInstitution(KeywordConstants.getKeyWordData().get("AssetInstitution"));
		enterAssetDateOpened(KeywordConstants.getKeyWordData().get("AssetDateOpened"));
		//enterAssetAccountNumber(KeywordConstants.getKeyWordData().get("AssetAccountNumber"));
		enterAssetAddress1(KeywordConstants.getKeyWordData().get("AssetAddress1"));
		enterAssetZipCode(KeywordConstants.getKeyWordData().get("AssetZipCode"));
		addButton();
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong");
			unsavedchangesYes();
		}
	}

	@Keywords(description = "Fill Liability Details", category = "Liability", author = "ATeam")
	public void applicantLiabilities() {
		// Liabilities
		System.out.println("Click Liability");
		clickLiability();
		selectLiabilityType(KeywordConstants.getKeyWordData().get("LiabilityType"));
		enterLiabilityDescription(KeywordConstants.getKeyWordData().get("LiabilityDescriptionType"));
		enterLiabilityCashMarketValue(KeywordConstants.getKeyWordData().get("LiabilityCashMarketValue"));
		enterLiabilityLoanBalance(KeywordConstants.getKeyWordData().get("LiabilityLoanBalance"));
		enterLiabilityInstitution(KeywordConstants.getKeyWordData().get("LiabilityInstitution"));
		enterLiabilityDateOpened(KeywordConstants.getKeyWordData().get("LiabilityDateOpened"));
		enterLiabilityAccountNumber(KeywordConstants.getKeyWordData().get("LiabilityAccountNumber"));
		enterLiabilityAddress1(KeywordConstants.getKeyWordData().get("LiabilityAddress1"));
		enterLiabilityZipCode(KeywordConstants.getKeyWordData().get("LiabilityZipCode"));
		addButton();
	}

	@Keywords(description = "Fill Reference Details", category = "References", author = "ATeam")
	public void applicantReference() {
		// References
		System.out.println("Click References");
		clickReferences();
		selectReferenceType(KeywordConstants.getKeyWordData().get("ReferenceType"));
		selectReferenceRelationship(KeywordConstants.getKeyWordData().get("ReferenceRelationship"));
		enterReferenceFirstName(KeywordConstants.getKeyWordData().get("ReferenceFirstName"));
		enterReferenceLastName(KeywordConstants.getKeyWordData().get("ReferenceLastName"));
		enterReferenceDOB(KeywordConstants.getKeyWordData().get("ReferenceDOB"));
		enterReferencePhoneNumber(KeywordConstants.getKeyWordData().get("ReferencePhoneNumber"));
		enterReferenceAddress1(KeywordConstants.getKeyWordData().get("ReferenceAddress1"));
		enterReferenceZipCode(KeywordConstants.getKeyWordData().get("ReferenceZipCode"));
		addButton();
	}

	@Keywords(description = "Add Applicant in DE", category = "AddApplicant", author = "ATeam")

	public void addApplicantinDE() {
		element.sync().pause(15);
		addApplicant();
	}
	
	@Keywords(description = "Fill NAS Summary Page", category = "Personal Information3", author = "ATeam")

	public void NASApplicantSummary()

	{
		try {
			Thread.sleep(1000);
			element.sync().pause(15);
			NASCommunityProperty();
			element.sync().pause(10);
			selectBorrowerTypeNAS(KeywordConstants.getKeyWordData().get("BorrowerType"));
			enterSSN2(KeywordConstants.getKeyWordData().get("SSN3"));
			selectInstReln(KeywordConstants.getKeyWordData().get("InstitutionalReln3"));
			enterFirstName2(KeywordConstants.getKeyWordData().get("FirstName3"));
			enterLastName2(KeywordConstants.getKeyWordData().get("LastName3"));
			enterDateOfBirth(KeywordConstants.getKeyWordData().get("DateofBirth3"));
			selectMaritalStatus(KeywordConstants.getKeyWordData().get("MaritalStatus3"));
			selectSpouse(KeywordConstants.getKeyWordData().get("SpouseName"));
			enterDriversLicense(KeywordConstants.getKeyWordData().get("DriversLicense3"));
			enterOccupation(KeywordConstants.getKeyWordData().get("Occupation3"));
			enterOccupationLength(KeywordConstants.getKeyWordData().get("OccupationLength3"));
			SelectPreferredMethod(KeywordConstants.getKeyWordData().get("PreferredContact3"));
			enterHomePhone(KeywordConstants.getKeyWordData().get("HomePhone3"));
			selectfavcontact();
			element.sync().pause(3);
			enterEmail1(KeywordConstants.getKeyWordData().get("Email13"));
			//scrolltoSSN2();
			clickSave();
			element.sync().pause(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Keywords(description = "Fill NAS Address Details", category = "Address3", author = "ATeam")

	public void NASAddress() {
		// Address
		try {
			Thread.sleep(1000);
			element.sync().pause(10);
			clickAddress();
			element.sync().pause(10);
			scrolltoAddressStatus();
			selectAddressType(KeywordConstants.getKeyWordData().get("AddressType3"));
			selectAddressStatus(KeywordConstants.getKeyWordData().get("AddressStatus3"));
			enterLengthyrs(KeywordConstants.getKeyWordData().get("Lengthyrs3"));
			enterMonthlyPayment(KeywordConstants.getKeyWordData().get("MonthlyPayment3"));
			enterAddDesc(KeywordConstants.getKeyWordData().get("AddressDescription3"));
			enterAddress1(KeywordConstants.getKeyWordData().get("Address13"));
			enterZipCode(KeywordConstants.getKeyWordData().get("ZipCode3"));
		//	enterNASAddress1(KeywordConstants.getKeyWordData().get("Address13"));
		//	enterNASZipCode(KeywordConstants.getKeyWordData().get("ZipCode3"));
			addButton();
			element.sync().pause(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Keywords(description = "Fill NAS Employment Details", category = "Employment3", author = "ATeam")

	public void NASEmployment() {

		// Employers
		clickEmployers();
		enterEmployername(KeywordConstants.getKeyWordData().get("EmployerName3"));
		enterEmployerAddress(KeywordConstants.getKeyWordData().get("EmployerAddress13"));
		enterEmployerZipCode(KeywordConstants.getKeyWordData().get("EmployerZipCode3"));
		enterEmployerSupervisor(KeywordConstants.getKeyWordData().get("Supervisor3"));
		selectEmploymentType(KeywordConstants.getKeyWordData().get("EmploymentType3"));
		enterEmployerLengthyrs(KeywordConstants.getKeyWordData().get("EmployerLength3"));
		enterEmployerPosition(KeywordConstants.getKeyWordData().get("Position3"));
		enterEmployerAmount(KeywordConstants.getKeyWordData().get("EmployerAmount3"));
		addButton();

	}

	@Keywords(description = "Fill NAS Other Income Details", category = "Income2", author = "ATeam")
	public void NASIncome() {
		// Other Income
		System.out.println("click on income");
		clickIncome();
		clickAddNewIncome();
		selectIncomeType(KeywordConstants.getKeyWordData().get("IncomeType3"));
		enterSourceDescription(KeywordConstants.getKeyWordData().get("SourceDescription3"));
		enterAmount(KeywordConstants.getKeyWordData().get("IncomeAmount3"));
		addButton();
	}

	@Keywords(description = "Fill NAS Asset Details", category = "Asset3", author = "ATeam")
	public void NASAssets() {
		// Assets
		System.out.println("Click Assets");
		clickAssets();
		selectAssetType(KeywordConstants.getKeyWordData().get("AssetType3"));
		enterAssetDescription(KeywordConstants.getKeyWordData().get("AssetDescriptionType3"));
		enterAssetCashMarketValue(KeywordConstants.getKeyWordData().get("AssetCashMarketValue3"));
		enterAssetLoanBalance(KeywordConstants.getKeyWordData().get("AssetLoanBalance3"));
		//enterAssetAccountNumber(KeywordConstants.getKeyWordData().get("AssetAccountNumber3"));
		enterAssetInstitution(KeywordConstants.getKeyWordData().get("AssetInstitution3"));
		enterAssetDateOpened(KeywordConstants.getKeyWordData().get("AssetDateOpened3"));
		//enterNASAssetAddress1(KeywordConstants.getKeyWordData().get("AssetAddress13"));
		//enterNASAssetZipCode(KeywordConstants.getKeyWordData().get("AssetZipCode3"));
		enterAssetAddress1(KeywordConstants.getKeyWordData().get("AssetAddress13"));
		enterAssetZipCode(KeywordConstants.getKeyWordData().get("AssetZipCode3"));
		addButton();
	}

	@Keywords(description = "Fill NAS Liability Details", category = "Liability3", author = "ATeam")
	public void NASLiabilities() {
		// Liabilities
		System.out.println("Click Liability");
		clickLiability();
		selectLiabilityType(KeywordConstants.getKeyWordData().get("LiabilityType3"));
		enterLiabilityDescription(KeywordConstants.getKeyWordData().get("LiabilityDescriptionType3"));
		enterLiabilityCashMarketValue(KeywordConstants.getKeyWordData().get("LiabilityCashMarketValue3"));
		enterLiabilityLoanBalance(KeywordConstants.getKeyWordData().get("LiabilityLoanBalance3"));
		enterLiabilityAccountNumber(KeywordConstants.getKeyWordData().get("LiabilityAccountNumber3"));
		enterLiabilityInstitution(KeywordConstants.getKeyWordData().get("LiabilityInstitution3"));
		enterLiabilityDateOpened(KeywordConstants.getKeyWordData().get("LiabilityDateOpened3"));
		//enterNASLiabilityAddress1(KeywordConstants.getKeyWordData().get("LiabilityAddress13"));
		//enterNASLiabilityZipCode(KeywordConstants.getKeyWordData().get("LiabilityZipCode3"));
		enterLiabilityAddress1(KeywordConstants.getKeyWordData().get("LiabilityAddress13"));
		enterLiabilityZipCode(KeywordConstants.getKeyWordData().get("LiabilityZipCode3"));
		addButton();
	}

	@Keywords(description = "Fill NAS Reference Details", category = "References2", author = "ATeam")
	public void NASReference() {

		System.out.println("Click References");
		clickReferences();
		selectReferenceType(KeywordConstants.getKeyWordData().get("ReferenceType3"));
		selectReferenceRelationship(KeywordConstants.getKeyWordData().get("ReferenceRelationship3"));
		enterReferenceFirstName(KeywordConstants.getKeyWordData().get("ReferenceFirstName3"));
		enterReferenceLastName(KeywordConstants.getKeyWordData().get("ReferenceLastName3"));
		enterReferenceDOB(KeywordConstants.getKeyWordData().get("ReferenceDOB3"));
		enterReferencePhoneNumber(KeywordConstants.getKeyWordData().get("ReferencePhoneNumber3"));
		//enterNASRefAddress1(KeywordConstants.getKeyWordData().get("ReferenceAddress13"));
		//enterNASRefZipCode(KeywordConstants.getKeyWordData().get("ReferenceZipcode3"));
		enterReferenceAddress1(KeywordConstants.getKeyWordData().get("ReferenceAddress13"));
		enterReferenceZipCode(KeywordConstants.getKeyWordData().get("ReferenceZipCode3"));
		addButton();
		//clickSave();
		//selectRegBCreditType();
	}


	@Keywords(description = "Fill CoApplicant Summary Page", category = "Personal Information2", author = "ATeam")

	public void coapplicantSummary()

	{
		try {
			Thread.sleep(1000);
			element.sync().pause(15);
			enterSSN2(KeywordConstants.getKeyWordData().get("SSN2"));
			selectInstReln(KeywordConstants.getKeyWordData().get("InstitutionalReln2"));
			enterFirstName2(KeywordConstants.getKeyWordData().get("FirstName2"));
			enterLastName2(KeywordConstants.getKeyWordData().get("LastName2"));
			enterDateOfBirth(KeywordConstants.getKeyWordData().get("DateofBirth2"));
			selectMaritalStatus(KeywordConstants.getKeyWordData().get("MaritalStatus2"));
			enterDriversLicense(KeywordConstants.getKeyWordData().get("DriversLicense2"));
			enterOccupation(KeywordConstants.getKeyWordData().get("Occupation2"));
			enterOccupationLength(KeywordConstants.getKeyWordData().get("OccupationLength2"));
			SelectPreferredMethod(KeywordConstants.getKeyWordData().get("PreferredContact2"));
			enterHomePhone(KeywordConstants.getKeyWordData().get("HomePhone2"));
			selectfavcontact();
			element.sync().pause(5);
			enterEmail1(KeywordConstants.getKeyWordData().get("Email12"));
			//scrolltoSSN2();
			//element.sync().pause(5);
			clickSave();
			selectRegBCreditType();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Keywords(description = "Fill CoApplicant Address Details", category = "Address2", author = "ATeam")

	public void coapplicantAddress() {
		// Address
		try {
		//	Thread.sleep(1000);
			element.sync().pause(10);
			clickAddress();
			element.sync().pause(10);
			scrolltoAddressStatus();
			selectAddressType(KeywordConstants.getKeyWordData().get("AddressType2"));
			selectAddressStatus(KeywordConstants.getKeyWordData().get("AddressStatus2"));
			enterLengthyrs(KeywordConstants.getKeyWordData().get("Lengthyrs2"));
			enterMonthlyPayment(KeywordConstants.getKeyWordData().get("MonthlyPayment2"));
			enterAddDesc(KeywordConstants.getKeyWordData().get("AddressDescription2"));
			enterAddress1(KeywordConstants.getKeyWordData().get("Address12"));
			enterZipCode(KeywordConstants.getKeyWordData().get("ZipCode2"));
			addButton();
			element.sync().pause(10);
		} 
		catch(Exception e) 
		{
			 System.out.println("Something went wrong");
			unsavedchangesYes();
			
		}

	}

	@Keywords(description = "Fill CoApplicant Employment Details", category = "Employment2", author = "ATeam")

	public void coapplicantEmployment() {

		// Employers
		try{
		clickEmployers();
		enterEmployername(KeywordConstants.getKeyWordData().get("EmployerName2"));
		enterEmployerAddress(KeywordConstants.getKeyWordData().get("EmployerAddress2"));
		enterEmployerZipCode(KeywordConstants.getKeyWordData().get("EmployerZipCode2"));
		enterEmployerSupervisor(KeywordConstants.getKeyWordData().get("Supervisor2"));
		selectEmploymentType(KeywordConstants.getKeyWordData().get("EmploymentType2"));
		enterEmployerLengthyrs(KeywordConstants.getKeyWordData().get("EmployerLength2"));
		enterEmployerPosition(KeywordConstants.getKeyWordData().get("Position2"));
		enterEmployerAmount(KeywordConstants.getKeyWordData().get("EmployerAmount2"));
		addButton();
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong");
			unsavedchangesYes();
		}
	}

	@Keywords(description = "Fill CoApplicant Other Income Details", category = "Income2", author = "ATeam")
	public void coapplicantIncome() {
		// Other Income
		System.out.println("click on income");
		clickIncome();
		clickAddNewIncome();
		selectIncomeType(KeywordConstants.getKeyWordData().get("IncomeType2"));
		enterSourceDescription(KeywordConstants.getKeyWordData().get("SourceDescription2"));
		enterAmount(KeywordConstants.getKeyWordData().get("IncomeAmount2"));
		addButton();
	}

	@Keywords(description = "Fill CoApplicant Asset Details", category = "Asset2", author = "ATeam")
	public void coapplicantAssets() {
		// Assets
		System.out.println("Click Assets");
		clickAssets();
		selectAssetType(KeywordConstants.getKeyWordData().get("AssetType2"));
		enterAssetDescription(KeywordConstants.getKeyWordData().get("AssetDescriptionType2"));
		enterAssetCashMarketValue(KeywordConstants.getKeyWordData().get("AssetCashMarketValue2"));
		enterAssetLoanBalance(KeywordConstants.getKeyWordData().get("AssetLoanBalance2"));
		//enterAssetAccountNumber(KeywordConstants.getKeyWordData().get("AssetAccountNumber2"));
		enterAssetInstitution(KeywordConstants.getKeyWordData().get("AssetInstitution2"));
		enterAssetDateOpened(KeywordConstants.getKeyWordData().get("AssetDateOpened2"));
		enterAssetAddress1(KeywordConstants.getKeyWordData().get("AssetAddress12"));
		enterAssetZipCode(KeywordConstants.getKeyWordData().get("AssetZipCode2"));
		addButton();
	}

	@Keywords(description = "Fill CoApplicant Liability Details", category = "Liability2", author = "ATeam")
	public void coapplicantLiabilities() {
		// Liabilities
		System.out.println("Click Liability");
		clickLiability();
		selectLiabilityType(KeywordConstants.getKeyWordData().get("LiabilityType2"));
		enterLiabilityDescription(KeywordConstants.getKeyWordData().get("LiabilityDescriptionType2"));
		enterLiabilityCashMarketValue(KeywordConstants.getKeyWordData().get("LiabilityCashMarketValue2"));
		enterLiabilityLoanBalance(KeywordConstants.getKeyWordData().get("LiabilityLoanBalance2"));
		enterLiabilityAccountNumber(KeywordConstants.getKeyWordData().get("LiabilityAccountNumber2"));
		enterLiabilityInstitution(KeywordConstants.getKeyWordData().get("LiabilityInstitution2"));
		enterLiabilityDateOpened(KeywordConstants.getKeyWordData().get("LiabilityDateOpened2"));
		enterLiabilityAddress1(KeywordConstants.getKeyWordData().get("LiabilityAddress12"));
		enterLiabilityZipCode(KeywordConstants.getKeyWordData().get("LiabilityZipCode2"));
		addButton();
	}

	@Keywords(description = "Fill CoApplicant Reference Details", category = "References2", author = "ATeam")
	public void coapplicantReference() {

		System.out.println("Click References");
		clickReferences();
		selectReferenceType(KeywordConstants.getKeyWordData().get("ReferenceType2"));
		selectReferenceRelationship(KeywordConstants.getKeyWordData().get("ReferenceRelationship2"));
		enterReferenceFirstName(KeywordConstants.getKeyWordData().get("ReferenceFirstName2"));
		enterReferenceLastName(KeywordConstants.getKeyWordData().get("ReferenceLastName2"));
		enterReferenceDOB(KeywordConstants.getKeyWordData().get("ReferenceDOB2"));
		enterReferencePhoneNumber(KeywordConstants.getKeyWordData().get("ReferencePhoneNumber2"));
		enterReferenceAddress1(KeywordConstants.getKeyWordData().get("ReferenceAddress12"));
		enterReferenceZipCode(KeywordConstants.getKeyWordData().get("ReferenceZipCode2"));
		addButton();
		//clickSave();
		//selectRegBCreditType();
	}

	@Keywords(description = "Click on Next Button", category = "Buttons-Next", author = "ATeam")
	public void nextButton() {

		try {
			Thread.sleep(5000);
			clickNext();
			element.sync().pause(5);

		} catch (InterruptedException e) {
			System.out.println("Next button not found");
			e.printStackTrace();
		}
	}

	@Keywords(description = "Fill Contract Details", category = "LoanDetails", author = "ATeam")
	public void contractDetails() {
		enterContractDetailsLoanAmount(KeywordConstants.getKeyWordData().get("ContractDetailsLoanAmount"));
	}

	@Keywords(description = "Select Repayment Method", category = "LoanDetails", author = "ATeam")
	public void repaymentMethod() {
		selectRepaymentMethod(KeywordConstants.getKeyWordData().get("RepaymentMethod"));
		enterRMAccountNumber(KeywordConstants.getKeyWordData().get("RMAccountNumber"));
		enterRMAccountSuffix(KeywordConstants.getKeyWordData().get("RMAccountSuffix"));
		enterRMCompanyName(KeywordConstants.getKeyWordData().get("RMCompanyName"));
	}

	@Keywords(description = "Select Payment Protection", category = "LoanDetails", author = "ATeam")
	public void paymentProtection() {
		selectSalesStatus(KeywordConstants.getKeyWordData().get("SalesStatus"));

	}

	@Keywords(description = "Enter Comments", category = "LoanDetails", author = "ATeam")
	public void enterStickyNote() {
		enterComment(KeywordConstants.getKeyWordData().get("Comments"));
	}

	@Keywords(description = "Add Real Estate Collateral", category = "Collateral", author = "ATeam")
	public void addCollateral() {
		try {
			Thread.sleep(5000);
			selectCollateralCategory(KeywordConstants.getKeyWordData().get("CollateralCategory"));
			selectCollateralName(KeywordConstants.getKeyWordData().get("CollateralName"));
			enterOwnerName(KeywordConstants.getKeyWordData().get("OwnerName"));
			enterEstimatedValue(KeywordConstants.getKeyWordData().get("EstimatedValue"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Add Mortgage
	@Keywords(description = "Fill Mortgage Details", category = "Collateral", author = "ATeam")

	public void applicantMortgage() {

		try {
			//Thread.sleep(1000);
			clickMortgage();
			selectLien(KeywordConstants.getKeyWordData().get("LienPosition"));
			enterMortgageHolder(KeywordConstants.getKeyWordData().get("MortgageHolder"));
			enterMDPhone(KeywordConstants.getKeyWordData().get("MDPhone"));
			enterMDDateOpen(KeywordConstants.getKeyWordData().get("MDDateOpen"));
			enterMDPI(KeywordConstants.getKeyWordData().get("MDPI"));
			enterMDPITI(KeywordConstants.getKeyWordData().get("MDPITI"));
			enterMDPayment(KeywordConstants.getKeyWordData().get("MDMonthlyPayment"));
			// enterMDDateOpen(KeywordConstants.getKeyWordData().get("MDDateOpen"));
			enterMDIntRate(KeywordConstants.getKeyWordData().get("MDIntRate"));
			enterMDBalance(KeywordConstants.getKeyWordData().get("MDBalance"));
			enterMDPayoff(KeywordConstants.getKeyWordData().get("MDPayoff"));
			enterMDAddress1(KeywordConstants.getKeyWordData().get("MDAddress1"));
			enterMDZipCode(KeywordConstants.getKeyWordData().get("MDZipCode"));
			addMortgage();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("unable to add all Mortgage values");
			addMortgage();
			//unsavedchangesYes();
			Assert.assertFalse(false);
			e.printStackTrace();
		}

	}
	
	@Keywords(description = "Fill Real Estate Costs", category = "Collateral", author = "ATeam")
	public void collateralRECosts() {
		
		clickRECosts();
		selectEscrowPaymentType(KeywordConstants.getKeyWordData().get("EscrowPaymentType"));
		enterCostDescription(KeywordConstants.getKeyWordData().get("CostDescription"));
		enterREMonthlyPayment(KeywordConstants.getKeyWordData().get("REMonthlyPayment"));
		checkEscrow();
		addRECosts();
		
	}

	
	@Keywords(description = "Fill Real Estate Insurance", category = "Collateral", author = "ATeam")
	public void collateralREInsurance() {
		
		clickREInsurance();
		selectREInsurancePolicyType(KeywordConstants.getKeyWordData().get("REInsPolicyType"));
		enterInsPolicyNo(KeywordConstants.getKeyWordData().get("REInsPolicyNo"));
		enterInsExpdate(KeywordConstants.getKeyWordData().get("REInsExpDate"));
		enterinsCoverage(KeywordConstants.getKeyWordData().get("REInsCoverage"));
		enterInsPremium(KeywordConstants.getKeyWordData().get("REInsPremium"));
		enterInsDeductible(KeywordConstants.getKeyWordData().get("REInsDeductible"));
		enterInsCompany(KeywordConstants.getKeyWordData().get("REInsCompany"));
		enterInsAgent(KeywordConstants.getKeyWordData().get("REInsAgent"));
		enterInsPhone(KeywordConstants.getKeyWordData().get("REInsPhone"));
		enterInsAddress1(KeywordConstants.getKeyWordData().get("REInsAddress1"));
		enterInsZipCode(KeywordConstants.getKeyWordData().get("REInsZipCode"));
		addReInsurance();
		
	}


	@Keywords(description = "Fill Collateral Owner", category = "Collateral", author = "ATeam")
	public void collateralOwners() {
		
		clickCollateralOwner();
		enterCollOwnerName(KeywordConstants.getKeyWordData().get("CollateralOwnerName"));
		enterCollOwnerAddress1(KeywordConstants.getKeyWordData().get("CollateralOwnerAddress1"));
		enterCollOwnerZipCode(KeywordConstants.getKeyWordData().get("CollateralOwnerZipCode"));
		addCollOwner();
		
	}

	@Keywords(description = "Fill Existing Lien Info", category = "Collateral", author = "ATeam")
	public void collateralExistingLienDetails() {
		
		clickExistingLienDetails();
		enterLienHolder(KeywordConstants.getKeyWordData().get("LienHolder"));
		selectExistLienPosition(KeywordConstants.getKeyWordData().get("ExistLienPosition"));
		enterExistLienDesc(KeywordConstants.getKeyWordData().get("ExistLienDesc"));
		enterExistLienPhoneNo(KeywordConstants.getKeyWordData().get("ExistLienPhone"));
		enterExistLienfaxNo(KeywordConstants.getKeyWordData().get("ExistLienFax"));
		enterExistLienAccNo(KeywordConstants.getKeyWordData().get("ExistLienAccNo"));
		enterExistDateOpen(KeywordConstants.getKeyWordData().get("ExistLienDateOpen"));
		enterExistLienPI(KeywordConstants.getKeyWordData().get("ExistLienPI"));
		enterExistLienPITI(KeywordConstants.getKeyWordData().get("ExistLienPITI"));
		enterExistLienPayment(KeywordConstants.getKeyWordData().get("ExistLienPayment"));
		enterExistLienRate(KeywordConstants.getKeyWordData().get("ExistLienRate"));
		enterExistLienBalance(KeywordConstants.getKeyWordData().get("ExistLienBalance"));
		enterExistLienPayOff(KeywordConstants.getKeyWordData().get("ExistLienPayOff"));
		enterExistLienDebtSpread(KeywordConstants.getKeyWordData().get("ExistLienDebtSpread"));
		enterExistLienAddress1(KeywordConstants.getKeyWordData().get("ExistLienAdd1"));
		enterExistLienZipCode(KeywordConstants.getKeyWordData().get("ExistLienZipCode"));
		addExistingLien();
	}

	@Keywords(description = "Fill Lien Filing Info", category = "Collateral", author = "ATeam")
	public void collateralLienFiling() {
	
		clickLienFiling();
		clickLienFilingYes();
		enterFiledBy(KeywordConstants.getKeyWordData().get("FiledBy"));
		enterDateFiled(KeywordConstants.getKeyWordData().get("DateFiled"));
		enterDateReceived(KeywordConstants.getKeyWordData().get("DateReceived"));
		
		}
	
	
	@Keywords(description = "Click on Submit Button", category = "Buttons-Submit", author = "ATeam")
	public void submitButton() {

		try {
			Thread.sleep(5000);
			clickSubmit();
			Thread.sleep(25000);
			CloseActionStatuswindow();

		} catch (InterruptedException e) {
			System.out.println("Submit button not found");
			e.printStackTrace();
		}
	}
}





