package br.com.koala.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KoalaProperties {

	private static final String FILE_NAME = "config.properties";
	private final static Logger LOGGER = LoggerFactory.getLogger(KoalaProperties.class);
	
	private static Properties properties = new Properties();

	static {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		try (InputStream resourceStream = loader.getResourceAsStream(FILE_NAME)) {
			properties.load(resourceStream);
		} catch (IOException e) {
			LOGGER.error("Could not load properties from " + FILE_NAME, e);
		}
	}

	public static String get(String key) {
		return properties.getProperty(key).toString();
	}
	
	
}
