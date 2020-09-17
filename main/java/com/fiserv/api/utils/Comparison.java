package com.fiserv.api.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.schema.PathResourceLoader;

import com.aventstack.extentreports.Status;
import com.fiserv.framework.utility.report.ExtentReportConstant;

public class Comparison {

	private static Comparison instance = null;
	private static Logger logger = Logger.getLogger(Comparison.class);

	ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();
	CommonUtils util = CommonUtils.getInstance();

	private enum primitiveTypes {
		INTEGER, DOUBLE, STRING, LONG, FLOAT, BOOLEAN, CHARACTER
	}

	protected Comparison() {

	}

	/**
	 * This function checks for currents class instance and returns one if present.
	 * If not instance available creates new instance and returns that.
	 * 
	 * @author manoj.perla
	 * @return Instance of the class
	 */
	public static Comparison getInstance() {
		if (null == instance) {
			instance = new Comparison();
		}
		return instance;
	}

	/**
	 * This function compares for either equality or NOT Equality of the values
	 * passed based on the ComparisonType parameter. If ComparisonType parameter is
	 * set to true, then comparison will be made for equality else comparison would
	 * be done for NOT equality.
	 * 
	 * @author manoj.perla
	 * @param comparisonType if set to true, will perform comparison for Equality.
	 *                       if set to false, will perform comparison for NOT
	 *                       Equality
	 * @param expectedValue  Expected value should be passed as Object Type
	 * @param actualValue    Actual value should be passed as Object Type
	 */
	public void isEqualsTo(boolean comparisonType, Object expectedValue, Object actualValue) {
		expectedValue=expectedValue+"";
		actualValue=actualValue+"";
		if (comparisonType) {
			try {
				assertThat("Field Validation:: ", expectedValue, equalTo(actualValue));
				logger.info("Field validated sucessfully. Expected : equal to - " + expectedValue + " Actual= : "
						+ actualValue);
				reportConstant.getParentTestNode().log(Status.PASS,
						" Expected : equal to :" + expectedValue.toString() + " Actual!: " + actualValue.toString());
			} catch (AssertionError a) {
				logger.error("Field validation failed. Expected : equals to - " + expectedValue.toString()
						+ " Actual --: " + actualValue.toString());
				util.failTestcase("Assertion Failed,",
						" Expected : equal to: " + expectedValue.toString() + " Actual !!: " + actualValue.toString());
			} catch (Exception e) {
				util.failTestcase("Assertion Failed, ", " Expected : equal to: " + null + " Actual !!!: " + null);
			}
		} else {
			isNotEqualsTo(expectedValue, actualValue);
		}

	}

	/**
	 * This function compares for NOT Equality of the values passed
	 * 
	 * @author manoj.perla
	 * @param expectedValue Expected value should be passed as Object Type
	 * @param actualValue   Actual value should be passed as Object Type
	 */
	private void isNotEqualsTo(Object expectedValue, Object actualValue) {
		try {
			assertThat("Field Validation", expectedValue, not((equalTo(actualValue))));
			logger.info("Field validated sucessfully. Expected : not equal to - " + expectedValue.toString()
					+ "Actual :- " + actualValue.toString());
			reportConstant.getParentTestNode().log(Status.PASS,
					" Expected : not equal to : " + expectedValue.toString() + " Actual :" + actualValue.toString());
		} catch (AssertionError a) {
			logger.error("Field validation failed. Expected : not equal to - " + expectedValue.toString()
					+ " actual -!: " + actualValue.toString());
			util.failTestcase("Assertion Failed ",
					"Expected : not equal to : " + expectedValue.toString() + "actual" + actualValue.toString());
		} catch (Exception e) {
			util.failTestcase("Assertion Failed.", " Expected : not equal to : " + null + "Actual" + null);
		}

	}

	/**
	 * This function compares if the actual value is greater than or equal to
	 * expected value passed
	 * 
	 * @author manoj.perla
	 * @param expectedValue Expected value should be passed as Object Type
	 * @param actualValue   Actual value should be passed as Object Type
	 */
	public void greatOrEqualsTo(Object expectedValue, Object actualValue) {
		String[] primitiveTypeSubString = expectedValue.getClass().getName().split("java.lang.");
		expectedValue = (expectedValue.toString() + "").replaceAll(",", "").replace("-", "");
		actualValue = (actualValue.toString() + "").replaceAll(",", "").replaceAll("-", "");
		try {
			switch (primitiveTypes.valueOf(primitiveTypeSubString[1].toUpperCase())) {
			case LONG:
				greaterComparison(Long.parseLong(expectedValue + ""), Long.parseLong(actualValue + ""));
				break;
			case INTEGER:
				greaterComparison(Integer.parseInt(expectedValue + ""), Integer.parseInt(actualValue + ""));
				break;
			case FLOAT:
				greaterComparison(Float.parseFloat(expectedValue + ""), Float.parseFloat(actualValue + ""));
				break;
			case DOUBLE:
				greaterComparison(Double.parseDouble(expectedValue + ""), Double.parseDouble(actualValue + ""));
				break;
			default:
				logger.error("The field value is not a number.");
				break;
			}

			logger.info("Field validated sucessfully. Expected : greatOrEqualsTo - " + expectedValue.toString()
					+ " Actual: " + actualValue.toString());
			reportConstant.getParentTestNode().log(Status.PASS, " Expected :  greatOrEqualsTo - "
					+ expectedValue.toString() + " Actual value: " + actualValue.toString());
		} catch (AssertionError a) {
			logger.error("Field validation failed. Expected : greatOrEqualsTo - " + expectedValue.toString()
					+ " Actual value is : " + actualValue.toString());
			util.failTestcase("Assertion Failed..", "Expected :  greatOrEqualsTo - " + expectedValue.toString()
					+ " Actual..: " + actualValue.toString());
		} catch (Exception e) {
			util.failTestcase("Assertion Failed. ", " Expected : greatOrEqualsTo : " + null + "Actual: " + null);
		}

	}

	/**
	 * This function compares if the actual value is lesser than or equal to
	 * expected value passed
	 * 
	 * @author manoj.perla
	 * @param expectedValue Expected value should be passed as Object Type
	 * @param actualValue   Actual value should be passed as Object Type
	 */
	public void lessOrEqualsTo(Object expectedValue, Object actualValue) {
		String[] primitiveTypeSubString = expectedValue.getClass().getName().split("java.lang.");
		expectedValue = (expectedValue.toString() + "").replaceAll(",", "").replaceAll("-", "");
		actualValue = (actualValue.toString() + "").replaceAll(",", "").replaceAll("-", "");
		try {
			switch (primitiveTypes.valueOf(primitiveTypeSubString[1].toUpperCase())) {
			case LONG:
				lessComparison(Long.parseLong(expectedValue + ""), Long.parseLong(actualValue + ""));
				break;
			case INTEGER:
				lessComparison(Integer.parseInt(expectedValue + ""), Integer.parseInt(actualValue + ""));
				break;
			case FLOAT:
				lessComparison(Float.parseFloat(expectedValue + ""), Float.parseFloat(actualValue + ""));
				break;
			case DOUBLE:
				lessComparison(Double.parseDouble(expectedValue + ""), Double.parseDouble(actualValue + ""));
				break;
			default:
				logger.error("The field value is not a number.");
			}

			logger.info("Field validated sucessfully. Expected : lessOrEqualsTo - " + expectedValue.toString()
					+ " Actual :" + actualValue.toString());
			reportConstant.getParentTestNode().log(Status.PASS, " Expected :  lessOrEqualsTo - "
					+ expectedValue.toString() + " Actual ::" + actualValue.toString());
		} catch (AssertionError a) {
			logger.error("Field validation failed. Expected : lessOrEqualsTo - " + expectedValue.toString()
					+ " Actual --" + actualValue.toString());
			util.failTestcase(" Assertion Failed", "Expected :  lessOrEqualsTo - " + expectedValue.toString()
					+ " Actual value ::" + actualValue.toString());
		} catch (Exception e) {
			util.failTestcase("Assertion Failed  ", " Expected : lessOrEqualsTo : " + null + " Actual ::" + null);
		}

	}

	/**
	 * This generic method performs less than or equal to comparison for Objects of
	 * class which implemented Comparable
	 * 
	 * @author Manoj.Perla
	 * @param expectedValue Expected value should be passed as Object of class which
	 *                      implemented Comparable
	 * @param actualValue   Actual value should be passed as Object of class which
	 *                      implemented Comparable
	 */
	private <T extends Comparable<T>> void lessComparison(T expectedValue, T actualValue) {
		assertThat("Field Validation", actualValue, lessThanOrEqualTo(expectedValue));
	}

	/**
	 * This generic method performs greater than or equal to comparison for Objects
	 * of class which implemented Comparable
	 * 
	 * @author Manoj.Perla
	 * @param expectedValue Expected value should be passed as Object of class which
	 *                      implemented Comparable
	 * @param actualValue   Actual value should be passed as Object of class which
	 *                      implemented Comparable
	 */
	private <T extends Comparable<T>> void greaterComparison(T expectedValue, T actualValue) {
		assertThat("Field Validation ", actualValue, greaterThanOrEqualTo(expectedValue));
	}

	/**
	 * This function checks if the Actual Values contains the expected value
	 * 
	 * @author Manoj.Perla
	 * @param expectedValue Expected value should be passed as Object Type
	 * @param actualValue   Actual value should be passed as Object Type
	 */
	public void contains(String expectedValue, String actualValue) {
		try {
			assertThat("Field Validation :", actualValue, containsString(expectedValue));
			logger.info("Field validated sucessfully. Expected : contains - " + expectedValue + " Actual value is -"
					+ actualValue);
			reportConstant.getParentTestNode().log(Status.PASS,
					" Expected :  contains - " + expectedValue + " actual value : " + actualValue);
		} catch (AssertionError a) {
			logger.error(
					"Field validation failed. Expected : Contains - " + expectedValue + " Actual.: " + actualValue);
			util.failTestcase("Assertion Failed...",
					"Expected :  contains - " + expectedValue + " Actual...: " + actualValue);
		} catch (Exception e) {
			util.failTestcase(" Assertion Failed ", " Expected : contains : " + null + " Actual..: " + null);
		}
	}
}
