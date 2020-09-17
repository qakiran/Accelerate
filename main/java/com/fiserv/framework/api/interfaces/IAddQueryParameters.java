/**
 * 
 */
package com.fiserv.framework.api.interfaces;

import java.util.Map;

/**
 * @author Piyushkumar.Rupareliya
 *
 */
public interface IAddQueryParameters {

	IAddParameter addParameter(String parameter);

	void addParameterMap(Map<String, String> queryParametersHashMap);
}
