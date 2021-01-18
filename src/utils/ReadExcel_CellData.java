package utils;

//Script Reference (Eng.Mhmoud) Test_Pro course
//This method read from excelfile.xlsx only

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel_CellData {

	private File src;
	private FileInputStream fis;
	private Workbook wb;

	public ReadExcel_CellData(String filePath, String fileName) {
		src = new File(filePath + "\\" + fileName);
		try {
			fis = new FileInputStream(src);
		
			// Find the file extension by splitting file name in substring and getting only extension name
			String fileExtensionName = fileName.substring(fileName.indexOf("."));

			if (fileExtensionName.equals(".xlsx")) {
				wb = new XSSFWorkbook(fis);
			} else if (fileExtensionName.equals(".xls")) {
				wb = new HSSFWorkbook(fis);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getCellStringData(int sheetindex, int rownum, int colnum) {

		return wb.getSheetAt(sheetindex).getRow(rownum).getCell(colnum).getStringCellValue();
	}

	public int getCellNumericData(int sheetindex, int rownum, int colnum) {

		return (int) wb.getSheetAt(sheetindex).getRow(rownum).getCell(colnum).getNumericCellValue();
	}

	public int getRowCount(int sheetindex) {
		return wb.getSheetAt(sheetindex).getLastRowNum();
	}

	public int getColCount(int sheetindex, int rownum) {
		return wb.getSheetAt(sheetindex).getRow(rownum).getLastCellNum();
	}

}
