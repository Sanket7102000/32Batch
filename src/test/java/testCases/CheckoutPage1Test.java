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
import pages.CheckoutPage1;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class CheckoutPage1Test extends TestBase
{
	LoginPage login;
	Inventory_Page inventory;
	CartPage cart;
	CheckoutPage1 check1;
	@BeforeMethod (alwaysRun = true)
	public void setup() throws IOException
	{
		initialization();
		login=new LoginPage();
		inventory=new Inventory_Page();
		cart=new CartPage();
		check1=new CheckoutPage1();
		login.loginToApplication();	
		inventory.adding6Product();
		inventory.clickOnCartIcon();
		cart.verifyCheckoutBtn();
	}
	
	@Test(groups = {"Sanity","Regression"})
	public void verifyCheckoutPage1URLTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(4,3);//"https://www.saucedemo.com/checkout-step-one.html"(4,3)
		String actURL=check1.verifyCheckoutPage1URL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("The URL of CheckoutPage1 is = " + actURL);
	}
	@Test(groups = {"Retesting","Universal"})
	public void verifyCheckoutPage1LogoTest() throws EncryptedDocumentException, IOException
	{
		String expLogo=ReadData.readExcel(5,3);//"Swag Labs"(5,3)
		String actLogo=check1.verifyCheckoutPage1Logo();
		Assert.assertEquals(expLogo, actLogo);
		Reporter.log("The Logo of CheckoutPage1 is = " + actLogo);
	}
	@Test(groups = {"Regression","Retesting"})
	public void verifyCheckoutPage1MenuBtnTest()
	{
		boolean result=check1.verifyCheckoutPage1MenuBtn();
		Assert.assertEquals(result,true);
		Reporter.log("CheckoutPage1MenuBtn is Present = " + result);
	}
	@Test(groups = "Smoke")
	public void verifyCheckoutPage1TitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(6,3);//"Checkout: Your Information"(6,3)
		String actTitle=check1.verifyCheckoutPage1Title();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("The Title of CheckoutPage1 is = " + actTitle);
	}
	@Test(groups = {"Regression","Retesting"})
	public void verifyContinueBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(7,3);//"https://www.saucedemo.com/checkout-step-two.html"(7,3)
		String actURL=check1.verifyContinueBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("The URL of ContinueBtn is = " + actURL);
	}
	@Test(groups = {"Regression","Retesting"})
	public void verifyCancelBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(8,3);//"https://www.saucedemo.com/cart.html"(8,3)
		String actURL=check1.verifyCancelBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("The URL of CancelBtn is = " + actURL);
	}
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.sc(it.getName());
		}
	driver.close();
	}

}
