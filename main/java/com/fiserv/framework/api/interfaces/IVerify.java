package com.fiserv.framework.api.interfaces;

/**
 * @author Piyuskumar.Rupareliya
 */
import java.util.concurrent.TimeUnit;

public interface IVerify {

	IResponseHeader header(String headerName);

	IStatusCode statusCode();

	IStatusLine statusLine();

	IResponseTime responseTime(TimeUnit tUnit);

	IResponseJsonPath jsonPath(String jpath);

	IXPath xPath(String xpath);

	void jsonResponseSchema(String filePath);

}
