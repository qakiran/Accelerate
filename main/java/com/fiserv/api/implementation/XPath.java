package com.fiserv.api.implementation;

/**
 * @author Nishant.Pathak
 */
import org.apache.log4j.Logger;
import com.fiserv.framework.api.interfaces.IXPath;
import com.fiserv.api.utils.Comparison;

public class XPath implements IXPath{

	private String path = "";
	private static XPath instance = null;
	private static Logger logger = Logger.getLogger(BaseURL.class);

	private Comparison compare = Comparison.getInstance();
	private ResponseBuilder responseBuilder = ResponseBuilder.getBuilder();
	protected XPath() {
		// Set access modifier protected for default constructor to achieve
		// Singleton Pattern
	}

	/**
	 * This function checks for currents class instance and returns one if
	 * present. If not instance available creates new instance and returns that.
	 * 
	 * @author Nishant.Pathak
	 * @return Instance of the XPath
	 */
	public static XPath getInstance() {
		if (null == instance) {
			instance = new XPath();
		}
		return instance;
	}

	/**
	 * This function is setter method for setting xpath value
	 * 
	 * @author Nishant.Pathak
	 * @param Xpath
	 *            Xpath to be passed as String
	 */
	public void setXpathValue(String xPath) {
		this.path = xPath;
	}

	/**
	 * This function is getter method for Xpath
	 * 
	 * @author Nishant.Pathak
	 * @return Xpath as String
	 */
	public String getXpathValue() {
		return path;
	}

	/**
	 * This function compares for equality of the String Expected value passed.
	 * This function should be used to compare field values based on XPath. User
	 * don't have to explicitly send Actual value, internally the function reads
	 * the response and get the Actual value at that XPATH
	 * 
	 * @author Nishant.Pathak
	 * @param xPathVal
	 *            Expected value at the XPATH to be passed as Object
	 * @param compareType
	 *            Pass true if you want to perform Equals To comparison, Else
	 *            pass false to perform Not Equals to Comparison
	 */
	public void isEqualTo(boolean compareType, Object xPathVal) {
		logger.info("Validating Xpath value - Equal to");
		compare.isEqualsTo(compareType, xPathVal,
				(Object) responseBuilder.getReponse().then().extract().path(getXpathValue()));
	}

}
