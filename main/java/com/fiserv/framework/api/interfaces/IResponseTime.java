package com.fiserv.framework.api.interfaces;

/**
 * @author Piyuskumar.Rupareliya
 */
public interface IResponseTime {
	
	void isLessOrEqualTo(Object responseTime);
	
	void isGreaterOrEqualTo(Object responseTime);
}
