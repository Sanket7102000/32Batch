package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class CheckoutPage1 extends TestBase
{
	//Object Repository
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement checkout1MenuBtn;
	@FindBy(xpath="//span[@class='title']") private WebElement checkout1Title;
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstNameTxtBox;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastNameTxtBox;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement zipCodeTxtBox;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancelBtn;
	
	//Constructor
	public CheckoutPage1()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public String verifyCheckoutPage1URL()
	{
		return driver.getCurrentUrl();
	}
	public String verifyCheckoutPage1Logo()
	{
		return driver.getTitle();
	}
	public boolean verifyCheckoutPage1MenuBtn()
	{
		return checkout1MenuBtn.isDisplayed();
	}
	public String verifyCheckoutPage1Title()
	{
		return checkout1Title.getText();
	}
	public String verifyContinueBtn() throws EncryptedDocumentException, IOException
	{
		firstNameTxtBox.sendKeys(ReadData.readExcel(1,3));//"Sanket"(1,3)
		lastNameTxtBox.sendKeys(ReadData.readExcel(2,3));//"Patil"(2,3)
		zipCodeTxtBox.sendKeys(ReadData.readExcel(3,3));//"590001"(3,3)
		continueBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyCancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
		
	}
	
	
	
	
	
	

}
