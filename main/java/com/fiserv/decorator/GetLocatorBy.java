package com.fiserv.decorator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.fiserv.decorator.ExtractGetLocatorBy.Locator;

/**
 * Creating custom annotation GetLocatorBy
 * @author vikram.bendre
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface GetLocatorBy 
{
	public Locator androidDeviceLocator();
	public String androidDeviceLocatorValue();
	public Locator desktopLocator();
	public String desktopLocatorValue();
	public Locator iPhoneDeviceLocator();
	public String iPhoneLocatorValue();
}

