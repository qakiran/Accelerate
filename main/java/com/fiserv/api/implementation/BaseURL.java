package com.fiserv.api.implementation;

/**
 * @author Piyuskumar.Rupareliya
 * @purpose to get and set base URL and basePath in the request URL
 */

import org.apache.log4j.Logger;
import com.aventstack.extentreports.Status;
import com.fiserv.api.utils.CommonUtils;
import com.fiserv.framework.api.interfaces.ISetURL;
import com.fiserv.framework.utility.report.ExtentReportConstant;

public class BaseURL implements ISetURL{

	private String url = "";
	private String resourcepath = "";
	private static BaseURL instance = null;
	private static Logger logger = Logger.getLogger(BaseURL.class);

	private RequestBuilder requestBuilder = RequestBuilder.getRequestBuilder();
	private ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();
	private CommonUtils util = CommonUtils.getInstance();
	
	/*
	 * Set access modifier protected for default constructor to achieve
	 * Singleton Pattern
	 */ protected BaseURL() {

	}

	/**
	 * This function checks for currents class instance and returns one if
	 * present. If not instance available creates new instance and returns that.
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of the BaseURL
	 */
	public static BaseURL getInstance() {
		if (null == instance) {
			instance = new BaseURL();
		}
		return instance;
	}

	/**
	 * This function is setter method for base URL
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param baseURL
	 *            base URL should be passed as String
	 */
	public void setBaseURL(String baseURL) {
		try {
			if (baseURL != null) {
				requestBuilder.getBuilder().setBaseUri(baseURL);
				logger.debug("Base URL set : " + baseURL);
				reportConstant.getParentTestNode().log(Status.PASS, baseURL);
				url = baseURL;
			} else {
				util.failTestcase("Base URI cannnot be set to null", "Base URI cannnot be set to null");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Set Base URI failed");
		}

	}

	/**
	 * This function is getter method for base URL
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Base URL as String
	 */
	public String getBaseURL() {
		return url;
	}

	/**
	 * This function is setter method for base path
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param resourcePath
	 *            base path should be passed as String
	 */
	public void setBasePath(String resourcePath) {
		try {
			if (resourcePath != null) {
				requestBuilder.getBuilder().setBasePath(resourcePath);
				logger.debug("Base path set : " + resourcePath);
				reportConstant.getParentTestNode().createNode("Set base path: ").log(Status.PASS, resourcePath);
				resourcepath = resourcePath;
			} else {
				util.failTestcase("Resource Path cannnot be set to null", "Resource Path cannnot be set to null");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Set Resource Path failed");
		}

	}

	/**
	 * This function is getter method for base URL
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Base URL as String
	 */
	public String getBasePath() {
		return resourcepath;
	}

}
