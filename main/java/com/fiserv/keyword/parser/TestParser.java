package com.fiserv.keyword.parser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import org.apache.log4j.Logger;
import org.testng.Assert;

import com.fiserv.framework.Initialize;
import com.fiserv.framework.constants.KeywordConstants;
import com.fiserv.keyword.Keywords;

/**
 * 
 * @author dhiraj.bendale
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class TestParser {

	static Initialize init = Initialize.getInstance();
	private static Logger logger = Logger.getLogger(TestParser.class);
	private KeywordConstants keywordConstant = new KeywordConstants();

	/**
	 *
	 * @author dhiraj.bendale
	 * @param packageName
	 */
	public void parseMethods(String packageName) {
		String className = "";
		String keyword = "";
		String methodName = "";
		List<String> keyWordInfo = new ArrayList<>();
		logger.debug("Reading classes from pakage " + packageName);
		try {
			Class[] classes = getClasses(packageName);
			for (Class<Class> clas : classes) {
				className = clas.getCanonicalName();
				logger.debug("Collecting methods from class " + className);
				Class myclass = Class.forName(className);
				Method[] methods = myclass.getMethods();
				for (Method method : methods) {
					keyWordInfo = new ArrayList<>();
					Keywords anno = method.getAnnotation(Keywords.class);
					// Verify add mandate field for keyword annoation
					if (anno != null && !anno.description().isEmpty() && !anno.author().isEmpty()) {
						logger.debug(anno.description().trim() + " is selected.");
						keyword = anno.description().trim();
						methodName = method.getName().trim();
						keyWordInfo.add(0, className);
						keyWordInfo.add(1, methodName);
						keyWordInfo.add(2, anno.description());
						keyWordInfo.add(3, anno.category());
						keyWordInfo.add(4, anno.author());
						keywordConstant.updateTestCaseParseData(keyword, keyWordInfo);
						logger.debug(methodName + " is method name.");
					}
				}
			}
		} catch (Exception e) {
			logger.error("Exception :- " + e);
			Assert.fail("Error while collection Keywords .");
		}
	}

	/**
	 * @author dhiraj.bendale
	 * @param packageName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class> classes = new ArrayList<>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes.toArray(new Class[classes.size()]);
	}

	/**
	 * Recursive method used to find all classes in a given directory and
	 * subdirs.
	 *
	 * @param directory
	 *            The base directory
	 * @param packageName
	 *            The package name for classes found inside the base directory
	 * @return The classes
	 * @throws ClassNotFoundException
	 */
	private List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
		List<Class> classes = new ArrayList<>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(
						Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
			}
		}
		return classes;
	}
}
