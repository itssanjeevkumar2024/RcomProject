package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigureDataFile {
	
public Properties pro;
	public ConfigureDataFile() throws IOException {
		String path=System.getProperty("user.dir")+"\\Config\\data.properties";
		
		File fl=new File(path);
		FileInputStream finpt=new FileInputStream(fl);
		pro=new Properties();
		
		pro.load(finpt);
		
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	public String getTestURL() {
		return pro.getProperty("qaUrl");
	}
	
	public String getENSURL() {
		return pro.getProperty("ENSURL");
	}
	public String getENSSignInEmail() {
		return pro.getProperty("ENSEmail");
	}
	public String getENSSignInPassword() {
		return pro.getProperty("Password");
	}
	public String getENSSearchEmail() {
		return pro.getProperty("ENSSearchEmail");
	}
	public String ServiceableAddress() {
		return pro.getProperty("Address");
	}

}
