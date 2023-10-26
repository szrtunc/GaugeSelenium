package driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static{
        String dosyaYolu="src/test/java/configuration.properties";

        try {
            FileInputStream fis= new FileInputStream(dosyaYolu);
            //fis tanimladigimiz configuration.properties dosya yolunu okudu.
            properties=new Properties();
            properties.load(fis);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        /*test methodundan yolladıgımız string key degerini alıp
        Properties classıdan getProperty() methodunu kullanarak
        bu key e ait value e bize getirdi.
        */
        return  properties.getProperty(key);
    }
    public static String[] getPropertyArray(String key) {
        String property = properties.getProperty(key);
        if (property != null) {
            return property.split(",");
        }
        return new String[0];
    }


}
