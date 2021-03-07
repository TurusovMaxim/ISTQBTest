package org.example.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Getting configurations for testing.
 */
public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;


    /*
     * Checks for the existence of the configuration file (conf.properties)
     * and writes properties.
     */
    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Returns values by the given key.
     *
     * @param key - the names of the variables
     *            from the configuration file
     *            (conf.properties).
     * @return - values of the variables
     *           from the configuration file
     *           (conf.properties).
     */
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
