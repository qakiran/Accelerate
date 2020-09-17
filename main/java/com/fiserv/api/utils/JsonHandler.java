package com.fiserv.api.utils;

import java.io.FileReader;
import java.io.FileWriter;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.JsonNode;
import com.fiserv.framework.utility.report.ExtentReportConstant;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

public class JsonHandler{

	private Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
			.mappingProvider(new JacksonMappingProvider()).build();
	private static Logger logger = Logger.getLogger(JsonHandler.class);
	private static JsonHandler instance = null;

	private JsonNode updatedJson = null;
	
	CommonUtils util = CommonUtils.getInstance();
	ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();

	protected JsonHandler() {

	}

	/**
	 * This function checks for currents class instance and returns one if
	 * present. If not instance available creates new instance and returns that.
	 * 
	 * @author manoj.perla
	 * @return Instance of the class
	 */
	public static JsonHandler getInstance() {
		if (null == instance) {
			instance = new JsonHandler();
		}
		return instance;
	}

	/**
	 * This functions writes JSON content to a File
	 * 
	 * @author manoj.perla
	 * @param jsonObject
	 *            JSON content as jsonObject
	 * @param filePath
	 *            file path to which the content has to be written should be
	 *            passed as String
	 */
	public void writeJsontoFile(JSONObject jsonObject, String filePath) {

		writeJsontoFile(jsonObject.toJSONString(), filePath);
	}

	/**
	 * This function writes JSON String to a File
	 * 
	 * @author manoj.perla
	 * @param jsonString
	 *            JSON String as String
	 * @param filePath
	 *            file Path to be passed as String
	 */
	public void writeJsontoFile(String jsonString, String filePath) {
		try (FileWriter file = new FileWriter(filePath)) {
			file.write(jsonString);
			logger.info("Json value written to File: " + jsonString);
			if (reportConstant.getParentTestNode() != null) {
				reportConstant.getParentTestNode().log(Status.PASS, jsonString);
			} else {
				reportConstant.setParentTestNode("Write to JSON File:");
				reportConstant.getParentTestNode().log(Status.PASS, jsonString);
			}
		} catch (Exception e) {
			logger.error("Exception " + e.getMessage());
			util.failTestcase(e.getMessage(), e.getMessage());
		}
	}

	/**
	 * This function would read the JSON content from the file based on the JSON
	 * Path Passed and return JSON value as string
	 * 
	 * @author manoj.perla
	 * @param filePath
	 *            file Path to be read should be passed as String
	 * @param jsonPath
	 *            json path as String
	 * @return JSON value as String
	 */
	public String readJsonfromFile(String filePath, String jsonPath) {
		String jsonvalue = "";
		try {
			jsonvalue = JsonPath.using(configuration).parse(readJsonfromFile(filePath)).read("$." + jsonPath)
					.toString();
			logger.info("Json Value read from file: " + jsonvalue);
			reportConstant.getParentTestNode().log(Status.PASS, jsonvalue);

		} catch (Exception e) {
			logger.error("Exception:" + e.getMessage());
			util.failTestcase(e.getMessage(), e.getMessage());
		}

		return jsonvalue;

	}

	/**
	 * This function would read all the JSON content from the file and returns
	 * JSON Object
	 * 
	 * @author manoj.perla
	 * @param filePath
	 *            file Path to be passed as String
	 * @return JSON Content as String
	 */
	public String readJsonfromFile(String filePath) {
		JSONObject jsonObject = null;
		String jsonObjectValue = null;
		try (FileReader file = new FileReader(filePath)) {

			jsonObject = (JSONObject) new JSONParser().parse(file);
			if (jsonObject != null)
				jsonObjectValue = jsonObject.toJSONString();
			logger.info("Json Value read from file: " + jsonObject);
			if (reportConstant.getParentTestNode() != null) {
				reportConstant.getParentTestNode().log(Status.PASS, jsonObjectValue);
			} else {
				reportConstant.setParentTestNode("Read From JSON File:");
				reportConstant.getParentTestNode().log(Status.PASS, jsonObjectValue);
			}

		} catch (Exception e) {
			logger.error("Exception Found!" + e.getMessage());
			reportConstant.setParentTestNode("Read From File: ");
			util.failTestcase(e.getMessage(), e.getMessage());
		}
		return jsonObjectValue;
	}

	/**
	 * This function would modify the JSON content based on the JSON Path Passed
	 * and return modified JSON content as string
	 * 
	 * @author manoj.perla
	 * @param jsonSource
	 *            JSON content to be passed as String
	 * @param jsonpath
	 *            JSON path as String
	 * @param Value
	 *            Value should be passed as Object type
	 * @return Modified JSON Content as String
	 */
	public String modfiyJson(String jsonSource, String jsonpath, Object value) {
		try {
			updatedJson = JsonPath.using(configuration).parse(jsonSource).set("$." + jsonpath, value).json();
			logger.info("Modified Json: " + updatedJson);
		} catch (Exception e) {
			logger.error("Exception Found :" + e.getMessage());
			reportConstant.setParentTestNode("Modify Json: ");
			util.failTestcase(e.getMessage(), e.getMessage());
		}
		return updatedJson.toString();
	}

	/**
	 * This function would modify the JSON content in a file based on the JSON
	 * Path Passed and return modified JSON content as string
	 * 
	 * @author manoj.perla
	 * @param jsonSourceFileName
	 *            pass File Name as String.
	 * @param jsonpath
	 *            JSON path as String
	 * @param Value
	 *            Value should be passed as Object type
	 * @return Modified JSON Content as String
	 */

	public String modfiyJsonfromFile(String jsonSourceFileName, String jsonpath, Object value) {
		try {
			updatedJson = JsonPath.using(configuration).parse(readJsonfromFile(jsonSourceFileName))
					.set("$." + jsonpath, value).json();
			writeJsontoFile(updatedJson.toString(), jsonSourceFileName);
			logger.info("File modified successfully and the Updated Json is: " + updatedJson);

		} catch (Exception e) {
			logger.error("Exception Found -" + e.getMessage());
			reportConstant.setParentTestNode("Modify Json: ");
			util.failTestcase(e.getMessage(), e.getMessage());
		}
		return updatedJson.toString();
	}

	/**
	 * This function would read the JSON content from the file based on the JSON
	 * Path Passed and return JSON value as string
	 * 
	 * @author manoj.perla * @param jsonSource pass JSON source as String
	 * @param jsonPath
	 *            Json Path of the field to be read should be passed as String
	 * @return JSON value as String
	 */
	public String readJsonValue(String jsonSource, String jsonPath) {
		String jsonvalue = "";
		try {
			jsonvalue = JsonPath.using(configuration).parse(jsonSource).read("$." + jsonPath).toString();
			logger.info("Json Value read: " + jsonvalue);
		} catch (Exception e) {
			logger.error("Exception Found.." + e.getMessage());
			util.failTestcase(e.getMessage(), e.getMessage());
		}

		return jsonvalue;

	}

}
