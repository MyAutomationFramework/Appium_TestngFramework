
package com.extentReport;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utility.PropertyReader;

public class ExtentObject {
	// udemy rahul shetty 
	 public static ExtentReports extent  ;   // yeh return ho raha hain . static so i can use in send key method 

	public static ExtentReports getReporterObject() {
		           String     Devicename      =PropertyReader.getConfigProperty("setReportName");
		    String reportGenratePath=System.getProperty("user.dir")+"\\reports\\extentReport.html";
		    // create object ---- ExtentSparker class for set config
		ExtentSparkReporter reporter =new ExtentSparkReporter(reportGenratePath);  
		 																					
		// yaha report bana   // oss report main kya kya config hoga   // oss report main kya kya config hoga                                                                                   // vo reporter box main pack kiya hain 
		            reporter.config().setReportName(Devicename);
		            reporter.config().setDocumentTitle(" SwangLab Automation Test Results");
		            reporter.config().setTheme(Theme.DARK);
		            //reporter.config().setTheme(Theme.STANDARD);
		            reporter.config().setTimeStampFormat("EEEE, MMMM dd, YYYY, hh:mm a '('zzz')'");
		            
		            // create object for Extent report 
		                 extent   =new ExtentReports();
		                   extent.attachReporter(reporter);// oss box ko ess emtpty box main bhur do , saree information yaha aa jaygee 
		                   	extent.setSystemInfo("Tested By ", "Shaily Jaiswal");
		                   	extent.setSystemInfo("Device Name", PropertyReader.getConfigProperty("DeviceName"));
		                   	return extent;
		
	}
	
	}
