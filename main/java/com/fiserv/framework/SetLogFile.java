package com.fiserv.framework;

import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.constants.ReportConstants;
import com.fiserv.framework.utility.files.PropertiesFiles;

public class SetLogFile {

	private static SetLogFile instance = null;
	private PropertiesFiles prop = new PropertiesFiles();
	private SetupExcecutionFolder excecutionOn = new SetupExcecutionFolder();
	private ExecutionParameters executionParam = new ExecutionParameters();

	protected SetLogFile() {

	}

	public static SetLogFile getInstance() {
		if (null == instance) {
			instance = new SetLogFile();
			instance.setLogConfiguration();

		}
		return instance;
	}

	private void setLogConfiguration() {
		setLogPath();
		System.setProperty("logfile.name", ReportConstants.getOutputFolder() + "logs.log");
		SetUpParameter setUpParameter = new SetUpParameter();
		setUpParameter.setExcutionParameter();

	}

	private void setLogPath() {
		FrameworkConstants.setglobalConfig(prop.readProperties(FrameworkConstants.CONFIGFILE));
		setupEnvironmrnt();
		executionParam.setupGlobalConfigParamter();
		excecutionOn.folderStructure();
	}

	private void setupEnvironmrnt() {
		if (System.getProperty("executionOn") != null) {
			FrameworkConstants.getGlobalConfig().put("TARGET", System.getProperty("target"));
			FrameworkConstants.getGlobalConfig().put("EXECUTION_ON", System.getProperty("executionOn"));
		}
	}
}
