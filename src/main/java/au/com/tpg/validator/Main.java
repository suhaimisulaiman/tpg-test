package au.com.tpg.validator;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import au.com.tpg.validator.Main;

public class Main {

	public static void main(String args[]){
		ClassLoader classLoader = Main.class.getClassLoader();
	    File file = new File(classLoader.getResource("ipaddress.txt").getFile());
	    
	    try {
			List<String> ipAddressList = FileUtils.readLines(file);
			IPValidationRegex validator = new IPValidationRegex();
			
			for(String ipAddress: ipAddressList){
				if(!validator.validate(ipAddress)){
					System.out.println(ipAddress + " is invalid!");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
