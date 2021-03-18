package Common_methods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetLibrary {
	
	static Workbook wrkbook = null;
	static Sheet wrksheet;
	static Hashtable dict = new Hashtable();
	static Hashtable flaggedMethod = new Hashtable();	
	
	public ExcelSheetLibrary(String ExcelSheetPath) throws IOException{
		
		FileInputStream inputStream = new FileInputStream(ExcelSheetPath);
		wrkbook = new HSSFWorkbook(inputStream);
		wrksheet = wrkbook.getSheet("Driver");
		ColumnDictionary();			
		
	}
	public static void ColumnDictionary(){
		for(int col = 0; col< wrksheet.getRow(1).getLastCellNum();col++){
			dict.put(ReadCell(col,0),col);
			
		}		
	}
	public static int RowCount(){
		return (wrksheet.getLastRowNum()- wrksheet.getFirstRowNum());
	}
	public static String ReadCell(int column, int row){
		return wrksheet.getRow(row).getCell(column).getStringCellValue();
		
	}
	public static String ReadCell(String columnname,int row){
		return ReadCell(GetCell(columnname),row);
		
	}
	public static int GetCell(String colName){
		try{
			int value;
			value = ((Integer)dict.get(colName)).intValue();
			return value;
			
		}catch(NullPointerException e){
			return (0);
		}	
		
	}
	public static Hashtable GetFlaggedMethods(String ColumnName){
		try{
			ColumnDictionary();
			int methodcount = 1;
			for(int row = 1;row <= RowCount();row++){
				if(ReadCell(ColumnName,row).equals("Y")){
					flaggedMethod.put(methodcount,  ReadCell("MethodName",row) + ";"+ ReadCell("ClassName",row));
					methodcount++;
				}
				
			}
			
		}catch (Exception e){
			
		}
		return flaggedMethod;
	}

}
