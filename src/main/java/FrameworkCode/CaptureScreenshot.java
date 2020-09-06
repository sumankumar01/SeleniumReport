package FrameworkCode;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class CaptureScreenshot {

	public static String capture(WebDriver driver,String screenShotName) throws IOException
    {   
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest =StartFramework.reportpath+"\\Report1\\"+"\\MSmart_"+StartFramework.fileName+"/Screenshots/"+screenShotName;
       // String dest ="C:/MSmart/Report/MSmart_"+StartFramework.fileName+"\\Screenshots\\"+screenShotName;
        
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
    }
	
	public static String capture(WebDriver driver,String screenShotName,ExtentTest logger) throws IOException
    {   
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //String dest = StartFramework.dir1+screenShotName+".png";
        String dest =StartFramework.reportpath+"\\Report1\\"+"\\MSmart_"+StartFramework.fileName+"/Screenshots/"+screenShotName;
        //String dest ="C:/MSmart/Report/MSmart_"+StartFramework.fileName+"\\Screenshots\\"+screenShotName;
       // C:/Users/kusuman/Desktop/Certificate/Report/CopaReport_"+fileName+"\\Screenshots
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
    }
}
