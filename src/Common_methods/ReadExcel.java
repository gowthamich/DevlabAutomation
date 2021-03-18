package Common_methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;

public class ReadExcel {
	WebDriver driver;
	String ColumnValue1;
	CommonMethods objCommonMethods;
	Workbook ReadWorkBook = null;
	public Hashtable Datadict = new Hashtable();
	Sheet ReadDataSheet = null;
	String filePath ="Data//";
	String fileName = "data.xls";
	File file = new File (filePath+"/"+fileName);
	
	public ReadExcel (String ReadSheetName)throws IOException{
		FileInputStream inputStream = new FileInputStream(file);
		ReadWorkBook = new HSSFWorkbook(inputStream);
		ReadDataSheet = ReadWorkBook.getSheet(ReadSheetName);
		if(ReadSheetName.contentEquals("Common")){
			DataSheetDictionary();
		}	
		
	}
	public String ReadExcelData(String ColumnName) throws IOException{
 		String ColValue = Datadict.get(ColumnName).toString();
		return ColValue;		
	}
	
	public void SetCell(String val) throws IOException{
		for(int i=0;i<ReadDataSheet.getLastRowNum(); i++){
			String RowName = ReadCell(0,i);
			if(RowName.equals("DeleteFile")){
				String beforeset = ReadDataSheet.getRow(i).getCell(1).getStringCellValue();
				System.out.println("Before setting ----"+beforeset);
				ReadDataSheet.getRow(i).getCell(1).setCellValue(val);
				String afterset = ReadDataSheet.getRow(i).getCell(1).getStringCellValue();
				System.out.println("After setting ----"+afterset);
			}
			//String RowValue = ReadCell(1,row);
		}
	}
	public String ReadCell(int column, int row) throws IOException{
		return ReadDataSheet.getRow(row).getCell(column).getStringCellValue();
	}
	
	public void DataSheetDictionary()throws IOException{
		for(int row =0; row<=ReadDataSheet.getLastRowNum(); row++){			
			String RowName = ReadCell(0,row);
			String RowValue = ReadCell(1,row);
			Datadict.put(RowName, RowValue);
		}	
		//System.out.println(Datadict.toString());

	}
	
	public String ReadExcelDataS(String ColumnName) throws IOException{
		int rowCount = ReadDataSheet.getLastRowNum()- ReadDataSheet.getFirstRowNum();
		ReadExcel: for(int i=0; i<rowCount;i++){
			Row row = ReadDataSheet.getRow(i);
			for(int j=0; j<row.getLastCellNum(); j++){
				String ExpColumn = row.getCell(j).getStringCellValue();
				if(ExpColumn.equals(ColumnName)== true){
					ColumnValue1 = ReadDataSheet.getRow(i+1).getCell(j).getStringCellValue();
					return ColumnValue1;
				}				
			}		
			
		}
		return ColumnValue1;		
	}	

}
