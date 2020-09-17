package com.fiserv.framework.api.interfaces;

/**
 * @author Sumeetsingh.Thakur
 *
 */
public interface ISoapServices {

	ICallWebService callWebService(String soapEndpointUrl, String soapAction, String requestPath);
	
	ICallWebService callWebServiceWithBasicAuth(String soapEndpointUrl, String soapAction, String requestPath, String userName, String password );
	
	IValidateResponse validateResponse();
	
}
