package com.fiserv.decorator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.fiserv.framework.constants.FrameworkConstants;

/**
 * using FindElementBy annotation and get the value for web element as runtime
 * 
 * @author vikram.bendre
 */
public class ExtractGetLocatorBy {
	private String propertyValue = null;
	private Locator locatorStrategy;
	private Logger logger = Logger.getLogger(ExtractGetLocatorBy.class);

	/*
	 * with this static method we will inialize the given page class using
	 * reflection and with that object of class we will set the values for our
	 * by elements at runtime
	 */
	public static <T> T initAnnotaion(Class<T> pageClassToProxy) {
		ExtractGetLocatorBy getLocatorBy = new ExtractGetLocatorBy();
		T page = getLocatorBy.instantiatePage(pageClassToProxy);
		getLocatorBy.getAnotaionPropertyValue(page);
		return page;
	}

	private <T> T instantiatePage(Class<T> pageClassToProxy) {
		try {
			Constructor<T> constructor = pageClassToProxy.getConstructor();
			return constructor.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * we get all the fields present in the class object iterate through all
	 * these fields and set the values to the element at runtime
	 * 
	 * @param page
	 */
	private <T> void getAnotaionPropertyValue(T page) {
		try {
			Field[] fields = page.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (field.getType().getName().equals("org.openqa.selenium.By")) {
					getAnnotationPropertyValues(field);
					setLocatorStrategyForField(field, page);
				}
			}
		} catch (IllegalArgumentException ex) {
			logger.error("Got IllegalArgumentException " + ex.getCause());
		} catch (IllegalAccessException ex) {
			logger.error("Got IllegalAccessException " + ex.getCause());
		} catch (Exception ex) {
			logger.debug("This class done not have any fields with annotation pressent" + ex.getCause());
		}
	}

	/**
	 * we read the annotation values provided by user and set the value as per
	 * the execution environment set in properties file
	 * 
	 * @param elements
	 */
	private void getAnnotationPropertyValues(Field currentField) {
		String valueFromPropertyFile = FrameworkConstants.getExecutionOn().toUpperCase();
		GetLocatorBy objAnnotaion = currentField.getAnnotation(GetLocatorBy.class);
		if (valueFromPropertyFile.equals("MOBILE")) {
			RuntimeEnv valueFromPropertymobile = RuntimeEnv
					.valueOf(FrameworkConstants.getMobileConfig().get("PLATFORM_OS").toUpperCase());
			switch (valueFromPropertymobile) {
			case IPHONE:
				locatorStrategy = objAnnotaion.iPhoneDeviceLocator();
				propertyValue = objAnnotaion.iPhoneLocatorValue();
				break;
			case ANDROID:
				locatorStrategy = objAnnotaion.androidDeviceLocator();
				propertyValue = objAnnotaion.androidDeviceLocatorValue();
				break;
			default:
				logger.debug("Please define correct envoirnment Type");
				break;
			}
		} else if (valueFromPropertyFile.equals("DESKTOP")) {
			locatorStrategy = objAnnotaion.desktopLocator();
			propertyValue = objAnnotaion.desktopLocatorValue();
		} else {
			logger.debug("Please define correct envoirnment Type");
		}
	}

	/**
	 * we set the property values for the element according to the respected
	 * locator strategy
	 * 
	 * @param elements
	 */
	private <T> void setLocatorStrategyForField(Field currentField, T page) throws IllegalAccessException {
		switch (locatorStrategy) {
		case ID:
			logger.debug("Returing by object for value of id : " + propertyValue);
			currentField.set(page, By.id(propertyValue));
			break;
		case NAME:
			logger.debug("Returing by object for value of name : " + propertyValue);
			currentField.set(page, By.name(propertyValue));
			break;
		case CSS:
			logger.debug("Returing by object for value of css: " + propertyValue);
			currentField.set(page, By.cssSelector(propertyValue));
			break;
		case XPATH:
			logger.debug("Returing by object for value of xpath : " + propertyValue);
			currentField.set(page, By.xpath(propertyValue));
			break;
		case LINKTEXT:
			logger.debug("Returing by object for value of linkText: " + propertyValue);
			currentField.set(page, By.linkText(propertyValue));
			break;
		case PARTIALLINKTEXT:
			logger.debug("Returing by object for value of partial link text : " + propertyValue);
			currentField.set(page, By.partialLinkText(propertyValue));
			break;
		case TAGNAME:
			logger.debug("Returing by object for value of tagname: " + propertyValue);
			currentField.set(page, By.tagName(propertyValue));
			break;
		case CLASSNAME:
			logger.debug("Returing by object for value of classname: " + propertyValue);
			currentField.set(page, By.className(propertyValue));
			break;
		}
	}

	/**
	 * enum to define the Runtime Environment
	 * 
	 * @author vikram.bendre
	 *
	 */
	private enum RuntimeEnv {
		IPHONE, ANDROID, DESKTOP, MOBILE
	}

	/**
	 * enum to define the find strategy for particular web element
	 * 
	 * @author vikram.bendre
	 */
	public enum Locator {
		ID, NAME, TAGNAME, CSS, LINKTEXT, PARTIALLINKTEXT, XPATH, CLASSNAME
	}
}
