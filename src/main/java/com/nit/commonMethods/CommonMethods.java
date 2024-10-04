package com.nit.commonMethods;

import static com.nit.utils.BaseClass.log;

import org.openqa.selenium.By;

import com.nit.elementUtils.ElementUtils;
public class CommonMethods {
	By logout=By.xpath("//span[contains(@class,'oxd-userdropdown-tab')]");
	By logout1=By.xpath("//a[text()='Logout']");
	
	public void logout() throws Exception{
		ElementUtils.cousmaizeclick(logout);
		ElementUtils.cousmaizeclick(logout1);
		System.out.println("logoutSuccessFully");               
		log.info("logout Successfull");
		
	}

}
