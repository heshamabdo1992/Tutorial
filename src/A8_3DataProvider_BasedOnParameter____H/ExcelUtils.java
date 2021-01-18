package A8_3DataProvider_BasedOnParameter____H;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	

	// This method is to set the File path and to open the Excel file, Pass Excel Path and Sheet name as Arguments to this method

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {
			throw (e);
		}

	}
	// *** Steps 3 ***
	public static Object[][] getTableArray(String FilePath, String SheetName, ArrayList<Integer> iTestCaseRow) throws Exception

	{
		String[][] tabArray = null;
		
		try {
			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startCol = 1;
			int ci = 0, cj = 0;
			int totalRows = iTestCaseRow.size();

			int totalCols = 3;

			tabArray = new String[totalRows][totalCols];
			for (int k = 0; k < iTestCaseRow.size(); k++) {
				
				for (int j = startCol; j < totalCols; j++, cj++){
					tabArray[ci][cj] = getCellData(iTestCaseRow.get(k), j);
					// System.out.println(tabArray[ci][cj]);
				}
				tabArray[ci][cj] = iTestCaseRow.get(k).toString();
				// System.out.println(tabArray[ci][cj]);
				cj = 0;
				ci++;
			}
		}

		catch (FileNotFoundException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();

		}

		catch (IOException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}

		return (tabArray);

	}

	// *** Steps 1 ***
	public static String getTestCaseName(String sTestCase) throws Exception {

		String value = sTestCase;

		try {

			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);

			return value;

		} catch (Exception e) {

			throw (e);

		}

	}

	// *** Steps 2 ***
	public static ArrayList<Integer> getRowContains(String sTestCaseName, int colNum) throws Exception {

		int i;
		try {

			int rowCount = ExcelUtils.getRowUsed();
			ArrayList<Integer> myList = new ArrayList<Integer>();

			// int[] cos2 = null;
			for (i = 0; i <= rowCount; i++) {

				if (ExcelUtils.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {

					myList.add(i);
				}
			}
			// System.out.println(myList.size());

			return myList;

		} catch (Exception e) {
			throw (e);
		}

	}

	/**
	* Support Step 2 & 3 ***
	*/
	// This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {
			DataFormatter formatter = new DataFormatter(); 
			return formatter.formatCellValue(ExcelWSheet.getRow(RowNum).getCell(ColNum));
			
		} catch (Exception e) {
			return "";
		}
	}

	/**
	* Support Step 2 ***
	*/
	public static int getRowUsed() throws Exception {

		try {
			int RowCount = ExcelWSheet.getLastRowNum();
			return RowCount;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			throw (e);

		}

	}

}