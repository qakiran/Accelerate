package com.fiserv.api;

import org.apache.log4j.Logger;
import com.aventstack.extentreports.Status;
import com.fiserv.api.implementation.AddHeaderParameter;
import com.fiserv.api.implementation.AddParameter;
import com.fiserv.api.implementation.AddPathParameter;
import com.fiserv.api.implementation.AddQueryParameter;
import com.fiserv.api.implementation.BaseURL;
import com.fiserv.api.implementation.Execute;
import com.fiserv.api.implementation.RequestBody;
import com.fiserv.api.implementation.RequestBuilder;
import com.fiserv.api.implementation.ResponseBuilder;
import com.fiserv.api.implementation.Verify;
import com.fiserv.api.utils.CommonUtils;
import com.fiserv.framework.api.interfaces.IAddHeadersParameters;
import com.fiserv.framework.api.interfaces.IAddPathParameters;
import com.fiserv.framework.api.interfaces.IAddQueryParameters;
import com.fiserv.framework.api.interfaces.IExecute;
import com.fiserv.framework.api.interfaces.IServices;
import com.fiserv.framework.api.interfaces.ISetRequestBody;
import com.fiserv.framework.api.interfaces.ISetURL;
import com.fiserv.framework.api.interfaces.IVerify;
import com.fiserv.framework.utility.report.ExtentReportConstant;

import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public abstract class AbstractRestAssuredAPI implements IServices {

	private static Logger logger = Logger.getLogger(AbstractRestAssuredAPI.class);
	private static ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();
	private static RequestBody requestBody = RequestBody.getInstance();
	protected static RequestBuilder requestBuilder = RequestBuilder.getRequestBuilder();
	private static AddParameter addParameter = AddParameter.getInstance();
	private CommonUtils util = CommonUtils.getInstance();

	/**
	 * This function sets base URL and returns instance of BaseURL
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of BaseURL
	 */
	public ISetURL setBaseURL(String baseURL) {
		reportConstant.setParentTestNode("Set Base URL: ");
		BaseURL.getInstance().setBaseURL(baseURL);
		return BaseURL.getInstance();
	}

	/**
	 * This function returns instance of execute
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of execute which implements IExecute
	 */
	public IExecute execute() {
		reportConstant.setParentTestNode("Execute Request: ");
		return new Execute();
	}

	/**
	 * This function returns instance of Verify
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of Verify which implements IVerify
	 */

	public IVerify verify() {
		if ((reportConstant.getParentTestNode() != null)
				&& (!(reportConstant.getParentTestNode().getModel().getName().contains("Field Verifications:")))) {
			reportConstant.setParentTestNode("Field Verifications: ");
		}
		return new Verify();
	}

	/**
	 * This function returns instance of AddQueryParameter
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of AddQueryParameter which implements
	 *         IAddQueryParameters
	 */
	public IAddQueryParameters queryParam() {
		if ((reportConstant.getParentTestNode() != null)
				&& (!(reportConstant.getParentTestNode().getModel().getName().contains("Add Query Parameter:")))) {
			reportConstant.setParentTestNode("Add Query Parameter: ");
		}

		return AddQueryParameter.getInstance();
	}

	/**
	 * This function returns instance of AddPathParameter
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of AddPathParameter which implements IAddPathParameters
	 */
	public IAddPathParameters pathParam() {
		if ((reportConstant.getParentTestNode() != null)
				&& (!(reportConstant.getParentTestNode().getModel().getName().contains("Add Path Parameter:")))) {
			reportConstant.setParentTestNode("Add Path Parameter: ");
		}

		return AddPathParameter.getInstance();
	}

	/**
	 * This function returns instance of AddHeaderParameter
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of AddHeaderParameter which implements
	 *         IAddHeadersParameters
	 */
	public IAddHeadersParameters header() {
		if ((reportConstant.getParentTestNode() != null)
				&& (!(reportConstant.getParentTestNode().getModel().getName().contains("Add Header Parameter:")))) {
			reportConstant.setParentTestNode("Add Header Parameter: ");
		}
		return AddHeaderParameter.getInstance();
	}

	/**
	 * This function sets the request body. It reads request body content from a
	 * input file and sets it as a request body in RequestSpecBuilder and
	 * returns requestbody.
	 * 
	 * @author manoj.perla
	 * @param filePath
	 *            Accepts one parameter as String
	 * @return returns instance of requestBody which implements ISetRequestBody
	 */
	public ISetRequestBody setRequestBodyFromFile(String filePath) {
		reportConstant.setParentTestNode("Set Request Body from File: ");
		requestBody.setRequestBodyfromFile(filePath);
		return requestBody;
	}

	/**
	 * This function sets the request body. request body should be passed as
	 * string and that would be set as request body in RequestSpecBuilder. It
	 * returns object of type ISetRequestBody.
	 * 
	 * @author manoj.perla
	 * @param strBody
	 *            Accepts one parameter as String
	 * @return requestBody
	 */
	public ISetRequestBody setRequestBody(Object strBody) {
		reportConstant.setParentTestNode("Set Request Body: ");
		RequestBody.getInstance().setRequestBody(strBody);
		return RequestBody.getInstance();
	}

	/**
	 * This function returns the Response body
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return ResponseBody as String
	 */
	public String getResponseBody() {
		reportConstant.setParentTestNode("Get Response Body: ");
		String responsebody = "";
		try {
			responsebody = ResponseBuilder.getBuilder().getReponse().getBody().asString();
			reportConstant.getParentTestNode().log(Status.PASS, "Response Body : " + responsebody);
			return responsebody;
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Get Response Body failed");
		}
		return responsebody;
	}

	/**
	 * This function removes Query Parameters
	 * 
	 * @author Manoj.Perla
	 */
	public void removeQueryParameters() {
		reportConstant.setParentTestNode("Remove Query Parameters: ");
		for (String temp : addParameter.getqueryParamlist()) {
			logger.debug("Query Parameter to be removed is : " + temp);
			requestBuilder.getBuilder().removeQueryParam(temp);
		}
		addParameter.clearQueryParamlist();
	}

	/**
	 * This function removes Path Parameters
	 * 
	 * @author Manoj.Perla
	 */
	public void removePathParameters() {
		reportConstant.setParentTestNode("Remove Path Parameter: ");
		for (String temp : addParameter.getpathParamlist()) {
			logger.debug("Path Parameter to be removed is : " + temp);
			requestBuilder.getBuilder().removePathParam(temp);
		}
		addParameter.clearPathParamlist();
	}

	QueryableRequestSpecification queryableReq = SpecificationQuerier.query(requestBuilder.getBuilder().build());
}
