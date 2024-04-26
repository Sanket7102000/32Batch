package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class Screenshot extends TestBase
{
	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
		
	}
	public static void sc(String nameofMethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Acer\\eclipse-workspace\\Framework\\Screenshot\\"+nameofMethod+"----"+getDate()+".jpeg");
		FileHandler.copy(source, dest);
	}

}
