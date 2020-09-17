package com.fiserv.framework.api.interfaces;

/**
 * @author Piyuskumar.Rupareliya
 */
public interface IServices {

	ISetURL setBaseURL(String baseURL);

	ISetRequestBody setRequestBodyFromFile(String filePath);

	ISetRequestBody setRequestBody(Object strBody);

	IExecute execute();

	IVerify verify();

	IAddQueryParameters queryParam();

	IAddPathParameters pathParam();

	IAddHeadersParameters header();

	String getResponseBody();

	void removeQueryParameters();

	void removePathParameters();

}
