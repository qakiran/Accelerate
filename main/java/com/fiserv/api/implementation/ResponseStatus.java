package com.fiserv.api.implementation;

/**
 * @author Piyuskumar.Rupareliya
 */
import org.apache.log4j.Logger;

import com.fiserv.api.utils.CommonUtils;
import com.fiserv.framework.api.interfaces.IRespStatus;
import com.fiserv.framework.api.interfaces.IStatusCode;
import com.fiserv.framework.api.interfaces.IStatusLine;


public class ResponseStatus  implements IRespStatus{

	private ResponseBuilder rspBuild = ResponseBuilder.getBuilder();
	private static ResponseStatus instance = null;
	private static Logger logger = Logger.getLogger(BaseURL.class);
	private CommonUtils util = CommonUtils.getInstance();

	protected ResponseStatus() {
		// Set access modifier protected for default constructor to achieve Singleton Pattern
	}

	/**
	 * This function checks for currents class instance and returns one if present.
	 * If not instance available creates new instance and returns that.
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of the ResponseStatus
	 */
	public static ResponseStatus getInstance() {
		if (null == instance) {
			instance = new ResponseStatus();
			logger.debug("ResponseStatus objecet is created");
		}
		return instance;
	}

	/**
	 * This function is setter method for setting Status code
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of StatusCode which implements IStatusCode
	 */
	public IStatusCode statusCode() {
		try {
			StatusCode.getInstance().setStatusCode(rspBuild.getReponse().getStatusCode());
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Get Status Code Failed");
		}
		return StatusCode.getInstance();
	}

	/**
	 * This function is setter method for setting Status Line
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of StatusLine which implements IStatusLine
	 */
	public IStatusLine statusLine() {
		try {
			StatusLine.getInstance().setStatusLine(rspBuild.getReponse().getStatusLine());
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Get Status Line Failed");
		}
		return StatusLine.getInstance();
	}
}
