package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	private static Properties envProperties_value=new Properties();  // store env=prepod 
	  private static Properties envirment_configStrore=new Properties(); // store url depend on env value  like prepod="httpmahakal.com"
	  private static Properties envirment_dataStrore=new Properties(); 
	 static {
		 
		   try {                  // read env value 
			FileInputStream read_env=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//com//properties//env.properties");   						
			                   envProperties_value.load(read_env);  // call load methos help with property object 																																																				 
			                
			            // config kay leeay  concatinate prepod-config.properties or stg-config.properties depending on env ----- read url   
 FileInputStream read_envirmentValue=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//com//properties//"+envProperties_value.getProperty("env")+"-config.properties");                 
			               envirment_configStrore.load(read_envirmentValue);																																														// stg or prepod yaja env key kee value maang raha hain prop or stg aayga aut -config.properties main jakur jo jo key hohee oona ka value read karayga 
		
			               // for  read data value depend on envirement -- we will do concatinate  jo env main hoha vahee data property main jayga  stg or prepod data       
			    FileInputStream       read_dataProperties  =new FileInputStream(System.getProperty("user.dir")+"//src//test//java//com//properties//"+envProperties_value.getProperty("env")+"-data.properties");
			                                       envirment_dataStrore.load(read_dataProperties);
			                 	               
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }
	
public static String getConfigProperty(String key) {
	  return envirment_configStrore.getProperty(key); 
}

public static String getDataProperty(String key) {
	  return envirment_dataStrore.getProperty(key); 
}


}
