package Runner;

import org.testng.annotations.Test;


import customReport.Report;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class run {
	Report report=new Report();
	WebDriver driver;
  @BeforeSuite
  public void beforeMethod() {
	  
	  report.CreateSummaryHeader();
  }

  @Test
  public void f() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "D:/Selenium Software/chromedriver.exe");
		
		 driver=new ChromeDriver();
		driver.get("https://www.linkedin.com/feed/");;
		/*FlashObjectWebDriver fl=new FlashObjectWebDriver(driver, "");
		//FlexUISelenium flex=new FlexUISelenium(driver, "");
		//FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "__symantecPKIClientMessenger");
  		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "myFlashMovie");
		//FlashSelenium flashApp=new FlashSelenium(driver, "__symantecPKIClientMessenger");
		driver.get("http://demo.guru99.com/test/flash-testing.html");;
		Thread.sleep(5000);	
		
		//flashApp.callFlashObject(functionName, args)
	  	flashApp.callFlashObject("Play");			
	  	Thread.sleep(5000);		
		flashApp.callFlashObject("StopPlay");*/
		
	  report.Func_Footer("TC1","login",driver);
		
	  
  }
  
  @Test
  public void g() throws InterruptedException {
		
		
	  report.Func_Footer("TC2","home page",driver);
		
	  
  }

  @AfterSuite
  public void afterSuite() {
	  
	  report.SummaryFooter();
  }

}
