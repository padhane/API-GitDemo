package UtilityLayer;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesClass {
	
	public static String getProperties(String Key) throws Exception
	{
	String path = System.getProperty("user.dir")+"\\src\\test\\resource\\ConfigLayer\\config.properties";
	
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(path);
	prop.load(fis);
	
   return prop.getProperty(Key);
}
}