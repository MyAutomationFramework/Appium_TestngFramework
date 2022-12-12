package com.genricMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.extentReport.Listeners;
import com.utility.PropertyReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class StartServerStopAndLaunchApk {
	
	
	
	AppiumDriverLocalService service; // global
	 public static String savePlatFormName;
		public  static AndroidDriver<MobileElement> driver;
		
		//public static AndroidDriver<MobileElement> driver;
	//@Test(priority=1)
	public  void statrtServerhurray() {
		
		// start server 
				 String NodeExePath="C:\\Program Files\\nodejs\\node.exe";
				 String NodeJsMainPath ="C:\\Users\\Shaily's Pc\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
				          service=AppiumDriverLocalService
				        		                   .buildService(new AppiumServiceBuilder()
				        		                   .usingDriverExecutable(new File(NodeExePath))
			       		                   .withAppiumJS(new File(NodeJsMainPath))
			       		                   .withLogFile(new File("C:\\Users\\Shaily's Pc\\OneDrive\\Desktop\\appiumlog\\new 1.txt"))); // log genrate
			      		           service.start();          
				           System.out.println(" server start hurray....");	
				          Listeners.test.log(Status.PASS," Hurray  Server Started Successfully") ;  
				           
		}
	
	//@Test(priority = 3)
	public void stopServer() {
		service.stop();
		System.out.println("stop server hurray.....");
		Listeners.test.log(Status.PASS," Server Stoped Successfully" );
	}
	
	// useing switch case
	//@Test(priority = 2)
	public  void launchApk_switchCase() throws Exception {
		 String save=PropertyReader.getConfigProperty("choosePlatformName");
		
		     switch(save) {
		     case"emulator":
		     {   // emulator information
		    	 			DesiredCapabilities caps=new DesiredCapabilities();
				     		caps.setCapability(MobileCapabilityType.DEVICE_NAME,PropertyReader.getConfigProperty("Device_Name"));
				   			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,PropertyReader.getConfigProperty("androidAutomationName"));
				   			caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME,PropertyReader.getConfigProperty("PlatformName"));
				   			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,PropertyReader.getConfigProperty("PlatformVersion"));
			// app package activity	   					
				   			caps.setCapability("appPackage",PropertyReader.getConfigProperty("androidAppPackage"));
				   			caps.setCapability("appActivity",PropertyReader.getConfigProperty("androidAppActivity"));
				   			//caps.setCapability("autoGrantPermissions","true");
			// incialize driver
				   			System.out.println(" app or apk launch success");
					driver	 =new AndroidDriver<MobileElement>(new URL(PropertyReader.getConfigProperty("appiumURL")),caps);
				   
					Listeners.test.log(Status.PASS ," Hurray Apk Launched Successfully");
		     }
		     break;
		     
		     case"RealAndroid":
		     {
		    	 DesiredCapabilities cap1 = new DesiredCapabilities();
	  				cap1.setCapability("BROWSER_NAME",PropertyReader.getConfigProperty("BROWSERNAME"));
	  				cap1.setCapability("automationName",PropertyReader.getConfigProperty("automationName"));
	  				cap1.setCapability("VERSION",PropertyReader.getConfigProperty("VERSION"));
	  				cap1.setCapability("deviceName",PropertyReader.getConfigProperty("deviceName"));
	  				cap1.setCapability("platformName",PropertyReader.getConfigProperty("platformName"));
	  				cap1.setCapability("appPackage",PropertyReader.getConfigProperty("androidAppPackage"));
	  				cap1.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,PropertyReader.getConfigProperty("androidAppActivity"));
	  				AndroidDriver<AndroidElement> 	 driver1 = new AndroidDriver<>(new URL(PropertyReader.getConfigProperty("appiumURL")),cap1);
	  				System.out.println(" app or apk launch successssss");
	  				//Listeners.test.log(Status.PASS," Hurray Apk Launched Successfully");
		     }
		     break;
		     
		     case"simulatour":
		     {
		    	
		    	 
		     }
		     break;
		    
		     
		     case"Iphone":
		     {
		    	
		    	 
		     }
		     break;
		     
		     
		     
		     
	
		     default:
		        	throw new Exception("invalid platform");  
		     
		     }
	}


	// useing if else  saME RESUL AS SWITCH CASE
	
	
	public  void launchApk_IFElse() throws MalformedURLException, InterruptedException {
			DesiredCapabilities	cap= new DesiredCapabilities();
			savePlatFormName =PropertyReader.getConfigProperty("choosePlatformName");
 			System.out.println(savePlatFormName);
 			
 			if(savePlatFormName.equals("emulator")) {
 			cap.setCapability(MobileCapabilityType.DEVICE_NAME,PropertyReader.getConfigProperty("Device_Name"));
  			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,PropertyReader.getConfigProperty("androidAutomationName"));
  			cap.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME,PropertyReader.getConfigProperty("PlatformName"));
  			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,PropertyReader.getConfigProperty("PlatformVersion"));
//app package activity	   					
			cap.setCapability("appPackage",PropertyReader.getConfigProperty("androidAppPackage"));
			cap.setCapability("appActivity",PropertyReader.getConfigProperty("androidAppActivity"));	   	 
//incialize driver 		 
				 driver = new AndroidDriver<>(new URL(PropertyReader.getConfigProperty("appiumURL")),cap);
				System.out.println(" app or apk launch succefully......");
				System.out.println("driver kya kya laker ja raha hain "+driver);
				Thread.sleep(2000);
				}	
 			
 		else if(savePlatFormName.equals("RealAndroid")) {
 			
 				DesiredCapabilities cap1 = new DesiredCapabilities();
 				cap1.setCapability("BROWSER_NAME",PropertyReader.getConfigProperty("BROWSERNAME"));
 				cap1.setCapability("automationName",PropertyReader.getConfigProperty("automationName"));
 				cap1.setCapability("VERSION",PropertyReader.getConfigProperty("VERSION"));
 				cap1.setCapability("deviceName",PropertyReader.getConfigProperty("deviceName"));
 				cap1.setCapability("platformName",PropertyReader.getConfigProperty("platformName"));
 				cap1.setCapability("appPackage",PropertyReader.getConfigProperty("androidAppPackage"));
 				cap1.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,PropertyReader.getConfigProperty("androidAppActivity"));
 				AndroidDriver<AndroidElement> 	 driver = new AndroidDriver<>(new URL(PropertyReader.getConfigProperty("appiumURL")),cap1);
 				System.out.println(" app or apk launch success");
 				
 				System.out.println(" app or apk launch successdddddd"+ driver);
				System.out.println("gggggggggddddd------->"+driver);
					
 			}	
 		
 		else if(savePlatFormName.equals("ios")) {
 			
 		}
 		
 		else if(savePlatFormName.equals("Iphone")) {
 			
 		}	
 			}//end method
	
	
	
	
	
	
	
	
	
	
	

}
