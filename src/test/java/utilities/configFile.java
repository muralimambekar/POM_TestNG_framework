package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configFile {
	
	public static String getVal(String propKey) throws IOException {
		Properties prop= new Properties();
		FileInputStream fis=new FileInputStream("./data.properties");
		prop.load(fis);
		return prop.getProperty(propKey);
	}

}
