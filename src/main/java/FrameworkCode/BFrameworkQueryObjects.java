package FrameworkCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class BFrameworkQueryObjects
{
  static String Moduel = null;
  static String classname = null;
  static String testdclassnameatarow = null;
  static String TestData;
  static XSSFWorkbook TD = null;
  static XSSFSheet test = null;
  static XSSFRow row = null;
  static StringBuilder htmlBuilder = new StringBuilder();
  static String screenShotPath;
  
  public static void logStatus(WebDriver driver, Status status, String str1, String str2, Exception obj)
    throws IOException
  {
    try
    {
      Date strDate = new Date();
      Calendar cal = Calendar.getInstance();
      String sDate = new SimpleDateFormat("MMddyyyy").format(cal.getTime());
      String screenShotName = "Copa_" + sDate + RandomStringUtils.random(6, true, false) + ".png";
      if ((driver != null) && (testmethod.url != "")) {
        screenShotPath = CaptureScreenshot.capture(driver, screenShotName, StartFramework.child);
      }
      String stat = status.toString();
      if (stat.equalsIgnoreCase("info"))
      {
        if (obj != null)
        {
          StartFramework.child.log(Status.INFO, obj);
          StartFramework.child.info(str1 + "------>" + str2, MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/"+screenShotName).build());
        }
        else
        {
          StartFramework.child.info(str1 + "------>" + str2, MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/"+screenShotName).build());
        }
      }
      else if (stat.equalsIgnoreCase("pass")) {
        StartFramework.child.pass(str1 + "------>" + str2, MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/"+screenShotName).build());
      } else if (stat.equalsIgnoreCase("warning")) {
        StartFramework.child.warning(str1 + "------>" + str2, MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/"+screenShotName).build());
      } else if (stat.equalsIgnoreCase("skip")) {
        StartFramework.child.skip(str1 + "------>" + str2, MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/"+screenShotName).build());
      } else if (stat.equalsIgnoreCase("error")) {
        StartFramework.child.error(str1 + "------>" + str2, MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/"+screenShotName).build());
      } else if (stat.equalsIgnoreCase("debug")) {
        StartFramework.child.debug(str1 + "------>" + str2, MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/"+screenShotName).build());
      } else if (stat.equalsIgnoreCase("fatal")) {
        StartFramework.child.fatal(str1 + "------>" + str2, MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/"+screenShotName).build());
      } else if (stat.equalsIgnoreCase("fail")) {
        if (obj != null)
        {
          StartFramework.child.log(Status.FAIL, obj);
          
          StartFramework.child.fail(str1 + "------>" + str2, MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/"+screenShotName).build());
        }
        else
        {
          StartFramework.child.fail(str1 + "------>" + str2, MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/"+screenShotName).build());
        }
      }
    }
    catch (Exception localException) {}
  }
  
  public String getTestData(String colname)
    throws IOException
  {
    TestData = StartFramework.TestData;
    String str = null;
    File Tdata = new File(TestData);
    try
    {
      FileInputStream inputStreamTestdata = new FileInputStream(Tdata);
      
      DataFormatter formatter = new DataFormatter();
      TD = new XSSFWorkbook(inputStreamTestdata);
      test = TD.getSheet(testmethod.Moduel);
      int testdatarow = Integer.parseInt(testmethod.testdclassnameatarow);
      row = test.getRow(testdatarow - 1);
      
      int colNum = test.getRow(0).getLastCellNum();
      
      Cell cell = null;
      
      int j = 0;
      for (int i = 0; i < colNum; i++) {
        if (test.getRow(0).getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().equals(colname))
        {
          j = i;
          break;
        }
      }
      str = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    return str;
  }
  
  public static void suman()
  {
    ExtentTest child = null;
    Object kumar = child;
  }
}
