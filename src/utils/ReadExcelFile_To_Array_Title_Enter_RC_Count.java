package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile_To_Array_Title_Enter_RC_Count {

	public Object[][] readExcel(String filePath, String fileName, String sheetName, int testData_RowCount, int testData_clumnCount) throws IOException {

		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);

		Workbook Excelfile = null;

		// Find the file extension by splitting file name in substring and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {
			Excelfile = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			Excelfile = new HSSFWorkbook(inputStream);
		}

		Sheet ExcelSheet = Excelfile.getSheet(sheetName);

		int numRows = testData_RowCount;
		int numCols = testData_clumnCount;
		
		System.out.println("The number for Rows is :"+numRows); //For tester view
		System.out.println("The number for Column is :"+numCols);//For tester view
		String[][] excelData = new String[numRows][numCols];

		// Create a loop over all the rows of excel file to read it
		// for (int i = 0; i < numRows ; i++) { //If excel file NOT have title.
		for (int i = 1; i < numRows; i++) {// If excel file have title in 1st row.
			Row row = ExcelSheet.getRow(i);

			// Create a loop to print cell values in a row
			for (int j = 0; j < numCols; j++) {

				Cell cell = row.getCell(j);

				// Create DataFormatter to get excel data regardless its data type
				DataFormatter formatter = new DataFormatter();

				// Add current cell value in array
				String value = formatter.formatCellValue(cell);
				excelData[i - 1][j] = value;
				System.out.println(excelData[i - 1][j]); // For Tester
			}

		}
		return excelData;
	}

}
