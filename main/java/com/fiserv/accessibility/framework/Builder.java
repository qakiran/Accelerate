package com.fiserv.accessibility.framework;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fiserv.accessibility.framework.AxeRuntimeException;

@SuppressWarnings("rawtypes")
public class Builder {
	private WebDriver driver;
	private URL script;
	private List<String> includes = new ArrayList<>();
	private List<String> excludes = new ArrayList<>();
	private String options = "{}";
	private Boolean skipFrames = false;
	private int timeout = 30;
	private AccessibilityUtils accessibilityUtils = new AccessibilityUtils();
	private static Logger logger = Logger.getLogger(Builder.class);

	/**
	 * Initializes the Builder class to chain configuration before analyzing
	 * pages.
	 * 
	 * @param driver
	 *            An initialized WebDriver
	 * @param script
	 *            The javascript URL of aXe
	 * @author Vimal.Tyagi
	 */
	public Builder(WebDriver driver, URL script) {
		this.driver = driver;
		this.script = script;
	}

	/**
	 * analyze violations against the page.
	 * 
	 * @return An aXe results document
	 * @author Vimal.Tyagi
	 */
	public JSONObject analyze() {
		String axeContext;
		String axeOptions;

		if (includes.size() > 1 || excludes.isEmpty()) {
			String includesJoined = "['" + StringUtils.join(includes, "'],['") + "']";
			String excludesJoined = excludes.isEmpty() ? "" : "['" + StringUtils.join(excludes, "'],['") + "']";

			axeContext = "document";
			axeOptions = String.format("{ include: [%s], exclude: [%s] }", includesJoined, excludesJoined);
		} else if (includes.size() == 1) {
			axeContext = String.format("'%s'", this.includes.get(0).replace("'", ""));
			axeOptions = options;
		} else {
			axeContext = "document";
			axeOptions = options;
		}

		String snippet = getSnippet(axeContext, axeOptions);
		return execute(snippet);
	}

	private String getSnippet(String context, String options) {
		return String.format("var callback = arguments[arguments.length - 1];" + "var context = %s;"
				+ "var options = %s;" + "var result = { error: '', results: null };"
				+ "axe.run(context, options, function (err, res) {" + "  if (err) {" + "    result.error = err.message;"
				+ "  } else {" + "    result.results = res;" + "  }" + "  callback(result);" + "});", context, options);
	}

	/**
	 * analyze violations against a specific WebElement.
	 * 
	 * @param context
	 *            A WebElement to test
	 * @return An results document
	 * @author Shivang.Ahuja
	 */
	public JSONObject analyze(final WebElement context) {
		String snippet = getSnippet("arguments[0]", options);
		return execute(snippet, context);
	}

	private JSONObject execute(final String command, final Object... args) {
		try {
			accessibilityUtils.inject(this.driver, this.script, this.skipFrames);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		this.driver.manage().timeouts().setScriptTimeout(this.timeout, TimeUnit.SECONDS);

		Object response = ((JavascriptExecutor) this.driver).executeAsyncScript(command, args);

		JSONObject result = new JSONObject((Map) response);
		String error = result.getString("error");
		if (error != null && !error.isEmpty()) {
			throw new AxeRuntimeException(error);
		}

		return result.getJSONObject("results");
	}

}
