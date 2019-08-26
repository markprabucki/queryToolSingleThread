package com.util;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.HashMap;
public class queryToolSingleThread 
{
   private static java.io.FileWriter outfile;
   private static java.io.PrintWriter pw;	
   public static void main(String[] args)  {

      try 
      {
         queryToolSingleThread();
      }
      catch (Exception e)
      {
         System.err.println("Error: " + e.getMessage());
      }
  }

  private static void queryToolSingleThread() throws Exception
  {

	    String driverName = "oracle.jdbc.driver.OracleDriver";
	    int vsmCounter = 0;
	    int bmCounter = 0;
	    int progressCounter = 0;
	  	int writeCount = 0;
        int foundCount = 0;
		
		String inFile1 = "input-1.txt";
		String inFile2 = "input-2.txt";
		String outFile = "report.txt";    
	    try {
	    	Class.forName(driverName);
/*
	    	String serverName = "127.0.0.2";
	        String portNumber = "1573";
	        String sid = "MySID";
	        String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
	        String username = "MyUserName";
	        String password = "MyPassword";
	        connection = DriverManager.getConnection(url, username, password);
	        System.out.println("Connection successful!");
	        Statement stmt = connection.createStatement ();
*/
	    	
	        String inputFileName1 = inFile1;
	        String inputFileName2 = inFile2;	        
	        String outputFileName = outFile;
	        
	        outfile = new java.io.FileWriter(outputFileName);	        
	        pw = new java.io.PrintWriter(outfile);
	        
	        FileInputStream infstream1 = new FileInputStream(inFile1);
	        FileInputStream infstream2 = new FileInputStream(inFile2);
	        
	        DataInputStream inStream1 = new DataInputStream(infstream1);
	        BufferedReader br1 = new BufferedReader(new InputStreamReader(inStream1));
	        
	        DataInputStream inStream2 = new DataInputStream(bmfstream);
	        BufferedReader brbm = new BufferedReader(new InputStreamReader(inbm));
	        
	        String strLine = "";
	        String sku = "";
	        String product = "";

	        HashMap hashmap = new HashMap(); 
         
	        while ((strLine = br1.readLine()) != null)   
	        {
	           product = strLine.substring(0, 8);
	           sku = strLine.substring(8,16);
	        }

	        while ((strLine = br2.readLine()) != null) {
	 	       sku = strLine.substring(1,10).replace('"', ' ').trim();	
	 	       statusCode = strLine.substring(91,93);
	           myData = sku + statusCode;
	           if(hashmap.containsKey(sku))
	           {	        	   
	        	   String hashMapValue = (String)hashmap.get(sku);
	        	   hashMapValue = hashMapValue.trim();
	        	   if(!hashMapValue.equalsIgnoreCase(myData)){
	        		   String outdata = "SKU:," + sku + myData;
	        		   pw.write(outdata + "\n");
	        	       writeCount++;	   
	        	   }

	           }
	        Thread.sleep(10000);
	        inFile2.close();
	        inFile1.close();	
	        pw.close();
	    } catch (ClassNotFoundException e) {
	        System.out.println("Could not find database Driver");
	    }
        catch (Exception e)
        {
           System.err.println("Error: " + e.getMessage());
        }	    
	    finally {
	    }
  }  
}

