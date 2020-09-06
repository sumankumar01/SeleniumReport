package FrameworkCode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;


public class Execute {
	
	static String Moduel=null;
	static String classname=null;
	String testdclassnameatarow=null;
	public static void run(Multimap map,String TID,WebDriver driver,ExtentTest logger) throws IOException, ReflectiveOperationException
	{
		List<String> ls=new ArrayList<String>();
		Collection<String> values = map.get(TID);
		for(int p=1;p<=values.size();p++)
		 {
		
		//ls1.add(Iterables.get(map.get(TID), p-1));
			/*Moduel=
			classname=
			classname=*/
			//String Value=(String) Iterables.get(map.get(TID), p-1);
			ls.add((String) Iterables.get(map.get(TID), p-1));
			
		//System.out.println(TID+"->"+Iterables.get(map.get(TID), p-1));
		
		 }
		try
		{
			/*String dsef=driver.getWindowHandle();
			String def=driver.getWindowHandle();
		String abc=driver.getCurrentUrl();*/
			
		testmethod.test(ls,driver,logger);
		String dddd =driver.getTitle();
		//driver.getWindowHandle();*/
		}
		catch(Exception  e)
		{
			BFrameworkQueryObjects.logStatus(driver,Status.FAIL, "Classs not found exception" ,"THis issue will cone if browser get closed incidentally",e);
		}
	}

}
