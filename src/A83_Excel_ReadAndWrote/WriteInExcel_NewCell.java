package A83_Excel_ReadAndWrote;

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

	public void writeExcel(String filePath, String fileName, String sheetName, String dataToWrite) throws IOException {

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

//		int numRows = testData_RowCount;
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		// =======================================
		for (int i = 1; i < rowCount+1; i++) {// If excel file have title in 1strow so i=1 if not i=0

			Row currentrow = sheet.getRow(i);
			
			int Lastcell = currentrow.getLastCellNum();
			Cell cell = currentrow.createCell(Lastcell);
			cell.setCellValue(dataToWrite);
		

			// Close input stream
			inputStream.close();

			// Create an object of FileOutputStream class to create write data in excel file
			FileOutputStream outputStream = new FileOutputStream(file);

			// write data in the excel file
			Excelfile.write(outputStream);

			// close output stream
			outputStream.close();
			System.out.println("The value added to '" + fileName + "' successfully");
		}
	}

	public static void main(String... strings) throws IOException {

		// Create an array with the data in the same order in which you expect
		// to be filled in excel file
		// String[] valueToWrite = { "Mr. E", "Noida" };

		// Create an object of current class
		WriteInExcel_NewCell objExcelFile = new WriteInExcel_NewCell();

		// Write the file using file name, sheet name and the data to be filled
		objExcelFile.writeExcel("D:\\eclips\\Work_Space\\Tutorial\\ReadFrom", "Test_Data_sheet.xls", "Sheet1","Successfully");

	}

}
