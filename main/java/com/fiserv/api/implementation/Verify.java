package com.fiserv.api.implementation;

/**
 * @author Piyuskumar.Rupareliya
 * @purpose to implement verification method
 */

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.fiserv.api.utils.CommonUtils;
import com.fiserv.framework.api.interfaces.IResponseHeader;
import com.fiserv.framework.api.interfaces.IResponseJsonPath;
import com.fiserv.framework.api.interfaces.IResponseTime;
import com.fiserv.framework.api.interfaces.IStatusCode;
import com.fiserv.framework.api.interfaces.IStatusLine;
import com.fiserv.framework.api.interfaces.IVerify;
import com.fiserv.framework.api.interfaces.IXPath;

import io.restassured.response.Response;

public class Verify implements IVerify{

	private static Logger logger = Logger.getLogger(Verify.class);
	private CommonUtils util = CommonUtils.getInstance();
	private StatusCode statusCode = StatusCode.getInstance();
	 RequestBuilder requestBuilder = RequestBuilder.getRequestBuilder();
	private ResponseBuilder responseBuilder = ResponseBuilder.getBuilder();
	private StatusLine statusLine = StatusLine.getInstance();
	private ResponseTime responseTime = ResponseTime.getInstance();
	private ResponseHeader responseHeader = ResponseHeader.getInstance();
	private ResponseJsonPath responseJsonPath = ResponseJsonPath.getInstance();

	/**
	 * This function gets status code from response and sets it using status
	 * code setter method
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of IStatusCode
	 */
	public IStatusCode statusCode() {
		try {
			statusCode.setStatusCode(responseBuilder.getReponse().getStatusCode());
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Get Status Code failed");
		}
		return statusCode;
	}

	/**
	 * This function gets status code from response and sets it using status
	 * line setter method
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of IStatusLine
	 */
	public IStatusLine statusLine() {
		try {
			statusLine.setStatusLine(responseBuilder.getReponse().getStatusLine());
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Get Status Line failed");
		}
		return statusLine;
	}

	/**
	 * This function gets response header value from response and sets it using
	 * header setter method
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of IResponseHeader
	 */
	public IResponseHeader header(String headerName) {
		try {
			responseHeader.setHeaderVal(responseBuilder.getReponse().getHeader(headerName));
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Get Header failed");
		}
		return ResponseHeader.getInstance();

	}

	/**
	 * This function gets response time value for time unit provided from
	 * response and sets it using response time setter method
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of IResponseTime
	 */
	public IResponseTime responseTime(TimeUnit tUnit) {
		try {
			if ((tUnit == TimeUnit.MICROSECONDS) || (tUnit == TimeUnit.MILLISECONDS) || (tUnit == TimeUnit.SECONDS)
					|| (tUnit == TimeUnit.MINUTES)) {
				responseTime.setRespTime((int) (responseBuilder.getReponse().timeIn(tUnit)));
				responseTime.setRespTimeUnit(tUnit);
			} else {
				logger.error("TimeUnit should be either Minutes, Seconds, Milliseconds or Microseconds");
				util.failTestcase("Incorrect TimeUnit Passed",
						"TimeUnit should be either Minutes, Seconds, Milliseconds or Microseconds");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Get Response Time Failed");
		}
		return responseTime;
	}

	/**
	 * This function gets Json path value from response and sets it using json
	 * path setter method
	 * 
	 * @author Manoj.Perla
	 * @return Instance of ResponseJsonPath which implements IResponseJsonPath
	 */
	public IResponseJsonPath jsonPath(String jpath) {
		try {
			responseJsonPath.setjsonpath(jpath);
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Set JSON Path Failed");
		}
		return ResponseJsonPath.getInstance();
	}

	/**
	 * This function validates JSON response schema as per the content of the
	 * input file passed
	 * 
	 * @author Nishant.Pathak
	 */
	public void jsonResponseSchema(String filePath) {

		Response response = responseBuilder.getReponse();
		try {
			response.then().assertThat().body(matchesJsonSchema(new File(filePath)));
			logger.info("JSON response schema validated sucessfully");

		} catch (AssertionError a) {
			logger.error("JSON response schema validation failed");
			util.failTestcase("Assertion failed", "JSON response schema validation failed");
		}

	}

	/**
	 * This function gets XPATH value from response and sets it using XPATH
	 * setter method
	 * 
	 * @author Nishant.Pathak
	 * @return Instance of XPath which implements IXPath
	 */
	public IXPath xPath(String xpath) {
		try {
			XPath.getInstance().setXpathValue(xpath);
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Set XPath Failed");
		}
		return XPath.getInstance();
	}

}
