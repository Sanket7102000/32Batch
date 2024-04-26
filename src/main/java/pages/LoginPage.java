package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	//object repository
	@FindBy(xpath="//input[@id='user-name']") private WebElement userNameTxtBox;
	@FindBy(xpath="//input[@id='password']") private WebElement passwordTxtBox;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;
	
	//constructor
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
		
	}
	public String loginToApplication() throws IOException
	{
		logger=report.createTest("Login to Sauce Lab Application");
		userNameTxtBox.sendKeys(ReadData.readpropertyfile("UserName"));
		logger.log(Status.INFO, "User Name is Entered");
		passwordTxtBox.sendKeys(ReadData.readpropertyfile("Password"));
		logger.log(Status.INFO, "Password is Entered");
		loginBtn.click();
		logger.log(Status.INFO, "Login Button is Clicked");
		logger.log(Status.INFO, "Login is Successful");
		return driver.getCurrentUrl() ;
	}
	public String loginToApplicationWithMultiCreds(String un, String pass)
	{
		userNameTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();
	}	

}
