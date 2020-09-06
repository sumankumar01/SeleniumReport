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
		
		
		
	  //report.Func_Footer("TC1","login",driver);
		
	  report.ReportStep("TC1","login");
  }
  
  @Test
  public void g() throws InterruptedException {
		
	  Report.FailFlag=true;
	  report.ReportStep("TC2","home page");
		
	  
  }

  @AfterSuite
  public void afterSuite() {
	  
	  report.SummaryFooter();
  }

}
