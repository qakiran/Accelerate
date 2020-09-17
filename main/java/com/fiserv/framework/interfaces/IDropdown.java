package com.fiserv.framework.interfaces;

import java.util.List;

public interface IDropdown {

	List<String> getAllOptions();

	void selectByVisibleText(String value);

	void selectByIndex(int index);

	void selectByValue(String value);
	
	String getFirstSelectedOption();

}
