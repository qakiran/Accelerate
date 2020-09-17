package com.fiserv.framework.api.interfaces;

import java.util.Map;

/**
 * @author Piyuskumar.Rupareliya
 */
public interface IAddHeadersParameters {

	IAddParameter addParameter(String parameter);

	void addParameterMap(Map<String, String> headerParametersHashMap);
}
