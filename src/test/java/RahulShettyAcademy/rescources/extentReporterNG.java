package RahulShettyAcademy.rescources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterNG  {
	public static ExtentReports getReportProjectObiect(){
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Result");
	
	reporter.config().setDocumentTitle("Test Results");
	ExtentReports extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester","Marwan Sameh");
	return extent;

}}