package com.fiserv.api.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Piyuskumar.Rupareliya
 * @purpose class to get and set request parameter value
 */

import org.apache.log4j.Logger;
import com.aventstack.extentreports.Status;
import com.fiserv.api.utils.CommonUtils;
import com.fiserv.framework.api.interfaces.IAddParameter;
import com.fiserv.framework.utility.report.ExtentReportConstant;

/**
 * @author Piyuskumar.Rupareliya
 * 
 *         set parameter values in the request body
 */

public class AddParameter implements IAddParameter {

	private String paramKey = "";
	private String paramType = "";
	private static AddParameter instance = null;
	private static Logger logger = Logger.getLogger(AddParameter.class);

	private List<String> queryParamlist = new ArrayList<>();
	private List<String> pathParamlist = new ArrayList<>();
	// private AddParameter addParameter = AddParameter.getInstance();
	private ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();
	private RequestBuilder requestBuilder = RequestBuilder.getRequestBuilder();
	private CommonUtils util = CommonUtils.getInstance();

	/*
	 * Set access modifier protected for default constructor to achieve
	 * Singleton Pattern
	 */
	protected AddParameter() {

	}

	/**
	 * This function checks for currents class instance and returns one if
	 * present. If not instance available creates new instance and returns that.
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of the AddParameter
	 */
	public static AddParameter getInstance() {
		if (null == instance) {
			instance = new AddParameter();
		}
		return instance;
	}

	/**
	 * This function calls setter method for parameter key and parameter type
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param paramKey
	 *            Parameter Key should be passed as String
	 */
	public void setParameterKey(String paramKey) {
		this.paramKey = paramKey;
	}

	/**
	 * This function is setter method for parameter type
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param paramType
	 *            Parameter Type should be passed as String
	 */
	public void setParameterType(String paramType) {
		this.paramType = paramType;
	}

	/**
	 * This function is getter method for parameter key
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Parameter key as String
	 */
	public String getParameterKey() {
		return paramKey;
	}

	/**
	 * This function is getter method for parameter type
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Parameter type as String
	 */
	public String getParameterType() {
		return paramType;
	}

	/**
	 * This function sets header, query or path parameter value based on
	 * parameter type and key-value passed
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param paramValue
	 *            Parameter value to be passed as String
	 */
	public void value(String paramValue) {
		try {
			if (paramValue != null) {
				if (getParameterType().toUpperCase().trim() == "QUERY") {
					logger.debug("Adding query parameter to request");
					requestBuilder.getBuilder().addQueryParam(getParameterKey(), paramValue);
					queryParamlist.add(getParameterKey());
					logger.info("Query parameter added to request");
					reportConstant.getParentTestNode().log(Status.PASS, getParameterKey() + ": " + paramValue);
				} else if (getParameterType().toUpperCase().trim() == "PATH") {
					logger.debug("Adding path parameter to request");
					requestBuilder.getBuilder().addPathParam(getParameterKey(), paramValue);
					pathParamlist.add(getParameterKey());
					logger.info("Path parameter added to request");
					reportConstant.getParentTestNode().log(Status.PASS, getParameterKey() + ": " + paramValue);
				} else if (getParameterType().toUpperCase().trim() == "HEADER") {
					logger.debug("Adding header parameter to request");
					requestBuilder.getBuilder().addHeader(getParameterKey(), paramValue);
					logger.info("Header parameter added to request");
					reportConstant.getParentTestNode().log(Status.PASS, getParameterKey() + ": " + paramValue);
				}
			} else {
				util.failTestcase("Parameter value cannnot be set to null", "Parameter value cannnot be set to null");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Set Parameter value failed");
		}
	}

	/**
	 * This function is getter method for queryParamlist
	 * 
	 * @author Manoj.Perla
	 * @return query Parameters as List
	 */
	public List<String> getqueryParamlist() {

		return queryParamlist;
	}

	/**
	 * This function is getter method for pathParamlist
	 * 
	 * @author Manoj.Perla
	 * @return path Parameters as List
	 */
	public List<String> getpathParamlist() {

		return pathParamlist;
	}

	/**
	 * This function is to clear all the elements in the queryParamlist
	 * 
	 * @author Manoj.Perla
	 */
	public void clearQueryParamlist() {
		queryParamlist.clear();
		reportConstant.getParentTestNode().log(Status.PASS, "Removed Query Parameters");
	}

	/**
	 * This function is to clear all the elements in the pathParamlist
	 * 
	 * @author Manoj.Perla
	 */
	public void clearPathParamlist() {
		pathParamlist.clear();
		reportConstant.getParentTestNode().log(Status.PASS, "Removed Path Parameters");
	}

	public void addParam(String paramKey, String type) {
		try {
			if (paramKey != null) {
				logger.debug("Setting parameter key:" + paramKey);
				setParameterKey(paramKey);
				logger.debug("Setting " + type + " parameter type");
				setParameterType(type);
			} else {
				util.failTestcase("Parameter Key cannnot be set to null", "Parameter Key cannnot be set to null");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Set Parameter Key failed");
		}
	}
}
