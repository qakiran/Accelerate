package com.fiserv.framework;

import com.fiserv.framework.utility.report.ExtentManager;

public class Initialize {

	private static Initialize instance = null;

	protected Initialize() {
		SetLogFile.getInstance();
	}

	public static Initialize getInstance() {
		if (null == instance) {
			instance = new Initialize();
			ExtentManager.getInstance().getExtent();
		}
		return instance;
	}

}
