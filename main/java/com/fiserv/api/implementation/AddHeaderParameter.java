package com.fiserv.api.implementation;

import java.util.Map;

/**
 * @author Piyuskumar.Rupareliya
 * @purpose to add header parameters in the request body
 */

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;
import com.fiserv.api.utils.CommonUtils;
import com.fiserv.framework.api.interfaces.IAddHeadersParameters;
import com.fiserv.framework.api.interfaces.IAddParameter;
import com.fiserv.framework.utility.report.ExtentReportConstant;

public class AddHeaderParameter implements IAddHeadersParameters{

	private static AddHeaderParameter instance = null;
	private static Logger logger = Logger.getLogger(AddHeaderParameter.class);
	private RequestBuilder requestBuilder = RequestBuilder.getRequestBuilder();
	private AddParameter addParameter = AddParameter.getInstance();
	private CommonUtils util = CommonUtils.getInstance();
	private ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();

	/*
	 * Set access modifier protected for default constructor to achieve
	 * Singleton Pattern
	 */
	protected AddHeaderParameter() {

	}

	/**
	 * This function checks for currents class instance and returns one if
	 * present. If not instance available creates new instance and returns that.
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of the AddHeaderParameter
	 */
	public static AddHeaderParameter getInstance() {
		if (null == instance) {
			instance = new AddHeaderParameter();
		}
		return instance;
	}

	/**
	 * This function calls setter methods for parameter key and type as Header
	 * and sets value
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param paramKey
	 *            Accepts Parameter Key as String
	 * @return Instance of IAddParameter
	 */
	public IAddParameter addParameter(String paramKey) {
		addParameter.addParam(paramKey, "HEADER");
		return addParameter;
	}

	/**
	 * This function adds header parameters using parameter map
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param headerParametersHashMap
	 *            Accepts Parameter map with both Key and value as String
	 */
	public void addParameterMap(Map<String, String> headerParametersHashMap) {
		try {
			if (!(headerParametersHashMap.isEmpty() && headerParametersHashMap != null)) {
				reportConstant.setParentTestNode("Add Header Parameter: ");
				logger.debug("Adding header parameters map to request");
				requestBuilder.getBuilder().addHeaders(headerParametersHashMap);
				reportConstant.getParentTestNode().log(Status.PASS, "Header Parameters added");
			} else {
				util.failTestcase("Header Parameter Map cannnot be empty", "Header Parameter Map cannnot be empty");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Set Header Parameters failed");
		}
	}
}
