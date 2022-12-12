package com.TestcaseExcution;

import org.testng.annotations.Test;

import com.genricMethod.GenricActionBase;
import com.pages.LoginPage;
import com.utility.PropertyReader;

public class LoginExcutionSecondWay extends GenricActionBase {
	public LoginPage obj;
	
	@Test(priority = 1)
	public void startServer() {
		statrtServerhurray();
	}
	
	@Test(priority = 2)
	public void lauchApk() throws Exception {
		launchApk_switchCase();
	}
	@Test(priority =3)
	public void CheckLogin_ValidCredentials() throws Exception {
		 obj=new LoginPage(driver);// driver construtor ko pass hoga
		 obj.enter_userName(PropertyReader.getDataProperty("validUsername"));
		 obj.enter_password(PropertyReader.getDataProperty("validPassword"));
		 obj.click_loginButton();
		 obj.validate_expectProductText();
		 obj.validate_ProductTextDisplay();
		 
	}
	
	@Test(priority =4 )
	public void serverStoped() {
		stopServer();
	}

}
