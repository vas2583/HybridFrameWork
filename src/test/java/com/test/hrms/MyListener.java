package com.test.hrms;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nit.utils.Utility;

public class MyListener extends TestListenerAdapter {
    //create the report with Time Stamp
	ExtentSparkReporter sparkReport;
	ExtentReports reporter;
	ExtentTest test;
	
	String report_Name;
	@Override
	public void onStart(ITestContext context) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		report_Name="test_report_"+timeStamp+".html";
		sparkReport=new ExtentSparkReporter("./reports\\"+report_Name);
		sparkReport.config().setReportName("HRMSReport");
		sparkReport.config().setDocumentTitle("HRMSReport");
		sparkReport.config().setTheme(Theme.DARK);
		
		reporter=new ExtentReports();
		 reporter.attachReporter(sparkReport);
		 reporter.setSystemInfo("Environment","QA");
		 String userName=System.getProperty("user.name");
		 reporter.setSystemInfo("TesterName",userName);
		 reporter.setSystemInfo("host","localHost");
		 reporter.setSystemInfo("os","windows");
		 String browser=context.getCurrentXmlTest().getParameter("browser");
		 List<String> includeGroups=context.getCurrentXmlTest().getIncludedGroups();
		 if(!includeGroups.isEmpty())
			 reporter.setSystemInfo("Groups",includeGroups.toString());
	    }
	@Override
	public void onTestStart(ITestResult result) {
	
		test=reporter.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test=reporter.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+" got Successfully executed");
	  }

	@Override
	public void onTestFailure(ITestResult result) {
		test=reporter.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName()+" test Got Failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		try {
			String imgPath=Utility.captureScreenShot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=reporter.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,result.getName()+" test Got Skiped");
	}

	


	@Override
	public void onFinish(ITestContext context) {
		reporter.flush();
		
		
		String extent_ReportPath=System.getProperty("user.dir")+"\\reports\\"+report_Name;
		File extent=new File(extent_ReportPath);
		try {
			Desktop.getDesktop().browse(extent.toURI());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


}
