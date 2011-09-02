package com.scommon.util.properties;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertiesHelper {
	private static Properties properties = null;
	private Log log = LogFactory.getLog(PropertiesHelper.class);

	public static Properties getInstance(String propertiesName) {
		if(null == properties){
			properties = new Properties();
			try {
				properties.load(Thread.currentThread().getContextClassLoader()
						.getResourceAsStream(propertiesName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
}
