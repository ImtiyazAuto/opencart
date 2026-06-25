package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_reading_class {
	FileInputStream fi;
	FileOutputStream fo;
	XSSFWorkbook wr;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    String file;
    public Excel_reading_class(String file) {
    	this.file=file;
    	
    }
    
    public int  totalRows(String sheetname) throws IOException {
    	fi=new FileInputStream(file);
    	wr=new XSSFWorkbook(fi);
    	sheet=wr.getSheet(sheetname);
    	int row=sheet.getLastRowNum();
    	fi.close();
		wr.close();
    	return row;
    	
    }
    public int totalCell(String sheetname) throws IOException {
    	fi=new FileInputStream(file);
    	wr=new XSSFWorkbook(fi);
    	sheet=wr.getSheet(sheetname);
    	row=sheet.getRow(0);
    	int cell=row.getLastCellNum();
    	fi.close();
		wr.close();
		return cell;
    	
    }
    public String   getCellData(String sheetname,int r,int c) throws IOException {
    	fi=new FileInputStream(file);
    	wr=new XSSFWorkbook(fi);
    	sheet=wr.getSheet(sheetname);
    	row=sheet.getRow(r);
    	cell=row.getCell(c);
    	String value;
    	try {
    		
    	value=cell.toString();
    	}
    	catch(Exception e) {
    		value="";
    		
    	}
    	fi.close();
		wr.close();
		return value;
    	
    }
    public  void write(String sname,int r,int c,String data) throws IOException {
		fi=new FileInputStream(file);
		wr=new XSSFWorkbook(fi);
		sheet=wr.getSheet(sname);
		row=sheet.getRow(r);
		cell=row.createCell(c);
		cell.setCellValue(data);
		fo=new FileOutputStream(file);
		wr.write(fo);
		fo.close();
		wr.close();
		fi.close();
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}















