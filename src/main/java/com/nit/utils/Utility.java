package com.nit.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utility extends BaseClass  {	
	public static String captureScreenShot(String imgName) {
		//add ytime stamp to imge name
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		   TakesScreenshot ts=(TakesScreenshot)driver;
		   File src=ts.getScreenshotAs(OutputType.FILE);
		   String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+imgName+"_"+timeStamp+".png";
		   File targetFile= new File(targetFilePath);
		   try {
		   FileUtils.copyFile(src, targetFile);
		   log.info("Capture The ScreenDShot");
		     }
		   catch(FileNotFoundException fne) {
			   fne.getMessage();
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   
		   return targetFilePath;
		   
	}
	public static String randomString() {
		String rondomString=RandomStringUtils.randomAlphabetic(5);
		return rondomString;
		
		
	}
}
