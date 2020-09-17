package com.fiserv.api.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import com.fiserv.api.AbstractSoapAPI;
import com.fiserv.api.utils.CommonUtils;
import com.fiserv.api.utils.NamespaceResolver;
import com.fiserv.framework.api.interfaces.IValidateResponse;

public class ValidateResponse implements IValidateResponse{

	private static Logger logger = Logger.getLogger(AbstractSoapAPI.class);
	SOAPPart soappart = null;
	SOAPEnvelope incomingEnvelope = null;
	SOAPBody body = null;
	DocumentBuilderFactory factory = null;
	DocumentBuilder builder = null;
	ArrayList<String> nodeValue = null;
	XPathFactory xpathfactory = null;
	XPath xpath = null;
	Document doc = null;
	XPathExpression expr = null;
	Object result = null;
	NodeList nodes = null;
	CommonUtils util = CommonUtils.getInstance();

	/**
	 * @author sumeetsingh.thakur
	 * @MethodDescription - This method is used get integer value on the basis
	 *                    of tag.
	 * @ReturnType - Integer
	 */
	public Integer getAttributeValueInInteger(SOAPMessage soapMessage, String tagName) {
		try {
			soappart = soapMessage.getSOAPPart();
			incomingEnvelope = soappart.getEnvelope();
			body = incomingEnvelope.getBody();
			return Integer.valueOf(body.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Errror in getAttributeValueInInteger().");
		}
		return Integer.valueOf(body.getElementsByTagName(tagName).item(0).getTextContent());
	}

	/**
	 * @author sumeetsingh.thakur
	 * @MethodDescription - This method is used get String value on the basis of
	 *                    tag.
	 * @ReturnType - String
	 */
	public String getAttributeValueInString(SOAPMessage soapMessage, String tagName) {
		try {
			soappart = soapMessage.getSOAPPart();
			incomingEnvelope = soappart.getEnvelope();
			body = incomingEnvelope.getBody();
			return body.getElementsByTagName(tagName).item(0).getTextContent();
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Errror in getAttributeValueInString().");
		}
		return body.getElementsByTagName(tagName).item(0).getTextContent();
	}

	/**
	 * @author sumeetsingh.thakur
	 * @MethodDescription - This method is used get Double value on the basis of
	 *                    tag.
	 * @ReturnType - Double
	 */
	public Double getAttributeValueInDouble(SOAPMessage soapMessage, String tagName) {
		try {
			soappart = soapMessage.getSOAPPart();
			incomingEnvelope = soappart.getEnvelope();
			body = incomingEnvelope.getBody();
			return Double.valueOf(body.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Errror in getAttributeValueInDouble().");
		}
		return Double.valueOf(body.getElementsByTagName(tagName).item(0).getTextContent());
	}

	/**
	 * @author sumeetsingh.thakur
	 * @MethodDescription - This method is used get Float value on the basis of
	 *                    tag.
	 * @ReturnType - Float
	 */
	public Float getAttributeValueInFloat(SOAPMessage soapMessage, String tagName) {
		try {
			soappart = soapMessage.getSOAPPart();
			incomingEnvelope = soappart.getEnvelope();
			body = incomingEnvelope.getBody();
			return Float.valueOf(body.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Errror in getAttributeValueInFloat().");
		}
		return Float.valueOf(body.getElementsByTagName(tagName).item(0).getTextContent());

	}

	/**
	 * @author sumeetsingh.thakur
	 * @MethodDescription - This method is used get node value on the basis of
	 *                    xpath.
	 * @ReturnType - ArrayList<String>
	 */
	public List<String> getNodeValueByXpath(String fileName, String xpathOfNode) {
		try {
			// Want to read required tag from XML
			nodeValue = new ArrayList<>();
			// Parse XML file
			factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			builder = factory.newDocumentBuilder();
			doc = builder.parse(new FileInputStream(
					new File(System.getProperty("user.dir") + System.lineSeparator() + fileName + ".xml")));
			// Get XPath expression
			xpathfactory = XPathFactory.newInstance();
			xpath = xpathfactory.newXPath();
			xpath.setNamespaceContext(new NamespaceResolver(doc));
			expr = xpath.compile(xpathOfNode + "/text()");
			// Search XPath expression
			result = expr.evaluate(doc, XPathConstants.NODESET);
			// Iterate over results and fetch node value
			nodes = (NodeList) result;
			for (int nodeIterator = 0; nodeIterator < nodes.getLength(); nodeIterator++) {
				nodeValue.add(nodes.item(nodeIterator).getNodeValue());
			}
			// Return node value
			return nodeValue;
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Errror in getNodeValueByXpath().");
		}
		return nodeValue;
	}
}
