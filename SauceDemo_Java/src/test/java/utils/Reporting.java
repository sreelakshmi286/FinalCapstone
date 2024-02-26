package utils;


import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestScript.SauceDemo;

public class Reporting extends SauceDemo implements ITestListener {
	
	public ExtentHtmlReporter htmlReport;
	public ExtentReports xReports;
	public ExtentTest xTest;

	public void onStart(ITestContext testContext) {
		String dateStamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Automation-Report" + dateStamp + ".html";
		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/" + repName);
		htmlReport.config().setDocumentTitle("Test Excution Summary Report");
		htmlReport.config().setReportName("Functional Testing");
		htmlReport.config().setTheme(Theme.DARK);
		xReports = new ExtentReports();
		xReports.attachReporter(htmlReport);
		xReports.setSystemInfo("QA Name", "Prasad");
		xReports.setSystemInfo("OS", "WIN10");
		xReports.setSystemInfo("hostName", "localhost");
	}

	public void onFinish(ITestContext testContext) {
		xReports.flush();
	}

	public void onTestSuccess(ITestResult tr) {
		xTest = xReports.createTest(tr.getName());
		xTest.log(Status.PASS, "Test Is Passed");
		xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult tr) {
		xTest = xReports.createTest(tr.getName());
		xTest.log(Status.FAIL, "Test Is Failed");
		xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		captureScreenShot(driver, tr.getMethod().getMethodName());
	}

	public void captureScreenShot(WebDriver driver, String methodName) {
		
	}

	public void onTestSkipped(ITestResult tr) {
		xTest = xReports.createTest(tr.getName());
		xTest.log(Status.SKIP, "Test Is Skipped");
		xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
	}

}
