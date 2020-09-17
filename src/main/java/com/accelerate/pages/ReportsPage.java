package com.accelerate.pages;

import org.openqa.selenium.By;
import com.accelerate.BaseElementPage;
import com.aventstack.extentreports.Status;
import com.fiserv.framework.Report;
import com.fiserv.framework.interfaces.ISynchronization;

public class ReportsPage extends BaseElementPage {

	public By Reports = By.xpath("//a[@href='/originateloans/main/reports']");
	public By FinalDecLoanRpt = By.xpath("//a[text()='Final Decisioned Loans Report With Approved LoanAmount']");
	public By StartDate = By.xpath("//input[@id=\"rptParam_pv_From_dt_F00001_txtDate\"]");
	public By StartDatepicker = By.xpath("//a/input[@title='Click to show Calendar']");
	public By EndDate = By.xpath("//input[@id=\"rptParam_pv_To_Dt_F00001_txtDate\"]");
	public By Run = By.xpath("//input[@value='Run']");
	public By ReportClose = By.xpath("//button[@id='drawer-close-button-ReportId']/span");

	public void clickReportsTab() {
		element.click(Reports, "");
	}

	public void clickFinalDecLoanRpt() {
		element.click(FinalDecLoanRpt, "");
	}

	public void enterStartDate(String startdate) {
		element.click(StartDate, "");
		System.out.println("clicked on start date");
		element.sendKeys(StartDate, startdate, "");
	}

	public void enterEndDate(String enddate) {
		element.click(EndDate, "");
		element.sendKeys(EndDate, enddate, "");
		element.click(StartDate, "");
	}

	public void clickRunRpt() {
		element.jsExecute().scrollToBottom();
		element.click(Run, "");
	}

	public void closeReports() {
		element.click(ReportClose, "");
	}
}
