package com.amazon.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataUtil {

	Properties prop;
	public Properties init() throws IOException
	{
		prop=new Properties();
		File file = new File(System.getProperty("user.dir")+"//src//main//resources//config.properties");
		FileInputStream io=new FileInputStream(file);
		prop.load(io);
		return prop;
	}
}
