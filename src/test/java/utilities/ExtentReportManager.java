package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
public ExtentSparkReporter sparkReporter;
public ExtentReports extent;
public ExtentTest test;

	String repName;
	
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName); //Location of the report	
		sparkReporter.config().setDocumentTitle("Mr. Price Automation Report"); //Title of report
		sparkReporter.config().setReportName("Mr.Price Functional Testing"); //Name of report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Mr.Price");
		extent.setSystemInfo("Environment", "QA");
		
		String device = testContext.getCurrentXmlTest().getParameter("device");
		extent.setSystemInfo("Device", device);
		
	/*	String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("browser", browser); */
		
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups",includedGroups.toString());
		}
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //Include group information on report
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL,result.getName()+" failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		String imgPath = new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgPath);
	}
	
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
		String reportName = repName != null ? repName: "defaultReport.html"; //to handle possibility of repName = null
		String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + reportName;
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
