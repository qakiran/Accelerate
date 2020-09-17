package com.fiserv.api.implementation;

/**
 * @author Piyuskumar.Rupareliya
 * @purpose to add set request body for POST, PUT and DELETE methods
 */

import org.apache.log4j.Logger;

import com.fiserv.api.utils.CommonUtils;
import com.fiserv.api.utils.JsonHandler;
import com.fiserv.framework.api.interfaces.ISetRequestBody;

public class RequestBody  implements ISetRequestBody{

	private static RequestBody instance = null;
	private static Logger logger = Logger.getLogger(RequestBody.class);
	private RequestBuilder requestBuilder = RequestBuilder.getRequestBuilder();
	private CommonUtils util = CommonUtils.getInstance();
	private JsonHandler jsonUtil = JsonHandler.getInstance();

	/*
	 * Set access modifier protected for default constructor to achieve
	 * Singleton Pattern
	 */
	protected RequestBody() {
		
	}

	/**
	 * This function checks for currents class instance and returns one if
	 * present. If not instance available creates new instance and returns that.
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of the AddPathParameter
	 */
	public static RequestBody getInstance() {
		if (null == instance) {
			instance = new RequestBody();
		}
		return instance;
	}

	/**
	 * This function reads request file and sets request body in request
	 * specification builder
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param filepath
	 *            File path should be passed as String
	 */
	public void setRequestBodyfromFile(String filepath) {
		setRequestBody(jsonUtil.readJsonfromFile(filepath));
	}

	/**
	 * This function sets request body in request specification builder
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param strBody
	 *            Request body should be passed as String
	 */
	public void setRequestBody(Object strBody) {
		try {
			if (strBody != null) {
				logger.debug("Setting request body from String value");
				requestBuilder.getBuilder().setBody(strBody);
			} else {
				util.failTestcase("Request Body cannnot be null", "Request Body cannnot be null");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Set Request body Failed");
		}
	}

}
