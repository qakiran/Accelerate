package com.fiserv.api.implementation;

import org.apache.log4j.Logger;
import io.restassured.builder.RequestSpecBuilder;

/**
 * @author Piyuskumar.Rupareliya
 * 
 *         To get request specification singleton class instance
 */

public class RequestBuilder{

	private static RequestBuilder builder = null;
	private RequestSpecBuilder instance = null;
	private static Logger logger = Logger.getLogger(RequestBuilder.class);

	/*
	 * Set access modifier protected for default constructor to achieve
	 * Singleton Pattern
	 */
	public RequestBuilder() {
		// Do nothing
	}

	/**
	 * This function checks for instance of RequestSpecBuilder and returns one
	 * if present. If instance not available, then creates new instance and
	 * returns that.
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of the RequestSpecBuilder
	 */
	public RequestSpecBuilder getBuilder() {
		if (instance == null) {
			instance = new RequestSpecBuilder();
			logger.debug("RequestSpecBuilder Object is created");
		}
		return instance;

	}

	/**
	 * This function checks for currents class instance and returns one if
	 * present. If instance not available, then creates new instance and returns
	 * that.
	 * 
	 * @author Manoj.Perla
	 * @return Instance of the RequestBuilder
	 */
	public static RequestBuilder getRequestBuilder() {
		if (builder == null) {
			builder = new RequestBuilder();
			logger.debug("RequestBuilder Object is created");
		}
		return builder;
	}

	/**
	 * This function checks if instance is not null, then sets it to null and
	 * creates a new instance of RequestSpecBuilder.
	 * 
	 * @author manoj.perla
	 */
	public void killRequestSpecBuilder() {
		if (instance != null) {
			instance = null;
			instance = new RequestSpecBuilder();
		}
	}

}
