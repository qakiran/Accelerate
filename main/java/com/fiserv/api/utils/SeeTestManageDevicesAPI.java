package com.fiserv.api.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.utility.DateTime;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class SeeTestManageDevicesAPI {

	private static Logger logger = Logger.getLogger(SeeTestManageDevicesAPI.class);
	private DateTime getDate = new DateTime();
	private String urlBase = FrameworkConstants.getMobileConfig().get("CLOUD_URL");
	private String user = FrameworkConstants.getMobileConfig().get("USERNAME");
	private String password = FrameworkConstants.getMobileConfig().get("PASSWORD");
	private HttpResponse<String> response;
	private String urlAPI = urlBase + "api/v1/devices/";
	private String dateFormat = "yyyy-MM-dd-HH-mm-ss";
	private static String deviceNameTxt = "deviceName";

	private static Map<String, Map<String, String>> seeTest = new HashMap<>();

	public SeeTestManageDevicesAPI() {
		try {
			response = Unirest.get(urlAPI).basicAuth(user, password).asString();
			logger.info("Json Response: " + response.getBody());
			getAllAvailableDevices();
		} catch (Exception e) {
			logger.error("Exception." + e.getMessage());
		}
	}

	/**
	 * This will create json map for retrive data from JSON
	 * 
	 * @param object
	 * @author swapnil.mane NOTE: Currently able to manage last device
	 *         properties , working on managing all other devices.
	 * 
	 */
	public static void jsonToMap(Object object) {
		JSONObject jObject = new JSONObject(object.toString());
		Iterator<?> keys = jObject.keys();
		String count = null;
		HashMap<String, String> subMap = new HashMap<>();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			if (!key.substring(0, 2).equalsIgnoreCase("is")) {
				String value = jObject.getString(key);
				subMap.put(key, value);
				if (key.equalsIgnoreCase(deviceNameTxt)) {
					count = value;
				}
			}
		}
		seeTest.put(count, subMap);

	}

	/**
	 * This will give all available devices
	 * 
	 * @author swapnil.mane
	 */
	public void getAllAvailableDevices() {
		try {
			JSONObject jObject = new JSONObject(response.getBody());
			JSONArray data = jObject.getJSONArray("data");
			if (data != null) {
				for (int i = 0; i < data.length(); i++) {
					jsonToMap(data.get(i));
				}
			}
		} catch (Exception e) {
			logger.error("Exception " + e.getMessage());
		}
	}

	/**
	 * This function will give you the particular device property
	 * 
	 * @param deviceID
	 *            deviceProperty
	 * @author swapnil.mane
	 */
	public String getDeviceProperty(String deviceName, String deviceProperty) {
		return seeTest.get(deviceName).get(deviceProperty);
	}

	/**
	 * This function will reserve a single device
	 * 
	 * @param deviceID,startTime,endTime
	 * @author swapnil.mane
	 */
	public void reserveSingleDevice(String deviceName, String startTime, String endTime) {

		String deviceID = getDeviceProperty(deviceName, "id");

		if (startTime.equals("now")) {
			startTime = getDate.getCurrentDate(dateFormat);
		}
		String availability = getDeviceProperty(deviceName, "displayStatus");
		try {
			if (!availability.equalsIgnoreCase("In Use")) {
				String timeStamp = getDate.getCurrentDate(dateFormat);
				urlAPI = urlAPI + deviceID + "/reservations/new";

				Unirest.post(urlAPI).basicAuth(user, password).queryString("clientCurrentTimestamp", timeStamp)
						.queryString("start", startTime).queryString("end", endTime).asString();

				logger.info("Device :" + getDeviceProperty(deviceName, deviceNameTxt) + " reserved for startTime:"
						+ startTime + " endTime :" + endTime);
			} else {
				logger.info("Device Already in Use");

			}

		} catch (Exception e) {
			logger.error("Exception... " + e.getMessage());
		}
	}

	/**
	 * This function will specific device details
	 * 
	 * @param deviceID
	 * @author swapnil.mane
	 */
	public void getSpecificDevice(String deviceID) {
		try {
			String url = urlAPI + deviceID;
			HttpResponse<String> deviceResponse = Unirest.get(url).basicAuth(user, password).asString();
			logger.info("Device Details are: " + deviceResponse.getBody());
		} catch (Exception e) {
			logger.error("Exception :" + e.getMessage());
		}
	}

	/**
	 * This function will release specific device
	 * 
	 * @param deviceID
	 * @author swapnil.mane
	 */
	public void releaseSpecificDevice(String deviceName) {
		try {

			String deviceID = getDeviceProperty(deviceName, "id");
			String releaseUrl = urlAPI + deviceID + "/release";
			Unirest.post(releaseUrl).basicAuth(user, password).asString();
			logger.info("Device: " + getDeviceProperty(deviceID, deviceName) + " Realeased");

		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
	}

	/**
	 * This function will reboot the device
	 * 
	 * @param deviceID
	 * @author swapnil.mane
	 */
	public void rebootSpecificDevice(String deviceID) {
		try {
			String rebootUrl = urlAPI + deviceID + "/reboot";
			Unirest.post(rebootUrl).basicAuth(user, password).asString();
			logger.info("Device : " + getDeviceProperty(deviceID, deviceNameTxt) + " rebooted");
		} catch (Exception e) {
			logger.error("Exception.. " + e.getMessage());
		}
	}

	/**
	 * This function will reboot the device
	 * 
	 * @param devicesLists,startTime,endTime
	 * @author swapnil.mane
	 */
	public void reserveMultiDevices(String devicesLists, String startTime, String endTime) {
		try {
			String timeStamp = getDate.getCurrentDate(dateFormat);
			String reserveUrl = urlAPI + "reservations/new";

			Unirest.post(reserveUrl).basicAuth(user, password).queryString("clientCurrentTimestamp", timeStamp)
					.queryString("start", startTime).queryString("end", endTime)
					.queryString("devicesList", devicesLists).queryString("userId", "3").queryString("projectId", "2")
					.asString();

			logger.info("devicesLists");
		} catch (Exception e) {
			logger.error("Exception." + e.getMessage());
		}
	}

	/**
	 * This function will reboot the device
	 * 
	 * @param deviceID
	 * @author swapnil.mane
	 */
	public void resetDeviceUSBConnection(String deviceID) {
		try {
			String resetUrl = urlAPI + deviceID + "/resetusb";
			Unirest.post(resetUrl).basicAuth(user, password).asString();
			logger.info("USB connection reset for " + getDeviceProperty(deviceID, deviceNameTxt));
		} catch (Exception e) {
			logger.error("Exception. " + e.getMessage());
		}
	}

}