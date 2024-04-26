package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utility.ExtentReportManager;
import utility.ReadData;

public class TestBase
{
	public ExtentReports report=ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	public static WebDriver driver;
	public void initialization() throws IOException 
	{
		String browser= ReadData.readpropertyfile("Browser");
		if(browser.equals("chrome"))
		{

			driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(ReadData.readpropertyfile("URL"));
		
	}

}
