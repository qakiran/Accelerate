/**
 * 
 */
package com.fiserv.api.implementation;

import org.apache.log4j.Logger;

import com.fiserv.api.utils.CommonUtils;
import com.fiserv.framework.api.interfaces.IExecute;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

/**
 * @author Piyuskumar.Rupareliya
 * 
 *         class implementing rest execution methods
 */

public class Execute  implements IExecute{
	
	private CommonUtils util = CommonUtils.getInstance();
	private RequestBuilder requestBuilder = RequestBuilder.getRequestBuilder();
	private ResponseBuilder responseBuilder = ResponseBuilder.getBuilder();
	private static Logger logger = Logger.getLogger(Execute.class);
	private RequestSpecification requestSpec = requestBuilder.getBuilder().build();

	/**
	 * This function execute post call using request specification builder
	 * prepared. This function also sets Response and Response Body
	 * 
	 * @author Piyushkumar.Rupareliya
	 */
	public void postRequest() {
		try {
			requestBuilder.getBuilder().build().log().all();
			logger.info("Executing REST POST request.");
			responseBuilder.setResponse(RestAssured.given().spec(requestSpec).relaxedHTTPSValidation().post());
			logger.info("POST request executed.");
			logger.info(responseBuilder.getReponse().then().log().all());
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Post Request Execution Failed.");
		}
	}

	/**
	 * This function execute put call using request specification builder
	 * prepared. This function also sets Response and Response Body
	 * 
	 * @author Piyushkumar.Rupareliya
	 */
	public void putRequest() {
		try {
			logger.info(requestBuilder.getBuilder().build().log().all());
			logger.info("Executing REST PUT request.");
			responseBuilder.setResponse(RestAssured.given().spec(requestSpec).relaxedHTTPSValidation().put());
			logger.info("PUT request executed.");
			logger.info(responseBuilder.getReponse().then().log().all());
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "PUT Request Execution Failed");
		}
	}

	/**
	 * This function execute get call using request specification builder
	 * prepared. This function also sets Response and Response Body
	 * 
	 * @author Piyushkumar.Rupareliya
	 */
	public void getRequest() {

		try {
			if (requestBuilder.getBuilder() == null) {
				logger.error("Request specification is null");
			} else {
				logger.info(requestBuilder.getBuilder().build().log().all());
				logger.info("Executing REST GET request.");
				responseBuilder.setResponse(RestAssured.given().spec(requestSpec).relaxedHTTPSValidation().get());
				logger.info("GET request executed.");
				logger.info(responseBuilder.getReponse().then().log().all());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Get Request Execution Failed");
		}
	}

	/**
	 * This function execute delete call using request specification builder
	 * prepared. This function also sets Response and Response Body
	 * 
	 * @author Piyushkumar.Rupareliya
	 */
	public void deleteRequest() {
		try {
			logger.info(requestBuilder.getBuilder().build().log().all());
			logger.info("Executing REST delete request.");
			responseBuilder.setResponse(RestAssured.given().spec(requestSpec).relaxedHTTPSValidation().delete());
			logger.info("DELETE request executed.");
			logger.info(responseBuilder.getReponse().then().log().all());
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Delete Request Execution Failed");
		}
	}

}
