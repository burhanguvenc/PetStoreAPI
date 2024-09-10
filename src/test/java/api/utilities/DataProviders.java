package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1 
	@DataProvider(name="Data")
	public String[][] getData() throws IOException{
		String path = ".\\testData\\testData.xlsx"; //taking xl file from testData
		XLUtility xlutil = new XLUtility(path); 
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1",1);
		
		String apidata[][] = new String[totalrows][totalcols]; //Created for two dimension array which can store data

		for(int i=1; i<=totalrows;i++) {
			for(int j=0; j<totalcols;j++) {
				apidata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return apidata;
	}
	
	//DataProvider 2
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException{
		String path = ".\\testData\\testData.xlsx"; //taking xl file from testData
		XLUtility xlutil = new XLUtility(path); 
		
		int totalrows = xlutil.getRowCount("Sheet1");
		
		String apidata[] = new String[totalrows]; //Created for two dimension array which can store data

		for(int i=1; i<=totalrows;i++) {
			apidata[i-1] = xlutil.getCellData("Sheet1", i, 1);
		}
		return apidata;
	}

 	
	//DataProvider 3
	
	//DataProvider 4
}
