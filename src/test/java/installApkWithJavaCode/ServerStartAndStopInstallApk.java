package installApkWithJavaCode;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.utility.PropertyReader;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ServerStartAndStopInstallApk {
	
	 AppiumDriverLocalService service; // global
	 public static String savePlatFormName;
		//public AppiumDriver driver;
		public static AndroidDriver<MobileElement> driver;
		
	//method
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
				          
		}
	
	
	public void stopServerhurray() {
		service.stop();
		System.out.println("Server stop hurray");
	}

	
	public void intallApk_switchCase() throws Exception {
		     
		String savePlatformName  = PropertyReader.getConfigProperty("choosePlatformName"); // check config stg  
		
		  switch(savePlatformName) {
		  	case"emulator":
		  	{
		  	File apkPath=new File(System.getProperty("user.dir")+"//resource//ResumeBuilder.apk"); // working
		  		//File apkPath=new File(System.getProperty("user.dir")+"//resource//Android.SauceLabs.Mobile.Sample.app.2.2.1.apk"); // working
		          // File apkPath=new File(System.getProperty("user.dir")+"//resource//ApiDemos-debug.apk"); // working
		           //File apkPath=new File(System.getProperty("user.dir")+"//resource//General-Store.apk"); //working
		         // File apkPath=new File(PropertyReader.getConfigProperty("swagApk"));   //not working properry 
				     DesiredCapabilities caps=new DesiredCapabilities();
				                     caps.setCapability(MobileCapabilityType.DEVICE_NAME,"R58MC1RBNGY");
				                     caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
				                     
				                     caps.setCapability(MobileCapabilityType.APP,apkPath.getAbsolutePath());
				                     
				                     caps.setCapability(MobileCapabilityType.NO_RESET,true);
				                     caps.setCapability(MobileCapabilityType.FULL_RESET,false);
				                     // box caps kaun layjakur day ga appium ko -- androdriver kay construtor main 
				                     // kis server ko aur kya so we are pass two paramerter 
				                          URL urlsave=new URL("http://127.0.0.1:4723/wd/hub");// post method hain request kay leeay kis server pur 
				                     AndroidDriver<AndroidElement> driver=new AndroidDriver<>(urlsave,caps);
				                    System.out.println(" akp intall hurayyyyy");
				                     Thread.sleep(3000);
				                     
				 }// first case
		  	 break;
		  
		  	case"RealAndroid":
		     {
		    	//File apkPath=new File(System.getProperty("user.dir")+"//resource//Android.SauceLabs.Mobile.Sample.app.2.2.1.apk"); // working
		          // File apkPath=new File(System.getProperty("user.dir")+"//resource//ApiDemos-debug.apk"); // working
		           //File apkPath=new File(System.getProperty("user.dir")+"//resource//General-Store.apk"); //working
		    	 File apkPath=new File(System.getProperty("user.dir")+"//resource//General-Store.apk");
			     DesiredCapabilities caps=new DesiredCapabilities();
			                     caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy Note10");
			                     caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
			                     caps.setCapability("noReset", true);
			                     caps.setCapability("no",true);
			                     caps.setCapability(MobileCapabilityType.APP,apkPath.getAbsolutePath());
			                     
			                     // box caps kaun layjakur day ga appium ko -- androdriver kay construtor main 
			                     // kis server ko aur kya so we are pass two paramerter 
			                          URL urlsave=new URL("http://127.0.0.1:4723/wd/hub");// post method hain request kay leeay kis server pur 
			                     AndroidDriver<AndroidElement> driver=new AndroidDriver<>(urlsave,caps);
			                     
			                     System.out.println(" app lauche done huray ");
		    	  }
		     break;
		  	
		  	
		  	case"iossamulator":
		  		
		  	{
		  		
		  	}
		     break;
		     
		     
		  	case"ipgone":
		  	{
		  		
		  	}	
		  		

		     default:
		        	throw new Exception("invalid platform");  
		     
		     
		  	
		  }//  end switch
		
		}// end method
	
	
	
	// intall apk if else
	
	  public void intallApk_ifElse() throws MalformedURLException, InterruptedException {
		  String savePlatformName  = PropertyReader.getConfigProperty("choosePlatformName"); 
		  if(savePlatformName.equals("emulator")) {
			  
				File apkPath=new File(System.getProperty("user.dir")+"//resource//ResumeBuilder.apk"); // working
		  		//File apkPath=new File(System.getProperty("user.dir")+"//resource//Android.SauceLabs.Mobile.Sample.app.2.2.1.apk"); // working
		          // File apkPath=new File(System.getProperty("user.dir")+"//resource//ApiDemos-debug.apk"); // working
		           //File apkPath=new File(System.getProperty("user.dir")+"//resource//General-Store.apk"); //working
		         // File apkPath=new File(PropertyReader.getConfigProperty("swagApk"));   //not working properry 
				     DesiredCapabilities caps=new DesiredCapabilities();
				                     caps.setCapability(MobileCapabilityType.DEVICE_NAME,"R58MC1RBNGY");
				                     caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
				                     
				                     caps.setCapability(MobileCapabilityType.APP,apkPath.getAbsolutePath());
				                     
				                     caps.setCapability(MobileCapabilityType.NO_RESET,true);
				                     caps.setCapability(MobileCapabilityType.FULL_RESET,false);
				                     // box caps kaun layjakur day ga appium ko -- androdriver kay construtor main 
				                     // kis server ko aur kya so we are pass two paramerter 
				                          URL urlsave=new URL("http://127.0.0.1:4723/wd/hub");// post method hain request kay leeay kis server pur 
				                     AndroidDriver<AndroidElement> driver=new AndroidDriver<>(urlsave,caps);
				                    System.out.println(" akp intall hurayyyyy");
				                     Thread.sleep(3000);
				                     
			  
		  }
		  
		  else if(savePlatformName.equals("RealAndroid")) {
			//File apkPath=new File(System.getProperty("user.dir")+"//resource//Android.SauceLabs.Mobile.Sample.app.2.2.1.apk"); // working
	          // File apkPath=new File(System.getProperty("user.dir")+"//resource//ApiDemos-debug.apk"); // working
	           //File apkPath=new File(System.getProperty("user.dir")+"//resource//General-Store.apk"); //working
			  File apkPath=new File(System.getProperty("user.dir")+"//resource//General-Store.apk");
			     DesiredCapabilities caps=new DesiredCapabilities();
			                     caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy Note10");
			                     caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
			                     caps.setCapability("noReset", true);
			                     caps.setCapability("no",true);
			                     caps.setCapability(MobileCapabilityType.APP,apkPath.getAbsolutePath());
			                     
			                     // box caps kaun layjakur day ga appium ko -- androdriver kay construtor main 
			                     // kis server ko aur kya so we are pass two paramerter 
			                          URL urlsave=new URL("http://127.0.0.1:4723/wd/hub");// post method hain request kay leeay kis server pur 
			                     AndroidDriver<AndroidElement> driver=new AndroidDriver<>(urlsave,caps);
			                     
			                     System.out.println(" app lauche done huray ");
			  
		  }
		  
		  
		  
		  else if(savePlatformName.equals("iphone")) {
			  
		  }
		  
		  else if(savePlatformName.equals("simulatour")) {
			  
		  }
		  
	  }
	
	
}// end class
