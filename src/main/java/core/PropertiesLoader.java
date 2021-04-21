package core;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    protected Properties properties;

    public PropertiesLoader() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PropertiesLoader(String fileName) {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public String getBrowserName() {
        return properties.getProperty("browser");
    }
}
