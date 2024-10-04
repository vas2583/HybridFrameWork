package com.nit.pages;

import org.openqa.selenium.By;

import com.nit.elementUtils.ElementUtils;
import static com.nit.utils.Utility.log;

public class DashBoardPage {
	By text_dispalyed=By.xpath("//h6[text()='Dashboard']");
	By pim_Module=By.xpath("//span[text()='PIM']");
	//check is Displayed or not
	  public void verify_textDispalyed()throws Exception {
		if(ElementUtils.checkVisibility(text_dispalyed)) {
			System.out.println("we are SuccesfULLY lOGIN");
			log.info("We are successFully Login");
		}
		else
			System.out.println("we are Not SuccessfullNot login");
		  log.info("We are not SuccessFullLogin");
	  }
	  public void gotoPIM()throws Exception {
		 ElementUtils.cousmaizeclick(pim_Module); 
	  }
	  

}
