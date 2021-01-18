package utils;

//Write data on Excel file
//=========================
//https://www.guru99.com/all-about-excel-in-selenium-poi-jxl.html

//	http://toolsqa.com/selenium-webdriver/data-driven-testing-excel-poi/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteInExcel_NewCell {

	public void writeExcel(String filePath, String fileName, String sheetName, int Countnumber, String dataToWrite) throws IOException {

		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);

		Workbook Excelfile = null;

		// Find the file extension by splitting file name in substring and
		// getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {
			Excelfile = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			Excelfile = new HSSFWorkbook(inputStream);
		}

		Sheet sheet = Excelfile.getSheet(sheetName);

//		==================================================		
			Row currentrow = sheet.getRow(Countnumber);
			
			int Lastcell = currentrow.getLastCellNum();
			Cell cell = currentrow.createCell(Lastcell-1); // <<< Need to check this code result with file without "Actual Result" column
			cell.setCellValue(dataToWrite);
//		==================================================		

			// Close input stream
			inputStream.close();

			// Create an object of FileOutputStream class to create write data in excel file
			FileOutputStream outputStream = new FileOutputStream(file);

			// write data in the excel file
			Excelfile.write(outputStream);

			// close output stream
			outputStream.close();
			System.out.println("The actual result updated to'" + fileName + "' successfully");
		}
	}


