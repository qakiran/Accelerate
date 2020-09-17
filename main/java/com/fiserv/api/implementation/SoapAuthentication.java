package com.fiserv.api.implementation;
import javax.xml.soap.*;
public class SoapAuthentication {
	/**
	 * This function is setter method for Basic SoapAuthentication
	 * 
	 * @author Sumeetsingh.Thakur, Akshay.Sharma
	 * @param uname, password SoapAuthentication credentials should be passed as String
	 */
	@SuppressWarnings("restriction")
	public void sendBasicAuthForSoapAsHeader(String username, String password, SOAPMessage soapMessage) {
		String authorization = new sun.misc.BASE64Encoder().encode((username + ":" + password).getBytes());
		javax.xml.soap.MimeHeaders hd = soapMessage.getMimeHeaders();
		hd.addHeader("Authorization", "Basic " + authorization);
	}

}
