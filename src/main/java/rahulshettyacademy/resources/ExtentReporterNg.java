package rahulshettyacademy.resources;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
	

	public static ExtentReports getReporterObject()
	{
		
		
			//ExtentReport,ExtentSparkreporter
			String path =System.getProperty("user.dir")+"//reports/index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Web Automation results");
			reporter.config().setDocumentTitle("Test results");
			
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Ravi");
			return extent;
		
	}

}
