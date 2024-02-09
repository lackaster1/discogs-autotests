package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDriverPath() {
        return properties.getProperty("browser.driver.path");
    }

    public String getBrowserProperty() {
        return properties.getProperty("browser.chrome.property");
    }
}
