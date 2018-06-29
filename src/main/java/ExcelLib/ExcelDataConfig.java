package ExcelLib;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	 


public class ExcelDataConfig {
	
	XSSFWorkbook workBook;
	 XSSFSheet sheet;
	 
	public ExcelDataConfig(String excelPath){
		
		try {
			
			File file = new File(excelPath);

			FileInputStream inputStreem = new FileInputStream(file);
			
			workBook = new XSSFWorkbook(inputStreem);
			
			sheet = 	workBook.getSheetAt(0) ;
			
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		}
	
	public String getDataa(int sheetNo, int rowno , int colNo) {
		
		DataFormatter formatter = new DataFormatter();
		Cell cell = sheet.getRow(rowno).getCell(colNo);
		String result = formatter.formatCellValue(cell);
	
		return result;
		
	}
	

	public int getRowNum(int SheetIndex) {
		
		
		int totalRow =  workBook.getSheetAt(SheetIndex).getLastRowNum();
		
		totalRow = totalRow + 1;
		
		
		return totalRow;
		
		
	}


}