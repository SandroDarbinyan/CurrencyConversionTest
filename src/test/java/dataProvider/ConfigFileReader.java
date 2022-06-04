package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String PROPERTY_FILE_PATH = "src/test/resources/config.properties";

    public ConfigFileReader(){
        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        return driverPath;
    }

    public String getUrl() {
        String url = properties.getProperty("url");
        return url;
    }
}
