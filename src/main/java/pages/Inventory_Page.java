package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDown;

public class Inventory_Page extends TestBase
{
	//Object Repository
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement menuBtn;
	@FindBy(xpath="//span[@class='title']") private WebElement pageTitle;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement filterDropDown;
	//Adding products to cart
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement productBackPack;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement productBikeLight;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement productTshirt;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement productJacket;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement productOnesie;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement productTshirtRed;
	//Removing products from cart
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeProductTshirt;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeProductTshirtRed;
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removeProductBackPack;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removeProductBikeLight;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkedinLogo;
	@FindBy(xpath="//div[@class='footer_copy']") private WebElement footerTxt;
	
	//Constructor
	public Inventory_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public String verifyURLofInventoryPage() 
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyAppLogoOfApplication()
	{
		return driver.getTitle();
		
	}
	public boolean verifyMenuBtn()
	{
		return menuBtn.isDisplayed();
		
	}
	public String verifyTitleOfInventoryPage()
	{
		return pageTitle.getText() ;
		
	}
	public String adding6Product()
	{
		HandleDropDown.handelSelect(filterDropDown, "Name (A to Z)");
		productBackPack.click();
		productBikeLight.click();
		productTshirt.click();
		productJacket.click();
		productOnesie.click();
		productTshirtRed.click();
		return cartCount.getText();
	}
	public String remove4Product()
	{
		adding6Product();
		removeProductTshirt.click();
		removeProductTshirtRed.click();
		removeProductBackPack.click();
		removeProductBikeLight.click();
		return cartCount.getText();
		
	}
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
		
	}
	public boolean verifyFacebookLogo()
	{
		return facebookLogo.isDisplayed();
		
	}
	public boolean verifyLinkedinLogo()
	{
		return linkedinLogo.isDisplayed();
		
	}
	public String verifyFooterTxt()
	{
		return footerTxt.getText();
		
	}
	public void clickOnCartIcon()
	{
		 cartIcon.click();
	
	}
	
	

}
