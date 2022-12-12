package com.genricMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.extentReport.ExtentObject;
import com.extentReport.Listeners;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
////https://testautomationu.applitools.com/appium-java-tutorial/chapter7.3.html
public class GenricActionBase extends StartServerStopAndLaunchApk{
	
	public static final long WAIT=10;
	public  static SoftAssert  soft ; 
	//public AndroidDriver<MobileElement> driver;
	
		public void waitForVisibility(MobileElement element) {
			 WebDriverWait wait_WithElement=new WebDriverWait(driver,WAIT); 
				 wait_WithElement.until(ExpectedConditions.visibilityOf(element));
			 }
		
		
	
		
		public void clear(MobileElement element) {
			waitForVisibility(element);
			element.clear();
		}

		public void click(MobileElement element,String TextFieldName) {
			waitForVisibility(element);
			element.click();
			Listeners.test.log(Status.PASS, TextFieldName);
		}
	// talk to trat method 
		public static void sendkeys(WebElement element,String TextFieldName, int timeout, String testData) {
			WebElement element_withWait = new WebDriverWait(driver, timeout)
					.until(ExpectedConditions.visibilityOf(element));
			element_withWait.sendKeys(testData);
			Listeners.test.log(Status.PASS,TextFieldName+"--->"+"*** Test Data =" +testData);
		}
		
		//*********************** i used this method ******************************************************
		public void sendText(MobileElement element , String TextFieldName, String testData) {
		
		 try
	 		{waitForVisibility(element);
			 element.sendKeys(testData);
			//Listeners.test.log(Status.INFO,"Text Field is ="+ TextFieldName+" ******   Test Data = "+ testData);
			Listeners.test.log(Status.PASS,TextFieldName+"--->"+"*** Test Data =" +testData);
				}
	 		catch (Exception e) {
	 			
	 		e.printStackTrace();
	Listeners.test.log(Status.FAIL,"Text Field Label--->"+ TextFieldName+" Test Data is --->"+ testData+" Step Failed");
	 		}
		 
		 }
	//***********************************************************************
		public String getScreenshotPath( String testCaseName ,AppiumDriver driver) throws IOException {
			 
			File source = driver.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir")+"//reports"+testCaseName+".png";// where you want store 
			       FileUtils.copyFile(source, new File(destinationFile));
			       return destinationFile;
		}
		

		// ********Validate Methods********
		
		 public void SoftAssertion() {
		    soft  = new SoftAssert();
	 }
	 
	 public  void validate_ElementDisplayed(MobileElement element) {
		 		waitForVisibility(element);  
		 	boolean   returnTrueOrFalse	=element.isDisplayed();
		 SoftAssert	soft  = new SoftAssert();
		 		soft.assertTrue(returnTrueOrFalse);
		 	     	soft.assertAll();
		Listeners.test.log(Status.PASS, " Expected  Element-*** "+ element.getText()+" ***  is Displayed " + "  -- Validation value ---->"+returnTrueOrFalse);
	 }
	
		
		public void validateExpect_Actual(MobileElement Element,String expectElement) {
					waitForVisibility(Element);  
				String actualElmentText	=Element.getText();
				SoftAssert	soft  = new SoftAssert();
				soft.assertEquals(actualElmentText, expectElement);
				soft.assertAll();
			Listeners.test.log(Status.PASS, "Expected Element= "+ expectElement +"    Actual Element = "+actualElmentText);
		}
	 
		
}// end class 
