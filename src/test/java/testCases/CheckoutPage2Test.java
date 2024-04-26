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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class CheckoutPage2Test extends TestBase
{
	LoginPage login;
	Inventory_Page inventory;
	CartPage cart;
	CheckoutPage1 check1;
	CheckoutPage2 check2;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException
	{
		initialization();
		login=new LoginPage();
		inventory=new Inventory_Page();
		cart=new CartPage();
		check1=new CheckoutPage1();
		check2=new CheckoutPage2();
		login.loginToApplication();	
		inventory.adding6Product();
		inventory.clickOnCartIcon();
		cart.verifyCheckoutBtn();
		check1.verifyContinueBtn();
	}
	
	@Test(groups = {"Sanity","Regression"})
	public void verifycheckoutPage2URLTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(1,4);//"https://www.saucedemo.com/checkout-step-two.html"(1,4)
		String actURL=check2.verifycheckoutPage2URL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("The URL of CheckoutPage2 is = " + actURL); 
	}
	@Test(groups = {"Retesting","Universal"})
	public void verifycheckoutPage2LogoTest() throws EncryptedDocumentException, IOException
	{
		String expLogo=ReadData.readExcel(2,4);//"Swag Labs"(2,4)
		String actLogo=check2.verifycheckoutPage2Logo();
		Assert.assertEquals(expLogo, actLogo);
		Reporter.log("The Logo of CheckoutPage2 is = " + actLogo);
	}
	@Test(groups = "Smoke")
	public void verifycheckoutPage2TitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(3,4);//"Checkout: Overview"(3,4)
		String actTitle=check2.verifycheckoutPage2Title();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("The Title of CheckoutPage2 is = " + actTitle);
	}
	@Test(groups = "Universal")
	public void verifyQtyTxtTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExcel(4,4);//"QTY"(4,4)
		String actTxt=check2.verifyQtyTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("The QTY Text is Present = " + actTxt);
	}
	@Test(groups = "Universal")
	public void verifyDescriptionTxtTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExcel(5,4);//"Description"(5,4)
		String actTxt=check2.verifyDescriptionTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("The Description Text is Present = " + actTxt);
	}
	@Test(groups = "Universal")
	public void verifypaymentInfoTxtTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExcel(6,4);//"Payment Information:"(6,4)
		String actTxt=check2.verifypaymentInfoTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("The Text is Present = " + actTxt);
	}
	@Test(groups = "Universal")
	public void verifyshippingInfoTextTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExcel(7,4);//"Shipping Information:"(7,4)
		String actTxt=check2.verifyshippingInfoText();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("The Text is Present = " + actTxt);
	}
	@Test(groups = "Universal")
	public void verifytotalInfoTxtTest() throws EncryptedDocumentException, IOException
	{
		String expTxt=ReadData.readExcel(8,4);//"Price Total"(8,4)
		String actTxt=check2.verifytotalInfoTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("The Text is Present = " + actTxt);
	}
	@Test(groups = {"Regression","Retesting"})
	public void verifyCancelBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(9,4);//"https://www.saucedemo.com/inventory.html"(9,4)
		String actURL=check2.verifyCancelBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("The URL of CancelBtn is = " + actURL);
	}
	@Test(groups = {"Regression","Retesting"})
	public void verifyFinishBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(10,4);//"https://www.saucedemo.com/checkout-complete.html"(10,4)
		String actURL=check2.verifyFinishBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("The URL of FinishBtn is = " + actURL);
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
