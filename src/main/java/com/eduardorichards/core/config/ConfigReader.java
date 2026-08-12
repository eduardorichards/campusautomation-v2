package com.eduardorichards.core.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")){
            if (input == null) {
                throw new RuntimeException("config.properties not found on classpath");
            }

            PROPERTIES.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    private static String get(String key) {
        String value = PROPERTIES.getProperty(key);

        if (value == null) {
            throw new RuntimeException("Missing key in config file: " + key);
        }

        return value;
    }

    public static String getBaseUrl() {
        return get("base.url");
    }

    public static String getBrowser() {
        return get("browser");
    }

    public static int getImplicitWaitSeconds() {
        return Integer.parseInt(get("implicit.wait.seconds"));
    }

    public static int getExplicitWaitSeconds() {
        return Integer.parseInt(get("explicit.wait.seconds"));
    }
}
