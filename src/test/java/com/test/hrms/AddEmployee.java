package com.test.hrms;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nit.commonMethods.CommonMethods;
import com.nit.pages.DashBoardPage;
import com.nit.pages.LoginPage;
import com.nit.pages.PIMPage;
import com.nit.utils.BaseClass;
import com.nit.utils.Utility;

public class AddEmployee extends BaseClass{
	
	
	@Test(groups={"Regeression","master"})
	public void addEmp() throws Exception {
		
		//objects of Lpages
		LoginPage login=new LoginPage();
		DashBoardPage dash=new DashBoardPage();
		PIMPage pim=new PIMPage();
		//verify logo
		login.verifyTheLogo();
		//login
		login.loginFunctionality(p.getProperty("username"),p.getProperty("password"));
		//login verify
		dash.verify_textDispalyed();
		//go to pim
		dash.gotoPIM();
		//verify the pim page welcomeText
		pim.verifiyPIMtext();
        //perform AddEmplolyee action and click on save Button
		 pim.AddEmpClick(Utility.randomString(),Utility.randomString());
		//verify the emp saved or not
		pim.conSavedEmp();
		Thread.sleep(2000);
		
	}
	@AfterMethod(groups={"sanity","Regeression","master"})
	public void logout()throws Exception {
		CommonMethods cm=new CommonMethods();
		 cm.logout();
		
	}
	

}
