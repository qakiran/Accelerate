package com.fiserv.api.implementation;

/**
 * @author Piyuskumar.Rupareliya
 * @purpose to get and set response body from request execution
 */
import org.apache.log4j.Logger;
import com.fiserv.framework.api.interfaces.IResponseHeader;
import com.fiserv.api.utils.Comparison;

public class ResponseHeader implements IResponseHeader {

	private String headerVal = "";
	private static ResponseHeader instance = null;
	private static Logger logger = Logger.getLogger(ResponseHeader.class);
	private Comparison compare = Comparison.getInstance();

	protected ResponseHeader() {
		// Set access modifier protected for default constructor to achieve
		// Singleton Pattern
	}

	/**
	 * This function checks for currents class instance and returns one if
	 * present. If not instance available creates new instance and returns that.
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of the AddPathParameter
	 */
	public static ResponseHeader getInstance() {
		if (null == instance) {
			instance = new ResponseHeader();
		}
		return instance;
	}

	/**
	 * This function is setter method for header value
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param headerVal
	 *            Header value to be passed as String
	 */
	public void setHeaderVal(String headerVal) {
		this.headerVal = headerVal;
		logger.debug("Request header value set.");
	}

	/**
	 * This function is getter method for header value
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Header value as String
	 */
	public String getHeaderVal() {
		return headerVal;
	}

	/**
	 * This function validates header value for equal to expected value
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param expectedHeaderValue
	 *            Expected Header value to be passed as Object
	 * @param compareType
	 *            Pass true if you want to perform Equals To comparison, Else
	 *            pass false to perform Not Equals to Comparison
	 */
	public void isEqualTo(boolean compareType, Object expectedHeaderValue) {
		logger.info("Validating header field - Equal to");
		compare.isEqualsTo(compareType, expectedHeaderValue, (Object) getHeaderVal());
	}

	/**
	 * This function validates header value that it contains expected value
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param expectedHeaderValue
	 *            Expected header value to be passed as String
	 */
	public void contains(String expectedHeaderValue) {
		logger.info("Validating header field - contains");
		compare.contains(expectedHeaderValue.trim(), getHeaderVal());

	}

}
