package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class FinishPage extends TestBase
{
	//Object Repositary
	@FindBy(xpath="//span[@class='title']") private WebElement finishPageTitle;
	@FindBy(xpath="//img[@class='pony_express']") private WebElement finishPageImg;
	@FindBy(xpath="//h2[@class='complete-header']") private WebElement thankYouTxt;
	@FindBy(xpath="//div[@class='complete-text']") private WebElement dispatchTxt;
	@FindBy(xpath="//button[@id='back-to-products']") private WebElement backBtn;
	
	//Constructor
	public FinishPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public String verifyFinishPageURL()
	{
		return driver.getCurrentUrl();
	}
	public String verifyFinishPageLogo()
	{
		return driver.getTitle();
	}
	public String verifyFinishPageTitle()
	{
		return finishPageTitle.getText();
	}
	public boolean verifyFinishPageImg()
	{
		return finishPageImg.isDisplayed();	
	}
	public String verifyThankYouTxt()
	{
		return thankYouTxt.getText();
	}
	public String verifyDispatchTxt()
	{
		return dispatchTxt.getText();
	}
	public String verifyBackBtn()
	{
		backBtn.click();
		return driver.getCurrentUrl();
	}	
}
