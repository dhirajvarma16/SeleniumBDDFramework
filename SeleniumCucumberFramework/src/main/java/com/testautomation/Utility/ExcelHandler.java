package com.testautomation.Utility;

import java.io.File;
import java.util.Map;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.util.TreeMap;

public class ExcelHandler {

public static Map<String,String> getTestDataInMap(String testDataFile,String sheetName,String TestCaseId) throws Exception
{
	Map<String,String> TestDataInMap=new TreeMap<String,String>();
	String query=null;
	query=String.format("Select * from %s where Run='Yes' and TestCaseId='%s'", 
			sheetName, TestCaseId);
	 Fillo fillo=new Fillo();
	 Connection conn=null;
	 Recordset	recordset=null;
	 try {
		 conn=fillo.getConnection(testDataFile);
		 recordset=conn.executeQuery(query);
		 while(recordset.next()){
			
			 for(String field:recordset.getFieldNames()) {
				 TestDataInMap.put(field,recordset.getField(field));
			 }
			 
		 }
	} catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Test data cannot find...");
	}
	 conn.close();
	 return TestDataInMap;
	
}
	
}
