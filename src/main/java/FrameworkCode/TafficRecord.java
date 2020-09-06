package FrameworkCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.logging.LogEntry;

public class TafficRecord {
	
	
	public static void network(File NetorkTraffic,List<LogEntry> logEntries) throws IOException
	{
		//File file=new File(NetorkTraffic);
		
		Boolean bol=NetorkTraffic.createNewFile();
		
		 FileWriter fw = new FileWriter(NetorkTraffic);
         BufferedWriter bw = new BufferedWriter(fw);
		for(int i=0;i<logEntries.size();i++)
    	{
        JSONObject messageJSON;
        String k=logEntries.get(i).getMessage();
       // System.out.println(k);
       bw.write(k);
        bw.write("\n/n");
		try {
			//messageJSON = new JSONObject(logEntries.get(i).toString().trim());
			String abc=logEntries.get(i).toString();
			messageJSON = new JSONObject(abc.substring(abc.indexOf('{')));
			String method = messageJSON.getJSONObject("message").getString("method").toString();
			bw.write(messageJSON.toString());
			if(method.equalsIgnoreCase("Network.webSocketFrameSent")){
               // System.out.println("Message Sent: " + messageJSON.getJSONObject("message").getJSONObject("params").getJSONObject("response").getString("payloadData"));
                bw.write("Message Sent: " + messageJSON.getJSONObject("message").getJSONObject("params").getJSONObject("response").getString("payloadData"));
			}else if(method.equalsIgnoreCase("Network.webSocketFrameReceived")){
                //System.out.println("Message Received: " + messageJSON.getJSONObject("message").getJSONObject("params").getJSONObject("response").getString("payloadData"));
                bw.write("Message Received: " + messageJSON.getJSONObject("message").getJSONObject("params").getJSONObject("response").getString("payloadData"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
        
    	}
		bw.close();
	}	
	

}
