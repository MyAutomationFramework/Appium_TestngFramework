package com.pages;


import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//here is three part ---- 
//xapth , webelement , 
//construtor 
//and relavent methods and validation method 


public class LoginPage extends com.genricMethod.GenricActionBase {
	 public AndroidDriver<MobileElement> driver;
	
	 @AndroidFindBy(accessibility="test-Username")
	 MobileElement userName;
	
	
	 @AndroidFindBy (accessibility = "test-Password") 
	 MobileElement  Password;
	
	
	 @AndroidFindBy (accessibility = "test-LOGIN") 
	 MobileElement Loginbutton;
	
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='PRODUCTS']")
	 MobileElement validateProductText;
	 
	 
	 // construtor if driver type android  ---- Androiud emulator and Androind device 
//	public  LoginPage(AndroidDriver<MobileElement> driver) {
//		PageFactory.initElements(new AppiumFieldDecorator(driver) ,this);
//	}
	
	 public  LoginPage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver) ,this);
	}
	  //username can come config or frature file se bhee aa sukta hain --here we need paramertzied method 
	public void enter_userName(String usernameTestData) {
		// sendText( userName,"Enter_UserName",usernameTestData);
		sendkeys(userName, "Enter_UserName", 5, usernameTestData);
		
	}
	
	
	public void enter_password(String passwordData) {
		sendText(Password,"Enter_Password", passwordData);
	}
	
    public void click_loginButton() {
    	click(Loginbutton,"Click_LoginButton");
    }
    
    
    public void validate_ProductTextDisplay() {
    	 validate_ElementDisplayed(validateProductText);
    }
    
    public void validate_expectProductText() {
    	validateExpect_Actual(validateProductText, "PRODUCTS");
    }
    
    
   
	
	
}
