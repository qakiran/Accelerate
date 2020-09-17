package com.fiserv.api.implementation;

/**
 * @author Piyuskumar.Rupareliya
 * @purpose to get and set response body from request execution
 */

import org.apache.log4j.Logger;
import com.aventstack.extentreports.Status;
import com.fiserv.framework.utility.report.ExtentReportConstant;

import io.restassured.response.Response;

public class ResponseBuilder{

	private Response response = null;
	private static ResponseBuilder instance = null;
	private static Logger logger = Logger.getLogger(ResponseBuilder.class);
	private ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();

	protected ResponseBuilder() {
		// Set access modifier protected for default constructor to achieve Singleton
		// Pattern
	}

	/**
	 * This function checks for currents class instance and returns one if present.
	 * If not instance available creates new instance and returns that.
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of the ResponseBuilder
	 */
	public static ResponseBuilder getBuilder() {
		if (null == instance) {
			instance = new ResponseBuilder();
		}
		return instance;
	}

	/**
	 * This function is setter method for Response
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param response response to be passed as a Response
	 */
	public void setResponse(Response response) {
		this.response = response;
		logger.debug("Response object value set.");
		reportConstant.getParentTestNode().log(Status.INFO, "Request Executed");
		reportConstant.getParentTestNode().log(Status.INFO, "Response headers: " + response.getHeaders());
		if (!(response.getDetailedCookies().asList().isEmpty() && response.getDetailedCookies().asList() != null)) {
			reportConstant.getParentTestNode().log(Status.INFO,
					"Response detailed cookies: " + response.getDetailedCookies());
		}
		reportConstant.getParentTestNode().log(Status.INFO, "Response body: " + response.asString());
	}

	/**
	 * This function is getter method for Response
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return response as Response
	 */
	public Response getReponse() {
		return response;
	}

}
