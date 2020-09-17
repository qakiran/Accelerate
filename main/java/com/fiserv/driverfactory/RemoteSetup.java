package com.fiserv.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.fiserv.api.utils.SeeTestManageDevicesAPI;
import com.fiserv.framework.constants.FrameworkConstants;

/**
 * Abstract class for remote tools.
 * 
 * @author dhiraj.bendale
 *
 */
public abstract class RemoteSetup {

	protected abstract WebDriver setRemotePlugIn(DesiredCapabilities capabilities);

	public abstract WebDriver getRemotePlugin(DesiredCapabilities capabilities);

	/**
	 * method will manage the seetest devices using API before they can be used.
	 * 
	 * @author swapnil.mane
	 *
	 */
	public void setSetSeeTestEnviornmentDetails() {
		SeeTestManageDevicesAPI objSeeTestManageDevicesAPI = new SeeTestManageDevicesAPI();
		objSeeTestManageDevicesAPI.getDeviceProperty(FrameworkConstants.getMobileConfig().get("DEVICE_ID_API"),
				"displayStatus");
		objSeeTestManageDevicesAPI.reserveSingleDevice(FrameworkConstants.getMobileConfig().get("DEVICE_ID_API"),
				FrameworkConstants.getMobileConfig().get("START_TIME"),
				FrameworkConstants.getMobileConfig().get("END_TIME"));
	}

}
