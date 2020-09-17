package com.fiserv.framework.api.interfaces;

import java.util.List;

import javax.xml.soap.SOAPMessage;

/**
 * @author Sumeetsingh.Thakur
 *
 */
public interface IValidateResponse {

	public Integer getAttributeValueInInteger(SOAPMessage soapMessage, String tagName);

	public String getAttributeValueInString(SOAPMessage soapMessage, String tagName);

	public Double getAttributeValueInDouble(SOAPMessage soapMessage, String tagName);

	public Float getAttributeValueInFloat(SOAPMessage soapMessage, String tagName);

	public List<String> getNodeValueByXpath(String fileName, String xpathOfNode);

}
