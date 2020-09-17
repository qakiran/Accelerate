package com.fiserv.framework.utility.selenium;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * 
 * @author Dhiraj.Bendale
 *
 */
public class AnnotationTransformer implements IAnnotationTransformer {

	/**
	 * @author dhiraj.bendale
	 */
	@SuppressWarnings("rawtypes")
	public void transform(ITestAnnotation annoattion, Class testClass, Constructor testConstructor, Method testMethod) {
		String testCase = testMethod.getName();
		if (testCase.equalsIgnoreCase("")) {
			annoattion.setAlwaysRun(true);
			annoattion.setEnabled(true);
		} else {
			annoattion.setAlwaysRun(false);
			annoattion.setEnabled(false);
		}
	}

}
