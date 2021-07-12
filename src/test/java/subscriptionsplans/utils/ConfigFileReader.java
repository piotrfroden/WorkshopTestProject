package subscriptionsplans.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReader {
    private final Properties properties;

    public ConfigFileReader() throws Exception{
        BufferedReader reader;
        String propertyFilePath = "./configs/configuration.properties";
        reader = new BufferedReader(new FileReader(propertyFilePath));
        properties = new Properties();
        properties.load(reader);
        reader.close();
    }

    public String getUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("Nie znaleziono pola - nazwa użytkownika w pliku konfiguracyjnym");
    }
}
