package com.fiserv.api.implementation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.soap.*;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

import com.fiserv.api.utils.CommonUtils;
import com.fiserv.framework.api.interfaces.ICallWebService;

public class CallWebService  implements ICallWebService{

	private static CallWebService instance = null;
	private static Logger logger = Logger.getLogger(BaseURL.class);
	SOAPConnectionFactory soapConnectionFactory;
	SOAPConnection soapConnection;
	SOAPMessage soapMessage;
	MessageFactory messageFactory;
	MimeHeaders headers;
	SOAPPart sp;
	StreamSource prepMsg;
	
	private CommonUtils util = CommonUtils.getInstance();

	public CallWebService() {
		// Set access modifier public for default constructor to achieve
		// Singleton Pattern
	}

	public static CallWebService getInstance() {
		if (null == instance) {
			instance = new CallWebService();
		}
		return instance;
	}

	/**
	 * This function is used to execute soap service.
	 * 
	 * @return - SOAPMessage
	 * @author Sumeetsingh.Thakur
	 *
	 */
	public SOAPMessage executeWebService(String soapEndpointUrl, String soapAction, String requestPath) {
		try {
			logger.info("Setting connection : ");
			soapConnectionFactory = SOAPConnectionFactory.newInstance();
			soapConnection = soapConnectionFactory.createConnection();
			soapMessage = soapConnection.call(createRequest(soapAction, requestPath), soapEndpointUrl);
			logger.info("Response SOAP Message:");
			soapConnection.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Set Base URI failed");
		}
		return soapMessage;
	}

	/**
	 * This function is used to create soap request xml without auth
	 * 
	 * @return - SOAPMessage
	 * @author Sumeetsingh.Thakur
	 * @throws SOAPException
	 * @throws FileNotFoundException
	 *
	 */
	private SOAPMessage createRequest(String soapAction, String requestPath)
			throws SOAPException, FileNotFoundException {
		messageFactory = MessageFactory.newInstance();
		soapMessage = messageFactory.createMessage();
		headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", soapAction);
		sp = soapMessage.getSOAPPart();
		prepMsg = new StreamSource(new FileInputStream(requestPath));
		sp.setContent(prepMsg);
		soapMessage.saveChanges();
		logger.info("Request SOAP Message:");
		return soapMessage;
	}

	/**
	 * This function is used to execute soap service with auth
	 * 
	 * @author Sumeetsingh.Thakur
	 *
	 */
	public SOAPMessage executeWebServiceWithAuth(String soapEndpointUrl, String soapAction, String requestPath,
			String userName, String password) {
		try {
			logger.info("Setting connection : ");
			soapConnectionFactory = SOAPConnectionFactory.newInstance();
			soapConnection = soapConnectionFactory.createConnection();
			soapMessage = soapConnection
					.call(createSOAPRequestWithBasicAuth(soapAction, requestPath, userName, password), soapEndpointUrl);

			logger.info("Response SOAP Message:");

			soapConnection.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
			util.failTestcase(e.getMessage(), "Set Base URI failed");
		}
		return soapMessage;
	}

	/**
	 * This function is used to create soap request xml with auth
	 * 
	 * @author Sumeetsingh.Thakur
	 * @throws SOAPException
	 * @throws FileNotFoundException
	 *
	 */
	private static SOAPMessage createSOAPRequestWithBasicAuth(String soapAction, String requestPath, String userName,
			String password) throws SOAPException, FileNotFoundException {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", soapAction);
		SoapAuthentication soapAuthentication = new SoapAuthentication();
		soapAuthentication.sendBasicAuthForSoapAsHeader(userName, password, soapMessage);
		// Object for message parts
		SOAPPart sp = soapMessage.getSOAPPart();
		StreamSource prepMsg = new StreamSource(new FileInputStream(requestPath));
		sp.setContent(prepMsg);
		soapMessage.saveChanges();
		/* Print the request message, just for debugging purposes */
		logger.info("Request SOAP Message:");
		logger.info("\n");
		return soapMessage;

	}
}
