package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class HandleDropDown extends TestBase
{
	public static void handelSelect(WebElement ele,String value)
	{
		Select s= new Select(ele);
		s.selectByVisibleText(value);
	}

}
