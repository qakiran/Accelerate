package com.fiserv.framework.api.interfaces;

/**
 * @author Piyuskumar.Rupareliya
 */
public interface IResponseHeader {

	void isEqualTo(boolean compareType, Object expectedHeaderValue) ;

	void contains(String expectedHeaderValue);

}
