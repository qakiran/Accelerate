package com.fiserv.api.implementation;

import java.util.Map;

/**
 * @author Piyuskumar.Rupareliya
 * @purpose to add query parameters in the request body
 */

import org.apache.log4j.Logger;
import com.aventstack.extentreports.Status;
import com.fiserv.api.utils.CommonUtils;
import com.fiserv.framework.api.interfaces.IAddParameter;
import com.fiserv.framework.api.interfaces.IAddQueryParameters;
import com.fiserv.framework.utility.report.ExtentReportConstant;

public class AddQueryParameter implements IAddQueryParameters{

	private static AddQueryParameter instance = null;
	private static Logger logger = Logger.getLogger(AddQueryParameter.class);
	
	private AddParameter addParameter = AddParameter.getInstance();
	private RequestBuilder requestBuilder = RequestBuilder.getRequestBuilder();
	private CommonUtils util = CommonUtils.getInstance();
	private ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();

	/*
	 * Set access modifier protected for default constructor to achieve Singleton
	 * Pattern
	 */
	protected AddQueryParameter() {

	}

	/**
	 * This function checks for currents class instance and returns one if present.
	 * If not instance available creates new instance and returns that.
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of the AddQueryParameter
	 */
	public static AddQueryParameter getInstance() {
		if (null == instance) {
			instance = new AddQueryParameter();
		}
		return instance;
	}

	/**
	 * This function calls setter methods for parameter key and type as Query and
	 * sets value
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param paramKey Parameter Key should be passed as String
	 * @return Instance of IAddParameter
	 */
	public IAddParameter addParameter(String paramKey) {
		try {
			if (paramKey != null) {
				logger.debug("Setting query parameter key");
				addParameter.setParameterKey(paramKey);
				logger.debug("Setting query parameter type");
				addParameter.setParameterType("QUERY");
			} else {
				util.failTestcase("Parameter Key cannnot be set to null", "Parameter Key cannnot be set to null");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Set Parameter key failed");
		}
		return addParameter;
	}

	/**
	 * This function adds query parameters using parameter map
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param queryParametersHashMap Parameter map should be passed as HashMap with
	 *                               both key and value as String
	 */
	public void addParameterMap(Map<String, String> queryParametersHashMap) {
		try {
			if (!(queryParametersHashMap.isEmpty() && queryParametersHashMap != null)) {
				logger.debug("Adding query parameters map to request");
				requestBuilder.getBuilder().addQueryParams(queryParametersHashMap);
				reportConstant.getParentTestNode().log(Status.PASS, "Query Parameters added");
			} else {
				util.failTestcase("Query Parameter Map cannnot be empty", "Query Parameter Map cannnot be empty");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Set Query Parameters failed");
		}
	}

}
