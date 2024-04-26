package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{
	//Object Repository
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement cartMenuBtn;
	@FindBy(xpath="//span[@class='title']") private WebElement pageTitle;
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement quantityTxt;
	@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement descriptionTxt;
	@FindBy(xpath="//button[@class='btn btn_secondary back btn_medium']") private WebElement continueShoppingBtn;
	@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button ']") private WebElement checkoutBtn;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	
	//Constructor
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public String verifyCartPageURL()
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyCartPageLogo()
	{
		return driver.getTitle();
	}
	public String verifyQuantityTxt()
	{
		return quantityTxt.getText();
	}
	public String verifyDescriptionTxt()
	{
		return descriptionTxt.getText();
	}
	public boolean verifycartMenuBtn()
	{
		return cartMenuBtn.isDisplayed();
	}
	public String verifyPageTitle()
	{
		return pageTitle.getText();
	}
	public String verifyContinueShoppingBtn()
	{
		continueShoppingBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyCheckoutBtn()
	{
		checkoutBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyCartCount()
	{
		return cartCount.getText();
	}	

}
