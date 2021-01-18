package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel_To_DProvider {

//	String FilePath= "./ReadFrom/CalcInput.xls";
	
	public Object[][] ReadAllExcel(String FilePath) throws IOException {
		// Access spreadsheet
//		System.out.println("==========================================\n Accessing spreadsheet and setting up Array\n===========================================");
		File myFile = new File(FilePath);
		FileInputStream myStream = new FileInputStream(myFile);
		HSSFWorkbook myWorkbook = new HSSFWorkbook(myStream);
		HSSFSheet mySheet = myWorkbook.getSheetAt(0);

		int numRows = mySheet.getLastRowNum() + 1;
		int numCols = mySheet.getRow(0).getLastCellNum();

		String[][] excelData = new String[numRows][numCols];

//		System.out.println("=================\n Populating Array \n=================");
		for (int i = 0; i < numRows; i++) {
			HSSFRow row = mySheet.getRow(i);

//			System.err.println("Next Row value");		//for test only
			for (int j = 0; j < numCols; j++) {
				HSSFCell cell = row.getCell(j);
				
//				String value = cell.getStringCellValue();
			//OR	
				String value = String.valueOf(cell);
				excelData[i][j] = value;
				
//				System.out.println("The value is: "+value);  //for test only
			}
		}
		return excelData;
		
//		//Print for test only
//		System.out.println("=========================\n Array population complete \n=========================");
//		//Loop for print
//		// 1- loop in 2D array [MyData] Rows. 
//		for (int i = 0; i < excelData.length; i++) {
//			String[] inner = excelData[i];
//
//			// 1- loop in 2D array [MyData] columns.
//			for (int j = 0; j < inner.length; j++) {
//				if (j == inner.length - 1)
//					System.out.print(excelData[i][j]);
//				else
//					System.out.print(excelData[i][j] + ",");
//			}
//			System.out.println();
//		}	
	
	}
}
