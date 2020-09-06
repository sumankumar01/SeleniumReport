package FrameworkCode;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;



public class StartFramework {
	
	static String ScanarioBank;
	static String  ScanarioDescription;
	static String  TestData;
	static String ScanarioBank_Sheet;
	static String objects;
	static String ScanarioBank_suite;
	static String testCaseID;
	static String exec;
	static String desc;
	static HSSFWorkbook wb=null;
	static HSSFSheet sh=null;
	static HSSFRow row=null;
	static HSSFCell testcasecellid=null;
	static HSSFCell TestDecription=null;
	static HSSFCell executioncell=null;
	static HSSFCell browservar=null;
	static HSSFCell sanityvar=null;
	static LinkedHashMap<String,String> TCID=new LinkedHashMap<String,String>();
	 List<String> testcaseidyes =new ArrayList<String>();
	 List<String> testcaseidyes1 =new ArrayList<String>();
	 List<String> testdes =new ArrayList<String>();
	 List<String> Browser =new ArrayList<String>();
	 List<String> Sanity =new ArrayList<String>();
	 Multimap<String, String> map = ArrayListMultimap.create();
	 WebDriver driver;
	static String rpt;
	static String Scanario;
	static ExtentReporter htmlReporter;
	static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentTest child;
	public static String fileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	public Date strDate = new Date();
	 static String reportpath=System.getProperty("user.dir")+"\\target";
	Boolean dir = new File(reportpath+"\\Report\\"+fileName).mkdirs();
	Boolean dir2 = new File(reportpath+"\\Report1\\"+fileName+"/HTML").mkdirs();
	public static Boolean dir1 = new File(reportpath+"\\Report1\\"+fileName+"/Screenshots").mkdirs();
	private static final String SummaryReportFilePath = reportpath+"\\Report1\\"+fileName+"/SummaryTestReport_"+fileName+".html";
	
	File NetorkTraffic = new File(reportpath+"\\Report1\\"+fileName+"/NetworkTraffic"+fileName+".txt");
	private static final String jenkinsreport = "D:/Mphasis Framework/Mphasis/Report/jenkinReport/report.html";
	//String[] Prope = {"C:/AFT/Configs/suiteRES.properties","C:/AFT/Configs/suiteATO.properties" };
	String Prop_COPA="D:/Mphasis Framework/Mphasis/Configs/suiteRES.properties";
	public static final String SummaryReportFilePath2 =reportpath+"\\Report1\\"+StartFramework.fileName+"/HTML/SummaryTestReport_1"+StartFramework.fileName+".html";
	
	
	/*Boolean dir = new File("C:D:/Mphasis Framework/Mphasis/Reportreportpath+"\\Report1\\"+fileName).mkdirs();
	Boolean dir2 = new File("C:D:/Mphasis Framework/Mphasis/Reportreportpath+"\\Report1\\"+fileName+"/HTML").mkdirs();
	public static Boolean dir1 = new File("C:D:/Mphasis Framework/Mphasis/Reportreportpath+"\\Report1\\"+fileName+"\\Screenshots").mkdirs();
	private static final String SummaryReportFilePath = "C:D:/Mphasis Framework/Mphasis/Reportreportpath+"\\Report1\\"+fileName+"\\SummaryTestReport_"+fileName+".html";
	File NetorkTraffic = new File("C:D:/Mphasis Framework/Mphasis/Reportreportpath+"\\Report1\\"+fileName+"\\NetworkTraffic"+fileName+".txt");
	private static final String jenkinsreport = "C:D:/Mphasis Framework/Mphasis/Report/jenkinReport/report.html";
	//String[] Prope = {"C:/AFT/Configs/suiteRES.properties","C:/AFT/Configs/suiteATO.properties" };
	String Prop_COPA="C:D:/Mphasis Framework/Mphasis/Configs/suiteRES.properties";
	public static final String SummaryReportFilePath2 ="C:D:/Mphasis Framework/Mphasis/Reportreportpath+"\\Report1\\"+StartFramework.fileName+"/HTML/SummaryTestReport_1"+StartFramework.fileName+".html";
	
	*/
	
	static File SummaryReportFilePath1=new File(SummaryReportFilePath2);
	
	@BeforeSuite(groups = {"Regression","Sanity"})
	public void Beforesuit() throws IOException
	{
		//Report.CreateSummaryHeader();
		
		//new File(SummaryReportFilePath).cr
		
		//if(!new File(SummaryReportFilePath).exists())
			//new File(SummaryReportFilePath).createNewFile(); 
	}
	@BeforeTest(groups = {"Regression","Sanity"})
	public void init(ITestContext context) throws IOException
	 {	
	   //System.out.println("Copa applicastion");
		
	 htmlReporter = new ExtentHtmlReporter(SummaryReportFilePath);
	// htmlReporter.loadXMLConfig("C:D:/Mphasis Framework/Mphasis/Configs/Files/extent-config.xml");
	// htmlReporter.loadXMLConfig("D:/Mphasis Framework/Mphasis/Configs/Files/extent-config.xml");
	 extent = new ExtentReports ();
	   List statusHierarchy = Arrays.asList(
                    Status.FATAL,
                    Status.FAIL,
                    Status.ERROR,
                    Status.WARNING,
                    Status.SKIP,
                    Status.PASS,
                    Status.DEBUG,
                    Status.INFO);

     extent.config().statusConfigurator().setStatusHierarchy(statusHierarchy);
    // htmlReporter.config().setDocumentTitle("Mphasis Auto. Report");
	      for (String group : context.getIncludedGroups())
	      {

				System.out.println("group : " + group);

				if (group.equalsIgnoreCase("Regression")) {
					
					//htmlReporter.config().setReportName("Regression cycle");
				}
				
				else
				{
					//htmlReporter.config().setReportName("Sanity cycle");
				}
	      }
	     
	    extent.attachReporter(htmlReporter);
	  //  htmlReporter.config().setChartVisibilityOnOpen(true);
	    String hostname = "Unknown";
	    InetAddress addr;
	    String address = InetAddress.getByName("stackoverflow.com").getHostAddress();
	    addr = InetAddress.getLocalHost();
	    hostname = addr.getHostName();
	    extent.setSystemInfo("IP address of Machine",address);
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", hostname);
		//
	    extent.attachReporter(htmlReporter);
	    
	    /*Prop_COPA= (String) JOptionPane.showInputDialog(null, "Choose now...",
	     "Select the ATO OR RES need to execute", JOptionPane.QUESTION_MESSAGE, null, // Use
	                                                                       // default
	                                                                       // icon
	       Prope, // Array of choices
	       Prope[1]); // Initial choice	       
*/	 
	    extent.setAnalysisStrategy(AnalysisStrategy.TEST);
	    extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
	    extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
	 }	
	@SuppressWarnings("deprecation")
	@Test(dataProvider="hybridDataRegression",groups = { "Regression" } )
		public void testLogin(String testcaseName,String def,String Browser) throws Exception {
		  rpt=testcaseName;
		  Scanario=def;
		  //Report.CreateSummaryHeader(def,testcaseName);
		 // Report.CreateIndvHeader(rpt);
		System.out.println(testcaseName+"->"+Browser);
		//extent.setSystemInfo("Browser",Browser );
	    htmlReporter.start();
		logger = extent.createTest(def,testcaseName);
		logger.assignCategory("Execution Report");
		/*if(testcaseName.toUpperCase().contains("PPS"))
		{
			logger.assignCategory("PPS");
		}
		else if(testcaseName.toUpperCase().contains("RES"))
		{
			logger.assignCategory("RES");	
		}
		else if(testcaseName.toUpperCase().contains("TRR"))
		{
			logger.assignCategory("RES");	
		}
		else if(testcaseName.toUpperCase().contains("ATO"))
		{
			logger.assignCategory("ATO");	
		}
		else if(testcaseName.toUpperCase().contains("SR"))
		{
			logger.assignCategory("SR");	
		}
		else if(testcaseName.toUpperCase().contains("ISSR"))
		{
			logger.assignCategory("ISSR");	
		}
		else
			logger.assignCategory("Others");*/
		
	    ActivityCapture handle=null;
	  //  String Node="http:http://199.228.249.66:4444/wd/hub";
	    EventFiringWebDriver driver1 =null;
		 if(Browser.equalsIgnoreCase("Chrome"))
		 {
		 //System.setProperty("webdriver.chrome.driver", "C:D:/Mphasis Framework/Mphasis/Driver/chromedriver.exe");
		 System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Framework\\Mphasis\\chromedriver.exe");
		 System.setProperty("org.uncommons.reportng.escape-output", "false");
		 LoggingPreferences loggingprefs = new LoggingPreferences();
	        loggingprefs.enable(LogType.PERFORMANCE, Level.ALL);

	        DesiredCapabilities cap = new DesiredCapabilities().chrome();
	        cap.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
	        ChromeOptions options = new ChromeOptions();
	        driver = new RemoteWebDriver(new URL("http://192.168.0.167:4444/wd/hub"), cap);
	        
	        
		// driver=new ChromeDriver(cap);
	      // driver=new ChromeDriver(cap);
	        //ChromeOptions driver = new ChromeOptions();
	      
		 driver.manage().window().maximize();
		driver1=new EventFiringWebDriver(driver);
		 
			  handle=new ActivityCapture();
			  
			 driver1.register(handle);
		 }
		 else if(Browser.equalsIgnoreCase("Chrome_headless"))
		 {
			 
		 //System.setProperty("webdriver.chrome.driver", "C:D:/Mphasis Framework/Mphasis/Driver/chromedriver.exe");
		 System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Framework\\Mphasis\\Driver\\chromedriver.exe");
		 System.setProperty("org.uncommons.reportng.escape-output", "false");
		 LoggingPreferences loggingprefs = new LoggingPreferences();
	        loggingprefs.enable(LogType.PERFORMANCE, Level.ALL);

	        DesiredCapabilities cap = new DesiredCapabilities().chrome();
	       // cap.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
 

				ChromeOptions options=new ChromeOptions();
				options.addArguments("window-size=1400,800");
				options.addArguments("headless");
				 
				
				
				driver=new ChromeDriver(options);
				
		/* driver.manage().window().maximize();
		driver1=new EventFiringWebDriver(driver);
		 
			  handle=new ActivityCapture();
			  
			 driver1.register(handle);*/
		 }
		 else if(Browser.equalsIgnoreCase("Firefox"))
		 {
			 //System.setProperty("webdriver.gecko.driver", "C:D:/Mphasis Framework/Mphasis/Driver/geckodriver.exe");
			 System.setProperty("webdriver.gecko.driver", "D:/Mphasis Framework/Mphasis/Driver/geckodriver.exe");
			 System.setProperty("org.uncommons.reportng.escape-output", "false");
			 LoggingPreferences loggingprefs = new LoggingPreferences();
		        loggingprefs.enable(LogType.PERFORMANCE, Level.ALL);

		        DesiredCapabilities cap = new DesiredCapabilities().firefox();
		        cap.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);

			 
			 driver=new FirefoxDriver(cap);
		      // driver=new ChromeDriver(cap);
		        //ChromeOptions driver = new ChromeOptions();
		      
			 driver.manage().window().maximize();
			driver1=new EventFiringWebDriver(driver);
			 
				  handle=new ActivityCapture();
				  
				 driver1.register(handle);
			 
		 }
		 else if(Browser.equalsIgnoreCase("IE"))
		 {
			 
			 //System.setProperty("webdriver.ie.driver", "C:D:/Mphasis Framework/Mphasis/Driver/IEDriverServer.exe");
			 System.setProperty("webdriver.ie.driver", "D:/Mphasis Framework/Mphasis/Driver/IEDriverServer.exe");
			 System.setProperty("org.uncommons.reportng.escape-output", "false");
			 LoggingPreferences loggingprefs = new LoggingPreferences();
		        loggingprefs.enable(LogType.PERFORMANCE, Level.ALL);

		       // DesiredCapabilities cap = new DesiredCapabilities().internetExplorer();
		        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		        cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		        cap.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
		        cap.setCapability("requireWindowFocus", true);
			 
			 driver=new InternetExplorerDriver(cap);
		      // driver=new ChromeDriver(cap);
		        //ChromeOptions driver = new ChromeOptions();
		      
			 driver.manage().window().maximize();
			driver1=new EventFiringWebDriver(driver);
			 
				  handle=new ActivityCapture();
				  
				 driver1.register(handle);
			 
		 }
		 
		 
		 // File  file = new File("C:/suman/mSafe_Framework/Configs/suite.properties");
		 File  file = new File(Prop_COPA);
			FileInputStream fs;
			
			try {
				fs = new FileInputStream(file);
				Properties prop=new Properties();
				prop.load(fs);
				fs.close();
				
				ScanarioBank=prop.getProperty("com.scenario.bank");
				ScanarioBank_Sheet=prop.getProperty("com.scenario.bank.sheet");
				ScanarioBank_suite=prop.getProperty("com.scenario.bank.suite");
				ScanarioDescription=prop.getProperty("com.scenario.description");
				TestData=prop.getProperty("com.scenario.TestData");
				objects=prop.getProperty("com.scenario.objects");
		 
		 File SDEC =    new File(ScanarioDescription);
		    try 
		    {
		    	
				FileInputStream inputStreamScanarioDec = new FileInputStream(SDEC);
				DataFormatter formatter=new DataFormatter();
				
				//DataFormatter formatter=new DataFormatter();
				wb=new HSSFWorkbook(inputStreamScanarioDec);
				sh=wb.getSheet("Scenario");
				
				
				//for(int k=1;k<=sh.getLastRowNum();i++)
					//int k=1;
					//int Stopwhile=0;
					String testCaseIDScan=null;
					String next="";
					int i=0;
					Boolean flag=true;
					int len=testcaseidyes.size();
					String abc="";
					int temp=0;
					String Mod=null;
					String Cla=null;
					String TestDa=null;
					int l=0;
						
					
						
							
						 abc=testcaseName;
						 
						int Stopwhile=0;
						int k=1;
						int u=0;
						;
						while(Stopwhile<sh.getLastRowNum())
						{List<String> ls1=new ArrayList<String>();
						//testObjArray1[u][s]=TID;
						String id=null;
							int s=0;
							row=sh.getRow(k);
							String TID=row.getCell(0,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
							
						if(abc.equalsIgnoreCase(TID))
						{   //System.out.println(TID);
							TID=row.getCell(0).toString();
							testCaseIDScan = TID;
						
							flag=true;
							do
							{  row=sh.getRow(k);
							//testObjArray=new Object[len][3];
						HSSFCell Modules=row.getCell(3);
						HSSFCell classToRun=row.getCell(4);
						HSSFCell TestData=row.getCell(5);		
						//String testCaseID = formatter.formatCellValue(testcasecellid);
						 testCaseIDScan = TID;
						
					
						 Mod = formatter.formatCellValue(Modules); 
						 Cla = formatter.formatCellValue(classToRun);
						 TestDa = formatter.formatCellValue(TestData);
						
						
						k++;
						
						List<String> ls=new ArrayList<String>();
					
						
						map.put(TID, Mod);
						map.put(TID, Cla);
						map.put(TID, TestDa);
						
						
					
						 next=formatter.formatCellValue(sh.getRow(k).getCell(0));
						 
							}
							while(next.equalsIgnoreCase(""));
							
							

							Collection<String> values = map.get(TID);
							
						
						List<String> ls=new ArrayList<String>();
						if(Browser.equalsIgnoreCase("Chrome_headless"))
							Execute.run(map,TID,driver,logger);
						else
							Execute.run(map,TID,driver1,logger);
						
						
							 /*for(int p=1;p<=values.size();p++)
							 {
							
							ls1.add(Iterables.get(map.get(TID), p-1));
							
							
							System.out.println(TID+"->"+Iterables.get(map.get(TID), p-1));
							
							 }*/
							
							break;
						}
						else
						 {
							flag=false;
						    k++;
						 }

						}
						
					
					wb.close();
					//logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
					
					//extent.config().statusConfigurator();
				
			}
		    catch (Exception e)
		    {
		    	logger.log(Status.FAIL, e);
		    	logger.log(Status.FAIL, " Getting the exception "+e.getMessage());
		    	//System.out.println ("Check config or scanario bank"+ e.getMessage());
		    	//extent.config().statusConfigurator();
				e.printStackTrace();
				
			}
		    
		} 
		 catch (Exception e) 
		 {   logger.log(Status.FAIL, e);
			 logger.log(Status.FAIL, "Getting the exception"+e.getMessage());
			//System.out.println ("Check config or scanario bank"+ e.getMessage());
			e.printStackTrace();
		
			//extent.config().statusConfigurator();
		
		 }
		
	
		 
	 }
	//=============Sanity=======================
	 
	 @Test(dataProvider="hybridDataRegression",groups = { "Sanity" })
		public void testLoginSanity(String testcaseName,String def,String Browser) throws Exception {
		 
		System.out.println(Browser);
		 htmlReporter.start();
		 logger = extent.createTest(testcaseName,def);
		 //logger = extent.createTest(def);
		 
		 
		 
		 
		 /*EventFiringWebDriver driver1=new EventFiringWebDriver(driver);
		  
		 ActivityCapture handle=new ActivityCapture();
		  
		 driver1.register(handle);*/
		// logger.log(Status.INFO, "Starting test " +TestMethod.Moduel);
		 /*logger.log(Status.PASS, "Test Passed");
		 logger.log(Status.FAIL, "Test Passed suman");	*/
		 //System.out.println(testcaseName);
		 ActivityCapture handle=null;
		 EventFiringWebDriver driver1 =null;
		 if(Browser.equalsIgnoreCase("Chrome"))
		 {
		// System.setProperty("webdriver.chrome.driver", "C:D:/Mphasis Framework/Mphasis/Driver/chromedriver.exe");
		 System.setProperty("webdriver.chrome.driver", "D:/Mphasis Framework/Mphasis/Driver/chromedriver.exe");
		 System.setProperty("org.uncommons.reportng.escape-output", "false");
		 LoggingPreferences loggingprefs = new LoggingPreferences();
	        loggingprefs.enable(LogType.PERFORMANCE, Level.ALL);

	        DesiredCapabilities cap = new DesiredCapabilities().chrome();
	        cap.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);

		 
		 driver=new ChromeDriver(cap);
	      // driver=new ChromeDriver(cap);
	        //ChromeOptions driver = new ChromeOptions();
	      
		 driver.manage().window().maximize();
		driver1=new EventFiringWebDriver(driver);
		 
			  handle=new ActivityCapture();
			  
			 driver1.register(handle);
		 }
		 else if(Browser.equalsIgnoreCase("Firefox"))
		 {
			// System.setProperty("webdriver.gecko.driver", "C:D:/Mphasis Framework/Mphasis/Driver/geckodriver.exe");
			 System.setProperty("webdriver.gecko.driver", "D:/Mphasis Framework/Mphasis/Driver/geckodriver.exe");
			 System.setProperty("org.uncommons.reportng.escape-output", "false");
			 LoggingPreferences loggingprefs = new LoggingPreferences();
		        loggingprefs.enable(LogType.PERFORMANCE, Level.ALL);

		        DesiredCapabilities cap = new DesiredCapabilities().firefox();
		        cap.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);

			 
			 driver=new FirefoxDriver(cap);
		      // driver=new ChromeDriver(cap);
		        //ChromeOptions driver = new ChromeOptions();
		      
			 driver.manage().window().maximize();
			driver1=new EventFiringWebDriver(driver);
			 
				  handle=new ActivityCapture();
				  
				 driver1.register(handle);
			 
		 }
		 else if(Browser.equalsIgnoreCase("IE"))
		 {
			 
			// System.setProperty("webdriver.ie.driver", "C:D:/Mphasis Framework/Mphasis/Driver/IEDriverServer.exe");
			 System.setProperty("webdriver.ie.driver", "D:/Mphasis Framework/Mphasis/Driver/IEDriverServer.exe");
			 System.setProperty("org.uncommons.reportng.escape-output", "false");
			 LoggingPreferences loggingprefs = new LoggingPreferences();
		        loggingprefs.enable(LogType.PERFORMANCE, Level.ALL);

		       // DesiredCapabilities cap = new DesiredCapabilities().internetExplorer();
		        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		        cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		        cap.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
		        cap.setCapability("requireWindowFocus", true);
			 
			 driver=new InternetExplorerDriver(cap);
		      // driver=new ChromeDriver(cap);
		        //ChromeOptions driver = new ChromeOptions();
		      
			 driver.manage().window().maximize();
			driver1=new EventFiringWebDriver(driver);
			 
				  handle=new ActivityCapture();
				  
				 driver1.register(handle);
			 
		 }
		  File  file = new File(Prop_COPA);
			FileInputStream fs;
			
			try {
				fs = new FileInputStream(file);
				Properties prop=new Properties();
				prop.load(fs);
				fs.close();
				
				ScanarioBank=prop.getProperty("com.scenario.bank");
				ScanarioBank_Sheet=prop.getProperty("com.scenario.bank.sheet");
				ScanarioBank_suite=prop.getProperty("com.scenario.bank.suite");
				ScanarioDescription=prop.getProperty("com.scenario.description");
				TestData=prop.getProperty("com.scenario.TestData");
				objects=prop.getProperty("com.scenario.objects");
		 
		 File SDEC =    new File(ScanarioDescription);
		    try 
		    {
		    	
				FileInputStream inputStreamScanarioDec = new FileInputStream(SDEC);
				DataFormatter formatter=new DataFormatter();
				
				//DataFormatter formatter=new DataFormatter();
				wb=new HSSFWorkbook(inputStreamScanarioDec);
				sh=wb.getSheet("Scenario");
				
				
				//for(int k=1;k<=sh.getLastRowNum();i++)
					//int k=1;
					//int Stopwhile=0;
					String testCaseIDScan=null;
					String next="";
					int i=0;
					Boolean flag=true;
					int len=testcaseidyes.size();
					String abc="";
					int temp=0;
					String Mod=null;
					String Cla=null;
					String TestDa=null;
					int l=0;
						
					
						
							
						 abc=testcaseName;
						 
						int Stopwhile=0;
						int k=1;
						int u=0;
						;
						while(Stopwhile<sh.getLastRowNum())
						{List<String> ls1=new ArrayList<String>();
						//testObjArray1[u][s]=TID;
						String id=null;
							int s=0;
							row=sh.getRow(k);
							String TID=row.getCell(0,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
							
						if(abc.equalsIgnoreCase(TID))
						{   //System.out.println(TID);
							TID=row.getCell(0).toString();
							testCaseIDScan = TID;
						
							flag=true;
							do
							{  row=sh.getRow(k);
							//testObjArray=new Object[len][3];
						HSSFCell Modules=row.getCell(3);
						HSSFCell classToRun=row.getCell(4);
						HSSFCell TestData=row.getCell(5);		
						//String testCaseID = formatter.formatCellValue(testcasecellid);
						 testCaseIDScan = TID;
						
					
						 Mod = formatter.formatCellValue(Modules); 
						 Cla = formatter.formatCellValue(classToRun);
						 TestDa = formatter.formatCellValue(TestData);
						
						
						k++;
						
						List<String> ls=new ArrayList<String>();
					
						
						map.put(TID, Mod);
						map.put(TID, Cla);
						map.put(TID, TestDa);
						
						
					
						 next=formatter.formatCellValue(sh.getRow(k).getCell(0));
						 
							}
							while(next.equalsIgnoreCase(""));
							
							

							Collection<String> values = map.get(TID);
							
						
						List<String> ls=new ArrayList<String>();
							
						Execute.run(map,TID,driver1,logger);
							 /*for(int p=1;p<=values.size();p++)
							 {
							
							ls1.add(Iterables.get(map.get(TID), p-1));
							
							
							System.out.println(TID+"->"+Iterables.get(map.get(TID), p-1));
							
							 }*/
							
							break;
						}
						else
						 {
							flag=false;
						    k++;
						 }

						}
						
					
					wb.close();
					logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
					//driver.close();
					extent.config().statusConfigurator();
				
			}
		    catch (Exception e)
		    {
		    	logger.log(Status.FAIL, " Getting the exception "+e.getMessage());
		    	//queryObjects.logStatus(driver,Status.FAIL,"------","----",e);
		    	extent.config().statusConfigurator();
				e.printStackTrace();
			
			}
		    
		} 
		 catch (Exception e) 
		 {
			 logger.log(Status.FAIL, " Getting the exception "+e.getMessage());
			// queryObjects.logStatus(driver,Status.FAIL,"------","----",e);
			//System.out.println ("Check config or scanario bank"+ e.getMessage());
			e.printStackTrace();
			extent.config().statusConfigurator();
			
		
		 }
		
	
		 
	 }
	 
	 //=========sanity===================
	 
	 @DataProvider(name="hybridDataRegression",parallel = true)
	 public Object[][] getDataFromDataproviderRegression(ITestContext context) throws IOException{
		 
		 Object[][]  object=null;
		 try
		 {
		
			 File file = new File(Prop_COPA);
				FileInputStream fs;
				
				
					fs = new FileInputStream(file);
					Properties prop=new Properties();
					prop.load(fs);
					fs.close();
					
					ScanarioBank=prop.getProperty("com.scenario.bank");
					ScanarioBank_Sheet=prop.getProperty("com.scenario.bank.sheet");
					ScanarioBank_suite=prop.getProperty("com.scenario.bank.suite");
					
		 
		 
			
				
				File SBank =    new File(ScanarioBank);
			    FileInputStream inputStreamScanarioBank = new FileInputStream(SBank);
			    
				//read the scanario bank
				DataFormatter formatter=new DataFormatter();
				wb=new HSSFWorkbook(inputStreamScanarioBank);
				sh=wb.getSheet(ScanarioBank_Sheet);
				
				
				/////////////////////
				
				for (String group : context.getIncludedGroups()) {

					//System.out.println("group : " + group);

					if (group.equalsIgnoreCase("Regression")) {
						////sanity
						
						//htmlReporter.config().setReportName("Regression cycle");
						for(int i=1;i<=sh.getLastRowNum();i++)
						{
							row=sh.getRow(i);
							testcasecellid=row.getCell(0);
							TestDecription=row.getCell(1);
							executioncell=row.getCell(4);
							browservar=row.getCell(2);;
							sanityvar=row.getCell(2);;
							testCaseID = formatter.formatCellValue(testcasecellid);
							exec = formatter.formatCellValue(executioncell); 
							desc = formatter.formatCellValue(TestDecription); 
						String brw=formatter.formatCellValue(browservar);
						String sanvar=formatter.formatCellValue(sanityvar);		
							TCID.put(testCaseID, exec);
							testdes.add(desc);
							Browser.add(brw);
							Sanity.add(sanvar);
						}
						wb.close();
						
						Set<String> testcaseid = TCID.keySet();
						List<String> testcaseidyes =new ArrayList<String>();
						List<String> Brovar =new ArrayList<String>();
						List<String> San =new ArrayList<String>();
						Collection<String> Status = TCID.values();
						
						int i=0;
						for(String myVal : Status) {
							//System.out.println(myVal);
								if(myVal.equalsIgnoreCase("n")) 
								  {
									i++;
									
								  }
								else
								{ // System.out.print(myVal+"->");
								String asd=testcaseid.toArray()[i].toString();
								testcaseidyes.add(asd);
								
								i++;
								}
						}
						int p=0;
						for(String myVal : Status) {
							//System.out.println(myVal);
								if(myVal.equalsIgnoreCase("n")) 
								  {
									p++;
									
								  }
								else
								{ // System.out.print(myVal+"->");
								String asd=testdes.get(p);
								testcaseidyes1.add(asd);
								p++;
								}
						}
						int s=0;
						for(String myVal : Status) {
							//System.out.println(myVal);
								if(myVal.equalsIgnoreCase("n")) 
								  {
									s++;
									
								  }
								else
								{ // System.out.print(myVal+"->");
								String asd=Browser.get(s);
								Brovar.add(asd);
								s++;
								}
						}
						/*int u=0;
						for(String myVal : Status) {
							//System.out.println(myVal);
								if(myVal.equalsIgnoreCase("n")) 
								  {
									u++;
									
								  }
								else
								{ // System.out.print(myVal+"->");
								String asd=Sanity.get(u);
								San.add(asd);
								u++;
								}
						}*/
				 
						  object=new Object[testcaseidyes.size()][3];
				for(int k=0;k<testcaseidyes.size();k++)
				{
				   /*for(int j=0;j<2;j++)	
				   {*/
					   object[k][0]= testcaseidyes.get(k);
					   object[k][1]=testcaseidyes1.get(k);
					   object[k][2]=Brovar.get(k);
					  // object[k][3]=San.get(k);
				   //}
				}
				 
			 break;
			 }
						
						
					else
					{
						//htmlReporter.config().setReportName("Sanity cycle");
						for(int i=1;i<=sh.getLastRowNum();i++)
						{
							row=sh.getRow(i);
							testcasecellid=row.getCell(0);
							TestDecription=row.getCell(1);
							executioncell=row.getCell(3);
							browservar=row.getCell(2);;
							sanityvar=row.getCell(2);;
							testCaseID = formatter.formatCellValue(testcasecellid);
							exec = formatter.formatCellValue(executioncell); 
							desc = formatter.formatCellValue(TestDecription); 
						String brw=formatter.formatCellValue(browservar);
						String sanvar=formatter.formatCellValue(sanityvar);		
							TCID.put(testCaseID, exec);
							testdes.add(desc);
							Browser.add(brw);
							Sanity.add(sanvar);
						}
						wb.close();
						
						Set<String> testcaseid = TCID.keySet();
						List<String> testcaseidyes =new ArrayList<String>();
						List<String> Brovar =new ArrayList<String>();
						List<String> San =new ArrayList<String>();
						Collection<String> Status = TCID.values();
						
						int i=0;
						for(String myVal : Status) {
							//System.out.println(myVal);
								if(myVal.equalsIgnoreCase("n")) 
								  {
									i++;
									
								  }
								else
								{ // System.out.print(myVal+"->");
								String asd=testcaseid.toArray()[i].toString();
								testcaseidyes.add(asd);
								
								i++;
								}
						}
						int p=0;
						for(String myVal : Status) {
							//System.out.println(myVal);
								if(myVal.equalsIgnoreCase("n")) 
								  {
									p++;
									
								  }
								else
								{ // System.out.print(myVal+"->");
								String asd=testdes.get(p);
								testcaseidyes1.add(asd);
								p++;
								}
						}
						int s=0;
						for(String myVal : Status) {
							//System.out.println(myVal);
								if(myVal.equalsIgnoreCase("n")) 
								  {
									s++;
									
								  }
								else
								{ // System.out.print(myVal+"->");
								String asd=Browser.get(s);
								Brovar.add(asd);
								s++;
								}
						}
						/*int u=0;
						for(String myVal : Status) {
							//System.out.println(myVal);
								if(myVal.equalsIgnoreCase("n")) 
								  {
									u++;
									
								  }
								else
								{ // System.out.print(myVal+"->");
								String asd=Sanity.get(u);
								San.add(asd);
								u++;
								}
						}*/
				 
						  object=new Object[testcaseidyes.size()][3];
				for(int k=0;k<testcaseidyes.size();k++)
				{
				   /*for(int j=0;j<2;j++)	
				   {*/
					   object[k][0]= testcaseidyes.get(k);
					   object[k][1]=testcaseidyes1.get(k);
					   object[k][2]=Brovar.get(k);
					  // object[k][3]=San.get(k);
				   //}
				}
					break;
					}
				}
		 }
	  catch(Exception e)
			{
		  System.err.println(e);
		  logger.log(Status.FAIL, "getting exception"+e);
		  
		 
		 
			}
			 return object;	
	 }
	
	/* @AfterTest(groups = {"Regression","Sanity"})
	 public void report()
	 {
		 Report.Func_Footer(StartFramework.rpt);
	 }
	*/
	 @AfterMethod(groups = {"Regression","Sanity"})
	 public void closeBrowser() throws IOException
	 {
		// Report.Func_Footer(StartFramework.Scanario,StartFramework.rpt);
		 try{
		// List<LogEntry> logEntries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		 try{
			driver.close();
			driver.quit();
		 }
		catch(Exception e){}
		extent.flush();
        File htmlFile = new File(SummaryReportFilePath);
        if(!htmlFile.exists())
        	htmlFile.createNewFile();
		// TafficRecord.network(NetorkTraffic,logEntries);
		 }
		 catch(Exception e){}
	 }
	 @AfterTest(groups = {"Regression","Sanity"})
	    public void endreport() throws IOException, URISyntaxException
	    { 
	        extent.config().statusConfigurator();
	         extent.flush();
	         File htmlFile = new File(SummaryReportFilePath);
	           ////sat
	         
	        // String source = "C:D:/Mphasis Framework/Mphasis/Reportreportpath+"\\Report1\\"+fileName+"\\Screenshots";
	         String source = reportpath+"\\Report1\\"+fileName+"/Screenshots";
	         File srcDir = new File(source);

	        // String destination = "C:D:/Mphasis Framework/Mphasis/Report/jenkinReport/Screenshots";
	         String destination = reportpath+"\\Report1\\"+"/jenkinReport/Screenshots";
	       //  Boolean dir1 = new File(destination).mkdirs();
	         File f = new File(destination);
	         if (f.exists() && f.isDirectory())
	         {
	               String[]entries = f.list();
	               for(String s: entries){
	                   File currentFile = new File(f.getPath(),s);
	                   currentFile.delete();
	               }      
	               f.delete();
	         }
	         if(!f.exists())
	         {
	               Boolean dir1 = new File(destination).mkdirs();
	         }
	         try {
	             FileUtils.copyDirectory(srcDir, f);
	                File jenkinsreportfile = new File(jenkinsreport);
	                if(jenkinsreportfile.exists())
	                {
	                	jenkinsreportfile.delete();
	                }
	                if(!jenkinsreportfile.exists())
	                {
	                	jenkinsreportfile.createNewFile();
	                }
	             FileUtils.copyFile(htmlFile, jenkinsreportfile);
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	      
	         
	         Desktop.getDesktop().browse(htmlFile.toURI());
	        
	                            }


	    
	 

}
