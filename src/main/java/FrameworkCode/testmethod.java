package FrameworkCode;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class testmethod {

	static String Moduel=null;
	static String classname=null;
	static String testdclassnameatarow=null;
	static String TestData;
	static XSSFWorkbook TD=null;
	static XSSFSheet test=null;
	static XSSFRow row=null;
	static StringBuilder htmlBuilder = new StringBuilder();
	static String url="suman";
	public static void test(List ls,WebDriver driver,ExtentTest logger) throws IOException
	{
	
		int n=ls.size();
		int k=0;
		String[] NoSeq;
		//String NoSeq[]=testdclassnameatarow.split(",");
		int NoSeqCount=1;
		//StartFramework.child=logger.createNode("child test start");
		for(int i=0;i<n;i+=3)
		{
			Moduel=(String) ls.get(i);
			classname=(String) ls.get(i+1);
			testdclassnameatarow=(String) ls.get(i+2);
			
			 NoSeq=testdclassnameatarow.split(",");
			
			//System.out.println(Moduel+"->"+classname+"->"+testdclassnameatarow);
		     
			//queryObjects.logStatus(Status.INFO, "Starting test ->" +Moduel);
			
				/*for(int t=k;t<n;t+=3)
				{
					Moduel=(String) ls.get(t);
					classname=(String) ls.get(t+1);
					testdclassnameatarow=(String) ls.get(t+2);*/
					System.out.println("Running--->"+Moduel+"--With class--->"+classname+"---Taking the test data row---"+testdclassnameatarow);
					
					StartFramework.child=logger.createNode("<b><font color="+"green"+" "+"size="+5+">"+Moduel+"---"+classname+"---"+testdclassnameatarow+"</font></b>");
					
					//BFrameworkQueryObjects.logStatus(driver,Status.FAIL, "<b><font color="+"Yellow"+" "+"size="+5+">Start Test</font></b>","" +"<b><font color="+"green"+" "+"size="+5+">"+Moduel+"---"+classname+"---"+testdclassnameatarow+"</font></b>",null);
				//}boolean isClosed=false;
					/*Boolean isClosed=false;
			        try{
			            driver.getTitle();
			        }catch(UnreachableBrowserException ubex){
			            isClosed=true;
			        }*/
			String abcd=driver.getWindowHandle();
			url="suman";
			try
			{
			 url=driver.getTitle();
			 //String abc=driver.getCurrentUrl();
			}
			catch(Exception e)
			{
				url="";
				//abcd="kumar";
			}
			//System.out.println(abcd+";;;"+url);
					
		   if(driver!=null && url == "")
			   {
				   BFrameworkQueryObjects.logStatus(driver,Status.FAIL, "Please check your browser" ,"May be your browser close incidentally",null);   
			   }
			
			k++;
			
	Class cls=null;
	try 
	{
		cls = Class.forName(classname);
	} 
	  catch (Exception e) 
	  {
		// logger.log(Status.FAIL, "Classs not found exception"+e);
		
		//System.out.println("Classs not found exception"+e.getMessage());
		BFrameworkQueryObjects.logStatus(driver,Status.FAIL, "Checking the class","Classs not found exceptio",e);

		
	  }
	Object obj=null;
	try 
	{
		obj = cls.newInstance();
	} 
	 catch (Exception  e)
	 {
		 //logger.log(Status.FAIL, "Classs not found exception"+e);
		//System.out.println("Classs not found exception"+e.getMessage());
		BFrameworkQueryObjects.logStatus(driver,Status.FAIL, "Checking the class","Classs not found while object exception",e);
		
	 }
	
	Method method=null;
	try 
	 {
		//method = cls.getDeclaredMethod(Moduel);
		
		
			//testdclassnameatarow=NoSeq[s];
		method = obj.getClass().getMethod(Moduel,WebDriver.class,BFrameworkQueryObjects.class);
		
		//Report.logstatus(driver,Status.INFO, "Method execution","sTART EXECUTING THE METHO");
		//Report.logstatus(driver, LogStatus.FAIL, "Login to COPA Application", "LoginFailure",null);
	 } 
	 catch (Exception e) 
	 { 
		 BFrameworkQueryObjects.logStatus(driver,Status.FAIL, "Classs not found exception" ,"",e);
		//System.out.println("Classs not found exception"+e);
		//e.printStackTrace();
		//logger.log(Status.INFO, "Classs not found exception"+e.getMessage());
		
     }
	
	try 
	 {   //int t=NoSeq.length;
		for(int s=0;s<NoSeq.length;s++)
		{
			
			testdclassnameatarow=NoSeq[s];
			if(NoSeq.length>1)
			{
				BFrameworkQueryObjects.logStatus(driver,Status.PASS, "<b><font color="+"Yellow"+" "+"size="+5+">Start Test</font></b>","" +"<b><font color="+"green"+" "+"size="+5+">"+Moduel+"---"+classname+"---"+testdclassnameatarow+"</font></b>",null);
			}
		 
		BFrameworkQueryObjects abc=new BFrameworkQueryObjects();
		double d=-1;Object value=null;
		try
		{
		 value= method.invoke(obj,driver,abc);
		}
		catch(InvocationTargetException ite)
		{
			BFrameworkQueryObjects.logStatus(driver,Status.FAIL, "method not executed correctly" ,""+ite.getTargetException()+"-----"+ite.getCause()+"-->"+ite.getMessage()+"",ite);
			//System.err.println(ite.getTargetException()+"-----"+ite.getCause()+"-->"+ite.getMessage());
		}
		if(value==null)
		{
			 //System.err.println(value+"--->"+"method not executed correctoly");
		}
		// d = (Double) value;
		
		}
		//Report.logstatus(driver, LogStatus.FAIL, "Login to COPA Application", "LoginFailure",null);
	 } 
	catch (Exception e) 
	 {
		
		BFrameworkQueryObjects.logStatus(driver,Status.FAIL, "Classs not found exception" ,"",e);
		//System.out.println("Classs not found exception"+e.getMessage());
		//queryObjects.logStatus(driver, Status.FAIL, "Login to COPA Application", "LoginFailure",null);
		//e.printStackTrace();
		
	 }
		}	
}


	
}
