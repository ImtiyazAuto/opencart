package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataprovider_class {
	String file=System.getProperty("user.dir")+"/testData/Book1.xlsx";
	
	@DataProvider(name="logind")
	public String[][] read() throws IOException{
		Excel_reading_class xl=new Excel_reading_class(file);
		int r=xl.totalRows("Sheet1");
		int c=xl.totalCell("Sheet1");
		String logindata[][]=new String[r][c];
		for(int i=1;i<=r;i++) {
			for(int j=0;j<c;j++) {
				logindata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;
		
	}
	

}
