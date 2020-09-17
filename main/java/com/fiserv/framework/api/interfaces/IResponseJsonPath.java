package com.fiserv.framework.api.interfaces;

/**
 * @author manoj.perla
 */
public interface IResponseJsonPath {

	void isEqualTo(boolean compareType, Object expectedValue);

	void fieldLengthEqualTo(int expectedFieldLength);

	void fieldLengthGreatOrEqualTo(int expectedFieldLength);

	void fieldLengthLessOrEqualTo(int expectedFieldLength);
	
	void contains(String expectedValue);
	
	void isLessOrEqualTo(Object expectedValue);
	
	void isGreaterOrEqualTo(Object expectedValue);
}
