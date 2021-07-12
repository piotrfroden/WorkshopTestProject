package subscriptionsplans.utils;

public class Utils {
    public String url;
    ConfigFileReader configFileReader;

    public Utils() throws Exception {
        configFileReader = new ConfigFileReader();
    }

    public void setUpConfiguration() {
        url = configFileReader.getUrl();
    }
}
