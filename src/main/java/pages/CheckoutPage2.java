package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutPage2 extends TestBase
{
	//Object Repository
	@FindBy(xpath="//span[@class='title']") private WebElement checkoutPage2Title;
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement qtyTxt;
	@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement descriptionTxt;
	@FindBy(xpath="//div[@data-test='payment-info-label']") private WebElement paymentInfoTxt;
	@FindBy(xpath="//div[@data-test='shipping-info-label']") private WebElement shippingInfoText;
	@FindBy(xpath="//div[@data-test='total-info-label']") private WebElement totalInfoTxt;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancelBtn;
	@FindBy(xpath="//button[@id='finish']") private WebElement finishBtn;
	
	//Constructor
	public CheckoutPage2()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public String verifycheckoutPage2URL()
	{
		return driver.getCurrentUrl();
	}
	public String verifycheckoutPage2Logo()
	{
		return driver.getTitle();
	}
	public String verifycheckoutPage2Title()
	{
		return checkoutPage2Title.getText();
	}
	public String verifyQtyTxt()
	{
		return qtyTxt.getText();
	}
	public String verifyDescriptionTxt()
	{
		return descriptionTxt.getText();
	}
	public String verifypaymentInfoTxt()
	{
		return paymentInfoTxt.getText();
	}
	public String verifyshippingInfoText()
	{
		return shippingInfoText.getText();
	}
	public String verifytotalInfoTxt()
	{
		return totalInfoTxt.getText();
	}
	public String verifyCancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyFinishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();
	}

}
