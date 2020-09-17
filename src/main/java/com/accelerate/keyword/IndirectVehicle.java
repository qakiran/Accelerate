package com.accelerate.keyword;

import org.apache.log4j.Logger;

import com.accelerate.pages.DataEntryPage;
import com.accelerate.pages.WorksheetPage;
import com.fiserv.framework.constants.KeywordConstants;
import com.fiserv.keyword.Keywords;

public class IndirectVehicle extends DataEntryPage {

	Logger log = Logger.getLogger(DataEntry.class.getName());
	
	public WorksheetPage wp = new WorksheetPage();

	@Keywords(description = "Fill Data Entry Page 0-IV", category = "DataEntry", author = "ATeam")

	public void dataEntryPage0() {
		System.out.println("Wait before clicking product");
		try {
			Thread.sleep(15000);
			selectProduct(KeywordConstants.getKeyWordData().get("Product"));
			enterCashPriceIV(KeywordConstants.getKeyWordData().get("CashPriceIV"));
			enterDealer(KeywordConstants.getKeyWordData().get("Dealer"));
			selectdeliverymethod(KeywordConstants.getKeyWordData().get("DeliveryMethod"));
			Thread.sleep(5000);
			enterSSN(KeywordConstants.getKeyWordData().get("SSN"));
			Thread.sleep(5000);
			enterFirstName(KeywordConstants.getKeyWordData().get("FirstName"));
			enterMiddleName(KeywordConstants.getKeyWordData().get("MiddleName"));
			enterLastName(KeywordConstants.getKeyWordData().get("LastName"));
			clickSaveBttn();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Keywords(description = "Fill Applicant Summary Page", category = "Personal Information", author = "ATeam")

	public void applicantSummary()

	{
		try {
			Thread.sleep(5000);

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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Keywords(description = "Fill Employment Details", category = "Employment", author = "ATeam")

	public void applicantEmployment() {

		// Employers
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

	@Keywords(description = "Fill Other Income Details", category = "Income", author = "ATeam")
	public void applicantIncome() {
		// Other Income
		System.out.println("click on income");
		clickIncome();
		clickAddNewIncome();
		selectIncomeType(KeywordConstants.getKeyWordData().get("IncomeType"));
		enterSourceDescription(KeywordConstants.getKeyWordData().get("SourceDescription"));
		enterAmount(KeywordConstants.getKeyWordData().get("IncomeAmount"));
		addButton();
	}

	@Keywords(description = "Fill Asset Details", category = "Asset", author = "ATeam")
	public void applicantAssets() {
		// Assets
		System.out.println("Click Assets");
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
		System.out.println("Tried adding references once");

	}

	@Keywords(description = "Add Titled Goods KBB Collateral", category = "TGKBBCollateral", author = "ATeam")
	public void addCollateral() {
		try {
			Thread.sleep(15000);
			selectCollateralCategory(KeywordConstants.getKeyWordData().get("CollateralCategory"));
			Thread.sleep(10000);
			selectCollateralName(KeywordConstants.getKeyWordData().get("CollateralName"));
			Thread.sleep(10000);
			selectKBBYear(KeywordConstants.getKeyWordData().get("KBBYear"));
			Thread.sleep(10000);
			selectKBBMake(KeywordConstants.getKeyWordData().get("KBBMake"));
			Thread.sleep(10000);
			selectKBBModel(KeywordConstants.getKeyWordData().get("KBBModel"));
			Thread.sleep(10000);
			selectKBBSubModel(KeywordConstants.getKeyWordData().get("KBBSubModel"));
			Thread.sleep(10000);
			selectKBBBodyStyle(KeywordConstants.getKeyWordData().get("KBBBodyStyle"));
			clickKBBGetOptions();
			clickKBBGetPricing();
			Thread.sleep(15000);
			clickKBBGetPricingYesbttn();
			Thread.sleep(5000);
			clickSave();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

