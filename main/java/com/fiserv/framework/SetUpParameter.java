package com.fiserv.framework;

import org.apache.log4j.Logger;
import com.fiserv.framework.constants.FrameworkConstants;

public class SetUpParameter {
	private static Logger logger = Logger.getLogger(SetUpParameter.class);

	public void setExcutionParameter() {
		logger.info("Setting execution parameter configuration.");
		logger.info("EXECUTION ON : " + FrameworkConstants.getExecutionOn());
		logger.info("EXECUTION TARGETED ON :  " + FrameworkConstants.getTarget());

	}
}
