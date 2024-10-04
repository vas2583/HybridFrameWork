package com.test.hrms;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nit.commonMethods.CommonMethods;
import com.nit.pages.DashBoardPage;
import com.nit.pages.LoginPage;
import com.nit.utils.BaseClass;
import com.nit.utils.Utility;

public class LoginTest extends BaseClass {
	
	@Test(groups={"sanity","master"})
	public  void login() throws Exception{
		LoginPage login=new LoginPage();
		DashBoardPage dash=new DashBoardPage();
		login.verifyTheLogo();
		login.loginFunctionality(p.getProperty("username"),p.getProperty("password"));
		dash.verify_textDispalyed();
	 }
	
	@AfterMethod(groups={"sanity","Regeression","master"})
	public void logout() throws Exception {
		CommonMethods cm=new CommonMethods();
		cm.logout();	
	  }
	
	
	
    
}
