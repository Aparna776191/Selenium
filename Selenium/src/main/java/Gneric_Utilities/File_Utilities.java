package Gneric_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utilities {

    private Properties pro;

    // Constructor to load properties file
    public File_Utilities() {
        String path = "./src/test/resources/Config.properties";
        pro = new Properties();
        try (FileInputStream fis = new FileInputStream(path)) {
            pro.load(fis);
        } catch (IOException e) {
            System.err.println("❌ Unable to load properties file: " + path);
            e.printStackTrace();
        }
    }

    // Method to return value for a given key
    public String getProperty(String key) {
        String value = pro.getProperty(key);
        if (value == null) {
            System.err.println("⚠ Key not found: " + key);
        }
        return value;
    }
}
