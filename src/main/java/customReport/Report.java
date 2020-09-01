package customReport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Report {
	public static  File SummaryReportFilePath1;
	static String fileName="";
	static String fileName1="";
	public static  Boolean flag;
	public static int Scanariocount;
	 public static Boolean FailFlag=false;
	 static String reportpath=System.getProperty("user.dir")+"\\target";
	public Report() {
		
		//System.out.println(System.getProperty("user.dir") + "/target");
		//System.out.println(System.getProperty("user.dir"));
		
		
	 String errorMessage;

		List<String> stepslist = new ArrayList<String>();

         fileName = new SimpleDateFormat("dd-MM-YYYY").format(new Date());
         fileName1 = new SimpleDateFormat("dd-MM-YYYY-HHmmss").format(new Date());
		Date strDate = new Date();
		Boolean dir = new File(reportpath+"\\Report\\" + fileName)
						.mkdirs();
		
		Boolean dir1 = new File(reportpath+"\\Report\\" + fileName+"//Screenshot")
				.mkdirs();
		
		 String SummaryReportFilePath2 = reportpath+"\\Report\\"+fileName+"\\"
			+ fileName1 + ".html";
	  SummaryReportFilePath1 = new File(SummaryReportFilePath2);

		 Boolean flag;

	}

	public static Date strDate = new Date();

	public Properties DICTVal;
	public static int intTestCaseCount = 0;
	public static int intPassTCCount = 0;
	public static int intFailTCCount = 0;
	public static Boolean Flag = true;
	public static long strstarttime;
	public static Boolean bool = true;
	public static int i;
	public static String indReportFilePath;
	public static String duplicateStep = "";

	public static void CreateSummaryHeader() {

		BufferedWriter bw = null;
		FileWriter fw = null;
		strstarttime = System.currentTimeMillis();
		Boolean flag = true;
		try {

			// String content = "This is the content to write into file\n";
			StringBuilder htmlStringBuilder = new StringBuilder();
			fw = new FileWriter(SummaryReportFilePath1, true);
			bw = new BufferedWriter(fw);
			// bw.write(content);
			if (bool) {
				bw.write("<!DOCTYPE html>");
				bw.write("<html>");
				bw.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
				bw.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">");
				// bw.write( "<body
				// background=\"C:/AFT/Configs/download.jpg\">");
				bw.write("<body>");
				bw.write("<div class=\"w3-container w3-teal\">");
				bw.write("<h1>Automation Execution Reports</h1>");
				bw.write("<h2>Execution Date:" + strDate + "</h2>");
				bw.write("</div>");
				bw.write("<div class=\"w3-container\">");
				bw.write("<table class=\"w3-table-all\">");
				bw.write("<tr>");
				bw.write("<th>Scanario</th>");
				bw.write("<th>Description</th>");
				bw.write("<th>Result</th>");
				bw.write("</tr>");
				// bw.write("<tr>");
				/*
				 * bw.write("<td>"+def+"</td>");
				 * bw.write("<td>"+testcaseName+"</td>");
				 * 
				 * bw.write("</tr>");
				 * 
				 * bool=false; } else {
				 * 
				 * bw.newLine(); bw.write("<tr>"); bw.write("<td>"+def+"</td>");
				 * bw.write("<td>"+testcaseName+"</td>"); bw.write("</tr>");
				 */

				// System.out.println("Done");
			}
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}


	public static void Func_Footer(String Scanario, String TCNAME,WebDriver driver) {
		BufferedWriter bw = null;
		BufferedWriter bw1 = null;
		FileWriter fw = null;
		FileWriter fw1 = null;
		try {
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String  screenshotname = new SimpleDateFormat("dd-MM-YYYY-HHmmss").format(new Date()); 
			FileUtils.copyFile(scrFile, new File(reportpath+"\\Report\\" + fileName+"\\Screenshot\\"+screenshotname+".png"));
  
			fw1 = new FileWriter(SummaryReportFilePath1, true);
			bw1 = new BufferedWriter(fw1);
			// indReportFilePath
			// bw1.write("<tr>");

			intTestCaseCount = intTestCaseCount + 1;
			// intPassTCCount = intPassTCCount+1;
			bw1.write("<td>" + Scanario + "</td>");
			bw1.write("<td>" + TCNAME + "</td>");
			if (FailFlag == true) {
				bw1.write("<td><a href=Screenshot//" + screenshotname+".png" + "><font color=\"green\">PASS</font></a></td>");
				intPassTCCount = intPassTCCount + 1;
			} else {
				bw1.write("<td><a href=Screenshot//" + screenshotname+".png" + "><font color=\"red\">FAIL</font></a></td>");
				intFailTCCount = intFailTCCount + 1;
			}
			bw1.write("</tr>");
			try {

				if (bw1 != null)
					bw1.close();

				if (fw1 != null)
					fw1.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	public void ReportStepWebServices(String TCName, String RequestXml, String ResponseXml, String Status) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			String TCNAME = StringUtils.replace(TCName, "_TD1", "");
			String indReportFilePath = "//Reports/SummaryTestReport_1" + fileName + "/HTML/" + TCNAME
					+ "TestReport_" + fileName + ".html";
			fw = new FileWriter(indReportFilePath, true);
			bw = new BufferedWriter(fw);
			bw.write("<tr>");
			bw.write("<td>" + TCName + "</td>");
			bw.write("<td>" + RequestXml + "</td>");
			bw.write("<td>" + ResponseXml + "</td>");
			bw.write("<td>" + Status + "</td>");
			if (Status == "FAIL") {
				Flag = false;
			}
			// oFile.WriteLine "<td><a
			// href="&".\Screenshots\TRR_"&strTimeStamp&".png"&">"&strActual&"</a></td>"
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	}

	public static void SummaryFooter() {
		BufferedWriter bw = null;
		FileWriter fw = null;
		long timetaken = 0;
		try {
			long endtime = System.currentTimeMillis();
			timetaken = endtime - strstarttime;
			fw = new FileWriter(SummaryReportFilePath1, true);
			bw = new BufferedWriter(fw);
			bw.write("</table>");
			bw.write("</div>");
			bw.write(" </div>");

			bw.write("<div class=\"w3-container w3-teal\">");
			bw.write("<p>Total execution time :" + timetaken + " Milliseconds </p>");
			bw.write("<tr>");
			bw.write("<td>Number of Test cases executed :" + intTestCaseCount + " </td>");
			bw.write("</tr>");
			bw.write("<tr>");
			bw.write("<td>Number of Test cases Passed :" + intPassTCCount + " </td>");
			bw.write("</tr>");
			bw.write("<tr>");
			bw.write("<td>Number of test cases Failed :" + intFailTCCount + "</td>");
			bw.write("</tr>");
			bw.write("</div>");
			bw.write("</html>");

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
