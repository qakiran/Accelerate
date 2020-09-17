package com.fiserv.api.implementation;

import java.util.Map;

/**
 * @author Piyuskumar.Rupareliya
 * @purpose to add path parameters in the request body
 */

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;
import com.fiserv.api.utils.CommonUtils;
import com.fiserv.framework.api.interfaces.IAddParameter;
import com.fiserv.framework.api.interfaces.IAddPathParameters;
import com.fiserv.framework.utility.report.ExtentReportConstant;

public class AddPathParameter  implements IAddPathParameters{

	private static AddPathParameter instance = null;
	private static Logger logger = Logger.getLogger(AddPathParameter.class);
	
	private RequestBuilder requestBuilder = RequestBuilder.getRequestBuilder();
	private ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();
	private AddParameter addParameter = AddParameter.getInstance();
	private CommonUtils util = CommonUtils.getInstance();

	/*
	 * Set access modifier protected for default constructor to achieve Singleton
	 * Pattern
	 */
	protected AddPathParameter() {

	}

	/**
	 * This function checks for currents class instance and returns one if present.
	 * If not instance available creates new instance and returns that.
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of the AddPathParameter
	 */
	public static AddPathParameter getInstance() {
		if (null == instance) {
			instance = new AddPathParameter();
		}
		return instance;
	}

	/**
	 * This function calls setter methods for parameter key and type as Path and
	 * sets value
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param paramKey Parameter Key should be passed as String
	 * @return Instance of IAddParameter
	 */
	public IAddParameter addParameter(String paramKey) {
		addParameter.addParam(paramKey, "PATH");
		return addParameter;
	}

	/**
	 * This function adds path parameters using parameter map
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param pathParametersHashMap Parameter map should be passed as HashMap with
	 *                              both key and value as String
	 */
	public void addParameterMap(Map<String, String> pathParametersHashMap) {
		try {
			if (!(pathParametersHashMap.isEmpty() && pathParametersHashMap != null)) {
				logger.debug("Adding path parameters map to request");
				requestBuilder.getBuilder().addPathParams(pathParametersHashMap);
				reportConstant.getParentTestNode().log(Status.PASS, "Path Parameters added");
			} else {
				util.failTestcase("Path Parameter Map cannnot be empty", "Path Parameter Map cannnot be empty");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Set Path Parameter failed");
		}
	}

}
