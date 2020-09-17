package com.fiserv.framework.api.interfaces;

import java.util.Map;
/**
 * @author Piyuskumar.Rupareliya
 */


public interface IAddPathParameters {

	IAddParameter addParameter(String parameter);

	void addParameterMap(Map<String, String> pathParametersHashMap);
}
