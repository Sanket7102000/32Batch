package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class ExtentReportManager extends TestBase
{
	static ExtentReports report;
	public static ExtentReports getReportInstance()
	{
		if(report==null)
		{
			String reportName=new SimpleDateFormat("dd-MM-YYY ss-mm-HH").format(new Date());
			ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("C:\\Users\\Acer\\eclipse-workspace\\Framework\\Extent Report"+reportName+".html");
			report=new ExtentReports();
			report.attachReporter(htmlReporter);
			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("Environment", "SIT");
			report.setSystemInfo("Build Number", "104.11.1");
			report.setSystemInfo("Browser", "Chrome");
			htmlReporter.config().setDocumentTitle("UI Testing Documents");
			htmlReporter.config().setReportName("UI Test Report");
		}
		return report;
	}

}
