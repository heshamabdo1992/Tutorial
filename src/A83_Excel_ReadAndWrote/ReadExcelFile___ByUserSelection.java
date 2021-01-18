package A83_Excel_ReadAndWrote;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile___ByUserSelection {

	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {

		// Create an object of File class to open xlsx file
		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		Workbook guru99Workbook = null;

		// Find the file extension by splitting file name in substring and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class
			guru99Workbook = new XSSFWorkbook(inputStream);
		}

		// Check condition if the file is xls file
		else if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of XSSFWorkbook class
			guru99Workbook = new HSSFWorkbook(inputStream);

		}

		// Read sheet inside the workbook by its name
		Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

		// Find number of rows in excel file
		int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount + 1; i++) {

			Row row = guru99Sheet.getRow(i);

			// Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {


				//Create DataFormatter to get excel data regardless its data type 
				DataFormatter formatter = new DataFormatter(); 
				
				// Returns the formatted value of a cell as a String regardless of the cell type.
				String cell_info = formatter.formatCellValue(row.getCell(j));
				// Print Excel data in console
				System.out.print(cell_info + "|| ");
			}

			System.out.println();

		}

	}

	// Main function is calling readExcel function to read data from excel file
	public static void main(String... strings) throws IOException {

		// Display "open window" to select file Path
		// ==============================================
		JFileChooser fc = new JFileChooser();

		// Define Default path
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		// fc.setCurrentDirectory(new java.io.File("."));

		// Show directory without files, but can choose another property to show a files
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		// define "open window" title.
		fc.setDialogTitle("choosertitle");
		// can define
		// fc.setAcceptAllFileFilterUsed(false);

		int returnVal = fc.showOpenDialog(fc);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String filePath = fc.getCurrentDirectory().getAbsolutePath();
			String filename = fc.getSelectedFile().getName();

			// Create an object of ReadGuru99ExcelFile class
			ReadExcelFile___ByUserSelection objExcelFile = new ReadExcelFile___ByUserSelection();

			objExcelFile.readExcel(filePath, filename, "ExcelGuru99Demo");
		} else
			System.out.println("There is no selected files");

	}

}
