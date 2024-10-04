package com.nit.pages;

import org.openqa.selenium.By;

import com.nit.elementUtils.ElementUtils;
import com.nit.utils.Utility;
import static com.nit.utils.Utility.log;

public class PIMPage {
	By  pageconText=By.xpath("//h6[text()='PIM']");
	By btn_addEmployee=By.linkText("Add Employee");
	By txt_firstName=By.name("firstName");
	By txt_lastName=By.name("lastName");
	By btn_saveEmp=By.xpath("//button[@type='submit']");
	By text_con_savedEmp=By.xpath("//h6[text()='Personal Details']");
	
	public void verifiyPIMtext()throws Exception {
		if(ElementUtils.checkVisibility(pageconText)) {
			System.out.println("We are in PIM Module");
			log.info("we are in PiM Module");
		}
		else {
			System.out.println("We are not in PIM Module");
			log.info("we are not in Pim Module");
		}
	}
	
	public void AddEmpClick(String fn,String ln)throws Exception {
		//click on AddEemployee 
		clickAddEmployee();
		System.out.println("we are click on addemployee");
		log.info("We are click an Add Employee");
		//enetr the first Nmae
		fn=Utility.randomString();
		setFirstName(fn);
		System.out.println(fn);
		ln=Utility.randomString();
		setlastName(ln);
		System.out.println(ln);
		//enetr save Button
		save();	
	 }
	
public void conSavedEmp()throws Exception {
	if(ElementUtils.checkVisibility(text_con_savedEmp)) {
		System.out.println("emp saved Successfully");
		log.info("emp saved SuccessFully");
	}
	else {
		System.out.println("Emp not saved");
		log.info("emp Not Saved");
	}
	    
    }

	private void save()throws Exception {
		ElementUtils.cousmaizeclick(btn_saveEmp);
		
	}

	private void setlastName(String ln)throws Exception {
		ElementUtils.cousmaizeTxtBox(txt_lastName,ln );
		
	}

	private void setFirstName(String fn)throws Exception {
		ElementUtils.cousmaizeTxtBox(txt_firstName, fn);
		
	}

	private void clickAddEmployee()throws Exception {
		ElementUtils.cousmaizeclick(btn_addEmployee);
			
	}

}
