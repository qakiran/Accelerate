package com.fiserv.framework.utility.files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.testng.Assert;

/**
 * 
 * @author dhiraj.bendale
 *
 */
public class PropertiesFiles {

	/**
	 * @author dhiraj.bendale
	 * @param filePath
	 * @return
	 */
	public Map<String, String> readProperties(String filePath) {
		Map<String, String> propData;
		propData = new HashMap<>();
		InputStream input = null;
		try {
			input = PropertiesFiles.class.getClassLoader().getResourceAsStream(filePath);
			if (input == null) {
				Assert.fail("Properties file not found at " + filePath + " location.");
			}
			Properties properties = new Properties();
			properties.load(input);

			Enumeration<Object> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				if (value.isEmpty())
					throw new NullPointerException("Value is missing");
				propData.put(key.trim(), value.trim());
			}
		} catch (FileNotFoundException e) {
			Assert.fail("Properties file not found." + e.getMessage());

		} catch (IOException e) {
			Assert.fail("Error while reading properties file not found..");

		} catch (Exception e) {
			Assert.fail("Error while reading properties." + e.getMessage());
		}
		return propData;
	}
}
