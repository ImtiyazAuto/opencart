package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCase.Test_base;

public class Extent_Reports implements ITestListener{
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	String report;
	
	
	public void onStart(ITestContext context) {
		String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		report="result"+timestamp+".html";
		spark=new ExtentSparkReporter(".\\test_Reports\\"+report);
		
		spark.config().setDocumentTitle("open cart");
		spark.config().setReportName("Automation test report");
		spark.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(spark);
		String os=context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("operatingsystem", os);
	  }

	 
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.PASS,result.getName()+"test passed");
		
		
	  }

	  
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName() +"failed mf");
		
		try {
			String path = Test_base.getScreenShot(result.getName());	
			test.addScreenCaptureFromPath(path);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	  }

	  
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,result.getName()+"skipped bro");
		
	  
	  }


	
	public void onFinish(ITestContext context) {
		extent.flush();
	  }
	}



