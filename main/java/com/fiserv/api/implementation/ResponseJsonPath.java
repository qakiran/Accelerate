package com.fiserv.api.implementation;

/**
 * @author manoj.perla
 */
import org.apache.log4j.Logger;

import com.fiserv.framework.api.interfaces.IResponseJsonPath;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fiserv.api.utils.CommonUtils;
import com.fiserv.api.utils.Comparison;

public class ResponseJsonPath implements IResponseJsonPath{

	private String jsonpath;
	private static ResponseJsonPath instance = null;
	private static Logger logger = Logger.getLogger(ResponseJsonPath.class);
	private ResponseBuilder rspBuild = ResponseBuilder.getBuilder();
	private Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
			.mappingProvider(new JacksonMappingProvider()).build();
	private Comparison compare = Comparison.getInstance();
	private CommonUtils util = CommonUtils.getInstance();

	private enum jsonNodeTypes {
		DOUBLENODE, INTNODE, LONGNODE, BOOLEANNODE, TEXTNODE, NULLNODE
	}

	protected ResponseJsonPath() {

	}

	/**
	 * This function gets status code from response and sets it using status
	 * code setter method
	 * 
	 * @author manoj.perla
	 * @return Instance of ResponseJsonPath
	 */
	public static ResponseJsonPath getInstance() {
		if (null == instance) {
			instance = new ResponseJsonPath();
		}
		return instance;
	}

	/**
	 * This function is setter method for jsonpath
	 * 
	 * @author manoj.perla
	 * @param jpath
	 *            JSON path to be passed as String
	 */
	public void setjsonpath(String jpath) {
		this.jsonpath = jpath;

	}

	/**
	 * This function is getter method for jsonpath
	 * 
	 * @author Manoj.Perla
	 * @return jsonpath as String
	 */
	public String getjsonpath() {
		return jsonpath;

	}

	/**
	 * This function compares for either equality or NOT Equality of the
	 * Expected value passed based on the compareType set. This function should
	 * be used to compare field values based on Json Path. User don't have to
	 * explicitly send Actual value, internally the function reads the response
	 * and get the Actual value at that Json path
	 * 
	 * @author manoj.perla
	 * @param expectedValue
	 *            Expected Value should be passed as Object Type
	 * @param compareType
	 *            Pass true if you want to perform Equals To comparison, Else
	 *            pass false to perform Not Equals to Comparison
	 */
	public void isEqualTo(boolean compareType, Object expectedValue) {
		logger.debug("Expected Value : " + expectedValue);
		compare.isEqualsTo(compareType, expectedValue, (Object) getFieldValue());
	}

	/**
	 * This function checks if Actual Value is less than or equal to Expected
	 * value passed. This function should be used to compare field values based
	 * on Json Path. User don't have to explicitly send Actual value, internally
	 * the function reads the response and get the Actual value at that Json
	 * path
	 * 
	 * @author manoj.perla
	 * @param expectedValue
	 *            Expected Value should be passed as Object Type
	 */
	public void isLessOrEqualTo(Object expectedValue) {
		logger.debug("Expected Value:" + expectedValue);
		compare.lessOrEqualsTo(expectedValue, (Object) getFieldValue());
	}

	/**
	 * This function checks if Actual Value is greater than or equal to Expected
	 * value passed. This function should be used to compare field values based
	 * on Json Path. User don't have to explicitly send Actual value, internally
	 * the function reads the response and get the Actual value at that Json
	 * path
	 * 
	 * @author manoj.perla
	 * @param expectedValue
	 *            Expected Value should be passed as Object Type
	 */
	public void isGreaterOrEqualTo(Object expectedValue) {
		logger.debug("Expected Value :" + expectedValue);
		compare.greatOrEqualsTo(expectedValue, (Object) getFieldValue());
	}

	/**
	 * This function checks if Actual Value contains Expected value passed. This
	 * function should be used to compare field values based on Json Path. User
	 * don't have to explicitly send Actual value, internally the function reads
	 * the response and get the Actual value at that Json path
	 * 
	 * @author manoj.perla
	 * @param expectedValue
	 *            Expected Value should be passed as String
	 */
	public void contains(String expectedValue) {
		logger.debug("Expected Value  : " + expectedValue);
		compare.contains(expectedValue, (String) getFieldValue());
	}

	/**
	 * This function compares for equality of the Expected field length passed.
	 * This function should be used to compare field length values based on Json
	 * Path. User don't have to explicitly send Actual field length, internally
	 * the function reads the response and get the Actual length of the field at
	 * that Json path
	 * 
	 * @author manoj.perla
	 * @param expectedFieldLength
	 *            Expected Field length should be passed as integer
	 */
	public void fieldLengthEqualTo(int expectedFieldLength) {
		logger.debug("Actual Field length: " + (getFieldValue().toString().length()));
		logger.debug("Expected Field length:" + expectedFieldLength);
		logger.info("Validating Json Field Length :");
		compare.isEqualsTo(true, (Object) expectedFieldLength, (Object) (getFieldValue().toString().length()));
	}

	/**
	 * This function compares for greater or equality of the Expected field
	 * length passed. This function should be used to compare field length
	 * values based on Json Path. User don't have to explicitly send Actual
	 * field length, internally the function reads the response and get the
	 * Actual length of the field at that Json path
	 * 
	 * @author manoj.perla
	 * @param expectedFieldLength
	 *            Expected Field length should be passed as integer
	 */
	public void fieldLengthGreatOrEqualTo(int expectedFieldLength) {
		logger.debug("Actual Field length is : " + (getFieldValue().toString().length()));
		logger.debug("Expected Field length::" + expectedFieldLength);
		logger.info("Validating Json Field Length.");
		compare.greatOrEqualsTo((Object) expectedFieldLength, (Object) (getFieldValue().toString().length()));
	}

	/**
	 * This function compares for lesser or equality of the Expected field
	 * length passed. This function should be used to compare field length
	 * values based on Json Path. User don't have to explicitly send Actual
	 * field length, internally the function reads the response and get the
	 * Actual length of the field at that Json path
	 * 
	 * @author manoj.perla
	 * @param expectedFieldLength
	 *            Expected Field length should be passed as integer
	 */
	public void fieldLengthLessOrEqualTo(int expectedFieldLength) {
		logger.debug("Actual Field length:" + (getFieldValue().toString().length()));
		logger.debug("Expected Field length" + expectedFieldLength);
		logger.info("Validating Json Field Length");
		compare.lessOrEqualsTo((Object) expectedFieldLength, (Object) (getFieldValue().toString().length()));
	}

	/**
	 * This function gets the Actual Field Value in the response body as per the
	 * JSON path
	 * 
	 * @author manoj.perla
	 * @return - Actual Field Value in the response body as Object
	 */
	private Object getFieldValue() {
		Object jsonValobj = "";
		try {
			logger.debug("Actual Value read from Json path: " + JsonPath.using(configuration)
					.parse(rspBuild.getReponse().asString().replace("[", "").replace("[", "")).read("$." + getjsonpath()).toString().trim());
			Object jobj = JsonPath.using(configuration).parse(rspBuild.getReponse().asString().replace("[", "").replace("[", ""))
					.read("$." + getjsonpath());
			String[] jsonNodeTypeSubString = jobj.getClass().getName().split("databind.node.");
			switch (jsonNodeTypes.valueOf(jsonNodeTypeSubString[1].toUpperCase())) {
			case DOUBLENODE:
				return (Object) ((DoubleNode) jobj).asDouble();
			case INTNODE:
				return (Object) ((IntNode) jobj).asInt();
			case LONGNODE:
				return (Object) ((LongNode) jobj).asLong();
			case BOOLEANNODE:
				return (Object) ((BooleanNode) jobj).asBoolean();
			case TEXTNODE:
				return ((TextNode) jobj).asText();
			default:
				break;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Get json field value Failed");
		}
		return jsonValobj;
	}

}
