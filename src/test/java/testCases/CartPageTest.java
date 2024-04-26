package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class CartPageTest extends TestBase
{
	LoginPage login;
	Inventory_Page inventory;
	CartPage cart;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException
	{
		initialization();
		login=new LoginPage();
		inventory=new Inventory_Page();
		cart=new CartPage();
		login.loginToApplication();	
		inventory.adding6Product();
		inventory.clickOnCartIcon();
	}
	@Test (groups = {"Sanity","Regression"})
	public void verifyCartPageURLTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(1,2);//"https://www.saucedemo.com/cart.html"(1,3)
		String actURL=cart.verifyCartPageURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("The URL of CartPage is = " + actURL);
	}
	@Test(groups = {"Retesting","Universal"})
	public void verifyCartPageLogoTest() throws EncryptedDocumentException, IOException
	{
		String expLogo=ReadData.readExcel(2,2);//"Swag Labs"(2,3)
		String actLogo=cart.verifyCartPageLogo();
		Assert.assertEquals(expLogo, actLogo);
		Reporter.log("The Logo of CartPage is = " + actLogo);
	}
	@Test(groups = "Universal")
	public void verifyQuantityTxtTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExcel(7,2);//"QTY"(7,2)
		String actTxt=cart.verifyQuantityTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("The QTY Text is Present = " + actTxt);
	}
	@Test(groups = "Universal")
	public void verifyDescriptionTxtTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExcel(8,2);//"Description"(8,2)
		String actTxt=cart.verifyDescriptionTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("The Description Text is Present = " + actTxt);
	}
	@Test(groups = {"Regression","Retesting"})
	public void verifycartMenuBtnTest()
	{
		boolean result=cart.verifycartMenuBtn();
		Assert.assertEquals(result,true);
		Reporter.log("Menu Btn is Present = "+ result);
	}
	@Test(groups = "Smoke")
	public void verifyPageTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(3,2);//"Your Cart"(3,3)
		String actTitle=cart.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("The Title of CartPage is = " + actTitle);
	}
	@Test(groups = {"Regression","Retesting"})
	public void verifyContinueShoppingBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(4,2);//"https://www.saucedemo.com/inventory.html"(4,3)
		String actURL=cart.verifyContinueShoppingBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("The URL of Continue Shopping Btn is = " + actURL);
	}
	@Test(groups = {"Regression","Retesting"})
	public void verifyCheckoutBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(5,2);//"https://www.saucedemo.com/checkout-step-one.html"(5,3)
		String actURL=cart.verifyCheckoutBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("The URL of Checkout Btn is = " +actURL);
	}
	@Test(groups = "Adhock")
	public void verifyCartCountTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(6,2);//"6"(6,3)
		String actCount=cart.verifyCartCount();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total Product Added to Cart = " +actCount);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.sc(it.getName());
		}
	driver.close();
	}

}
