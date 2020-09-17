package com.fiserv.api;

import org.apache.log4j.Logger;
import com.fiserv.api.implementation.CallWebService;
import com.fiserv.api.implementation.ValidateResponse;
import com.fiserv.api.utils.CommonUtils;
import com.fiserv.framework.api.interfaces.ICallWebService;
import com.fiserv.framework.api.interfaces.ISoapServices;
import com.fiserv.framework.api.interfaces.IValidateResponse;
import com.fiserv.framework.utility.report.ExtentReportConstant;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPPart;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public abstract class AbstractSoapAPI implements ISoapServices {
	private static Logger logger = Logger.getLogger(AbstractSoapAPI.class);
	SOAPPart soappart;
	SOAPEnvelope incomingEnvelope;
	SOAPBody body;
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	ArrayList<String> nodeValue;
	XPathFactory xpathfactory;
	XPath xpath;
	Document doc;
	XPathExpression expr;
	Object result;
	NodeList nodes;
	CallWebService cws = CallWebService.getInstance();
	protected ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();
	protected CommonUtils util = CommonUtils.getInstance();

	/**
	 * This function is used to call soap service wihtout auth
	 * 
	 * @author Sumeetsingh.Thakur
	 */
	public ICallWebService callWebService(String soapEndpointUrl, String soapAction, String requestPath) {
		try {

			logger.info("Getting request from path: " + requestPath);
			cws.executeWebService(soapEndpointUrl, soapAction, requestPath);
			return cws;

		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Failed to make a soap call");
		}
		return cws;
	}

	/**
	 * This function is used to call soap service with basic auth
	 * 
	 * @author Sumeetsingh.Thakur
	 */
	public ICallWebService callWebServiceWithBasicAuth(String soapEndpointUrl, String soapAction, String requestPath,
			String userName, String password) {
		try {

			logger.info("Getting request from path: " + requestPath);
			cws.executeWebServiceWithAuth(soapEndpointUrl, soapAction, requestPath, userName, password);
			return cws;

		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Failed to make a soap call");
		}
		return cws;
	}

	/**
	 * This function is used to validate soap service.
	 * 
	 * @author Sumeetsingh.Thakur
	 */
	public IValidateResponse validateResponse() {
		reportConstant.setParentTestNode("Validate Response: ");
		return new ValidateResponse();
	}

}
