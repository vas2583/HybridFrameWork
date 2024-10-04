package com.nit.pages;

import org.openqa.selenium.By;

import com.nit.elementUtils.ElementUtils;
import com.nit.utils.Utility;
import static com.nit.utils.Utility.log;

public class LoginPage {
  //locate Elements
	By img_logo=By.xpath("//img[@alt='company-branding']");
	By txt_userName=By.name("username");
	By txt_password=By.name("password");
	By btn_login=By.xpath("//button[@type='submit']");
	
	public void verifyTheLogo() throws Exception {
		//find Element
		//isDispaly or not
		if(ElementUtils.checkVisibility(img_logo)) {
			System.out.println("we are in the Login Page");
		    log.info("we are in the Login Page");
		}
		else {
		  System.out.println("We are not in login page");
		   log.info("we are not in the login page");
		}
	  }
	public void loginFunctionality(String usn,String pass)throws Exception {
		//enter the User name 
		setUserName(usn);
		setPassword(pass);
		clickButton();
		
	}
	private void clickButton()throws Exception {
		ElementUtils.cousmaizeclick(btn_login);
		
	}
	private void setPassword(String pass)throws Exception {
	   
	   ElementUtils.cousmaizeTxtBox(txt_password, pass);
		
	}
	private void setUserName(String usn)throws Exception {
		ElementUtils.cousmaizeTxtBox(txt_userName, usn);
		
		
	}
	
		

	}


