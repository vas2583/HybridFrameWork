package com.nit.elementUtils;

import static com.nit.utils.Utility.driver;
import static com.nit.utils.Utility.log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class ElementUtils {
	static WebElement element=null;
	public static boolean checkVisibility(By locator)throws Exception {
		//findELement 
		boolean res=false;
		 try {
			 res=element(locator).isDisplayed();
			 System.out.println("we finding Dispaly Locatro");
			 log.info("We finding Display Locator");
		 }
		 catch(Exception e){
			 System.out.println("We are not finding Display Locator");
			 log.info("we are not finding Display Locator");
		 }
		 return res;
		//isDispalayed Method
		
	}

	public static WebElement element(By locator)throws Exception {
		for(int i=1;i<=10;i++) {
	    try {
	    element=driver.findElement(locator);
	     break;
	      }
	    catch(Exception e) {
	    	Thread.sleep(2000);
	      }
		}
	    return element;
		
	  }
	public static void cousmaizeTxtBox(By locator,String value) throws Exception {
		element(locator).sendKeys(value);
	}
	public static void cousmaizeclick(By locator) throws Exception {
		element(locator).click();
	}

	}
