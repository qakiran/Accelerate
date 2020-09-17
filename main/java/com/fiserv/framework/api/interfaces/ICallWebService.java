package com.fiserv.framework.api.interfaces;
import javax.xml.soap.SOAPMessage;
/**
 * @author Sumeetsingh.Thakur
 *
 */
public interface ICallWebService {
	
	public SOAPMessage executeWebService(String soapEndpointUrl, String soapAction, String requestPath);
	
}
