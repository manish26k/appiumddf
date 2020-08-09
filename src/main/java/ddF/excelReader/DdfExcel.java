package ddF.excelReader;

import java.util.HashMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DdfExcel {
	
	Object[][] data=null;
	
	public Object[][] getExcelData(String excellocation, String sheetName) throws FilloException{
		
		Fillo fillo = new Fillo();
		Connection connection=fillo.getConnection(excellocation);
		HashMap<String,String> datatable = null; //key value   key=col name value =cell value row by row
		String strQuery= "Select * from Sheet1";
		Recordset rs=connection.executeQuery(strQuery); // it will execute the query and fect the record set.
		
		int i=0; // row= 0 start
		data =  new Object[rs.getCount()][1]; 
		System.out.println("the counts are"+"------>"+ data);
		
		
		while(rs.next()) {
			datatable =  new HashMap<String, String >();
			for(String col : rs.getFieldNames()) {
				datatable.put(col,rs.getField(col));
			}
			
			data[i][0]= datatable;
			i++;						
		}
		
		return data;
	}
	
	
	
	
	/*public static Object[][] getLocatorExcel(String key) throws FilloException {
		
		Object[][] data=null;		
		
		Fillo fillo = new Fillo();
		Connection connection=fillo.getConnection("./KeywordFrameworkTestData/TestSuite.xlsx");
		HashMap<String, String> datatable = new HashMap<String, String>() ;
		String strQuery="Select * from TC01 where Keyword='"+key+"'";
	     
	    Recordset rs=connection.executeQuery(strQuery);
	      
		data =  new Object[rs.getCount()][1]; 
		
		//Object[] elementName =  new Object[rs.getCount()][2]; 
		
		Object[] mobileLocator =  new Object[rs.getCount()][3]; // Mobileelement
		
		Object[] testValue  =  new Object[rs.getCount()][5]; //TestDatavalue
		
		System.out.println("the counts are"+"------>"+ data);
	    
	    
		for (int i=0; i<=mobileLocator.length;i++) {
			
			datatable.put((String)mobileLocator[i],(String)testValue[i]);
			System.out.println();
			
		}
		return data;
	}*/
	
	

}
