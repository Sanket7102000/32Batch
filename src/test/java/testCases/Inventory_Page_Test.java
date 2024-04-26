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
import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField.Read;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Inventory_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page inventory;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException
	{
		initialization();
		login=new LoginPage();
		inventory=new Inventory_Page();
		login.loginToApplication();	
	}
	
	@Test(priority = 1,groups = {"Sanity","Regression"})
	public void verifyURLofInventoryPageTest() throws EncryptedDocumentException, IOException
	{
		String exptURL=ReadData.readExcel(1,1);//"https://www.saucedemo.com/inventory.html"(1,1)
		String actURL=inventory.verifyURLofInventoryPage();
	    Assert.assertEquals(exptURL, actURL);
	    Reporter.log("URL of Inventory Page is = " + actURL);	
	}
	@Test(priority = 2,groups = {"Retesting","Universal"})
	public void verifyAppLogoOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String exptLogo=ReadData.readExcel(2,1);//"Swag Labs"(2,1)
		String actLogo=inventory.verifyAppLogoOfApplication();
        Assert.assertEquals(exptLogo, actLogo);
        Reporter.log("Logo of Inventory Page is = " + actLogo);
	}
	@Test(priority = 3,groups = {"Regression","Retesting"})
	public void verifyMenuBtnTest()
	{
		boolean result=inventory.verifyMenuBtn();
		Assert.assertEquals(result,true);
		Reporter.log("Menu Btn is Present = "+ result);
	}
	@Test(priority = 4,groups = "Smoke")
	public void verifyTitleOfInventoryPageTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(3,1);//"Products"(3,1)
		String actTitle=inventory.verifyTitleOfInventoryPage();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of Inventory Page is = " + actTitle);
	}
	@Test(priority = 5,groups = "Adhock")
	public void adding6ProductTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(4,1);//"6"(4,1)
		String actCount=inventory.adding6Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total Product Added to Cart = " + actCount);
	}
	@Test(priority = 6,groups = "Adhock")
	public void remove4ProductTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(5,1);//"2"(5,1)
		String actCount=inventory.remove4Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total Product Remained in Cart = " + actCount);
	}
	@Test(priority = 7,groups = {"Retesting","Universal"})
	public void verifyTwitterLogoTest()
	{
		boolean result=inventory.verifyTwitterLogo();
		Assert.assertEquals(result,true);
		Reporter.log("Twitter Logo is Present = " + result);
	}
	@Test(priority = 8,groups = {"Retesting","Universal"})
	public void verifyFacebookLogoTest()
	{
		boolean result=inventory.verifyFacebookLogo();
		Assert.assertEquals(result,true);
		Reporter.log("Facebook Logo is Present = " + result);
	}
	@Test(priority = 9,groups = {"Retesting","Universal"})
	public void verifyLinkedinLogoTest()
	{
		boolean result=inventory.verifyLinkedinLogo();
		Assert.assertEquals(result,true);
		Reporter.log("Linkedin Logo is Present = " + result);
	}
	@Test(priority = 10,groups = "Universal")
	public void verifyFooterTxtTest() throws EncryptedDocumentException, IOException 
	{
		String expTxt=ReadData.readExcel(6,1);//"© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"(6,1)
		String actTxt=inventory.verifyFooterTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("The Footer Text Is Present = " + actTxt);
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
