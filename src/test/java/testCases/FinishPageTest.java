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
import pages.CheckoutPage2;
import pages.FinishPage;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class FinishPageTest extends TestBase
{ 
	LoginPage login;
	Inventory_Page inventory;
	CartPage cart;
	CheckoutPage1 check1;
	CheckoutPage2 check2;
	FinishPage finish;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException
	{
		initialization();
		login=new LoginPage();
		inventory=new Inventory_Page();
		cart=new CartPage();
		check1=new CheckoutPage1();
		check2=new CheckoutPage2();
		finish=new FinishPage();
		login.loginToApplication();	
		inventory.adding6Product();
		inventory.clickOnCartIcon();
		cart.verifyCheckoutBtn();
		check1.verifyContinueBtn();
		check2.verifyFinishBtn();
	}
	
	@Test(groups = {"Sanity","Regression"})
	public void verifyFinishPageURLTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(1,5);//"https://www.saucedemo.com/checkout-complete.html"(1,5)
		String actURL=finish.verifyFinishPageURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("The URL of FinishPage is = " + actURL);
	}
	@Test(groups = {"Retesting","Universal"})
	public void verifyFinishPageLogoTest() throws EncryptedDocumentException, IOException
	{
		String expLogo=ReadData.readExcel(2,5);//"Swag Labs"(2,5)
		String actLogo=finish.verifyFinishPageLogo();
		Assert.assertEquals(expLogo, actLogo);
		Reporter.log("The Logo of FinishPage is = " + actLogo);
	}
	@Test(groups = "Smoke")
	public void verifyFinishPageTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(3,5);//"Checkout: Complete!"(3,5)
		String actTitle=finish.verifyFinishPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("The Title of FinishPage is = " + actTitle);
	}
	@Test(groups = "Smoke")
	public void verifyFinishPageImgTest()
	{
		boolean result=finish.verifyFinishPageImg();
		Assert.assertEquals(result, true);
		Reporter.log("Image is Present = " + result);
	}
	@Test(groups = "Universal")
	public void verifyThankYouTxtTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExcel(4,5);//"Thank you for your order!"(4,5)
		String actTxt=finish.verifyThankYouTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("The Text is Present = " + actTxt);
	}
	@Test(groups = "Universal")
	public void verifyDispatchTxtTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExcel(5,5);//"Your order has been dispatched, and will arrive just as fast as the pony can get there!"(5,5)
        String actTxt=finish.verifyDispatchTxt();
        Assert.assertEquals(expTxt, actTxt);
        Reporter.log("The Text is Present = " + actTxt);
	}
	@Test(groups = {"Regression","Retesting"})
	public void verifyBackBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(6,5);//"https://www.saucedemo.com/inventory.html"(6,5)
		String actURL=finish.verifyBackBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("The URL of BackBtn is = " + actURL);
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
