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
				bw.write("<script>\r\n" + 
						"					function ScanarioFunction() {\r\n" + 
						"					// Declare variables\r\n" + 
						"					var input, filter, table, tr, td, i, txtValue;\r\n" + 
						"					input = document.getElementById(\"ScanarioInput\");\r\n" + 
						"					filter = input.value.toUpperCase();\r\n" + 
						"					table = document.getElementById(\"myTable\");\r\n" + 
						"					tr = table.getElementsByTagName(\"tr\");\r\n" + 
						"					// Loop through all table rows, and hide those who don't match the search query\r\n" + 
						"					for (i = 0; i < tr.length; i++) {td = tr[i].getElementsByTagName(\"td\"\r\n" + 
						"						)[0];if (td) {txtValue = td.textContent || td.innerText;if (txtValue.toUpperCase().indexOf(filter) > -1) {\r\n" + 
						"						tr[i].style.display = \"\";\r\n" + 
						"						} else {\r\n" + 
						"						tr[i].style.display = \"none\";\r\n" + 
						"						}\r\n" + 
						"						}\r\n" + 
						"						}\r\n" + 
						"						}\r\n" + 
						"						function DescriptionFunction() {\r\n" + 
						"						// Declare variables\r\n" + 
						"						var input, filter, table, tr, td, i, txtValue;\r\n" + 
						"						input = document.getElementById(\"DescriptionInput\");\r\n" + 
						"						filter = input.value.toUpperCase();\r\n" + 
						"						table = document.getElementById(\"myTable\");\r\n" + 
						"						tr = table.getElementsByTagName(\"tr\");\r\n" + 
						"						// Loop through all table rows, and hide those who don't match the search query\r\n" + 
						"						for (i = 0; i < tr.length; i++) {td = tr[i].getElementsByTagName(\"td\"\r\n" + 
						"							)[1];if (td) {txtValue = td.textContent || td.innerText;if (txtValue.toUpperCase().indexOf(filter) > -1) {\r\n" + 
						"							tr[i].style.display = \"\";\r\n" + 
						"							} else {\r\n" + 
						"							tr[i].style.display = \"none\";\r\n" + 
						"							}\r\n" + 
						"							}\r\n" + 
						"							}\r\n" + 
						"							}\r\n" + 
						"							function ResultFunction() {\r\n" + 
						"							// Declare variables\r\n" + 
						"							var input, filter, table, tr, td, i, txtValue;\r\n" + 
						"							input = document.getElementById(\"ResultInput\");\r\n" + 
						"							filter = input.value.toUpperCase();\r\n" + 
						"							table = document.getElementById(\"myTable\");\r\n" + 
						"							tr = table.getElementsByTagName(\"tr\");\r\n" + 
						"							// Loop through all table rows, and hide those who don't match the search query\r\n" + 
						"							for (i = 0; i < tr.length; i++) {td = tr[i].getElementsByTagName(\"td\"\r\n" + 
						"								)[2];if (td) {txtValue = td.textContent || td.innerText;if (txtValue.toUpperCase().indexOf(filter) > -1) {\r\n" + 
						"								tr[i].style.display = \"\";\r\n" + 
						"								} else {\r\n" + 
						"								tr[i].style.display = \"none\";\r\n" + 
						"								}\r\n" + 
						"								}\r\n" + 
						"								}\r\n" + 
						"								}\r\n" + 
						"							</script>");
				bw.write("<body>");
				bw.write("<div class=\"w3-container w3-teal\">");
				bw.write("<h1>Automation Execution Reports</h1>");
				bw.write("<h2>Execution Date:" + strDate + "</h2>");
				bw.write("</div>");
				bw.write("<div class=\"w3-container\">");
				bw.write("<table class=\"w3-table-all\" id=\"myTable\">");
				bw.write("<tr>");
				bw.write("<th>Scanario<input type=\"text\"\r\n" + 
						"     													id=\"ScanarioInput\"\r\n" + 
						"     													onkeyup=\"ScanarioFunction()\"\r\n" + 
						"     													placeholder=\"Search for Scanario..\"></th>");
				bw.write("<th>Description<input type=\"text\"\r\n" + 
						"     														id=\"DescriptionInput\"\r\n" + 
						"     														onkeyup=\"DescriptionFunction()\"\r\n" + 
						"     														placeholder=\"Search for Description..\"</th>");
				bw.write("<th>Result<input type=\"text\"\r\n" + 
						"     															id=\"ResultInput\"\r\n" + 
						"     															onkeyup=\"ResultFunction()\"\r\n" + 
						"     															placeholder=\"Search for result..\"></th>");
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


	public static void ReportStep(String Scanario, String TCNAME,WebDriver driver) {
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
			 bw1.write("<tr>");

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
	public static void ReportStep(String Scanario, String TCNAME) {
		BufferedWriter bw = null;
		BufferedWriter bw1 = null;
		FileWriter fw = null;
		FileWriter fw1 = null;
		try {
			
			
  
			fw1 = new FileWriter(SummaryReportFilePath1, true);
			bw1 = new BufferedWriter(fw1);
			// indReportFilePath
			bw1.write("<tr>");

			intTestCaseCount = intTestCaseCount + 1;
			// intPassTCCount = intPassTCCount+1;
			bw1.write("<td>" + Scanario + "</td>");
			bw1.write("<td>" + TCNAME + "</td>");
			if (FailFlag == true) {
				bw1.write("<td><font color=\"green\">PASS</font></td>");
				intPassTCCount = intPassTCCount + 1;
			} else {
				bw1.write("<td><font color=\"red\">FAIL</font></td>");
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
			
			
			bw.write("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">\r\n" + 
					"// Load google charts\r\n" + 
					"google.charts.load('current', {'packages':['corechart']});\r\n" + 
					"google.charts.setOnLoadCallback(drawChart);\r\n" + 
					"\r\n" + 
					"// Draw the chart and set the chart values\r\n" + 
					"function drawChart() {\r\n" + 
					"  var data = google.visualization.arrayToDataTable([\r\n" + 
					"  ['STATUS', 'EXECUTION STATUS'],\r\n" + 
					"  ['PASS',"+intPassTCCount+"],\r\n" + 
					"  ['FAIL',"+intFailTCCount+"]\r\n" + 
					"]);\r\n" + 
					"\r\n" + 
					"  // Optional; add a title and set the width and height of the chart\r\n" + 
					"  var options = {'title':'Execution status total test case', 'width':550, 'height':400};\r\n" + 
					"\r\n" + 
					"\r\n" + 
					" var piechart_options = {'title':'Execution status total test case',\r\n" + 
					"                       width:400,\r\n" + 
					"                       height:300};\r\n" + 
					"        var piechart = new google.visualization.PieChart(document.getElementById('piechart_div'));\r\n" + 
					"        piechart.draw(data, piechart_options);\r\n" + 
					"\r\n" + 
					"        var barchart_options = {'title':'Execution status total test case',\r\n" + 
					"                       width:400,\r\n" + 
					"                       height:300,\r\n" + 
					"                       legend: 'none'};\r\n" + 
					"        var barchart = new google.visualization.BarChart(document.getElementById('barchart_div'));\r\n" + 
					"        barchart.draw(data, barchart_options);\r\n" + 
					"\r\n" + 
					"  // Display the chart inside the <div> element with id=\"piechart\"\r\n" + 
					"  var chart = new google.visualization.PieChart(document.getElementById('piechart'));\r\n" + 
					"  chart.draw(data, options);\r\n" + 
					"}\r\n" + 
					"</script>");
			bw.write(" <table class=\"columns\">\r\n" + 
					"      <tr>\r\n" + 
					"        <td><div id=\"piechart_div\" style=\"border: 1px solid #ccc\"></div></td>\r\n" + 
					"        <td><div id=\"barchart_div\" style=\"border: 1px solid #ccc\"></div></td>\r\n" + 
					"      </tr>\r\n" + 
					"    </table>");
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
