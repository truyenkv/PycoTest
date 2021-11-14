package pyco.dataProvider;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader innstance;
    Properties properties = new Properties();

    private PropertiesReader(){}

    public static PropertiesReader getInstance(){
        if(innstance==null){
            innstance = new PropertiesReader();
        }
        return innstance;
    }

    public String getValue(String key){
        try {
            properties.load(new FileReader("src/main/resources/env.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
