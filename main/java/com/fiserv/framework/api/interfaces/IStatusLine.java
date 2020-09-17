package com.fiserv.framework.api.interfaces;

/**
 * @author Piyuskumar.Rupareliya
 */
public interface IStatusLine {

	void isEqualTo(boolean compareType, Object expectedStatusLine);

	void contains(String statusLine);
}
